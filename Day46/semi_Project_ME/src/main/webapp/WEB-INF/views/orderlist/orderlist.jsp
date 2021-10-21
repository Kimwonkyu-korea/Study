<%@page import="java.util.List"%>
<%@page import="mul.com.a.dto.CartDto"%>
<%@page import="mul.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<CartDto> list = (List<CartDto>)request.getAttribute("orderlist");
CartDto dto = (CartDto)request.getAttribute("dto");
%>   
    
    
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


<h2 align="center">주문내역</h2>
<div align="center"><%=mem.getUser_id() %>님의 주문내역</div>
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
		<td colspan="5">주문내역이 없습니다.</td>
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
<br>
<button type="button">취소</button>
<button type="button">결제</button>
</div>


</body>
</html>