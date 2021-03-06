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
	href="${pageContext.request.contextPath}/adminCSS/adDesInfo.css">
<title>Pettime Manager</title>
</head>
<body class="col-lg-10" style="margin:auto;">
	<div id="navbar-wrap">
		<%@ include file="../adminNav.jsp"%>
	</div>

	<div class="content col-12">
	<h1>직원 정보</h1>
		<form name="frm" method="post" action="adDesStatus">
			<input type="hidden" name="num" value="${list[0].num}">
			<div class="col-12 col-md-6 contentBox"><img id="imgbox" src="${pageContext.request.contextPath}/designerimg/${list[0].id }.jpg"/></div>
			<div class="col-12 col-md-6 contentBox">
				<div class="col-12 contentType bg-light">ID : ${list[0].id }</div>
				<br>
				<div class="col-12 contentType bg-light">NAME : ${list[0].name }</div>
				<br>
				<div class="col-12 contentType bg-light">Email : ${list[0].email }</div>
				<br>
				<div class="col-12 contentType bg-light">Phone : ${list[0].phone }</div>
				<br>
				<div class="col-12 contentType bg-light" id="intro">Intro :
					${list[0].intro }</div>
					<br>
				<div id="blackChk" class="col-12 contentType bg-light">
					<c:choose>
						<c:when test="${list[0].enabled eq '1'.charAt(0)}">	
						직원분류 : 정상 계정 입니다.
						</c:when>
						<c:otherwise>
						직원분류 : 비활성화 계정 입니다.
						</c:otherwise>
					</c:choose>
				</div>
			</div>
			<input type="hidden"
					name="${_csrf.parameterName }" value="${_csrf.token }" />
			<div class="col-12 btnbox row">
					<c:choose>
						<c:when test="${list[0].enabled eq '1'.charAt(0)}">
							<button class="btn btn-dark" type="submit">계정 비활성화</button>
						</c:when>
						<c:otherwise>
							<button class="btn btn-light" type="submit">계정 활성화</button>
						</c:otherwise>
					</c:choose>

					<button type="button" class="btn btn-success"
						onclick="location.href='adDesPassword?id=${list[0].id}&email=${list[0].email }&num=${list[0].num }'">임시비밀번호
						발급</button>
					<button type="button" class="btn btn-primary" onclick="history.back()">목록으로</button>	
				</div>
		</form>
	</div>
	<br>
	<br>
</body>
</html>