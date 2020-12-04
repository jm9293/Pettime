<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	href="${pageContext.request.contextPath}/adminCSS/adNotice.css">
<title>Pettime Manager</title>
</head>
<body class="col-lg-10" style="margin: auto;">
	<div id="navbar-wrap">
		<%@ include file="../adminNav.jsp"%>
	</div>

	<div class="content col-12">
		<div class="col-12 col-md-8 head row">
			<h2 class="col-7">공지사항</h2>
		</div>
		<br>
		<div class="menuname menuborder row col-12 col-md-8 alert-primary">
			<div class="col-2 menu">No</div>
			<div class="col-4 menu">제목</div>
			<div class="col-2 menu">조회</div>
			<div class="col-4 menu">작성일</div>		
		</div>
		<c:forEach var="item" items="${list }">
		<div class="menuname textarea row col-12 col-md-8 textlist" onclick="location.href='adNoticeView?page=${page }&num=${item.num }'">
			<div class="col-2 text" id="text1">${item.num }</div>
			<div class="col-4 text" id="text1">${item.title }</div>
			<div class="col-2 text" id="text4">${item.viewcnt }</div>
			<div class="col-4 text" id="text5">${item.wrdate }</div>
		</div>
		</c:forEach>
		<br>
		<div class="box_ul">
			<ul class="box_li">
			<c:choose>
				<c:when test="${pageNum -1 <1 }">
					<li class="paging"><a
					href="${pageContext.request.contextPath }/admin/adNotice/adNoticelist?page=1">이전</a></li>
				</c:when>
				<c:otherwise>
					<li class="paging"><a
						href="${pageContext.request.contextPath }/admin/adNotice/adNoticelist?page=${page -1}">이전</a></li>
				</c:otherwise>
			</c:choose>
				<c:if test="${maxCnt > 0 }">
					<c:forEach var="item2" begin="1" end="${pageNum }">
					<c:choose>
						<c:when test="${pageNum == item2} ">
							<li class="paging"><a class='active tooltip-top'
					href="${pageContext.request.contextPath }/admin/adNotice/adNoticelist?page=${item2 }">${item2 }</a></li>
						</c:when>
						<c:otherwise>
							<li class="paging"><a
					href="${pageContext.request.contextPath }/admin/adNotice/adNoticelist?page=${item2 }">${item2 }</a></li>
						</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:if>
			<c:choose>
				<c:when test="${pageNum < maxCnt }">
					<li class="paging"><a
					href="${pageContext.request.contextPath }/admin/adNotice/adNoticelist?page=${pageNum + 1 }">다음</a></li>
				</c:when>
				<c:otherwise>
					<li class="paging"><a
					href="${pageContext.request.contextPath }/admin/adNotice/adNoticelist?page=${maxCnt}">다음</a></li>
				</c:otherwise>
			</c:choose>
			</ul>
		</div>
		<form action="adSearchText" method="post">
			<div class="col-12 col-md-6 row searchbox">
				<input type="hidden" name="page" value="${page }">
				<input type="hidden" name="pageNum" value="1">
				<div class="col-5">
					<input class="col-12 form-control" type="text" name="title" />
				</div>
				<div class="col-3 col-md-2">
					<button type="submit" id="searchbtn"
						class="form-control col-12 btn btn-success btn-sm">검색</button>
				<input type="hidden"
					name="${_csrf.parameterName }" value="${_csrf.token }" />
				</div>
				<button type="button" id="write"
					class="col-4 col-md-2 btn btn-primary btn-sm form-control"
					onclick="location.href='${pageContext.request.contextPath }/admin/adNotice/adNoticeWrite'">글쓰기</button>
			</div>
		</form>
		<br>
	</div>
</body>
</html>