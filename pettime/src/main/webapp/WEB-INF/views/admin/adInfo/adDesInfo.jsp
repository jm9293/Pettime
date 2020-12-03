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
		<form name="frm" method="post" action="adDesStatus">
			<input type="hidden" name="num" value="${list[0].num}">
			<div class="col-12 col-md-6 contentBox">
				<div class="col-12">사진?</div>
				<div class="col-12">
					<c:choose>
						<c:when test="${list[0].enabled eq '1'.charAt(0)}">
							<button type="submit">계정 비활성화</button>
						</c:when>
						<c:otherwise>
							<button type="submit">계정 활성화</button>
						</c:otherwise>
					</c:choose>

					<button type="button"
						onclick="location.href='adDesPassword?id=${list[0].id}&email=${list[0].email }'">임시비밀번호
						발급</button>
					<button type="button" onclick="history.back()">목록으로</button>	
				</div>
			</div>
			<div class="col-12 col-md-6 contentBox">
				<div class="col-12 contentType">ID : ${list[0].id }</div>
				<div class="col-12 contentType">NAME : ${list[0].name }</div>
				<div class="col-12 contentType">Email : ${list[0].email }</div>
				<div class="col-12 contentType">Phone : ${list[0].phone }</div>
				<div class="col-12 contentType" id="intro">Intro :
					${list[0].intro }</div>
				<div id="blackChk" class="col-12 contentType">
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
		</form>
	</div>
	<br>
	<br>
</body>
</html>