$(function() {
	//ckeditor 
	CKEDITOR.replace('lecture_detail_content', {
		height: 600
	});
	
	//상위 카테고리 클릭 이벤트
	$('.topRadio').click(function() {
		getSubCategory(this.id);
	});
	
	//파일 체인지 이벤트
	$("#imgInp").change(function() { //alert(this.value); //선택한 이미지 경로 표시 
		readURL(this);
	});
	
	//jquery ajax 형태로 formdata를 보내주기
	$('#lectureRegistBtn').click(function(){
		lectureRegist();
	});
});

function lectureRegist(){
	var formData = new FormData($('#LectureRegistForm')[0]);
	
	//폼데이터에 에디터의 값 추가하기!!
	formData.append("lecture_detail_content", CKEDITOR.instances["lecture_detail_content"].getData());
	
	$.ajax({
		url:'/lecture/regist',
		type:'POST',
		data: formData,
		enctype : 'multipart/form-data',
		processData: false,
		contentType: false,
		success: function(data){
			alert("등록 성공! 내 강의에서 강의 섹션을 추가해주세요!");
			location.href = '/lecture/list';
		},
		error:function(e){
			alert('등록중 에러가 발생하였습니다.. 다시 한번 잘 입력되었는지 확인해 보세요');
		}
	});	
}

//상위 카테고리를 선택하면 하위 카테고리를 db에서 가져와 값을 radio버튼에 넣음.
function getSubCategory(id) {
	$.ajax({
		url: "/lecture/getSubCategory?subCategory_id=" + id,
		success: function(data) {
			var tag = '<label for="subRadio"><b>하위 카테고리</b></label><br><br>';
			for (var i = 0; i < data.length; i++) {
				tag += '<label class="topCategory">' + data[i].lecture_subcategory_name;
				tag += '<input type="radio" id =' + data[i].lecture_subcategory_id + 'class = "subRadio" name="lecture_subcategory_id" value ='+data[i].lecture_subcategory_id+'>'
				tag += '<span class="checkmark"></span>';
				tag += '</label>';
			}
			$('#category_sub').html(tag);
		},
		error: function() {
			alert("실패?");
		}
	});
}

//선택한 이미지로 바꿔준다
function readURL(input) {
	if (input.files && input.files[0]) {
	var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성 
	reader.onload = function(e) { //파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러 
		$('#blah').attr('src', e.target.result);//이미지 Tag의 SRC속성에 읽어들인 File내용을 지정 //(아래 코드에서 읽어들인 dataURL형식) 
	}
		reader.readAsDataURL(input.files[0]); //File내용을 읽어 dataURL형식의 문자열로 저장 
	}
}//readURL()-- //file 양식으로 이미지를 선택(값이 변경) 되었을때 처리하는 코드 

