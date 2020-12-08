function updateProfile(){
	
}


function updatePw(){
	
	
	$("input[name='password']").attr("disabled", false);
	$("input[name='password']").attr("value", '');
	$("input[name='password']").attr("placeholder", '변경한 비밀번호를 입력하세요');
	$("input[name='passwordchk']").attr("disabled", false);
	$("input[name='passwordchk']").attr("value", '');
	$("input[name='passwordchk']").attr("placeholder", '동일하게 입력하세요');
	
	

	
	// password 와 passwordchk 가 같은지 아닌지
	
}



function updateEmail(){
	
	$("input[name='email']").attr("disabled", false);
	$("input[name='email']").attr("value", '');
	$("input[name='email']").attr("placeholder", '변경할 이메일을 입력하세요');
	
	// aaa@aa.aa 구조인지 아닌지(올바른 구조인지 아닌지)
	// var emailCheck = RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
}

function updatePhone(){
	
	$("input[name='phone']").attr("disabled", false);
	$("input[name='phone']").attr("value", '');
	
	// 010 포함하여 10~11자리 
	// var phonNumberCheck = RegExp(/^01[0179][0-9]{7,8}$/);
}




	
	
	
	