package controller.user_admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import util.HttpServlet.HttpServlet;
import util.form.user.UpdateForm;
import util.session.Message;

@SuppressWarnings("serial")
public class Update extends HttpServlet {

	private Session sessionHibernate;
	private Transaction tx;

	private UpdateForm form;

	protected void before(HttpServletRequest request, HttpServletResponse response) {
		this.form = new UpdateForm();
		form.setRequest(request);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		try {		
			// Creation de notre objet Session grace � notre HibernateUtil
			sessionHibernate = HibernateUtil.currentSession();
			User user = (User)sessionHibernate.load(User.class, new Integer(request.getParameter("id")));
			
			form.fillForm(user);
	
			request.setAttribute("languages", sessionHibernate.createQuery("from Language").list());
	
			HibernateUtil.closeSession();
	
			request.setAttribute("form", form);
			RequestDispatcher dispatch = request
					.getRequestDispatcher("WEB-INF/src/view/user_admin/update.jsp");
			dispatch.forward(request, response);
		} catch (ObjectNotFoundException e) {
			Message.addError(request, "L'utilisateur n'existe pas");
			response.sendRedirect("user-admin-list");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		if (form.validate()) {
			sessionHibernate = HibernateUtil.currentSession();
			try {				
				tx = sessionHibernate.beginTransaction();
				
				//Création de l'utilisateur
				User user = (User)sessionHibernate.load(User.class, new Integer(request.getParameter("id")));
				
				form.fillUser(user,sessionHibernate);
	
				sessionHibernate.update(user);
	
				tx.commit();
			} catch (ObjectNotFoundException e) {
				Message.addError(request, "L'utilisateur n'existe pas");
				tx.rollback();
			} catch (Exception e) {
				Message.addError(request, "Une erreur est survenue pendant la suppresion");
				tx.rollback();
			}

			HibernateUtil.closeSession();

			response.sendRedirect("user-admin-list");
		} else {
			doGet(request, response);
		}

	}
}
