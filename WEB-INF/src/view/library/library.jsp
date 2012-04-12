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

<%
	for(Record record : records){
		Set<Track> tracks = record.getTracks();
	%>
	<div>
		<div><%out.print("Title : "+record.getTitle()); %>
		<%= LibraryTemplate.displayFlag(user, record) %>
		</div>
		<table class="table table-striped">
			<tbody>
			<%
				for(Track track : tracks){
			%>
          <tr>
            <td><%out.print(track.getTitle()); %></td>
            <td><%out.print(track.getLabel()); %></td>
            <td><%out.print(track.getPlayingTime()); %></td>
            <td><%out.print(track.getTitle()); %></td>
          </tr>
          <%
				}
          %>
          
          </tbody>
		</table>
		
	</div>
	<%
	}
%>     
<jsp:include page="/WEB-INF/src/view/footer.jsp" />