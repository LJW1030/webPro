<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
	form{
	width:300px;
	border:3px solid navy;
	}</style>
</head>
<body>
	<% int su = Integer.parseInt(request.getParameter("num")); %>
	<form>
	<p>결과화면</p>
	<hr/>
	<p>해당 구구단 출력</p>
	<%for(int i=1; i<=9; i++) {%>
		<p><%=su %> * <%=i %> = <%=su*i %></p>
	
	<%} %>
	</form>
</body>
</html>