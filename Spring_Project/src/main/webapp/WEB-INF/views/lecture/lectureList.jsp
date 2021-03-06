<%@page import="com.jscompany.springproject.model.domain.lecture.Lecture"%>
<%@page import="com.jscompany.springproject.common.Pager"%>
<%@page import="com.jscompany.springproject.model.domain.member.Member"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Pager pager = (Pager)request.getAttribute("pager");
	List<Lecture> lectureList = pager.getList();
	Member memberSession = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/resources/css/admin/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/resources/js/lecture/main.js"></script>
<script>
	function back(){
		alert('접근할 수 없습니다');
		history.back();
	}
</script>
</head>
<body>
	<%if(session.getAttribute("member")==null) {%>
		<script>
			back();
		</script>
	<%} else if(memberSession.getTeacher_state_id() !=1){%>
		<script>
			back();			
		</script>
	<%} %>
	<%@ include file="./inc/sidebar_list.jsp"%>

	<table>
		<tr>
			<th>강의명</th>
			<th>가격</th>
			<th>등록일자</th>
			<th>승인여부</th>
			<th></th>
		</tr>
		<%
			int curPos = pager.getCurPos();
			int num = pager.getNum();
		%>
		<%for(int i = 1; i<pager.getPageSize() + 1; i++){ %>
		<%if(num<1)break; %>
		<%Lecture lecture = lectureList.get(curPos++);%>
		<tr>
			<%num--; %>
			<td><%=lecture.getLecture_name() %></td>
			<td>
				<%if(lecture.getPrice() == 0){ %>무료<%} else {%><%=lecture.getPrice()%><%} %>
			</td>
			<td><%=lecture.getRegistDate() %></td>
			<td>
				<%if(lecture.getLecture_use_state() == 1){%> 승인완료 <%} else if(lecture.getLecture_use_state() == 2) {%> 승인반려 <%} else {%> 승인완료 <%} %>
			</td>
			<td>
				<input name="addSection" class="<%=lecture.getLecture_id() %>" type="button" value="섹션추가" style="margin-left:2px;"/>
				<input name = "updateLecture" class="<%=lecture.getLecture_id() %>" type="button" value="수정" style="margin-left:8px;"/>
				<input name = "delLacture" class="<%=lecture.getLecture_id() %>" type="button" value="삭제" style="margin-left:8px;"/>
				<input id="currentPage" type="hidden" value="<%=pager.getCurrentPage()%>"/>
			</td>
		</tr>
		<%} %>
		<tr>
			<td colspan="5" style="text-align: center"><a id="blockPage"
				href="/lecture/list?currentPage=<%=1%>">◀◀</a> <%if(pager.getCurrentPage() > 1){%>
				<a id="blockPage"
				href="/lecture/list?currentPage=<%=pager.getFirstPage() - pager.getBlockSize()%>">◀</a>
				<%}else{ %> <a id="blockPage">◀</a> <%} %> <%for(int i = pager.getFirstPage(); i < pager.getLastPage() + 1; i++){ %>
				<%if(pager.getTotalPage() < i)break; %> <a id="blockPage"
				<%if(pager.getCurrentPage() == i){ %> class="curPage" <%} %>
				href="/lecture/list?currentPage=<%=i%>"><%=i %></a> <%} %> <%if(pager.getCurrentPage() == pager.getTotalPage()) {%>
				<a id="blockPage">▶</a> <%} else { %> <a id="blockPage"
				href="/lecture/list?currentPage=<%=pager.getLastPage() + 1%>">▶</a>
				<%} %> <a id="blockPage"
				href="/lecture/list?currentPage=<%=pager.getTotalPage()%>">▶▶</a></td>
		</tr>
	</table>

</body>
</html>
