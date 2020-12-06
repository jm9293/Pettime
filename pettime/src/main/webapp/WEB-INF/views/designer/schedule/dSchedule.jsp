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
	<link rel="stylesheet" href="${pageContext.request.contextPath }/DesignCSS/dMain.css"/>
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
			<h1>${id } 님의 휴무 일정</h1>
		  	<c:choose>
				<c:when test="${!empty list}">
					<c:forEach var="item" items="${list }">
						<div class="col-12 row resbox reslist">		
							<div class="col-4">휴무 날짜:</div>
							<div class="col-8">${item.holiday}</div>
						</div>
					</c:forEach>
				</c:when>
				<c:otherwise>
					<div class="col-12 row">휴무일이 없습니다.</div>
				</c:otherwise>
			</c:choose>
		 	
		    	
		</article>
		    
		    
	   	<section>
	   		<c:choose>
	   			<c:when test="${!chk }">
	   				<c:choose>
	   					<c:when test="${cnt != 0 }">
	   						<div class="col-12"><p>휴무날 입니다.</p></div>
	   					</c:when>
	   					<c:otherwise>
	   						<div class="col-12"><p>휴무날이 아닙니다.</p></div>
	   					</c:otherwise>
	   				</c:choose>
	   			</c:when>
	   			<c:otherwise>
	   				<c:choose>
	   					<c:when test="${cnt != 0 }">
	   						<div class="col-12 row">
	   							<div class="col-7"><p>휴무 진행예정일 입니다.</p></div>
	   							<button type="button" class="col-5" onclick="location.href='dScheduleCancle?datestr=${datestr}'">휴무 취소</button>
	   						</div>
	   					</c:when>
	   					<c:otherwise>
	   						<div class="col-12 row">
	   							<div class="col-7"><p>휴무날이 아닙니다.</p></div>
	   							<button type="button" class="col-5" onclick="location.href='dScheduleAdd?datestr=${datestr}'">휴무 신청</button>
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