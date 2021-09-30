<%@page import="jspSample1.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

Member mem = new Member("홍길동");

// 짐싸!
// request.setAttribute("member", mem);
session.setAttribute("member", mem);

// 잘가!
// 1. sendredirect ->		짐을 두고 자신만 이동
 response.sendRedirect("index4.jsp");

// 2. forward	   -> 		짐을 들고 이동
// request.getRequestDispatcher("index4.jsp").forward(request, response);
// pageContext.forward("index4.jsp"); // -> 짐을 들고 이동


%>   
 
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>