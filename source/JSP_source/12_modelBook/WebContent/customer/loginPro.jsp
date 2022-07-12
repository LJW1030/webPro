<%@page import="dto.CustomerDto"%>
<%@page import="dao.CustomerDao"%>
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
		request.setCharacterEncoding("utf-8");
		String cid = request.getParameter("cid");
		String cpw = request.getParameter("cpw");
		CustomerDao cDao = CustomerDao.getInstance();
		int result = cDao.loginCheck(cid, cpw);
		if(result == CustomerDao.SUCCESS){
			CustomerDto cDto = cDao.getCustomer(cid);
			session.setAttribute("customer", cDto);
			response.sendRedirect("../main/main.jsp");
		}else{
			response.sendRedirect("loginForm.jsp?msg=");
		}
	%>
</body>
</html>