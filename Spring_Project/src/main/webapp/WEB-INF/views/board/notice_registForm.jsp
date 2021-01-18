<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../lecture/inc/header.jsp"%>
<link rel="stylesheet" href="/resources/css/board/regist.css">
<script src="/resources/js/board/regist.js"></script>
</head>
<body>
<%@ include file="../lecture/inc/nav.jsp"%>
	<%if( member == null) {%>
		<script>
			location.href = "/";
		</script>
	<%} else if(member.getAdmin_state() !=1){%>
		<script>
			location.href = "/";			
		</script>
	<%} %>
<div class="writeForm">
  <form id="noticeRegistForm">
  	<%if(member != null) {%>
  		<input type="hidden" name = "member_id" value="<%=member.getMember_id()%>">
  	<%} %>
    <label for="title">제목</label>
    <input type="text" id="title" name="title" placeholder="제목">

    <label for="content">내용</label>
    <textarea id="content" name="content" placeholder="내용입력" style="height:400px;"></textarea>

    <input id="noticeRegist" type="button" value="등록">
  </form>
</div>
<%@ include file="../lecture/inc/footer.jsp"%>
</body>
</html>
