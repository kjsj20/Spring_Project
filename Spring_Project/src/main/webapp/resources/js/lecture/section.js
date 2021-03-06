
var sectionArr = [];
var classArrList = [];
var urlArrList = [];
var numberSection = 1;
var numberClass = 1;
$(function() {
	
	$('.sectionbtn').click(function(){
		registSection();
	});
	
	$('#sectionAdd').click(function() {
		//섹션 추가
		var table = document.createElement('table');
		table.id = 'table' + numberSection;
		var sectionTr = document.createElement('tr');
		var sectionTd = document.createElement('td');
		var br = document.createElement('br');
		var b = document.createElement('b');
		var label = document.createElement('label');
		var divAdd = document.createElement('div');
		divAdd.id = 'addCls' + numberSection;
		divAdd.className = 'clsAdd';
		divAdd.style.display = 'inline-block';
		divAdd.style.cursor = 'pointer';
		divAdd.innerHTML = '수업추가';
		divAdd.style.marginLeft = '5px';
		divAdd.style.marginBottom = '8px';
		var divRmv = document.createElement('div');
		divRmv.innerHTML = '섹션삭제';
		divRmv.id = 'rmvCls' + numberSection;
		divRmv.className = 'clsRmv';
		divRmv.style.display = 'inline-block';
		divRmv.style.cursor = 'pointer';
		divRmv.style.marginLeft = '20px';
		divRmv.style.marginBottom = '8px';
		var iAdd = document.createElement('i');
		iAdd.className = 'fa fa-fw fa-plus-circle';
		var iRmv = document.createElement('i');
		iRmv.className = 'fa fa-fw fa-minus-circle'
		var inputSection = document.createElement('input');
		inputSection.id = 'sectionName'+numberSection;
		inputSection.placeholder = '섹션명 ex ) 1교시 자바의 기초';
		inputSection.type = "text";

		//섹션 추가
		table.appendChild(sectionTr);
		sectionTr.appendChild(sectionTd);
		sectionTd.appendChild(br);
		sectionTd.appendChild(b);
		b.appendChild(label);
		sectionTd.appendChild(divAdd);
		divAdd.prepend(iAdd);
		sectionTd.appendChild(divRmv);
		divRmv.prepend(iRmv);
		sectionTd.appendChild(inputSection);
		$('#tableContainer').append(table);
		
		//섹션 제목을 담을 배열 
		sectionArr.push(inputSection);
		
		//수업을 담을 배열 생성;	
		eval("classArr"+ numberSection +"= []");
		eval("urlArr"+ numberSection +"= []");
		classArrList.push(eval("classArr"+numberSection));
		urlArrList.push(eval("urlArr"+numberSection));
		
		//섹션에서 수업 추가
		$('#addCls' + numberSection).click(function() {
			var classTr = document.createElement('tr');
			var classTd = document.createElement('td');
			var inputClass = document.createElement('input');
			inputClass.id = 'className' + numberClass;
			inputClass.placeholder = '수업명 ex ) 0강 : 자바란? 무엇인가';
			inputClass.type = "text";
			var inputUrl = document.createElement('input');
			inputUrl.id = 'urlName' + numberClass;
			inputUrl.placeholder = '유튜브 URL을 추가 해주세요';
			inputUrl.type = "text";
			inputUrl.style.width = "80%";
			var inputdelBtn = document.createElement('input');
			inputdelBtn.id = 'btn' + numberClass;
			inputdelBtn.value = '삭제';
			inputdelBtn.type = "button";
			inputdelBtn.style.marginLeft = "4%";

			table.appendChild(classTr);
			classTr.appendChild(classTd);
			classTd.appendChild(inputClass);
			classTd.appendChild(inputUrl);
			classTd.appendChild(inputdelBtn);
			
			var sectionId = this.id.replace(/[^0-9]/g, "");
			
			eval("classArr"+sectionId+".push(inputClass)");
			eval("urlArr"+sectionId+".push(inputUrl)");
			
			//수업삭제
			$('#btn'+numberClass).click(function(){
				var id = 'className'+this.id.replace(/[^0-9]/g, "");
				//수업을 담은 배열을 지우기위해 찾아옴
				var arrName = eval("classArr"+ sectionId);
				var classIndex = eval("classArr"+ sectionId).lastIndexOf(id);
				var arrIndex = classArrList.lastIndexOf(arrName);
				//URL을 담은 배열을 지우기위해 찾아옴
				var urlid = 'urlName'+this.id.replace(/[^0-9]/g, "");
				var urlName = eval("urlArr"+ sectionId);
				var urlIndex = eval("urlArr"+ sectionId).lastIndexOf(urlid);
				var urlArrIndex = urlArrList.lastIndexOf(urlName);
				
				$('#className' + this.id.replace(/[^0-9]/g, "")).remove();
				$('#urlName' + this.id.replace(/[^0-9]/g, "")).remove();
				this.remove();
				
				const delClassArr = arrName.filter(function(classVal){
					return classVal.id !== id;
				});
				
				const delUrlArr = urlName.filter(function(urlVal){
					return urlVal.id !== urlid;
				});
				
				arrName = delClassArr;
				eval("classArr" + sectionId + "= arrName");
				classArrList[arrIndex] = delClassArr;
				if(arrName.length == 0){
					classArrList.splice(arrIndex,1);
				}
				
				urlName = delUrlArr;
				eval("urlArr" + sectionId + "= urlName");
				urlArrList[urlArrIndex] = delUrlArr;
				if(urlName.length == 0){
					urlArrList.splice(urlArrIndex,1);
				}
			});
			
			numberClass++
		});
		
		//섹션 삭제 
		$('#rmvCls' + numberSection).click(function() {
			var id = 'sectionName'+this.id.replace(/[^0-9]/g, "");
			var arrName = eval("classArr"+ this.id.replace(/[^0-9]/g, ""));
			var arrIndex = classArrList.lastIndexOf(arrName);
			
			var urlid = 'urlName'+this.id.replace(/[^0-9]/g, "");
			var urlName = eval("urlArr"+ this.id.replace(/[^0-9]/g, ""));
			var urlArrIndex = urlArrList.lastIndexOf(urlName);
			
			$('#table' + this.id.replace(/[^0-9]/g, "")).remove();
			const delSectionArr = sectionArr.filter(function(section){
				return section.id !== id;
			});
			sectionArr = delSectionArr;
			classArrList.splice(arrIndex,1);
			urlArrList.splice(urlArrIndex,1);
		});

		numberSection++;
	});
	
	//섹션 & 수업 등록
	function registSection(){
		var formData = new FormData($("#sectionForm")[0]);
		for(i = 0; i < sectionArr.length; i++){
			var count = 0;
			formData.append("sectionList", sectionArr[i].value);
			for(j = 0; j < classArrList[i].length; j++){
				formData.append("classList", classArrList[i][j].value);
				formData.append("urlList", urlArrList[i][j].value);
				count++;
			}
			formData.append("countList", count);
		}
		
		$.ajax({
			url:"/lecture/sectionRegist",
			data: formData,
			type:"POST",
			contentType:false,/*false일 경우 multipart/form-data*/
			processData:false,
			success:function(data){
				alert('섹션 추가 성공 !!!');
				location.href = "/lecture/list";
			},
			error:function(){
				alert('섹션 추가 실패..');
			}
		});
	}
});
