<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="<%=conPath %>/css/style.css" rel="stylesheet">
</head>
<body>
	<h2>표현식 태그 이용</h2>
	<p>산술연산 : 10+1 = <%=10+1 %></p>
	<p>산술연산 : 10/0.0 = <%=10/0.0 %></p> <!-- 0으로 나누면 에러. 0.0으로 나누면 무한대 -->
	<p>관계연산 : 1==2 => <%=1==2 %></p>
	<p>관계연산 : 1!=2 => <%=1!=2 %></p>
	<p>관계연산 : 1 &lt; 2 => <%=1<2 %></p>
	<p>조건연산 : <%=(1>2)? "1이 2보다 큽니다":"1이 2보다 크지 않습니다" %></p>
	<p>논리연산 : (1>2) || (1<2) = <%=(1>2) || (1<2) %></p>
	<p>로그인 여부 <%=session.getAttribute("customer")==null? "로그인전":"로그인후" %>
	<p>로그인 여부 <%=session.getAttribute("customer")!=null? "로그인후":"로그인전" %>
	<p>pageNum 파라미터 여부 <%=request.getParameter("pageNum")==null? "pageNum 안 옴":"pageNum 옴" %></p>
	<p>name 파라미터 : <%=request.getParameter("name") %></p>
	<hr>
	<h2>EL표기법 이용</h2>
	<p>산술연산 : 10+1 = ${10+1 }</p>
	<p>산술연산 : 10/0.0 = ${10/0.0 }</p> <!-- 0으로 나누면 에러. 0.0으로 나누면 무한대 -->
	<p>관계연산 : 1==2 => ${1 eq 2 }</p>
	<p>관계연산 : 1!=2 => ${1 != 2 }</p>
	<p>관계연산 : 1 &lt; 2 => ${1 < 2 }</p>
	<p>조건연산 : ${1>2 ? "1이 2보다 큽니다":"1이 2보다 크지 않습니다" }</p>
	<p>논리연산 : (1>2) || (1<2) = ${ (1>2) || (1<2) }</p>
	<p>로그인 여부 ${customer == null? "로그인전" : "로그인후" }</p>
	<p>로그인 여부 ${customer eq null? "로그인전" : "로그인후" }</p>
	<p>로그인 여부 ${empty customer? "로그인전" : "로그인후" }</p>
	<p>로그인 여부 ${not empty customer? "로그인전" : "로그인후" }</p>
	<p>pageNum 파라미터 여부 ${empty param.pageNum? "pageNum 없" : "pageNum 있" }</p>
	<p>name 파라미터 : ${param.name }</p>
</body>
</html>