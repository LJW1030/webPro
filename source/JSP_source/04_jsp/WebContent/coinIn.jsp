<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<div id="wrap">
		<p>동전이 있는 곳을 맞춰봐</p>
		<hr>
		<button name="num" onclick="location.href='coinOut.jsp?num=1'">1번</button>
		<button name="num" onclick="location.href='coinOut.jsp?num=2'">2번</button>
		<button name="num" onclick="location.href='coinOut.jsp?num=3'">3번</button>
	</div>
<%
	String msg = request.getParameter("msg");
	if(msg!=null){
		out.print("<h2>"+msg+"</h2>");
	}
%>
</body>
</html>