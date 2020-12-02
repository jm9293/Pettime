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
	href="${pageContext.request.contextPath}/adminCSS/adUserlist.css">
<title>Pettime Manager</title>
</head>
<body class="col-lg-10" style="margin:auto;">
	<div id="navbar-wrap">
		<%@ include file="../adminNav.jsp"%>
	</div>

	<div class="content col-12">
		<div class="col-12 searchbox">
			<form action="adUserlistSearch" method="post">
				<div class="col-3 col-md-2">
					<button type="submit" id="searchbtn"
						class="form-control col-12 btn btn-success btn-sm">검색</button>
				</div>
				<div class="col-5">
					<input class="col-12 form-control" type="text" name="text" value="${text }"/>
				</div>
				<div class="col-4 col-md-3">
					<select class="col-12 form-control" name="selectMenu">
						<option value="id_sch" id="id_sch" <c:if test="${select eq 'id_sch' }">selected</c:if>>ID검색</option>
						<option value="name_sch" id="name_sch" <c:if test="${select eq 'name_sch' }">selected</c:if>>이름검색</option>
					</select>
				</div>
			</form>
		</div>
		<br>
		<br>
		<br>
		<div class="row col-12 menu">
			<div class="col-3">등록ID</div>
			<div class="col-4">이름</div>
			<div class="col-5">email</div>
		</div>
		<!-- for문 돌려서 가져오기 -->
		<c:forEach var="list" items="${list }">
			<div class="row col-12 subject"
				onclick="location.href='${pageContext.request.contextPath}/admin/adInfo/adUserInfo?userNum=${list.userNum }'">
				<div class="col-3">${list.id }</div>
				<div class="col-4">${list.name }</div>
				<div class="col-5">${list.email }</div>
			</div>
		</c:forEach>
	</div>
	<br>
	<br>
</body>
</html>