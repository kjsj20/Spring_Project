<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Created By CodingNepal -->
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<!-- Somehow I got an error, so I comment the title, just uncomment to show -->
<!-- <title>Transparent Login Form UI</title> -->
<link rel="stylesheet" href="/resources/css/loginForm.css">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- javascript lib load -->
	<script src="/resources/js/rsa/rsa.js"></script>
	<script src="/resources/js/rsa/jsbn.js"></script>
	<script src="/resources/js/rsa/prng4.js"></script>
	<script src="/resources/js/rsa/rng.js"></script>
	<script src="/resources/js/login.js"></script>
</head>
<body>
	<div class="bg-img">
		<div class="content">
			<header>로그인</header>
			<form id="loginForm">
				<input type="hidden" id="RSAModulus" value="${modulus}" /><!-- 서버에서 전달한값을 셋팅한다. -->
				<input type="hidden" id="RSAExponent" value="${exponent}" /><!-- 서버에서 전달한값을 셋팅한다. -->
				<div class="field">
					<span class="fa fa-user"></span> <input type="text" id="e_mail" name = "e_mail" required
						placeholder="이메일 입력">
				</div>
				<div class="field space">
					<span class="fa fa-lock"></span> <input type="password" onkeyup="enterkey()" id ="password"
						 name = "password" class="pass-key" required placeholder="비밀번호 입력"> <span
						class="show">SHOW</span>
				</div>
				<p id="idPassChk" style="color: #FF6600; margin: 0;"></p>
				<div class="pass" style="float:left;">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/idSearchForm" >이메일 찾기 /&nbsp;</a>
				</div>
				<div class="pass">
					<a href="/passSearchForm"> 비밀번호 찾기</a>
				</div>
				<div class="field">
					<input class="login" type="button" value="로그인">
				</div>
			</form>
			<div class="loginWith">Or login with</div>
			<div class="links">
				<div class="facebook">
					<i class="fab fa-facebook-f"><span>Facebook</span></i>
				</div>
				<div class="instagram">
					<i class="fab fa-instagram"><span>Instagram</span></i>
				</div>
			</div>
			<div class="signup">
				아직 가입을 안하셨나요? <a href="/">회원가입</a>
			</div>
		</div>
	</div>
	
	<!-- 실제 서버로 전송되는 form -->
	<form id="hiddenForm">
	        <input type="hidden" name="e_mail" />
	        <input type="hidden" name="password" />
	</form>

	<script>
      const pass_field = document.querySelector('.pass-key');
      const showBtn = document.querySelector('.show');
      showBtn.addEventListener('click', function(){
       if(pass_field.type === "password"){
         pass_field.type = "text";
         showBtn.textContent = "HIDE";
         showBtn.style.color = "#3498db";
       }else{
         pass_field.type = "password";
         showBtn.textContent = "SHOW";
         showBtn.style.color = "#222";
       }
      });
    </script>
</body>
</html>
