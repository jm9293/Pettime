<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${result == 0 }">
		<script>
			alert("처리 실패 !!!");
			history.back();
			return;
		</script>
	</c:when>
	<c:otherwise>
		<script>
		alert("처리 성공, 상세페이지로 이동 합니다.");
		location.href = "${pageContext.request.contextPath}/admin/adResSearch?num=${num}";
		</script>
	</c:otherwise>
</c:choose>