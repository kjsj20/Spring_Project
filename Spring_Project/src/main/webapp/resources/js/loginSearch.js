$(function() {
	$('.idSearch').click(function() {
		if ($('#phone_nember').val() == '') {
			alert('휴대전화번호를 읿력해주세요');
		} else {
			idSearch();
		}
	});
	$('.passSearch').click(function() {
		if ($('#e_mail').val() == '') {
			alert('이메일을 읿력해주세요');
		} else if($('#phone_number').val()==''){
			alert('휴대전화번호를 읿력해주세요');
		} else{
			$('#passVal').text('');
			$('#passVal').html("<font color='#FF6600'>확인중 입니다. 잠시만 기다려 주세요..</font>");
			$('.passSearch').attr('disabled', true);
			passSearch();
		}
	});
});

function idSearch() {
	$.ajax({
		url: "/idSearch",
		data: $("#searchForm").serialize(),
		success: function(data) {
			$('#idVal').text('');
			if (data == "") {
				$('#idVal').html("<font color='#FF6600'>휴대전화 번호를 다시 확인해주세요..</font>");
			} else {
				$('#idVal').html("<font color='#FF6600'>회원님의 이메일은 " + data + " 입니다</font>");
			}
		},
		error: function() {
			alert('id찾기중 에러 발생');
		}
	});
}

function passSearch() {
	$.ajax({
		url: "/passSearch",
		type:"POST",
		data: $("#searchForm").serialize(),
		success: function(data) {
			$('#passVal').text('');
			if (data == 0) {
				$('#passVal').html("<font color='#ffffff'>잘못된 정보가 있는지 확인해 주세요..</font>");
			} else {
				$('#passVal').html("<font color='#ffffff'>회원님의 메일로 임시번호를<br> 발송 하였습니다.</font>");
			}
			$('.passSearch').attr('disabled', true);
		},
		error: function() {
			alert('패스워드 찾기중 에러 발생');
			$('.passSearch').attr('disabled', true);
		}
	});
}