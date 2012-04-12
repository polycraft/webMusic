package controller.library;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

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
import util.validator.BlankValidator;
import util.validator.ChainValidator;
import util.validator.FormValidator;
import util.validator.LengthMaxValidator;
import util.validator.error.Error;

import model.Copy;
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
		//Récupération des Type de copy
		Session sessionHibernate = HibernateUtil.currentSession();
		List<TypeCopy> typeCopies = (List<TypeCopy>) sessionHibernate.createQuery("from TypeCopy").list();
		
		//id du record à obtenir
		int idRecord = Integer.parseInt(request.getParameter("id"));
		
		request.setAttribute("idRecord", idRecord);
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
		
		fieldCondition.set((String) request.getAttribute("condition"));
		
		int idRecord = Integer.parseInt(request.getParameter("id"));
		
		if(Validator.valid()){
			//Récupération des Type de copy
			Session sessionHibernate = HibernateUtil.currentSession();
			Transaction tx = sessionHibernate.beginTransaction();
			//on promu le record dans une copy
			Copy copy = new Copy();
			copy.setCondition((String) request.getAttribute("condition"));
			
			Record record = (Record)sessionHibernate.get(Record.class, idRecord);
			copy.setRecord(record);
			
			User user = (User) sessionHibernate.get(User.class,
					(Serializable) session.getAttribute("idUser"));
			
			copy.setUser(user);
			
			
			System.out.println(request.getAttribute("condition"));
			TypeCopy typeCopy = (TypeCopy)sessionHibernate.get(TypeCopy.class, Integer.parseInt((String) request.getAttribute("typecopy")));
			
			copy.setTypeCopy(typeCopy);
			
			// On sauve, on renvoi, notre bean ï¿½ la session Hibernate
			sessionHibernate.saveOrUpdate(copy);
			
			//puis on supprime le flag
			user.getRecords().remove(record);
			
			tx.commit();
			// Enfin on ferme la session
			HibernateUtil.closeSession();
			
		}else {
			form.addError(new Error("Pas de condition"));
			doGet(request, response);
		}
	}

}
