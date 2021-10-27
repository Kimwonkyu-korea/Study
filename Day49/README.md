# Spring Boot 시작

**스프링 다운로드**

- spring.io/tools 접속 -> 다운로드

- 드라이브에 새로운 폴더 생성 후 스프링 실행한다.



**설정**

- Window / 맨 밑 / Seplling

- Workspace 

- General / Appearance / Colors and Fonts 

  Text Font 설정

- 부트는 서버 설정이 필요없다.

- Web / CSS, HTML  - > UTF-8



- new  / New Spring Starter Project



![image-20211027104650231](C:/Users/User/AppData/Roaming/Typora/typora-user-images/image-20211027104650231.png)



![image-20211027110812586](C:/Users/User/AppData/Roaming/Typora/typora-user-images/image-20211027110812586.png)



pom.xml 설정

- https://mvnrepository.com/search?q=spring+boot+web

- Spring Boot Starter Web



서버 설정

- https://mvnrepository.com/search?q=spring+boot+tomcat

- Spring Boot Starter Tomcat



설정 부분

- src/main/resources / applic~~
- port 설정

```properties
# port
server.port=3000
```



- DB를 통해 데이터 불러오기

```properties
<!-- JDBC -->
		<dependency>
		    <groupId>org.springframework.boot</groupId>
		    <artifactId>spring-boot-starter-jdbc</artifactId>		    
		</dependency>
		
		<dependency>
		    <groupId>org.mybatis.spring.boot</groupId>
		    <artifactId>mybatis-spring-boot-starter</artifactId>
		    <version>1.3.2</version>
		</dependency>
<!-- My batis -- >
		<dependency>
           <groupId>org.mybatis</groupId>
           <artifactId>mybatis-spring</artifactId>
           <version>1.3.2</version>
        </dependency>  
           
        <dependency>
           <groupId>org.mybatis</groupId>
           <artifactId>mybatis</artifactId>
           <version>3.5.4</version>
        </dependency>

```



- Json 사용

```properties
<!-- 자바용 json 라이브러리(XML/YAML/CSV) data-processing 툴 --> 
	      <dependency>
	          <groupId>com.fasterxml.jackson.core</groupId>
	          <artifactId>jackson-core</artifactId>
	          <version>2.10.1</version>
	      </dependency>
	      <dependency>
	          <groupId>com.fasterxml.jackson.core</groupId>
	          <artifactId>jackson-databind</artifactId>
	          <version>2.10.1</version>
	      </dependency>

```



- Oracle 사용

```properties
		<dependency>
	          <groupId>com.oracle.database.jdbc</groupId>
	          <artifactId>ojdbc6</artifactId>
	          <version>11.2.0.4</version>
	    </dependency>
```



- DB(oracle) 설정

appli~.properties

```properties
# port
server.port=3000

# DB(oracle)
spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:xe
spring.datasource.username=HR
spring.datasource.password=HR

```



- 클래스 DatabaceConfig.java 생성

```java
package mul.com.a;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
public class DatabaceConfig {
	
	// SqlSessionFactory 셋팅
	@Bean	// 객체를 생성해라
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		System.out.println("DatabaceConfig sqlSessionFactory");
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		
		// core.io.Resource
		// sql 어디든 읽어라
		Resource arrResource[] = new PathMatchingResourcePatternResolver().getResources("classpath:sqls/*.xml");
		sqlSessionFactoryBean.setMapperLocations(arrResource);
		sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
		
		return (SqlSessionFactory)sqlSessionFactoryBean.getObject();
	}
	
	// mybatis
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
```



**src/main/java**

- sqls 폴더 생성

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
```



**MVC 설정**

- MemberDto.java 설정



- MemberController.java

```java
package mul.com.a.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController	// restful		@Controller + @ResponseBody
public class MemberController {

}
```



- MemberDao.java

```java
package mul.com.a.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MemberDao {

}
```



- MemberService.java

```java
package mul.com.a.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {

}
```



- JSON Viewer

https://chrome.google.com/webstore/detail/json-viewer/gbmdgpbipfallnflgajpaliibnhdgobh/related?utm_source=chrome-ntp-icon



서버 값 받아 오기

- mul.com.a / WebConfig.java

![image-20211027143950934](C:/Users/User/Desktop/Markdown/%25EA%25B7%25B8%25EB%259E%25A8%25EC%2598%25A4%25EB%25A9%25B4%2520%25EC%2584%25A4%25EC%25A0%2595%25ED%2595%25A0%2520%25EA%25B2%2583.assets/image-20211027143950934.png)





```java
package mul.com.a;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer{

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addCorsMappings(registry);
		
		registry.addMapping("/**").allowedOrigins("http://localhost:8090");
	}
}
```





mysql 다운로드