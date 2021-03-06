$(function(){
	$('#nameEdit').click(function(){
		nameEdit();
	});	
	$('#passEdit').click(function(){
		passEdit();
	});	
	$('#phoneEdit').click(function(){
		phoneEdit();
	});	
	$('#birthEdit').click(function(){
		birthEdit();
	});	
	$('#delMember').click(function(){
		if(confirm('정말 삭제하시겠습니까 ?')){
			if(confirm('후회하지 않으십니까 ?')){
				delMember(this.className);
			}
		}
	});	
});
//멤버 이름 수정
function nameEdit(){
	$.ajax({
		url: "/mypage/nameEdit",
		type: "POST",
		data: $('#myPageForm').serialize(),
		success: function(data) {
				if(data == 0){
					alert('이름 수정 실패');
				} else {
					alert('이름 수정 성공');
					location.href("/mypage?mypage=1");									
				}
		},
		error: function() {
			alert("이름 변경 실패..");
		}
	});
}

//멤버 암호 수정
function passEdit(){
	$.ajax({
		url: "/mypage/passEdit",
		type: "POST",
		data: $('#myPageForm').serialize(),
		success: function(data) {
				if(data == 0){
					alert('암호 수정 실패');
				} else {
					alert('암호 수정 성공');
					location.href("/mypage?mypage=1");									
				}
		},
		error: function() {
			alert("암호 변경 실패..");
		}
	});
}

//멤버 휴대전화번호 수정
function phoneEdit(){
	$.ajax({
		url: "/mypage/phoneEdit",
		type: "POST",
		data: $('#myPageForm').serialize(),
		success: function(data) {
				if(data == 0){
					alert('번호 수정 실패');
				} else {
					alert('번호수정 성공');
					location.href("/mypage?mypage=1");									
				}
		},
		error: function() {
			alert("번호 변경 실패..");
		}
	});
}

//멤버 생년월일 수정
function birthEdit(){
	$.ajax({
		url: "/mypage/birthEdit",
		type: "POST",
		data: $('#myPageForm').serialize(),
		success: function(data) {
				if(data == 0){
					alert('생년월일 수정 실패');
				} else {
					alert('생년월일수정 성공');
					location.href("/mypage?mypage=1");									
				}
		},
		error: function() {
			alert("생년월일 변경 실패..");
		}
	});
}

//회원탈퇴
function delMember(id){
	$.ajax({
		url: "/mypage/delMember?member_id="+id,
		success: function(data) {
				if(data == 0){
					alert('회원탈퇴 실패');
				} else {
					alert('회원탈퇴 완료');
					location.href="/";									
				}
		},
		error: function() {
			alert("회원탈퇴 에러로 인하여 실패..");
		}
	});
}
