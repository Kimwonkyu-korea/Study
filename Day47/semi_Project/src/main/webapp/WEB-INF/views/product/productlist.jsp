<%@page import="mul.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="path" value="<%=request.getContextPath()%>" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>


<!-- jQuery Modal -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-modal/0.9.1/jquery.modal.min.css" />

<style type="text/css">
ul li {
	display: inline-block;
	margin: 10px;
}

li {
	align-content: center;
}

img {
	width: 200px;
	height: 200px;
}

.productName {
	padding: 10px 0;
	text-align: center;
}

.productPrice {
	padding: 10px 0;
	text-align: right;
	color: #DB8EB5;
	font-size: 20px;
}

.productName a {
	color: #000;
	text-decoration: none;
}

.center {
	position: absolute;
	left: 50%;
	transform: translateX(-50%);
	msTransform: translate(-50%, -50%);
	webkitTransform: translate(-50%, -50%);
}

.modal {
	max-width: 1000px;
	max-height: 1000px;
	width: 70%;
	height: 70%;
}
/*  
ul {
    list-style:none;
    margin:0;
    padding:0;
}

li {
    margin: 0 0 0 0;
    padding: 0 0 0 0;
    border : 0;
    float: left;
}

 */
</style>



</head>
<body>

<%
MemberDto mem = (MemberDto)session.getAttribute("login");
%>

<h4 align="right" style="color:#fff; background-color:#3e2407">환영합니다, <%=mem.getUser_id() %>님!</h4>

<jsp:include page="../menu.jsp" flush="false"/>
<div align="center">
<a href="cartlist.do?user_id=<%=mem.getUser_id() %>">장바구니</a>
</div>
		<div>
			<ul>
				<c:forEach var="row" items="${list}" begin="0" end="15">
					<%--  <li>&nbsp;&nbsp;${row.productId}</li>  --%>
					<li>
						<div style="border: 2px solid #EAEAEA;">
							<div class="productImg">
								<a href="/productdetail.do?productId=${row.productId}" rel="modal:open">
									<img src="/images/product/${row.productUrl}" width="120px" height="110px">
								</a>
							</div>

							<div class="productName">
								<a href="/productdetail.do?productId=${row.productId}">${row.productName}</a>
							</div>
							<div class="productPrice">
								₩&nbsp;
								<fmt:formatNumber value="${row.productPrice}"
									pattern="###,###,###" />
								&nbsp;&nbsp;
							</div>
				      </div>
					</li>
		 	 </c:forEach>
			</ul>
	  </div>
	

</body>
</html>