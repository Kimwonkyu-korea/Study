<%@page import="mul.com.a.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="mul.com.a.dto.CartDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
List<CartDto> list = (List<CartDto>)request.getAttribute("cartlist");
CartDto dto = (CartDto)request.getAttribute("dto");
String user_id = (String)request.getAttribute("user_id");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
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

<h2 align="center">장바구니</h2>
<div align="center"><%=mem.getUser_id() %>님</div>
<br></br>

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
	int totalprice = 0;
	for (int i = 0; i < list.size(); i++) {
		CartDto cart = list.get(i);
%>
		<tr>
			<th><%=(i + 1)%></th>
	
			<td align="center">
				<%=cart.getProduct_name()%>
			</td>
		
			<td align="center">
				<%=cart.getProduct_price() %>
			</td>
			<td align="center">
				<%=cart.getOrder_count()%>
			</td>
			<td align="center" id="Toael_price">
				<%=cart.getTotal_price()%>
			</td>
			<td>
				<a href="delete.do?user_id=<%=cart.getUser_id() %>&order_id=<%=cart.getOrder_id() %>">삭제</a>
			</td>	
		</tr>
	<%
      totalprice += cart.getTotal_price();
    }
    %>
	<tr>
		<th align="right" colspan="4">합계</th>
		<td align="center"><%=totalprice %>원</td>
	</tr>
	<%
	}
%>
</table>

</div>

<br>

<div align="center">

<br><br>

<%
if(dto.getUser_id().equals( mem.getUser_id() )){
	%>
	<div align="center">
		<button type="button" onclick="location.href='product.do'">취소</button>
		<button type="button" onclick="deleteAll('<%=user_id%>')">장바구니 비우기</button>	
		<button type="button" onclick="orderlist('<%=user_id%>')">주문</button>	
	</div>
	<% 
}
%>
</div>

<script type="text/javascript">
function orderlist(user_id) {
	location.href = "orderlist.do?user_id=" + user_id;
}

function deleteAll(user_id) {
	location.href = "deleteAll.do?user_id=" + user_id;
}
</script> 

 
</body>
</html>