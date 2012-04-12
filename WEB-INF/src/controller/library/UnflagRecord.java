package controller.library;

import java.io.IOException;
import java.io.Serializable;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Record;
import model.User;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class UnflagRecord extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession();
		int idRecordFlag = Integer.parseInt(request.getParameter("id"));

		// Récupération de tout les Records dans la base de donnée
		Session sessionHibernate = HibernateUtil.currentSession();
		Transaction tx = sessionHibernate.beginTransaction();
		
		Record record = (Record) sessionHibernate.get(Record.class,
				idRecordFlag);
		User user = (User) sessionHibernate.get(User.class,
				(Serializable) session.getAttribute("idUser"));

		user.getRecords().remove(record);

		// On sauve, on renvoi, notre bean ï¿½ la session Hibernate
		sessionHibernate.saveOrUpdate(user);

		tx.commit();
		// Enfin on ferme la session
		HibernateUtil.closeSession();
		
		response.sendRedirect("personal_library");

	}

}
