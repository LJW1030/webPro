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
	<style>
	b:last-child {
		color:red;
}
	</style>
</head>
<body>
	<form action="">
		<p>
			<input type="number" name="num1" value="<%=(int)(Math.random()*9)+1%>"> *
			<input type="number" name="num2" value="<%=(int)(Math.random()*9)+1%>"> =
			<input type="number" name="ans">
		</p>
	<input type="submit" value="확인">
	</form>
	<hr>
	<b>
		${param.num1 } * ${param.num2 } = ${param.ans } 
		${param.num1 * param.num2 eq param.ans ? "는 정답" : "는 오답"}
		
	</b>
</body>
</html>