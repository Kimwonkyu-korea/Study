<%@page import="mul.com.a.dto.AdminDto"%>
<%@page import="java.util.List"%>
<%@page import="mul.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<AdminDto> list = (List<AdminDto>)request.getAttribute("memberlist");
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

<h2 align="center">회원정보</h2>

<br></br>

<div align="center">

<table border="1">
	<col width="40px">
	<col width="150px">
	<col width="100px">
	<col width="80px">
	<col width="200px">
	
		<tr>
			<th>#</th>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>핸드폰</th>
		</tr>

<%
if (list == null || list.size() == 0) {
%>
	<tr align="center">
		<td colspan="5">회원목록이 없습니다.</td>
	</tr>
<%
} else {
	int totalprice = 0;
	for (int i = 0; i < list.size(); i++) {
		AdminDto admin = list.get(i);
%>
		<tr>
			<th><%=(i + 1)%></th>
	
			<td align="center">
				<%=admin.getUser_name()%>
			</td>
		
			<td align="center">
				<%=admin.getUser_id() %>
			</td>
			<td align="center">
				<%=admin.getUser_pw()%>
			</td>
			<td align="center">
				<%=admin.getUser_phone()%>
			</td>
		</tr>
	<%
	}
}
%>
</table>
</div>

</body>
</html>