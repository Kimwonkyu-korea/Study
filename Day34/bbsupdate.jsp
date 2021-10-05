<%@page import="dto.MemberDto"%>
<%@page import="dto.BbsDto"%>
<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% // 한글깨짐방지
request.setCharacterEncoding("utf-8");
// int형으로 바꿈
int seq = Integer.parseInt( request.getParameter("seq") );

BbsDao dao = BbsDao.getInstance();

// readcount 증가
BbsDto dto = dao.getBbs(seq);

dao.readcount(seq);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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

<h2>글 수정</h2>

<div align="center">
<form action="bbsupdateAf.jsp" method="post">
<!-- seq 넘기기 위해 -->
<input type="hidden" name="seq" value="<%=seq %>">

<table border="1">
<col width="200px"><col width="400px">
<tr>
	<th>작성자</th>
	<td size="50px" ><%=dto.getId() %></td>
</tr>

<tr>
	<th>제목</th>
	<td>
		<input type="text" name="title" size="100px" value="<%=dto.getTitle() %>">
	</td>
</tr>

<tr>
	<th>내용</th>
	<td>
		<input type="text" size="250px"  name="content" value="<%=dto.getContent() %>">
	</td>
</tr>
<tr>
    <td colspan="2">
        <input type="submit" value="수정하기">   
    </td>
</tr>


</table>
</form>
</div>


</body>
</html>