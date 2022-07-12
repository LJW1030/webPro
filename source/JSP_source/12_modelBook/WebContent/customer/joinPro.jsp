<%@page import="dao.CustomerDao"%>
<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="dto" class="dto.CustomerDto"/>
	<jsp:setProperty property="*" name="dto"/>
	<%
		String tempbirth = request.getParameter("tempbirth");
		dto.setCbirth(Date.valueOf(tempbirth));
		CustomerDao cDao = CustomerDao.getInstance();
		int result = cDao.confirmCid(dto.getCid());
		if(result == CustomerDao.CUSTOMER_NONEXISTENT){
			result = cDao.insertCustomer(dto);
			if(result == CustomerDao.LOGIN_SUCCESS){
				session.setAttribute("cid", dto.getCid());
	%>		<script>
				alert('회원가입 감사합니다. 로그인 후 서비스 이용해주세요');
				location.href='../main/main.jsp';
			</script>
	<% 	}else{%>
			<script>
				alert('회원가입 실패. 회원가입 페이지로 돌아갑니다');
				location.href='join.jsp';
			</script>
	<%}
		}else{
	%>		<script>
				alert('중복된 ID입니다.');
				history.back();
			</script>	
	<% 	}%>
</body>
</html>