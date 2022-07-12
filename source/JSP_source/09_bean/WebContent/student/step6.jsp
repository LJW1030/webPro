<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="st" class="com.ex.Student" scope="request"/>
	<jsp:setProperty name="st" property="*"/>
	<jsp:forward page="view.jsp"/>
</body>
</html>