<%@page import="com.dao.FriendDao"%>
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
	<jsp:useBean id="dto" class="com.dto.FriendDto"/>
	<jsp:setProperty name="dto" property="*"/>
	<%
		FriendDao Fdao = FriendDao.getInstance();
		int result = Fdao.addFriend(dto);
		response.sendRedirect("friendInput.jsp?result=?"+result);
	%>
</body>
</html>