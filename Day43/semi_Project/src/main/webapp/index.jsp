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
response.sendRedirect("login.do");
%>
<%-- 
<form action="login.do" method="get">

<input type="submit" value="이동">
</form>
--%>
<%--
<button type="button" onclick="account()">이동</button>

<script type="text/javascript">
function account() {	
	location.href = "cartlist.do";

</script>
--%>
</body>
</html>