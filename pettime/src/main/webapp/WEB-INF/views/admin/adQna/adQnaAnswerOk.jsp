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
		alert("답변등록 성공, 게시글을 출력 합니다.");
		location.href = "${pageContext.request.contextPath}/admin/adQna/adQnaView?num=${num}";
	</script>
	</c:otherwise>
</c:choose>
