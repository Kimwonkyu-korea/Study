<%@page import="mul.com.a.util.BbsUtil"%>
<%@page import="mul.com.a.dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="mul.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

String search = (String)request.getAttribute("search");
if(search == null) search = "";
String choice = (String)request.getAttribute("choice");

int bbsPage = (Integer)request.getAttribute("bbsPage");
int pageNumber = (Integer)request.getAttribute("pageNumber"); // 현재 페이지

List<BbsDto> list = (List<BbsDto>)request.getAttribute("bbslist");	
%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link type="text/css" rel="stylesheet" href="./css/table.css">

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

<div align="center">

<table class="type02">
<col width="70px"><col width="550px"><col width="100px"><col width="100px">
<tr>
	<th>번호</th><th>제목</th><th>조회수</th><th>작성자</th>
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
			
				<%
				if(bbs.getDel() == 0){
					%>
					<td class="titleTd">						
					<%=BbsUtil.arrow( bbs.getDepth() ) %>				
					<a href="bbsdetail.jsp?seq=<%=bbs.getSeq() %>"><%=BbsUtil.dot3(bbs.getTitle()) %></a>
					</td>
					<%
				}else{
					%>
					<td align="center">
					<font color="#c0c0c0">*** 이 글은 작성자에 위해서 삭제되었습니다 ***</font>
					</td>
					<%
				}
				%>
				
			
			<td align="center"><%=bbs.getReadcount() %></td>
			<td align="center">
				<%=bbs.getId() %>
			</td>
		</tr>
<%
	}
}
%>
</table>

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

<select id="choice" style="height:25px; vertical-align: middle">
	<option value="title">제목</option>
	<option value="content">내용</option>
	<option value="id">작성자</option>
</select>

<input type="text" id="search" value="<%=search %>" style="height:20px">

<button type="button" onclick="searchBbs()" style="height:25px; vertical-align: middle">검색</button>

</div>

<br>	
	<a href="bbswrite.do">글쓰기</a>

</div>

<script type="text/javascript">
$(function () {
	$(".titleTd").mouseover(function() {		
		$(this).css("background", "#e0e0e0");
	});
	$(".titleTd").mouseout(function() {
		$(this).css("background", "#ffffff");
	});	
});

function searchBbs() {
	let choice = document.getElementById("choice").value;
	let search = document.getElementById("search").value;

	location.href = "bbslist.do?choice=" + choice + "&search=" + search;
}

function goPage( pageNum ) {
	let choice = document.getElementById("choice").value;
	let search = document.getElementById("search").value;
	
	location.href = "bbslist.do?choice=" + choice + "&search=" + search + "&pageNumber=" + pageNum;
}

</script>

</body>
</html>





