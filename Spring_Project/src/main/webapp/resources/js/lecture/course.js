$(function(){
	$('.topCategory').click(function(){
		getSubCategory(this.id.replace(/[^0-9]/g, ""));
	});
});

//상위 카테고리를 선택하면 하위 카테고리를 db에서 가져옴.
function getSubCategory(id) {

		location.href = "/course/list?topcategory_id=" + id;
	
	/*$.ajax({
		url: "/lecture/getSubCategory?topCategory_id=" + id,
		success: function(data) {
			var tag = '<h3 class="heading-sidebar">강의 카테고리</h3>';
			for (var i = 0; i < data.length; i++) {
				tag += '<label for="option-instructor-'+data[i].lecture_subcategory_id+'"><input type="checkbox" id="option-instructor-'+data[i].lecture_subcategory_id+'" name="vehicle" value="">'+data[i].lecture_subcategory_name+'</label><br>';
			}
			$('#subCategoryDiv').html(tag);
			//$('#subCategory'+$('.subIdVal').val()).attr('checked',true);
		},
		error: function() {
			alert("하위 카테고리 가져오기 실패..");
		}
	});*/
}