<%@page import="com.jscompany.springproject.model.domain.lecture.Lecture"%>
<%@page import="java.util.List"%>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<Lecture> lectureList = (List)request.getAttribute("lectureList"); 
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>CoCo!</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@ include file="../lecture/inc/header.jsp"%>
    <link rel="stylesheet" href="/resources/css/lecture/course.css">
    <script src="/resources/js/lecture/course.js"></script>
</head>
<body>
<%@ include file="../lecture/inc/nav.jsp" %>
<!-- END nav -->
	<%if(session.getAttribute("member")==null) {%>
		<script>
			location.href = "/";
		</script>
	<%} %>
	
	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row">
				<div class="col-lg-9">
					<div class="row" style="width:1200px;">
						<%for(int i = 0; i < lectureList.size(); i++){ %>
						<%Lecture lecture = lectureList.get(i); %>
							<div class="col-md-6 d-flex align-items-stretch ftco-animate" style="width:20px;">
								<div class="project-wrap">
									<a href="/lectureview?lecture_id=<%=lecture.getLecture_id() %>" class="img" style="background-image: url(/resources/data/logo/<%=lecture.getLecture_id()%>.<%=lecture.getLogofile()%>);">
									</a>
									<div class="text p-4">
										<h3><a href="/lectureview?lecture_id=<%=lecture.getLecture_id() %>"><%=lecture.getLecture_name() %></a></h3>
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
<%@ include file="../lecture/inc/footer.jsp" %>
<script>
$(function(){
	$('#topCategory'+$('#topcategory_id').val()).addClass('active');
	$('#subCategory'+$('#subcategory_id').val()).addClass('active');
});
</script>
</body>
</html>