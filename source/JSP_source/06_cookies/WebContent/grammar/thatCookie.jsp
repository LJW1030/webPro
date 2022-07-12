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
	<h1>특정 쿠키 찾아(이름으로) 값 확인하기</h1>
<% 	Cookie[] cs = request.getCookies();
	if(cs!=null){
		int i=0;
		for(i=0; i<cs.length; i++){
			String name = cs[i].getName();
			if(name.equals("cookieName")){
				String value = cs[i].getValue();
				out.println("<h2>찾으려고 하는 쿠키 이름 : "+name+", 쿠키값 : "+value+"</h2>");
				break;
			}
		}
		if(i==cs.length){
			out.println("<h2>찾으려고 하는 쿠키가 없습니다</h2>");
		}
	}else{
		out.println("<h2>생성된 쿠키가 없습니다</h2>");
	}
%>
	<hr>
	<a href="cookieConstruct.jsp">쿠키 생성</a> <br>
	<a href="cookieList.jsp">쿠키 리스트</a><br>
	<a href="cookieDel.jsp">쿠키 삭제</a>
</body>
</html>