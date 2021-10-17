<%@page import="mul.com.a.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="mul.com.a.dto.CartDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<CartDto> list = (List<CartDto>)request.getAttribute("cartlist");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
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



<h2>장바구니</h2>
<div align="center">
<table border="1">
	<col width="40px">
	<col width="150px">
	<col width="100px">
	<col width="80px">
	<col width="100px">
	
		<tr>
			<th>#</th>
			<th>상품명</th>
			<th>단가</th>
			<th>수량</th>
			<th>금액</th>
		</tr>


<%
if (list == null || list.size() == 0) {
%>
	<tr align="center">
		<td colspan="5">장바구니가 비었습니다</td>
	</tr>
<%
} else {

	for (int i = 0; i < list.size(); i++) {
		CartDto cart = list.get(i);
%>
	<tr>
		<th><%=(i + 1)%></th>

		<%
		if (cart.getOrder_count() == 0) {
		%>
			<td>
				<%=cart.getProduct_name()%>
			</td>
			<%
		} else {
			%>
			<td align="center">
			<font color="#c0c0c0">*** 구매자에의해서삭제되었습니다</font>
			</td>
			<%
		}
		%>

		<td align="center">
			<%=cart.getOrder_count()%>
		</td>
		<td align="center">
			<%=cart.getTotal_price()%>
		</td>
	</tr>
<%
	}

}
%>
</table>
</div>
<br>

<div align="center">
	<button type="button" onclick="deleteAll()">삭제</button>
	<button type="button" onclick="oderlist()">주문</button>
</div>

<script type="text/javascript">
function deleteAll() {
	location.href = "cart/deleteAll.do";
}

function oderlist() {
	location.href = "cart/orderlist.do";
}
</script>

</body>
</html>