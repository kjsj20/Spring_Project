<%@page import="com.jscompany.springproject.model.domain.lecture.Lecture_TopCategory"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String lecture_id = request.getParameter("lecture_id");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="/resources/css/lecture/regist.css">
<script src="/resources/js/admin/main.js"></script>
<script src="/resources/js/lecture/section.js"></script>
</head>
<body>
	<%@ include file="../inc/sidebar_regist.jsp"%>
	
	<form id = "sectionForm">
		<input name = "lecture_id" type="hidden" value="<%=lecture_id%>"/>
  		<div class="container">
	  		<h1>섹션 등록</h1>  <div id="sectionAdd" style="width:15%; cursor: pointer;"><i class="fa fa-fw fa-plus-circle"></i>섹션추가</div>
	    	<hr>
			<div id = "tableContainer">
			    
			</div>
		    <button type="button" class="sectionbtn">등록</button>
		</div>
	</form>
</body>
</html>
