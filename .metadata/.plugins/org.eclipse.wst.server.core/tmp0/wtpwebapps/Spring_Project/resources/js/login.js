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

//엔터키를 눌렀을때 로그인 버튼이 먹도록 설정
function enterkey(){
	if(window.event.keyCode == 13){
		login();
	}
}

// RSA 적용 로그인 공개키 값을받아서 확인 후 e_mail과 password 를 암호화 하여 Controller에게 넘긴다
function login(){
	var $e_mail = $("#hiddenForm input[name='e_mail']");
	var $password = $("#hiddenForm input[name='password']");
	
	 // Server로부터 받은 공개키 입력
    var rsa = new RSAKey();
    rsa.setPublic($("#RSAModulus").val(), $("#RSAExponent").val());	
    
	var e_mail = $("#loginForm").find("#e_mail").val();
    var password = $("#loginForm").find("#password").val();
	
	console.log(e_mail);
	console.log(password);
	
	$e_mail.val(rsa.encrypt(e_mail)); // 아이디 암호화
    $password.val(rsa.encrypt(password)); // 비밀번호 암호화

		
	$.ajax({
		url : "/login",
		type: "POST",
		data: $("#hiddenForm").serialize(),
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