<%@page import="mul.com.a.dto.MemberDto"%>
<%@page import="mul.com.a.dto.BbsDto"%>
<%@page import="mul.com.a.dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// seq로 BbsDto를 취득
BbsDto dto = (BbsDto)request.getAttribute("bbs");
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/table.css">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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


<h2>상세 글 보기</h2>

<div align="center">

<table class="table table-bordered">
<col width="200px"><col width="400px">

<tr>
	<th>작성자</th>
	<td><%=dto.getId() %></td>
</tr>
<tr>
	<th>제목</th>
	<td><%=dto.getTitle().replaceAll("\"", "&#34;") %></td>
</tr>

<tr>
	<th>작성일</th>
	<td><%=dto.getWdate() %></td>
</tr>

<tr>
	<th>조회수</th>
	<td><%=dto.getReadcount() %></td>
</tr>

<tr>
	<th>정보</th>
	<td><%=dto.getRef() %>-<%=dto.getStep() %>-<%=dto.getDepth() %></td>
</tr>

<tr>
	<th>내용</th>
	<td>
		<textarea rows="15" cols="90" readonly="readonly"><%=dto.getContent() %></textarea>
	</td>
</tr>

</table>

<button type="button" class="btn btn-info" onclick="location.href='bbslist.do'">글목록</button>
<button type="button" onclick="answerbbs(<%=dto.getSeq() %>)">답글</button>

<%
if(dto.getId().equals( mem.getId() )){
	%>
	<button type="button" onclick="updatebbs(<%=dto.getSeq() %>)">수정</button>	
	<button type="button" onclick="deletebbs(<%=dto.getSeq() %>)">삭제</button>
	<%
}
%>

</div>

<br><br><br><br>

<script type="text/javascript">
function answerbbs(seq) {
	location.href = "bbsanswer.do?seq=" + seq;
}
function updatebbs(seq) {	
	location.href = "bbsupdate.do?seq=" + seq;
}
function deletebbs(seq) {
	location.href = "bbsdelete.do?seq=" + seq;
}
</script>


</body>
</html>

