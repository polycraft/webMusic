<%@page import="util.form.TemplateForm"%>
<%@page import="java.util.List"%>
<%@page import="util.form.search.SearchForm"%>
<%@page import="model.Record"%>
<%
	SearchForm form=(SearchForm)request.getAttribute("form");
	List<Record> records =  (List<Record>)request.getAttribute("records");
%>

<jsp:include page="/WEB-INF/src/view/header.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>

	<form>
		<div class="form-search">
			<input type="text" class="input-medium search-query" <%= TemplateForm.value(form, "text") %> name="text">
			<button type="submit" class="btn">Search</button>
		</div>
		<div class="control-group">
			<div class="controls">
              <label class="checkbox inline">
                <input type="checkbox" id="all" value="all" name="all"> All data base
              </label>
              <label class="checkbox inline">
                <input type="checkbox" id="personnal" value="personnal" name="personnal"> Personnal librairy
              </label>
              <label class="checkbox">
                <input type="checkbox" id="track" value="track" name="track"> track librairy
              </label>
            </div>
		</div>
	</form>
	
	<div class="tabbable">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#">Record view</a></li>
			<li class="disabled"><a href="#">Record view</a></li>
			<li><a href="#">Track view</a></li>
		</ul>
	</div>
	
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Title <a href="#"><i class="icon-arrow-up"></i></a>/<a href="#"><i class="icon-arrow-down"></i></a></th>
				<th>Width <a href="#"><i class="icon-arrow-up"></i></a>/<a href="#"><i class="icon-arrow-down"></i></a></th>
			</tr>
		</thead>
		<tbody>
			<%
				for(Record record : records){
			%>
		          <tr>
		            <td><a href="#"><%= record.getTitle() %></a></td>
		            <td><%= record.getWidth() %></td>
		          </tr>
          	<%
				}
	        %>
		</tbody>
	</table>
	
	<jsp:include page="/WEB-INF/src/view/footer.jsp" />