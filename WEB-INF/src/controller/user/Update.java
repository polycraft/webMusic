package controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

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

		// Creation de notre objet Session grace � notre HibernateUtil
		sessionHibernate = HibernateUtil.currentSession();
		
		HttpSession session = request.getSession();
		User user = (User)sessionHibernate.load(User.class, new Integer(session.getAttribute("idUser").toString()));
		
		form.fillForm(user);

		request.setAttribute("languages", sessionHibernate.createQuery("from Language").list());

		HibernateUtil.closeSession();

		request.setAttribute("form", form);
		RequestDispatcher dispatch = request
				.getRequestDispatcher("WEB-INF/src/view/user/update.jsp");
		dispatch.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		if (form.validate()) {System.out.println("good");
			sessionHibernate = HibernateUtil.currentSession();
			tx = sessionHibernate.beginTransaction();
			
			//Création de l'utilisateur
			HttpSession session = request.getSession();
			User user = (User)sessionHibernate.load(User.class, new Integer(session.getAttribute("idUser").toString()));
			
			form.fillUser(user,sessionHibernate);

			sessionHibernate.save(user);

			tx.commit();

			HibernateUtil.closeSession();

			Message.addMessage(request, "Profil mis à jours");
			response.sendRedirect("user-update");
		} else {
			doGet(request, response);
		}

	}
}
