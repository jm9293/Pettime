<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.19.1/moment.min.js"
	integrity="sha512-Dz4zO7p6MrF+VcOD6PUbA08hK1rv0hDv/wGuxSUjImaUYxRyK2gLC6eQWVqyDN9IM1X/kUA8zkykJS/gEVOd3w=="
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/adminCSS/adBasic.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/adminCSS/adQnaView.css">
<title>Pettime Manager</title>
</head>
<body class="col-lg-10" style="margin: auto;">
	<div id="navbar-wrap">
		<%@ include file="../adminNav.jsp"%>
	</div>

	<div class="content col-12">
		<div class="col-10 head row">
			<h2 class="col-7">Q&A 상담게시판</h2>
		</div>
	<br>
	<div class="col-10 box">
	<c:if test="${dto != null }">
		<div class="col-12 titlebox">
		<h3 class="title">글 제목 : ${dto.title }</h3><br>
		<h6 class="title">작성자 : ${dto.userid } </h6>
		<h6 class="title">조회수 : ${dto.viewcnt } </h6>
		<fmt:formatDate  value="${dto.wrdate}" var="dateFmt" pattern="yyyy-MM-dd"/>	
		<h6 class="title">작성일 : ${dateFmt }></h6>
		<c:if test="${dto.open eq 'Y' }">
			<h6 class="title">비공개 글</h6>
		</c:if>
		</div>
		<div class="row col-12 contentbox">
			<textarea class="col-8 form-control" readonly>${dto.content }</textarea>
		</div>
			<br>
			<form action="adQnaUpdateOk" method="post">
				<input type="hidden" name="num" value="${dto.num }">
				<div class="contentbox2 row col-12">
				<textarea class="col-8 form-control" name="anser">${dto.anser }</textarea>
				<input type="hidden" name="${_csrf.parameterName }"
					value="${_csrf.token }" />
			</div>
			<div id="select" class="col-12">
			<button type="submit" class="btn btn-primary">수정완료</button>
			<button type="button" id="back" class="btn btn-dark btn-md" onclick="location.href='${pageContext.request.contextPath }/admin/adQna/adQnalist?page=1'">목록으로</button>
			</div>
			</form>
	<br>
	</c:if>
	</div>
	<br><br>
	</div>
</body>
</html>