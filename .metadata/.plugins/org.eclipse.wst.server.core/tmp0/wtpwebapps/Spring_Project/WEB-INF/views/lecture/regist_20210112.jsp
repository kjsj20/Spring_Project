<%@page import="com.jscompany.springproject.model.domain.lecture.Lecture_TopCategory"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<Lecture_TopCategory> topList = (List)request.getAttribute("topList");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/resources/css/lecture/regist.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="//cdn.ckeditor.com/4.15.1/standard/ckeditor.js"></script>
<script src="/resources/js/admin/main.js"></script>
<script src="/resources/js/lecture/regist.js"></script>
</head>
<body>
	<%@ include file="./inc/sidebar.jsp"%>
	
	<form>
  		<div class="container">
	  		<h1>강의 등록</h1>
	    	<hr>
			
			<!-- 강의 제목 작성란 -->
		    <label for="lecTitle"><b>강의제목</b></label>
		    <input type="text" placeholder="ex ) 자바 프로그래밍 기초" name="lecTitle" id="lecTitle" />
		    
			<hr>
			
			<!-- 상위 카테고리 선택 라디오 박스 -->
			<div id ="category_top">
				<label for="radio"><b>상위 카테고리</b></label><br><br>
				<%for(int i = 0; i < topList.size(); i++) {%>
				<%Lecture_TopCategory lecture_TopCategory = topList.get(i); %>
					<label class="topCategory"><%=lecture_TopCategory.getLecture_topcategory_name() %>
				  		<input type="radio" id = <%=lecture_TopCategory.getLecture_topcategory_id() %> class = "topRadio" name="topRadio">
				  		<span class="checkmark"></span>
					</label>
				<%} %>
			</div>
			
			
			<!-- 하위 카테고리 선택 라디오 박스 -->
			<div id="category_sub">
			</div>
			
			<hr>
			
			<!-- 강의 요약 작성란 -->
			<label for="summaryContent"><b>강의 요약</b></label>
		   	<textarea id="summaryContent" name=summaryContent placeholder="간단하게 강의 요약을 입력 해주세요~" style="height:60px"></textarea>
			<!-- 강의 상세 내용 작성란-->
		    <label for="detailContent"><b>강의 상세 내용</b></label>
		    <textarea id="detailContent" name="detailContent" placeholder="강의 상세내용을 입력 해주세요~" ></textarea>
		
		    <hr>
		    
		    <table>
			  <tr>
			    <th>
			    	<input type="text"> 
			    </th>
			  </tr>
			  <tr>
			  	<td>
			  		<input type="text" placeholder="ex ) 자바 프로그래밍 기초" name="lecTitle" id="email" />
			  		<input type="text" placeholder="ex ) 자바 프로그래밍 기초" name="lecTitle" id="email" />
				</td>
			  </tr>
			</table>
		    
		    <hr>
		
		    <button type="button" class="registerbtn">등록</button>
		</div>
	</form>
</body>
</html>
