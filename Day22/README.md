# HTML

## HTML(Hypertext Markup Language)

- **웹페이지를 구성, 배치하기 위한 태그들로 구성되어 있는 마크언 언어이다.**



#### 주석 :   Ctrl + Shift + /



**개행**

```html
<br>
```



**글씨 크기**

```html
<h1>Hello World</h1>
<h2>Hello World</h2>
<h3>Hello World</h3>
<h4>Hello World</h4>
<h5>Hello World</h5>
<h6>Hello World</h6>
```



**paragraph : 단락**

```html
<p> 내용 </p>
```



 **Pre Formatted : 분단**

```html
<pre> 내용 </pre>
```



**image** 

- C,D 드라이브 영역에서는 가져올 수 없다 (서버에 올라온 것만 가능)

```html
<img alt="" width="200" height="300" src="URL">
```



**Tag안의 tag**

```html
<p>보통의 단락태그</p>

<p><b>두꺼운</b> 텍스트</p>

<p><strong>strong</strong></p>

<p><i>이탤릭 텍스트</i></p>

<p>나는 <em>성공</em> 할 것입니다</p>

<p>보시는 글은 <del>삭제</del>된 글입니다</p>

<p>이것은 <sub>아래</sub> 첨자입니다</p>

<p>이것은 <sup>윗</sup>첨자 입니다</p>

<a href="http://www.naver.com">네이버</a>

<a href="http://www.daum.net">다움</a>

<a href="htmlPage.html">htmlPage.html로 이동</a>

<a href="http://www.daum.net" target="_blank">다움</a>
```



**컬러 지정**

```html
<h1 style="color: yellow;">h1 tag입니다.</h1>
 
<h2 style="background-color: #00ff00;">h2 tag입니다</h2>

<h3 style="font-family: verdana;">h3 tag입니다</h3>
```



**List**

- 순서있는 리스트 type 지정가능

```html
<ol type ="I">
	<li>사과</li>
	<li>바나나</li>
	<li>오렌지</li>
</ol>
```

- 순서없는 리스트

```html
<ul>
	<li>사과</li>
	<li>바나나</li>
	<li>오렌지</li>
<ul>
```

- 리스트안의 리스트

```html
<ul>
	<!-- 첫번재 목록 -->
	<li>
		<b>과일</b>		<!-- bold -->
		<ol>
			<li>사과</li>
			<li>바나나</li>
			<li>오렌지</li>
		</ol>
	</li>
	
	<!-- 두번재 목록 -->
	<li>
		<b>채소</b>
		<ol type="A">
			<li>상추</li>
			<li>치커리</li>
			<li>양배추</li>
		</ol>
	</li>
</ul>
```





**Table**

- thead, tbody 생략가능

```html
<table border="1" style="width: 50%">
	<!-- 중앙 맞추기 -->
	<caption>주소록</caption>
<tr>
	<th>번호</th>
	<th>이름</th>
	<th>나이</th>
	<th colspan="2">전화번호</th>
<!--<th>전화번호</th> -->
</tr>
<tr>
	<th>1</th>
	<th>홍길동</th>
	<th>24</th>
	<th>123-4567</th>
	<th>010-123-4567</th>
</tr>
<tr>
	<th>2</th>
	<th>성춘향</th>
	<th>26</th>
	<th>234-5678</th>
	<th>010-234-5678</th>
</tr>
```



**Audio**

```html
<body>
	<audio src="Kalimba.mp3" controls="controls"></audio>
	<br>
	
	<video width="640" controls="controls">
		<source src="mov_bbb.mp4" type="video/mp4">
		<!-- <source src="mov_bbb.webm" type="vidoe/webm"> -->
		
	</video>
	
	
</body>
```

