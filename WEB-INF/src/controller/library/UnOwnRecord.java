package controller.library;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import util.form.user.LoginForm;
import util.session.Message;
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

public class UnOwnRecord extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		Integer idCopy = new Integer(request.getParameter("id"));

		// R�cup�ration de tout les Records dans la base de donn�e
		Session sessionHibernate = HibernateUtil.currentSession();
		Transaction tx = sessionHibernate.beginTransaction();
		
		Copy copy = (Copy) sessionHibernate.get(Copy.class,
				idCopy);

		sessionHibernate.delete(copy);
		
		tx.commit();
		// Enfin on ferme la session
		HibernateUtil.closeSession();
		
		String redirect = request.getHeader("Referer");
		if(redirect==null || redirect.isEmpty()) redirect = "personal_library";
		
		Message.addMessage(request, "Record unown");
		
		response.sendRedirect(redirect);
	}

}
