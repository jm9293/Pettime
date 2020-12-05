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
	href="${pageContext.request.contextPath}/adminCSS/adMain.css">
<title>Pettime Manager</title>
</head>
<body class="col-lg-10" style="margin:auto;">
	<div id="navbar-wrap">
		<%@ include file="adminNav.jsp"%>
	</div>

	<div class="content col-12">
		<div class="col-12 col-md-4" id="resCnt"><div class="bg-warning text-dark">당일 예약현황 ${cnt }건</div></div>
		<div class="col-12 col-md-4" id="userCnt"><div class="bg-light text-dark">회원수 ${cnt2 }명</div></div>
		<div class="col-12 col-md-4" id="weather">
			<div class="weathertxt col-8">날씨정보</div>
			<div class="weather-box col-4" id="weatherimg"></div>
		</div>
		<div class="col-12" id="desList">
			<div class="col-12" id="destitle">당일 출근 리스트</div>
			<div class="col-12 row" id="desmenu">
				<div class="col-6 col-md-2 bg-light text-dark">ID</div>
				<div class="col-6 col-md-2 bg-light text-dark">이름</div>
				<div class="col-6 col-md-4 bg-light text-dark">연락처</div>
				<div class="col-6 col-md-4 bg-light text-dark">이메일</div>
			</div>
			<c:forEach var="item" items="${list }" varStatus="status">
				<div class="col-12 row desinfo">
					<div class="col-6 col-md-2">${item.id }</div>
					<div class="col-6 col-md-2">${item.name }</div>
					<div class="col-6 col-md-4">${item.phone }</div>
					<div class="col-6 col-md-4">${item.email }</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<br>
	<br>
</body>
<script src="${pageContext.request.contextPath }/adminJS/weatherList.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
</html>