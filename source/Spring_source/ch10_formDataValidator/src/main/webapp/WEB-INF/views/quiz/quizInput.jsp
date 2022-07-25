<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<form action="${conPath }/result.do" method="post">
		<h3>${cnt }</h3>
		<h1>개인 정보 입력</h1>
		<p>이름 : <input type="text" name="name" value="${quiz.name }"></p>
		<p>국어 : <input type="number" name="kor" value='<c:if test="${quiz.kor!=0 }>">${quiz.kor }</c:if>'></p>
		<p>영어 : <input type="number" name="eng" value='<c:if test="${quiz.eng!=0 }>">${quiz.eng }</c:if>'></p>
		<p>수학 : <input type="number" name="mat" value='<c:if test="${quiz.mat!=0 }>">${quiz.mat }</c:if>'></p>
		<input type="submit" value="입력">
	</form>
	<h4>${nameError }</h4>
	<h4>${scoreError }</h4>
</body>
</html>