<%@page import="mul.com.a.dto.MemberDto"%>
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
MemberDto mem = (MemberDto)session.getAttribute("login");
if(mem == null){
%>
	<script type="text/javascript">
	alert("로그인 해 주십시오");
	location.href = "login.jsp";
	</script>
<%
}
%>

<h2>주문 리스트</h2>

<table border="1">
<tr>
	<th>상품 이름</th>
	<td>
		<input type="text" name="product_name">
	</td>
	<th>상품 가격</th>
	<td>
		<input type="text" name="product_price">
	</td>
	<th>얼음 여부</th>
	<td>
		<input type="text" name="product_ice">
	</td>
	<th>샷 추가</th>
	<td>
		<input type="text" name="product_shot">
	</td>
</tr>
</table>

</body>
</html>