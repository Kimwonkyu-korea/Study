# CSS

## CSS - Cascading Style Sheet

- 문자의 컬러, 종류, 형태 지정
- 배경화면 이미지, 컬럼 지정
- 테두리 넣기
- 각종 tag에 이미지 형태 라인을 적용할 수 있다.
  	

#### Attribute(속성) - 접근

1. **id**			- css, javascript	현 웹페이지에서 1개만 적용된다	->	 JS에서 1개만 접근이 가능하다.
2. **class**	  - css, javascript	다수의 태그에 적용이 가능하다.
3. **name**	 - javascript 		   link를 통해서 파라미터로 전달하다.



**inline(태그 안)**

```html
<!-- lnline 방식 -->
<p style="background-color: #0000ff; color: #ffff00">내용</p>

```



**internal(head)**

```html
<!-- internal 방식 -->
<style type="text/css">
h1{
	color:red;    /* color를 property*/
}
p{
	color: #0000ff;
}

#idcss{
	font-size: 150%;
	background-color: yellow;
	color: green; 	
}

.classcss{
	background-color: red;
	border: 1px solid;
}

</style>
```



**external(외부파일)**

```html
<!-- external 방식 -->
<link href="style.css" rel="stylesheet">
```



### font-size

```html
<p class="p1">p size 1 cm</p>
<p class="p2">p size 1 mm</p>
<p class="p3">p size 1 inch</p>		<!-- 1 inch == 2.54cm -->
<p class="p4">p size 1 pt</p>
<p class="p5">p size 1 pc</p>

<p class="p6">p size 24 px</p>
<p class="p7">p size 1 em</p>
<p class="p8">p size 100%</p>
```



### margin과 padding

- margin : Object와 화면과의 여백(외부여백)
- Object내의 내부여백을 



### table CSS

```html
<style type="text/css">
table {
	width: 100%;
	border-collapse: collapse; /* 선 하나로 설정 */
}

table, th, td{ 	/* 같이 선언할 수 있다 */
	border: 1px solid black;
}
</style>
```



### body CSS

- 한줄에 쓸 수 있따

```html
<style type="text/css">
body {
/* 	background-color: red;
	background-image: url("back.jpg");
	background-repeat: no-repeat;
	background-position: right top; */
	
	background: #00ff00 url("back.jpg") repeat-y right top;
}
</style>
```



### 화면비에 따른 색 CSS

- fullscreen, left, right 
- left와 right는 up,down 나눈다.
- id 값은 #, class 값은 . 

```html
<style type="text/css">
#fullscreen{
	width: 800px;
	height: 500px;
	background-color: gray;
}
#left{
	width: 400px; 
	height: 500px;
	background-color: orange;
	float: left;
}
.right{
	width: 400px;
	height: 500px;
	background-color: red;
	float: left;
}

#leftup{
	width: 300px;
	height: 300px;
	background-color: yellow;
}

#leftdown{
	width: 350px;
	height: 200px;
	background-color: olive;
}
.rightup{
	width: 300px;
	height: 200px;
	background-color: blue;
}
.rightdown{
	width: 300px;
	height: 300px;
	background-color: green;
}
</style>
```

