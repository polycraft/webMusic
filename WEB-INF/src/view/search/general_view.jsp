<%@page import="util.form.TemplateForm"%>
<%@page import="util.template.SearchTemplate"%>
<%@page import="util.template.LibraryTemplate"%>
<%@page import="java.util.List"%>
<%@page import="util.form.search.Search"%>
<%@page import="model.Record"%>
<%@page import="model.User"%>
<%
	Search search=(Search)request.getAttribute("search");
	User user=(User)request.getAttribute("user");
	List<Record> records =  (List<Record>)request.getAttribute("result");
%>

	<table class="table table-bordered table-striped">
		<thead>
			<tr>
				<th>Title <%= SearchTemplate.showOrderRecord(search,"Title") %></th>
				<th>Width <%= SearchTemplate.showOrderRecord(search,"Width") %></th>
				<th>Artist <%= SearchTemplate.showOrderRecord(search,"Artist") %></th>
				<th>Producer <%= SearchTemplate.showOrderRecord(search,"Producer") %></th>
			</tr>
		</thead>
		<tbody>
			<%
				for(Record record : records){
			%>
		          <tr>
		            <td><a href="?<%= search.getAttributeViewNewRecord(record.getIdRecord(), "record") %>"><%= record.getTitle() %></a><%= LibraryTemplate.displayFlag(user, record) %></td>
                    <td><%= record.getWidth() %></td>
		            <td><%= record.getArtist() %></td>
		            <td><%= record.getProducer() %></td>
		          </tr>
          	<%
				}
	        %>
		</tbody>
	</table>