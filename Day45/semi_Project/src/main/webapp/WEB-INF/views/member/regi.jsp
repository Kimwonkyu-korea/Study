<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>regi</title>

<style type="text/css">
.center{
	margin: auto;
	width: 60%;
	border: 3px solid;
	padding: 10px;	
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>

<h2>회원가입</h2>
<p>회원가입을 환영합니다</p>

<div class="center">

<form action="regiAf.do" method="post">

<table border="1">
<tr>
	<th>아이디</th>
	<td>
		<input type="text" name="user_id" id="user_id" size="20"><br>
		<p id="idcheck" style="font-size: 8px"></p>
		<input type="button" id="btn" value="id확인">
	</td>
</tr>
<tr>
	<th>패스워드</th>
	<td>
		<input type="text" name="user_pw" size="20">
	</td>
</tr>
<tr>
	<th>이름</th>
	<td>
		<input type="text" name="user_name" size="20">
	</td>
</tr>
<tr>
	<th>핸드폰</th>
	<td>
		<input type="text" name="user_phone" size="20">
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="회원가입">
	</td>
</tr>

</table>
</form>
</div>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#btn").click(function () {
		
		$.ajax({
			url:"idcheck.do",
			type:"post",
			data:{ id:$("#user_id").val() },
			success:function(resp){
				alert('success');
				alert(resp);
				
				if(resp == "YES"){
					$("#idcheck").css("color", "#0000ff");
					$("#idcheck").html("이 ID는 사용할 수 있습니다");
				}
				else{
					$("#idcheck").css("color", "#ff0000");
					$("#idcheck").html("사용 중인 ID입니다");
					$("#user_id").val("");
					$("#user_id").focus();
				}
			},
			error:function(){
				alert('error');
			}
		});
		
	});
	
});
</script>
</body>
</html>