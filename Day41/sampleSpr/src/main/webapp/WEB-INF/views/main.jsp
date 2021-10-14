<%@page import="mul.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String content = (String)request.getAttribute("content");
if(content == null || content.equals("")){
	content = "bbs/bbslist.jsp";
}
else if(content.equals("bbswrite")){
	content = "bbs/bbswrite.jsp";	
}
else if(content.equals("bbsdetail")){
	content = "bbs/bbsdetail.jsp";
}
else if(content.equals("answerUpdate")){
	content = "bbs/bbsanswer.jsp";
}
else if(content.equals("answerInsert")){
	content = "bbs/bbsanswer.jsp";
}
else if(content.equals("bbsupdate")){
	content = "bbs/bbsupdate.jsp";
}

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<body>

<%
MemberDto mem = (MemberDto)session.getAttribute("login");
%>
<h4 align="right" style="background-color: #f0f0f0">환영합니다 <%=mem.getId() %>님 반갑습니다</h4>

<jsp:include page="menu.jsp" flush="false"/>

<jsp:include page="<%=content %>"/>


</body>
</html>