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
	<h3>${cnt }</h3>
	<h2>결과는 다음과 같습니다</h2>
	<h2>이름 : ${quiz.name }</h2>
	<h2>국어 : ${quiz.kor }</h2>
	<h2>영어 : ${quiz.eng }</h2>
	<h2>수학 : ${quiz.mat }</h2>
	<h2>총점 : ${quiz.kor + quiz.eng + quiz.mat }</h2>
	<h2>평균 : ${(quiz.kor + quiz.eng + quiz.mat)/3 }</h2>
	<button onclick="history.back()">이전</button>
	<button onclick="location.href='${conPath}/inputForm.do'">다시</button>
</body>
</html>