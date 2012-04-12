
<%@page import="model.Language"%>
<%@page import="java.util.List"%>
<%@page import="util.form.user.RegisterForm"%>
<%@page import="util.form.TemplateForm"%>
<%
	RegisterForm form=(RegisterForm)request.getAttribute("form");
	List<Language> languages =  (List<Language>)request.getAttribute("languages");
%>

<jsp:include page="/WEB-INF/src/view/header.jsp">
    <jsp:param name="title" value="Register"/>
</jsp:include>

<jsp:include page="/WEB-INF/src/view/user/form.jsp">
    <jsp:param name="formTitle" value="Formulaire Enregistrement User"/>
    <jsp:param name="formSubmit" value="New"/>
</jsp:include>

<jsp:include page="/WEB-INF/src/view/footer.jsp" />