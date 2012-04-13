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
import util.session.Message;

public class UnflagRecord extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		HttpSession session = request.getSession();
		int idRecordFlag = Integer.parseInt(request.getParameter("id"));

		// R�cup�ration de tout les Records dans la base de donn�e
		Session sessionHibernate = HibernateUtil.currentSession();
		Transaction tx = sessionHibernate.beginTransaction();
		
		Record record = (Record) sessionHibernate.get(Record.class,
				idRecordFlag);
		User user = (User) sessionHibernate.get(User.class,
				(Serializable) session.getAttribute("idUser"));

		user.getRecords().remove(record);
//TODO simplifier
		// On sauve, on renvoi, notre bean � la session Hibernate
		sessionHibernate.saveOrUpdate(user);

		tx.commit();
		// Enfin on ferme la session
		HibernateUtil.closeSession();
		
		String redirect = request.getHeader("Referer");
		if(redirect==null || redirect.isEmpty()) redirect = "personal_library";
		
		Message.addMessage(request, "Record unflaged");
		
		response.sendRedirect(redirect);

	}

}
