<%@page import="mul.com.a.dto.CartDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



<%
List<CartDto> list = (List<CartDto>)request.getAttribute("orderlist");
System.out.println(list.toString());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문확인 - Cafe Order</title>
</head>
<body>

<!-- 현재 무조건 결제완료 창으로 넘어가게 해놨음!! 나중에 결제수단 구현하면 링크 바꿔주기 -->
<!-- 주문한 게 없는데 주문하기 버튼 누를경우: 주문 먼저 해달라는 글 띄우기 -->

<div align="center" class="order_Allwrapper">

<h3>주문 정보</h3>

<table>
<col width="300px"><col width="100px"><col width="70px"><col width="100px">

<thead>
<tr>
	<th>메뉴</th><th>가격</th><th>수량</th><th>총액</th>
</tr>
</thead>

<tbody>


<%-- 
<%
if(list == null || list.size() == 0){	// 받아온 장바구니가 없거나 장바구니에 메뉴가 하나도 없는 경우
%>	
	<tr align="center">
		<td colspan="4" style="color:gray">아직 주문하신 메뉴가 없어요!</td>
	</tr>
<%	
} else{	// 장바구니가 담은 메뉴가 있는 경우
	
	int totalprice = 0;
	for(int i = 0 ; i < list.size() ; i++) {
		CartDto cart = list.get(i);
	%>
	
	
	<tr align="center">
		<th><%=cart.getProduct_name() %></th>
		<td><%=cart.getProduct_price() %></td>
		<td><%=cart.getOrder_count() %></td>
		<td><%=cart.getTotal_price() %></td>
		<td>
			<a href="delete.do?user_id=<%=cart.getUser_id() %>&product_name=<%=cart.getProduct_name() %>">삭제</a>
		</td>
	</tr>

	
	<%
		totalprice += cart.getTotal_price();
	}
	%>
	<tr>
		<th align="right" colspan="3">합계</th>
		<td><%=totalprice %>원</td>
	</tr>
<%
}	
%>
 --%>
<%-- 
	<tr align="center">
		<th>${dto.productName}</th>
		<td>${dto.product_price}</td>
		<td>${dto.order_count}</td>
		<td>${dto.total_price}</td>
		<td>
			<a href="delete.do?user_id=${row.user_id}&product_name=${row.product_name}">삭제</a>
		</td>
	</tr>

	<tr>
		<th align="right" colspan="3">합계</th>
		<td>${dto.total_price}원</td>
	</tr>
  --%>
</tbody>
</table>

<br><br>

<input type="button" id="orderBtn_payment" onclick="location.href = 'paysuccess.do'" value="결제하기">
<input type="button" id="orderBtn_payment" onclick="history.back()" value="결제취소">

</div>


</body>
</html>