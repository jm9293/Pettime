<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/DesignCSS/dMain.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/DesignCSS/deslogin.css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>애견디자이너 로그인 페이지</title>
</head>
<body>
		<div class="col-4 mx-auto" style="padding-top: 200px">
			<form method="post" action="loginOk">
				<h1 style="text-align: center;">Pettime Designer</h1>
				<h3>안녕하세요 디자이너님~!</h3>
				<h4>오늘도 활기찬 하루가 되시길 바랍니다~!^^</h4>
				<h6 style="text-align: center;">${msg}</h6><br>
				<div class="form-group">
					<input type="text" class="form-control" placeholder="아이디" id="id" name="username" maxlength="20">
				</div>
				<div class="form-group">
					<input type="password" name="password"  class="form-control" placeholder="비밀번호" imaxlength="20">
				</div>
				<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
				<input type="submit" class="btn btn-outline-secondary form-control" value="로그인">
			</form>
		</div>
</body>
</html>