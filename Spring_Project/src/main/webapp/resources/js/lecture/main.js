$(function(){
	
	$('input[name=addSection]').click(function(){
		location.href = "/lecture/sectionRegistFrom?lecture_id="+this.className;
	});
	
	//강의 수정 폼으로 이동
	$('input[name=updateLecture]').click(function(){
		location.href = "/lecture/detail?lecture_id="+this.className;
	});
	
	$('.sidebar').find('a').click(function(){
		$('.sidebar').find('a').removeClass("active");
		$(this).addClass("active");
	});
	
	//강의 삭제
	$('input[name=delLacture]').click(function(){
		if(confirm("정말 삭제 하시겠습니까? 섹션까지 삭제되오니 주의 하시기 바랍니다.")){
			delLacture(this.className, $("#currentPage").val());
		};
	});
});

function delLacture(id, currentPage){
	$.ajax({
		url:"/lecture/delete?lecture_id="+ id +"&currentPage="+ currentPage,
		success:function(data){
			location.href="/lecture/list?currentPage=" + data
		},
		error:function(){
			alert('삭제중 오류 발생');
		}
	});
}