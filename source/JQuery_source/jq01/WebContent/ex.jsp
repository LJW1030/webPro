<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	 h1, td, div {text-align: center;}
    table {width: 450px;margin: 0 auto;}
    table td {
        background-color: #AAFFAA;
        width: 150px;
        height: 150px;
    }
    .tdClick {
      background-color: red;
    }
</style>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
		$(document).ready(function(){
			var Didx = parseInt(Math.random()*9);
			$('td').click(function(){
			$('td').removeClass('tdClick');
		var idx = Number($(this).attr('id'));	
		if(Didx == idx){
			$('#msg').html('정답');
			$(this).css('background-image','url("img/dduk.jpg")');
			$(this).css('background-size','100%');
			$('td').off();
		}else{
			$('#msg').html('땡 ! 다른곳입니다~');
			$(this).addClass('tdClick');
		}
			});
		});
	</script>
</head>
<body>
	<h1>떡이 있는곳을 맞춰라</h1>
	<table>
		<tr><td id="0"></td><td id="1"></td><td id="2"></td></tr>
    	<tr><td id="3"></td><td id="4"></td><td id="5"></td></tr>
    	<tr><td id="6"></td><td id="7"></td><td id="8"></td></tr>
	</table>
	<div id="msg"></div>
</body>
</html>