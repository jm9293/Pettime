<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:choose>
	<c:when test="${result == 0 }">
		<script>
			alert("추가 실패 !!!");
			history.back();
			return;
		</script>
	</c:when>
	<c:otherwise>
		<script>
		alert("추가 성공, 목록으로 이동 합니다.");
		location.href = "${pageContext.request.contextPath}/admin/adProduct/adProductlist";
		</script>
	</c:otherwise>
</c:choose>