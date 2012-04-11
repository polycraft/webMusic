
<%@page import="model.Language"%>
<%@page import="java.util.List"%>
<%@page import="util.form.user.RegisterForm"%>
<%@page import="util.form.TemplateForm"%>
<%
	RegisterForm form=(RegisterForm)request.getAttribute("form");
	List<Language> languages =  (List<Language>)request.getAttribute("languages");
%>

<jsp:include page="/WEB-INF/src/view/header.jsp">
    <jsp:param name="title" value="Register"/>
</jsp:include>

	<form name="firstForm" action="register" method="post">
		<%= TemplateForm.globalError(form) %>
		
		<fieldset>
			<legend>Formulaire Enregistrement User</legend>
		
			<fieldset>
				<legend>Obligatoire</legend>
				
				<div class="control-group <%= TemplateForm.hasError(form.get("username")) %>">
					<label for="username" class="control-label">Username</label>
					<div class="controls">
						<input type="text" id="username" name="username" <%= TemplateForm.value(form, "username") %> />*
						<%= TemplateForm.fieldError(form.get("username")) %>
					</div>
				</div>
				
				<div class="control-group <%= TemplateForm.hasError(form.get("password")) %>">
					<label for="password" class="control-label">Password</label>
					<div class="controls">
						<input type="password" id="password" name="password" />*
						<%= TemplateForm.fieldError(form.get("password")) %>
					</div>
				</div>
				
				<div class="control-group <%= TemplateForm.hasError(form.get("password_confirm")) %>">
					<label for="password_confirm" class="control-label">Password confirm</label>
					<div class="controls">
						<input type="password" id="password_confirm" name="password_confirm" />*
						<%= TemplateForm.fieldError(form.get("password_confirm")) %>
					</div>
				</div>
				
				<div class="control-group <%= TemplateForm.hasError(form.get("emailAdress")) %>">
					<label for="emailAdress" class="control-label">Email adress</label>
					<div class="controls">
						<input type="text" id="emailAdress" name="emailAdress" <%= TemplateForm.value(form, "emailAdress") %> />*
						<%= TemplateForm.fieldError(form.get("emailAdress")) %>
					</div>
				</div>
				
				<div class="control-group <%= TemplateForm.hasError(form.get("language")) %>">
					<label for="language" class="control-label">Language</label>
					<div class="controls">
						<select name="language">
							<option></option>
							<% for(Language l : languages) {
							%>
								<option value='<%= l.getIdLanguage() %>' <%= TemplateForm.selected(form, "language", l.getIdLanguage()) %>><%= l.getName() %></option>
							<% }
							%>
						</select>*
						<%= TemplateForm.fieldError(form.get("language")) %>
					</div>
				</div>
			</fieldset>
		
			<fieldset>
				<legend>Optional</legend>
				
				<div class="control-group <%= TemplateForm.hasError(form.get("firstname")) %>">
					<label for="firstname" class="control-label">Firstname</label>
					<div class="controls">
						<input type="text" id="firstname" name="firstname" <%= TemplateForm.value(form, "firstname") %> />
						<%= TemplateForm.fieldError(form.get("firstname")) %>
					</div>
				</div>
				
				<div class="control-group <%= TemplateForm.hasError(form.get("lastname")) %>">
					<label for="lastname" class="control-label">Lastname</label>
					<div class="controls">
						<input type="text" id="lastname" name="lastname" <%= TemplateForm.value(form, "lastname") %> />
						<%= TemplateForm.fieldError(form.get("lastname")) %>
					</div>
				</div>
				
				<div class="control-group <%= TemplateForm.hasError(form.get("biography")) %>">
					<label for="biography" class="control-label">Biography</label>
					<div class="controls">
						<textarea rows="5" cols="15" name="biography"><%= TemplateForm.valueTextarea(form, "biography") %></textarea>
						<%= TemplateForm.fieldError(form.get("biography")) %>
					</div>
				</div>
				
				<div class="control-group <%= TemplateForm.hasError(form.get("picture")) %>">
					<label for="picture" class="control-label">Picture</label>
					<div class="controls">
						<input type="text" id="picture" name="picture" <%= TemplateForm.value(form, "picture") %> />
						<%= TemplateForm.fieldError(form.get("picture")) %>
					</div>
				</div>
				
				<div class="control-group <%= TemplateForm.hasError(form.get("website")) %>">
					<label for="website" class="control-label">Website</label>
					<div class="controls">
						<input type="text" id="website" name="website" <%= TemplateForm.value(form, "website") %> />
						<%= TemplateForm.fieldError(form.get("website")) %>
					</div>
				</div>
				
				<div class="control-group <%= TemplateForm.hasError(form.get("socialNetworkAccount")) %>">
					<label for="socialNetworkAccount" class="control-label">Social Network account</label>
					<div class="controls">
						<input type="text" id="socialNetworkAccount" name="socialNetworkAccount" <%= TemplateForm.value(form, "socialNetworkAccount") %> />
						<%= TemplateForm.fieldError(form.get("socialNetworkAccount")) %>
					</div>
				</div>				
				
				<div class="form-actions">
					<input class="btn btn btn-primary" type="submit" name="Valider" value="Valider">
				</div>			
			</fieldset>
		</fieldset>
	</form>

<jsp:include page="/WEB-INF/src/view/footer.jsp" />