<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	$(document).ready(function(){
		$('#p1').click(function(){
			//$(this).text("<b>바뀐 p태그</b>");
			$(this).html("<b>바뀐 p태그</b>");
		});
	});
</script>
</head>
<body>
	<p id="p1">p태그</p>
</body>
</html>