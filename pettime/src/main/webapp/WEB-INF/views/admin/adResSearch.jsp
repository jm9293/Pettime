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
	href="${pageContext.request.contextPath}/adminCSS/adResSearch.css">
<title>Pettime Manager</title>
</head>
<body class="col-lg-10" style="margin: auto;">
	<div id="navbar-wrap">
		<%@ include file="adminNav.jsp"%>
	</div>

	<div class="content col-12">
		<div class="col-12">예약 정보</div>
		<div class="col-12 row">
		<div class="col-6">고객ID:</div>
		<div class="col-6">${dto.userid }</div>
		</div>
		<div class="col-12 row">
		<div class="col-6">담당 미용사:</div>
		<div class="col-6">${dto.degid }</div>
		</div>
		<div class="col-12 row">
		<div class="col-6">예약 일자:</div>
		<div class="col-6">${date }</div>
		</div>
		<div class="col-12 row">
		<div class="col-6">주소:</div>
		<div class="col-6">${dto.address }</div>
		</div>
		<div class="col-12 row">
		<div class="col-6">견명:</div>
		<div class="col-6">${dto.petName }</div>
		</div>
		<div class="col-12 row">
		<div class="col-6">견종:</div>
		<div class="col-6">${dto.petKind }</div>
		</div>
		<c:forEach var="item" items="${dto2 }">
		<div class="col-12 row">
		<div class="col-6">항목:</div>
		<div class="col-6">${item.content }</div>
		</div>
		<div class="col-12 row">
		<div class="col-6">금액:</div>
		<div class="col-6">${item.price }</div>
		</div>
		</c:forEach>
		<div class="col-12 row">
		<div class="col-6">예약 메모:</div>
		<div class="col-6">${dto.petMemo }</div>
		</div>
		<div class="col-12 row">
		<div class="col-6">처리상태:</div>
		<div class="col-6">${dto.state }</div>
		</div>
		<button type="button" onclick="history.back()">돌아가기</button>
	</div>

</body>
</html>