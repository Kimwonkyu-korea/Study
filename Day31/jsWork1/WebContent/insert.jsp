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

<!-- <form action="insertAf.jsp"> -->
<form id="frm">

아이디:<input type="text" name="id" id="id" size="20px"> <br> 
패스워드:<input type="password" name="pwd" id="pwd" size="20px"> <br>
<br><br>

취미
<br>
잠자기<input type="checkbox" name="hobby" value="sleep"> 
노래하기<input type="checkbox" name="hobby" value="sing">
게임하기<input type="checkbox" name="hobby" value="game">
<br><br>
연령대
<br>
10대<input type="radio" name="age" value="10" checked="checked"> 
20대<input type="radio" name="age" value="20"> 
30대<input type="radio" name="age" value="30">
40대<input type="radio" name="age" value="40"> 
50대<input type="radio" name="age" value="50"> 
60대 이상<input type="radio"  name="age" value="60">
<br>

	
기타하고싶은말<br>
<textarea rows="10" cols="30" name="text"></textarea>

<!-- <input type="submit" value="전송"> -->
<button type="button" id="send">전송</button>
<input type="reset" value="취소">

</form>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#send").click(function() {
	//	alert('send');
		// getter
		if($("#id").val().trim() == ''){
			alert('id를 입력해 주십시오');
			$("#id").focus();
			
			//setter
			$("#id").val(""); 
			
			return;
		}
	
		// location.href = "insertAf.jsp?id="
		$("#frm").attr("action", "insertAf.jsp").submit();
	});
	
});
</script>


</body>
</html>