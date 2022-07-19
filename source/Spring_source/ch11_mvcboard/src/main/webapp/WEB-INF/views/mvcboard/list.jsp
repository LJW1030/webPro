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
	<c:set var="oNum" value="${orderNum }"/>
	<c:set var="iNum" value="${inverseNum }"/>
	<table>
		<tr>
			<td><a href="${conPath }/mvcboard/writeView.do">글쓰기</a></td>
		</tr>
	</table>
	<table>
		<tr>
			<th>순번</th>
			<th>역순</th>
			<th>글번호</th>
			<th>글쓴이</th>
			<th>글제목</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:if test="${totCnt eq 0 }">
			<tr>
				<th colspan="7">등록된 글이 없습니다</th>
			</tr>
		</c:if>
		<c:if test="${totCnt != 0 }">
			<c:forEach items="${boardList }" var="bDto">
				<tr onclick="trclicked(${bDto.bid})">
					<td>${oNum }</td>
					<td>${iNum }</td>
					<td>${bDto.bid }</td>
					<td>${bDto.bname }</td>
					<td class="left">
						<c:forEach var="i" begin="1" end="${bDto.bindent }">
							<c:if test="${i == bDto.bindent }">
								└─
							</c:if>
							<c:if test="${i != bDto.bindent }">
						 		&nbsp; &nbsp; &nbsp; 
						 	</c:if>
						</c:forEach>
						${bDto.btitle }
					<td>
						<fmt:formatDate value="${bDto.bdate }" pattern="yy/MM/dd(E) hh:mm:ss(a)"/>
						<!-- <fmt:formatDate value="${bDto.date }" pattern="yy/MM/dd(E) hh:mm:ss(a)"/> -->
					</td>
					<td>
						<fmt:formatNumber value="${bDto.bhit }" groupingUsed="true"/>
					</td>
				</tr>
				<c:set var="oNum" value="${oNum+1 }"></c:set>
				<c:set var="iNum" value="${iNum-1 }"></c:set>
			</c:forEach>
		</c:if>
	</table>
	<div class="paging">
		<c:if test="${startPage > BLOCKSIZE }">
			[ <a href="${conPath }/mvcboard/list.do?pageNum=${startPage-1}">이전</a> ]
		</c:if>
		<c:forEach var="i" begin="${startPage }" end="${endPage }">
			<c:if test="${i eq pageNum }">
				[ <b> ${i } </b> ]
			</c:if>
			<c:if test="${i != pageNum }">
				[ <a href="${conPath }/mvcboard/list.do?pageNum=${i}">${i }</a> ]
			</c:if>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			[ <a href="${conPath }/mvcboard/list.do?pageNum=${endPage+1}">다음</a> ]
		</c:if>
	</div>
</body>
</html>