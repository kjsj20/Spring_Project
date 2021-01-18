<%@page import="com.jscompany.springproject.model.domain.board.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Notice notice = (Notice)request.getAttribute("notice");
%>
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

<div class="writeForm">
  <form id="noticeForm">
  	<%if(member != null) {%>
  		<input type="hidden" name = "member_id" value="<%=member.getMember_id()%>">
  	<%} %>

  	<input id = "notice_id" type= "hidden" name = "notice_id" value="<%=notice.getNotice_id()%>">
  	<%if(member == null||member.getMember_id() != notice.getMember_id()) {%>
	  	<label for="title">제목</label>
    	<input type="text" id="title" name="title" placeholder="제목" value="<%=notice.getTitle()%>" readonly>
	    <label for="content">내용</label>
    	<textarea id="content" name="content" placeholder="내용입력" style="height:400px;" readonly><%=notice.getContent() %></textarea>
	<%} else if (member.getMember_id() == notice.getMember_id()){%>
	  	<label for="title">제목</label>
    	<input type="text" id="title" name="title" placeholder="제목" value="<%=notice.getTitle()%>">
	    <label for="content">내용</label>
    	<textarea id="content" name="content" placeholder="내용입력" style="height:400px;"><%=notice.getContent() %></textarea>
	    <input id="noticeEdit" type="button" value="수정">
	    <input id="noticeDel" type="button" value="삭제">
	<%} %>

    <input id="backBtn" type="button" value="이전">
  </form>
</div>
<%@ include file="../lecture/inc/footer.jsp"%>
</body>
</html>
