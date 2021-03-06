$(function() {
	var elements = document.getElementsByClassName("elements");
	// 모든 영역 접기
	for (var i = 0; i < elements.length; i++) {
		elements[i].style.display = "none";
	}
	$('.label').click(function() {
		switchDisplay(this.id.replace(/[^0-9]/g, ""));
	});

	//상위 카테고리 클릭 이벤트
	$('.topCategory').click(function() {
		getSubCategory(this.id.replace(/[^0-9]/g, ""));
	});

	//하위 카테고리 클릭 이벤트
	$('.subCategory').click(function() {
		getSubLecture(this.id.replace(/[^0-9]/g, ""), $('#topcategory_id').val());
	});

	//수강 등록 클릭 이벤트
	$('#courseRegist').click(function() {
		if ($('#price').val() == 0) {
			courseRegist($('#member_id').val(), $('#lecture_id').val());
		} else if ($('#price').val() > 0) {
			let val = payment($('#price').val(), $('#user_name').val(), $('#e_mail').val(), $('#phone').val());
		}
	});
	$('#registIdNull').click(function() {
		alert('로그인이 필요한 서비스 입니다.');
		location.href = '/loginForm';
	});
	
	//강의 변경할때
	$('.srcChange').click(function(){
		console.log(this.id);
		$('#iframeView').attr('src', this.id);
	})
});

//상위 카테고리를 선택하면 하위 카테고리를 db에서 가져옴.
function getSubCategory(id) {
	location.href = "/course/list?topcategory_id=" + id;
}

//하위 카테고리를 선택하면 하위카테고리에 소속된 강의를  db에서 가져온다.
function getSubLecture(subid, topid) {
	location.href = "/course/listSub?topcategory_id=" + topid + "&subcategory_id=" + subid;
}

function switchDisplay(id) {
	var target = document.querySelector("#section_detail" + id);

	if (target.style.display == "none") {
		target.style.display = "block";
	} else {
		target.style.display = "none";
	}
	return false;
}

function courseRegist(member_id, lecture_id) {
	$.ajax({
		url: "/course/regist?member_id=" + member_id + "&lecture_id=" + lecture_id,
		type: "GET",
		success: function(data) {
			if (data === 0) {
				alert('오류로인해 신청 실패...');
			} else if (data === 2) {
				alert('이미 등록되어 있는 강의 입니다...');
			} else {
				alert('수강 등록 성공했습니다!');
				location.href = '/'
			}
		},
		error: function() {
			alert('시스템 오류 발생');
		}
	});
}

function payment(price, user_name, e_mail, phone ) {
	var IMP = window.IMP; // 생략가능
	IMP.init('imp83135203');
	// 'iamport' 대신 부여받은 "가맹점 식별코드"를 사용
	// i'mport 관리자 페이지 -> 내정보 -> 가맹점식별코드
	IMP.request_pay({
		pg: 'inicis', // version 1.1.0부터 지원.
		/*
		'kakao':카카오페이,
		html5_inicis':이니시스(웹표준결제)
		'nice':나이스페이
		'jtnet':제이티넷
		'uplus':LG유플러스
		'danal':다날
		'payco':페이코
		'syrup':시럽페이
		'paypal':페이팔
		*/
		pay_method: 'card',
		/*
		'samsung':삼성페이,
		'card':신용카드,
		'trans':실시간계좌이체,
		'vbank':가상계좌,
		'phone':휴대폰소액결제
		*/
		merchant_uid: 'merchant_' + new Date().getTime(),
		/*
		merchant_uid에 경우
		https://docs.iamport.kr/implementation/payment
		위에 url에 따라가시면 넣을 수 있는 방법이 있습니다.
		참고하세요.
		나중에 포스팅 해볼게요.
		*/
		name: '주문명:잡아오라 강의',
		//결제창에서 보여질 이름
		amount: price,
		//가격
		buyer_email: e_mail,
		buyer_name: user_name,
		buyer_tel: phone,
		buyer_addr: '테스트',
		buyer_postcode: '123-456',
		m_redirect_url: '/'
		/*
		모바일 결제시,
		결제가 끝나고 랜딩되는 URL을 지정
		(카카오페이, 페이코, 다날의 경우는 필요없음. PC와 마찬가지로 callback함수로 결과가 떨어짐)
		*/
	}, function(rsp) {
		console.log(rsp);
		if (rsp.success) {
			var msg = '결제가 완료되었습니다.';
			msg += '고유ID : ' + rsp.imp_uid;
			msg += '상점 거래ID : ' + rsp.merchant_uid;
			msg += '결제 금액 : ' + rsp.paid_amount;
			msg += '카드 승인번호 : ' + rsp.apply_num;
			courseRegist($('#member_id').val(), $('#lecture_id').val());
		} else {
			var msg = '결제에 실패하였습니다.';
			msg += '에러내용 : ' + rsp.error_msg;
		}
	});
}