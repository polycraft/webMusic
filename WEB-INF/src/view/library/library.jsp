<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="model.Record"%>
<%@page import="model.Track"%>
<%@page import="model.Copy"%>
<%@page import="model.User"%>
<%@page import="util.template.LibraryTemplate"%> 
<%

	
	List<Record> records =  (List<Record>)request.getAttribute("listeRecords");
	User user =  (User)request.getAttribute("user");
%>

<jsp:include page="/WEB-INF/src/view/header.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>


	<div>
		<table class="table table-bordered table-striped">
		<thead>
          <tr>
            <th>Record</th>
            <th>Width</th>
            <th>Artist</th>
            <th>Producer</th>
          </tr>
        </thead>
			<tbody>
			<%
	for(Record record : records){
	%>
          <tr>
            <td><%= LibraryTemplate.recordLink(record) %><TAB><%= LibraryTemplate.displayFlag(user, record) %></td>
            <td><%= record.getWidth() %></td>
            <td><%= record.getArtist() %></td>
            <td><%= record.getProducer() %></td>
          </tr>
          <%
				}
          %>
          
          </tbody>
		</table>
		
	</div>
  
<jsp:include page="/WEB-INF/src/view/footer.jsp" />