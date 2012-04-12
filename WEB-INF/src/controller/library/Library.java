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

import model.Copy;
import model.Record;
import model.User;

import org.hibernate.Session;

import util.HibernateUtil;

public class Library extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		//Récupération de tout les Records dans la base de donnée
		Session sessionHibernate = HibernateUtil.currentSession();
		List<Record> listRecords = (List<Record>) sessionHibernate.createQuery("from Record ORDER BY title ASC").list();
		
		//recup de l'utilisateur
		User user = (User) sessionHibernate.get(User.class, (Serializable) session.getAttribute("idUser"));
		
		request.setAttribute("user", user);
		request.setAttribute("listeRecords", listRecords);
		RequestDispatcher dispatch = request
				.getRequestDispatcher("WEB-INF/src/view/library/library.jsp");
		dispatch.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
	}
	


}
