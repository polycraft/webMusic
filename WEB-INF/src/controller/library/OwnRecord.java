package controller.library;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import util.form.user.LoginForm;
import util.session.Message;
import util.validator.BlankValidator;
import util.validator.ChainValidator;
import util.validator.FormValidator;
import util.validator.LengthMaxValidator;
import util.validator.error.Error;

import model.Copy;
import model.CopyCondition;
import model.Record;
import model.TypeCopy;
import model.User;

public class OwnRecord extends HttpServlet {
	
	private LoginForm form;
	
	protected void before(HttpServletRequest request, HttpServletResponse response) {
		this.form = new LoginForm();
		form.setRequest(request);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		//R�cup�ration des Type de copy
		Session sessionHibernate = HibernateUtil.currentSession();
		List<TypeCopy> typeCopies = (List<TypeCopy>) sessionHibernate.createQuery("from TypeCopy").list();
		List<CopyCondition> copyConditions = (List<CopyCondition>) sessionHibernate.createQuery("from CopyCondition").list();
		
		//id du record � obtenir
		int idRecord = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("idRecord", idRecord);
		request.setAttribute("copyConditions", copyConditions);
		request.setAttribute("form", form);
		request.setAttribute("typeCopies", typeCopies);
		RequestDispatcher dispatch = request
				.getRequestDispatcher("WEB-INF/src/view/library/own_record.jsp");
		dispatch.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		FormValidator Validator = new FormValidator();
		ChainValidator<String> fieldCondition = new ChainValidator<String>()
				.add(new BlankValidator()).add(new LengthMaxValidator(10));
		
		fieldCondition.set((String) request.getParameter("condition"));
		
		int idRecord = Integer.parseInt(request.getParameter("id"));
		
		if(Validator.valid()){		
			//R�cup�ration des Type de copy
			Session sessionHibernate = HibernateUtil.currentSession();
			Transaction tx = sessionHibernate.beginTransaction();
			//on promu le record dans une copy
			Copy copy = new Copy();
			
			copy.setIdCopy(null);
			
			int idCopyCondition = Integer.parseInt(request.getParameter("record_condition"));
			CopyCondition condition = (CopyCondition) sessionHibernate.get(CopyCondition.class, idCopyCondition);
			copy.setCopyCondition(condition);
			
			Record record = (Record)sessionHibernate.get(Record.class, idRecord);
			copy.setRecord(record);
			
			User user = (User) sessionHibernate.get(User.class,(Serializable) session.getAttribute("idUser"));
			
			copy.setUser(user);
			
			
			int idTypeCopy = Integer.parseInt(request.getParameter("typecopy"));
			TypeCopy typeCopy = (TypeCopy)sessionHibernate.get(TypeCopy.class, idTypeCopy);
			
			copy.setTypeCopy(typeCopy);
			
			System.out.println(copy.getTypeCopy().getName());
			
			if(!alreadyOwned(copy, user)){
				// On sauve si la copy n'existe pas d�ja
				sessionHibernate.saveOrUpdate(copy);
				
				//puis on supprime le flag
				user.getRecords().remove(record);
				
				tx.commit();
			}
			else{
				//afficher message
			}

			// Enfin on ferme la session
			HibernateUtil.closeSession();
			
			String redirect = request.getHeader("Referer");
			if(redirect==null || redirect.isEmpty()) redirect = "personal_library";
			
			Message.addMessage(request, "Record owned");
			
			response.sendRedirect(redirect);
			
		}else {
			form.addError(new Error("Pas de condition"));
			doGet(request, response);
		}
	}
	
	private boolean alreadyOwned(Copy copy, User user){
		Set<Copy> copies = user.getCopies();
		for(Copy temp : copies){
			if(temp.getRecord().equals(copy.getRecord()) && temp.getTypeCopy().equals(copy.getTypeCopy())) return true;
		}
		return false;
	}

}
