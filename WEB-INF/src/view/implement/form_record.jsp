<%@page import="model.Record"%>
<%@page import="model.Category"%>
<%@page import="java.util.List"%>
<%@page import="util.form.TemplateForm"%>
<%@page import="util.form.implement.RecordForm"%>
<%
	RecordForm form=(RecordForm)request.getAttribute("form");
	List<Category> categories =  (List<Category>)request.getAttribute("category");
%>
<form method="post">
		<%= TemplateForm.globalError(form) %>
		
		<fieldset>
			<legend><%= request.getParameter("formTitle") %></legend>
				
				<div class="control-group <%= TemplateForm.hasError(form.get("title")) %>">
					<label for="title" class="control-label">Title</label>
					<div class="controls">
						<input type="text" id="title" name="title" <%= TemplateForm.value(form, "title") %> />*
						<%= TemplateForm.fieldError(form.get("title")) %>
					</div>
				</div>
				
				<div class="control-group <%= TemplateForm.hasError(form.get("matrix")) %>">
					<label for="matrix" class="control-label">matrix</label>
					<div class="controls">
						<input type="text" id="matrix" name="matrix" <%= TemplateForm.value(form, "matrix") %> />*
						<%= TemplateForm.fieldError(form.get("matrix")) %>
					</div>
				</div>
				
				<div class="control-group <%= TemplateForm.hasError(form.get("width")) %>">
					<label for="width" class="control-label">width</label>
					<div class="controls">
						<input type="text" id="width" name="width" <%= TemplateForm.value(form, "width") %> />*
						<%= TemplateForm.fieldError(form.get("width")) %>
					</div>
				</div>
				
				<div class="control-group <%= TemplateForm.hasError(form.get("category")) %>">
					<label for="category" class="control-label">category</label>
					<div class="controls">
						<select name="category">
							<option></option>
							<% for(Category l : categories) {
							%>
								<option value='<%= l.getIdCategory() %>' <%= TemplateForm.selected(form, "category", l.getIdCategory()) %>><%= l.getName() %></option>
							<% }
							%>
						</select>*
						<%= TemplateForm.fieldError(form.get("category")) %>
					</div>
				</div>
				
				<div class="control-group <%= TemplateForm.hasError(form.get("artist")) %>">
					<label for="artist" class="control-label">artist</label>
					<div class="controls">
						<input type="text" id="artist" name="artist" />
						<%= TemplateForm.fieldError(form.get("artist")) %>
					</div>
				</div>
				
				<div class="control-group <%= TemplateForm.hasError(form.get("producer")) %>">
					<label for="producer" class="control-label">producer</label>
					<div class="controls">
						<input type="text" id="producer" name="producer" />
						<%= TemplateForm.fieldError(form.get("producer")) %>
					</div>
				</div>
				
				<div class="control-group <%= TemplateForm.hasError(form.get("pressInfo")) %>">
					<label for="pressInfo" class="control-label">pressInfo</label>
					<div class="controls">
						<textarea rows="5" cols="15" name="pressInfo"><%= TemplateForm.valueTextarea(form, "pressInfo") %></textarea>
						<%= TemplateForm.fieldError(form.get("pressInfo")) %>
					</div>
				</div>			
				
				<div class="form-actions">
					<input class="btn btn btn-primary" type="submit" name="Valider" value="<%= request.getParameter("formSubmit")%>">
				</div>			
			</fieldset>

	</form>
