<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%
	List<User> users = (List<User>) request.getAttribute("listeUsers");
%>

<jsp:include page="/WEB-INF/src/view/header.jsp">
	<jsp:param name="title" value="Admin - List user" />
</jsp:include>


<table class="table table-striped">
	<thead>
		<tr>
			<th>Username</th>
			<th>Email</th>
			<th>Language</th>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
		<%
			for (User user : users) {
		%>
		<tr>
			<td>
				<%
					out.print(user.getUsername());
				%>
			</td>
			<td>
				<%
					out.print(user.getEmailAdress());
				%>
			</td>
			<td>
				<%
					out.print(user.getLanguage().getName());
				%>
			</td>
			<td>
				<%
					out.print(user.getFirstname());
				%>
			</td>
			<td>
				<%
					out.print(user.getLastname());
				%>
			</td>
			<td>
				<a href="user-admin-update?id=<%= user.getIdUser() %>"><i class="icon-edit"></i></a>
				<a href="user-admin-delete?id=<%= user.getIdUser() %>"><i class="icon-remove"></i></a>
			</td>
		</tr>
		<%
			}
		%>

	</tbody>
</table>

<a href="user-admin-add"><i class="icon-plus"></i>Add user</a>

<jsp:include page="/WEB-INF/src/view/footer.jsp" />