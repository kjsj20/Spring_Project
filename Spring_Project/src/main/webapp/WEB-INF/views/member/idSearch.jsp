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
			<header>아이디찾기</header>
			<form id="searchForm">
				<div class="field">
					<span class="fa fa-user"></span> <input type="text" id="phone_number" name = "phone_number" required
						placeholder="휴대 전화 번호 입력">
				</div>
				<p id="idVal" style="color: #FF6600; margin: 0;"></p>
				<div class="pass" style="float:left;">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/loginForm" >로그인 /&nbsp;</a>
				</div>
				<div class="pass">
					<a href="/passSearchForm"> 비밀번호 찾기</a>
				</div>
				<div class="field">
					<input class="idSearch" type="button" value="ID찾기">
				</div><br/>
			</form>
			<div class="signup">
				아직 가입을 안하셨나요? <a href="/">회원가입</a>
			</div>
		</div>
	</div>
</body>
</html>
