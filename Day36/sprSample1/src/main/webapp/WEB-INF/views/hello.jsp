<%@page import="mul.com.a.Human"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>hello JSP</h2>

<%
// 짐을 푼다
String name = (String)request.getAttribute("name");
%>

이름:<%=name %><br><br>

이름:${name}	<!--(속성값), jsp만 가능 , EL tag, Core tag-->

<form action="home.do" method="get">
이름:<input type="text" name="name">
<br>
나이:<input type="text" name="age">
<br>
<input type="submit" value="전송">
</form>

<%
Human hu = (Human)request.getAttribute("human");
if( hu == null) {
	hu = new Human("김영희", 22);
}
%>

이름:<input type="text" name="<%=hu.getName() %>">
<br>
나이:<input type="text" name="<%=hu.getAge() %>">
<br><br>

이름:<input type="text" value="${human.name}">
<br>
나이:<input type="text" value="${human.age}">

</body>
</html>