package controller.register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import util.form.user.RegisterForm;

@SuppressWarnings("serial")
public class Register extends HttpServlet {

	private Session session;
	private Transaction tx;

	private RegisterForm form;
	private boolean post=false;

	public Register() {
		super();
		this.form = new RegisterForm();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		if(!post) {
			form.setRequest(request);
			post=false;
		}

		// Creation de notre objet Session grace � notre HibernateUtil
		session = HibernateUtil.currentSession();

		request.setAttribute("languages", session.createQuery("from Language").list());

		HibernateUtil.closeSession();

		request.setAttribute("form", form);
		RequestDispatcher dispatch = request
				.getRequestDispatcher("WEB-INF/src/view/register/register.jsp");
		dispatch.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		post=true;
		form.setRequest(request);
		
		if (form.validate()) {System.out.println("good");
			session = HibernateUtil.currentSession();
			tx = session.beginTransaction();
			
			//Création de l'utilisateur
			User user = new User();
			user.setIdUser(null);
			form.fillUser(user,session);

			session.save(user);

			tx.commit();

			HibernateUtil.closeSession();

			RequestDispatcher dispatch = request
					.getRequestDispatcher("WEB-INF/src/view/register/register_valid.jsp");
			dispatch.forward(request, response);
		} else {System.out.println(form.get("firstname").hasError()+" "+form.get("language").hasError());
			doGet(request, response);
		}

	}
}
