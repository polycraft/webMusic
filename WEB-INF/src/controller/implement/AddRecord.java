package controller.implement;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import util.HttpServlet.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import util.form.implement.AddRecordForm;
import util.form.user.LoginForm;
import util.form.user.RegisterForm;
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

public class AddRecord extends HttpServlet {
	
	private AddRecordForm form;
	
	protected void before(HttpServletRequest request, HttpServletResponse response) {
		this.form = new AddRecordForm();
		form.setRequest(request);
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// Creation de notre objet Session grace � notre HibernateUtil
				Session session = HibernateUtil.currentSession();

				request.setAttribute("category", session.createQuery("from Category").list());

				HibernateUtil.closeSession();

				request.setAttribute("form", form);
				RequestDispatcher dispatch = request
						.getRequestDispatcher("WEB-INF/src/view/implement/add_record.jsp");
				dispatch.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (form.validate()) {
			Session session = HibernateUtil.currentSession();
			Transaction tx = session.beginTransaction();
			
			//Création de l'utilisateur
			Record record = new Record();
			record.setIdRecord(null);
			form.fillRecord(record,session);

			session.save(record);

			tx.commit();

			HibernateUtil.closeSession();

			response.sendRedirect("library");
			
		} else {
			doGet(request, response);
		}
	}

}
