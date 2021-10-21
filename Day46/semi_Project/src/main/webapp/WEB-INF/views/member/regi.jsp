<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<meta http-equiv="X-UA-Compatible" content="ie=edge"/>

<title>회원가입 - Cafe Order</title>

<link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css" type="text/css"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" type="text/css"/>
<link rel="stylesheet" href="./css/account.css"/>

<link rel="shortcut icon" href="./images/favicon.svg"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>

<main class="d-flex align-items-center min-vh-100 py-3 py-md-0">

<div class="container" style="max-height:611px">

	<div class="card account-card">
	
		<div class="row no-gutters">
		<div class="card-body">
		
			<div class="brand-wrapper" align="center"> <!-- 카페오더 로고 -->
	          <img src="./images/logo.svg" alt="logo" class="logo"/>
	        </div>
	        
	        <p class="account-card-description" style="margin-bottom:0px" align="center">회원가입을 환영합니다!</p>
	        <p style="margin-bottom:24px; font-size:13px; color:#0d2366" align="center">다음의 정보를 입력해주세요.</p>
	        
	        <div align="center">
	        <form action="regiAf.do" method="post">
	        	<div class="form" style="display:inline-block; margin-right:50px">
	        	<div class="form-group"> <!-- 아이디 -->
	        	   <p class="account-card-description-semi" align="left">아이디</p>
                   <input type="text" name="user_id" id="user_id" class="form-control" placeholder="아이디" style="margin-bottom:3px">
                   <div align="left">
	                   <input type="button" class="account-btn-mini" id="btn" value="아이디 확인">
	                   <span id="idcheck" style="font-size:8px"></span>
                   </div>
                </div>
                
                <div class="form-group"> <!-- 비밀번호 -->
                  <p class="account-card-description-semi" align="left">비밀번호</p>
                  <input type="text" name="user_pw" id="user_pw" class="form-control" placeholder="비밀번호">
                </div>
                </div>
                 
                 <div class="form" style="display:inline-block">
                 <div class="form-group" style="margin-bottom:45px"> <!-- 이름 -->
                   <p class="account-card-description-semi" align="left">이름</p>
                   <input type="text" name="user_name" id="user_name" class="form-control" placeholder="이름">
                 </div>
                 
                 <div class="form-group"> <!-- 전화번호 -->
                   <p class="account-card-description-semi" align="left">전화번호</p>
                   <input type="text" name="user_phone" id="user_phone" class="form-control" placeholder="전화번호">
                 </div>
                 </div>
                 
                 <hr>
                 
                 <input type="submit" class="btn btn-block account-btn mb-4 form" value="회원가입">
	        </form>
	        </div>
	        
        </div>
	</div>
	</div>
</div>

</main>

<script type="text/javascript">
$(document).ready(function() {
	
	$("#btn").click(function () {
		
		$.ajax({
			url:"idcheck.do",
			type:"post",
			data:{ id:$("#user_id").val() },
			success:function(resp){
			//	alert('success');
			//	alert(resp);
				if($("#user_id").val() == ""){
					$("#idcheck").css("color", "#dc3545");
					$("#idcheck").html("아이디를 입력해주세요.");
				}
				else if(resp == "YES"){
					$("#idcheck").css("color", "#007bff");
					$("#idcheck").html("이 아이디는 사용할 수 있습니다.");
				}
				else{
					$("#idcheck").css("color", "#dc3545");
					$("#idcheck").html("사용 중인 아이디입니다.");
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