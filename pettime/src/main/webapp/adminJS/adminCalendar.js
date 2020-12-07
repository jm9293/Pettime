var today = null;
var year = null;
var month = null;
var firstDay = null;
var lastDay = null;
var $tdDay = null;
var $tdSche = null;
var fullstr = "";
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

// calendar 그리기
function drawCalendar() {
	var setTableHTML = "";
	setTableHTML += '<table class="calendar">';
	setTableHTML += '<tr><th>SUN</th><th>MON</th><th>TUE</th><th>WED</th><th>THU</th><th>FRI</th><th>SAT</th></tr>';
	for (var i = 0; i < 6; i++) {
		setTableHTML += '<tr height="100">';
		for (var j = 0; j < 7; j++) {
			setTableHTML += '<td style="text-overflow:ellipsis;overflow:hidden;white-space:nowrap">';
			setTableHTML += '    <div class="cal-day"></div>';
			setTableHTML += '    <div class="cal-schedule"></div>';
			setTableHTML += '</td>';
		}
		setTableHTML += '</tr>';
	}
	setTableHTML += '</table>';
	$("#cal_tab").html(setTableHTML);
}

// 날짜 초기화
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

// calendar 날짜표시
function drawDays() {
	$("#cal_top_year").text(year);
	$("#cal_top_month").text(month);
	for (var i = firstDay.getDay(); i < firstDay.getDay() + lastDay.getDate(); i++) {
		$tdDay.eq(i).text(++dayCount);
	}
	for (var i = 0; i < 42; i += 7) {
		$tdDay.eq(i).css("color", "red");
	}
	for (var i = 6; i < 42; i += 7) {
		$tdDay.eq(i).css("color", "blue");
	}
	for (var i = 0; i < 42; i++) {
		if ($tdDay.eq(i).text()) {
			$("td").eq(i).css("visibility", "visible");
		} else {
			$("td").eq(i).css("visibility", "hidden");
		}
	}
}

// calendar 월 이동
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
		fullstr = yy + "-" + mm + "-" + dd;
		$("#choiceday").text(fullstr);
		loadPage(fullstr);
		var date = moment().format('YYYY-MM-DD');
		var pdate = moment(date).isAfter(fullstr);
		console.log(pdate);
		if(pdate == true){
			$("input[type=checkbox]").css({"display" : "none"});
			$("#delete").attr("disabled", true);
		}
		
	});
});

function loadPage(fullstr) {
	$.ajax({
		// /board/{page}/{pageRows}
		// 현재 /board/rest
		url : "./adRes/" + fullstr,
		type : "GET",
		cache : false,
		success : function(data, status) {
			if (status == "success") {
				// alert("정상적으로 받았쥬?");
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
		if (jsonObj.cnt != 0) {
			$("#change").attr("disabled", false);
			$("#delete").attr("disabled", false);
			var result = "<div class='row col-12 menu'><div class='col-2'>번호</div><div class='col-4'>ID</div><div class='col-6'>예약 시간</div></div>";
			var cnt = jsonObj.cnt;
			var data = jsonObj.data;

			for (var i = 0; i < cnt; i++) {
				result += "<div class='row col-12 resbox2'>";
				result += "<div class='col-2'><input type='checkbox' name='num' value='"+data[i].num+"'>"
						+ (i+1) + "</div>";
				result += "<div class='id col-4' onclick=\"location.href='adResSearch?num="+ data[i].num +"'\">" + data[i].userid + "</div>";
				result += "<div class='time col-6' onclick=\"location.href='adResSearch?num="+ data[i].num +"'\">"+moment(data[i].stime).format('YYYY-MM-DD HH')+"</div>";
				result += "</div>";
			}
			$("#resList").html(result);

		} else {
			$("#resList").html("예약이 없습니다.");
			$("#change").attr("disabled", true);
			$("#delete").attr("disabled", true);
		}

	} else {
		$("#resList").html("서버 통신 문제");
	}
}

function deleteList(){

    var nums = [];  // 빈 배열 준비
	$("input[name=num]").each(function(){
		if($(this).is(":checked")){  // jQuery 에서 check 여부 확인함수
			nums.push(parseInt($(this).val()));  // 배열에 uid 값 추가
			//uids.push($(this).val());  // 숫자 변환 안한 버젼
		}
    });
    
    if(nums.length == 0){
		alert("삭제할 글을 체크해주세요");
	} else {
		if(!confirm(nums.length + "개의 글을 삭제하시겠습니까?")) return false;
		
		var data = $("#frmList").serialize();
		//alert(data);  // uid=10&uid=20   <-- 이런 형태로 출력된다.
        // DELETE 방식
        $.ajax({
            //url : "deleteOk.ajax",
            url : "",
            type : "POST",
            data : data,			
            cache : false,
            success : function(data, status){
                if(status == "success"){
                    if(data.status == "OK"){						
                        alert(data.cnt + "개" + "삭제 성공 ");
                        loadPage(fullstr);  // 현제페이지 로딩
                    } else {
                        alert("DELETE실패 " );
                        return false;
                    }
                }
            }
        });
    } // end if

    return true;

} // end chkDelete()