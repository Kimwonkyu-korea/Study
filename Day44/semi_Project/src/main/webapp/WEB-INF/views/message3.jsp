<%@page import="mul.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% // 출력해보기
boolean b = (boolean)request.getAttribute("b");
System.out.println(b);
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%

if(b){
%>
	<script type="text/javascript">
	alert("삭제되었습니다");
	location.href = "cartlist.do;
	</script>
<%
} else{
%>
	<script type="text/javascript">
	alert("삭제되지 않았습니다.");
	location.href = "cartlist.do;
	</script>	
<%
}
%>


</body>
</html>