# Spring_boot(로그인, 회원가입, 게시판)

pom.xml  설정 후 

서버 실행되는지 확인

application.properties 에서 port번호와 DB 설정

DatabaseConfig 에서 ("DatabaseConfig sqlSessionFactory"); 확인



이노테이션

Controller

- RestController 
- Autowired
- @RequestMapping



Dao

- Mapper

- Repository



Service

- Service
- Transactionnal

- Autowired



중간중간 확인해야될 절차

- Controller 까지 완성 후 localhost로 GET방식 확인 



#### sprBootBack

sqls / Member.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="mul.com.a.dao.MemberDao">
// 아이디 확인
<select id="idcheck" parameterType="String" resultType="Integer">
	SELECT NVL(COUNT(*), 0)
	FROM MEMBER
	WHERE ID=#{id}
</select>
    
// 회원가입
<insert id="addMember" parameterType="mul.com.a.dto.MemberDto">
	INSERT INTO MEMBER(ID, PWD, NAME, EMAIL, AUTH)
	VALUES(#{id}, #{pwd}, #{name}, #{email}, 3 )
</insert>

// 로그인
<select id="login" parameterType="mul.com.a.dto.MemberDto" resultType="mul.com.a.dto.MemberDto">
	SELECT ID, NAME, EMAIL, AUTH
	FROM MEMBER
	WHERE ID=#{id} AND PWD=#{pwd}
</select>

</mapper>
```





mul.com.a.dao / MemberDao.java

```java
package mul.com.a.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.com.a.dto.MemberDto;

@Mapper
@Repository
public interface MemberDao {
	
	int idcheck(String id);	// .xml에 resultType
	int addMember(MemberDto dto);
	MemberDto login(MemberDto dto);
}

```



mul.com.a.dao / MemberService.java

```java
package mul.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.com.a.dao.MemberDao;
import mul.com.a.dto.MemberDto;

@Service
@Transactional
public class MemberService {
// dao로 부터 편집
	
	@Autowired
	private MemberDao dao;
	
	public boolean idcheck(String id) {
		int n = dao.idcheck(id);
		return n>0?true:false;
	}
	
	public boolean addMember(MemberDto dto) {
		int n = dao.addMember(dto);
		return n>0?true:false;
	}
	
	public MemberDto login(MemberDto dto) {
		return dao.login(dto);
	}
}
```



mul.com.a.controller / MemberController.java

```java
package mul.com.a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mul.com.a.dto.MemberDto;
import mul.com.a.service.MemberService;

@RestController // restful    @Controller + @ResponseBody
public class MemberController {

	@Autowired
	MemberService service;	
	
	@RequestMapping(value = "/idcheck", method = RequestMethod.POST)
	public String idcheck(String id) {
		System.out.println("MemberController idcheck");
		System.out.println("id:" + id);
		
		boolean b = service.idcheck(id);
		if(b) { // 있다
			return "YES";
		}else { // 없다
			return "NO";
		}
	}
	

	@RequestMapping(value = "/addMember", method = RequestMethod.POST)
	public String addMember(MemberDto dto) {
		System.out.println("MemberController addMember()");
		System.out.println(dto.toString());
		
		boolean b = service.addMember(dto);
		if(b == true) {	// 추가	
			return "OK";
		}
		return "NG";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public MemberDto login(String id, String pwd) {	// 매개변수 dto도 가능
		System.out.println("MemberController login");
		
		MemberDto dto = service.login(new MemberDto(id, pwd, "", "", 0));
		return dto;
	}
}
```



#### sprBootFront

WebContent에 생성해주기

index.html을 만들어서 location.href = "login.html"; 바로 이동시켜주기



login.html

```html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style type="text/css">
#app{
	margin: auto;
	margin-top: 60px;
	width: 60%;
	border: 3px solid #8ac007;
	padding: 10px;
}
</style>

</head>
<body>

<h1>login</h1>


<div id="app">	
	<table border="1">
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" id="id" placeholder="아이디입력" size="20">
		</td>
	</tr>
	<tr>
		<td>패스워드</td>
		<td>
			<input type="text" id="pwd" placeholder="패스워드입력" size="20">
		</td>
	</tr>
	
	<tr>
		<td colspan="2">
			<button type="button" id="login">login</button>		
			<!-- 회원가입으로 이동 -->
			<button type="button" onclick="account()">회원가입</button>
		</td>
	</tr>
	</table>	
</div>

<script type="text/javascript">
function account() {
	location.href = "regi.html";
}

$("#login").click(function(){
	$.ajax({
		url:"http://localhost:3000/login",
		type:"post",
		data:{ id:$("#id").val(), pwd:$("#pwd").val() },
		success:function(resp){
		//	alert('success');
		//	alert(JSON.stringify(resp));
		
			if(resp == ""){
				alert("id나 password를 확인해 주십시오");				
			}
			else{ // login 성공!
				alert(resp.name + "님 환영합니다");
			
				// session에 저장 setAttribute( , ) getAttribute()
				sessionStorage.setItem("login", JSON.stringify(resp)); // <- server에 저장하는 것은 아니다
				
				location.href = "bbslist.html";			
			}
		
		},
		error:function(){
			alert('error');
		}
	});
});
</script>
</body>
</html>
```



regi.html

```html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style type="text/css">
#app{
	margin: auto;
	margin-top: 60px;
	width: 60%;
	border: 3px solid #8ac007;
	padding: 10px;
}
</style>

</head>
<body>

<h1>회원가입</h1>

<div id="app">	
	<form id="frm">

	<table border="1">
	<tr>
		<td>아이디</td>
		<td>
			<input type="text" id="id" name="id" placeholder="아이디입력" size="20">
			<p id="idcheck"></p>
			<button type="button" id="idcheckbtn">중복확인</button>
		</td>
	</tr>
	<tr>
		<td>패스워드</td>
		<td>
			<input type="text" id="pwd" name="pwd" placeholder="패스워드입력" size="20">
		</td>
	</tr>	
	<tr>
		<td>이름</td>
		<td>
			<input type="text" id="name" name="name" placeholder="패스워드입력" size="20">
		</td>
	</tr>
	<tr>
		<td>이메일</td>
		<td>
			<input type="text" id="email" name="email" placeholder="패스워드입력" size="20">
		</td>
	</tr>	
	
	<tr>
		<td colspan="2">
			<button type="button" id="account">회원가입</button>
		</td>
	</tr>	
	
	</table>
	</form>	
</div>

<script type="text/javascript">
$(document).ready(function () {
	
	$("#idcheckbtn").click(function () {
	//	alert('idcheckbtn');
	
		// id첵크
	
		$.ajax({
			url:"http://localhost:3000/idcheck",
			type:"post",
			data:{ id:$("#id").val() },
			success:function( resp ){
			//	alert('success');
			
				if(resp.trim() == "YES"){
					$("#idcheck").html("사용중인 아이디입니다");
					$("#id").val("");
				}else{
					$("#idcheck").html("사용할 수 있는 아이디입니다");
				}			
			},
			error:function(){
				alert('error');
			}
		});
	});
	
	$("#account").click(function () {
		
		let params = $("#frm").serialize();	// 데이터를 가져옴
		
		$.ajax({
			url:"http://localhost:3000/addMember",
			type:"post",
			data:params,
			success:function(resp){
			//	alert("success");
				if(resp == "OK"){
					alert("가입성공했습니다")
					location.href = "login.html";
				}else{
					alert("가입이 되지 않았습니다")
				}
			},
			error:function(){
				alert("error");
			}
		});
	});
});
</script>
</body>
</html>
```





pagination

https://github.com/josecebe/twbs-pagination