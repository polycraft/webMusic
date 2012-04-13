package controller.implement;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Record;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import util.HttpServlet.HttpServlet;
import util.form.implement.RecordForm;

public class AddRecord extends HttpServlet {
	
	private RecordForm form;
	
	protected void before(HttpServletRequest request, HttpServletResponse response) {
		this.form = new RecordForm();
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

			response.sendRedirect("search?view=record&id_record="+record.getIdRecord());
			
		} else {
			doGet(request, response);
		}
	}

}
