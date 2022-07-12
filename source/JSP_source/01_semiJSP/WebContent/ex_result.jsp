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
	}
	</style>
</head>
<body>
	<%! String name, id, pw; %>
	
	<% request.setCharacterEncoding("utf-8");
	   name = request.getParameter("name"); 
	   id = request.getParameter("id"); 
	   pw = request.getParameter("pw"); %>
	<form>
	<p>결과화면</p>
	<hr/>
	<p>아이디는 <%=id %> 이고</p>
	<br>
	<p>패스워드는 <%=pw %> 이고</p>
	<br>
	<p><%=name %>님 반갑습니다</p>
	</form>
</body>
</html>