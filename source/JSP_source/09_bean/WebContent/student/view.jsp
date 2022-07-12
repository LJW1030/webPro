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
	<p>학번   <jsp:getProperty name="st" property="num"/>
	<p>이름   <jsp:getProperty name="st" property="name"/>
	<p>학년   <jsp:getProperty name="st" property="grade"/>
	<p>반   <jsp:getProperty name="st" property="classNum"/>
	<p>점수   <jsp:getProperty name="st" property="score"/>
</body>
</html>