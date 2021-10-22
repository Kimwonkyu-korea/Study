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
String add = (String)request.getAttribute("insert");
if(add.equals("YES")){
	%>
	<script type="text/javascript">
	alert("추가되었습니다");
	location.href = "productlist.do";
	</script>
	<%
}else{
	%>
	<script type="text/javascript">
	alert("추가되지 않았습니다");
	location.href = "productlist.do";
	</script>
	<%
}
%>
</body>
</html>