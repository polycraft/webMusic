package controller.library;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Person;
import model.Record;
import model.Track;
import model.User;

import org.hibernate.Session;

import util.HibernateUtil;
import util.HttpServlet.HttpServlet;

public class TrackDetails extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();	
		Integer idTrack = new Integer(request.getParameter("id").toString());
		
		Session sessionHibernate = HibernateUtil.currentSession();
		 User user = (User)sessionHibernate.get(User.class, new Integer(session.getAttribute("idUser").toString()));
		
		//Récupération des personnes ayant travaillées sur la track
		@SuppressWarnings("unchecked")
		List<Person> persons =  sessionHibernate.createQuery("from Person person where person.track= :track")
		 .setParameter("track", (Track)sessionHibernate.get(Track.class, idTrack)).list();
		 
		request.setAttribute("track", (Track)sessionHibernate.get(Track.class, idTrack));
		request.setAttribute("user",user);
		request.setAttribute("persons",persons);
		RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/src/view/library/track_details.jsp");
		dispatch.forward(request, response);		
	}

}
