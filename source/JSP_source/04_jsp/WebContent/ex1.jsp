<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%String num = request.getParameter("num"); %>
	<fieldset>
		<legend>숫자입력</legend>
		<form action="">
		<p>숫자
			<input type="number" name="num" value="<%if(num!=null){out.print(num);}; %>">
			<input type="submit" value="누적">
		</p>
		</form>
	</fieldset>
	<%
		if(num!=null && !num.equals("")){
			int su = Integer.parseInt(num);
			int total =0;
			for(int i=1; i<=su; i++){
				total += i;
			}
			out.print("<h2>1부터 "+su+"까지의 합은 "+total+"</h2>");
		}
	%>
</body>
</html>