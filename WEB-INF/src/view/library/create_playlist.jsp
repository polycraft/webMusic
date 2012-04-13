<%@page import="model.User"%>
<%@page import="util.form.implement.PlaylistForm"%>
<%@page import="util.form.TemplateForm"%>
<%
	PlaylistForm form=(PlaylistForm)request.getAttribute("form");
%>

<jsp:include page="/WEB-INF/src/view/header.jsp">
	<jsp:param name="title" value="Home" />
</jsp:include>


<form method="post">
		<%= TemplateForm.globalError(form) %>
		
		<fieldset>				
				<div class="control-group <%= TemplateForm.hasError(form.get("name")) %>">
					<label for="name" class="control-label">Nom de la Playlist</label>
					<div class="controls">
						<input type="text" id="name" name="name" <%= TemplateForm.value(form, "name") %> />
						<%= TemplateForm.fieldError(form.get("name")) %>
					</div>
				</div>
				
				<div class="form-actions">
					<input class="btn btn btn-primary" type="submit" name="Valider" value="<%= request.getParameter("formSubmit")%>">
				</div>			
			</fieldset>

	</form>

<jsp:include page="/WEB-INF/src/view/footer.jsp" />