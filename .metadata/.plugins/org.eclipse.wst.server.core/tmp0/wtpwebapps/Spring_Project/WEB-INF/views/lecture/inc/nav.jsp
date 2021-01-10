<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
   <div class="container">
    <a class="navbar-brand" href="#">잡아오라</a>
     <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
       <span class="oi oi-menu"></span> Menu
   </button>

   <div class="collapse navbar-collapse" id="ftco-nav">
       <ul class="navbar-nav ml-auto">
         <li class="nav-item active"><a href="index.html" class="nav-link">Home</a></li>
         <li class="nav-item"><a href="about.html" class="nav-link">LoadMap</a></li>
         <li class="nav-item"><a href="course.html" class="nav-link">Course</a></li>
         <li class="nav-item"><a href="instructor.html" class="nav-link">Community</a></li>
         <li class="nav-item"><a href="blog.html" class="nav-link">FAQ</a></li>
         <li class="nav-item">
         	<%if(session.getAttribute("member")==null){//세션에 담겨진 데이터가 없다면 %>
	         <a href="/loginForm" class="nav-link">Login</a>
	        <%} else { //세션에 담겨진 데이터가 있다면%>
	         <a href="/loginout" class="nav-link">Logout</a>
	        <%} %>
         </li>
     </ul>
 </div>
</div>
</nav>
<!-- END nav -->