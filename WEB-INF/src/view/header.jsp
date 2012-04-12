<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=request.getParameter("title")%></title>
<link href="public/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
	<script type="text/javascript" src="public/js/jquery-1.7.2.min.js" ></script>
	<script type="text/javascript" src="public/js/bootstrap.min.js" ></script>	
</head>
<body>
	<div class="container-fluid">
	<div style="background : black; height : 100px"></div>
		<div class="row-fluid">
			<div class="span2">
				<jsp:include page="/WEB-INF/src/view/menu/menu.jsp" />
			</div>
			<div class="span10">
			