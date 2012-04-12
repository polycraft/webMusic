package controller.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

import org.hibernate.Session;

import util.HibernateUtil;
import util.HttpServlet.HttpServlet;
import util.form.user.LoginForm;
import util.validator.BlankValidator;
import util.validator.ChainValidator;
import util.validator.FormValidator;
import util.validator.LengthMaxValidator;
import util.validator.error.Error;

public class Login extends HttpServlet {

	private boolean error = false;
	private String errorType;
	private LoginForm form;
	private boolean post = false;

	public Login() {
		super();
		
	}
	
	protected void before(HttpServletRequest request, HttpServletResponse response) {
		this.form = new LoginForm();
		form.setRequest(request);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.setAttribute("form", form);
		RequestDispatcher dispatch = request
				.getRequestDispatcher("WEB-INF/src/view/user/login.jsp");
		dispatch.forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		if (form.validate()) {
			// on recherche dans la BD:
			// Creation de notre objet Session grace � notre HibernateUtil
			Session sessionHibernate = HibernateUtil.currentSession();
			List<User> user = (List<User>) sessionHibernate
					.createQuery(
							"from User user where user.username = :username and user.password = :password")
					.setParameter("username", form.getRequestvalue("username"))
					.setParameter("password", form.getRequestvalue("password")).list();
			HibernateUtil.closeSession();

			if (user.size() == 1) {
				HttpSession session = request.getSession();
				session.setAttribute("idUser", user.get(0).getIdUser());
				session.setAttribute("username", user.get(0).getUsername());

				response.sendRedirect("");

			} else {
				form.addError(new Error("Identifiant incorrect"));
				doGet(request, response);
			}
		} else {
			doGet(request, response);
		}
	}

	private FormValidator getValidator(String username, String password) {

		// on v�rifie que les champs username / password / emailAdress sont non
		// vides et la taille < max
		FormValidator Validator = new FormValidator();
		ChainValidator<String> fieldUsername = new ChainValidator<String>()
				.add(new BlankValidator()).add(new LengthMaxValidator(10));
		ChainValidator<String> fieldPassword = new ChainValidator<String>()
				.add(new BlankValidator()).add(new LengthMaxValidator(20));

		Validator.add(fieldUsername).add(fieldPassword);

		fieldUsername.set(username);
		fieldPassword.set(password);

		return Validator;

	}
}
