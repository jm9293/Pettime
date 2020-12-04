<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<c:choose>
	<c:when test="${result == 0 }">
	<script>
		alert("작성 실패");
		history.back();
		return;
	</script>
	</c:when>
	<c:otherwise>
	<script>
		alert("등록 성공, 목록을 출력 합니다.");
		location.href = "${pageContext.request.contextPath}/admin/adNotice/adNoticelist?page=1";
	</script>
	</c:otherwise>
</c:choose>
