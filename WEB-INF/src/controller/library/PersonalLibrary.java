package controller.library;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

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

public class PersonalLibrary extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		
		//Récupération de tout les Records owned
		Session sessionHibernate = HibernateUtil.currentSession();
		List<Copy> ownedCopies = (List<Copy>) sessionHibernate.createQuery("from Copy where id_owner= :owner")
				.setParameter("owner", session.getAttribute("idUser")).list();

		
		request.setAttribute("ownedCopies", ownedCopies);
		request.setAttribute("user",sessionHibernate.get(User.class, (Serializable) session.getAttribute("idUser")));
		RequestDispatcher dispatch = request
				.getRequestDispatcher("WEB-INF/src/view/library/personal_library.jsp");
		dispatch.forward(request, response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
	}

}
