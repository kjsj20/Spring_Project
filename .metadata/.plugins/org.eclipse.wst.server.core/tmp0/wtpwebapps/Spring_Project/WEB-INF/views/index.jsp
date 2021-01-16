<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>CoCo!</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%@ include file="./lecture/inc/header.jsp"%>
</head>
<body>
<%@ include file="./lecture/inc/nav.jsp" %>
<div class="hero-wrap js-fullheight" style="background-image: url('/resources/images/bg_1.png');">
  <div class="overlay"></div>
  <div class="container">
    <div class="row no-gutters slider-text js-fullheight align-items-center" data-scrollax-parent="true">
      <div class="col-md-7 ftco-animate">
        <span class="subheading">Welcome to Coco Programming learn</span>
        <h1 class="mb-4">배우자 싸우자 취업을 하자! 바로 여기서! Right Now</h1>
        <p class="caps">배움의 기회 더 이상 늦다고 생각할때가 가장 늦은법, 지금 바로 여기서 기초부터 심화까지 공부를 시작하세요</p>
        <p class="mb-0"><a href="#" class="btn btn-primary">Our Course</a> <a href="#" class="btn btn-white">Learn More</a></p>
    </div>
</div>
</div>
</div>

<section id = "registForm" class="ftco-section ftco-no-pb ftco-no-pt" <%if(session.getAttribute("member") != null){%>style = "display:none;"<%}%>>
    <div class="container">
       <div class="row">
          <div class="col-md-7"></div>
          <div class="col-md-5 order-md-last">
           <div id = "registArea" class="login-wrap p-4 p-md-5">
               <h3 class="mb-4">회원가입</h3>
               <form class="signup-form">
                  <div class="form-group">
                     <label class="label" for="e_mail">이메일</label>
                     <input type="text" id= "e_mail" name = "e_mail" class="form-control" placeholder="example@gmail.com">
                 </div>
                 <div class="form-group">
                     <label class="label" for="phone">휴대전화 번호</label>
                     <input type="text" id= "phone" name = "phone" class="form-control" placeholder="번호 - 빼고 입력 ">
                 </div>
                 <div class="form-group">
                     <label class="label" for="birth_date">생년월일</label>
                     <input type="text" id= "birth_date" name = "birth_date" class="form-control" placeholder="생년월일 - 빼고 입력">
                 </div>
                 <div class="form-group">
                     <label class="label" for="user_name">이름</label>
                     <input type="text" id= "user_name" name = "user_name" class="form-control" placeholder="이름 입력">
                 </div>
                 <div class="form-group">
                  <label class="label" for="password">비밀번호</label>
                  <input id="password" name = "password" type="password" class="form-control" placeholder="비밀번호 입력">
              </div>
              <div class="form-group">
                  <label class="label" for="passwordConfirm">비밀번호 확인</label>
                  <input id="passwordConfirm" name="passwordConfirm" type="password" class="form-control" placeholder="비밀번호 확인">
              </div>
              <p id="pwCheck" style="color: #FF6600; margin: 0;"></p>
              <p id="signUpComplete" style="color : #70AD47; margin: 0;"></p>
              <div class="form-group d-flex justify-content-end mt-4">
                  <button type="button" id="signUpUser" class="btn btn-primary submit">회원가입 <span class="fa fa-paper-plane"></span></button>
              </div>
          </form>
          <p class="text-center">이미 가입한 계정이 있습니까? <a href="/loginForm">Login</a></p>
      </div>
  </div>
 </div>
 </div>
 </section>

<!--  <section id = "signInForm" class="ftco-section ftco-no-pb ftco-no-pt"> -->
<!--     <div class="container"> -->
<!--        <div class="row"> -->
<!--           <div class="col-md-7"></div> -->
<!--           <div class="col-md-5 order-md-last"> -->
<!--            <div class="login-wrap p-4 p-md-5"> -->
<!--                <h3 class="mb-4">로그인</h3> -->
<!--                <form class="signin-form"> -->
<!--                   <div class="form-group"> -->
<!--                      <label class="label" for="name">이메일</label> -->
<!--                      <input type="text" class="form-control" placeholder="이메일 입력"> -->
<!--                  </div> -->
<!--                  <div class="form-group"> -->
<!--                   <label class="label" for="password">비밀번호</label> -->
<!--                   <input id="password-field" type="password" class="form-control" placeholder="비밀번호"> -->
<!--               </div> -->
<!--               <div class="form-group d-flex justify-content-end mt-4"> -->
<!--                   <button type="submit" class="btn btn-primary submit"><span class="fa fa-paper-plane"></span></button> -->
<!--               </div> -->
<!--           </form> -->
<!--           <p class="text-center">가입한 계정이 없으십니까? <a id = "signUp" href="#">Sign Up</a></p> -->
<!--       </div> -->
<!--   </div> -->
<!--  </div> -->
<!--  </div> -->
<!--  </section> -->

<section class="ftco-section">
   <div class="container">
      <div class="row justify-content-center pb-4">
          <div class="col-md-12 heading-section text-center ftco-animate">
          	<span class="subheading">Start Learning Today</span>
            <h2 class="mb-4">Browse Online Course Category</h2>
        </div>
    </div>
    <div class="row justify-content-center">
     <div class="col-md-3 col-lg-2">
        <a href="#" class="course-category img d-flex align-items-center justify-content-center" style="background-image: url(/resources/images/html.png);">
           <div class="text w-100 text-center">
              <h3>HTML/CSS3</h3>
              <span>100 course</span>
          </div>
      </a>
  </div>
  <div class="col-md-3 col-lg-2">
    <a href="#" class="course-category img d-flex align-items-center justify-content-center" style="background-image: url(/resources/images/javascript.png);">
       <div class="text w-100 text-center">
          <h3>JavaScript Basic</h3>
          <span>100 course</span>
      </div>
  </a>
</div>
<div class="col-md-3 col-lg-2">
    <a href="#" class="course-category img d-flex align-items-center justify-content-center" style="background-image: url(/resources/images/python.jpg);">
       <div class="text w-100 text-center">
          <h3>Python</h3>
          <span>100 course</span>
      </div>
  </a>
</div>
<div class="col-md-3 col-lg-2">
    <a href="#" class="course-category img d-flex align-items-center justify-content-center" style="background-image: url(/resources/images/java.png);">
       <div class="text w-100 text-center">
          <h3>Java Basic</h3>
          <span>100 course</span>
      </div>
  </a>
</div>
<div class="col-md-3 col-lg-2">
    <a href="#" class="course-category img d-flex align-items-center justify-content-center" style="background-image: url(/resources/images/spring.png);">
       <div class="text w-100 text-center">
          <h3>Spring</h3>
          <span>100 course</span>
      </div>
  </a>
</div>
<div class="col-md-3 col-lg-2">
    <a href="#" class="course-category img d-flex align-items-center justify-content-center" style="background-image: url(/resources/images/meteor.png)">
       <span class="text w-100 text-center">
          <h3>MeteorJs</h3>
          <span>100 course</span>
      </span>
  </a>
</div>
<div class="col-md-12 text-center mt-5">
    <a href="#" class="btn btn-secondary">See All Courses</a>
</div>
</div>
</div>
</section>

<section class="ftco-section bg-light">
   <div class="container">
      <div class="row justify-content-center pb-4">
          <div class="col-md-12 heading-section text-center ftco-animate">
          	<span class="subheading">Start Learning Today</span>
            <h2 class="mb-4">Pick Your Course</h2>
        </div>
    </div>
    <div class="row">
       <div class="col-md-4 ftco-animate">
          <div class="project-wrap">
             <a href="#" class="img" style="background-image: url(/resources/images/work-1.jpg);">
                <span class="price">Software</span>
            </a>
            <div class="text p-4">
                <h3><a href="#">Design for the web with adobe photoshop</a></h3>
                <p class="advisor">Advisor <span>Tony Garret</span></p>
                <ul class="d-flex justify-content-between">
                   <li><span class="flaticon-shower"></span>2300</li>
                   <li class="price">$199</li>
               </ul>
           </div>
       </div>
   </div>
   <div class="col-md-4 ftco-animate">
      <div class="project-wrap">
         <a href="#" class="img" style="background-image: url(/resources/images/work-2.jpg);">
            <span class="price">Software</span>
        </a>
        <div class="text p-4">
            <h3><a href="#">Design for the web with adobe photoshop</a></h3>
            <p class="advisor">Advisor <span>Tony Garret</span></p>
            <ul class="d-flex justify-content-between">
               <li><span class="flaticon-shower"></span>2300</li>
               <li class="price">$199</li>
           </ul>
       </div>
   </div>
</div>
<div class="col-md-4 ftco-animate">
  <div class="project-wrap">
     <a href="#" class="img" style="background-image: url(/resources/images/work-3.jpg);">
        <span class="price">Software</span>
    </a>
    <div class="text p-4">
        <h3><a href="#">Design for the web with adobe photoshop</a></h3>
        <p class="advisor">Advisor <span>Tony Garret</span></p>
        <ul class="d-flex justify-content-between">
           <li><span class="flaticon-shower"></span>2300</li>
           <li class="price">$199</li>
       </ul>
   </div>
</div>
</div>

<div class="col-md-4 ftco-animate">
  <div class="project-wrap">
     <a href="#" class="img" style="background-image: url(/resources/images/work-4.jpg);">
        <span class="price">Software</span>
    </a>
    <div class="text p-4">
        <h3><a href="#">Design for the web with adobe photoshop</a></h3>
        <p class="advisor">Advisor <span>Tony Garret</span></p>
        <ul class="d-flex justify-content-between">
           <li><span class="flaticon-shower"></span>2300</li>
           <li class="price">$199</li>
       </ul>
   </div>
</div>
</div>
<div class="col-md-4 ftco-animate">
  <div class="project-wrap">
     <a href="#" class="img" style="background-image: url(/resources/images/work-5.jpg);">
        <span class="price">Software</span>
    </a>
    <div class="text p-4">
        <h3><a href="#">Design for the web with adobe photoshop</a></h3>
        <p class="advisor">Advisor <span>Tony Garret</span></p>
        <ul class="d-flex justify-content-between">
           <li><span class="flaticon-shower"></span>2300</li>
           <li class="price">$199</li>
       </ul>
   </div>
</div>
</div>
<div class="col-md-4 ftco-animate">
  <div class="project-wrap">
     <a href="#" class="img" style="background-image: url(/resources/images/work-6.jpg);">
        <span class="price">Software</span>
    </a>
    <div class="text p-4">
        <h3><a href="#">Design for the web with adobe photoshop</a></h3>
        <p class="advisor">Advisor <span>Tony Garret</span></p>
        <ul class="d-flex justify-content-between">
           <li><span class="flaticon-shower"></span>2300</li>
           <li class="price">$199</li>
       </ul>
   </div>
</div>
</div>
</div>
</div>
</section>
<%@ include file="./lecture/inc/footer.jsp" %>
</body>
</html>