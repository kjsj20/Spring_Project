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
<script src="/resources/js/login.js"></script>
</head>
<body>
	<div class="bg-img">
		<div class="content">
			<header>로그인</header>
			<form id="loginForm">
				<div class="field">
					<span class="fa fa-user"></span> <input type="text" id="e_mail" name = "e_mail" required
						placeholder="이메일 입력">
				</div>
				<div class="field space">
					<span class="fa fa-lock"></span> <input type="password" id ="password"
						 name = "password" class="pass-key" required placeholder="비밀번호 입력"> <span
						class="show">SHOW</span>
				</div>
				<p id="idPassChk" style="color: #FF6600; margin: 0;"></p>
				<div class="pass">
					<a href="#">비밀번호를 잊으셨나요?</a>
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
