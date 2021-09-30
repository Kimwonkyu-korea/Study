<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
// 배열
String hobby[] = request.getParameterValues("hobby");

int age = Integer.parseInt( request.getParameter("age"));
String text = request.getParameter("text");
%>

  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>전송된 정보</h1>
id:<%=id %><br>
pw:<%=pwd %><br>

<%
if(hobby != null) {
	for(int i=0; i< hobby.length; i++){
		%>
		취미:<%=hobby[i] %><br>
		<%
	}
}
%>
연령:<%=age %>대<br>
<br>
<%
if(text.equals("") == false) {
	%>
	하고싶은 말<br><%=text%>
	<%
}
%>


</body>
</html>