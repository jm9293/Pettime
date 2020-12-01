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
<title>Pettime Manager</title>
</head>
<body>
	<div class="wrap">
		<div class="adLogin col-4">
			<h1>환영합니다 관리자님!</h1>
			<h3>로그인을 진행해주세요</h3>
			<form action="" method="${pageContext.request.contextPath }/login">
				<input type="text" name="username" required><br> <input
					type="password" name="password" required><br> <input
					type="submit" value="로그인"><br> <input type="hidden"
					name="${_csrf.parameterName }" value="${_csrf.token }" />
			</form>
		</div>
	</div>
</body>
</html>