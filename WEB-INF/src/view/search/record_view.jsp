<%@page import="util.template.SearchTemplate"%>
<%@page import="util.template.LibraryTemplate"%>
<%@page import="java.util.List"%>
<%@page import="util.form.search.Search"%>
<%@page import="model.Record"%>
<%@page import="model.Track"%>
<%@page import="model.User"%>
<%
	Record record = (Record)request.getAttribute("record");
	Search search=(Search)request.getAttribute("search");
	User user=(User)request.getAttribute("user");
	List<Track> tracks = (List<Track>)request.getAttribute("result");
%>
<h2><%= record.getTitle() %><%= LibraryTemplate.displayFlag(user, record) %></h2><br/>
<div>
		<table class="table table-bordered table-striped">
		<thead>
          <tr>
            <th>Track <%= SearchTemplate.showOrderTrack(search,"title") %></th>
            <th>Rythm <%= SearchTemplate.showOrderTrack(search,"rythm") %></th>
            <th>Playing Time (min) <%= SearchTemplate.showOrderTrack(search,"playing_time") %></th>
            <th>Release Date <%= SearchTemplate.showOrderTrack(search,"release_date") %></th>
          </tr>
        </thead>
			<tbody>
	<%
	for(Track track : tracks){
	%>
          <tr>
            <td><a href="?<%= search.getAttributeViewNewTrack(track.getIdTrack(), "track") %>"><%= track.getTitle() %></a></td>
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