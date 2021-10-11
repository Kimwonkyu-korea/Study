<%@page import="mul.com.a.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% // 짐을 푼다
List<MemberDto> list = (List<MemberDto>)request.getAttribute("memlist");
%>            
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>allMember.jsp</title>
</head>
<body>

<table border="1">
<%
	for(int i = 0;i < list.size(); i++){
		MemberDto dto = list.get(i);
		%>	
		<tr>
			<th><%=i + 1 %></th>
			<td><%=dto.getId() %></td>
			<td><%=dto.getName() %></td>
			<td><%=dto.getEmail() %></td>
		</tr>
		<%
	}
%>
</table>

</body>
</html>




