<%@page import="com.lec.ch12.dto.BoardDto"%>
<%@page import="com.lec.ch12.dao.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		BoardDao bDao = BoardDao.getInstance();
		BoardDto bDto = new BoardDto();
		for(int i=0; i<101 ; i++){
			bDto.setBname("홍길녘"+i);
			bDto.setBtitle("제목"+i);
			bDto.setBcontent("본문입니다");
			bDto.setBip("127.0.0."+i);
			int result = bDao.write(bDto);
			System.out.println(i+"번째 : "+(result==1? "성공" : "살패"));
		}
		response.sendRedirect("mvcboard/list.do");
	%>
</body>
</html>