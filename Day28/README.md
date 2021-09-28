## JSON

### JSON : Java Script Object Notation



- JSON 데이터 

```html
<p id="demo"></p>
 
<script type="text/javascript">

let jsonDate = [
					{
						"name":"홍길동",
						"age" : 24,
					},
					{
						"name": "성춘향", 
						"age":16,
					}
				];


document.getElementById("demo").innerHTML = jsonDate[1].name + " " + jsonDate[1].age;

let arrText = '{"name":"홍길동", "age" : 24, "주소":"서울시"}';
//alert(arrText);
</script>
```



- String -> Json Object

```html
<script type="text/javascript">
let jsonObj = JSON.parse(arrText);
alert(jsonObj);
</script>
```



- Json Object -> String 

```html
<script type="text/javascript">
let str = JSON.stringify(jsonObj);
alert(str);
</script>
```



# JSON - table 

- json 파일 불러오기

```html
<script type="text/javascript">

let xhttp = new XMLHttpRequest();	// 생성

xhttp.onreadystatechange = function () {	// 함수 생성
		
	if(this.readyState == 4 && this.status == 200){	// 성공적으로 처리 될 때
		jsonPars(this);
	}
}

xhttp.open("GET", "data.json", true);	// 파일 불러오기
xhttp.send();
```



- 함수생성 및 json 변경

```html
function jsonPars( xhttp ) {
	
	let jsonDoc = xhttp.responseText;
	let jsonObj = JSON.parse(jsonDoc);	// json 변경
```



- table 생성
- 컬럼 5개, row 4개

```html
function jsonPars( xhttp ) {
	
	let jsonDoc = xhttp.responseText;
	let jsonObj = JSON.parse(jsonDoc);	// json 변경
```



- datas 

- 실제 데이터 값

```html
for(i = 0;i < jsonObj.length; i++){
		out += "<tr>";	
		
		out += "<th>" + (i + 1) + "</th>";
		
			out += "<td>" + jsonObj[i].title + "</td>";
			out += "<td>" + jsonObj[i].author + "</td>";
			out += "<td>" + jsonObj[i].price + "</td>";
			out += "<td>" + jsonObj[i].date + "</td>";		
		
		out += "</tr>";
	}	
	out += "</table>";	
	
	document.getElementById("books").innerHTML = out;
}
```

