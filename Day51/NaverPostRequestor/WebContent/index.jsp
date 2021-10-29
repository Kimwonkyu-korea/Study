<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
String name = request.getParameter("name");
String message = request.getParameter("message");

// 넘어온 값을 모두 대문자로 변경하는 JSON작성
if(name != null && message != null){
   String json = "{";
   
          json += "name:\"" + name.toUpperCase() + "\",";
          json += "message:\"" + message.toUpperCase() + "\"";
          json += "}";
          
   out.println(json);
}


%>

