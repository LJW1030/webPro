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
	<form action="petResult.jsp">
		<p>ID <input type="text" name="id"></p>
		<p>
			키우는 애완동물 선택
			<input type="checkbox" name="pets" value="개">개
			<input type="checkbox" name="pets" value="고양이">고양이
			<input type="checkbox" name="pets" value="햄스터">햄스터
			<input type="checkbox" name="pets" value="호랑이">호랑이
		</p>
		<input type="submit">
	</form>
</body>
</html>