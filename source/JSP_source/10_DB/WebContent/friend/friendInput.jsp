<%@page import="java.util.ArrayList"%>
<%@page import="com.dao.FriendDao"%>
<%@page import="com.dto.FriendDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href ="<%=conPath %>/css/style.css" rel = "stylesheet">
	<script>
		function search(){
			var fname = frm.fname.value;
			var tel = frm.tel.value;
			location.href='friendInput.jsp?fname='+fname+'&tel='+tel;
			}
		
	</script>
</head>
<body>
	<form action="friendInputPro.jsp" name="frm">
		<p>친구이름
			<input type="text" name="fname" required="required" 
			value = "<%String fname = request.getParameter("fname");
			if(fname!=null) out.print(fname);%>">
		 전화	<input type="text" name="tel" required="required"
		 	value = "<%String tel = request.getParameter("tel");
			if(tel!=null) out.print(tel);%>">
			<input type="button" value="검색" onclick='search()'>
			<input type="submit" value="추가">
		</p>
	</form>
	<table>
		<tr><th>순번</th><th>이름</th><th>전화번호</th></tr>
		<%
			FriendDao Fdao = FriendDao.getInstance();
			ArrayList<FriendDto> fs = Fdao.searchFriend(fname, tel);
			for(FriendDto f : fs){
				out.println("<tr>");
				out.println("<td>"+f.getNo()+"</td>");
				out.println("<td>"+f.getFname()+"</td>");
				out.println("<td>"+(f.getTel()!=null? f.getTel():"")+"</td></tr>");
			}
		%>
	</table>
</body>
</html>