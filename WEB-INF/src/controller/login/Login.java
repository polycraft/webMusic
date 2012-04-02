package controller.login;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.HibernateUtil;
import util.validator.BlankValidator;
import util.validator.ChainValidator;
import util.validator.LengthMaxValidator;
import model.Language;
import model.User;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class Login extends HttpServlet {

	private boolean error = false;
	private String errorType;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		
		request.setAttribute("error", this.error);
		request.setAttribute("errorType", this.errorType);
		RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/src/view/login/login.jsp");
		dispatch.forward(request, response);		
		
	}
	
	public void doPost(	HttpServletRequest request, 
			HttpServletResponse response)
			throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		//FormValidator registerValidator=new FormValidator();		
		ChainValidator<String> fieldUsername=new ChainValidator<String>().add(new BlankValidator()).add(new LengthMaxValidator(10));
		ChainValidator<String> fieldPassword=new ChainValidator<String>().add(new BlankValidator()).add(new LengthMaxValidator(20));
		//registerValidator.add(fieldUsername);//.add(fieldPassword1)
		
		String username = request.getParameter("username");
		String password  = request.getParameter("password");
		fieldUsername.set(username);
		fieldPassword.set(password);
		
		try {
			if(fieldUsername.validate() && fieldPassword.validate()){

				//on recherche dans la BD:
				// Creation de notre objet Session grace à notre HibernateUtil
				Session sessionHibernate = HibernateUtil.currentSession();
				List<User> user =  (List<User>) sessionHibernate.createQuery("from User user where user.username = :username and user.password = :password").setParameter("username", username).setParameter("password",password).list();
				HibernateUtil.closeSession();

				
				if(user.size() == 1){
					out.println("loged");
					
					HttpSession session = request.getSession();
					session.setAttribute("idUser", user.get(0).getIdUser());
					session.setAttribute("username", user.get(0).getUsername());
					
					error = false;
				}
				else{
					error = true;
					errorType = "username / password faux";
					doGet(request, response);
				}		
			}
			else{
				error = true;
				errorType = "Champ vide";
				doGet(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

