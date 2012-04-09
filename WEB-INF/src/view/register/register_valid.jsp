<%@page import="model.Language"%>
<%@page import="java.util.List"%>
<%@page import="util.form.user.RegisterForm"%>
<%@page import="util.form.TemplateForm"%>

<jsp:include page="/WEB-INF/src/view/header.jsp">
    <jsp:param name="title" value="Register"/>
</jsp:include>

<div class="alert alert-success">Vous êtes enregistrée</div>

<jsp:include page="/WEB-INF/src/view/footer.jsp" />