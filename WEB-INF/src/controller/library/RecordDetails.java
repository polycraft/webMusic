package controller.library;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Record;
import model.User;

import org.hibernate.Session;

import util.HibernateUtil;
import util.HttpServlet.HttpServlet;

public class RecordDetails extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();	
		Integer idRecord = new Integer(request.getParameter("id").toString());
		
		Session sessionHibernate = HibernateUtil.currentSession();
		 User user = (User)sessionHibernate.get(User.class, new Integer(session.getAttribute("idUser").toString()));
		
		
		request.setAttribute("record", (Record)sessionHibernate.get(Record.class, idRecord));
		request.setAttribute("user",user);
		RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/src/view/library/record_details.jsp");
		dispatch.forward(request, response);		
	}

}
