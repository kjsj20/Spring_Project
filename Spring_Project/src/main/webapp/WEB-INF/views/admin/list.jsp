<%@page import="com.jscompany.springproject.common.Pager"%>
<%@page import="com.jscompany.springproject.model.domain.member.Member"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Pager pager = (Pager)request.getAttribute("pager");
	List<Member> memberList = pager.getList();
	Member memberSession = (Member)session.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/resources/css/admin/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/resources/js/admin/main.js"></script>
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
	<%} else if(memberSession.getAdmin_state() !=1){%>
		<script>
			back();			
		</script>
	<%} %>
	<%@ include file="./inc/sidebar.jsp"%>

	<table>
		<tr>
			<th>이메일</th>
			<th>이름</th>
			<th>가입일자</th>
			<th>인증여부</th>
			<th></th>
		</tr>
		<%
			int curPos = pager.getCurPos();
			int num = pager.getNum();
		%>
		<%for(int i = 1; i<pager.getPageSize() + 1; i++){ %>
		<%if(num<1)break; %>
		<%Member member = memberList.get(curPos++);%>
		<tr>
			<%num--; %>
			<td><%=member.getE_mail() %></td>
			<td><%=member.getUser_name() %></td>
			<td><%=member.getJoindate() %></td>
			<td>
				<%if(member.getAuthstatus() == 1){%> 인증완료 <%} else {%> 인증미완료 <%} %>
			</td>
			<td>
				<input id="<%=member.getMember_id()%>" class="delMember" type="button" value="삭제"/>
				<input id="currentPage" type="hidden" value="<%=pager.getCurrentPage()%>"/>
			</td>
		</tr>
		<%} %>
		<tr>
			<td colspan="5" style="text-align: center"><a id="blockPage"
				href="/admin/list?currentPage=<%=1%>">◀◀</a> <%if(pager.getCurrentPage() > 1){%>
				<a id="blockPage"
				href="/admin/list?currentPage=<%=pager.getFirstPage() - pager.getBlockSize()%>">◀</a>
				<%}else{ %> <a id="blockPage">◀</a> <%} %> <%for(int i = pager.getFirstPage(); i < pager.getLastPage() + 1; i++){ %>
				<%if(pager.getTotalPage() < i)break; %> <a id="blockPage"
				<%if(pager.getCurrentPage() == i){ %> class="curPage" <%} %>
				href="/admin/list?currentPage=<%=i%>"><%=i %></a> <%} %> <%if(pager.getCurrentPage() == pager.getTotalPage()) {%>
				<a id="blockPage">▶</a> <%} else { %> <a id="blockPage"
				href="/admin/list?currentPage=<%=pager.getLastPage() + 1%>">▶</a>
				<%} %> <a id="blockPage"
				href="/admin/list?currentPage=<%=pager.getTotalPage()%>">▶▶</a></td>
		</tr>
	</table>

</body>
</html>
