<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
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
<body class="col-lg-10" style="margin:auto;">
	<div id="navbar-wrap">
		<%@ include file="../adminNav.jsp"%>
	</div>
	
	<div class="content col-12">
		<div class="col-6" id="menulist">
			<div class="col-12 row menubar">
				<div class="col-6">메뉴</div>
				<div class="col-6">금액</div>
			</div>
			<c:forEach var="item" items="${list }" varStatus="status">
				<div class="col-12 row menuvalue">
					<div class="col-6 subject_text">${item.subject }</div>
					<div class="col-6 price_text">${item.price }</div>
				</div>
			</c:forEach>
		</div>
		<div class="col-6" id="changelist">
			<div class="col-12 row">
				<div class="col-6">메뉴</div><input type="text" maxlength="20" required name="subject" id="subject" readonly>
				<div class="col-6">금액</div><input type="text" maxlength="20" required name="price" id="price" readonly>
			</div>
			<div class="col-12 row">
				<div><button type="button" onclick="" id="addbtn">추가하기</button></div>
				<div><button type="button" onclick="" id="updatebtn">수정하기</button></div>
				<div><button type="button" onclick="" id="deletebtn">삭제하기</button></div>
			</div>
		</div>
	</div>
</body>
</html>