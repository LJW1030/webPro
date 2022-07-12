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
	<h1>특정쿠키 삭제(이름으로)</h1>
<%
	Cookie[] cs = request.getCookies();
	if(cs!=null){
		for(Cookie c : cs){
			String name = c.getName();
			if(name.equals("cookieName")){
				//쿠키 삭제 : 유효기간이 0초짜리 같은 이름의 쿠키를 만들어 덮어써 삭제
				Cookie cookie = new Cookie("cookieName", "nnn");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				out.println("<h2>쿠키 삭제 성공<h2>");
				break;
			}
		}
	}
%>
	<hr>
	<a href="cookieConstruct.jsp">쿠키 생성</a> <br>
	<a href="cookieList.jsp">쿠키 리스트</a><br>
	<a href="thatCookie.jsp">특정 쿠키</a><br>
</body>
</html>