<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="${pageContext.request.contextPath }/DesignCSS/dMain.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/DesignCSS/calender.css"/>
		

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>디자이너 메인 페이지</title>
</head>
<body>
	<div class="container">
			
		<%@ include file="../dNav.jsp" %><br>
	   
		<header>
			<p class="ct">안녕하세요 이승원 디자이너님!</p>
			<p class="ct">${datestr }입니다</p>
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
		  	
		 	${date}<br>
		  	${datestr}
		    	
		</article>
		    
		    
	   	<section>날씨 api
		    	
	   	</section>
	 
    </div>
</body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" 
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
			<script src="${pageContext.request.contextPath }/DesignJS/calender.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>