package util.session;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Message {
	public static List<String> getMessages(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<String> messages=(List<String>) session.getAttribute("[Messages]");
		if(messages==null)
			return new ArrayList<String>();
		session.removeAttribute("[Messages]");
		return messages;
	}
	
	public static List<String> getErrors(HttpServletRequest request) {
		HttpSession session = request.getSession();
		List<String> errors=(List<String>) session.getAttribute("[Errors]");
		if(errors==null)
			return new ArrayList<String>();
		session.removeAttribute("[Errors]");
		return errors;
	}
	
	public static void addMessage(HttpServletRequest request,String message) {
		HttpSession session = request.getSession();
		List<String> messages=(List<String>) session.getAttribute("[Messages]");
		if(messages==null)
			messages=new ArrayList<String>(); 
		messages.add(message);
		session.setAttribute("[Messages]", messages);
	}
	
	public static void addError(HttpServletRequest request,String error) {
		HttpSession session = request.getSession();
		List<String> errors=(List<String>) session.getAttribute("[Errors]");
		if(errors==null)
			errors=new ArrayList<String>(); 
		errors.add(error);
		session.setAttribute("[Errors]", errors);
	}
}
