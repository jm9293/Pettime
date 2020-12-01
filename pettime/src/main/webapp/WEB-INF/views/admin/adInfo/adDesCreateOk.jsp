<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${result == 0 }">
		<script>
			alert("발급 실패 !!!");
			history.back();
			return;
		</script>
	</c:when>
	<c:otherwise>
		<script>
		alert("발급 성공, 직원 계정을 발급 합니다.");
		location.href = "${pageContext.request.contextPath}/admin/adInfo/adDeslist";
		</script>
	</c:otherwise>
</c:choose>