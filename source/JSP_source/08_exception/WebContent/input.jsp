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
	<form action="ex1.jsp">
		<p>수1 <input type="number" name="num1" required="required"></p>
		<p>수2 <input type="number" name="num2" required="required"></p>
		<p><input type="submit" value="사칙연산 출력"></p>
	</form>
</body>
</html>