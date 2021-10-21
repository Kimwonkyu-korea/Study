<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<meta http-equiv="X-UA-Compatible" content="ie=edge"/>

<title>로그인 - Cafe Order</title>

<link rel="stylesheet" href="https://cdn.materialdesignicons.com/4.8.95/css/materialdesignicons.min.css"/>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>
<link rel="stylesheet" href="./css/account.css"/>

<link rel="shortcut icon" href="./images/favicon.svg"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>

</head> 
<body>

<main class="d-flex align-items-center min-vh-100 py-3 py-md-0">

<div class="container">
	
	<div class="card account-card">
	
       <div class="row no-gutters">
       
         <div class="col-md-5"> <!-- 로그인화면 이미지 -->
           <img src="./images/login.png" alt="login" class="account-card-img"/>
         </div>
        
         <div class="col-md-7">
           <div class="card-body">
           	
             <div class="brand-wrapper"> <!-- 카페오더 로고 -->
               <img src="./images/logo.svg" alt="logo" class="logo"/>
             </div>
             
             <p class="account-card-description">로그인 해주세요.</p>
             
             <!-- 로그인 폼 -->
             <form action="/loginAf.do" method="post" class="form">
                 <div class="form-group"> <!-- 아이디 -->
                   <div align="right">
                   <input type="checkbox" id="chk_save_id"><label for="chk_save_id">아이디 저장</label>
                   </div>
                   <label for="user_id" class="sr-only">ID</label>
                   <input type="text" name="user_id" id="user_id" class="form-control" placeholder="아이디">
                 </div>
                 <div class="form-group mb-4"> <!-- 비밀번호 -->
                   <label for="user_pw" class="sr-only">Password</label>
                   <input type="password" name="user_pw" id="user_pw" class="form-control" placeholder="비밀번호">
                 </div>
                 <input name="login" id="login" class="btn btn-block account-btn mb-4" type="submit" value="로그인">
             </form>
               
               <p class="account-card-footer-text">아직 계정이 없나요? <a href="regi.do" class="text-reset"><b>회원가입</b></a></p>
           
           </div>
         </div>
       </div>
     </div>
</div>

</main>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<script type="text/javascript">

// 아이디 저장 쿠키설정
let user_id = $.cookie("userId");
if(user_id != null){
	$("#user_id").val( user_id );
	$("#chk_save_id").prop("checked", true);
}

$("#chk_save_id").click(function() {
	if( $("#chk_save_id").is(":checked") ){
		if( $("#user_id").val().trim() == "" ){
			alert('먼저 아이디를 입력해 주세요.');
			$("#chk_save_id").prop("checked", false);
		}
		else{
			$.cookie("userId", $("#user_id").val().trim(), { expires:7, path:'./' });	
		}		
	}
	else{
		$.removeCookie("userId", { path:'./' });
	}
});

</script>


</body>
</html>











