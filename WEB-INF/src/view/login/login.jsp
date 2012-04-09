<jsp:include page="/WEB-INF/src/view/header.jsp">
    <jsp:param name="title" value="Login"/>
</jsp:include>

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
	
	</form>
	
<jsp:include page="/WEB-INF/src/view/footer.jsp" />