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
	href="${pageContext.request.contextPath}/adminCSS/adCreateDes.css">
<title>Pettime Manager</title>
<script>
var idlist = new Array();
var size = ${fn:length(idList)};
console.log(size);
</script>
<c:forEach var="item" items="${idList }">
	<script> idlist[size] = ${item}; </script>
</c:forEach>
</head>
<body class="col-lg-10" style="margin: auto;">
	<div id="navbar-wrap">
		<%@ include file="../adminNav.jsp"%>
	</div>

	<div class="content col-12">
			<div class="col-6 box">
			<h2>직원 계정 생성</h2>
			<br>
		<form method="post" action="adDesCreateOk">
				<div class="input-box col-12 row">
					<label for="idtext" class="col-3">ID : </label> <input type="text"
						class="form-control col-6" id="idtext" name="id" maxlength="6" required />
					<button class="col-2 btn btn-success" type="button" onclick="createChk()" id="idchk-btn" disabled>중복체크</button>
					<div class="invalid-feedback" id="id-invalid">아이디는 4~6자
						영문소문자+숫자여야 합니다.</div>
				</div>
				<br>
				<div class="input-box col-12 row">
					<label for="pwtext" class="col-3">PW : </label> <input type="password"
						class="form-control col-9" id="pwtext" name="password" maxlength="8"
						required />
					<div class="invalid-feedback">비밀번호는 6~8자 영문+숫자여야 합니다.</div>
				</div>
				<br>
				<div class="input-box col-12 row">
					<label for="inputPWCHK" class="col-3">PW 확인 : </label> <input
						type="password" class="form-control col-9" name="pwchk" id="pwchk"
						placeholder="동일한 비밀번호를 입력하세요" maxlength="8" required>
					<div class="invalid-feedback">비밀번호와 일치하지 않습니다.</div>
				</div>
				<br>
				<div class="input-box col-12 row">
					<label for="nametext" class="col-3">Name : </label> <input type="text"
						class="form-control col-9" id="nametext" name="name" maxlength="10"
						required />
					<div class="invalid-feedback">한글 2글자 이상만 입력할수 있습니다.</div>
				</div>
				<br>
				<div class="input-box col-12">
					<label for="emailtext">e-mail : </label>
					<div class="row col-12">
						<input type="text" class="form-control emailf col-3" id="emailtext"
							placeholder="이메일 아이디" maxlength="10" required>
						<div class="at emailg col-1 emaillogo">@</div>
						<select class="custom-select emailb col-5" id="emailSelect">
							<option selected value="gmail.com">gmail.com</option>
							<option value="naver.com">naver.com</option>
							<option value="daum.net">daum.net</option>
							<option value="nate.com">nate.com</option>
							<option value="direct">직접 입력</option>
						</select> <input type="text" class="form-control emailb col-5"
							id="inputEmaildirect" placeholder="" value="직접입력">
						<button class="col-2 btn btn-success" type="button" onclick="createChk2()" id="emailchk-btn"
							disabled>중복체크</button>
						<input type="hidden" id="email" name="email" value=""> <input
							type="hidden" name="enabled" value="1">
						<div class="invalid-feedback" id="email-invalid">이메일
							형식이아닙니다.</div>
					</div>
				</div>
				<br>
				<div class="input-box col-12 row">
					<label for="phonetext" class="col-3">Phone : </label> <input type="text"
						class="form-control col-9" id="phonetext" name="phone" maxlength="11"
						required />
					<div class="invalid-feedback">숫자 10~11자만 입력할수 있습니다.</div>
				</div>
				<br>
				<div class="input-box col-12">
					<label for="introtext">소개글</label>
					<textArea class="form-control" id="introtext" name="intro" rows="5"
						required></textArea>
				</div>
				<br>
				<input type="hidden" value="1" name="enabled">
				<button class="login-btn btn btn-primary emailf" type="submit"
					id="signup-btn" disabled>계정발급</button>
				<button id="off-btn" type="button" class="btn btn-danger emailf"
					onclick="history.back();">취소</button>
				<input type="hidden" name="${_csrf.parameterName }"
					value="${_csrf.token }" />
			</form>
			</div>
	</div>
	<script
		src="${pageContext.request.contextPath}/adminJS/adminDesCreate.js"></script>
</body>
</html>