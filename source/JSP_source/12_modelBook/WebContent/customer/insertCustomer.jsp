<%@page import="java.sql.Date"%>
<%@page import="dto.CustomerDto"%>
<%@page import="dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String conPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
<%
	CustomerDao cDao = CustomerDao.getInstance();
	CustomerDto cDto = new CustomerDto();
	for(int i=0; i<10; i++){
		cDto.setCid("b"+i);
		cDto.setCpw("1");
		if(i%2==0){
			cDto.setCname("김길길");
			cDto.setCgender("m");
		}else{
			cDto.setCname("이일일");
			cDto.setCgender("f");
		}
		cDto.setCtel("010-1234-567"+i);
		cDto.setCemail("aa"+i+"@good.com");
		cDto.setCbirth(Date.valueOf("1996-10-30"));
		int result = cDao.insertCustomer(cDto);
		out.println(result==CustomerDao.SUCCESS?"성공":"실패");
		out.println("<br>");
	}
%>
</body>
</html>