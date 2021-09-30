<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
// DB로부터 취득한 데이터
String name = "홍길동";
String age = "24";
String birth = "2001/06/17";

// json 사용
String json = "{ \"name\":\"" + name + "\", \"age\":" + age + ", \"birth\":\"" + birth +"\" }";

System.out.println(json);

out.println(json);	// 내장객체 밖으로 내보낸다.
%>
 
<!-- json 밖으로내보냄 -->