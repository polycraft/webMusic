	<div class="well" style="padding: 8px 0;">   
	
	
	<ul class="nav nav-list">
	<jsp:include page="/WEB-INF/src/view/menu/menuStatic.jsp" />
	<% if(session.getAttribute("role")!=null) {%>
		<jsp:include page="/WEB-INF/src/view/menu/menuAdmin.jsp" />
	<%
	}
	%>
	
	<%
	if((session.getAttribute("idUser") != null) && session.getAttribute("username") != null){ %>
		<jsp:include page="/WEB-INF/src/view/menu/menuConnected.jsp" />
	<%
	} 
	else{ %>
		<jsp:include page="/WEB-INF/src/view/menu/menuNotConnected.jsp" />
	<% 
	}
	%>
	
	
       
    </ul>
     </div>