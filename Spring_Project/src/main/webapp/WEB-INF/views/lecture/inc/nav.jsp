<%@page import="com.jscompany.springproject.model.domain.member.Member"%>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Member member = (Member)session.getAttribute("member");
%>
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
   <div class="container">
    <a class="navbar-brand" href="/">잡아오라</a>
     <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
       <span class="oi oi-menu"></span> Menu
   </button>

   <div class="collapse navbar-collapse" id="ftco-nav">
       <ul class="navbar-nav ml-auto">
         <li class="nav-item"><a href="/" class="nav-link">Home</a></li>
         <li class="nav-item"><a href="/course/list?topcategory_id=1" class="nav-link">Course</a></li>
         <li class="nav-item"><a href="/board/notice" class="nav-link">Community</a></li>
         <li class="nav-item">
         	<%if(session.getAttribute("member")==null){//세션에 담겨진 데이터가 없다면 %>
	         <a href="/loginForm" class="nav-link">Login</a>
	        <%} else { //세션에 담겨진 데이터가 있다면%>
	         <a href="/loginout" class="nav-link">Logout</a>
	        <%} %>
         </li>
         <%if(session.getAttribute("member")!=null){//세션에 담겨진 데이터가 없다면 %>
         <li class="nav-item"><a href="/mycourselist?member_id=<%=member.getMember_id() %>" class="nav-link">DashBoard</a></li>
         <li class="nav-item"><a href="/mypage?mypage=1" class="nav-link">MyPage</a></li>
         <%} %>
         <%if(session.getAttribute("member")!=null){%>
        	 <%if(member.getAdmin_state() == 1) {%>
         		<li class="nav-item"><a href="/admin/list" class="nav-link">AdminPage</a></li>
         	<%} %>
         	 <%if(member.getTeacher_state_id() == 1) {%>
         		<li class="nav-item"><a href="/lecture/list" class="nav-link">TeacherPage</a></li>
         	<%} %>
         <%} %>
     </ul>
 </div>
</div>
</nav>
<!-- END nav -->