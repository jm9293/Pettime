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
	href="${pageContext.request.contextPath}/adminCSS/adNoticeWrite.css">
<script
		src="${pageContext.request.contextPath }/adminJS/adNotice.js"></script>
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
		<div class="col-12 col-md-8 contain">
			<form name="frm" action="adNoticeUpdateOk" method="post"
				onsubmit="return chkSubmit()">
				<input type="hidden" name="num" value="${dto.num }" /> <input
					type="hidden" name="page" value="${page }" />
				<div class="form-group col-12">
					<label for="title">제목</label> <input type="text"
						class="form-control" id="title" name="title" maxlength="50"
						value="${dto.title }" />
				</div>
				<div class="form-group col-12">
					<label for="content">내용</label>
					<textArea class="form-control" id="content" name="content"
						rows="10">${dto.content }</textArea>
				</div>
				<input type="hidden" name="viewcnt" value="${dto.viewcnt }">
				<input type="hidden" name="${_csrf.parameterName }"
					value="${_csrf.token }" />
				<div class="btn row col-12">
					<button type="submit" class="btn btn-primary">수정</button>
					<button type="button" class="btn btn-dark"
						onclick="location.href='adNoticelist?page=${page}'">목록으로</button>
				</div>
				<br>
				<br>
			</form>
		</div>
	</div>
</body>
</html>