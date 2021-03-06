<%@page import="com.jscompany.springproject.model.domain.lecture.Lecture_SubCategory"%>
<%@page import="com.jscompany.springproject.common.Formatter"%>
<%@page import="com.jscompany.springproject.model.domain.lecture.Lecture"%>
<%@page import="com.jscompany.springproject.model.domain.lecture.Difficulty"%>
<%@page import="java.util.List"%>
<%@page import="com.jscompany.springproject.model.domain.lecture.Lecture_TopCategory"%>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<Lecture_TopCategory> topList = (List)request.getAttribute("topList");
	List<Lecture_SubCategory> subList = (List)request.getAttribute("subList");
	List<Difficulty> diffList = (List)request.getAttribute("diffList");
	List<Lecture> lectureList = (List)request.getAttribute("lectureList");
	String topcategory_id = request.getParameter("topcategory_id");
	String subcategory_id = request.getParameter("subcategory_id");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>저놈을 잡아오라!</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@ include file="../inc/header.jsp"%>
    <link rel="stylesheet" href="/resources/css/lecture/course.css">
    <script src="/resources/js/lecture/course.js"></script>
</head>
<body>
<%@ include file="../inc/nav.jsp" %>
	<input id="topcategory_id" type="hidden" value="<%=topcategory_id %>"/>
	<input id="subcategory_id" type="hidden" value="<%=subcategory_id %>"/>
	<section class="hero-wrap hero-wrap-2" style="background-image: url('/resources/images/work-5.jpg');">
		<div class="overlay"></div>
		<div class="container">
			<div class="row no-gutters slider-text align-items-end justify-content-center">
				<div class="col-md-9 ftco-animate pb-5 text-center">
					<p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home <i class="fa fa-chevron-right"></i></a></span> <span>Course Lists <i class="fa fa-chevron-right"></i></span></p>
					<h1 class="mb-0 bread">Course Lists</h1>
				</div>
			</div>
		</div>
	</section>
	
	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row">
				<div class="col-lg-3 sidebar">
					<div class="sidebar-box bg-white ftco-animate">
						<form action="#" class="search-form">
							<div class="form-group">
								<span class="icon fa fa-search"></span>
								<input type="text" class="form-control" placeholder="Search...">
							</div>
						</form>
					</div>

					<div class="sidebar-box bg-white p-4 ftco-animate">
							<%for(Lecture_TopCategory lecture_TopCategory : topList){ %>
								<label id="topCategory<%=lecture_TopCategory.getLecture_topcategory_id() %>" class = "topCategory"  style="cursor:pointer;"> <%=lecture_TopCategory.getLecture_topcategory_name()%></label><br>
							<%} %>
					</div>

					<div id="subCategoryDiv" class="sidebar-box bg-white p-4 ftco-animate">
						<h3 class="heading-sidebar">코스</h3>
						<%for(Lecture_SubCategory lecture_SubCategory : subList){%>
							<label id="subCategory<%=lecture_SubCategory.getLecture_subcategory_id() %>" class = "subCategory"  style="cursor:pointer;"> <%=lecture_SubCategory.getLecture_subcategory_name()%></label><br>
						<%} %>
					</div>

					<div class="sidebar-box bg-white p-4 ftco-animate">
						<h3 class="heading-sidebar">Course Type</h3>
						<form action="#" class="browse-form">
							<%for(Difficulty difficulty: diffList){ %>						
								<label for="option-course-type-1"><input type="checkbox" id="option-course-type-1" name="vehicle" value=""> <%=difficulty.getDifficulty_name() %></label><br>
							<%} %>
						</form>
					</div>
					
				</div>
				<div class="col-lg-9">
					<div class="row">
						<%for(int i = 0; i < lectureList.size(); i++){ %>
						<%Lecture lecture = lectureList.get(i); %>
							<div class="col-md-6 d-flex align-items-stretch ftco-animate">
								<div class="project-wrap">
									<a href="/course/detail?lecture_id=<%=lecture.getLecture_id() %>" class="img" style="background-image: url(/resources/data/logo/<%=lecture.getLecture_id()%>.<%=lecture.getLogofile()%>);">
										<span class="price"><%=lecture.getLecture_subcategory_name() %></span>
									</a>
									<div class="text p-4">
										<h3><a href="/course/detail?lecture_id=<%=lecture.getLecture_id() %>"><%=lecture.getLecture_name() %></a></h3>
										<p class="advisor">강사명 : <span><%=lecture.getUser_name() %></span></p>
										<ul class="d-flex justify-content-between">
											<li><span class="flaticon-shower"></span></li>
											<%if(lecture.getPrice() == 0){%>
												<li class="price">무료</li>
										 	<%}else { %>
												<li class="price"><%=Formatter.getCurrency(lecture.getPrice())%></li>
											<%} %>
										</ul>
									</div>
								</div>
							</div>
						<%} %>
					</div>
					<div class="row mt-5">
						<div class="col">
							<div class="block-27">
								<ul>
									<li><a href="#">&lt;</a></li>
									<li class="active"><span>1</span></li>
									<li><a href="#">2</a></li>
									<li><a href="#">3</a></li>
									<li><a href="#">4</a></li>
									<li><a href="#">5</a></li>
									<li><a href="#">&gt;</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
<%@ include file="../inc/footer.jsp" %>
<script>
$(function(){
	$('#topCategory'+$('#topcategory_id').val()).addClass('active');
	$('#subCategory'+$('#subcategory_id').val()).addClass('active');
});
</script>
</body>
</html>