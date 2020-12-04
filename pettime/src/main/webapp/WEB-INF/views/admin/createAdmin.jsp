<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	href="${pageContext.request.contextPath}/adminCSS/adLogin.css">
<script src="${pageContext.request.contextPath}/adminJS/createAdmin.js"></script>
<title>Pettime Manager</title>
</head>
<body>
	<div class="wrap">
		<div class="adLogin col-4">
			<form action="createOk" method="POST">
			<div class="input-box col-12">
				<label for="idtext">ID : </label> <input type="text"
					class="form-control" id="idtext" name="id" maxlength="6" required />
				<button type="button" onclick="createChk()" id="idchk-btn" disabled>중복체크</button>
				<div class="invalid-feedback" id="id-invalid">아이디는 4~6자
					영문소문자+숫자여야 합니다.</div>
			</div>
			<div class="input-box col-12">
				<label for="pwtext">PW : </label> <input type="password"
					class="form-control" id="pwtext" name="password" maxlength="8"
					required />
				<div class="invalid-feedback">비밀번호는 6~8자 영문+숫자여야 합니다.</div>
			</div>
			<div class="input-box col-12">
				<label for="inputPWCHK" class="">비밀번호 확인 : </label> <input
					type="password" class="form-control" name="pwchk" id="pwchk"
					placeholder="비밀번호 확인" maxlength="8" required>
				<div class="invalid-feedback">비밀번호와 일치하지 않습니다.</div>
				 <input type="hidden"
					name="${_csrf.parameterName }" value="${_csrf.token }" />
			</div>
			<button type="submit">계정 발급</button>
			</form>
			<button type="button" onclick="location.href=${pageContext.request.contextPath}/admin/adminLogin">취소</button>
		</div>
	</div>
</body>
</html>