<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style>
		form{
		border:3px solid black;
		width:500px;
		height:250px;
		text-align:center;
		}
		
	</style>
</head>
<body>
	<h2>오늘의 메뉴와 식당 선택</h2>
	<form action="ex1" method="post">
		<p class="m">메뉴
			<select name="menu" multiple="multiple" size="3">
				<option>김치찌개</option>
				<option>돈가스</option>
				<option>제육볶음</option>
				<option>뚝배기불고기</option>
				<option>보쌈정식</option>
			</select>
		</p>
		<p>식당
			<input type="checkbox" name="rest" value="일원동" checked="checked">일원동
			<input type="checkbox" name="rest" value="개포동">개포동
			<input type="checkbox" name="rest" value="대치동">대치동
			<input type="checkbox" name="rest" value="역삼동">역삼동
			<input type="checkbox" name="rest" value="양재동">양재동
		</p>
		<p>종류
			<input type="radio" name="nation" value="한식">한식
			<input type="radio" name="nation" value="양식">양식
			<input type="radio" name="nation" value="일식">일식
		</p>
		<input type="submit" value="확인">
	</form>
</body>
</html>