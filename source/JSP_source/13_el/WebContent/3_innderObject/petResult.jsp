<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="conPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link href="${conPath }/css/style.css" rel="stylesheet">
</head>
<body>
	<h3> ID : ${param.id }</h3>
	<p>
		키우는 동물은 ${paramValues.pets[0] }
				${paramValues.pets[1] }
				${paramValues.pets[2] }
				${paramValues.pets[3] }
				${paramValues.pets[4] }
			${empty paramValues.pets ? "없습니다" : "" }
	</p>
	<h2>contextID : ${initParam.contextID }</h2>
	<h2>contextPW : ${initParam.contextPW }</h2>
</body>
</html>