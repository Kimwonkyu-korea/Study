<%@page import="mul.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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

<h2 align="center">관리자페이지</h2>

<div>
	<div align="center">
		<button type="button" onclick="memberlist('<%=mem.getUser_id()%>')">회원정보</button>
	</div>
</div>

<script type="text/javascript">
function memberlist(user_id) {
	location.href = "memberlist.do?user_id=" + user_id;
}

</script>




</body>
</html>