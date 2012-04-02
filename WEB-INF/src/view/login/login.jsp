<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form name="loginForm" action="login" method="post"
		style="width: 50%; margin: auto; background-color: #c1d9fc; padding-bottom: 15px;">

		<h2
			style="text-align: center; color: white; background-color: #6683b1;">Login</h2>
		<% 
			Boolean error = (Boolean)request.getAttribute("error");
			String errorType = (String)request.getAttribute("errorType");
			if(error){
				out.println("<p style='text-align:center';>"+errorType+"</p>");
			}
		%>
		<p style="text-align: center;">	username : <input type="text" name="username" /></p>
		<p style="text-align: center;">	password : <input type="password" name="password" /></p>
		<p style="text-align:center;width:50%;margin:auto;"><input type="submit" name="Valider" value="Valider"/></p>
</body>
</html>