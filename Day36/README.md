# # SpringSample 1

![image-20211008235003293](C:/Users/User/AppData/Roaming/Typora/typora-user-images/image-20211008235003293.png)



index.jsp 

- 프로젝트 / src / main / webapp
  -  서버를 실행하는 페이지



web.xml 

- 프로젝트 / src / main / webapp / WEB-INF 
  - servlet 설정

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd" version="4.0">
  <display-name>sprSample1</display-name>
  <welcome-file-list>
    <welcome-file>index.html</welcome-file>
    <welcome-file>index.htm</welcome-file>
    <welcome-file>index.jsp</welcome-file>
    <welcome-file>default.html</welcome-file>
    <welcome-file>default.htm</welcome-file>
    <welcome-file>default.jsp</welcome-file>
  </welcome-file-list>
  <servlet>
    <servlet-name>dispatcherServlet</servlet-name>
    <servlet-class>
		org.springframework.web.servlet.DispatcherServlet
	</servlet-class>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>
			/WEB-INF/spring/dispatcherServlet.xml
		</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
  </servlet>
  <servlet-mapping>
    <servlet-name>dispatcherServlet</servlet-name>
    <url-pattern>*.do</url-pattern>
  </servlet-mapping>
</web-app>
```



- dispatcherServlet.xml
  - 프로젝트 / src / main / webapp / WEB-INF / spring
  - src/main/java에 있는 패키지로 설정

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd">

	<!-- spring MVC annotaion(주석문, 지시어)을 사용하기 위한 설정 -->
	<context:annotation-config />
	
	<!-- 사용자의 view의 위치와 확장명을 설정 -->
	<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/views/"></property>	<!-- views(jsp, html)의 경로 -->
		<property name="suffix" value=".jsp"></property>	<!-- 확장자명은 jsp -->
	</bean>
	<!-- InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();  
		 ViewResolver.prefix = "/WEB-INF/views";
	-->
	
	<context:component-scan base-package="mul.com.a" />
	
</beans>
```



- 프로젝트 / src / main / webapp / WEB-INF / views

  - hello.jsp

  ```jsp
  <%@page import="mul.com.a.Human"%>
  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  </head>
  <body>
  
  <h2>hello JSP</h2>
  
  <%
  // 짐을 푼다
  String name = (String)request.getAttribute("name");
  %>
  
  이름:<%=name %><br><br>
  
  이름:${name}	<!--(속성값), jsp만 가능 , EL tag, Core tag-->
  
  <form action="home.do" method="get">
  이름:<input type="text" name="name">
  <br>
  나이:<input type="text" name="age">
  <br>
  <input type="submit" value="전송">
  </form>
  
  <%
  Human hu = (Human)request.getAttribute("human");
  if( hu == null) {
  	hu = new Human("김영희", 22);
  }
  %>
  
  이름:<input type="text" name="<%=hu.getName() %>">
  <br>
  나이:<input type="text" name="<%=hu.getAge() %>">
  <br><br>
  
  이름:<input type="text" value="${human.name}">
  <br>
  나이:<input type="text" value="${human.age}">
  
  </body>
  </html>
  ```

  

  - home.jsp

  ```jsp
  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  </head>
  <body>
  
  <h2>Home Jsp</h2>
  
  </body>
  </html>
  ```

  

- 프로젝트 / src/main/java / mul.com.a

  - HomeController.java

  ```java
  package mul.com.a;
  
  import java.util.Date;
  
  import org.slf4j.Logger;
  import org.slf4j.LoggerFactory;
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  
  @Controller		// <- annotation
  public class HomeController {
  	
  	private static Logger logger = LoggerFactory.getLogger(HomeController.class);
  	
  	@RequestMapping("home")
  	public String helloMethod() {
  	//	System.out.println("HomeController helloMethod()");
  		logger.info("HomeController helloMethod() " + new Date());
  		
  		return "home";		// <- home.jsp로 이동
  	}
  	
  	@RequestMapping(value = "hello.do")
  	public String hello(Model model) {	// Model <- 짐을 포장하기 위한 interface
  		logger.info("HomeController hello() " + new Date());
  		
  		String name = "홍길동";
  		
  		model.addAttribute("name", name);	// 짐싸! == setAttribute
  		
  		return "hello"; 	// <- hello.jsp로 이동
  	}
  	/*
  	@RequestMapping(value = "home.do", method = RequestMethod.GET)
  	// 전달 받을 값이 같아야된다.
  	public String home(String name, int age) {	// hello.jsp로 부터 전달 받는 값, spring 자동으로 바꿔줌 parsing x
  		logger.info("HomeController home() " + new Date());
  		
  		System.out.println("name:" + name);
  		System.out.println("age:" + age);
  		
  		return "hello";		// <- hello.jsp로 이동
  	}*/
  	
  	@RequestMapping(value = "home.do", method = RequestMethod.GET)
  	// 전달 받을 값이 같아야된다.
  	public String home(Model model ,Human human) {	// 자동생성
  		logger.info("HomeController home() " + new Date());
  		
  		System.out.println("name:" + human.getName());	// 객체 안 값
  		System.out.println("age:" + human.getAge());
  		
  		model.addAttribute("human", human);
  		
  		return "hello";		// <- hello.jsp로 이동
  	}
  }
  ```

  

  - Human.java

  ```java
  package mul.com.a;
  
  import java.io.Serializable;
  
  public class Human implements Serializable{
  	
  	private String name;
  	private int age;
  	
  	// 생성자 필수
  	public  Human() {
  	}
  
  	public Human(String name, int age) {
  		super();
  		this.name = name;
  		this.age = age;
  	}
  
  	public String getName() {
  		return name;
  	}
  
  	public void setName(String name) {
  		this.name = name;
  	}
  
  	public int getAge() {
  		return age;
  	}
  
  	public void setAge(int age) {
  		this.age = age;
  	}
  
  	@Override
  	public String toString() {
  		return "Human [name=" + name + ", age=" + age + "]";
  	}
  }
  ```

  

  

