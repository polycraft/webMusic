package controller.disconnect;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Disconnect extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
			HttpSession session = request.getSession();
			
			session.setAttribute("idUser", null);
			session.setAttribute("username", null);
			
			response.sendRedirect("index");
	}	
}
