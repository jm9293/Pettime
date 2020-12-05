<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<c:choose>
	<c:when test="${result == 0 }">
	<script>
		alert("생성 실패");
		history.back();
		return;
	</script>
	</c:when>
	<c:otherwise>
	<script>
		alert("계정발급 성공, 목록 페이지로  이동 합니다.");
		location.href = "${pageContext.request.contextPath}/admin/createAdmin";
	</script>
	</c:otherwise>
</c:choose>
