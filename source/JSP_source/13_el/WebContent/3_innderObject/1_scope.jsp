<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<form action="2_scope.jsp">
		<p>이름 <input type="text" name="name"></p>
		<p>ID <input type="text" name="id"></p>
		<p><input type="submit"></p>
	</form>
	<%
		pageContext.setAttribute("pageName", "pageValue");
		request.setAttribute("requestName", "requsetValue");
		session.setAttribute("sessionName", "sessionValue");
		application.setAttribute("applicationName", "applicationValue");
		RequestDispatcher dispatcher = request.getRequestDispatcher("2_scope.jsp?name=lee&id=aaa");
		dispatcher.forward(request, response);
	%>
</body>
</html>