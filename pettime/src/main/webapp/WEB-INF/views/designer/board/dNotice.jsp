<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/DesignCSS/dNotice.css"/>
	<meta charset="UTF-8">
	<title>공지사항 게시판</title>
</head>
<body>
	<div id="wrapper" class="ct">
		<nav>
			<%@ include file="../dNav.jsp" %>
		</nav>
		
		<header class="ct">
			<table class="ct">
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>조회수</th>
					<th>등록일</th>
				</tr>
	
				<c:forEach var="dao" items="${list }"> <!-- var = "변수명" ,items = "목록 데이터" --> 
					<tr>
						<td>${dao.num }</td>
						<td>${dao.title }</td>
						<td>${dao.viewcnt }</td>
						<td>${dao.wrdate }</td>
					</tr>
				
				</c:forEach>
			</table>
		</header>
		
	</div>

</body>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>