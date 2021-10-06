<%@page import="dto.MemberDto"%>
<%@page import="dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
String choice = request.getParameter("choice");
String search = request.getParameter("search");
if(search == null || choice == null || search.equals("")){
	search = "";
	choice = "";
}

BbsDao dao = BbsDao.getInstance();

// page 부분
// 글의 총수 
int len = dao.getAllBbs(choice, search);
System.out.println("글의 총수:" + len);

// 페이지 수
int bbsPage = len / 10;		// 29 / 10 -> 2
if((len % 10) > 0){
	bbsPage = bbsPage + 1;
}

// 현재 페이지
String spageNumber = request.getParameter("pageNumber");
int pageNumber = 0;
if(spageNumber != null){
	pageNumber = Integer.parseInt(spageNumber);
}


//List<BbsDto> list = dao.getBbsList(); 
//List<BbsDto> list = dao.getBbsSearchList(choice, search);
List<BbsDto> list = dao.getBbsPagingList(choice, search, pageNumber);

--%>

<%
	String search = (String)request.getAttribute("search");
	String choice = (String)request.getAttribute("choice");

	int bbsPage = (Integer)request.getAttribute("bbsPage");
	int pageNumber = (Integer)request.getAttribute("pageNumber");
	
	List<BbsDto> list = (List<BbsDto>)request.getAttribute("list");

%>


<%!
// 댓글 깊이와 image를 추가하는 함수
public String arrow(int depth){
	String rs = "<img src='./image/arrow.png' width='20px' height='20px'>";
	String nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";			
	
	String ts = "";
	for(int i = 0;i < depth; i++){
		ts += nbsp;
	}
	
	return depth==0 ? "":ts + rs;
}
// 제목의 문자열의 길이가 28자를 넘을 때 ...으로 표현
public String dot3(String title){
	String str = "";
	if(title.length() >= 30){
		str = title.substring(0, 30);
		str += "...";
	}else{
		str = title;
	}	
	return str;
}

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	// 검색어가 있는 경우
	let search = "<%=search %>";
	if(search == "") return;
	
	// select 처리
	let obj = document.getElementById("choice");
	obj.value = "<%=choice %>";
	obj.setAttribute("selected", "selected");	
});
</script>

</head>
<body>

<%
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
<col width="70px"><col width="500px"><col width="100px"><col width="100px">
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
				<%
				if(bbs.getDel() == 0){
					%>						
					<%=arrow( bbs.getDepth() ) %>				
					<a href="bbsdetail.jsp?seq=<%=bbs.getSeq() %>"><%=dot3(bbs.getTitle()) %></a>
					<%
				}else{
					%>
					<font color="#ff0000">***이 글은 작성자에 위해서 삭제되었습니다***</font>
					<%
				}
				%>
				
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

<%-- 1 [2][3] --%>
<% 
for(int i = 0;i < bbsPage; i++){
	if(pageNumber == i){	// 현재 페이지		1 [2] [3]
		%>
		<span style="font-size: 15pt; color: #0000ff; font-weight: bold;">
			<%=i + 1 %>
		</span>&nbsp;
		<%
	}
	else{					// 그 외의 페이지
		%>
		<a href="#none" title="<%=i + 1 %>페이지" onclick="goPage(<%=i %>)"
			style="font-size: 15pt;color: #000; font-weight: bold; text-decoration: none;">
			[<%=i + 1 %>]
		</a>&nbsp;
		<%
	}
}
%>
<br><br>
<div align="center">

<select id="choice">
	<option value="title">제목</option>
	<option value="content">내용</option>
	<option value="id">작성자</option>
</select>

<input type="text" id="search" value="<%=search %>">

<button type="button" onclick="searchBbs()">검색</button>

</div>

<br>	
	<a href="bbs?param=bbswrite">글쓰기</a>

</div>

<script type="text/javascript">
function searchBbs() {
	let choice = document.getElementById("choice").value;
	let search = document.getElementById("search").value;
	
//	alert(choice);
//	alert(search);
	location.href = "bbs?param=bbslist&choice=" + choice + "&search=" + search;
}


function goPage( pageNum ) {
	let choice = document.getElementById("choice").value;
	let search = document.getElementById("search").value;
	
	location.href = "bbs?param=bbslist&choice=" + choice + "&search=" + search + "&pageNumber=" + pageNum;
}


</script>



</body>
</html>









