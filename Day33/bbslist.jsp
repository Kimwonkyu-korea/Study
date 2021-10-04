<%@page import="dto.MemberDto"%>
<%@page import="dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String choice = request.getParameter("choice");
String search = request.getParameter("search");
if(choice == null){
	choice = "";
}
if(search == null){
	search = "";
}
// getBbsList();  넘겨줘야됌

BbsDao dao = BbsDao.getInstance();

// List<BbsDto> list = dao.getBbsList(); 
List<BbsDto> list = dao.getBbsSearchList(choice, search);
%>    

<%!
// 댓글 깊이와 image를 추가하는 함수
public String arrow(int depth){
	String rs = "<img src='./image/arrow.png' width='20px' height='20px'>";
	String nbsp = "&nbsp&nbsp&nbsp&nbsp";
	
	String ts = "";
	for(int i = 0; i<depth; i++){
		ts += nbsp;
	}
	// 0이면 빈칸, 0이아니면 이미지
	return depth==0 ? "":ts + rs;
}
%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
// 공용
MemberDto mem = (MemberDto)session.getAttribute("login");
if(mem == null){
%>
	<script type="text/javascript">
	alert("로그인 해 주십시오");
	location.href = "login.jsp";
	</script>
<%
}
%>

<h2>게시판</h2>

<div align="center">

<table border="1">
<col width="70px"><col width="500px"><col width="100px">
<tr>
	<th>번호</th><th>제목</th><th>정보</th><th>작성자</th>
</tr>

<%
if(list == null || list.size() == 0){
%>
	<tr>
		<td colspan="3">작성된 글이 없습니다</td>
	</tr>
<%
}else{
	
	for(int i = 0;i < list.size(); i++){
		BbsDto bbs = list.get(i);
%>
		<tr>
			<th><%=(i + 1) %></th>
			<td>
				<%=arrow( bbs.getDepth() ) %>
			
				<%-- <!-- <%=bbs.getTitle() %> --> --%>
				<a href="bbsdetail.jsp?seq=<%=bbs.getSeq() %>"><%=bbs.getTitle() %></a>
			</td>
			<td><%=bbs.getRef() %>-<%=bbs.getStep() %>-<%=bbs.getDepth() %></td>
			<td>
				<%=bbs.getId() %>
			</td>
		</tr>
<%
	}
}
%>

</table>

<br>

<div align="center">

<select id="choice">
	<option value="title">제목</option>
	<option value="content">내용</option>
	<option value="id">작성자</option>
</select>

<input type="text" id="search" value="">

<button type="button" onclick="searchBbs()">검색</button>

</div>


<br>	
	<a href="bbswrite.jsp">글쓰기</a>
</div>

<script type="text/javascript">
function searchBbs() {
	let choice = document.getElementById("choice").value;
	let search = document.getElementById("search").value;
	
//	alert(choice);
//	alert(search);
	location.href = "bbslist.jsp?choice=" + choice + "&search=" + search;
}
</script>

</body>
</html>









