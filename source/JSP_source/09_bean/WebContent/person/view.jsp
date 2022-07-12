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
	<jsp:useBean id="p" class="com.ex.Person" scope="request"/>
	<h2>입력된 정보</h2>
	<p>이름  <jsp:getProperty name="p" property="name"/></p>
	<p>나이  <jsp:getProperty name="p" property="age"/></p>
	<p>성별  <jsp:getProperty name="p" property="gender"/></p>
	<p>주소  <jsp:getProperty name="p" property="address"/></p>
</body>
</html>