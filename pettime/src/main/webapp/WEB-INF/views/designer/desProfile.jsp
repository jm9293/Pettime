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
	href="${pageContext.request.contextPath}/DesignCSS/desCreateDes.css">	
<script src="${pageContext.request.contextPath}/DesignJS/myprofile.js"></script>
<title>Pettime Designer</title>
</head>
<body class="col-lg-10" style="margin: auto;">

	<div id="navbar-wrap">
		<%@ include file="DesNav.jsp"%>
	</div>
	
	<div class="content col-12">
		<div class="col-6 box">
			<h2>내 정보 수정</h2>
			<br>
		<form method="post" action="desUpdateOk" enctype="multipart/form-data">
			<input type="hidden" name="num" value="${dto.num }">
			<div>
				<img id="dimg" src="${pageContext.request.contextPath}/designerimg/${dto.id}.jpg"/>
				<input id="imgbtn" name="photo" type="file" accept="jpg, jpeg">
			</div>
			<br>
				<div class="input-box col-12 row">
					<label for="pwtext" class="col-3">PW : </label> 
					<input type="password" class="form-control col-9" id="pwtext" name="password" maxlength="8"
						required readonly/>
					<div class="invalid-feedback">비밀번호는 6~8자 영문+숫자여야 합니다.</div>
				</div>
				<br>
				<div class="input-box col-12 row">
					<label for="inputPWCHK" class="col-3">PW 확인 : </label> <input
						type="password" class="form-control col-9" name="pwchk" id="pwchk"
						placeholder="동일한 비밀번호를 입력하세요" maxlength="8" required readonly>
					<div class="invalid-feedback">비밀번호와 일치하지 않습니다.</div>
				</div>
				<br>
				<div class="input-box col-12 row">
					<label for="nametext" class="col-3">Name : </label> <input type="text"
						class="form-control col-9" id="nametext" name="name" maxlength="10" value="${dto.name }"
						required readonly/>
					<div class="invalid-feedback">한글 2글자 이상만 입력할수 있습니다.</div>
				</div>
				<br>
				<div class="input-box col-12">
				<label for="emailtext2" class="emailbox2">기존 e-mail : </label>
				<div class="row col-12 emailbox2">
					<input type="text" class="form-control emailf col-12" id="emailtext2" value="${dto.email }" readonly>
				</div>
					<label for="emailtext">e-mail : </label>
					<div class="row col-12 emailbox">
						<input type="text" class="form-control emailf col-4" id="emailtext"
							placeholder="이메일 아이디" maxlength="10" required readonly>
						<div class="at emailg col-1 emaillogo">@</div>
						<select class="custom-select emailb col-4" id="emailSelect">
							<option selected value="gmail.com">gmail.com</option>
							<option value="naver.com">naver.com</option>
							<option value="daum.net">daum.net</option>
							<option value="nate.com">nate.com</option>
							<option value="direct">직접 입력</option>
						</select> <input type="text" class="form-control emailb col-5"
							id="inputEmaildirect" placeholder="" value="직접입력">
						<button class="col-2 btn btn-success" type="button" onclick="createChk2()" id="emailchk-btn"
							disabled>중복체크</button>
						<input type="hidden" id="email" name="email" value=""> 
						<div class="invalid-feedback" id="email-invalid">이메일
							형식이아닙니다.</div>
					</div>
				</div>
				<br>
				<div class="input-box col-12 row">
					<label for="phonetext" class="col-3">Phone : </label> <input type="text"
						class="form-control col-9" id="phonetext" name="phone" maxlength="11" value="${dto.phone }"
						required readonly/>
					<div class="invalid-feedback">숫자 10~11자만 입력할수 있습니다.</div>
				</div>
				<br>
				<div class="input-box col-12">
					<label for="introtext">소개글</label>
					<textArea class="form-control" id="introtext" name="intro" rows="5"
						required readonly>${dto.intro }</textArea>
				</div>
				<br>
				<button class="login-btn btn btn-primary emailf" type="button"
					id="signup-btn">정보 수정 하기</button>
				<button class="login-btn btn btn-primary emailf" type="submit"
					id="signup-btn2" disabled>정보 수정 완료</button>
				<input type="hidden" name="${_csrf.parameterName }"
					value="${_csrf.token }" />
			</form>
			<br><br>
			</div>
	</div>
	
</body>
</html>