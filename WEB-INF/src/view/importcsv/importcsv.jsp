<jsp:include page="/WEB-INF/src/view/header.jsp">
    <jsp:param name="title" value="Home"/>
</jsp:include>

	<h1><p>CSV file importation</p></h1>
      <form action="<%= request.getContextPath() + "/importcsv"%>" enctype="multipart/form-data" method="post">
         <p>File :<input  type="file" name="source" size="30"></p>
 
         <p>
            <input class="btn btn-primary" type="submit" name="cancel" value="Cancel" title="Cancel Import">
            <input class="btn btn-primary" type="submit" name="submitFichier" value="Import" title="Import">
         </p>
      </form>

	<jsp:include page="/WEB-INF/src/view/footer.jsp" />