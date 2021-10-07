

# JSP_Model 1_member

-  index.jsp로 기본페이지 설정
- 실행을 하면 login.jsp(로그인페이지)로 이동

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
response.sendRedirect("login.jsp"); // login.jsp으로 이동
%>

</body>
</html>
```



- login.jsp
- Jquery, cookie 사용하기 위해 script로 url 설정
- 회원가입 버튼 클릭 시 regi.jsp(회원가입 페이지)로 이동
- save id 클릭 시 chk_save_id()

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

<style type="text/css">
.center{
    margin: auto;
    width: 60%;
    border: 3px solid;
    padding: 10px;
}

</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>

</head>
<body>

<h2>Login Page</h2>

<div class="center">

<form action="loginAf.jsp" method="post">

<table border="1">

<tr>
    <th>아이디</th>
    <td>
        <input type="text" id="id" name="id" size="20"><br>
        <input type="checkbox" id="chk_save_id">save id
    </td>
</tr>
<tr>
    <th>패스워드</th>
    <td>
        <input type="password" name="pwd" size="20">
    </td>
</tr>
<tr>
    <td colspan="2">
        <input type="submit" value="login">
        <button type="button" onclick="account()">회원가입</button>
    </td>
</tr>

</table>
</form>
</div>

<script type="text/javascript">
function account() {
   location.href = "regi.jsp";
}
/*
    session : Java -> 서버에서 사용, 회원정보를 기억할 때, 방문횟수 = object가 저장
    cookie   : JavaScript -> client id저장할 때 많이 사용 = String
*/

let user_id = $.cookie("userId");
if(user_id != null){ // 저장된 쿠키가 있을 때, 유저가 아이디를 적었을 때
   $("#id").val( user_id );		// id값( user_id )
//   $("#chk_save_id").attr( "checked", "checked" ) // attr(attribute명, attribute값)
    $("#chk_save_id").prop("checked", true);
}    

$("#chk_save_id").click(function () {	// 아이디 저장 클릭 시 
//   alert("check click");

    if($("#chk_save_id").is(":checked") == true){	
       if($("#id").val().trim() == ""){
          alert("id를 입력해 주십시오");
          $("#chk_save_id").prop("checked", false);
       }
       else{
           $.cookie("userId", $("#id").val().trim(), {expires:7, path:'./'}); // {expires:7}
        }
    }   
    else{
       $.removeCookie("userId", {path:'./'}); 
    }
});
</script>
</body>
</html>
```



- loginAf.jsp
- parameter 가져온다.
- dto에 데이터를 담는다.
- session에 로그인 정보를 저장

```jsp
<%@page import="dao.MemberDao"%>
<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("utf-8"); %>    
    
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
MemberDao dao = MemberDao.getInstance();

MemberDto mem = dao.login(id, pwd);

if(mem != null){	// 로그인 성공
   
   // session에 로그인 정보를 저장
   session.setAttribute("login", mem);		// mem을 로그인에 담아라
   session.setMaxInactiveInterval(60 * 60 * 2); // 2시간 저장
%>
   <script type="text/javascript">
   alert("안녕하세요 <%=mem.getName() %>님");
   location.href = "bbslist.jsp";
   </script>
<% 
}else{		// 로그인 실패
%>   
   <script type="text/javascript">
   alert("id나 password를 확인하세요.");
   location.href = "login.jsp";
   </script>
<% 
}
%>
</body>
</html>
```



- regi.jsp

```jsp
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

<!-- <form action="member?param=regiAf" method="post"> -->
<form action="regiAf.jsp" method="post">

<table border="1">
<tr>
	<th>아이디</th>
	<td>
		<input type="text" name="id" id="id" size="20"><br>
		<p id="idcheck" style="font-size: 8px"></p>
		<input type="button" id="btn" onclick="id()" value="id확인">
	</td>
</tr>
<tr>
	<th>패스워드</th>
	<td>
		<input type="text" name="pwd" size="20">
	</td>
</tr>
<tr>
	<th>이름</th>
	<td>
		<input type="text" name="name" size="20">
	</td>
</tr>
<tr>
	<th>이메일</th>
	<td>
		<input type="text" name="email" size="20">
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
			url:"getId.jsp",
			type:"post",
			data:{ id:$("#id").val() },
			success:function(resp){
			//	alert('success');
			//	alert(resp.msg.trim());
				
				// msg 추가
				if(resp.msg.trim() == "YES"){
					$("#idcheck").css("color", "#0000ff");
					$("#idcheck").html("이 ID는 사용할 수 있습니다");
				}
				else{
					$("#idcheck").css("color", "#ff0000");
					$("#idcheck").html("사용 중인 ID입니다");
					$("#id").val("");
					$("#id").focus();
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
```



- regiAf.jsp

```jsp
<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>

<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
String name = request.getParameter("name");	// 한글깨짐
String email = request.getParameter("email");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
MemberDao dao = MemberDao.getInstance();
MemberDto dto = new MemberDto(id, pwd, name, email, 0);
boolean isS = dao.addMember(dto);;


if(isS == true){
%>
	<script type="text/javascript">
	alert("성공적으로 가입되었습니다");
	location.href = "login.jsp";
	</script>
<%
}else{
%>
	<script type="text/javascript">
	alert("다시 기입해 주십시오");
	location.href = "regi.jsp";
	</script>
<%
}
%>
</body>
</html>
```





- getId.jsp

```jsp
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");
System.out.println("id:" + id);

MemberDao dao = MemberDao.getInstance();
boolean b = dao.getId(id);

if(b == true){
	out.println("NO");	
}else{
	out.println("YES");
}    
%>
```





- MemberDao.java

```java
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBClose;
import db.DBConnection;
import dto.MemberDto;

public class MemberDao {

   private static MemberDao dao = null;
   
   private MemberDao() {
      DBConnection.initConnection();
   }
   
   public static MemberDao getInstance() {
      if(dao == null) {
         dao = new MemberDao();
      }
      return dao;
   }
   
   public boolean addMember(MemberDto dto) {
      
      String sql = " INSERT INTO MEMBER(ID, PWD, NAME, EMAIL, AUTH) "
            + "    VALUES(?, ?, ?, ?, 3) ";
      
      Connection conn = null;
      PreparedStatement psmt = null;
      
      int count = 0;
      
      try {
         conn = DBConnection.getConnection();
         System.out.println("1/3 addMember success");
         
         psmt = conn.prepareStatement(sql);
         psmt.setString(1, dto.getId());
         psmt.setString(2, dto.getPwd());
         psmt.setString(3, dto.getName());
         psmt.setString(4, dto.getEmail());         
         System.out.println("2/3 addMember success");
         
         count = psmt.executeUpdate();
         System.out.println("3/3 addMember success");
         
      } catch (SQLException e) {         
         e.printStackTrace();
         System.out.println("addMember fail");
      } finally {
         DBClose.close(conn, psmt, null);
      }
      
      return count>0?true:false;
   }
   
   public boolean getId(String id) {
      // 회원가입의 데이터 -> DB
      String sql = " SELECT COUNT(*) "
            + "      FROM MEMBER "
            + "    WHERE ID=? ";
      
      Connection conn = null;
      PreparedStatement psmt = null;
      ResultSet rs = null;
      
      int findId = 0;
      
      try {
         conn = DBConnection.getConnection();
         System.out.println("1/3 getId success");
         
         psmt = conn.prepareStatement(sql);
         psmt.setString(1, id.trim());
         System.out.println("2/3 getId success");
         
         rs = psmt.executeQuery();
         System.out.println("3/3 getId success");
         
         if(rs.next()) {	// 찾았을때
            findId = rs.getInt(1);
         }
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         System.out.println("getId fail");
      } finally {
         DBClose.close(conn, psmt, rs);
      }
      
      return findId>0?true:false;
   }
   
   public MemberDto login(String id, String pwd) {
      String sql = " SELECT ID, NAME, EMAIL, AUTH "
            + "      FROM MEMBER "
            + "    WHERE ID=? AND PWD=? ";
      
      Connection conn = null;
      PreparedStatement psmt = null;
      ResultSet rs = null;
      
      MemberDto mem = null;
      try {
         conn = DBConnection.getConnection();
         System.out.println("1/3 getId success");
         
         psmt = conn.prepareStatement(sql);
         psmt.setString(1, id);
         psmt.setString(2, pwd);
         System.out.println("2/3 getId success");
         // select 이므로
         rs = psmt.executeQuery();
         System.out.println("3/3 getId success");
         
         if(rs.next()) {	// auth는 관리자페이지 / 유저페이지 구분
            String _id = rs.getString(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            int auth = rs.getInt(4);
            
            // 생성, 안전성을 위해서 패스워드는 뺀다.
            mem = new MemberDto(_id, null, name, email, auth);
         }
         
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
         System.out.println("login fail");
      }finally {
         DBClose.close(conn, psmt, rs);
      }
      return mem;
   }
}
```

