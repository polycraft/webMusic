<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="model.Record"%>
<%@page import="model.Track"%>
<%@page import="model.Copy"%>
<%@page import="model.TypeCopy"%>
<%@page import="model.User"%>
<%@page import="util.template.LibraryTemplate"%>

<jsp:include page="/WEB-INF/src/view/header.jsp">
	<jsp:param name="title" value="Home" />
</jsp:include>

<%
	List<Copy> ownedCopies = (List<Copy>) request
			.getAttribute("ownedCopies");
	User user = (User) request
			.getAttribute("user");
	Set<Record> trackedRecords = user.getRecords();

%>


<div class="tabbable" style="margin-bottom: 9px;">
	<ul class="nav nav-tabs">
		<li class="active"><a href="#1" data-toggle="tab">Owned
				Records</a></li>
		<li><a href="#2" data-toggle="tab">Flaged Records</a></li>
		<li><a href="#3" data-toggle="tab">Playlists</a></li>
	</ul>
	<div class="tab-content">
		<div class="tab-pane active" id="1">

			<%
				for (Copy copy : ownedCopies) {
					Record record = copy.getRecord();
					Set<Track> tracks = record.getTracks();
			%>
			<div>
				<div>
					Titre: <a href="search?view=record&id_record=<%= record.getIdRecord() %>"><%= record.getTitle() %></a><%= LibraryTemplate.displayEdit(user, record) %> / 
					Type de copie: <%= copy.getTypeCopy().getName() %>
					<a href="unown_record?id=<%= copy.getIdCopy() %>" title="Discard this Copy"><i class="icon-remove"></i></a>
				</div>
				<table class="table table-striped">
					<tbody>
						<%
							for (Track track : tracks) {
						%>
						<tr>
							<td>
								<%
									out.print(track.getTitle());
								%>
							</td>
							<td>
								<%
									out.print(track.getLabel());
								%>
							</td>
							<td>
								<%
									out.print(track.getPlayingTime());
								%>
							</td>
							<td>
								<%
									out.print(track.getTitle());
								%>
							</td>
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

		</div>
		<div class="tab-pane" id="2">

			<%
				for (Record trackedRecord : trackedRecords) {
					Set<Track> tracks = trackedRecord.getTracks();
			%>
			<div>
				<div>
					<%
						out.print("Titre: "+trackedRecord.getTitle());
					%> / <a href="unflag_record?id=<%= trackedRecord.getIdRecord() %>" class="icon-remove" title="Unflag this record"></a> / <a href="own_record?id=<%= trackedRecord.getIdRecord() %>" class="icon-ok" title="Own it"></a>
				</div>
				<table class="table table-striped">
					<tbody>
						<%
							for (Track track : tracks) {
						%>
						<tr>
							<td>
								<%
									out.print(track.getTitle());
								%>
							</td>
							<td>
								<%
									out.print(track.getLabel());
								%>
							</td>
							<td>
								<%
									out.print(track.getPlayingTime());
								%>
							</td>
							<td>
								<%
									out.print(track.getTitle());
								%>
							</td>
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
			
		</div>
		<div class="tab-pane" id="3">
			<p>What up girl, this is Section 3.</p>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/src/view/footer.jsp" />