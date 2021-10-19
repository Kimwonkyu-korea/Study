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

<p><%=mem.getUser_id() %> 님 환영합니다</p>

<form action="productAf.do" method="post">
<table border="1">
<tr>
	<th>order_id</th>
	<td>
		<input type="text" name="order_id">
	</td>
	
	<th>유저 id</th>
	<td>
		<input type="text" name="user_id" value="<%=mem.getUser_id() %>">
	</td>
	
	<th>상품 번호</th>
	<td>
		<input type="text" name="product_id">
	</td>
	<th>날짜</th>
	<td>
		<input type="text" name="order_date">
	</td>
	<th>합계</th>
	<td>
		<input type="text" name="total_price">
	</td>
	<th>상품 이름</th>
	<td>
		<input type="text" name="product_name">
	</td>
	<th>수량</th>
	<td>
		<input type="text" name="order_count">
	</td>
	<th>단가</th>
	<td>
		<input type="text" name="product_price">
	</td>
</tr>
<tr>
	<td colspan="8" align="center">
		<input type="submit" value="장바구니 담기">
	
	</td>
</tr>

</table>

<a href="cartlist.do?user_id=<%=mem.getUser_id() %>">주문목록</a>


</form>
</body>
</html>