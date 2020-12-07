<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/DesignCSS/dProfile.css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath }/DesignJS/myprofile.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<%@ include file="../dNav.jsp" %><br>
	
		
		<div class="frame ct">
		<form action="updateProfile" method="post">
			<input type="hidden" name="${_csrf.parameterName }"
					value="${_csrf.token }" />
			<input type="hidden" name="num"	value="${dto.num }" />		
			<table>
				<tr>
					<td>상태  </td>
					<td>
						<input name="enabled" value="${dto.enabled }" readonly/>
					</td>
				</tr>
				<tr>
					<td class="">비밀번호 변경  </td>
					<td>
						<input type="password" name="password" value="${dto.password }" readonly/>
					</td>
					<td>
						<a class="btn btn-outline-info" onclick="updatePw()">수정</a>					
					</td>
				</tr>
				<tr>
					<td class="">비밀번호 확인  </td>
					<td>
						<input type="password" name="passwordchk" value="${dto.password }" readonly/>
					</td>
				</tr>
				<tr>
					<td>이름  </td>
					<td><input type="text" name="name" value="${dto.name}" readonly/></td>
				</tr>
				<tr>
					<td>이메일  </td>
					<td><input type="text" name="email" value="${dto.email }" readonly/></td>
					<td>
						<a class="btn btn-outline-info" onclick="updateEmail()">수정</a>					
					</td>
				</tr>
				<tr>
					<td>연락처  </td>
					<td><input type="text" name="phone" value="${dto.phone }" readonly/></td>
					<td>
						<a class="btn btn-outline-info" onclick="updatePhone()">수정</a>					
					</td>
				</tr>
				<tr>
					<td>자기소개 </td>
					<td>
						<textarea name="intro">${dto.intro }</textarea>
					</td>
				</tr>
			</table><br>
			

			<button class="btn btn-outline-danger innerbtn" type="submit">수정완료</button>
		</form>	
		</div>
		
		
		
	
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"
   integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
   crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>