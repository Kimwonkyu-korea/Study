<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>

<p id="show"></p>

<script type="text/javascript">
$(function() {
		
	$.ajax({
		url:"json.do",
		type:"get",
		dataType:"json",
		success:function(data) {
		//	alert("success");
		//	console.log(data);
		
			let str = JSON.stringify(data, null, 2);
			
			$("#show").append(str);
		},
		error:function(){
			alert("error");	
		}
	});
	
});
</script>

</body>
</html>