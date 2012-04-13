

<jsp:include page="/WEB-INF/src/view/header.jsp">
	<jsp:param name="title" value="Home" />
</jsp:include>


<jsp:include page="/WEB-INF/src/view/implement/form_record.jsp">
    <jsp:param name="formTitle" value="Formulaire Enregistrement Record"/>
    <jsp:param name="formSubmit" value="New"/>
</jsp:include>

<jsp:include page="/WEB-INF/src/view/footer.jsp" />