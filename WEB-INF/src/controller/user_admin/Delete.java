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
public class Delete extends HttpServlet {

	private Session sessionHibernate;
	private Transaction tx;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		sessionHibernate = HibernateUtil.currentSession();
		
		
		try {
			tx = sessionHibernate.beginTransaction();
			
			User user = (User)sessionHibernate.load(User.class, new Integer(request.getParameter("id")));
			
			sessionHibernate.delete(user);

			tx.commit();

			
			
			Message.addMessage(request, "User supprimé avec succes");
		} catch (ObjectNotFoundException e) {
			Message.addError(request, "L'utilisateur n'existe pas");
			tx.rollback();
		} catch (Exception e) {
			Message.addError(request, "Une erreur est survenue pendant la suppresion");
			tx.rollback();
		}
		
		
		
		HibernateUtil.closeSession();

		response.sendRedirect("user-admin-list");
	}
}
