package controller.search;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import util.HibernateUtil;
import util.HttpServlet.HttpServlet;
import util.form.search.SearchForm;
import util.form.search.SearchQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import model.User;


@SuppressWarnings("serial")
public class Search extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
			SearchForm form=new SearchForm();
			util.form.search.Search search=new util.form.search.Search();
			form.setRequest(request);
			
			form.fillSearch(search);
			
			SearchQuery query=new SearchQuery(search);
			
			
			Session sessionHibernate = HibernateUtil.currentSession();
			
			HttpSession session = request.getSession();
			User user = (User)sessionHibernate.load(User.class, new Integer(session.getAttribute("idUser").toString()));
			
			request.setAttribute("records", query.createQuery(sessionHibernate, user));
			request.setAttribute("form", form);
			
			RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/src/view/search/search.jsp");
			dispatch.forward(request, response);
		
	}	
}

