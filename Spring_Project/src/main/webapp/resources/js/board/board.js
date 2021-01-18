$(function(){
	$('#registNotice').click(function(){
		location.href = "/board/notice_registForm";
	});
	
	$('#registQna').click(function(){
		location.href = "/board/qna_registForm";
	});
	
	$('.noticeDetail').click(function(){
		location.href = "/board/notice_detail?notice_id="+this.id;
	});
	
	$('.qnaDetail').click(function(){
		location.href = "/board/qna_detail?qna_id="+this.id;
	});
	
	$('#notice').click(function(){
		location.href = "/board/notice";
	});
	
	$('#qna').click(function(){
		location.href = "/board/qna";
	});
});