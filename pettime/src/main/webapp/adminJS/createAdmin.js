$(function() {

	$("#idtext").keyup(
			function() {
				var value = $("#idtext").val();
				if (/[a-z0-9]{4,6}/.test(value) && /[a-z]/.test(value)
						&& /[0-9]/.test(value)) {

					$("#idtext").addClass("is-invalid");
					$("#id-invalid").text("중복확인을 해주세요.");
					$("#idchk-btn").removeAttr("disabled");
				} else {

					$("#id-invalid").text("아이디는 4~6자 영문소문자+숫자여야 합니다.");
					$("#idtext").addClass("is-invalid");
					$("#idchk-btn").attr("disabled", "");
				}

				validchk();
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
	function validchk() {
		var chk = $("#idtext").hasClass("is-valid")
				&& $("#pwtext").hasClass("is-valid")
				&& $("#pwchk").hasClass("is-valid")

		if (chk) {
			$("#signup-btn").removeAttr("disabled");
		} else {
			$("#signup-btn").attr("disabled", "");
		}
		return chk;
	}

});

function submitchk() {

	$("#idtext").keyup();
	$("#pwtext").keyup();
	$("#pwchk").keyup();
	return validchk();
}
function createChk() {
	var text = $("#idtext").val();
	checkId(text);
}
function checkId(text) {
	$.ajax({
		url : "./createAdmin/" + text,
		type : "GET",
		cache : false,
		success : function(data, status) {
			if (status == "success") {
				if (chkData(data)) {}
			}
		}

	});
}

function chkData(jsonObj) {
	if (jsonObj.status == "OK") {
		if (jsonObj.cnt != 0) {
			alert("중복된 ID 입니다.");
		} else {
			$("#idtext").removeClass("is-invalid");
			$("#idtext").addClass("is-valid");
			$("#idchk-btn").text("체크완료");
			$("#idtext").attr("readonly", "");
			$("#idchk-btn").attr("disabled", "");
		}
	}
}