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
	<h2>2_view 페이지</h2>
	<h2>회원정보</h2>
	<p>ID : ${member.id }</p>
	<p>PW : ${member.pw }</p>
	<p>등록일 : ${member.rdate }</p>
	<hr>
	<p>
		넘어온 파라미터  ID : ${param.id }
		넘어온 파라미터  PW : ${param.pw }
	</p>
	<button onclick="history.back()">이전</button>
</body>
</html>