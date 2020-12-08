<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${result == 0 }">
		<script>
			alert("메일 발송 실패 !!!");
			history.back();
			return;
		</script>
	</c:when>
	<c:otherwise>
		<script>
		alert("메일 발송 성공, 임시비밀번호를 발급 합니다.");
		location.href = "${pageContext.request.contextPath}/admin/adInfo/adDesInfo?num=${num}";
		</script>
	</c:otherwise>
</c:choose>