# JQuery

### 특징

- Java Script 경량화, 간략화
- Java Script 경량화, 간략화



### 형식 및 사용

```js
$( tag명, id, class, name ).핸들러 함수(매개변수)
```



- script 부분 기본 함수

```html
<script type="text/javascript">
$(document).ready(function() {	// 문서가 준비되면 실행
});
</script>
```



- 1. w3school -> JQuery -> 아무링크 참고

```html
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
```

- 2. 해당 src 복사 후 크롬 창 붙혀넣기 -> 다른 이름으로 저장(jquery.min.js) -> 프로젝트 파일
- 3. JS 파일을 만들어서 저장

```js
document.write('<script src="jquery.min.js"></script>');
```

- 4. index파일 불러오기

```html
<script src="jquery.min.js"></script>
```





### Java script / JQuery

- getter
  - innerHTML = html(), text()
  - value = val()

```
 JS
let pval = document.getElementsByTagName("p")[0].innerHTML;

 JQuery
let pval = $("p").html();

let demo = $("#demo").html();	// id일 경우# 사용 / text()도 가능
	alert(demo);
```



- setter 

```
$("p").html("hello <b>p</b> tag");	// setter
$("p").text("hello <b>p</b> tag text");	// 문자열로 인식

$("#demo").text("p tag 입니다");	// html();
	
$(".cls").text("cls class 값입니다"); // class는 . 사용
```



- JQuery 장점 (함수)
  - ready는 최종적으로 실행, 문서가 준비되면 함수를 실행.

```
function func() {
	//	java script
	let ptagArr = document.getElementsByTagName("p"); // Object
	for (i = 0; i < ptagArr.length; i++) {
		ptagArr[i].innerHTML = "p 태그입니다!!!";
	}
}

// JQuery
$("p").html("p 태그입니다!!!");
```



- button

```html
<script type="text/javascript">

//JS		먼저 실행된다.
function btnClick() {
}

// Jquary
$("button").click(function () {
});

$("#btn").click(function () {	//id 접근
})


$("#btn").on("click", function () {		// id접근, 버튼 클릭 시 함수 호출
});

$("#btn").on("click", btnClick);	// 클릭 시 해당 함수를 호출

function btnClick() {
}
    
$("#btn").click(function () {
//alert("click");
	
// getter
let value = $("#text").val();
alert(value);
	
// setter
$("#text").val("hello JQuery");
	
});
</script>
```



- this

```html
<script src="jquery.min.js"></script>
</head>
<body>

<p class="cls">p tag</p>

<h2 class="cls">h2 tag</h2>

<h3 class="cls">h3 tag</h3>

<div class="cls">div tag</div>

<script type="text/javascript">
$(document).ready(function() {		// 문서가 준비되면 실행
	
	$(".cls").click(function() {	// class 접근
		//alert('cls click');
	
		$(this).text("여기를 클릭!");	// 클릭 시 text() 변경
	
	})
	
});
</script>
```



- table

```html
<table border="1">
<col width="50"><col width="200"><col width="150">
<tr>
	<th>번호</th><th>이름</th><th>나이</th>
</tr>
<tr class="cls">
	<th>1</th><td>홍길동</td><td>24</td>
</tr>
<tr class="cls">
	<th>2</th><td>성춘향</td><td>16</td>
</tr>
<tr class="cls">
	<th>3</th><td>일지매</td><td>22</td>
</tr>
</table>

<script type="text/javascript">
$(document).ready(function() {
	
	$("tr.cls").mouseover(function() {	// tr tag 안에 class="cls"만 허용
		$(this).css("background", "#00ff00");	// 마우스를 올렸을 때
	});
	
	$("tr.cls").mouseout(function() {
		$(this).css("background", "#ffffff");	// 마우스가 밖으로 나갈 때
	});
	
	$("td").on("click", function () {
		let txt = $(this).text();	// 클릭 시 자신의 text를 가져옴
		alert(txt);
	});
	
	// html(), text(), css()
	
});
</script>
```



- attribute(속성) 추가

```html
<script type="text/javascript">
$(document).ready(function() {
	
	$("button").click(function() {
	$("p").attr("id", "demo");	// id="demo" 생성
		
		let ptext = $("p").attr("id");	// p tag에 id 값 추가
	//	alert(ptext);
        
		$("p").attr("class", "back");	
        
		// html(), text(), val(), css(), attr(), prop()
	});
});
</script>
```



- radio
  - id는 한개만 인식하기때문에 name 사용

```html
<ul>	
	<li><input type="radio" name="radio_test" value="apple" checked="checked">사과</li>
	<li><input type="radio" name="radio_test" value="pear">배</li>
	<li><input type="radio" name="radio_test" value="banana">바나나</li>
</ul>

<button type="button" id="choice">선택</button>

<script type="text/javascript">
$(function () {
	
	$("#choice").click(function() {
	// getter
	//let rVal = $("input[name='radio_test']:checked").val();
	//alert(rVal);
	
	// setter
	$("input[name='radio_test']").val(["banana"]);
	});
});
</script>
```



- checkbox

```html
<input type="checkbox" id="ch" checked="checked">그림그리기
<br><br>
<button type="button" id="btn">체크</button>

<script type="text/javascript">

$("#btn").click(function() {

	// getter
//	let check = $("#ch").is(":checked");
    
	// setter
	$("#ch").prop("checked", true);	// 버튼 클릭 시 id="ch"를 체크함
});
</script>

```



- append

```html
<div id="demo"></div>

<button type="button">태그 추가</button>

<script type="text/javascript">
$(function () {
	
	$("button").click(function() {
	
    // html(text) 추가
	//	let txt ="<p><b>html p tag Append</b></p>"
	//	$("#demo").append(txt);
		
		// JavaScript 추가
	//	let element = document.createElement("h3");
	//	element.innerHTML = "JS h3 tag append";		// <h3>JS h3 tag append</h3>
	//	$("#demo").append(element);
		
		// JQuery 추가   
	let element = $("<p></p>").html("JQuery p tag append");	// </p> 생략가능
		$("#demo").append(element);		// 클릭 시 추가
	});
});
</script>
```



- Picker
  - 달력 만들기
  - JQuery UI -> picker 추가

```html
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
```



- input(기본 틀)

```html
<h1>DatePricker</h1>

<p>선택일:<input type="text" id="date"></p>

연도:<input type="text" id="year"><br>
월:<input type="text" id="month"><br>
일:<input type="text" id="day"><br>
요일:<input type="text" id="week"><br>
```



- JQuery

```html
<script type="text/javascript">
$(document).ready(function() {
	
	let week = ['일', '월', '화', '수', '목', '금', '토'];
	
	$("#date").datepicker({
		dateFormat: "yy/mm/dd",		// 날짜 형식
		dayNamesMin: week,	// ['일', '월', '화', '수', '목', '금', '토']
		monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
		onSelect: function ( d ) {
		//	alert( d );
		
			let arr = d.split("/");	// 년도/월/일
			
			$("#year").val( arr[0].trim() ); 	// trim 공백없애기
			$("#month").val( arr[1] );
			$("#day").val( arr[2] );
			
			let weekday = new Date( $("#date").datepicker({ dateFormat: "yy/mm/dd" }).val() );
		//	alert(weekday.getDay());	// 0~6 요일
			
			$("#week").val( week[weekday.getDay()]);	
		}
	});
});
</script>
```



- daumPost

  - 우편번호 찾기

  - http://postcode.map.daum.net/guide -> 예제코드 보기