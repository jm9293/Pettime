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
	href="${pageContext.request.contextPath}/adminCSS/adRes.css">
<title>Pettime Manager</title>
</head>
<body class="col-lg-10" style="margin: auto;">
	<div id="navbar-wrap">
		<%@ include file="adminNav.jsp"%>
	</div>

	<div class="content col-12">
		<div id="myCalender" class="col-12 col-md-6">
			<div class="cal_top">
				<button type="button" id="movePrevMonth">
					<span id="prevMonth" class="cal_tit">&lt;</span>
				</button>
				<span id="cal_top_year"></span> <span id="cal_top_month"></span>
				<button type="button" id="moveNextMonth">
					<span id="nextMonth" class="cal_tit">&gt;</span>
				</button>
			</div>
			<div id="cal_tab" class="cal"></div>
			
		</div>
		<form id="frmList" name="frmList">
		<div id="resList" class="col-12 col-md-6"></div>
		</form>
		<div class="row col-12">
		<div class="row col-6">
			<div class="col-6">선택한 날짜 :</div>
			<div class="col-6"id="choiceday"></div>
		</div>
		<div class="row col-6">
			<button type="button" onclick="deleteList();" id="delete" disabled="disabled">삭제하기</button>
		</div>
		</div>
	</div>
	<br>
	<br>
	<script
		src="${pageContext.request.contextPath }/adminJS/adminCalendar.js"></script>
</body>
</html>