<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String mypage = request.getParameter("mypage");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>CoCo!</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@ include file="../lecture/inc/header.jsp"%>
<link rel="stylesheet" href="/resources/css/mypage.css">
<script src="/resources/js/mypage.js"></script>
<style>

</style>
</head>
<body>
	<%@ include file="../lecture/inc/nav.jsp"%>
	<%
	if (session.getAttribute("member") == null) {//세션에 담겨진 데이터가 없다면
	%>
	<script>
		alert('접근할 수 없습니다');
		history.back();
	</script>
	<%
	}
	%>
	<!-- END nav -->
	<input id="mypage_num" type="hidden" value="<%=mypage %>" />
	<section class="hero-wrap hero-wrap-2"
		style="background-image: url('/resources/images/work-5.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-end justify-content-center">
				<div class="col-md-9 ftco-animate pb-5 text-center">
					<p class="breadcrumbs">
						<span class="mr-2"><a href="index.html">Home <i
								class="fa fa-chevron-right"></i></a></span> <span>My page <i
							class="fa fa-chevron-right"></i></span>
					</p>
					<h1 class="mb-0 bread">My Page</h1>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 sidebar">

					<div class="sidebar-box bg-white p-4 ftco-animate">
						<label id="mypage1" class="mypage" style="cursor: pointer;"> 내 정보 </label><br> 
					</div>
				</div>
				<div class="col-lg-9">
					<div class="row">
						<h2 style="font-weight:bold; margin-left: 4px;">내 정보</h3>
						<div class="containerTb">
							<form id="myPageForm">
								<input id="member_id" type="hidden" name="member_id" value="<%=member.getMember_id() %>" />
								<input type="text" id="fname" name="user_name" placeholder="이름" value="<%=member.getUser_name()%>"><input id="nameEdit" type="button" value="수정">
								<input type="text" id="lname" value="<%=member.getE_mail()%>" style = "width:100%;" readonly>
								<input type="password" id="lname" name="password" placeholder="비밀번호" value=""><input id="passEdit" type="button" value="수정">
								<input type="text" id="lname" name="phone" placeholder="휴대전화" value="<%=member.getPhone()%>"><input id="phoneEdit" type="button" value="수정">
								<input type="text" id="lname" name="birth_date" placeholder="생년월일" value="<%=member.getBirth_date()%>"><input id="birthEdit" type="button" value="수정">
								<input id="delMember" class="<%=member.getMember_id() %>" type="button" style="margin-left:0px; width:16%;" value="회원탈퇴">
							</form>
						</div>
					</div>
				</div>
			</div>
	</section>
	<%@ include file="../lecture/inc/footer.jsp"%>
	<script>
		$(function() {
			$('#mypage' + $('#mypage_num').val()).addClass('active');
		});
	</script>
</body>
</html>