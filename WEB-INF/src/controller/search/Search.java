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

import model.Record;
import model.Track;
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
			
			User user = null;
			if(session.getAttribute("idUser")!=null)
				user = (User)sessionHibernate.load(User.class, (Integer) session.getAttribute("idUser"));
			
			request.setAttribute("result", query.createQuery(sessionHibernate, user));
			request.setAttribute("form", form);
			request.setAttribute("search", search);
			request.setAttribute("user", user);
			
			if(search.getView().equals("record") && search.getId_record()!=null) {
				request.setAttribute("record",sessionHibernate.get(Record.class, search.getId_record()));
			}
			else if(search.getView().equals("track") && search.getId_track()!=null) {
				request.setAttribute("persons",sessionHibernate.createQuery("from Person person where person.track= :track").setParameter("track", (Track)sessionHibernate.get(Track.class, search.getId_track())).list());
			}
			
			RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/src/view/search/search.jsp");
			dispatch.forward(request, response);
		
	}	
}

