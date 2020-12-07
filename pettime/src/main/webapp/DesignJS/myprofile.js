function updateProfile(){
	
}


function updatePw(){
	
	$("input[name='password']").attr("readonly", false);
	$("input[name='password']").attr("value", '');
	$("input[name='password']").attr("placeholder", '변경한 비밀번호를 입력하세요');
	$("input[name='passwordchk']").attr("readonly", false);
	$("input[name='passwordchk']").attr("value", '');
}



function updateEmail(){
	
	$("input[name='email']").attr("readonly", false);
	$("input[name='email']").attr("value", '');
	$("input[name='email']").attr("placeholder", '변경할 이메일을 입력하세요');
	
	
}

function updatePhone(){
	
	$("input[name='phone']").attr("readonly", false);
	$("input[name='phone']").attr("value", '010');
}



