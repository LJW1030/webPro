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
	<h1>쿠키 리스트</h1>
	<%
		Cookie[] cs = request.getCookies();
		for(int i=0; i<cs.length; i++){
			String name = cs[i].getName();
			String value = cs[i].getValue();
			out.println("<h2>"+i+"번째 쿠키 이름"+name+", 값"+value+"</h2>");
		}
	%>
	<hr>
	<a href="cookieConstruct.jsp">쿠키 생성</a> <br>
	<a href="thatCookie.jsp">특정 쿠키</a><br>
	<a href="cookieDel.jsp">쿠키 삭제</a>
</body>
</html>