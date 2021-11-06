# Spring_Boot BBS

### sprBootBack



#### mul.com.a.dto

- BbsDto.java

```java
package mul.com.a.dto;

import java.io.Serializable;

public class BbsDto implements Serializable {

	private int seq;
	private String id;		// 작성자
	
	private int ref;		// 그룹번호		답글용
	private int step;		// 행번호
	private int depth;		// 깊이
	
	private String title;	// 제목
	private String content;	// 내용
	private String wdate;	// 작성일	
	
	private int del;		// 삭제여부
	private int readcount;	// 조회수
	
	public BbsDto() {
	}

	public BbsDto(int seq, String id, int ref, int step, int depth, String title, String content, String wdate, int del,
			int readcount) {
		super();
		this.seq = seq;
		this.id = id;
		this.ref = ref;
		this.step = step;
		this.depth = depth;
		this.title = title;
		this.content = content;
		this.wdate = wdate;
		this.del = del;
		this.readcount = readcount;
	}

	public BbsDto(String id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}

	public int getDel() {
		return del;
	}

	public void setDel(int del) {
		this.del = del;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	@Override
	public String toString() {
		return "BbsDto [seq=" + seq + ", id=" + id + ", ref=" + ref + ", step=" + step + ", depth=" + depth + ", title="
				+ title + ", content=" + content + ", wdate=" + wdate + ", del=" + del + ", readcount=" + readcount
				+ "]";
	}
	
}
```



- BbsParam.java

```java
package mul.com.a.dto;

import java.io.Serializable;

public class BbsParam implements Serializable{

	private String choice;
	private String search;
	
	private int page;	// 페이지
	
	private int start;
	private int end;
	
	public BbsParam() {
	}

	public BbsParam(String choice, String search, int page, int start, int end) {
		super();
		this.choice = choice;
		this.search = search;
		this.page = page;
		this.start = start;
		this.end = end;
	}

	public String getChoice() {
		return choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int getpage() {
		return page;
	}

	public void setpage(int page) {
		this.page = page;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "BbsParam [choice=" + choice + ", search=" + search + ", page=" + page + ", start=" + start
				+ ", end=" + end + "]";
	}
	
}
```



#### sqls

- Bbs.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="mul.com.a.dao.BbsDao">
<!-- BbsParam를 만들어준다. -->
<select id="getbbslist" parameterType="mul.com.a.dto.BbsParam" resultType="mul.com.a.dto.BbsDto">
    SELECT SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT 
	FROM ( SELECT ROW_NUMBER()OVER(ORDER BY REF DESC, STEP ASC) AS RNUM,
	           SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT
	       FROM BBS    
	       WHERE 1=1
	     <if test="choice != null and choice != ''
		  		and search != null and search != ''">		  	  
			  <if test="choice == 'title'">
			  		AND TITLE LIKE '%'||#{search}||'%'		  
			  </if>
			  <if test="choice == 'content'">
			  		AND CONTENT LIKE '%'||#{search}||'%'			  
			  </if>
			  <if test="choice == 'writer'">
			  		AND ID=#{search}  
			  </if>	
		 </if>
	       ORDER BY REF DESC, STEP ASC)	 
	WHERE RNUM BETWEEN #{start} AND #{end}       
	
</select>

<!-- 글의 총수 -->
<select id="getbbscount" parameterType="mul.com.a.dto.BbsParam" resultType="java.lang.Integer">
    SELECT NVL(COUNT(*), 0) AS CNT
    FROM BBS
    WHERE 1=1
	     <if test="choice != null and choice != ''
		  		and search != null and search != ''">		  	  
			  <if test="choice == 'title'">
			  		AND TITLE LIKE '%'||#{search}||'%'		  
			  </if>
			  <if test="choice == 'content'">
			  		AND CONTENT LIKE '%'||#{search}||'%'			  
			  </if>
			  <if test="choice == 'writer'">
			  		AND ID=#{search}  
			  </if>	
		 </if>
</select>

<!-- 글 추가 -->
<insert id="writeBbs" parameterType="mul.com.a.dto.BbsDto">
	INSERT INTO BBS(SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT)
	VALUES(SEQ_BBS.NEXTVAL, #{id}, (SELECT NVL(MAX(REF), 0)+1 FROM BBS), 0, 0,#{title}, #{content}, SYSDATE, 0, 0)
</insert>

<!-- 조회수 -->
<update id="readcount" parameterType="Integer">
    UPDATE BBS 
    SET READCOUNT=READCOUNT + 1 
    WHERE SEQ=#{ seq }
</update>

<!-- 상세 글보기-->
<select id="getBbs" parameterType="Integer" resultType="mul.com.a.dto.BbsDto">
    SELECT SEQ, ID, REF, STEP, DEPTH, 
    	   TITLE, CONTENT, WDATE, DEL, READCOUNT 
	FROM BBS 
	WHERE SEQ=#{ seq }
</select>
<!-- 답글 파라미터 Integer지만 seq가 dto 소속이기때문에 둘다 가능하다. -->
<update id="answerupdate" parameterType="mul.com.a.dto.BbsDto">
    UPDATE BBS 
    SET STEP=STEP+1 
    WHERE REF = (SELECT REF FROM BBS WHERE SEQ=#{ seq } )
    AND STEP > (SELECT STEP FROM BBS WHERE SEQ=#{ seq } )
</update>

<insert id="answerinsert" parameterType="mul.com.a.dto.BbsDto">
    INSERT INTO BBS(SEQ, ID,  
                    REF, STEP, DEPTH, 
                    TITLE, CONTENT, WDATE, DEL, READCOUNT) 
    VALUES(SEQ_BBS.NEXTVAL, #{ id }, 
    (SELECT REF FROM BBS WHERE SEQ=#{ seq } ),
    (SELECT STEP FROM BBS WHERE SEQ=#{ seq } ) + 1, 
    (SELECT DEPTH FROM BBS WHERE SEQ=#{ seq } ) + 1, 
    #{ title }, #{ content }, SYSDATE, 0, 0)
</insert>

<!-- 글 수정 -->
<update id="updateBbs" parameterType="mul.com.a.dto.BbsDto">
UPDATE BBS
SET TITLE=#{title},CONTENT=#{content}
WHERE SEQ=#{seq} 
</update>

<!-- 글 삭제 -->
<update id="deleteBbs" parameterType="Integer">
    UPDATE BBS 
    SET DEL=1 
    WHERE SEQ=#{seq}
</update>

</mapper>
```



#### mul.com.a.dao

- BbsDao.java

```java
package mul.com.a.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import mul.com.a.dto.BbsDto;
import mul.com.a.dto.BbsParam;

@Mapper
@Repository
public interface BbsDao {
	
	// 로그인 후 게시판 리스트형태
	List<BbsDto> getbbslist(BbsParam param);
	// 글의 총수
	int getbbscount(BbsParam param);
	// 글쓰기
	int writeBbs(BbsDto bbs);
	// 조회수
	void readcount(int seq);
	// 상세글보기
	BbsDto getBbs(int seq);
	// 답글
	boolean answerupdate(BbsDto dto);
	
	boolean answerinsert(BbsDto dto);
	
	// 글 수정 
	boolean updateBbs(BbsDto bbs);
	
	// 글 삭제
	boolean deleteBbs(int seq);
}
```



#### mul.com.a.service

- BbsService.java

```java
package mul.com.a.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mul.com.a.dao.BbsDao;
import mul.com.a.dto.BbsDto;
import mul.com.a.dto.BbsParam;

@Service
@Transactional
public class BbsService {

	@Autowired
	BbsDao dao;
	
	public List<BbsDto> getbbslist(BbsParam param) {
		return dao.getbbslist(param);
		
	}
	
	public int getbbscount(BbsParam param) {
		return dao.getbbscount(param);
	}
	
	public boolean writeBbs(BbsDto bbs) {
		int n = dao.writeBbs(bbs);
		
		return n>0?true:false;		
	}
	
	public void readcount(int seq) {
		dao.readcount(seq);
	}
	
	public BbsDto getBbs(int seq) {
		return dao.getBbs(seq);
	}
	
	public boolean answerupdate(BbsDto bbs) {
		return dao.answerupdate(bbs);
	}
	
	public boolean answerinsert(BbsDto bbs) {
		return dao.answerinsert(bbs);
	}
	
	public boolean updateBbs(BbsDto dto) {
		return dao.updateBbs(dto);
	}
	
	public boolean deleteBbs(int seq) {
		return dao.deleteBbs(seq);
	}
}
```



#### mul.com.a.controller

- BbsController.java

```java
package mul.com.a.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mul.com.a.dto.BbsDto;
import mul.com.a.dto.BbsParam;
import mul.com.a.service.BbsService;

@RestController
public class BbsController {
	
	@Autowired
	BbsService service; 
	
	// 'http://localhost:3000/bbslist'
	@RequestMapping(value = "/bbslist", method = RequestMethod.GET)
	public List<BbsDto> bbslist(BbsParam param){ // 리턴 값 List<BbsDto>
		System.out.println("BbsController bbslist()");
		
		int sn = param.getpage();	// 0 1 2	페이지 수
		int start = sn * 10 +1;		// 1 11 21 	
		int end = (sn + 1 ) * 10;	// 10 20 30 
		
		param.setStart(start);	// param start 값 담는다
		param.setEnd(end);		// param end 값 담는다
		
		List<BbsDto> list = service.getbbslist(param);
		
		return list;
	}
	
	@RequestMapping(value = "/bbscount", method = RequestMethod.GET)
	public int bbscount(BbsParam param) {
		System.out.println("BbsController bbscount()");
		
		return service.getbbscount(param);
	}
	
	@RequestMapping(value = "/bbswrite", method = RequestMethod.GET)
	public String bbswrite(BbsDto dto) {
		System.out.println("BbsController bbswrite()");
		
		boolean b = service.writeBbs(dto);
		if(b == true) {
			return "OK";
		}else {
			return "NG";
		}	
	}
	
	@RequestMapping(value = "/bbsdetail", method = RequestMethod.GET)
	public BbsDto bbsdetail(int seq) {
		System.out.println("BbsController bbsdetail()");
		
		// 조회수
		service.readcount(seq);
		
		BbsDto data = service.getBbs(seq);
		
		return data;
	}
	
	@RequestMapping(value = "/bbsanswer", method = RequestMethod.GET)
	public String bbsanwer(BbsDto dto) {
		System.out.println("BbsController bbsanwer()");
		System.out.println(dto);
		// update, insert 둘다 서비스해준다
		
		service.answerupdate(dto);
		boolean insert = service.answerinsert(dto);
		
		if(insert == true) {
			return "OK";
		}else {
			return "NG";
		}	
	}
	
	// 글 수정
	@RequestMapping(value = "/bbsupdate", method = RequestMethod.GET)
	public String bbsupdate(BbsDto dto) {
		System.out.println("BbsController bbsupdate()");
		System.out.println(dto);
		boolean b = service.updateBbs(dto);
		if(b == true) {
			return "OK";
		}else {
			return "NG";
		}	
	}
	
	// 글 삭제
	@RequestMapping(value = "/bbsdelete", method = RequestMethod.GET)
	public String bbsupdelete(int seq) {
		System.out.println("BbsController bbsupdelete()");
		
		boolean b = service.deleteBbs(seq);
		
		if(b == true) {
			return "OK";
		}else {
			return "NG";
		}	
	}
	
}
```





### sprBootFront

- bbslist.html
  - 게시판

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bbslist.html</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script type="text/javascript" src="page/jquery.twbsPagination.min.js"></script>
</head>
<body>

<h2>게시판</h2>

<a href="STT.html">STT</a>
<a href="CFR.html">CFR</a>
<a href="TTS.html">TTS</a>
<a href="objectDetection.html">objectDetection</a>

<div id="app" class="container">

<table class="table table-striped table-hover">

<thead>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>seq</th>			
	</tr>
</thead>

<tbody id="blist">
</tbody>

</table>

<br><br>

<div class="container">
    <nav aria-label="Page navigation">
        <ul class="pagination" id="pagination" style="justify-content:center"></ul>
    </nav>
</div>

<br>
<div align="center">
	<a href="bbswrite.html">글쓰기</a>
</div>
<br>

<table style="margin-left: auto;margin-right: auto; margin-top: 3px; margin-bottom: 3px">
<tr>
	<td>검색</td>
	<td style="padding-left: 5px">
		<select id="_choice" name="choice">
			<option value="" selected="selected">선택</option>
			<option value="title">제목</option>
			<option value="content">내용</option>
			<option value="writer">작성자</option>
		</select>	
	</td>
	<td style="padding-left: 5px">
		<input type="text" id="_search" name="search">
	</td>
	<td style="padding-left: 5px">
		<span>
			<button type="button" id="btnSearch">검색</button>
		</span>
	</td>
</tr>
</table>

</div>

<script type="text/javascript">
//let login = sessionStorage.getItem("login");
//alert(login);

getBbslist(0);
getBbsCount();

function getBbslist( page ) {
	let choice = $("#_choice").val();
	let search = $("#_search").val();
		
	$.ajax({
		url:'http://localhost:3000/bbslist',
		type:"get",
		data:{ 'choice':choice, 'search':search, 'page':page },
		success:function(list){
		//	alert('success');
			// session
		//	let login = JSON.parse(sessionStorage.getItem("login"));
		//	alert(login.id);
			
		//	alert(JSON.stringify(list));
		//	alert(list.length);
		
		/*
			for(i = 0;i < list.length; i++){
				let str = "<tr>";
					str += "<td>" + (i + 1) + "</td>";
					str += "<td>" + list[i].title + "</td>";
					str += "<td>" + list[i].id + "</td>";
					str += "</tr>";
					
				$("#blist").append(str);
			}
		*/
			$("#blist").html("");
			$.each(list, function (i, item) {
				let str = "<tr>";
				str += "<td>" + (i + 1) + "</td>";
				
				if(item.del == 0){
					str += "<td>" + getArrow(item.depth) + "<a href='bbsdetail.html?seq=" + item.seq + "'>" + item.title + "</a>" + "</td>";
				}else{
					str += "<td><font color='red'>***이 글은 작성자의 의해서 삭제되었습니다***</font></td>";
				}
				
				str += "<td>" + item.id + "</td>";
				str += "<td>" + item.seq + "</td>";
				str += "</tr>";
				
				$("#blist").append(str);
			})		
		},
		error:function(){
			alert('error');
		}
	});	
}

// 글의 총수를 취득
function getBbsCount() {
	
	$.ajax({
		url:"http://localhost:3000/bbscount",
		type:"get",
		data:{ 'choice':$("#_choice").val(), 'search':$("#_search").val(), 'page':0 },
		success:function(count){
		//	alert(count);
			loadPage(count);
		}
	});
}

// 검색
$("#btnSearch").click(function () {
	getBbslist(0);
	getBbsCount();
});

function loadPage( totalCount ) {
	
	let pageSize = 10;		// 페이지의 크기
	
	let _totalPages = totalCount / 10
	if(totalCount % 10 > 0){
		_totalPages++; 
	}
	
	// 페이지 갱신
	$("#pagination").twbsPagination('destroy');

	$("#pagination").twbsPagination({
		startPage: 1,
		totalPages: _totalPages,
		visiblePages: 10,
		first:'<span sris-hidden="true">«</span>',
		prev:"이전",
		next:"다음",
		last:'<span sris-hidden="true">»</span>',
		initiateStartPageClick:false,		// onPageClick 자동호출이 되도록 하지 않는다
		onPageClick:function(event, page){ // 페이지 번호를 클릭
		//	alert(page);			1 2 3 4
			getBbslist(page - 1);	// 0 1 2 3
		} 
	});	
}

// 답글의 이미지
function getArrow( depth ) {
	let rs = "<img src='./image/arrow.png' width='20px' height='20px'/>";
	let nbsp = "&nbsp;&nbsp;&nbsp;&nbsp;";
	
	let ts = "";
	for(i = 0;i < depth; i++){
		ts += nbsp;
	}
	return depth==0?"":ts + rs;
}
</script>
</body>
</html>
```



- bbswrite.html
  - 글쓰기

```html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<h1>글추가</h1>

<div align="center">

<form id="frm">

<div align="center">
	<div style="width: 1000px">

		<table class="table table-bordered">
		<col width="200"><col width="400">
		
		<tr>
			<th class="table-primary">아이디</th>
			<td>
				<input type="text" id="id" name="id" size="50px" readonly="readonly">
			</td>
		</tr>
		
		<tr>
			<th class="table-primary">제목</th>
			<td>
				<input type="text" class="form-control" name="title" size="50px">
			</td>
		</tr>
		
		<tr>
			<th class="table-primary">내용</th>
			<td>
				<textarea class="form-control" rows="10" name="content"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button type="button" id="btn" class="btn btn-secondary">작성완료</button>
			</td>	
		</tr>
		</table>
		
	</div>
</div>

</form>
</div>

<script type="text/javascript">

let login = sessionStorage.getItem("login");
let id = JSON.parse(login).id;
// alert(id);
$("#id").val(id);

$("#btn").click(function() {
	
	$.ajax({
		url:"http://localhost:3000/bbswrite",
		type:"get",
		data:$("#frm").serialize(),
		success:function(resp){
		//	alert('success');
		
			if(resp == "OK"){
				alert('추가되었습니다');
			}else{
				alert('추가되지 않았습니다');
			}			
			location.href = "bbslist.html";
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



- bbsdetail.html
  - 상세 글 보기

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
//html에서 추가하면, parameter를 받을 수 있는 소스 : 추가만 해주면 된다.
let urlParams = location.search.split(/[?&]/).slice(1).map(function(paramPair) {
    return paramPair.split(/=(.+)?/).slice(0, 2);
}).reduce(function(obj, pairArray) {
    obj[pairArray[0]] = pairArray[1];
    return obj;
}, {});
</script>

</head>
<body>

<h2>내용보기</h2>

<div id="app" class="container">
	<table class="table table-striped">
		<col width="200"><col width="500">		
		<tr>
			<td>작성자</td>
			<td id="id"></td>
		</tr>
		<tr>
			<td>제목</td>
			<td id="title"></td>
		</tr>
		<tr>
			<td>작성일</td>
			<td id="wdate"></td>
		</tr>
		<tr>
			<td>조회수</td>
			<td id="readcount"></td>
		</tr>		
		
		<tr>
			<td>내용</td>
			<td>
				<textarea class="form-control" rows="20" id="content" readonly="readonly"></textarea>
			</td>
		</tr>
	</table>
	
	<button type="button" id="bbslist" onclick="location.href = 'bbslist.html'">글목록</button>
	<button type="button" id="bbsanswer">답글</button>
	<button type="button" id="bbsupdate">글수정</button>	
	<button type="button" id="bbsdelete">글삭제</button>
</div>

<script type="text/javascript">

let seq = urlParams.seq;
//alert(seq);

getBbs();

function getBbs() {
	$.ajax({
		url:'http://localhost:3000/bbsdetail',
		type:'get',
		data:{ 'seq':seq },
		success:function(data){
		//	alert('success');
		//	alert( JSON.stringify(data));
			$("#id").text( data.id );
			$("#title").text( data.title );
			$("#wdate").text( data.wdate );
			$("#readcount").text( data.readcount );
			$("#content").val( data.content );	// textarea
			
			// login한 id와 다를 때는 수정과 삭제를 할 수 없도록 처리  
			let login = JSON.parse(sessionStorage.getItem("login"));
			if(data.id != login.id){
				$("#updatebbs").hide(); // 나타내지 말아라
				$("#deletebbs").hide();
			}
		},
		error:function(){
			alert('error');
		}		
	});
}

$("#bbsanswer").click(function () {	
	location.href = "bbsanswer.html?seq=" + seq;
});
 
$("#bbsupdate").click(function () {	
	location.href = "bbsupdate.html?seq=" + seq;
});
 
$("#bbsdelete").click(function () {	
	location.href = "bbsdelete.html?seq=" + seq;
});
</script>
</body>
</html>
```



- bbsanswer.html
  - 답글

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<script type="text/javascript">
//html에서 추가하면, parameter를 받을 수 있는 소스 : 추가만 해주면 된다.
let urlParams = location.search.split(/[?&]/).slice(1).map(function(paramPair) {
    return paramPair.split(/=(.+)?/).slice(0, 2);
}).reduce(function(obj, pairArray) {
    obj[pairArray[0]] = pairArray[1];
    return obj;
}, {});

</script>

</head>
<body>
<div align="center">

<h2>부모글</h2>

<table border="1">
<col width="200"><col width="500">
<tr>
	<td>작성자</td>
	<td id="userId"></td>
</tr>
<tr>
	<td>제목</td>
	<td id="title"></td>
</tr>
<tr>
	<td>작성일</td>
	<td id="wdate"></td>
</tr>
<tr>
	<td>조회수</td>
	<td id="readcount"></td>
</tr>
<tr>
<tr>
	<td>내용</td>
	<td>
		<textarea rows="10" cols="50" id="content" readonly="readonly"></textarea>
	</td>
</tr>
</table>

<h2>답글</h2>

<form id="frm">
<input type="hidden" id="seq" name="seq">
<table border="1">
<col width="200"><col width="500">

<tr>
	<td>아이디</td>
	<td>
		<input type="text" id="id" name="id" size="50" readonly="readonly">
	</td>
</tr>
<tr>
	<td>제목</td>
	<td>
		<input type="text" name="title" size="50">
	</td>
</tr>
<tr>
	<td>내용</td>
	<td>
		<textarea rows="10" cols="50" name="content"></textarea>
	</td>
</tr>
<tr>
	<td colspan="2">
		<div align="center">
			<button id="answerBtn">답글작성완료</button>
		</div>
	</td>
</tr>
</table>
</form>
</div>


<script type="text/javascript">
// 로그인한 회원 id
let login = sessionStorage.getItem("login");
let id = JSON.parse(login).id;
// alert(id);
$("#id").val(id);

let seq = urlParams.seq;
// alert(seq);
$("#seq").val(seq);

getBbs();

function getBbs() {
	$.ajax({
		url:"http://localhost:3000/bbsdetail",
		type:"get",
		data:{'seq':seq},
		success:function(data){
		//	alert('success');
		// 	태그안에 비어 있을때 append : 문자열 추가 , 
		//	val : 값을 넣어라 
			$("#userId").append( data.id );
			$("#wdate").append(data.wdate);
			$("#readcount").append( data.readcount);
			$("#title").append( data.title );
			$("#content").append( data.content );
			
		},
		error:function(){
			alert('error');
		}
	});
}

$("#answerBtn").click(function () {	
	
	let params = $("#frm").serialize();
	// alert(params);
	$.ajax({
		url:"http://localhost:3000/bbsanswer",
		type:"get",
		data:params,
		success:function(resp){
			// alert('success');
			if(resp == "OK"){
				alert('답글이 작성되었습니다.');
				location.href = "bbslist.html";
			}else{
				alert('답글이 작성되지 않았습니다.');
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



- bbsupdate.html
  - 글 수정

```java
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script type="text/javascript">
//html에서 추가하면, parameter를 받을 수 있는 소스 : 추가만 해주면 된다.
let urlParams = location.search.split(/[?&]/).slice(1).map(function(paramPair) {
    return paramPair.split(/=(.+)?/).slice(0, 2);
}).reduce(function(obj, pairArray) {
    obj[pairArray[0]] = pairArray[1];
    return obj;
}, {});
</script>

</head>
<body>
<h2>글 수정</h2>

<div align="center">
<form id="frm">
<input type="hidden" id="seq" name="seq">

<table border="1">
<col width="200"><col width="500"> 

<tr>
	<th>아이디</th>
	<td>
		<input type="text" id="id" name="id" readonly="readonly" size="60"> 		
	</td>	
</tr>
<tr>
	<th>제목</th>
	<td>
		<input type="text" id="title" name="title" size="60" >		
	</td>
</tr>
<tr>
	<th>내용</th>
	<td>
		<textarea rows="10" cols="60" id="content" name="content"></textarea>		
	</td>
</tr>
<tr>
	<td colspan="2">
		<button type="button" id="updateBtn">글수정</button>
	</td>
</tr>

</table>
</form>
</div>

<a href="bbslist.html">글목록</a>

<script type="text/javascript">
let seq = urlParams.seq;

getBbs();

function getBbs() {
	$.ajax({
		url:"http://localhost:3000/bbsdetail",
		type:"get",
		data:{'seq':seq},
		success:function(data){
		//	alert('success');
			$("#seq").val( data.seq);
			$("#id").val( data.id );
			$("#title").val( data.title );
			$("#content").val( data.content );
		},
		error:function(){
			alert('error');
		}
	});
}

$("#updateBtn").click(function() {
	//	let params = $("#frm").serialize();
	//	alert(params);
	
	$.ajax({
		url:"http://localhost:3000/bbsupdate",
		contentType: 'application/.xml; charset=utf-8',
		type:"get",
		data:$("#frm").serialize(),
		success:function(resp){
		//	alert('success');
		
			if(resp == "OK"){
				alert('수정되었습니다');
			}else{
				alert('수정되지 않았습니다');
			}			
			location.href = "bbslist.html";
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



- bbsdelete.html
  - 글 삭제

```html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
//html에서 추가하면, parameter를 받을 수 있는 소스 : 추가만 해주면 된다.
let urlParams = location.search.split(/[?&]/).slice(1).map(function(paramPair) {
    return paramPair.split(/=(.+)?/).slice(0, 2);
}).reduce(function(obj, pairArray) {
    obj[pairArray[0]] = pairArray[1];
    return obj;
}, {});
</script>

</head>
<body>

<script type="text/javascript">
let seq = urlParams.seq;
alert(seq);

bbsDelete();

function bbsDelete() {
	$.ajax({
		url:"http://localhost:3000/bbsdelete",
		type:"get",
		data:{'seq':seq},
		success:function(resp){
			// alert('success');
		
			if(resp == "OK"){
				alert('삭제되었습니다');
			}else{
				alert('삭제되지 않았습니다');
			}			
			location.href = "bbslist.html";
		},
		error:function(){
			alert('error');
		}
	});
}
</script>
</body>
</html>
```



