
<%@page import="model.Language"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register jsp</title>
</head>
<body>

	<form name="firstForm" action="register" method="post"
style="width:50%;margin:auto;background-color:#c1d9fc;padding-bottom:15px;">
				
		<h2 style="text-align:center;color:white;background-color:#6683b1;">Formulaire Enregistrement User</h2>
		<% 
			Boolean error = (Boolean)request.getAttribute("error");
			String errorType = (String)request.getAttribute("errorType");
			if(error){
				out.println("<p style='text-align:center';>"+errorType+"</p>");
			}
		%>
		<p style="text-align:center;">username : <input type="text" name="username" />*</p>
		<p style="text-align:center;">password : <input type="password" name="password1" />*</p>
		<p style="text-align:center;">password (verif) : <input type="password" name="password2" />*</p>
		<p style="text-align:center;">emailAdress : <input type="text" name="emailAdress" />*</p>
		
		
		<p style="text-align:center;">Language :
			<select name="language">
				<%
				
				List<Language> languages =  (List<Language>)request.getAttribute("languages");
				for(Language temp : languages)
				{
					out.println("<option value='"+temp.getIdLanguage()+"'>"+temp.getName()+"</option>");
				}
				%>

			</select>
		</p>
		<h2 style="text-align:center;">Optional</h2>
		<p style="text-align:center;">firstname : <input type="text" name="firstname" /></p>
		<p style="text-align:center;">lastname : <input type="text" name="lastname" /></p>
		<p style="text-align:center;">biography : <input type="textarea" name="biography" /></p>
		<p style="text-align:center;">picture : <input type="text" name="picture" /></p>	
		<p style="text-align:center;">website : <input type="text" name="website" /></p>
		<p style="text-align:center;">socialNetworkAccount : <input type="text" name="socialNetworkAccount" /></p>		
		<p style="text-align:center;width:50%;margin:auto;"><input type="submit" name="Valider" value="Valider"/></p>
		
	</form>


</body>
</html>