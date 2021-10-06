<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// 처음 시작
String content = request.getParameter("content");
// 초기값
if(content == null) {
	content = "home";
	
}

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table style="width: 500px" border="1" cellpadding="2" cellspacing="0">
<tr>
	<td>
		<jsp:include page="menu.jsp" flush="false" />
	</td>
</tr>

<tr>
	<td>		<!-- 	처음에 home.jsp  -->
		<jsp:include page='<%=content + ".jsp" %>' flush="false" />
	</td>
</tr>

<tr>
	<td>
		<jsp:include page="footer.jsp" flush="false" />
	</td>
</tr>


</table>


</body>
</html>