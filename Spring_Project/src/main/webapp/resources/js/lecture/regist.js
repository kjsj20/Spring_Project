$(function(){
	$('.topRadio').click(function(){
		getSubCategory(this.id);
	});
});

function getSubCategory(id){
	$.ajax({
		url: "/lecture/getSubCategory?subCategory_id=" + id,
		success : function(data){
			console.log(data[0].lecture_subcategory_id); 
			var tag = '<label for="radio"><b>하위 카테고리</b></label><br><br>';
			for(var i = 0; i < data.length; i++){
					tag += '<label class="topCategory">'+data[i].lecture_subcategory_name;
					tag += '<input type="radio" id =' +data[i].lecture_subcategory_id+ 'class = "subRadio" name="subRadio">'
					tag += '<span class="checkmark"></span>';
					tag += '</label>';
			}
			$('#category_sub').html(tag);
		},
		error : function(){
			alert("실패?");
		}
	});
}