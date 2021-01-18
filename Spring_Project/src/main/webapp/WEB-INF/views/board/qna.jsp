<%@page import="com.jscompany.springproject.model.domain.board.Qna"%>
<%@page import="com.jscompany.springproject.common.Pager"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Pager pager = (Pager)request.getAttribute("pager");
	List<Qna> qnaList = pager.getList();
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
		<div id="notice">공지사항</div>
		<div id="qna" class = "active">Q&A</div>
	</div>
	<div id = "boardContainer">
		<h2 id ="boardTitle">Q&A</h2>
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
			<%Qna qna = qnaList.get(curPos++); %>
				<tr id = "<%=qna.getQna_id() %>" class="qnaDetail" style="cursor:pointer;">
					<%num--; %>
					<td><%=num+1 %></td>
					<td><%=qna.getTitle() %></td>
					<td><%=qna.getWriter() %></td>
					<td><%=qna.getRegdate() %></td>
				</tr>
			<%} %>
		<% if(member != null){ %>
				<tr>
					<td colspan="4"><input id="registQna" type="button" value="글쓰기" /></td>
				</tr>
		<%} %>
		<tr>
			<td colspan="5" style="text-align: center"><a id="blockPage"
				href="/board/qna?currentPage=<%=1%>">◀◀</a> <%if(pager.getCurrentPage() > 1){%>
				<a id="blockPage"
				href="/board/qna?currentPage=<%=pager.getFirstPage() - pager.getBlockSize()%>">◀</a>
				<%}else{ %> <a id="blockPage">◀</a> <%} %> <%for(int i = pager.getFirstPage(); i < pager.getLastPage() + 1; i++){ %>
				<%if(pager.getTotalPage() < i)break; %> <a id="blockPage"
				<%if(pager.getCurrentPage() == i){ %> class="curPage" <%} %>
				href="/board/qna?currentPage=<%=i%>"><%=i %></a> <%} %> <%if(pager.getCurrentPage() == pager.getTotalPage()) {%>
				<a id="blockPage">▶</a> <%} else { %> <a id="blockPage"
				href="/board/qna?currentPage=<%=pager.getLastPage() + 1%>">▶</a>
				<%} %> <a id="blockPage"
				href="/board/qna?currentPage=<%=pager.getTotalPage()%>">▶▶</a></td>
		</tr>
		</table>
	</div>
	<%@ include file="../lecture/inc/footer.jsp"%>
</body>
</html>
