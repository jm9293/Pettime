<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/DesignCSS/dSchedule.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/DesignCSS/calender.css"/>
<meta charset="UTF-8">
<title>디자이너 스케줄 페이지</title>
</head>
<body>
	<div class="container">
			
		<%@ include file="../dNav.jsp" %><br>
	   
		<header>
			<p class="ct">안녕하세요 ${id } 디자이너님!</p>
			<p class="ct">${datestr2 } 월의 휴무내역 입니다</p>
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
			<h3 class="ct">${id } 님의 휴무 일정</h3><br>
		  	<c:choose>
				<c:when test="${!empty list}">
				<table>
					<tr>
						<th class="tth">휴무 날짜</td>
					</tr>
					<c:forEach var="item" items="${list }">
					<tr>
						<td class="tth">${item.holiday}</td>
					</tr>
					</c:forEach>
				</table>
				</c:when>
				<c:otherwise>
					<div class="ct">휴무일이 없습니다.</div>
				</c:otherwise>
			</c:choose>
		 	
		</div> 	
		</article>
		    
		    
	   	<section>
	   		<c:choose>
	   			<c:when test="${!chk }">
	   				<c:choose>
	   					<c:when test="${cnt != 0 }">
	   						<div class="container">
	   							<p class="ct bdr-rd"><b>${datestr }일은 휴무날 입니다.</b><br><br>
	   									편안하고 행복한 휴일 되세요 ^^</p>
	   						</div>
	   					</c:when>
	   					<c:otherwise>
	   						<div class="container">
	   						<p class="ct bdr-bl"><b>${datestr }일</b><br> 
	   									휴무날이 아닙니다.<br><br>
	   									"오늘 하루 화이팅!"</p>
	   						</div>
	   					</c:otherwise>
	   				</c:choose>
	   			</c:when>
	   			<c:otherwise>
	   				<c:choose>
	   					<c:when test="${cnt != 0 }">
	   						<div class="container">
	   							<div class="ct"><p>${datestr }일은 휴무 진행예정일 입니다.</p></div>
	   							<div class="ct">
	   								<button class="btn btn-outline-danger innerbtn" onclick="location.href='dScheduleCancle?datestr=${datestr}'">휴무 취소</button>
	   							</div>
	   						</div>
	   					</c:when>
	   					<c:otherwise>
	   						<div class="container">
	   							<div class="ct"><p>${datestr }일은 휴무날이 아닙니다.</p></div>
	   							<div class="ct">
	   								<button class="btn btn-outline-success innerbtn" onclick="location.href='dScheduleAdd?datestr=${datestr}'">휴무 신청</button>
	   							</div>
	   						</div>
	   					</c:otherwise>
	   				</c:choose>
	   			</c:otherwise>
	   		</c:choose>
		    	
	   	</section>
	 
    </div>
    
    
    
    
</body>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="${pageContext.request.contextPath }/DesignJS/calender2.js"></script>	

</html>