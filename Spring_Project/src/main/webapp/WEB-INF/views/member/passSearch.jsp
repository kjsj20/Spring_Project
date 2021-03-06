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
<script src="/resources/js/loginSearch.js"></script>
</head>
<body>
	<div class="bg-img">
		<div class="content">
			<header>비밀번호 찾기</header>
			<form id="searchForm">
				<input type="hidden" id="RSAModulus" value="${modulus}" /><!-- 서버에서 전달한값을 셋팅한다. -->
				<input type="hidden" id="RSAExponent" value="${exponent}" /><!-- 서버에서 전달한값을 셋팅한다. -->
				<div class="field">
					<span class="fa fa-user"></span> <input type="text" id="e_mail" name = "e_mail" required
						placeholder="이메일 입력">
				</div>
				<div class="field space">
					<span class="fa fa-phone"></span> <input type="text" onkeyup="enterkey()" id ="phone"
						 name = "phone" class="pass-key" required placeholder="휴대전화번호 입력"> 
				</div>
				<p id="passVal" style="color: #FF6600; margin: 0;"></p>
				<div class="pass" style="float:left;">
					&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/loginForm" >로그인 /&nbsp;</a>
				</div>
				<div class="pass">
					<a href="/idSearchForm"> 이메일 찾기</a>
				</div>
				<div class="field">
					<input class="passSearch" type="button" value="비밀번호 찾기">
				</div><br/>
			</form>
			<div class="signup">
				아직 가입을 안하셨나요? <a href="/">회원가입</a>
			</div>
		</div>
	</div>
</body>
</html>
