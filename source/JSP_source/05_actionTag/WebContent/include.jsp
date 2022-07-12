<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/ex.css" rel="stylesheet">
</head>
<body>
	<h1>include페이지</h1>
	<h2>안녕하세요</h2>
	<jsp:include page="includePage.jsp"/>
	<h1>다시 include페이지</h1>
	
</body>
</html>