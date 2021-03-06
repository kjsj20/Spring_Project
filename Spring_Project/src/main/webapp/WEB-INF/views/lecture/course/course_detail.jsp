<%@page import="com.jscompany.springproject.model.domain.lecture.Section_detail"%>
<%@page import="com.jscompany.springproject.model.domain.lecture.Section"%>
<%@page import="java.util.List"%>
<%@page import="com.jscompany.springproject.common.Formatter"%>
<%@page import="com.jscompany.springproject.model.domain.lecture.Lecture"%>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Lecture lecture = (Lecture)request.getAttribute("lecture");
	List<Section> sectionList = (List)request.getAttribute("sectionList");
	List<List<Section_detail>> sectionDetailListList = (List)request.getAttribute("sectionDetailListList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>CoCo!</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="/resources/css/lecture/course.css">
    <%@ include file="../inc/header.jsp"%>
    <script src="/resources/js/lecture/course.js"></script>
    <style>
    .class_info .left_thumbnail {
     	float: left; 
     	width: 270px; 
    	margin-right: 30px; 
    	box-sizing: border-box;
	}
	.class_info .right_information {
    	width: calc(100% - 300px);
    	float: left;
	}
    </style>
    <script type="text/javascript" src="https://service.iamport.kr/js/iamport.payment-1.1.5.js"></script>
</head>
<body style="">
<%@ include file="../inc/nav.jsp" %>
	<%if(session.getAttribute("member") != null){ %>
		<input id="member_id" type="hidden" value="<%=member.getMember_id()%>">
		<input id="user_name" type="hidden" value="<%=member.getUser_name()%>">
		<input id="e_mail" type="hidden" value="<%=member.getE_mail()%>">
		<input id="phone" type="hidden" value="<%=member.getPhone()%>">
	<%} %>
	<input id="lecture_id" type="hidden" value="<%=lecture.getLecture_id()%>">
	<input id="price" type="hidden" value="<%=lecture.getPrice()%>">
	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row">
				<div class="col-lg-9" style="color: black;">
					<div class="class_info">
	                    <div class="left_thumbnail">
	                        <span>
	                            <img src="/resources/data/logo/<%=lecture.getLecture_id()%>.<%=lecture.getLogofile()%>" alt="courseImg" style="width:270px; height: 218px; border : 1px solid #D8D8D8; border-radius: 10px;" />
	                        </span>
	                    </div>
	                    <div class="right_information" style="margin-bottom:40px;">
	                        <div class="top">
	                            <p class="tit" style="font-weight:bold;"><h3><%=lecture.getLecture_name() %></h3></p>
	                        </div>
	                        <div class="mid">
	                            <span class="class_type" style = "background-color:#2E9AFE; color: #ffffff; padding: 5px; border-radius: 6px;"><%=lecture.getLecture_subcategory_name() %></span>
	                            &nbsp;&nbsp;&nbsp;&nbsp;
	                            <%if(session.getAttribute("member") != null){ %>
	                            <input id="courseRegist" type = "button" value="✔수강신청" style="border-radius: 5px; padding: 3px; border : none;color: #ffffff; background-color:#0000FF;"/>
	                            <%} else{ %>
	                            <input id="registIdNull" type = "button" value="✔수강신청" style="border-radius: 5px; padding: 3px; border : none;color: #ffffff; background-color:#0000FF;"/>
	                            <%} %>
	                            <br/>
	                            <br/>
	                            <span>
	                            	<h4>가격 : 
	                            	<%if(lecture.getPrice()==0){ %>
	                            		무료
	                            	<%} else {%>
	                            		<%=Formatter.getCurrency(lecture.getPrice())%>
	                            	<%} %>
	                            	</h4>
	                            </span>
	                            <span><h4>강사 : <%=lecture.getUser_name()%></h4></span>
	                        </div>
	                    </div>
	                </div>
					<div class="summaryContent" style="width : 100%; float : left; border : 1px solid #D8D8D8; border-radius: 6px; padding:20px; margin-bottom:40px;">
						<h4>강의 요약</h4>
						<hr/>
						<%=lecture.getLecture_summary_content() %>
					</div>
					<br/>
					<div class="detailContent" style="width : 100%; float : left; border : 1px solid #D8D8D8; border-radius: 6px; padding:20px;">
						<h3>✔강의 소개</h3>
						<hr/>
						<%=lecture.getLecture_detail_content() %>
					</div>
				</div>
				<div class ="sectionCategory">
					<%for(int i = 0; i < sectionList.size(); i++) {%>
					<%Section section = sectionList.get(i); %>
				    	<div id = "section<%=section.getSection_id() %>" class="label" style="cursor: pointer;"><p><h5 style="font-weight:bold;"><%=section.getSection_name() %></h5></p></div>
				    	<%List<Section_detail> sectionDetailList = sectionDetailListList.get(i); %>
				    		<div id = "section_detail<%=section.getSection_id() %>" class="elements" style="font-weight:bold;">
				    		<%for(int j = 0; j < sectionDetailList.size(); j++){ %>
				    			<%Section_detail section_detail = sectionDetailList.get(j); %>
				    			<p><%=section_detail.getSection_detail_name() %></p>
				    			<%if(j != sectionDetailList.size()-1){ %>
				    				<hr>
				    			<%} %>
				    		<%} %>
				    		</div>
				    <%} %>
				</div>
			</div>
		</div>
	</section>
<%@ include file="../inc/footer.jsp" %>

</body>
</html>