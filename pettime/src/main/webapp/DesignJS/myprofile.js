var emailStr = null;
var emailId = null;
$(function() {
	$("#imgbtn").change(function() {
		file = $('#imgbtn').prop("files")[0];
		blobURL = window.URL.createObjectURL(file);
		$('#dimg').attr('src', blobURL);
	});
	
	$("#signup-btn").click(function() {
		$(".emailbox2").hide();
		$(".emailbox").show();
		$("#signup-btn").attr("disabled", true);
		$(":input").attr("readonly", false);
	});

	$("#inputEmaildirect").hide();
	$(".emailbox").hide();
	$("#emailSelect").change(function() {
		if ($("#emailSelect").val() === 'direct') {
			$("#emailSelect").hide();
			$("#inputEmaildirect").show();
			$("#inputEmaildirect").keyup();
		}
	})

$("#pwtext").keyup(function() {
	var value = $("#pwtext").val();
	if (/(?=.*[a-zA-Z])(?=.*\d).{6,8}/.test(value)) {
		$("#pwtext").removeClass("is-invalid");
		$("#pwtext").addClass("is-valid");
	} else {
		$("#pwtext").removeClass("is-valid");
		$("#pwtext").addClass("is-invalid");
	}

	validchk();
})

$("#pwchk").keyup(function() {
	var value = $("#pwchk").val();
	if (value === $("#pwtext").val()) {
		$("#pwchk").removeClass("is-invalid");
		$("#pwchk").addClass("is-valid");
	} else {
		$("#pwchk").removeClass("is-valid");
		$("#pwchk").addClass("is-invalid");
	}

	validchk();
})

$("#nametext").keyup(function() {
	var value = $("#nametext").val();
	if (/[가-힣]{2,}/.test(value)) {
		$("#nametext").removeClass("is-invalid");
		$("#nametext").addClass("is-valid");
	} else {
		$("#nametext").removeClass("is-valid");
		$("#nametext").addClass("is-invalid");
	}

	validchk();
})

$("#phonetext").keyup(function() {
	var value = $("#phonetext").val();
	if (/[0-9]{10,11}/.test(value)) {
		$("#phonetext").removeClass("is-invalid");
		$("#phonetext").addClass("is-valid");
	} else {
		$("#phonetext").removeClass("is-valid");
		$("#phonetext").addClass("is-invalid");
	}

	validchk();
})

$("#emailtext").keyup(function() {
		var text = "";
		var address = "";
		var value;
		if ($("#emailSelect").val() !== 'direct') {
			value = $("#emailtext").val() + '@' + $("#emailSelect").val()
		} else {
			value = $("#emailtext").val() + '@' + $("#inputEmaildirect").val()
		}

		if (/[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}/.test(value)) {
			$("#emailtext").removeClass("is-invalid");
			$("#emailtext").addClass("is-valid");
			$("#email-invalid").text("중복확인을 해주세요.");
			$("#emailchk-btn").removeAttr("disabled");
		} else {
			$("#emailtext").removeClass("is-valid");
			$("#emailtext").addClass("is-invalid");
		}

		validchk();
		text = $("#emailtext").val();
		address = $("#emailSelect").val();
		emailChk(text, address);
	})
	
	$("#inputEmaildirect").keyup(function() {
		var value;
		var text = "";
		var address = "";
		value = $("#emailtext").val() + '@' + $("#inputEmaildirect").val()

		if (/[a-z0-9_+.-]+@([a-z0-9-]+\.)+[a-z0-9]{2,4}/.test(value)) {
			$("#inputEmaildirect").removeClass("is-invalid");
			$("#inputEmaildirect").addClass("is-valid");
			$("#emailchk-btn").removeAttr("disabled");
			$("#email-invalid").text("중복확인을 해주세요.");
		} else {
			$("#inputEmaildirect").removeClass("is-valid");
			$("#inputEmaildirect").addClass("is-invalid");
		}

		validchk();
		text += $("#emailtext").val();
		address += $("#inputEmaildirect").val();
		emailChk(text, address);
	})
	
	function emailChk(text, address) {
		var emailId = text;
		var emailAdd = address;
		var email = "";

		email = emailId + '@' + emailAdd;
		console.log(email);
		$("#email").val(email);
	}

	$("#introtext").keyup(function() {
		var value = $("#introtext").val();
		if (value != "") {
			$("#introtext").removeClass("is-invalid");
			$("#introtext").addClass("is-valid");
		} else {
			$("#introtext").removeClass("is-valid");
			$("#introtext").addClass("is-invalid");
		}

		validchk();
	})
	function validchk() {
		var chk = $("#pwtext").hasClass("is-valid")
				&& $("#pwchk").hasClass("is-valid")
				&& $("#nametext").hasClass("is-valid")
				&& $("#phonetext").hasClass("is-valid")
				&& $("#emailtext").hasClass("is-valid")
				&& $("#introtext").hasClass("is-valid")

		if (chk) {
			$("#signup-btn2").removeAttr("disabled");
		} else {
			$("#signup-btn2").attr("disabled", "");
		}
		return chk;
	}
});
function submitchk() {

	$("#idtext").keyup();
	$("#pwtext").keyup();
	$("#pwchk").keyup();
	$("#nametext").keyup();
	$("#phonetext").keyup();
	$("#emailtext").keyup();
	$("#introtext").keyup();

	return validchk();

}
function createChk2() {
	
	var emailAddress = "";
	if ($("#emailSelect").val() !== 'direct') {
		emailId = $("#emailtext").val();
		emailAddress = $("#emailSelect").val().split(".");
	}else{
		emailId = $("#emailtext").val();
		emailAddress = $("#inputEmaildirect").val().split(".");
	}
	emailStr = emailAddress[0].concat(emailAddress[1]);
	checkEmail(emailId);
	console.log(emailId)
	console.log(emailStr)
}
function checkEmail(emailId) {
	$.ajax({
		url : "./desProfile/" + emailId + "/" + emailStr,
		type : "GET",
		cache : false,
		success : function(data, status) {
			if (status == "success") {
				if (chkData2(data)) {}
			}
		}

	});
}

function chkData2(jsonObj) {
	if (jsonObj.status == "OK") {
		if (jsonObj.cnt != 0) {
			alert("중복된 Email 입니다.");
		} else {
			$("#emailtextext").removeClass("is-invalid");
			$("#emailtext").addClass("is-valid");
			$("#emailchk-btn").text("체크완료");
			$("#emailtext").attr("readonly", "");
			$("#emailchk-btn").attr("disabled", "");
		}
	}
}

