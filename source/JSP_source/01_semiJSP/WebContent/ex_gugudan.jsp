<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	form{
	width:300px;
	height:150px;
	border:3px solid navy;
	}
	table{
	margin: 10px auto;
	}
</style>
</head>
<body>
	<form action="ex_gugudanOut.jsp" method="get">
	<p>단수입력</p>
	<hr/>
	<table>
		<tr>
			<td>원하는 단수<td>
			<td>
				<input type="text" name="num">
			</td>
		<tr>
			<td colspan="2">
				<input type="submit" value="구구단 출력">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>