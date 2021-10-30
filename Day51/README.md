# Spring boot 



### sprBootBack



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



- sqls
- Bbs.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="mul.com.a.dao.BbsDao">
<!-- BbsParam를 만들어준다. -->
<select id="getbbslist" parameterType="mul.com.a.dto.BbsParam" resultType="mul.com.a.dto.BbsDto">
	SELECT SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT
			FROM (SELECT ROW_NUMBER()OVER(ORDER BY REF DESC, STEP ASC) AS RNUM,
			SEQ, ID, REF, STEP, DEPTH,TITLE, CONTENT, WDATE,DEL, READCOUNT
	FROM BBS
			WHERE 1=1	<!-- 무조건 참으로 만들기 위함 -->
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
	WHERE RNUM BETWEEN ${start} AND ${end}	<!-- int값일 경우 $로하는 경우가 많다. -->
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

<!-- 상세 글보기-->
<select id="getBbs" parameterType="Integer" resultType="mul.com.a.dto.BbsDto">
	SELECT SEQ, ID, REF, STEP, DEPTH, TITLE, CONTENT, WDATE, DEL, READCOUNT
	FROM BBS
	WHERE SEQ=#{seq}
</select>

<!-- 답글 -->
<insert id="answerInsert">

</insert>

</mapper>
```



- BbsDao

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
	// 상세글보기
	BbsDto getBbs(int seq);
}
```



- BbsService.java
  - BbsDao.java 데이터 편집하는 기능

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
	
	public BbsDto getBbs(int seq) {
		return dao.getBbs(seq);
	}
}
```



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
	public String bbswrite(BbsDto bto) {
		System.out.println("BbsController bbswrite()");
		
		boolean b = service.writeBbs(bto);
		if(b == true) {
			return "OK";
		}else {
			return "NG";
		}	
	}
	
	@RequestMapping(value = "/bbsdetail", method = RequestMethod.GET)
	public BbsDto bbsdetail(int seq) {
		System.out.println("BbsController bbsdetail()");
		
		return service.getBbs(seq);
	}
	
}
```



### sprBootFront



- bbslist.html
  - 게시판 리스트

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

<div id="app" class="container">

<table class="table table-striped table-hover">
<!-- thead, tboby로 구분-->
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

getBbslist(0);	// 0을 넣어줘서 초기 리스트화면을 보여준다.
getBbsCount();	// 검색된 부분을 실행한다.

function getBbslist( page ) {
	let choice = $("#_choice").val();	// 옵션 선택 값 
	let search = $("#_search").val();	// 검색어 값
		
	$.ajax({
		url:'http://localhost:3000/bbslist',
		type:"get",
		data:{ 'choice':choice, 'search':search, 'page':page },	// param.dto
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
			$("#blist").html(""); // 중복을 방지하기 위함
			$.each(list, function (i, item) {	 // 배열, 힘수(인덱스, 값)
				let str = "<tr>";
				str += "<td>" + (i + 1) + "</td>";
				
				if(item.del == 0){	// 삭제가 안될 경우
                    // 글을 보여줌, 글을 누를경우 해당 seq를 가지고 bbsdetail.html로 이동
					str += "<td>" + getArrow(item.depth) + "<a href='bbsdetail.html?seq=" + item.seq + "'>" + item.title + "</a>" + "</td>";
				}else{	// 글이 없을 경우 -> 삭제
					str += "<td><font color='red'>***이 글은 작성자의 의해서 삭제되었습니다***</font></td>";
				}
				
				str += "<td>" + item.id + "</td>";
				str += "<td>" + item.seq + "</td>";
				str += "</tr>";
				// tbody에 더해줘라
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
        // select선택한 값과, 검색어 값
		data:{ 'choice':$("#_choice").val(), 'search':$("#_search").val(), 'page':0 },
		success:function(count){	// param 리턴
		//	alert(count);
			loadPage(count);	// function loadPage( totalCount ) 이동
		}
	});
}

// 검색
$("#btnSearch").click(function () {	// 검색 클릭 시
	getBbslist(0);	// 초기값 실행	
	getBbsCount();	// 검색 실행
});

function loadPage( totalCount ) {
	
	let pageSize = 10;		// 페이지의 크기
	
	let _totalPages = totalCount / 10	// 총 글수 / 10 
	if(totalCount % 10 > 0){			// 나머지 값은 ++로 1개더 생성
		_totalPages++; 
	}
	
	// 페이지 갱신
	$("#pagination").twbsPagination('destroy');

	$("#pagination").twbsPagination({
		startPage: 1,
		totalPages: _totalPages,
		visiblePages: 10,	// 10개로 보여준다
		first:'<span sris-hidden="true">«</span>',
		prev:"이전",
		next:"다음",
		last:'<span sris-hidden="true">»</span>',
		initiateStartPageClick:false,		
        // onPageClick 자동호출이 되도록 하지 않는다
		onPageClick:function(event, page){ // 페이지 번호를 클릭
		//	alert(page);			1 2 3 4
			getBbslist(page - 1);	// 0 1 2 3	무한 반복
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
  - 게시판 글쓰기

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

let login = sessionStorage.getItem("login");	// login에서 저장된 값을 가져옴 
let id = JSON.parse(login).id;					// id 값 가져옴 
// alert(id);
$("#id").val(id);

$("#btn").click(function() {
	
	$.ajax({
		url:"http://localhost:3000/bbswrite",
		type:"get",
		data:$("#frm").serialize(),	// form 값
		success:function(resp){
		//	alert('success');
		
			if(resp == "OK"){	// 성공
				alert('추가되었습니다');
			}else{				// 실패
				alert('추가되지 않았습니다');
			}					// 이동
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
				<textarea class="form-control" rows="20" id="content"></textarea>
			</td>
		</tr>
	</table>
	
	<button type="button" id="bbslist">글목록</button>
	<button type="button" id="updatebbs">글수정</button>	
	<button type="button" id="deletebbs">글삭제</button>
</div>

<script type="text/javascript">

let seq = urlParams.seq;	// seq값을 가져온다
//alert(seq);

$.ajax({
	url:'http://localhost:3000/bbsdetail',
	type:'get',
	data:{ 'seq':seq },	// 키, 값
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

</script>
</body>
</html>
```

