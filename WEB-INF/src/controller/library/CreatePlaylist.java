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
import model.Playlist;
import model.Record;
import model.User;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import util.form.implement.PlaylistForm;
import util.form.implement.RecordForm;

public class CreatePlaylist extends HttpServlet {
	
	private PlaylistForm form;
	
	protected void before(HttpServletRequest request, HttpServletResponse response) {
		this.form = new PlaylistForm();
		form.setRequest(request);
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		request.setAttribute("form", form);
		RequestDispatcher dispatch = request
				.getRequestDispatcher("WEB-INF/src/view/library/create_playlist.jsp");
		dispatch.forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (form.validate()) {
			Session session = HibernateUtil.currentSession();
			Transaction tx = session.beginTransaction();
			
			//Création de l'utilisateur
			Playlist playlist = new Playlist();
			playlist.setIdPlaylist(null);
			playlist.setUser((User)session.get(User.class, new Integer(request.getSession().getAttribute("idUser").toString())));
			form.fillRecord(playlist,session);

			session.save(playlist);

			tx.commit();

			HibernateUtil.closeSession();

			response.sendRedirect("personal_library");
			
		} else {
			doGet(request, response);
		}
	}
	


}
