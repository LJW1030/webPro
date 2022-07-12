<%@page import="com.dao.BoardDao"%>
<%@page import="com.dto.BoardDto"%>
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
	request.setCharacterEncoding("utf-8");
	String pageNum = request.getParameter("pageNum");
%>
	<jsp:useBean id="dto" class="com.dto.BoardDto"/>
	<jsp:setProperty property="*" name="dto"/>
<%
	dto.setIp(request.getRemoteAddr());
	BoardDao dao = BoardDao.getInstance();
	int result = dao.updateBoard(dto);
	if(result==BoardDao.SUCCESS){
%>
	<script>
		alert('글 수정 성공');
		location.href='list.jsp?pageNum=<%=pageNum%>';
	</script>
<%	}else{%>
	<script>
		alert('글 수정 실패');
		history.back();
	</script>
<%} %>
</body>
</html>