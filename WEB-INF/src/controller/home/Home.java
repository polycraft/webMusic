package controller.home;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class Home extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{

			RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/src/view/home/home.jsp");
			dispatch.forward(request, response);
		
	}	
}

