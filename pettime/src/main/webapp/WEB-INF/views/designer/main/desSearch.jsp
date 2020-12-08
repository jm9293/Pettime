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
	href="${pageContext.request.contextPath}/DesignCSS/desBasic.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/DesignCSS/desResSearch.css">
<title>Pettime Designer</title>
</head>
<body class="col-lg-10" style="margin: auto;">

	<div id="navbar-wrap">
		<%@ include file="../DesNav.jsp"%>
	</div>
	
	<div class="content col-12">
		<div class="col-8 cbox">
			<div class="col-12 box"><h1>예약 정보</h1></div>
			<br>
			<div class="col-12 row box">
			<div class="col-4 menu">고객ID:</div>
			<div class="col-8 subject">${dto.userId }</div>
			</div>
			<br>
			<div class="col-12 row box">
			<div class="col-4 menu">담당 미용사:</div>
			<div class="col-8 subject">${dto.degId }</div>
			</div>
				<br>
			<div class="col-12 row box">
			<div class="col-4 menu">예약 일자:</div>
			<div class="col-8 subject">${date }</div>
			</div>
				<br>
			<c:choose>
				<c:when test="${dto.address ne '방문' }">
				<div class="col-12 row box">
					<div class="col-4 menu">주소:</div>
					<div class="col-8 subject">${dto.address }</div>
				</div>
				<br>
				</c:when>
				<c:otherwise>
				<div class="col-12 row box">
					<div class="col-12 visit">매장 방문</div>
				</div>
				<br>
				</c:otherwise>
			</c:choose>
			<div class="col-12 row box">
			<div class="col-4 menu">주소:</div>
			<div class="col-8 subject">${dto.address }</div>
			</div>
				<br>
			<div class="col-12 row box">
			<div class="col-4 menu">견명:</div>
			<div class="col-8 subject">${dto.petName }</div>
			</div>
				<br>
			<div class="col-12 row box">
			<div class="col-4 menu">견종:</div>
			<div class="col-8 subject">${dto.petKind }</div>
			</div>
				<br>
			<c:if test="${dto.address ne '방문' }">
				<div class="col-12 row box">
					<div class="col-4 menu menu2">출장 비용:</div>
					<div class="col-8 subject">30,000 원</div>
				</div>
				<br>
			</c:if>
			<c:forEach var="item" items="${list }">
			<div class="col-12 row box">
			<div class="col-4 menu menu2">항목:</div>
			<div class="col-8 subject">${item.content }</div>
			</div>
				<br>
			<div class="col-12 row box">
			<div class="col-4 menu menu2">금액:</div>
			<div class="col-8 subject">${item.price }</div>
			</div>
				<br>
			</c:forEach>
			<div class="col-12 row box">
			<div class="col-4 menu">예약 메모:</div>
			<div class="col-8 subject">${dto.petMemo }</div>
			</div>
				<br>
			<div class="col-12 row box">
			<div class="col-4 menu">처리상태:</div>
			<div class="col-8 subject">${dto.state }</div>
			</div>
			<br>
		</div>
		<div class="col-8 row btnbox">
			<c:choose>
				<c:when test="${dto.state eq '결제완료'}">
					<button class="btn btn-primary" id="resultOk" type="button" onclick="location.href='desResResultOk?num=${dto.num}'">처리완료</button>
				</c:when>
				<c:otherwise>
					<button class="btn btn-primary" id="resetOk" type="button" onclick="location.href='desResResetOk?num=${dto.num}'">처리취소</button>
				</c:otherwise>
			</c:choose>
			<button class="btn btn-dark" id="back" type="button" onclick="location.href='${pageContext.request.contextPath}/designer/main'">돌아가기</button>
		</div>	
	</div>

</body>
</html>

