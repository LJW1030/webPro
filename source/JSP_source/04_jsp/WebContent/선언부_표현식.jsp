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
		int j=0;
		i++;
		j++;
		strBuf.append("<span>~~~~</span>");
		out.println("strBuf = "+strBuf+"<br>");
		out.println("sum(10,5) = "+sum(10,5));
	%>
	<%!
		int i; // 0
		StringBuffer strBuf = new StringBuffer("nice ");
		public int sum(int a, int b){
			return a+b;
		}
	%>
</body>
</html>