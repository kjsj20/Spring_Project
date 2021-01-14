$(function(){
	
	$('.updateLecture').click(function(){
		location.href = "/lecture/detail";
	});
	
	$('.sidebar').find('a').click(function(){
		$('.sidebar').find('a').removeClass("active");
		$(this).addClass("active");
	});
	
	$('.delMember').click(function(){
		if(confirm("정말 삭제 하시겠습니까?")){
			delMember(this.id, $("#currentPage").val());
		};
	});
});

function delMember(id, currentPage){
	$.ajax({
		url:"/admin/delMember?member_id="+ id +"&currentPage="+ currentPage,
		success:function(data){
			location.href="/admin/list?currentPage=" + data
		},
		error:function(){
			alert('삭제중 오류 발생');
		}
	});
}