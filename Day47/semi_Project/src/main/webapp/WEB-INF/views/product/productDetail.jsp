<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 - Cafe Order</title>
<style type="text/css">

.center {
	position: absolute;
	left: 50%;
	transform: translateX(-50%);
	msTransform: translate(-50%, -50%);
	webkitTransform: translate(-50%, -50%);
}

</style>
</head>
<body>
	
			
<div class="center">
	<table border="1">
		<tr>
			<td><img src="/images/product/${dto.productUrl}" width="340"
				height="300"></td>
			<td>
				<table border="1" style="height: 300px; width: 400px;">
					<tr align="center">
						<td>상품명    </td>
						<td>${dto.productName}</td>
					</tr>
					<tr align="center">
						<td>가격</td>
						<td><fmt:formatNumber value="${dto.productPrice}"
								pattern="###,###,###" /></td>
					</tr>
					<tr align="center">
						<td>상품소개</td>
						<td>${dto.productDesc}</td>
					</tr>
					<tr align="center">
						<td colspan="2">
							<form name="form1" method="post" action="/ordercheck.do">
								<input type="hidden" name="productId" value="${dto.productId}"> 
								<input type="hidden" name="productPrice" value="${dto.productPrice}"> 
								<input type="hidden" name="productName" value="${dto.productName}"> 
									<select name="amount">
									<c:forEach begin="1" end="10" var="i">
										<option value="${i}">${i}</option>
									</c:forEach>
								    </select> 
								<input type="submit" value="장바구니에 담기">
							</form> <a href="/productlist.do">상품목록</a>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>
			
		
</body>
</html>