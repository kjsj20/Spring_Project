$(function() {
	$('#signUpUser').click(function() {
		if ($('#e_mail').val() == '') {
			alert('이메일을 입력해 주세요..');
		} else {
			if ($('#phone').val() == '') {
				alert('휴대전화 번호를 입력해 주세요..');
			} else {
				if ($('#birth_date').val() == '') {
					alert('생년월일을 입력해 주세요..');
				} else {
					if ($('#user_name').val() == '') {
						alert('이름을 입력해주세요..')
					} else {
						if ($('#password').val() == '') {
							alert('비밀번호를 입력해주세요..');
						} else {
							if ($('#passwordConfirm').val() == '') {
								alert('비밀번호 확인을 입력해주세요..');
							} else {
								if ($('#password').val() != $('#passwordConfirm').val()) {
									$('#pwCheck').text('');
									$('#pwCheck').html("비밀번호 확인이 일치하지 않습니다.");
								} else {
									$('#pwCheck').text('');
									$('#signUpComplete').text('');
									$('#signUpComplete').html("<font color='#70AD47'>잠시만 기다려 주세요. <br>처리 중입니다..</font>");
									$('#signUpUser').attr('disabled', true);
									signUp();
								}
							}
						}
					}
				}
			}
		}
	});
});

function signUp() {
	$.ajax({
		url: "/member/signup",
		type: "POST",
		data: $(".signup-form").serialize(),
		success: function(data){
			console.log(data);
			if(data == 0){
				$('#signUpComplete').html("<font color='#1263CE'>회원님의 메일로 인증메일을 발송 하였습니다. <br> 인증 완료후 로그인 해주세요.</font>");
			} else {
				$('#signUpComplete').html("<font color='#FF6600'>이미 중복된 아이디 입니다.. <br> 다시 한번 확인해주세요.. </font>");
			}
			$('#signUpUser').attr('disabled', false);
		},
		error: function(){
			alert('회원가입 에러 발생');
			$('#signUpComplete').html("<font color='#FF6600'>가입중 에러가 발생하였습니다. <br> 고객센터에 문의해 주세요. </font>");
			$('#signUpUser').attr('disabled', false);
		}
	});
	
	/*$('.signup-form').attr({
		action: "/member/signup",
		method: "POST"
	});
	$('.signup-form').submit();*/
}

