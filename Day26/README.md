# JavaScript

### JavaScript != Java  -> 사용 목적이 다르다.


#### 목적

- Client쪽의 언어이다. (front end)

- 웹 브라우저의 Tag들을 접근하기 위한 스크립트.
- 보조 프로그래밍 언어이다.
- 컴파일을 하지 않는다 -> 가볍다 -> 속도가 빠르다.

- JavaScript 간략화, 경량화 -> JQuery(Ajax)



#### 웹 에서 사용

- 회원가입 -> 빈칸을 조사. ID 글자수를 조사. PW에 숫자, 문자를 포함
- CSS에 대해서 제어, 구현
- Timer를 설정해서 특수효과 같은 처리가 가능



#### element(요소)

- id		-> 현 웹페이지에서 1개 유효. JS용
- class   -> 다수의 Tag에 적용이 가능. CSS
- name  -> 다수의 Tag에 적용이 가능. 값을 전달



#### innerHTML 

```html
<p id="demo">p태그입니다</p>
 
 <script type="text/javascript">
 // 여기가 JS영역
 /*
 	주석문
 */
 console.log('Java Script가 실행되었음');
 
// alert('Java Script가 실행되었음')  팝업창

var v = document.getElementById("demo").innerHTML;
// alert(v)

document.getElementByID("demo").innerHTML = "p tag id demo"; // setter
 
 </script>
```



#### 변수(Variavle) 

- Integer, Double, String, Object, MyClass

```html
<p id="demo">p tag</p>

<script type="text/javascript">
    
Integer in = 234;
	String str = "hello";
	String str = new String("hello");
	MyClass cls = new MyClass();
	
	Object cls = new MyClass();
	Object cls = new YouClass();

</script>
```



#### var를 안쓰고 let을 쓰는 이유

```html
<script type="text/javascript">
var num = 123;
	var pi = 3.141592;
	var name = "홍길동";
	var str = '안녕하세요'; 
	
	var num = 234;
	alert(num);

	
	let num = 123;
	
	let num = 234;
	alert(num);
</script>
```



#### Array(배열)

```html
<script type="text/javascript">	
	let cars = []; 
	let cars = [ "Saab", "Volvo", "BMW"];
	console.log(cars[1]);
	
	cars = new Array(3);	// String cars[] = new String[3];
	cars[0] = "사브";
	cars[1] = "볼보";
	cars[2] = "비엠더블유";
	console.log(cars[2]);
</script>
```



#### for / foreach

```html
for(let i=0; i < cars.length; i++) {	// let 생략가능
		console.log(cars[i]);
	}
	
	// foreach
	for(car in cars) {	// let 생략, : -> in
		console.log(cars[car]);
```



#### Object

```html
<script type="text/javascript">
	let obj = {
 			firstname: '길동',	// key:value -> hashmap(Java) == Json(Web)
 			lastname: '홍',
 			age:24,
 			func : function(){
 				console.log("func 함수호출");
 				console.log(this.lastname + this.firstname);	// this 
 			},
 			method:function(a,b){
 				this.age = a;
 			}
 	}
	console.log(obj.firstname);
	console.log(obj.age);
	obj.func();
	
	class Person{
		constructor(name, age){	// 매개변수
			this.name = name;	
			this.age = age;
		}
		allprint(){
			console.log(this.name + " " + this.age);
		}
	}
	let pobj = new Person("일지매", 22);
	console.log(pobj.name);
	console.log(pobj.age);
</script>
```



#### button

```html
<h3>입력한 숫자를 2배증가시켜 출력하시오</h3>
입력:<input type="text" id="num">
<br><br>
출력:<input type="text" id="out">
<br><br>
<button type="button" onclick="inputBtn()">2배증가</button>

<script type="text/javascript">
function inputBtn() {
	let num = document.getElementById("num").value;
	
	document.getElementById("out").value = parseInt(num) * 2;
	
	// String -> Integer = Integer.parseInt("123");
}
</script>
```



#### 날짜 시간을 설정

- Java -> Calendar() , Date()

```html
<script type="text/javascript">

let date = new Date(); 	// 현재 날짜시간

date = new Date(2021, 12-1 , 3, 6, 25, 10, 0);	// 달은 0~11

date = new Date("October 12, 2021 12:35:35"); //2021/10/12

document.getElementById("date").innerHTML = date;

document.getElementById("date").innerHTML = date.getDay(); // 요일
document.getElementById("date").innerHTML = date.getFullYear(); // 년
document.getElementById("date").innerHTML = date.getMonth() + 1; // 달
document.getElementById("date").innerHTML = date.getDate(); // 날짜
document.getElementById("date").innerHTML = date.getHours(); // 시
document.getElementById("date").innerHTML = date.getMinutes(); // 분
document.getElementById("date").innerHTML = date.getSeconds(); // 초
</script>
```



#### Access attribute

- id		: 1개만 접근. (빈칸)검사
- class	: 다수. CSS 
- name	: 다수. 데이터전송

```html
<p id="pdemo">p tag</p>
<p id="pdemo">p tag</p>
<br>

<h3 class="hdemo">h3 tag</h3>
<p class="hdemo">p tag</p>
<br>

<p name="pname">p tag</p>

 <button type="button" onclick="btnclick()">클릭</button>
 
 <script type="text/javascript">
 function btnclick() {
	document.getElementById('pdemo').innerHTML = 'p 태그입니다';
	
//	document.getElementsByClassName('hdemo')[1].innerHTML = 'class는 hdemo';

//	alert(document.getElementsByClassName('hdemo').length);

	let hdemo = document.getElementsByClassName('hdemo');
	//
	//alert(hdemo[0].innerHTML);
	
	for(i =0; i<hdemo.length; i++){
		hdemo[i].innerHTML = 'class는 hdemo입니다.';
	}
	// HTML -> innerHTML
	document.getElementsByName("pname")[0].innerHTML ='pname입니다';
	
	document.getElementsByTagName("p")[1].innerHTML = '이것으로 결정!!'
}
 </script>
```



#### location.href

- 파일로 이동

```html
<input type="button" value="이전" onclick="history.back()">

<input type="button" value="현재페이지를 갱신" onclick="location.reload()">

<input type="button" value="진행" onclick="history.forward()">

<input type="button" value="index3로 이동" onclick="gopage()">

<script type="text/javascript">
function gopage() {
	location.href = "index3.html";
}
</script>
```



