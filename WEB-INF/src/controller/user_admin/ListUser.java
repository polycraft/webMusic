package controller.user_admin;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Record;
import model.User;

import org.hibernate.Session;

import util.HibernateUtil;

public class ListUser extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		//R�cup�ration de tout les Records dans la base de donn�e
		Session sessionHibernate = HibernateUtil.currentSession();
		List<User> listUsers = (List<User>) sessionHibernate.createQuery("from User ORDER BY username DESC").list();
		
		request.setAttribute("listeUsers", listUsers);
		RequestDispatcher dispatch = request
				.getRequestDispatcher("WEB-INF/src/view/user_admin/listUser.jsp");
		dispatch.forward(request, response);
	}
}
