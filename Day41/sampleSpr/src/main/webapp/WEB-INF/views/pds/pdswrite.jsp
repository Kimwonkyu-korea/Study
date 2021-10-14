<%@page import="mul.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
MemberDto mem = (MemberDto)session.getAttribute("login");
%>

<h2>자료올리기</h2>
<!-- 자료실 : method="post" enctype="multipart/form-data" -->
<form action="pdsupload.do" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="<%=mem.getId() %>">

<table border="1">
<tr>
	<th>아이디</th>
	<td><%=mem.getId() %></td>	
</tr>

<tr>
	<th>제목</th>
	<td>
		<input type="text" name="title" size="80">  <!-- form field -->
	</td>
</tr>

<tr>
	<th>파일 업로드</th>
	<td>
		<input type="file" name="fileload">		<!-- form field가 아니다 -->
	</td>
</tr>

<tr>
	<th>내용</th>
	<td>
		<textarea rows="10" cols="50" name="content"></textarea>
	</td>
</tr>

<tr>
	<td colspan="2">
		<input type="submit" value="자료올리기">
	</td>
</tr>
</table>

</form>

</body>
</html>
