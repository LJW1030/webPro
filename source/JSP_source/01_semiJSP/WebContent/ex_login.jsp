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
		text-align:center;	
		margin: 5px auto;
	}
	td{
	}
	input{
		border:3px solid navy;
	}
	</style>	
</head>
<body>
	<form action="ex_result.jsp" method="post">
	<p>로그인 화면</p>
	<hr/>
	<table>
		<tr>
			<td>이   름<td>
			<td>
				<input type="text" name="name">
			</td>
		</tr>
		<tr>
			<td>아이디<td>
			<td>
				<input type="text" name="id">
			</td>
		</tr>
		<tr>
			<td>패스워드<td>
			<td>
				<input type="password" name="pw">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인">
			</td>
		</tr>	
	</table>
	</form>
</body>
</html>