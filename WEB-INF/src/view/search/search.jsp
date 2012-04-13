<%@page import="util.form.TemplateForm"%>
<%@page import="util.template.SearchTemplate"%>
<%@page import="java.util.List"%>
<%@page import="util.form.search.SearchForm"%>
<%@page import="util.form.search.Search"%>
<%
	SearchForm form=(SearchForm)request.getAttribute("form");
	Search search=(Search)request.getAttribute("search");
%>

<jsp:include page="/WEB-INF/src/view/header.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>

	<form>
		<div class="form-search">
			<input type="text" class="input-medium search-query" <%= TemplateForm.value(form, "text") %> name="text">
			<button type="submit" class="btn">Search</button>
		</div>
		<input type="text" class="input-medium search-query" <%= TemplateForm.value(form, "artist") %> name="artist">
		<div class="control-group">
			<div class="controls">
              <label class="checkbox inline">
                <input type="checkbox" id="all" value="all" name="all" <%= TemplateForm.checked(form, "all") %> > All data base
              </label>
              <label class="checkbox inline">
                <input type="checkbox" id="personnal" value="personnal" name="personnal" <%= TemplateForm.checked(form, "personnal") %>> Personnal librairy
              </label>
              <label class="checkbox">
                <input type="checkbox" id="tracked" value="tracked" name="tracked" <%= TemplateForm.checked(form, "tracked") %>> track librairy
              </label>
            </div>
		</div>
		
		<input type="hidden" <%= TemplateForm.value(form, "order") %> name="order">
		<input type="hidden" <%= TemplateForm.value(form, "order_col") %> name="order_col">
	</form>
	
	<div class="tabbable">
		<ul class="nav nav-tabs">
			<li <%= SearchTemplate.activateViews(search, "general", true) %>>
				<%= SearchTemplate.linkViews(search, "general", "General view", true) %>
			</li>
			<%
			if(search.getId_record()!=null) {
				%>
				<li <%= SearchTemplate.activateViews(search, "record", false) %>>
					<%= SearchTemplate.linkViews(search, "record", "Record view", false) %>
				</li>
				<%
			}
			if(search.getId_track()!=null) {
				%>
				<li <%= SearchTemplate.activateViews(search, "track", false) %>>
					<%= SearchTemplate.linkViews(search, "track", "Track view", false) %>
				</li>
				<%
			} %>
		</ul>
	</div>
	
	<% if(search.getView().equals("record") && search.getId_record()!=null) { %>
		<jsp:include page="/WEB-INF/src/view/search/record_view.jsp" />
	<%
	} else if(search.getView().equals("track") && search.getId_track()!=null) { %>
		<jsp:include page="/WEB-INF/src/view/search/track_view.jsp" />
	<%
	} else { %>
		<jsp:include page="/WEB-INF/src/view/search/general_view.jsp" />
	<%
	} %>
	
	<jsp:include page="/WEB-INF/src/view/footer.jsp" />