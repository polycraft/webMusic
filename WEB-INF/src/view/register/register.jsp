
<%@page import="model.Language"%>
<%@page import="java.util.List"%>
<%@page import="util.form.user.RegisterForm"%>
<%@page import="util.form.TemplateForm"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	RegisterForm form=(RegisterForm)request.getAttribute("form");
	List<Language> languages =  (List<Language>)request.getAttribute("languages");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register</title>
</head>
<body>

	<form name="firstForm" action="register" method="post"
style="width:50%;margin:auto;background-color:#c1d9fc;padding-bottom:15px;">
				
		<h2 style="text-align:center;color:white;background-color:#6683b1;">Formulaire Enregistrement User</h2>
		<p style="text-align:center;">username : <input type="text" name="username" <%= TemplateForm.value(form, "username") %> />*</p>
		<p style="text-align:center;">password : <input type="password" name="password" />*</p>
		<p style="text-align:center;">password (verif) : <input type="password" name="password2" />*</p>
		<p style="text-align:center;">emailAdress : <input type="text" name="emailAdress" <%= TemplateForm.value(form, "emailAdress") %> />*</p>
		
		
		<p style="text-align:center;">Language :
			<select name="language">
				<% for(Language l : languages) {
				%>
					<option value='<%= l.getIdLanguage() %>' <%= TemplateForm.selected(form, "language", l.getIdLanguage()) %>><%= l.getName() %></option>
				<% }
				%>
			</select>
		</p>
		<h2 style="text-align:center;">Optional</h2>
		<p style="text-align:center;">firstname : <input type="text" name="firstname" <%= TemplateForm.value(form, "firstname") %> /></p>
		<p style="text-align:center;">lastname : <input type="text" name="lastname" <%= TemplateForm.value(form, "lastname") %> /></p>
		<p style="text-align:center;">biography : <textarea rows="5" cols="15" name="biography"><%= TemplateForm.valueTextarea(form, "biography") %></textarea></p>
		<p style="text-align:center;">picture : <input type="text" name="picture" <%= TemplateForm.value(form, "picture") %> /></p>	
		<p style="text-align:center;">website : <input type="text" name="website" <%= TemplateForm.value(form, "website") %> /></p>
		<p style="text-align:center;">socialNetworkAccount : <input type="text" name="socialNetworkAccount" <%= TemplateForm.value(form, "socialNetworkAccount") %> /></p>		
		<p style="text-align:center;width:50%;margin:auto;"><input type="submit" name="Valider" value="Valider"/></p>
		
	</form>


</body>
</html>