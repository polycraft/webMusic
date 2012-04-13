<%@page import="util.form.TemplateForm"%>
<%@page import="util.template.SearchTemplate"%>
<%@page import="java.util.List"%>
<%@page import="util.form.search.SearchForm"%>
<%@page import="util.form.search.Search"%>
<%@page import="model.User"%>
<%
	SearchForm form=(SearchForm)request.getAttribute("form");
	Search search=(Search)request.getAttribute("search");
	User user=(User)request.getAttribute("user");
%>

<jsp:include page="/WEB-INF/src/view/header.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>

	<form>
		<div class="form-search">
			<input type="text" class="input-medium search-query" <%= TemplateForm.value(form, "text") %> name="text">
			<button type="submit" class="btn">Search</button>
		</div>
		<% if(user!=null) {%>
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
		 <%
		 }%>
		 <a href="#more_search" data-toggle="collapse" data-target="#more_search" class="collapse">Recherche avancée</a>
		<div class="form-horizontal collapse <%= (search.isavancedSearch())?"":"in" %>" id="more_search">
			<div class="control-group">
	            <label class="control-label" for="artist">Artist</label>
	            <div class="controls">
	              <input type="text" name="artist" id="artist" <%= TemplateForm.value(form, "artist") %>>
	            </div>
            </div>
            <div class="control-group">
	            <label class="control-label" for="producer">producer</label>
	            <div class="controls">
	              <input type="text" name="producer" id="producer" <%= TemplateForm.value(form, "producer") %>>
	            </div>
            </div>
			
		</div>
		
		<input type="hidden" <%= TemplateForm.value(form, "order") %> name="order">
		<input type="hidden" <%= TemplateForm.value(form, "order_col") %> name="order_col">
	</form>
	
	<a href="add_record"><i class="icon-plus"></i>Ajouter un record</a>
	
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
	
	<script type="text/javascript">
	$(".collapse").collapse()
	</script>
	<jsp:include page="/WEB-INF/src/view/footer.jsp" />