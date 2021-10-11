# sampleSprDb



![image-20211011173014283](C:/Users/User/AppData/Roaming/Typora/typora-user-images/image-20211011173014283.png)



- 프로젝트 우 클릭 -> Configure -> Maven 생성 -> pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>sampleSprDb</groupId>
  <artifactId>sampleSprDb</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>war</packaging>
  <build>
    <plugins>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <release>16</release>
        </configuration>
      </plugin>
      <plugin>
        <artifactId>maven-war-plugin</artifactId>
        <version>3.2.3</version>
      </plugin>
    </plugins>
  </build>
  
  <dependencies>
  	
  	<dependency>
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-webmvc</artifactId>
	    <version>5.3.6</version>
	</dependency>  	
	
	<dependency>
	    <groupId>log4j</groupId>
	    <artifactId>log4j</artifactId>
	    <version>1.2.17</version>
	</dependency>
	
	<dependency>
	    <groupId>org.slf4j</groupId>
	    <artifactId>slf4j-simple</artifactId>
	    <version>1.7.30</version>	    
	</dependency>
	  
    <dependency>
	    <groupId>javax.servlet</groupId>
	    <artifactId>javax.servlet-api</artifactId>
	    <version>3.1.0</version>
	    <scope>provided</scope>
	</dependency>
	<dependency>
		<groupId>javax.servlet.jsp</groupId>
		<artifactId>jsp-api</artifactId>
		<version>2.1</version>
		<scope>provided</scope>
	</dependency>
	<dependency>
		<groupId>javax.servlet</groupId>
		<artifactId>jstl</artifactId>
		<version>1.2</version>
	</dependency>
	
	<!-- 런타임에 동적으로 자바 클래스의 프록시(대리(인))를 생성해주는 기능을 제공한다 -->
	<dependency>
	    <groupId>cglib</groupId>		
	    <artifactId>cglib</artifactId>
	    <version>3.3.0</version>
	</dependency>
	<dependency>
	    <groupId>commons-digester</groupId>
	    <artifactId>commons-digester</artifactId>
	    <version>1.8</version>
	</dependency>
	
	<dependency>
  		<groupId>commons-logging</groupId>
  		<artifactId>commons-logging</artifactId>
  		<version>1.1.3</version>
  	</dependency>
  	
  	<!-- Ajax 사용 설정[jackson] -->
  	<dependency>
  		<groupId>org.codehaus.jackson</groupId>	
  		<artifactId>jackson-core-asl</artifactId>
  		<version>1.9.12</version>
  	</dependency>
  	<dependency>
  		<groupId>org.codehaus.jackson</groupId>
  		<artifactId>jackson-mapper-asl</artifactId>
  		<version>1.9.12</version>
  	</dependency>
  	
  	<!-- 의존성을 추가 --> 
  	<dependency>
  		<groupId>javax.inject</groupId>
  		<artifactId>javax.inject</artifactId>
  		<version>1</version>
  	</dependency>
  	
  	<!-- JCL(자카르타 커먼스 로깅)을 사용 --> 	
  	<dependency>
  		<groupId>org.slf4j</groupId>
  		<artifactId>jcl-over-slf4j</artifactId>
  		<version>1.7.30</version>
  	</dependency>

	<!-- XML 파싱 -->
  	<dependency>
	    <groupId>jdom</groupId>
	    <artifactId>jdom</artifactId>
	    <version>1.0</version>
	</dependency>
	
	<!-- 마이 바티스 스프링 사용시 -->
  	<dependency>
	    <groupId>org.mybatis</groupId>
	    <artifactId>mybatis-spring</artifactId>
	    <version>2.0.3</version>
	</dependency>
	
  	<dependency>
	    <groupId>org.mybatis</groupId>
	    <artifactId>mybatis</artifactId>
	    <version>3.5.3</version>
	</dependency>
	
	<!-- 마이 SQL 사용시 -->	
  	<dependency>
	    <groupId>mysql</groupId>
	    <artifactId>mysql-connector-java</artifactId>
	    <version>8.0.18</version>
	</dependency>
	
	<!-- XML 파싱 -->
  	<dependency>
	    <groupId>org.jdom</groupId>
	    <artifactId>jdom</artifactId>
	    <version>2.0.1</version>
	</dependency>

	<!-- SLF4J API를 사용하도록 -->
  	<dependency>
  		<groupId>org.slf4j</groupId>
  		<artifactId>slf4j-api</artifactId>
  		<version>1.7.30</version>
  	</dependency>

	<!-- log4j -->
  	<!-- <dependency>
  		<groupId>ant</groupId>
  		<artifactId>ant-apache-log4j</artifactId>
  		<version>1.9.4</version>
  	</dependency> -->
  	
  	<dependency>
	    <groupId>commons-dbcp</groupId>
	    <artifactId>commons-dbcp</artifactId>
	    <version>1.4</version>
	</dependency>
  	
  	<!-- Map을 Bean객체로 바꾸어주는 클래스 -->
  	<dependency>
  		<groupId>commons-beanutils</groupId>
  		<artifactId>commons-beanutils-core</artifactId>
  		<version>1.8.2</version>
  	</dependency>
  	
  	<!-- DBCP : DB Connection Poll 사용 --> 
  	<dependency>
  		<groupId>com.kenai.nbpwr</groupId>
  		<artifactId>org-apache-commons-dbcp</artifactId>
  		<version>1.2.2-201002241055</version>
  		<type>nbm</type>
  	</dependency>
  	
  	<!-- IO 기능 개발을 지원하는 유틸리티 라이브러리  다운안됨 -->
  	<dependency>
  		<groupId>org.apache.commons</groupId>
  		<artifactId>commons-io</artifactId>
  		<version>1.3.2</version>
  	</dependency>
  	
  	<dependency>
  		<groupId>org.apache.commons</groupId>
  		<artifactId>commons-lang3</artifactId>
  		<version>3.9</version>
  	</dependency>
  	
  	<dependency>
  		<groupId>org.apache.commons</groupId>
  		<artifactId>commons-pool2</artifactId>
  		<version>2.8.0</version>
  	</dependency>
  	<dependency>
  		<groupId>org.slf4j</groupId>
  		<artifactId>slf4j-log4j12</artifactId>
  		<version>1.7.30</version>
  	</dependency>
  	
  	<!-- spring -->
	<dependency>
  		<groupId>org.springframework</groupId>
  		<artifactId>spring-aop</artifactId>
  		<version>5.3.6</version>
  	</dependency>
  	<dependency>
  		<groupId>org.springframework</groupId>
  		<artifactId>spring-beans</artifactId>
  		<version>5.3.6</version>
  	</dependency>
  	<dependency>
  		<groupId>org.springframework</groupId>
  		<artifactId>spring-context</artifactId>
  		<version>5.3.6</version>
  	</dependency>  	
  	<dependency>
  		<groupId>org.springframework</groupId>
  		<artifactId>spring-context-support</artifactId>
  		<version>5.3.6</version>
  	</dependency>  	
  	<dependency>
  		<groupId>org.springframework</groupId>
  		<artifactId>spring-core</artifactId>
  		<version>5.3.6</version>
  	</dependency>
  	<dependency>
  		<groupId>org.springframework</groupId>
  		<artifactId>spring-expression</artifactId>
  		<version>5.3.6</version>
  	</dependency>
  	<dependency>
  		<groupId>org.springframework</groupId>
  		<artifactId>spring-jdbc</artifactId>
  		<version>5.3.6</version>
  	</dependency>
  	
  	<dependency>
  		<groupId>org.springframework</groupId>
  		<artifactId>spring-orm</artifactId>
  		<version>5.3.6</version>
  	</dependency>
  	<dependency>
  		<groupId>org.springframework</groupId>
  		<artifactId>spring-test</artifactId>
  		<version>5.3.6</version>
  	</dependency>
  	<dependency>
  		<groupId>org.springframework</groupId>
  		<artifactId>spring-tx</artifactId>
  		<version>5.3.6</version>
  	</dependency>
  	<dependency>
  		<groupId>org.springframework</groupId>
  		<artifactId>spring-web</artifactId>
  		<version>5.3.6</version>
  	</dependency>
  	
  	<!-- Java용 json 라이브러리(XML/YAM/CSV) data-processing 툴 -->
  	<dependency>
	    <groupId>com.fasterxml.jackson.core</groupId>
	    <artifactId>jackson-core</artifactId>
	    <version>2.12.1</version>
	</dependency>
	
	<dependency>
	    <groupId>com.fasterxml.jackson.core</groupId>
	    <artifactId>jackson-databind</artifactId>
	    <version>2.12.1</version>
	</dependency>
		
	
	
	<dependency>
	    <groupId>org.aspectj</groupId>
	    <artifactId>aspectjweaver</artifactId>
	    <version>1.9.4</version>
	</dependency>
	
	<dependency>
	    <groupId>org.aspectj</groupId>
	    <artifactId>aspectjrt</artifactId>
	    <version>1.9.4</version>
	</dependency>
	
	<!-- oracle -->
	<dependency>
	    <groupId>com.oracle.database.jdbc</groupId>
	    <artifactId>ojdbc6</artifactId>
	    <version>11.2.0.4</version>
	</dependency>
		
	<dependency>
	    <groupId>org.json</groupId>
	    <artifactId>json</artifactId>
	    <version>20190722</version>
	</dependency>	
  
</dependencies>

<repositories>
  	<repository>
		<id>codelds</id>		<!-- ojdbc6 와 함께 추가 -->
		<url>https://code.lds.org/nexus/content/groups/main-repo</url>
	</repository>
</repositories>    
</project>
```



webapp

- index.jsp

```jsp
<a href="allMember.do">allMember로 이동</a>
```



#### webapp / WEB-INF / spring

- applicationContext.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd">

	<!-- Database 설정 -->
	
	<!-- DB 초기화 파일의 위치 -->
	<bean id="propertyConfigurer" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
		<property name="locations">
			<list>
				<value>classpath:properties/jdbc.properties</value>
			</list>
		</property>
	</bean>
	
	<!-- DBMS(DataBase Management System) -->
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource" destroy-method="close">
		<property name="driverClassName" value="${jdbc.driverClassName}"/>
		<property name="url" value="${jdbc.url}"/>
		<property name="username" value="${jdbc.username}"/>
		<property name="password" value="${jdbc.password}"/>
		<property name="initialSize" value="${jdbc.initialSize}"/>
		<property name="maxActive" value="${jdbc.maxActive}"/>
		<property name="minIdle" value="${jdbc.initialSize}"/>
		<property name="maxWait" value="3000"/>
		<property name="poolPreparedStatements" value="true"/>
		<property name="maxOpenPreparedStatements" value="50"/>		
	</bean>
	
	<!-- mybatis setting -->
	<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
		<property name="dataSource" ref="dataSource"/>
		<property name="mapperLocations" value="classpath:sqls/*.xml"/>
	</bean>
	<!-- 
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.dataSource = dataSource;
	 -->
	
	<!-- sqlSession 취득 -->
	<bean id="sqlSession" class="org.mybatis.spring.SqlSessionTemplate">
		<constructor-arg index="0" ref="sqlSessionFactory"/>
		<constructor-arg index="1" value="SIMPLE"/>		<!-- value="BATCH" -->
	</bean>
	
	<!-- jdbc 설정 -->
	<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
		<property name="dataSource" ref="dataSource"/>
	</bean>
	
</beans>
```



- servlet-context.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.0.xsd
		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd">

	<!-- spring MVC annotaion(주석문, 지시어)을 사용하기 위한 설정 -->
	<context:annotation-config />
	
	<!-- 사용자의 view의 위치와 확장명을 설정 -->
	<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="prefix" value="/WEB-INF/views/"></property>  <!-- views(jsp, html)의 경로 -->
		<property name="suffix" value=".jsp"></property>		<!-- 확장자명은 jsp -->
	</bean>
	<!-- InternalResourceViewResolver viewResolver = new InternalResourceViewResolver(); 
		 viewResolver.prefix = "/WEB-INF/views";	
	-->

	<context:component-scan base-package="mul.com.a" />

</beans>
```



#### webapp / WEB-INF / views

- allMember.jsp

```jsp
<%@page import="mul.com.a.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% // 짐을 푼다
List<MemberDto> list = (List<MemberDto>)request.getAttribute("memlist");
%>            
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>allMember.jsp</title>
</head>
<body>

<table border="1">
<%
	for(int i = 0;i < list.size(); i++){
		MemberDto dto = list.get(i);
		%>	
		<tr>
			<th><%=i + 1 %></th>
			<td><%=dto.getId() %></td>
			<td><%=dto.getName() %></td>
			<td><%=dto.getEmail() %></td>
		</tr>
		<%
	}
%>
</table>
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





#### src/main/java

- mul.com.a.controller 패키지 생성

  - MemberController.java

  ```java
  package mul.com.a.controller;
  
  import java.util.Date;
  import java.util.List;
  
  import org.slf4j.Logger;
  import org.slf4j.LoggerFactory;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  
  import mul.com.a.dto.MemberDto;
  import mul.com.a.service.MemberService;
  
  @Controller
  public class MemberController {
  
  	private static Logger logger = LoggerFactory.getLogger(MemberController.class);
  
  	@Autowired
  	MemberService service;
  	
  	@RequestMapping(value = "allMember.do", method = RequestMethod.GET)
  	public String allMember(Model model) {
  		logger.info("MemberController allMember " + new Date());
  		
  		List<MemberDto> list = service.allMember();
  		// 짐싸
  		model.addAttribute("memlist", list);
  		
  		// 이동
  		return "allMember";	// allMember.jsp
  	}
  }
  ```

  

- mul.com.a.dao 패키지 생성
  - MemberDao.java

  ```java
  package mul.com.a.dao;
  
  import java.util.List;
  
  import mul.com.a.dto.MemberDto;
  
  public interface MemberDao {
  
  	List<MemberDto> allMember();
  }
  ```



- mul.com.a.dao.impl 패키지 생성
  - MemberDaoImpl.java

  ```java
  package mul.com.a.dao.impl;
  
  import java.util.List;
  
  import org.apache.ibatis.session.SqlSession;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Repository;
  
  import mul.com.a.dao.MemberDao;
  import mul.com.a.dto.MemberDto;
  
  @Repository
  public class MemberDaoImpl implements MemberDao {
  
  	@Autowired
  	SqlSession sqlSession; // IOC, DI
  	
  	String namespace = "Member.";
  
  	@Override
  	public List<MemberDto> allMember() {
  		List<MemberDto> list = sqlSession.selectList(namespace + "allMember");
  		return list;
  	}	
  }
  ```

  

- mul.com.a.dto패키지 생성
  - MemberDto.java

  ```java
  package mul.com.a.dto;
  
  import java.io.Serializable;
  
  public class MemberDto implements Serializable{	// 직렬화 (순서대로 정렬)
  
  	private String id;
  	private String pwd;
  	private String name;
  	private String email;
  	private int auth;		// 사용자:3 관리자:1
  	
  	public MemberDto() {
  	}
  
  	public MemberDto(String id, String pwd, String name, String email, int auth) {
  		super();
  		this.id = id;
  		this.pwd = pwd;
  		this.name = name;
  		this.email = email;
  		this.auth = auth;
  	}
  
  	public String getId() {
  		return id;
  	}
  
  	public void setId(String id) {
  		this.id = id;
  	}
  
  	public String getPwd() {
  		return pwd;
  	}
  
  	public void setPwd(String pwd) {
  		this.pwd = pwd;
  	}
  
  	public String getName() {
  		return name;
  	}
  
  	public void setName(String name) {
  		this.name = name;
  	}
  
  	public String getEmail() {
  		return email;
  	}
  
  	public void setEmail(String email) {
  		this.email = email;
  	}
  
  	public int getAuth() {
  		return auth;
  	}
  
  	public void setAuth(int auth) {
  		this.auth = auth;
  	}
  
  	@Override
  	public String toString() {
  		return "MemberDto [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", auth=" + auth + "]";
  	}
  }
  ```

  

- mul.com.a.service

  - MemberService.java

  ```java
  package mul.com.a.service;
  
  import java.util.List;
  
  import mul.com.a.dto.MemberDto;
  
  public interface MemberService {
  
  	List<MemberDto> allMember();
  }
  ```

  

- mul.com.a.service.impl

  - MemberServiceImpl

  ```java
  package mul.com.a.service.impl;
  
  import java.util.List;
  
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Service;
  
  import mul.com.a.dao.MemberDao;
  import mul.com.a.dto.MemberDto;
  import mul.com.a.service.MemberService;
  
  @Service
  public class MemberServiceImpl implements MemberService{
  
  	@Autowired
  	MemberDao dao;
  
  	@Override
  	public List<MemberDto> allMember() {		
  		return dao.allMember();
  	}	
  }
  ```



- properties

  - jdbc.properties

  ```
  # DB setting(oracle, mysql)
  
  jdbc.driverClassName=oracle.jdbc.driver.OracleDriver
  jdbc.url=jdbc:oracle:thin:@localhost:1521:xe
  jdbc.username=HR
  jdbc.password=HR
  jdbc.initialSize=5
  jdbc.maxActive=20
  ```

  

- sqls

  - log4.xml

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <!DOCTYPE log4j:configuration PUBLIC "-//APACHE//DTD LOG4J 1.2//EN" "log4j.dtd">
  <log4j:configuration xmlns:log4j="http://jakarta.apache.org/log4j/">
  
  	<!-- Appenders -->
  	<appender name="console" class="org.apache.log4j.ConsoleAppender">
  		<param name="Target" value="System.out" />
  		<layout class="org.apache.log4j.PatternLayout">
  			<param name="ConversionPattern" value="%-5p: %c - %m%n" />
  		</layout>
  	</appender>
  	
  	<!-- Application Loggers -->
  	<logger name="mul.com.a">
  		<level value="info" />
  	</logger>
  	
  	<!-- 3rdparty Loggers -->
  	<logger name="org.springframework.core">
  		<level value="info" />
  	</logger>
  	
  	<logger name="org.springframework.beans">
  		<level value="info" />
  	</logger>
  	
  	<logger name="org.springframework.context">
  		<level value="info" />
  	</logger>
  
  	<logger name="org.springframework.web">
  		<level value="info" />
  	</logger>
  
  	<!-- Root Logger -->
  	<root>
  		<priority value="warn" />
  		<appender-ref ref="console" />
  	</root>
  	
  </log4j:configuration>
  ```

  





# sampleSprAjax

**AJAX(Asynchronous Javascript And XML)**

자바스크립트를 사용하여 웹 서버와 클라이언트 간 비동기적으로 XML 데이터를 교환하고 조작하기 위한 웹 기술, XMLHttpRequest 객체를 이용해 전체 페이지를 새로 로드하지 않고 필요한 부분만 로드한다.



- pom.xml

```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>sampleSprAjax</groupId>
  <artifactId>sampleSprAjax</artifactId>
  <version>0.0.1-SNAPSHOT</version>
  <packaging>war</packaging>
  <build>
    <plugins>
      <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.8.1</version>
        <configuration>
          <release>16</release>
        </configuration>
      </plugin>
      <plugin>
        <artifactId>maven-war-plugin</artifactId>
        <version>3.2.3</version>
      </plugin>
    </plugins>
  </build>
  
  <dependencies>
  
 	 <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.6</version>
	</dependency>
	
	<dependency>
   		 <groupId>log4j</groupId>
    	<artifactId>log4j</artifactId>
    	<version>1.2.17</version>
    </dependency>
    
 	<dependency>
   		 <groupId>org.slf4j</groupId>
  	  	 <artifactId>slf4j-simple</artifactId>
   		 <version>1.7.30</version>
	</dependency>   
	
	<!-- Java용 json 라이브러리(XML/YAM/CSV) data-processing 툴 -->
  	<dependency>
	    <groupId>com.fasterxml.jackson.core</groupId>
	    <artifactId>jackson-core</artifactId>
	    <version>2.12.1</version>
	</dependency>
	
	<dependency>
	    <groupId>com.fasterxml.jackson.core</groupId>
	    <artifactId>jackson-databind</artifactId>
	    <version>2.12.1</version>
	</dependency>
  </dependencies>
</project>
```



- WEB-INF / spring

  - servlet-context.xml

  ```xml
  <?xml version="1.0" encoding="UTF-8"?>
  <beans xmlns="http://www.springframework.org/schema/beans"
  	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  	xmlns:context="http://www.springframework.org/schema/context"
  	xmlns:mvc="http://www.springframework.org/schema/mvc"
  	xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.3.xsd
  		http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
  		http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.3.xsd">
  
  	<!-- spring MVC annotaion(주석문, 지시어)을 사용하기 위한 설정 -->
  	<context:annotation-config />
  	
  	<!-- 사용자의 view의 위치와 확장명을 설정 -->
  	<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
  		<property name="prefix" value="/WEB-INF/views/"></property>	<!-- views(jsp, html)의 경로 -->
  		<property name="suffix" value=".jsp"></property>	<!-- 확장자명은 jsp -->
  	</bean>
  	
  	<!-- 공통 패키지 설정-->
  	<context:component-scan base-package="mul.com.a" />
  	
  	<!-- Ajax 주석문을 사용허가 -->
  	<mvc:annotation-driven/>
  	
  	<!-- spring에서 처리할 수 없는 요청 tomcat에 위임 -->
  	<mvc:default-servlet-handler/>
  	
  </beans>
  ```



- WEB-INF / views

  - hello.jsp

  ```jsp
  <%@ page language="java" contentType="text/html; charset=UTF-8"
      pageEncoding="UTF-8"%>
  <!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>hello.jsp</title>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  </head>
  <body>
  
  <h2>hello jsp</h2>
  
  아이디:<input type="text" id="id"> 
  <br><br>
  <button type="button" onclick="idcheck()">아이디 첵크</button>
  
  <script type="text/javascript">
  function idcheck() {
  	
  	$.ajax({
  		url:"./idcheck.do",
  		type:"post",
  		data:{ id:$("#id").val() },
  		success:function( resp ){
  		//	alert('success');
  			alert(resp);
  		},
  		error:function(){
  			alert('error');
  		}
  	});
  }
  
  </script>
  
  <br><br>
  
  아이디:<input type="text" id="id" value="abc"><br>
  패스워드:<input type="text" id="pwd" value="123"><br>
  이름:<input type="text" id="name" value="홍길동"><br>
  이메일:<input type="text" id="email" value="abc@naver.com">
  <br><br>
  <button type="button" id="account">회원가입</button>
  
  <script type="text/javascript">
  $("#account").click(function() {
  //	alert('click');
  	
  	let member = { 
  			id:$("#myid").val(),
  			pwd:$("#pwd").val(),
  			name:$("#name").val(),
  			email:$("#email").val()
  	};
  	
  	
  	$.ajax({
  		url:"account.do",
  		type:"post",
  		data:member,
  		dataType:'json',
  		success:function( datas ){
  		//	alert('success');
  		//	alert(datas);
  			alert( JSON.stringify(datas));	// Object 형태는 문자열로 만든다
  		},
  		error:function(){
  			alert('error');
  		}
  	});
  });
  
  
  </script>
  
  <br><br>
  
  <button type="button" onclick="func()">다수의 전송받기</button>
  
  <script type="text/javascript">
  function func() {
  	
  	$.ajax({
  		url:"read.do",
  		type:"get",
  		success:function( map ){
  		//	alert('success');
  		//	alert(map)
  			alert(map.name);	// JSON
  			alert(map.list);
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

  

- src/main/java/mul.com.a

  - HelloController.java

  ```java
  package mul.com.a;
  
  import java.util.ArrayList;
  import java.util.Date;
  import java.util.HashMap;
  import java.util.List;
  import java.util.Map;
  
  import org.slf4j.Logger;
  import org.slf4j.LoggerFactory;
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  import org.springframework.web.bind.annotation.ResponseBody;
  
  @Controller
  public class HelloController {
  
  	private static Logger logger = LoggerFactory.getLogger(HelloController.class);
  		
  	@RequestMapping(value = "hello.do", method = RequestMethod.GET)
  	// 전달 받을 값이 같아야된다.
  	public String hello(Model model) {	// hello.jsp로 부터 전달 받는 값, spring 자동으로 바꿔줌 parsing x
  		logger.info("HelloController hello() " + new Date());
  		
  		return "hello";		// <- hello.jsp로 이동
  	}
  	// doget, dopost 상관없이 가져온다
  	@ResponseBody // <- Ajax 설정
  	@RequestMapping(value = "idcheck.do", method = { RequestMethod.GET, RequestMethod.POST },
  					produces = "application/String; charset=utf-8")
  	public String idcheck(String id) { // 리턴 문자열
  		logger.info("HelloController idcheck() " + new Date());
  		System.out.println("id:" + id);
  		
  		return "OK";
  	}
  	
  	@ResponseBody // <- Ajax 설정
  	@RequestMapping(value = "account.do", method = { RequestMethod.GET, RequestMethod.POST })
  	public List<MemberDto> account(MemberDto mem){
  		logger.info("HelloController account() " + new Date());
  		System.out.println(mem.toString());
  		
  		List<MemberDto> list = new ArrayList<MemberDto>();
  		list.add(new MemberDto("aaa", "111", "AAA", "Aaa", 0));
  		list.add(new MemberDto("bbb", "222", "BBB", "Bbb", 0));
  		list.add(new MemberDto("ccc", "333", "CCC", "Ccc", 0));
  		// 자동적으로 JSON으로 넘어간다
  		return list;
  	}
  	
  	@ResponseBody // <- Ajax 설정
  	@RequestMapping(value = "read.do", method = { RequestMethod.GET, RequestMethod.POST })
  	public Map<String, Object> read(){
  		logger.info("HelloController read() " + new Date());
  		
  		// 포장
  		String name = "박정현";
  		
  		List<MemberDto> list = new ArrayList<MemberDto>();
  		list.add(new MemberDto("abc", "123", "성춘향", "abc@naver.com", 0));
  		list.add(new MemberDto("bcd", "234", "정수동", "bcd@naver.com", 0));
  		
  		Map<String, Object> map = new HashMap<String, Object>();
  		map.put("name", name);
  		map.put("list", list);
  		
  		return map;
  	}
  }	
  ```

  

  

- src/main/java/mul.com.a

  - MemberDto.java

  ```java
  package mul.com.a;
  
  import java.io.Serializable;
  
  public class MemberDto implements Serializable{	// 직렬화 (순서대로 정렬)
  
  	private String id;
  	private String pwd;
  	private String name;
  	private String email;
  	private int auth;		// 사용자:3 관리자:1
  	
  	public MemberDto() {
  	}
  
  	public MemberDto(String id, String pwd, String name, String email, int auth) {
  		super();
  		this.id = id;
  		this.pwd = pwd;
  		this.name = name;
  		this.email = email;
  		this.auth = auth;
  	}
  
  	public String getId() {
  		return id;
  	}
  
  	public void setId(String id) {
  		this.id = id;
  	}
  
  	public String getPwd() {
  		return pwd;
  	}
  
  	public void setPwd(String pwd) {
  		this.pwd = pwd;
  	}
  
  	public String getName() {
  		return name;
  	}
  
  	public void setName(String name) {
  		this.name = name;
  	}
  
  	public String getEmail() {
  		return email;
  	}
  
  	public void setEmail(String email) {
  		this.email = email;
  	}
  
  	public int getAuth() {
  		return auth;
  	}
  
  	public void setAuth(int auth) {
  		this.auth = auth;
  	}
  
  	@Override
  	public String toString() {
  		return "MemberDto [id=" + id + ", pwd=" + pwd + ", name=" + name + ", email=" + email + ", auth=" + auth + "]";
  	}	
  }
  ```

  

- src/main/java/mul.com.a

  - log4j.xml 