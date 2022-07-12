<%@page import="java.net.URLEncoder"%>
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
	int num = Integer.parseInt(request.getParameter("num"));
	int com = (int)(Math.random() * 3)+1;
	if(num==com){
		out.println("정답입니다<br>동전이 있던 곳은 "+num);
	}else{
		String msg =("Wrong! Try Again!<br>답은 "+num+"이 아니라 "+com);
		msg = URLEncoder.encode(msg, "utf-8");
		response.sendRedirect("coinIn.jsp?msg="+msg);
	}
%>
<button onclick="history.go(-1)">다시도전</button>
</body>
</html>