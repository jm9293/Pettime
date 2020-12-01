var today = null;
var year = null;
var month = null;
var firstDay = null;
var lastDay = null;
var $tdDay = null;
var $tdSche = null;

$(document).ready(function() {
	drawCalendar();
	initDate();
	drawDays();
	$("#movePrevMonth").on("click", function() {
		movePrevMonth();
	});
	$("#moveNextMonth").on("click", function() {
		moveNextMonth();
	});
});

//calendar 그리기
function drawCalendar(){
    var setTableHTML = "";
    setTableHTML+='<table class="calendar">';
    setTableHTML+='<tr><th>SUN</th><th>MON</th><th>TUE</th><th>WED</th><th>THU</th><th>FRI</th><th>SAT</th></tr>';
    for(var i=0;i<6;i++){
        setTableHTML+='<tr height="100">';
        for(var j=0;j<7;j++){
            setTableHTML+='<td style="text-overflow:ellipsis;overflow:hidden;white-space:nowrap">';
            setTableHTML+='    <div class="cal-day"></div>';
            setTableHTML+='    <div class="cal-schedule"></div>';
            setTableHTML+='</td>';
        }
        setTableHTML+='</tr>';
    }
    setTableHTML+='</table>';
    $("#cal_tab").html(setTableHTML);
}

//날짜 초기화
function initDate() {
	$tdDay = $("td div.cal-day")
	$tdSche = $("td div.cal-schedule")
	dayCount = 0;
	today = new Date();
	year = today.getFullYear();
	month = today.getMonth() + 1;
	firstDay = new Date(year, month - 1, 1);
	lastDay = new Date(year, month, 0);
}

//calendar 날짜표시
function drawDays(){
    $("#cal_top_year").text(year);
    $("#cal_top_month").text(month);
    for(var i=firstDay.getDay();i<firstDay.getDay()+lastDay.getDate();i++){
        $tdDay.eq(i).text(++dayCount);
    }
    for(var i=0;i<42;i+=7){
        $tdDay.eq(i).css("color","red");
    }
    for(var i=6;i<42;i+=7){
        $tdDay.eq(i).css("color","blue");
    }
    for(var i = 0; i < 42; i++){
    	if($tdDay.eq(i).text()){
    		$("td").eq(i).css("visibility", "visible");
    	}else{
    		$("td").eq(i).css("visibility", "hidden");
    	}
    }
}

//calendar 월 이동
function movePrevMonth() {
	month--;
	if (month <= 0) {
		month = 12;
		year--;
	}
	if (month < 10) {
		month = String("0" + month);
	}
	getNewInfo();
}

function moveNextMonth() {
	month++;
	if (month > 12) {
		month = 1;
		year++;
	}
	if (month < 10) {
		month = String("0" + month);
	}
	getNewInfo();
}

function getNewInfo() {
	for (var i = 0; i < 42; i++) {
		$tdDay.eq(i).text("");
	}
	dayCount = 0;
	firstDay = new Date(year, month - 1, 1);
	lastDay = new Date(year, month, 0);
	drawDays();
}

$(function() {
	$("td").click(function() {
		var yy = $("#cal_top_year").text();
		var mm = $("#cal_top_month").text();
		var dd = $(this).text().trim();
		if (dd < 10) {
			dd = "0" + dd;
		}
		var fullstr = yy + "-" + mm + "-" + dd;
		$("#choiceday").text(fullstr);
		loadPage(fullstr);
	});
});

function loadPage(fullstr) {
	$.ajax({
		//   /board/{page}/{pageRows}
		//   현재  /board/rest
		url : "./adRes/" + fullstr,
		type : "GET",
		cache : false,
		success : function(data, status) {
			if (status == "success") {
				//alert("정상적으로 받았쥬?");
				if (updateList(data)) {
					// 화면 업데이트 후, 페이지 정보 업데이트 

					// 업데이트된 list 의 이벤트 동작...

				}

			}
		}

	});
}
function updateList(jsonObj) {

	if (jsonObj.status == "OK") {
		if(jsonObj.cnt !=0){
		var result = "";
		var cnt = jsonObj.cnt;
		var data = jsonObj.data;
		
		for (var i = 0; i < cnt; i++) {
			result += "<div class='id'>" + data[i].userid + "</div>";
			result += "<div class='stime'>" + moment(data[i].stime).format('YYYY-MM-DD') + "</div>";
			result += "<div class='address'>" + data[i].address + "</div>";
		}
		$("#resList").html(result);
		
	}else{
		$("#resList").html("예약이 없습니다.");
	}
		
		
	} else {
		$("#resList").html("서버 통신 문제");
	}
}