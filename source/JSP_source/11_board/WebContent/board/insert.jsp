<%@page import="com.dto.BoardDto"%>
<%@page import="com.dao.BoardDao"%>
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
	BoardDao dao = BoardDao.getInstance();
	BoardDto dto = new BoardDto();
	for(int i=0; i<50; i++){
		dto.setWriter(i+"진우");
		dto.setSubject(i+"상한나라의 앨리스");
		dto.setContent("줄거리~");
		dto.setPw("1");
		dto.setIp("127.0.0.1");
		dao.insertBoard(dto);
	}
	response.sendRedirect("list.jsp");
%>
</body>
</html>