<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${cnt == 0 }">
		<script>
			alert("수정 실패 !!!");
			history.back();
			return;
		</script>
	</c:when>
	<c:otherwise>
		<script>
		alert("수정 성공, 계정 정보를 변경 합니다.");
		location.href = "${pageContext.request.contextPath}/admin/adInfo/adDesInfo?num=${num }";
		</script>
	</c:otherwise>
</c:choose>