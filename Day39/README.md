# sampleSpr

### 로그인 ~ 글쓰기

#### views/member

- login.jsp

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>

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

<h2>login page</h2>

<div class="center">

<form action="loginAf.do" method="post">

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
	location.href = "regi.do";
}
/*
	session : java -> server 회원정보, 방문회수 = Object
	cookie : javascript -> client id저장 = String
*/

let user_id = $.cookie("userId");
if(user_id != null){
	$("#id").val( user_id );
//	$("#chk_save_id").attr("checked", "checked");
	$("#chk_save_id").prop("checked", true);
}

$("#chk_save_id").click(function() {
//	alert('check click');	
	if( $("#chk_save_id").is(":checked") ){
		
		if( $("#id").val().trim() == "" ){
			alert('id를 입력해 주십시오');
			$("#chk_save_id").prop("checked", false);
		}
		else{
			$.cookie("userId", $("#id").val().trim(), { expires:7, path:'./' });	
		}		
	}
	else{
		$.removeCookie("userId", { path:'./' });
	}
});

</script>
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

<form action="regiAf.do" method="post">

<table border="1">
<tr>
	<th>아이디</th>
	<td>
		<input type="text" name="id" id="id" size="20"><br>
		<p id="idcheck" style="font-size: 8px"></p>
		<input type="button" id="btn" value="id확인">
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
			url:"idcheck.do",
			type:"post",
			data:{ id:$("#id").val() },
			success:function(resp){
			//	alert('success');
			//	alert(resp);
				
				if(resp == "YES"){
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



#### views/bbs

- bbslist.jsp

```jsp
<%@page import="mul.com.a.util.BbsUtil"%>
<%@page import="mul.com.a.dto.BbsDto"%>
<%@page import="java.util.List"%>
<%@page import="mul.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

String search = (String)request.getAttribute("search");
if(search == null) search = "";
String choice = (String)request.getAttribute("choice");

int bbsPage = (Integer)request.getAttribute("bbsPage");
int pageNumber = (Integer)request.getAttribute("pageNumber"); // 현재 페이지

List<BbsDto> list = (List<BbsDto>)request.getAttribute("bbslist");	
%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link type="text/css" rel="stylesheet" href="./css/table.css">

<script type="text/javascript">
$(document).ready(function() {
	// 검색어가 있는 경우
	let search = "<%=search %>";
	if(search == "") return;
	
	// select 처리
	let obj = document.getElementById("choice");
	obj.value = "<%=choice %>";
	obj.setAttribute("selected", "selected");	
});
</script>

</head>
<body>

<div align="center">

<table class="type02">
<col width="70px"><col width="550px"><col width="100px"><col width="100px">
<tr>
	<th>번호</th><th>제목</th><th>조회수</th><th>작성자</th>
</tr>

<%
if(list == null || list.size() == 0){
%>
	<tr>
		<td colspan="3">작성된 글이 없습니다</td>
	</tr>
<%
}else{
	
	for(int i = 0;i < list.size(); i++){
		BbsDto bbs = list.get(i);
%>
		<tr>
			<th><%=(i + 1) %></th>
			
				<%
				if(bbs.getDel() == 0){
					%>
					<td class="titleTd">						
					<%=BbsUtil.arrow( bbs.getDepth() ) %>				
					<a href="bbsdetail.jsp?seq=<%=bbs.getSeq() %>"><%=BbsUtil.dot3(bbs.getTitle()) %></a>
					</td>
					<%
				}else{
					%>
					<td align="center">
					<font color="#c0c0c0">*** 이 글은 작성자에 위해서 삭제되었습니다 ***</font>
					</td>
					<%
				}
				%>
				
			
			<td align="center"><%=bbs.getReadcount() %></td>
			<td align="center">
				<%=bbs.getId() %>
			</td>
		</tr>
<%
	}
}
%>
</table>

<% 
for(int i = 0;i < bbsPage; i++){
	if(pageNumber == i){	// 현재 페이지		1 [2] [3]
		%>
		<span style="font-size: 15pt; color: #0000ff; font-weight: bold;">
			<%=i + 1 %>
		</span>&nbsp;
		<%
	}
	else{					// 그 외의 페이지
		%>
		<a href="#none" title="<%=i + 1 %>페이지" onclick="goPage(<%=i %>)"
			style="font-size: 15pt;color: #000; font-weight: bold; text-decoration: none;">
			[<%=i + 1 %>]
		</a>&nbsp;
		<%
	}
}
%>
<br><br>


<div align="center">

<select id="choice" style="height:25px; vertical-align: middle">
	<option value="title">제목</option>
	<option value="content">내용</option>
	<option value="id">작성자</option>
</select>

<input type="text" id="search" value="<%=search %>" style="height:20px">

<button type="button" onclick="searchBbs()" style="height:25px; vertical-align: middle">검색</button>

</div>

<br>	
	<a href="bbswrite.do">글쓰기</a>

</div>

<script type="text/javascript">
$(function () {
	$(".titleTd").mouseover(function() {		
		$(this).css("background", "#e0e0e0");
	});
	$(".titleTd").mouseout(function() {
		$(this).css("background", "#ffffff");
	});	
});

function searchBbs() {
	let choice = document.getElementById("choice").value;
	let search = document.getElementById("search").value;

	location.href = "bbslist.do?choice=" + choice + "&search=" + search;
}

function goPage( pageNum ) {
	let choice = document.getElementById("choice").value;
	let search = document.getElementById("search").value;
	
	location.href = "bbslist.do?choice=" + choice + "&search=" + search + "&pageNumber=" + pageNum;
}

</script>
</body>
</html>
```



- bbswrite.jsp

```jsp
<%@page import="mul.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/table.css">
</head>
<body>

<%
MemberDto mem = (MemberDto)session.getAttribute("login");
if(mem == null){
%>
	<script type="text/javascript">
	alert("로그인 해 주십시오");
	location.href = "login.jsp";
	</script>
<%
}
%>

<h1>글추가</h1>

<div align="center">

<form action="bbswriteAf.do" method="post">

<table class="type02">
<col width="200"><col width="400">

<tr>
	<th>아이디</th>
	<td>
		<input type="text" name="id" size="50px" value="<%=mem.getId() %>" readonly="readonly">
	</td>
</tr>

<tr>
	<th>제목</th>
	<td>
		<input type="text" name="title" size="50px">
	</td>
</tr>

<tr>
	<th>내용</th>
	<td>
		<textarea rows="20" cols="50px" name="content"></textarea>
	</td>
</tr>

<tr>
	<td colspan="2" align="center">
		<input type="submit" value="글쓰기">
	</td>	
</tr>
</table>
</form>
</div>
</body>
</html>
```



#### spring 

- applicationcontext.xml
- servlet-context.xml 



#### webapp/image

- arrow.png : 댓글 이미지 추가



#### src/main/java/sqls

- sql 문 추가
- Member.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  
<mapper namespace="Member">

<select id="allMember" resultType="mul.com.a.dto.MemberDto">
	SELECT * FROM MEMBER
</select>

<select id="idcheck" parameterType="java.lang.String" 
						resultType="java.lang.Integer">
	SELECT NVL(COUNT(*), 0)
	FROM MEMBER
	WHERE ID=#{ id }
</select>

<insert id="addmember" parameterType="mul.com.a.dto.MemberDto">
	INSERT INTO MEMBER(ID, PWD, NAME, EMAIL, AUTH)
	VALUES(#{id}, #{pwd}, #{name}, #{email}, 3)
</insert>

<!-- PWD는 조회 X , 해킹 우려 -->
<select id="login" parameterType="mul.com.a.dto.MemberDto" resultType="mul.com.a.dto.MemberDto">
		SELECT ID, NAME, EMAIL, AUTH
		FROM MEMBER
		WHERE ID=#{id} AND PWD=#{pwd}
</select>
</mapper>
```



- Bbs.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
  PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
  "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
  
<mapper namespace="Bbs">

<select id="bbslist" parameterType="mul.com.a.dto.BbsParam" resultType="mul.com.a.dto.BbsDto">
	SELECT SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT
	FROM (SELECT 	ROW_NUMBER()OVER(ORDER BY REF DESC, STEP ASC) AS RNUM,
				SEQ, ID, REF, STEP, DEPTH, 
				TITLE, CONTENT, WDATE, 
				DEL, READCOUNT
		FROM BBS
		<if test="choice == 'title'">
			WHERE TITLE LIKE '%'||#{ search }||'%'
		</if>
		<if test="choice == 'content'">
			WHERE CONTENT LIKE '%'||#{ search }||'%'
		</if>
		<if test="choice == 'id'">
			WHERE ID=#{ search }
		</if>	
		ORDER BY REF DESC, STEP ASC)
	WHERE RNUM BETWEEN #{start} AND #{end}
</select>

<select id="allbbs" parameterType="mul.com.a.dto.BbsParam" resultType="Integer">
	SELECT COUNT(*) 
	FROM BBS
	<if test="choice == 'title'">
		WHERE TITLE LIKE '%'||#{ search }||'%'
	</if>
	<if test="choice == 'content'">
		WHERE CONTENT LIKE '%'||#{ search }||'%'
	</if>
	<if test="choice == 'id'">
		WHERE ID=#{ search }
	</if>
</select>

<insert id="writeBbs" parameterType="mul.com.a.dto.BbsDto">
	INSERT INTO BBS(SEQ, ID, REF, STEP, DEPTH, 
			TITLE, CONTENT, WDATE, DEL, READCOUNT)
	VALUES(SEQ_BBS.NEXTVAL, #{id}, (SELECT NVL(MAX(REF), 0)+1 FROM BBS), 0, 0, 
			#{title}, #{content}, SYSDATE, 0, 0)
</insert>
</select>
</mapper>
```



#### sql과 대화하는 Dao 작성

#### mul.com.a.dao

- Interface 추가, DB로부터 data, Dao - 세션

- MemberDao.java

```java
package mul.com.a.dao;

import java.util.List;

import mul.com.a.dto.MemberDto;

public interface MemberDao {

	List<MemberDto> allMember();
	
	boolean idcheck(String id);
	boolean addMember(MemberDto mem);
	MemberDto login(MemberDto mem);	// 매개변수 mem
}
```



- BbsDao.java

```java
package mul.com.a.dao;

import java.util.List;

import mul.com.a.dto.BbsDto;
import mul.com.a.dto.BbsParam;

public interface BbsDao {

	List<BbsDto> getBbsList(BbsParam param);
	int getAllBbs(BbsParam param);
	
	boolean writeBbs(BbsDto bbs);
}
```



#### mul.com.a.dao.impl

- Override, namespace, return

- MemberDaoImpl.java

```java
package mul.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.com.a.dao.MemberDao;
import mul.com.a.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	SqlSession sqlSession; // IOC, DI
	
	String namespace = "Member.";

	@Override
	public List<MemberDto> allMember() {
		List<MemberDto> list = sqlSession.selectList(namespace + "allMember");
		return list;
	}

	@Override
	public boolean idcheck(String id) {	
		int count = sqlSession.selectOne(namespace + "idcheck", id);
		return count>0?true:false;
	}
	
	@Override
	public boolean addMember(MemberDto mem) {
		int n = sqlSession.insert(namespace + "addmember", mem);
		return n>0?true:false;
	}

	@Override
	public MemberDto login(MemberDto mem) {
		
		return sqlSession.selectOne(namespace + "login", mem); 
	}	
}
```



- BbsDaoImpl.java

```java
package mul.com.a.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mul.com.a.dao.BbsDao;
import mul.com.a.dto.BbsDto;
import mul.com.a.dto.BbsParam;

@Repository
public class BbsDaoImpl implements BbsDao {
	
	// session : DB 소속
	@Autowired	// session 접근
	SqlSession session;
	
	String ns = "Bbs."; // namespase

	@Override
	public List<BbsDto> getBbsList(BbsParam param) {		
		return session.selectList(ns + "bbslist", param);
	}
	@Override
	public int getAllBbs(BbsParam param) {		
		return session.selectOne(ns + "allbbs", param);
	}
	
	@Override
	public boolean writeBbs(BbsDto bbs) {
		int n = session.insert(ns + "writeBbs", bbs);
		return n>0?true:false;
	}
}
```



#### Data 편집하는 service 접근

#### mul.com.a.service

- dao 접근
- MemberService.java

```java
package mul.com.a.service;

import java.util.List;

import mul.com.a.dto.MemberDto;

public interface MemberService {

	List<MemberDto> allMember();
	
	boolean idcheck(String id);
	boolean addMember(MemberDto mem);
	MemberDto login(MemberDto mem);	// 매개변수 mem
}
```



- BbsService.java

```java
package mul.com.a.service;

import java.util.List;

import mul.com.a.dto.BbsDto;
import mul.com.a.dto.BbsParam;

public interface BbsService {

	List<BbsDto> getBbsList(BbsParam param);
	int getAllBbs(BbsParam param);
	
	boolean writeBbs(BbsDto bbs);
}
```



#### mul.com.a.service.impl

- Override

- MemberServiceimpl.java

```java
package mul.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.com.a.dao.MemberDao;
import mul.com.a.dto.MemberDto;
import mul.com.a.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired	// Interface
	MemberDao dao;

	@Override
	public List<MemberDto> allMember() {		
		return dao.allMember();
	}

	@Override
	public boolean idcheck(String id) {		
		return dao.idcheck(id);
	}
	
	@Override
	public boolean addMember(MemberDto mem) {		
		return dao.addMember(mem);
	}

	@Override
	public MemberDto login(MemberDto mem) {
		return dao.login(mem);
	}
}
```



- BbsService.java

```java
package mul.com.a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mul.com.a.dao.BbsDao;
import mul.com.a.dto.BbsDto;
import mul.com.a.dto.BbsParam;
import mul.com.a.service.BbsService;

@Service
public class BbsServiceImpl implements BbsService {
	
	@Autowired
	BbsDao dao ; 	// new BbsDaoImpl(); 자동완성

	@Override
	public List<BbsDto> getBbsList(BbsParam param) {		
		return dao.getBbsList(param);
	}

	@Override
	public int getAllBbs(BbsParam param) {		
		return dao.getAllBbs(param);
	}

	@Override
	public boolean writeBbs(BbsDto bbs) {		
		return dao.writeBbs(bbs);
	}
}
```

