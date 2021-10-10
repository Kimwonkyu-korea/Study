# EL Tag

#### EL : Expression Language

#### 				표현		    언어



-  front end에서 java코드와 혼용하지 않고 사용하기 위한 태그



#### 형식

```jsp
request.setAttribute("Key", Value);
${ 값(연산식) }
```



#### 코드 및 주석

```jsp
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.HumanDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
		EL : Expression Language
				표현		언어
			 front end에서 java코드와 혼용하지 않고 사용하기 위한 태그

		형식: ${ 값(연산식) }
--%>

<%
	String str = "hello";	// String 객체에 "hello"를 str변수에 넣는다
%>
<!-- 자바스크립트로 출력한다  -->
str:<%=str %><br> 

<%
	request.setAttribute("_str", str);	// _str 속성에 str 값을 가져온다
%>
<!-- EL Tag로 호출 -->
str:${_str }	
<br>
number:${ 2+3 }

<%
// HumanDto 생성자를 만들어서 1, "홍길동" 를 넣어준다
HumanDto dto = new HumanDto(1, "홍길동");
//_dto 속성에 dto 값을 가져온다
request.setAttribute("_dto", dto);
%>

<%
if(dto != null) {	// dto 값이 null 값이 아니면
	
}
%>
<br>
dto = ${empty _dto}		<br>	<!-- dto == null -->
!dto =  ${not empty _dto}	
<br>
<!-- 자바스크립트 호출과 EL 비교  -->
<!-- 값을 통해서 가져온다 -->
number:<%=dto.getNumber() %><br>
name:<%=dto.getName() %><br>

<!-- 속성값을 통해서 가져온다 -->
number:${_dto.number }
name:${_dto.name }	<!-- get 안붙는다 -->

<%--
		EL : Value
		Core : 제어문
--%>

<!-- if -->
<%
	/* count 라는 속성에 "10"을 넣는다 */
	request.setAttribute("count", "10");
%>

<%
	// String 객체 s_count = String 캐스팅 변환을 한 count 속성 값을 가져온다
	String s_count = (String)request.getAttribute("count");
	// int 값으로 바꿔준다
	int count = Integer.parseInt(s_count);
	// count 값이 10보다 크면
	if(count >= 10) {
		%>
		<p>count:<%=count %></p>
		<%
	}
%>

<!-- EL Tag -->
<!-- count 값 속성 값을 사용 -->
<c:if test="${count >= 10 }">
	<p>count:${count}</p>
</c:if>

<%
	/* 속성 name에 홍길동을 담는다 */
	request.setAttribute("name", "홍길동");
%>

<%
	/* String 객체 name = "홍길동"을 담은 name 속성을 가져온다 */
	String name = (String)request.getAttribute("name");
	if(name.equals("홍길동")){
		%>
		<p>이름:<%=name %></p>
		<%
	}
%>
<!--  Core Tag -->
<%-- <c:if test="${name == '홍길동' }"> --%>
<c:if test="${name eq '홍길동' }">
	<p>이름:${name}</p>
</c:if>

<!-- for -->
<%
	for(int i=0; i <10; i++){
		%>
		<p><%=i %></p>
		<%
	}
%>
<!-- begin : 시작점, end : 지정 값까지, step : step, varStatus : 변수 값  -->
<c:forEach begin="0" end="9" step="1" varStatus="i">
	<p>${i.index}</p>
</c:forEach>

<%
	/* String 객체 List를 list로 선언한다 = 생성자 String 배열리스트()*/
	List<String> list = new ArrayList<String>();
	
	// 배열리스트 list에 String 객체 " "를 넣는다
	list.add(new String("tigers"));
	list.add(new String("lions"));
	list.add(new String("twins"));
	
	// 배열리스트 list를 mylist로 설정한다
	request.setAttribute("mylist", list);
	
//	for(String item : list) {
//	}
%>
<!-- 0번지~2번지까지 item(지정)을 list 형식으로 i 값 -->
<c:forEach begin="0" end="2" var="item" items="${mylist}" varStatus="i">
	<p>index:${i.index} date:${item}</p>
</c:forEach>
</body>
</html>
```

