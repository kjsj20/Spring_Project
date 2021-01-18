<%@page import="com.jscompany.springproject.model.domain.lecture.Section_detail"%>
<%@page import="com.jscompany.springproject.model.domain.lecture.Section"%>
<%@page import="java.util.List"%>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<Section> sectionList = (List)request.getAttribute("sectionList");
	List<List<Section_detail>> sectionDetailListList = (List)request.getAttribute("sectionDetailListList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>CoCo!</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="/resources/css/lecture/lectureView.css">
    <script src="/resources/js/lecture/course.js"></script>
</head>
<body>
	<%if(session.getAttribute("member")==null) {%>
		<script>
			location.href = "/";
		</script>
	<%} %>
	<div class="sidebar">
  		<a id ="1" href="/" class="active"><h3><i class="fa fa-fw fa-home"></i>Home</h3></a>
  		<%for(int i=0; i < sectionList.size(); i++) {%>
  		<%Section section = sectionList.get(i); %>
  			<div class ="section"><%=section.getSection_name() %></div>
  			<%List<Section_detail> section_DetailList = sectionDetailListList.get(i); %>
  			<%for(int j = 0; j < section_DetailList.size(); j++){ %>
  			<%Section_detail section_Detail = section_DetailList.get(j); %>
  			<div class ="section_detail"><a style="cursor:pointer;" id ="<%=section_Detail.getSection_lectureurl()%>" class ="srcChange"><%=section_Detail.getSection_detail_name()%></a></div>  				
  			<%} %>
  		<%} %>
  		
	</div>
  	<div class="video">
    	<div class="video-container">
      		<iframe id="iframeView" width="100%" height="100%" src="" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
    	</div>
	</div>
  		
</body>
</html>