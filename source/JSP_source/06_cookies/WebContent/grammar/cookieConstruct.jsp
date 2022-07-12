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
<%
	Cookie cookie = new Cookie("cookieName", "cookieValue"); // 쿠키생성
	cookie.setMaxAge(60*60); // 유효시간(1시간)
	response.addCookie(cookie); // response에 탑재
%>
	<h2>생성된 쿠키 이름 : <%=cookie.getName() %></h2>
	<h2>생성된 쿠키 값 : <%=cookie.getValue() %></h2>
	<hr>
	<a href="cookieList.jsp">쿠키 리스트</a><br>
	<a href="thatCookie.jsp">특정 쿠키</a><br>
	<a href="cookieDel.jsp">쿠키 삭제</a>
</body>
</html>