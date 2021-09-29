

# Servlet

### Servlet = server + applet

#### Web ---------- > Servlet(Java) : 언제든 DB를 호출할 수 있다.

```html
	html
		<a href=""						GET
		<form action="" 	submit		GET, POST
		
		JavaScript
		loaction.href = ""				GET
		
		Java 
		sendRedirect 
		forward
```



#### 구성

![image-20210929223435784](C:/Users/User/AppData/Roaming/Typora/typora-user-images/image-20210929223435784.png)



#### web.xml

- 설정

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
                      http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
  version="4.0">
    
 	 <servlet>
		<servlet-name>hello</servlet-name>
		<servlet-class>serv.HelloServlet</servlet-class>
 	 </servlet>  
 
	<servlet-mapping>
		<servlet-name>hello</servlet-name>
		<url-pattern>/location</url-pattern>
	</servlet-mapping>
    
</web-app>  
```



### index.html

- <!-- 파라미터는 get은 보이고, post는 안보임 -->

- checkbox

```
<a href="location">Hello Servlet(doGet)으로 이동</a>
<br><br>
<!-- 파라미터는 get은 보이고, post는 안보임 -->
<form action="location" method="get">
	<input type="text" name="name">
	<input type="checkbox" name="hobby" value="book">독서
	<input type="checkbox" name="hobby" value="game">게임
	<input type="checkbox" name="hobby" value="eat">군것질
	<input type="submit" value="get">
</form>
<br><br>
<form action="location" method="post">
	<input type="text" name="name">
	<input type="submit" value="post">
</form>
```



- button

```html
<button type="button" onclick="btnClick()">Hello Servlet으로 이동</button>

<script type="text/javascript">

// location.href = "loaction?name=" + "성춘향";

function btnClick() {	
	let name = document.getElementById("name").value;
	let number = document.getElementById("number").value;
	// 검사를 할 수 있다.
	
	location.href = "location?name=" + name + "&number=" + number;
}
</script>
```



#### src

- Java 영역
- doGet(), doPost() 나뉜다.
- HttpServlet 상속

```java
public class HelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("HelloServlet doGet()");
		
		String name = req.getParameter("name");
		System.out.println(name);
		
		int number = Integer.parseInt(req.getParameter("number"));
		System.out.println(number);
		/*
		 * resp.setContentType("text/html; charset=utf-8"); PrintWriter pw =
		 * resp.getWriter(); pw.println("<html>");
		 * 
		 * pw.println("<head>"); pw.println("<title>HelloServletHtml</title>");
		 * pw.println("</head>");
		 * 
		 * pw.println("<body>");
		 * 
		 * pw.println("<h3>Hello Servlet</h3>");
		 * 
		 * pw.println("</body>");
		 * 
		 * pw.println("</html>");
		 * 
		 * pw.close();
		 */
		// 짐싸!
		HumanDto human = new HumanDto(name, number);	// 객체로 만듬
		req.setAttribute("human", human); 				// 문자열, object
		
		
		resp.sendRedirect("world");  		// servlet으로 이동	 짐을 안가져감
	//	resp.sendRedirect("index.html");  	// web으로 이동
		
		// 이동해
	//	RequestDispatcher rd = req.getRequestDispatcher("world");
	//	rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
```



#### session

- server에 저장.	Java에서 사용
- 사용자정보를 저장
- 기한을 설정

```java
// 세션을 생성
		HttpSession session = req.getSession();
		
		// 세션에 저장
		session.setAttribute("name", "giant");
		
		// 세션에서 산출
		String name = (String)session.getAttribute("name");
		
		HumanDto human = new HumanDto("홍길동", 1001);
		
		session.setAttribute("user", human);
		session.setMaxInactiveInterval(10); // 시간만큼 저장
		
		HumanDto h = (HumanDto)session.getAttribute("user");
		
		/*
		// 세션 오브젝트 삭제
		session.removeAttribute("name");
		
		// 세션 삭제
		session.invalidate();
		*/
```



#### dto

- private 값 설정
- using fields
- toString

```java
package dto;

import java.util.Arrays;

public class HumanDto {
	
	private String name;
	private String age;
	private String gen;
	private String hobby[];
	public HumanDto(String name, String age, String gen, String[] hobby) {
		super();
		this.name = name;
		this.age = age;
		this.gen = gen;
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "결과 출력 : [이름=" + name + ", 나이=" + age + ", 성별=" + gen + ", 취미=" + Arrays.toString(hobby) + "]";
	}
}
```



