<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input type="date" id="cal" onchange="gDate()"/>
	
	<script>
        
        function gDate()  {
            const dt = document.getElementById('cal').value;
            document.getElementById("result").innerText = dt;
        }

    </script>
    <div id="result"></div>
    <br><br>
    <div style="border: 1px solid black; width: 200px; height: 100px;">
		<c:forEach var="dao" items="${list }"> <!-- var = "변수명" ,items = "목록 데이터" --> 	
			<div id="bbd">${dao.holiday }</div>		
		</c:forEach>
    </div>
    
    
    
    <div id="bb"></div>
    <script>
    	
    const bb = document.getElementById('bbd').value;
    	document.getElemetById("resultB").innerText = bb;
    
    </script>
    
    
    <button onclick="btn()">버튼</button>
    
    <script>
    function btn(){
    	
    }

    </script>
    <br>
    
    <div id="final" style="border: 1px solid black; width: 200px; height: 100px;"></div>
    
    
    
    
    
    
    
    
    
    
</body>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" 
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</html>