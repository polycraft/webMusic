package controller.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Language;
import model.User;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;
import util.validator.BlankValidator;
import util.validator.ChainValidator;
import util.validator.FormValidator;
import util.validator.LengthMaxValidator;

@SuppressWarnings("serial")
public class Register extends HttpServlet {

	private Session session;
	private Transaction tx;
	private boolean error = false;
	private String errorType;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// Creation de notre objet Session grace � notre HibernateUtil
		session = HibernateUtil.currentSession();

		@SuppressWarnings("unchecked")
		List<Language> languages = session.createQuery("from Language").list();

		HibernateUtil.closeSession();

		request.setAttribute("languages", languages);
		request.setAttribute("error", this.error);
		request.setAttribute("errorType", this.errorType);
		RequestDispatcher dispatch = request.getRequestDispatcher("WEB-INF/src/view/register/register.jsp");
		dispatch.forward(request, response);
	}

	public void doPost(	HttpServletRequest request, 
			HttpServletResponse response)
			throws IOException, ServletException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		//Recup�ration des variables//
		String username = request.getParameter("username");
		String password1 = request.getParameter("password1");
		String password2 = request.getParameter("password2");
		String emailAdress = request.getParameter("emailAdress");
		
		//Creation du validator//
		FormValidator registerValidator = getValidator(username,password1,password2,emailAdress);
		
			try {
				if(registerValidator.validate())
				{
					if(request.getParameter("password1").equals(request.getParameter("password2")))
					{
						
						
						//Creation de notre objet Session grace � notre HibernateUtil  
						session = HibernateUtil.currentSession();

						//Ouverture de notre transaction avec Hibernate grace
						// a la session 
					     tx = session.beginTransaction();
						// Ajout d'un utilisateur en utilisant notre bean User 
						// pr�alablement configur� dans Hibernate 
					      User user = new User();
					      user.setIdUser(null);
					      user.setUsername(request.getParameter("username"));
					      user.setPassword(request.getParameter("password1"));
					      user.setEmailAdress(request.getParameter("emailAdress"));
					      
					    //recup�ration de la classe Language
					      Language language = (Language) session.get(Language.class, Integer.parseInt(request.getParameter("language")));
					     user.setLanguage(language);
					     
					     
					     //Optionnel
					     user.setFirstname(request.getParameter("firstname"));
					     user.setLastname(request.getParameter("lastname"));
					     user.setBiography(request.getParameter("biography"));
					     user.setPicture(request.getParameter("picture"));
					     user.setWebsite(request.getParameter("website"));
					     user.setSocialNetworkAccount(request.getParameter("socialNetworkAccount"));
					     
					      
					      
						// On sauve, on renvoi, notre bean � la session Hibernate   
					      session.save(user);
					      
						// Nous commitons la transaction vers la base
					      tx.commit();

						//Enfin on ferme la session 
					      HibernateUtil.closeSession();
		                //Nous invoquons la m�thode doGet avec les param�tres re�u par la m�thode doPost
				
						error = false;
						
						out.println("<p>registered !</p>  <a src='/'>Home</a>");
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
	
	
	private FormValidator getValidator(String username,String password1,String password2, String emailAdress){
		
		//on v�rifie que les champs username / password / emailAdress sont non vides et la taille < max
		FormValidator Validator=new FormValidator();		
		ChainValidator<String> fieldUsername=new ChainValidator<String>().add(new BlankValidator()).add(new LengthMaxValidator(10));
		ChainValidator<String> fieldPassword1=new ChainValidator<String>().add(new BlankValidator()).add(new LengthMaxValidator(20));
		ChainValidator<String> fieldPassword2=new ChainValidator<String>().add(new BlankValidator()).add(new LengthMaxValidator(20));
		ChainValidator<String> fieldEmail=new ChainValidator<String>().add(new BlankValidator()).add(new LengthMaxValidator(20));
		
		Validator.add(fieldUsername).add(fieldPassword1).add(fieldPassword2).add(fieldEmail);
		
		fieldUsername.set(username);
		fieldPassword1.set(password1);
		fieldPassword2.set(password2);
		fieldEmail.set(emailAdress);
		
		return Validator;

	}
}
