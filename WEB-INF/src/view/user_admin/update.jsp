
<%@page import="model.Language"%>
<%@page import="java.util.List"%>
<%@page import="util.form.user.UpdateForm"%>
<%@page import="util.form.TemplateForm"%>
<%
	UpdateForm form=(UpdateForm)request.getAttribute("form");
	List<Language> languages =  (List<Language>)request.getAttribute("languages");
%>

<jsp:include page="/WEB-INF/src/view/header.jsp">
    <jsp:param name="title" value="Update"/>
</jsp:include>

<jsp:include page="/WEB-INF/src/view/user/form.jsp">
    <jsp:param name="formTitle" value="Update user"/>
    <jsp:param name="formSubmit" value="Update"/>
</jsp:include>

<a href="user-admin-list"><i class="icon-list-alt"></i>Return to list</a>

<jsp:include page="/WEB-INF/src/view/footer.jsp" />