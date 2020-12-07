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
	href="${pageContext.request.contextPath}/adminCSS/createAdmin.css">
<script src="${pageContext.request.contextPath}/adminJS/createAdmin.js"></script>
<title>Pettime Manager</title>
</head>
<body class="col-lg-10" style="margin:auto;">
	<div id="navbar-wrap">
		<%@ include file="adminNav.jsp"%>
	</div>

	<div class="content col-12">
		<div class="col-10 row box">
		<div class="adLogin col-8">
			<h1>관리자 계정 발급</h1>
			<form action="createOk" method="POST">
			<div class="input-box col-12 row">
				<label for="idtext" class="col-3">ID : </label> 
				<input type="text" class="form-control col-6" id="idtext" name="id" maxlength="6" required />
				<button type="button" class="btn btn-primary col-2" onclick="createChk()" id="idchk-btn" disabled>중복체크</button>
				<div class="invalid-feedback" id="id-invalid">아이디는 4~6자
					영문소문자+숫자여야 합니다.</div>
			</div>
			<div class="input-box col-12 row">
				<label for="pwtext" class="col-3">PW : </label> 
				<input type="password" class="form-control col-6" id="pwtext" name="password" maxlength="8" required />
				<div class="invalid-feedback">비밀번호는 6~8자 영문+숫자여야 합니다.</div>
			</div>
			<div class="input-box col-12 row">
				<label for="inputPWCHK" class="col-3">비밀번호 확인 : </label> 
				<input type="password" class="form-control col-6" name="pwchk" id="pwchk" placeholder="비밀번호 확인" maxlength="8" required>
				<div class="invalid-feedback">비밀번호와 일치하지 않습니다.</div>
				 <input type="hidden"
					name="${_csrf.parameterName }" value="${_csrf.token }" />
			</div>
			<button type="submit" class="btn btn-primary col-3" id="signup-btn" disabled>계정 발급</button>
			</form>
			<br>
		</div>
			<div class="col-4 idlist">
				<div><h3>발급한 ID 목록</h3></div>
				<c:forEach var="item" items="${list }">
					<div class="list">${item.id }</div>
				</c:forEach>
			</div>
			</div>
	</div>
</body>
</html>