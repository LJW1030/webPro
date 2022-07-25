<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>studentOk.jsp 페이지</h2>
	<h2>confirm된 ID : ${id } (model의 id)</h2>
	<h2>confirm된 ID : ${param.id } (파라미터의 id)</h2>
</body>
</html>