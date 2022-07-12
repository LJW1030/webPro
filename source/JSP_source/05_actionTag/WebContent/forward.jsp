<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>forward페이지</h2>
	<jsp:forward page="forward2.jsp">
		<jsp:param value="jinwoo" name="name"/>
		<jsp:param value="abc" name="id"/>
	</jsp:forward>
</body>
</html>