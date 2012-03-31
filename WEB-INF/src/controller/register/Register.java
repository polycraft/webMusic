package controller.register;

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
import util.validator.FormValidator;
import util.validator.LengthMaxValidator;
import model.Language;
import model.User;
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Hashtable;

public class Register extends HttpServlet {

	private Session session;
	private Transaction tx;
	private boolean error = false;
	private String errorType;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// Creation de notre objet Session grace à notre HibernateUtil
		session = HibernateUtil.currentSession();

		List<Language> languages = session.createQuery("from Language").list();

		HibernateUtil.closeSession();

		request.setAttribute("languages", languages);
		request.setAttribute("error", this.error);
		request.setAttribute("errorType", this.errorType);
		RequestDispatcher dispatch = request
				.getRequestDispatcher("WEB-INF/src/view/register.jsp");
		dispatch.forward(request, response);
	}

	public void doPost(	HttpServletRequest request, 
			HttpServletResponse response)
			throws IOException, ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		//on vérifie que les champs username / password / emailAdress sont non vides
		//FormValidator registerValidator=new FormValidator();		
		ChainValidator<String> fieldUsername=new ChainValidator<String>().add(new BlankValidator());
		//ChainValidator<String> fieldPassword1=new ChainValidator<String>().add(new BlankValidator()).add(new LengthMaxValidator(20));
		//ChainValidator<String> fieldPassword2=new ChainValidator<String>().add(new BlankValidator()).add(new LengthMaxValidator(20));
		//ChainValidator<String> fieldEmail=new ChainValidator<String>().add(new BlankValidator()).add(new LengthMaxValidator(20));
		
		//registerValidator.add(fieldUsername);//.add(fieldPassword1).add(fieldPassword2).add(fieldEmail);
		
		
		fieldUsername.set(request.getParameter("username"));
		//fieldPassword1.set(request.getParameter("password1"));
		//fieldPassword2.set(request.getParameter("password2"));
		//fieldEmail.set(request.getParameter("emailAdress"));
		
			try {
				if(fieldUsername.validate())
				{
					if(request.getParameter("password1").equals(request.getParameter("password2")))
					{
						
						
						//Creation de notre objet Session grace à notre HibernateUtil  
						session = HibernateUtil.currentSession();

						//Ouverture de notre transaction avec Hibernate grace
						// a la session 
					     tx = session.beginTransaction();
						// Ajout d'un utilisateur en utilisant notre bean User 
						// préalablement configuré dans Hibernate 
					      User user = new User();
					      user.setIdUser(null);
					      user.setUsername(request.getParameter("username"));
					      user.setPassword(request.getParameter("password1"));
					      user.setEmailAdress(request.getParameter("emailAdress"));
					      
					    //recupération de la classe Language
					      Language language = (Language) session.get(Language.class, Integer.parseInt(request.getParameter("language")));
					     user.setLanguage(language);
					     
					     
					     //Optionnel
					     user.setFirstname(request.getParameter("firstname"));
					     user.setLastname(request.getParameter("lastname"));
					     user.setBiography(request.getParameter("biography"));
					     user.setPicture(request.getParameter("picture"));
					     user.setWebsite(request.getParameter("website"));
					     user.setSocialNetworkAccount(request.getParameter("socialNetworkAccount"));
					     
					      
					      
						// On sauve, on renvoi, notre bean à la session Hibernate   
					      session.save(user);
					      
						// Nous commitons la transaction vers la base
					      tx.commit();

						//Enfin on ferme la session 
					      HibernateUtil.closeSession();
		                //Nous invoquons la méthode doGet avec les paramètres reçu par la méthode doPost
				
						error = false;
						
						out.println("registered !");
						//Enregistrement du nouvel User
					}
					else {
						error = true;
						errorType = "Passwords non identique";
						doGet(request, response);
					}
				}
				else
				{
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
