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
	response.setContentType("utf-8");
	String id = request.getParameter("id"); 
	String pw = request.getParameter("pw");	
	if(pw==null || !pw.equals("1234") || id==null || !id.equals("abcd")){
		response.sendRedirect("login.jsp?msg=");
	}else{
		session.setAttribute("id", id);
		session.setAttribute("name", "이진우");
		response.sendRedirect("main.jsp");
	}
%>
	
</body>
</html>