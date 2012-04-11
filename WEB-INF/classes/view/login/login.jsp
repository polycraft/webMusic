<%@page import="util.form.user.RegisterForm"%>
<%@page import="util.form.TemplateForm"%>
<%@page import="util.form.user.LoginForm"%>
<% 
	LoginForm form=(LoginForm)request.getAttribute("form");
%>

<jsp:include page="/WEB-INF/src/view/header.jsp">
    <jsp:param name="title" value="Login"/>
</jsp:include>


	
	<form name="loginForm" action="login" method="post" class="form-horizontal">

		<%= TemplateForm.globalError(form) %>
		
		<fieldset>
			<legend>Login</legend>
			<div class="control-group <%= TemplateForm.hasError(form.get("username")) %>">
				<label for="username" class="control-label">Username</label>
				<div class="controls">
					<input type="text" id="username" name="username" />
					<%= TemplateForm.fieldError(form.get("username")) %>
				</div>
			</div>
			
			<div class="control-group<%= TemplateForm.hasError(form.get("password")) %>">
				<label for="password" class="control-label">Password</label>
				<div class="controls">
					<input type="password" id="password" name="password" />
					<%= TemplateForm.fieldError(form.get("password")) %>
				</div>
			</div>
			
			<div class="form-actions">
				<input class="btn" type="submit" name="Valider" value="Valider">
			</div>
		</fieldset>
	</form>
	
<jsp:include page="/WEB-INF/src/view/footer.jsp" />