package controller.implement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Record;
import model.User;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import util.HttpServlet.HttpServlet;
import util.form.implement.RecordForm;
import util.session.Message;

public class UpdateRecord extends HttpServlet {
	
	private RecordForm form;
	
	protected void before(HttpServletRequest request, HttpServletResponse response) {
		this.form = new RecordForm();
		form.setRequest(request);
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			// Creation de notre objet Session grace � notre HibernateUtil
			Session session = HibernateUtil.currentSession();
			
			Record record = (Record)session.load(Record.class, new Integer(request.getParameter("id")));

			request.setAttribute("category", session.createQuery("from Category").list());
			
			form.fillForm(record);

			HibernateUtil.closeSession();

			request.setAttribute("form", form);
			RequestDispatcher dispatch = request
					.getRequestDispatcher("WEB-INF/src/view/implement/update_record.jsp");
			dispatch.forward(request, response);
		} catch (Exception  e) {
			Message.addError(request, "Le record n'existe pas");
			
			String redirect = request.getHeader("Referer");
			if(redirect==null || redirect.isEmpty()) redirect = "search";
			
			response.sendRedirect(redirect);
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			if (form.validate()) {
				Session session = HibernateUtil.currentSession();
				Transaction tx = session.beginTransaction();
				
				//Création de l'utilisateur
				Record record = (Record)session.load(Record.class, new Integer(request.getParameter("id")));
				form.fillRecord(record,session);
	
				session.update(record);
	
				tx.commit();
	
				HibernateUtil.closeSession();
	
				response.sendRedirect("search?id_record="+record.getIdRecord());
				
			} else {
				doGet(request, response);
			}
		} catch (Exception e) {
			Message.addError(request, "Le record n'existe pas");
			
			String redirect = request.getHeader("Referer");
			if(redirect==null || redirect.isEmpty()) redirect = "search";
			
			response.sendRedirect(redirect);
		}
	}

}
