# JSP_dao

### dao.java

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

   private static MemberDao dao = null;		// 메모리 공유
   
   private MemberDao() {
      DBConnection.initConnection();
   }
   
   public static MemberDao getInstance() {
      if(dao == null) {
         dao = new MemberDao();
      }
      return dao;
   }
   //regiAf.jsp -> 회원가입
   public boolean addMember(MemberDto dto) {
      // 사용자 3
      String sql = " INSERT INTO MEMBER(ID, PWD, NAME, EMAIL, AUTH) "
            + "    VALUES(?, ?, ?, ?, 3) ";
      
      Connection conn = null;
      PreparedStatement psmt = null;
      
      int count = 0;
      
      try {
         conn = DBConnection.getConnection();
         System.out.println("1/3 addMember success");
         // 값을 가져온다.
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
      // Id를 검색해서 결과가 나오는지 확인
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
         
         if(rs.next()) {
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
   
  // 값을 저장해둬야됌 -> MemberDto
   public MemberDto login(String id, String pwd)  { 
     // id와 pwd가 일치하면 조회
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
         
         rs = psmt.executeQuery();
         System.out.println("3/3 getId success");
         
         if(rs.next()) {
            String _id = rs.getString(1);
            String name = rs.getString(2);
            String email = rs.getString(3);
            int auth = rs.getInt(4);
            // pwd값은 받지 않으므로 null
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



# JSP_getId

### getId.jsp

- 아이디 중복체크

```jsp
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = request.getParameter("id");
System.out.println("id:" + id);

MemberDao dao = MemberDao.getInstance();
boolean b = dao.getId(id);

if(b == true){	// 아이디가 이미 있으면,
	out.println("NO");	
}else{					// 사용하는 아이디가 없으면,
	out.println("YES");
}    
%>
```





# JSP_loginAf

### loginAf.jsp

- session에 로그인 정보를 저장한다.
- 한글깨짐 -> request.setCharacterEncoding("utf-8");



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

if(mem != null){	// 로그인 확인(id, pwd)
   
   // session에 로그인 정보를 저장
   session.setAttribute("login", mem);
   session.setMaxInactiveInterval(60 * 60 * 2); // 2시간 저장
%>
   <script type="text/javascript">
   alert("안녕하세요 <%=mem.getName() %>님");
   location.href = "bbslist.jsp";
   </script>
<% 
}else{	// 로그인 실패, login 페이지 유지
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



# JSP_regi

### regi.jsp

- 회원가입

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
	// Id 확인버튼 클릭 시
	$("#btn").click(function () {
		
		$.ajax({	// getId.jsp로 부터 
			url:"getId.jsp",
			type:"post",
			data:{ id:$("#id").val() }, // Id의 값
			success:function(resp){	// ()는 상관없다.
			//	alert('success');
			//	alert(resp.trim());
				
				if(resp.trim() == "YES"){		// 공백제거, 
					$("#idcheck").css("color", "#0000ff");
					$("#idcheck").html("이 ID는 사용할 수 있습니다");
				}
				else{
					$("#idcheck").css("color", "#ff0000");
					$("#idcheck").html("사용 중인 ID입니다");
					$("#id").val("");	// 공백으로 만들어줌.
					$("#id").focus();
				}
			},
			error:function(){
				alert('error');
			}
		})
	});
});
</script>
</body>
</html>
```



# regiAf





### regiAf.jsp

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
boolean isS = dao.addMember(dto);
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

