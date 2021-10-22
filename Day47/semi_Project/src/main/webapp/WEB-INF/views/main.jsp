<%@page import="mul.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String content = (String)request.getAttribute("content");
if(content == null || content.equals("")){
	content = "/WEB-INF/views/product/productlist.jsp";
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="shortcut icon" href="./images/favicon.svg"/>

</head>
<body>

<%
MemberDto mem = (MemberDto)session.getAttribute("login");
%>

<h4 align="right" style="color:#fff; background-color:#3e2407">환영합니다, <%=mem.getUser_id() %>님!</h4>

<jsp:include page="menu.jsp" flush="false"/>

<jsp:include page="<%=content %>" flush="true"/>


</body>
</html>