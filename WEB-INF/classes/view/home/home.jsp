<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>HOME</title>
</head>
<body>

	<h1>HOME</h1>
	
	<%
	if((session.getAttribute("idUser") != null) && session.getAttribute("username") != null){
		out.println("LOGED !: "+ session.getAttribute("idUser").toString()+" / "+ session.getAttribute("username").toString());
		out.println("<a href='disconnect'>Disconnect</a>");
	}
	else{
		out.println("<a href='register'>Register</a>");
		out.println("<a href='login'>Connect</a>");
	}
	%>


</body>
</html>