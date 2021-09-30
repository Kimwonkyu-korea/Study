<%@page import="func.UtilClass"%>
<%@page import="jspSample1.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%!
// 선언부 : 전역변수(값을 유지), class, function
int gl_number = 0; // 전역변수(값을 유지)
%>

<%
// 코드부
gl_number++;

int number = 0;
number++;
%>

<!--  value -->
전역변수: <%=gl_number %>
지역변수: <%=number %>

<%!
class Human{
	private String name;
	
	public Human(String name){	// 생성자
		this.name = name;
	}
	public String toString(){
		return this.name;
	}
}
%>

<%
	Human h = new Human("홍길동");
	System.out.println(h.toString());
	
	Member m = new Member("성춘향");
	System.out.println(m.toString());
%>


<%!
public int func(int n1, int n2){
	return n1 * n2;
}
%>

<%
System.out.println(func(12,34));

System.out.println( UtilClass.func(56, 78));

%>

<%=func(12,34)%>

<%=UtilClass.func(56, 78)%>

</body>
</html>