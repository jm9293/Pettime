<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
	<h1>상품 정보</h1>
		<div class="col-8 box">
		<div class="col-12" id="menulist">
			<div class="col-12 row menubar">
				<div class="col-2">번호</div>
				<div class="col-5">메뉴</div>
				<div class="col-5">금액</div>
			</div>
			<div id="resList">
				<c:forEach var="item" items="${list }">
					<div class="col-12 row menuvalue" onclick="location.href='adProductView?num=${item.num }'">
						<div class='col-2 num_text'>${item.num }</div>
						<div class='col-5 subject_text'>${item.subject }</div>
						<div class='col-5 price_text'>${item.price }</div>
					</div>
				</c:forEach>
			</div>
		</div>
				<button id="createbtn" type="button" class="btn btn-primary" onclick="location.href='adProductAdd'">추가하기</button>
		</div>
	</div>
</body>
</html>