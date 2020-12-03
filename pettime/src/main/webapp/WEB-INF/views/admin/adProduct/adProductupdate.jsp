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
	href="${pageContext.request.contextPath}/adminCSS/adMenu.css">
<script src="${pageContext.request.contextPath }/adminJS/adminMenu.js"></script>
<title>Pettime Manager</title>
</head>
<body class="col-lg-10" style="margin: auto;">
	<div id="navbar-wrap">
		<%@ include file="../adminNav.jsp"%>
	</div>
	<div class="content col-12">
		<form action="adProductUpdateOk" method="POST">
			<div class="col-12 row">
			<input type="hidden" name="num" value="${dto.num }">
				<div class="col-6">메뉴</div>
				<div class="col-6">
					<input type="text" name="subject" value="${dto.subject }">
				</div>
				<div class="col-6">금액</div>
				<div class="col-6">
					<input type="text" name="price" value="${dto.price }">
				</div>
			</div>

			<div class="col-12 row">
				<button type="submit">수정완료</button>
				<button type="button" onclick="history.back()">목록으로</button>
			</div>
			<input type="hidden"
					name="${_csrf.parameterName }" value="${_csrf.token }" />
		</form>
	</div>

</body>
</html>