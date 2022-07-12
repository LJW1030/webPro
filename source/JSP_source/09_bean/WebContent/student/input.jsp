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
	<form action="step6.jsp">
		<p>학번<input type="text" name="num">
		<p>이름<input type="text" name="name">
		<p>학년<input type="number" name="grade">
		<p>반<input type="number" name="classNum">
		<p>점수<input type="number" name="score">
		<p><input type="submit" value="입력"></p>
		</form>
</body>
</html>