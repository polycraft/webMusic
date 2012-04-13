<%@page import="util.template.LibraryTemplate"%>
<%@page import="model.Track"%>
<%@page import="model.Record"%>
<%@page import="model.User"%>
<%@page import="model.Person"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="util.form.search.Search"%>

<%
	Track track = (Track)request.getAttribute("result");
	User user =  (User)request.getAttribute("user");
	List<Person> persons = (List<Person>)request.getAttribute("persons");
	Search search=(Search)request.getAttribute("search");
	
	Set<Record> records = track.getRecords();

%>
<h2><%= track.getTitle() %></h2>
<br/>
<p>Label: <%= track.getLabel() %></p>
<p>Rythm: <%= track.getRythm() %></p>
<p>Time (min): <%= track.getPlayingTime() %></p>
<p>Rythm: <%= track.getReleaseDate() %></p>
<p>Style: <%= track.getStyle().getName()%></p>
<p>Original Version: <%= track.getOriginalVersion()%></p>

<br/>
<p>Participants:</p>


<%for(Person person : persons){
%>
	<p><%= person.getTrackRole().getName() %>: <%= person.getName() %></p>
<%} %>

<br/><p>In Record(s):</p>
<div>
		<table class="table table-bordered table-striped">
		<thead>
          <tr>
            <th>Record</th>
            <th>Artist</th>
            <th>Producer</th>
          </tr>
        </thead>
			<tbody>
	<%
	for(Record record : records){
	%>
          <tr>
            <td><a href="?<%= search.getAttributeViewNewRecord(record.getIdRecord(), "record") %>"><%= record.getTitle() %></a><%= LibraryTemplate.displayFlag(user, record) %></td>
            <td><%= record.getArtist() %></td>
            <td><%= record.getProducer() %></td>
          </tr>
          <%
			}
          %>    
          </tbody>
		</table>
		
	</div>