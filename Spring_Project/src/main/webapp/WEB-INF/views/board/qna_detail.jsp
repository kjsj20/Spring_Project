<%@page import="com.jscompany.springproject.model.domain.board.Qna_Comment"%>
<%@page import="java.util.List"%>
<%@page import="com.jscompany.springproject.model.domain.board.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Qna qna = (Qna)request.getAttribute("qna");
	List<Qna_Comment> cmmtList = (List)request.getAttribute("cmmtList");
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
  <form id="qnaForm">
  	<%if(member != null) {%>
  		<input id="member_id" type="hidden" name = "member_id" value="<%=member.getMember_id()%>">
  	<%} %>

  	<input id = "qna_id" type= "hidden" name = "qna_id" value="<%=qna.getQna_id()%>">
  	<%if(member == null||member.getMember_id() != qna.getMember_id()) {%>
	  	<label for="title">제목</label>
    	<input type="text" id="title" name="title" placeholder="제목" value="<%=qna.getTitle()%>" readonly>
	    <label for="content">내용</label>
    	<textarea id="content" name="content" placeholder="내용입력" style="height:400px;" readonly><%=qna.getContent() %></textarea>
	<%} else if (member.getMember_id() == qna.getMember_id()){%>
	  	<label for="title">제목</label>
    	<input type="text" id="title" name="title" placeholder="제목" value="<%=qna.getTitle()%>">
	    <label for="content">내용</label>
    	<textarea id="content" name="content" placeholder="내용입력" style="height:400px;"><%=qna.getContent() %></textarea>
	    <input id="qnaEdit" type="button" value="수정">
	    <input id="qnaDel" type="button" value="삭제">
	<%} %>
    <input id="backBtn" type="button" value="이전">
    <hr>
    <div>
		<textarea style="height:100px;" id="cmmt_content" name = "cmmt_content" placeholder="댓글을 입력해주세요"></textarea>
		<input id="registCmmt" type="button" value="댓글 등록" <%if(member == null){%>disabled<%} %>>
		<div id ="cmmtContainer">
			<hr>
			<%for(int i = 0; i < cmmtList.size(); i++){ %>
			<%Qna_Comment qna_Comment = cmmtList.get(i); %>
				<p>
					<%=qna_Comment.getUser_name() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=qna_Comment.getRegdate() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<span id = "<%=qna_Comment.getQna_comment_id() %>" class="cmmtDel" style="cursor:pointer;">
					<%if(member != null){ %>
						<%if(member.getMember_id() == qna_Comment.getMember_id()){ %>
						❌
						<%} %></span>
					<%} %>
				</p>
				<p><%=qna_Comment.getCmmt_content() %></p>
			<hr>
			<%} %>
		</div>
	</div>
  </form>
</div>
<%@ include file="../lecture/inc/footer.jsp"%>
</body>
</html>
