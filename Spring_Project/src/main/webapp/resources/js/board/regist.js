$(function(){
	$('#noticeRegist').click(function(){
		noticeregist();
	});	
	$('#noticeEdit').click(function(){
		noticeEdit();
	});	
	$('#noticeDel').click(function(){
		noticedel($('#notice_id').val());
	});	
	$('#backBtn').click(function(){
		history.back();
	});
	
	$('#qnaRegist').click(function(){
		qnaregist();
	});	
	$('#qnaEdit').click(function(){
		qnaEdit();
	});	
	$('#qnaDel').click(function(){
		qnadel($('#qna_id').val());
	});	
	
	//cmmt
	$('#registCmmt').click(function(){
		if($('#cmmt_content').val() == ''){
			alert("댓글을 입력 후 눌러주세요..");
		} else {
			registCmmt($('#member_id').val());
		}
	});	
	
	$(document).on('click','.cmmtDel',function(){
			delCmmt(this.id, $('#qna_id').val(),$('#member_id').val());		
	});
});

function noticeregist(){   
	$.ajax({
		url : '/board/noticeRegist',
		type: 'POST',
		data : $('#noticeRegistForm').serialize(),
		success : function(data){
			if(data == 0){
				alert('등록에 실패하였습니다.');
			} else {
				location.href="/board/notice";
			}
		} ,
		error : function(){
			alert('등록중 오류 발생...');
		}
	});
}

function noticeEdit(){   
	$.ajax({
		url : '/board/noticeEdit',
		type: 'POST',
		data : $('#noticeForm').serialize(),
		success : function(data){
			if(data == 0){
				alert('수정에 실패하였습니다.');
			} else {
				location.href="/board/notice";
			}
		} ,
		error : function(){
			alert('수정중 오류 발생...');
		}
	});
}

function noticedel(notice_id){   
	$.ajax({
		url : '/board/noticeDel?notice_id='+notice_id,
		type: 'GET',
		success : function(data){
			if(data == 0){
				alert('삭제에 실패하였습니다.');
			} else {
				location.href="/board/notice";
			}
		} ,
		error : function(){
			alert('삭제중 오류 발생...');
		}
	});
}

//qna
function qnaregist(){   
	$.ajax({
		url : '/board/qnaRegist',
		type: 'POST',
		data : $('#qnaRegistForm').serialize(),
		success : function(data){
			if(data == 0){
				alert('등록에 실패하였습니다.');
			} else {
				location.href="/board/qna";
			}
		} ,
		error : function(){
			alert('등록중 오류 발생...');
		}
	});
}

function qnaEdit(){   
	$.ajax({
		url : '/board/qnaEdit',
		type: 'POST',
		data : $('#qnaForm').serialize(),
		success : function(data){
			if(data == 0){
				alert('수정에 실패하였습니다.');
			} else {
				location.href="/board/qna";
			}
		} ,
		error : function(){
			alert('수정중 오류 발생...');
		}
	});
}

function qnadel(qna_id){   
	$.ajax({
		url : '/board/qnaDel?qna_id='+qna_id,
		type: 'GET',
		success : function(data){
			if(data == 0){
				alert('삭제에 실패하였습니다.');
			} else {
				location.href="/board/qna";
			}
		} ,
		error : function(){
			alert('삭제중 오류 발생...');
		}
	});
}
function registCmmt(member_id){   
	$.ajax({
		url : '/board/cmmtRegist',
		type: 'POST',
		data: $('#qnaForm').serialize(),
		success : function(data){
			$('#cmmt_content').val('');
			$('#cmmtContainer').empty();
			var tag = '<hr>';
			for(var i = 0; i < data.length; i++){ 
				tag +=	"<p>";
				tag +=	data[i].user_name+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+data[i].regdate+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp";
				tag +=	"<span id = "+data[i].qna_comment_id+" class= 'cmmtDel' style='cursor:pointer;'>";
				if(member_id == data[i].member_id){
				tag += "❌"	;	
				}
				tag +=	"</span>"	
				tag +=	"</p>";
				tag +=	"<p>"+data[i].cmmt_content+"</p>";
				tag += "<hr>";
			}  
			$('#cmmtContainer').html(tag);   
		} ,     
		error : function(){
			alert('댓글 등록중 오류 발생...');
		}
	});
}

function delCmmt(id,qna_id,member_id){   
	$.ajax({
		url : '/board/cmmtDel?qna_comment_id='+id+'&qna_id='+qna_id,
		type: 'GET',
		success : function(data){
			$('#cmmtContainer').empty();
			var tag = '<hr>';
			for(var i = 0; i < data.length; i++){ 
				tag +=	"<p>";
				tag +=	data[i].user_name+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+data[i].regdate+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp";
				tag +=	"<span id = "+data[i].qna_comment_id+" class= 'cmmtDel' style='cursor:pointer;'>";
				if(member_id == data[i].member_id){
				tag += "❌"	;	
				}
				tag +=	"</span>"	
				tag +=	"</p>";
				tag +=	"<p>"+data[i].cmmt_content+"</p>";
				tag += "<hr>";
			}  
			$('#cmmtContainer').html(tag);   
		} ,     
		error : function(){
			alert('댓글 등록중 오류 발생...');
		}
	});
}