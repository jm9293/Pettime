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
	href="${pageContext.request.contextPath}/adminCSS/adQna.css">
<title>Pettime Manager</title>
</head>
<body class="col-lg-10" style="margin: auto;">
	<div id="navbar-wrap">
		<%@ include file="../adminNav.jsp"%>
	</div>

	<div class="content col-12">
		<div class="col-12 col-md-8 head row">
			<h2 class="col-7">Q&A 상담게시판</h2>
		</div>
	<br>
	<c:if test="${dto != null }">
		<div class="col-12 col-md-8 titlebox">
		<h3 class="title">글 제목 : ${dto.title }</h3><br>
		<h6 class="title">작성자 : ${dto.userid } </h6>
		<h6 class="title">조회수 : ${dto.viewcnt } </h6>
		<fmt:formatDate  value="${dto.wrdate}" var="dateFmt" pattern="yyyy-MM-dd"/>	
		<h6 class="title">작성일 : ${dateFmt }></h6>
		<c:if test="${dto.open eq 'Y' }">
			<h6 class="title">비공개 글</h6>
		</c:if>
		</div>
		<div class="row col-12 col-md-8 contentbox">
			<textarea class="col-12 form-control" readonly>${dto.content }</textarea>
		</div>
		<c:if test="${dto.anser != null }">
			<br>
			<fmt:formatDate  value="${dto.andate}" var="dateFmt2" pattern="yyyy-MM-dd"/>
			<div class="col-12 col-md-8 answerbox"><h6>답변 내용<br>작성자: 관리자<br>작성일: ${dateFmt2 }</h6></div>
			<div class="contentbox2 row col-12 col-md-8">
				<textarea class="col-12 form-control" readonly>${dto.anser }</textarea>
			</div>
		</c:if>
		<div class="row col-12 col-md-8">
			<div id="select" class="col-12">
			<c:choose>
				<c:when test="${dto.anser != null }">
					<button type="button" class="btn btn-primary btn-md" onclick="location.href='adQnaUpdate?&num=${dto.num }'">답변수정</button>
				</c:when>
				<c:otherwise>
					<button type="button" class="btn btn-primary btn-md" onclick="location.href='adQnaAnswer?&num=${dto.num }'">답변달기</button>
				</c:otherwise>
			</c:choose>			
			<button type="button" class="btn btn-secondary btn-md" onclick="location.href='adQnaDelete?num=${dto.num}'">글삭제</button>
			<button type="button" id="back" class="btn btn-dark btn-md" onclick="location.href='${pageContext.request.contextPath }/admin/adQna/adQnalist?page=1'">목록으로</button>
			</div>
		</div>
	<br>
	</c:if>
	<br><br>
	</div>
</body>
</html>