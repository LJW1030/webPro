<%@page import="java.util.Enumeration"%>
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
<%  // 특정 세션 속성값 가져오기
	out.println("<h4>특정 세션 속성</h4>");
	String sessionName=(String)session.getAttribute("sessionName");
	int myNum=(Integer)session.getAttribute("myNum");
	
	out.println("sessionName = "+sessionName+"<br>");
	out.println("myNum = "+myNum+"<br>");
	out.println("id : "+session.getAttribute("id")+"<br>"); // 추가한 속성없을 경우 null
	// 모든 세션 속성 리스트 추력
	out.println("<h4>모든 세션 속성들 list</h4>");
	Enumeration<String> sAttrNames = session.getAttributeNames();
	int cnt=0;
	while(sAttrNames.hasMoreElements()){
		String sname = sAttrNames.nextElement(); // 세션 이름
		String svalue = session.getAttribute(sname).toString(); // 세션 값
		out.println("세션 이름 : "+sname+", 세션 값 : "+svalue);
		cnt++;
	}
	if(cnt==0){
		out.println("추가한 세션 속성 없음");
	}
	// 특정 세션 (속성) 삭제하기(로그아웃시 사용)
	session.removeAttribute("myNum"); // myNum 세션 삭제
	out.println("<h4>myNum 세션 삭제 후</h4>");
	sAttrNames = session.getAttributeNames();
	cnt=0;
	while(sAttrNames.hasMoreElements()){
		String sname = sAttrNames.nextElement(); // 세션 이름
		String svalue = session.getAttribute(sname).toString(); // 세션 값
		out.println("세션 이름 : "+sname+", 세션 값 : "+svalue+"<br>");
		cnt++;
	}
	if(cnt==0){
		out.println("추가한 세션 속성 없음");
	}	
	// 모든 세션 삭제하기(로그아웃시 사용)
	session.invalidate();
	if(request.isRequestedSessionIdValid()){ // 유효한 세션 attribute가 있는지 확인
		out.println("session에 유효한 속성 있음<br>");
	}else{
		out.println("session에 유효한 속성 없음<br>");
	}
	out.println("<h4>세션ID : "+session.getId()+"</h4>");
	out.println("<h4>세션의 유효시간 : "+session.getMaxInactiveInterval()+"</h4>");
%>	
</body>
</html>