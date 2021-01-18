<%@page import="com.jscompany.springproject.common.Pager"%>
<%@page import="com.jscompany.springproject.model.domain.board.Notice"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Pager pager = (Pager)request.getAttribute("pager");
	List<Notice> noticeList = pager.getList();
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@ include file="../lecture/inc/header.jsp"%>
<link rel="stylesheet" href="/resources/css/board/board.css">
<script src="/resources/js/board/board.js"></script>
</head>
<body>
	<%@ include file="../lecture/inc/nav.jsp"%>
	<hr>
	<div class="sidenav">
		<div id="notice" class = "active">공지사항</div>
		<div id="qna">Q&A</div>
	</div>
	<div id = "boardContainer">
		<h2 id ="boardTitle">공지사항</h2>
		<table>
			<tr>
				<th>No</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
			</tr>
			<%
				int curPos = pager.getCurPos();
				int num = pager.getNum();
			%>
			<%for(int i = 1; i < pager.getPageSize() + 1; i++) {%>
			<%if(num<1)break; %>
			<%Notice notice = noticeList.get(curPos++); %>
				<tr id = "<%=notice.getNotice_id() %>" class="noticeDetail" style="cursor:pointer;">
					<%num--; %>
					<td><%=num+1 %></td>
					<td><%=notice.getTitle() %></td>
					<td><%=notice.getWriter() %></td>
					<td><%=notice.getRegdate() %></td>
				</tr>
			<%} %>
		<% if(member != null){ %>
			<% if(member.getAdmin_state() == 1){%>
				<tr>
					<td colspan="4"><input id="registNotice" type="button" value="글쓰기" /></td>
				</tr>
			<%} %>
		<%} %>
		<tr>
			<td colspan="5" style="text-align: center"><a id="blockPage"
				href="/board/notice?currentPage=<%=1%>">◀◀</a> <%if(pager.getCurrentPage() > 1){%>
				<a id="blockPage"
				href="/board/notice?currentPage=<%=pager.getFirstPage() - pager.getBlockSize()%>">◀</a>
				<%}else{ %> <a id="blockPage">◀</a> <%} %> <%for(int i = pager.getFirstPage(); i < pager.getLastPage() + 1; i++){ %>
				<%if(pager.getTotalPage() < i)break; %> <a id="blockPage"
				<%if(pager.getCurrentPage() == i){ %> class="curPage" <%} %>
				href="/board/notice?currentPage=<%=i%>"><%=i %></a> <%} %> <%if(pager.getCurrentPage() == pager.getTotalPage()) {%>
				<a id="blockPage">▶</a> <%} else { %> <a id="blockPage"
				href="/board/notice?currentPage=<%=pager.getLastPage() + 1%>">▶</a>
				<%} %> <a id="blockPage"
				href="/board/notice?currentPage=<%=pager.getTotalPage()%>">▶▶</a></td>
		</tr>
		</table>
	</div>
	<%@ include file="../lecture/inc/footer.jsp"%>
</body>
</html>
