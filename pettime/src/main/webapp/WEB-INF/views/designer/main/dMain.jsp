<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/DesignCSS/dMain.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/DesignCSS/calender.css"/>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>디자이너 메인 페이지</title>
</head>
<body class="col-lg-10" style="margin: auto;">

	<div id="navbar-wrap">
		<%@ include file="../DesNav.jsp"%>
	</div>

	<div class="container">
		<header>
			<p class="ct">안녕하세요 ${id } 디자이너님!</p>
			<p class="ct">${datestr } 일의 예약내역 입니다</p>
			<div id="dailySchedule">
				<div class="container">
					<div class="my-calendar clearfix">
						<div class="clicked-date">
							<div class="cal-day"></div>
							<div class="cal-date"></div>
						</div>
					   	<div class="calendar-box">
					    	<div class="ctr-box clearfix">
								<button type="button" title="prev" class="btn-cal prev"></button>
								<span class="cal-month"></span>
								<span class="cal-year"></span>
								<button type="button" title="next" class="btn-cal next"></button>
							</div>
				            <table class="cal-table">
								<thead>
									<tr>
								    	<th>S</th>
								        <th>M</th>
								        <th>T</th>
								        <th>W</th>
								        <th>T</th>
								        <th>F</th>
							         	<th>S</th>
								   </tr>
								</thead>
								<tbody class="cal-body"></tbody>
							</table>
						</div>
					</div>
						  <!-- // .my-calendar -->
				</div>
			</div>
		</header>

		<article>
			<div class="container">
			<div class="box">
			<h4 class="ct">${datestr }일 예약내역</h4><br>
			<c:choose>
				<c:when test="${!empty list}">
					<table>
						<thead>
							<tr>
							<th class="tth">고객 ID</th>
							<th class="tth">예약 날짜</th>
							<th class="tth">펫 이름</th>
							</tr>
						<thead>
						<tbody>
					<c:forEach var="item" items="${list }">
						<tr class="reslist" onclick="location.href='desSearch?num=${item.num}'">		
							<td class="ttd">${item.userId }</td>
							<td class="ttd">${item.stime }</td>
							<td class="ttd">${item.petName }</td>
						</tr>
					</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					<div class="ct">예약이 없습니다.</div>
				</c:otherwise>
			</c:choose>
			</div>
			</div>
		</article>

		<section>
		 <div class="col-12" id="weather">
			<div class="weathertxt col-8">날씨정보</div>
			<div class="weather-box col-4" id="weatherimg"></div>
		</div>
	   	</section>
	 
    </div>
</body>
<script src="${pageContext.request.contextPath }/DesignJS/weatherList.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath }/DesignJS/calender.js"></script>
</html>