<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<c:choose>
	<c:when test="${result == 0 }">
	<script>
		alert("신청 실패");
		history.back();
		return;
	</script>
	</c:when>
	<c:otherwise>
	<script>
		alert("휴무신청 성공, 스케줄 페이지로  이동 합니다.");
		location.href = "${pageContext.request.contextPath }/designer/schedule";
	</script>
	</c:otherwise>
</c:choose>
