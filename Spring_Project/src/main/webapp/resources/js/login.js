$(function(){
	$('.login').click(function(){
		if($('#e_mail').val()== ''){
			alert('이메일을 입력해주세요..');
		} else {
			if($('#password').val()== ''){
				alert('비밀번호를 입력해주세요..');	
			} else{
				login();
			}
		}
	});
});

function login(){
	$.ajax({
		url : "/login",
		type: "POST",
		data: $("#loginForm").serialize(),
		success: function(data){
			if(data == ''){
				$('#idPassChk').text('');
				$('#idPassChk').html("<font color='#FF6600'>이메일 또는 비밀번호가 <br>일치 하지 않습니다.<br> 다시 한번 확인해주세요 </font>");	
			} else {
				location.href = "/";
			}
		},
		error: function(){
			alert('로그인중 에러 발생');
		}
	});
}