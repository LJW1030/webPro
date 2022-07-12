<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<a href="/servlet/ex?id=dlwlsdn&pw=1234">id와 pw 넘기기(GET)</a>
	<hr>
	<button onclick="location.href='ex?id=dlwlsdn&pw=1234'">id와 pw 넘기기(GET)</button>
	<hr>
	<form action="ex" method="get">
		<p>ID <input type="text" name="id"></p>
		<p>PW <input type="password" name="pw"></p>
		<p><input type="submit" value="id와 pw 넘기기<GET>"></p>
	</form>
	<form action="ex" method="post">
		<p>ID <input type="text" name="id"></p>
		<p>PW <input type="password" name="pw"></p>
		<p><input type="submit" value="id와 pw 넘기기<POST>"></p>
	</form>
</html>