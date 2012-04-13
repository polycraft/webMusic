package controller.library;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Copy;
import model.Record;
import model.User;

import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

public class FlagRecord extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		
		int idRecordFlag = Integer.parseInt(request.getParameter("id"));
		
		//R�cup�ration de tout les Records dans la base de donn�e
		Session sessionHibernate = HibernateUtil.currentSession();
		

		
    	User user = (User) sessionHibernate.get(User.class, (Serializable) session.getAttribute("idUser"));
    	
    	boolean alreadyExist = false;
    	for(Record record : user.getRecords()){
    		if(record.getIdRecord() == idRecordFlag){
    			alreadyExist = true;
    			break;
    		}
    	}
    	
    	//Verif si d�ja pr�sent dans les Copy owned
    	//ENLEVE    	
    	/*boolean alreadyOwned = false;
    	
    	if(sessionHibernate.createQuery("from Copy where id_record= :id_record and id_owner= :id_owner")
    		.setParameter("id_record", idRecordFlag)
    		.setParameter("id_owner", user.getIdUser()).list().size() >=1){
    		alreadyOwned = true;
    	}*/
    	
    	
    	if(alreadyExist){
    		//already flaged
    		//Enfin on ferme la session 
    		HibernateUtil.closeSession();
    	}
    	else{

    		Transaction tx = sessionHibernate.beginTransaction();
    		
    		Record record = (Record) sessionHibernate.get(Record.class, idRecordFlag);
    		
    		Set<Record> records = user.getRecords();
    		records.add(record);
    		
    		// On sauve, on renvoi, notre bean � la session Hibernate   
    	     sessionHibernate.saveOrUpdate(user);

    	     tx.commit();
    	   //Enfin on ferme la session 
    	      HibernateUtil.closeSession();
    	}
    	String redirect = request.getHeader("Referer");
		if(redirect==null || redirect.isEmpty()) redirect = "personal_library";
		
		response.sendRedirect(redirect);
    	
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
	}

}
