<%@page import="util.template.LibraryTemplate"%>
<%@page import="model.Track"%>
<%@page import="model.Record"%>
<%@page import="model.User"%>
<%@page import="java.util.Set"%>
<jsp:include page="/WEB-INF/src/view/header.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>

<%
	Record record = (Record)request.getAttribute("record");
	User user =  (User)request.getAttribute("user");
	
	Set<Track> tracks = record.getTracks();
%>
<p><%= LibraryTemplate.recordLink(record) %></p><br/>
<div>
		<table class="table table-bordered table-striped">
		<thead>
          <tr>
            <th>Track</th>
            <th>Rythm</th>
            <th>Playing Time (min)</th>
            <th>Release Date</th>
          </tr>
        </thead>
			<tbody>
	<%
	for(Track track : tracks){
	%>
          <tr>
            <td><%= LibraryTemplate.trackLink(track) %></td>
            <td><%= track.getRythm() %></td>
            <td><%= track.getPlayingTime() %></td>
            <td><%= track.getReleaseDate().toString() %></td>
          </tr>
          <%
			}
          %>    
          </tbody>
		</table>
		
	</div>
	
	
	<p>Artist: <%= record.getArtist() %></p>
	<p>Producer: <%= record.getProducer() %></p>
	<p>Width: <%= record.getWidth() %></p>
	<p>Category: <%= record.getCategory().getName() %></p>
	<p>MatrixCode: <%= record.getMatrix() %></p>
	
	Press Infos :
	<p><%= record.getPressInfo() %></p>

<jsp:include page="/WEB-INF/src/view/footer.jsp" />