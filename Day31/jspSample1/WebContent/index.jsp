
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 

%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- html 주석문 -->

<%-- jsp 주석문 --%>

<%--
		JSP : Java Server Page
			  Server(Web)를 통해서 client form을 생성하는 코드
			  
			  
			  http://localhost:8090(ip 주소)/jspSample1/index.jsp
			  
			  http://www.myappwork.co.kr -> domain name 할당   		
			     		
			  		request			Web Application Server(WAS)
		client	 ------------ >	server		container
											index.jsp
					
											servlet/jsp
				 < ----------- 
				 	response
				 	
				 	
				Servlet -> java(html)
				JSP -> html + java		가독성 -> jsp 좋은 편은 아님.
				
				script + applet = scriptlet -> Java 영역
				
				내장(암시) 객체 : 생성하지 않고 바로 사용 가능한 객체
				String name request.getParameter("name");
				
				브라우저 마우스로 호출 시
				html -> 코드에 해당되는 화면 나옴
				JSP  -> 해당 코드가 나옴 
				
				JSP 코드를 상단
				Ajax는 하단
 --%>
 
 <h1>Hello JSP</h1>
 <h3>h3 tag</h3>
 <p>p tag</p>
 
 <button type="button">button</button>
 
<%
//	java area(영역) == scriptlet

	System.out.println("Hello JSP");	// java 사용가능
%>
 
<%
	String str = "Hello Jsp";
	int number = 1024;
%> 

 <p><%=str %></p>

 <input type="text" size="20" value="<%=number %>">
 
 <br>
 
 
 <%
 // out : web에 출력을 할수 있는 객체
 
 	out.println("<h2>" + str + number + "</h2>");
 %>
 
 <h2 style=""><%=str %><%=number %></h2>	<%-- tag 접근 가능 --%>
 
 <%
 for(int i = 0; i < 10; i++) {
 %>
 	<p>hello p tag<%=(i + 1) %></p>
 <%
 }
 %>
 
</body>
</html>