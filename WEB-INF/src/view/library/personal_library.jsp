<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="model.Record"%>
<%@page import="model.Track"%>
<%@page import="model.Copy"%>
<%@page import="model.TypeCopy"%>

<jsp:include page="/WEB-INF/src/view/header.jsp">
	<jsp:param name="title" value="Home" />
</jsp:include>

<%
	List<Copy> ownedCopies = (List<Copy>) request
			.getAttribute("ownedCopies");
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
					<%
						out.print("Titre: "+record.getTitle()+" / Type de copie: "+copy.getTypeCopy().getName());
					%>
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
			<p>Howdy, I'm in Section 2.</p>
		</div>
		<div class="tab-pane" id="3">
			<p>What up girl, this is Section 3.</p>
		</div>
	</div>
</div>

<jsp:include page="/WEB-INF/src/view/footer.jsp" />