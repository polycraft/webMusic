<%@page import="java.util.List"%>
<%@page import="model.TypeCopy"%>
<%@page import="model.CopyCondition"%>
<%	List<TypeCopy> typeCopies = (List<TypeCopy>) request.getAttribute("typeCopies");
List<CopyCondition> copyConditions = (List<CopyCondition>) request.getAttribute("copyConditions");
%>
<jsp:include page="/WEB-INF/src/view/header.jsp">
	<jsp:param name="title" value="Home" />
</jsp:include>
<p>Veuillez choisir le type de copy du Record</p>
<form name="choiceTypeCopy" action="own_record?id=<%= request.getAttribute("idRecord") %>" method="post" class="form-horizontal">
<div class="control-group">
            <label class="control-label" for="select01">Select the Type of Copy</label>
            <div class="controls">
              <select name="typecopy">
              <%for(TypeCopy type : typeCopies){ %>
                <option value='<%= type.getIdTypeCopy() %>'><%= type.getName() %></option>
                <%} %>
              </select>
            </div>
          </div>
              
<div class="control-group">
            <label class="control-label" for="select01">Select the Condition</label>
            <div class="controls">
              <select name="record_condition">
              <%for(CopyCondition condition : copyConditions){ %>
                <option value='<%= condition.getIdCondition() %>'><%= condition.getName() %></option>
                <%} %>
              </select>
            </div>
          </div>
          
          <div class="form-actions">
				<input class="btn" type="submit" name="Valider" value="Valider">
			</div>
</form>
<jsp:include page="/WEB-INF/src/view/footer.jsp" />