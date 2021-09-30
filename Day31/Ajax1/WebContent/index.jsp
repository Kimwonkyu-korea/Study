<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

<%-- AJAX : Asynchronous(비동기) Javascript And Xml --%>

<p id="demo"></p>
<br>
<button type="button">클릭</button>

<script type="text/javascript">
$(document).ready(function() { 	// 문서가 준비되면 실행
	
	$("button").click(function() {
		
		// $("#demo").load("data.html");	 data.html p tag에 넣어라
		
		// $("#demo").load("data.html #data1");
		
		$("#demo").load("data.jsp", "t1=abc&t2=123")	// 파라미터 구분 &
	});
});
</script>

</body>
</html>