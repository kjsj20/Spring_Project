<%@page import="com.jscompany.springproject.model.domain.member.Member"%>
<%@page import="com.jscompany.springproject.model.domain.lecture.Difficulty"%>
<%@page import="com.jscompany.springproject.model.domain.lecture.Lecture_TopCategory"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<Lecture_TopCategory> topList = (List)request.getAttribute("topList");
	List<Difficulty> diffList = (List)request.getAttribute("diffList");
	Member member = (Member)session.getAttribute("member");
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
<script src="/resources/js/lecture/crud.js"></script>
</head>
<body>
	<%@ include file="./inc/sidebar_regist.jsp"%>
	
	<form id = "LectureRegistForm">
  		<div class="container">
	  		<h1>강의 등록</h1>
	    	<hr>
			<input type="hidden" name = "member_id" value="<%=member.getMember_id()%>"/>
			<!-- 강의 제목 작성란 -->
		    <label for="lecTitle"><b>강의제목</b></label>
		    <input type="text" placeholder="ex ) 자바 프로그래밍 기초" name="lecture_name" id="lecture_name" />
		    
			<hr>
			
			<!-- 상위 카테고리 선택 라디오 박스 -->
			<div id ="category_top">
				<label for="topRadio"><b>상위 카테고리</b></label><br><br>
				<%for(int i = 0; i < topList.size(); i++) {%>
				<%Lecture_TopCategory lecture_TopCategory = topList.get(i); %>
					<label class="topCategory"><%=lecture_TopCategory.getLecture_topcategory_name() %>
				  		<input type="radio" id = <%=lecture_TopCategory.getLecture_topcategory_id() %> class = "topRadio" name = "topRadio" value="<%=lecture_TopCategory.getLecture_topcategory_name() %>">
				  		<span class="checkmark"></span>
					</label>
				<%} %>
			</div>
			
			
			<!-- 하위 카테고리 선택 라디오 박스 -->
			<div id="category_sub">
			</div>
			
			<div id="diff_radio">
				<label for="difficulty_id"><b>난이도</b></label><br><br>
				<%for(int i = 0; i < diffList.size(); i++){ %>
				<%Difficulty difficulty = diffList.get(i); %>
					<label class="topCategory"><%=difficulty.getDifficulty_name()%>
				  		<input type="radio" id = <%=difficulty.getDifficulty_id() %> class = "diffRadio" name="difficulty_id" value="<%=difficulty.getDifficulty_id()%>">
				  		<span class="checkmark"></span>
					</label>
				<%} %>
			</div>
			
			<hr>
			
			<!-- 강의 요약 작성란 -->
			<label for="lecture_summary_content"><b>강의 요약</b></label>
		   	<textarea id="lecture_summary_content" name="lecture_summary_content" placeholder="간단하게 강의 요약을 입력 해주세요~" style="height:60px"></textarea>
			<!-- 강의 상세 내용 작성란-->
		    <label for="lecture_detail_content"><b>&nbsp;&nbsp;&nbsp;강의 상세 내용</b></label>
		    <textarea id="lecture_detail_content" name="lecture_detail_content" placeholder="강의 상세내용을 입력 해주세요~" ></textarea>
		    
		    <hr>
		    
		    <label for="price"><b>가격</b></label>
		    <input type="text" name="price" id="price" value="0"/>
		    
		    <hr>
			
			<label><b>강의 대표 이미지(강의를 대표하는 이미지를 넣어주세요! 주의> jpg 또는 png 파일만 넣어주세요)</b></label><br><br>
			<img id="blah" src="/resources/images/javascript.png"alt="your image" style="width:230px; height:150px;"/>
			<input type='file' id="imgInp" name="imgFile" /><br /> 
			
		    <hr>
			
		    <button id="lectureRegistBtn" type="button" class="registerbtn">등록</button>
		</div>
	</form>
</body>
</html>
