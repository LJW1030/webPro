<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>forward2페이지</h2>
	<% String n = request.getParameter("n"); 
	   String name = request.getParameter("name");
	   String id = request.getParameter("id");
	%>
	<h2>n은 <%=n%></h2>
	<h2>name은 <%=name%></h2>
	<h2>id는 <%=id%></h2>
</body>
</html>