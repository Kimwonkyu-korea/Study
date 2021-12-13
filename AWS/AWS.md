#### AWS

1. jar

- 프로젝트 우클릭 - Run as - maven build
- 해당 폴더 target에 jar 파일 생성
- cmd - 해당 경로 - [java -jar sprBootTest.jar]



![image-20211123102755642](C:/Users/User/AppData/Roaming/Typora/typora-user-images/image-20211123102755642.png)





![image-20211123103106373](C:/Users/User/AppData/Roaming/Typora/typora-user-images/image-20211123103106373.png)





![image-20211123103556019](C:/Users/User/AppData/Roaming/Typora/typora-user-images/image-20211123103556019.png)





https://putty.softonic.kr/ 다운로드



putty gen 실행

![image-20211123104127410](C:/Users/User/AppData/Roaming/Typora/typora-user-images/image-20211123104127410.png)





![image-20211123104213418](C:/Users/User/AppData/Roaming/Typora/typora-user-images/image-20211123104213418.png)



mykeypair.pem 넣어주기 -> save prive~

- 변환해주기



![image-20211123104342700](C:/Users/User/AppData/Roaming/Typora/typora-user-images/image-20211123104342700.png)





putty.exe 실행

- 퍼블릭주소 넣기 둘다 가능

- Connection / SSH / Auth



![image-20211123104715242](C:/Users/User/AppData/Roaming/Typora/typora-user-images/image-20211123104715242.png)



![image-20211123104807270](C:/Users/User/AppData/Roaming/Typora/typora-user-images/image-20211123104807270.png)



![image-20211123104834607](C:/Users/User/AppData/Roaming/Typora/typora-user-images/image-20211123104834607.png)



-- 우 클릭 연결

![image-20211123105124230](C:/Users/User/AppData/Roaming/Typora/typora-user-images/image-20211123105124230.png)



![image-20211123105155275](C:/Users/User/AppData/Roaming/Typora/typora-user-images/image-20211123105155275.png)





https://filezilla-project.org/download.php?type=client



다운로드 - 실행



편집 - 설정 - STFP 

- pem 설정
- ![image-20211123113156532](AWS.assets/image-20211123113156532.png)



파일 - 사이트 관리자 - 호스트 : 퍼블릭 주소 붙혀넣기



![image-20211123113046387](AWS.assets/image-20211123113046387.png)







![image-20211123113135015](AWS.assets/image-20211123113135015.png)



putty 확인 ls

![image-20211123113401012](AWS.assets/image-20211123113401012.png)



sudo apt-get update



sudo apt install openjdk-8-jdk

- Y



java -jar 파일명.jar



홈페이지 - 보안 - 링크

![image-20211123114444067](AWS.assets/image-20211123114444067.png)



인바운드 규칙 편집

- 포트번호를 열어줌 

![](AWS.assets/image-20211123114721487.png)

mysql 다운로드

sudo apt install mysql-server 

- Y

my sql 접속

- sudo mysql -u root -p
- password 넘김

![image-20211123131401479](AWS.assets/image-20211123131401479.png)



- use mysql;

- CREATE USER '{생성할 사용자 이름}'@'%' IDENTIFIED BY '{비밀번호}';

- GRANT ALL PRIVILEGES ON *.* TO '{사용자 이름}'@'%';
- FLUSH PRIVILEGES;

![image-20211123131857018](AWS.assets/image-20211123131857018.png)

mysql 종료 : exit



mysql 폴더 위치

- cd /etc/mysql 

  cd  mysql.conf.d

sudo vi mysqld.cnf;



![image-20211123132446407](AWS.assets/image-20211123132446407.png)

bind-address =  변경



외부 접속 허용

- insert 누르고 0.0.0.0 변경

- bind-address =  0.0.0.0

esc 키 누르고 빠져나오기

![image-20211123132615101](AWS.assets/image-20211123132615101.png)



나가는 방법

- :q, :wq

sudo service mysql restart 

cd ~ 

오라클 사용하려면 인바운드 규칙

- mysql/aurora  - 3306 - Ipv4



오라클 Developer 

- 재접속
- ![image-20211123133733343](AWS.assets/image-20211123133733343.png)







![image-20211123140157327](AWS.assets/image-20211123140157327.png)





![image-20211123140251686](AWS.assets/image-20211123140251686.png)+

sql 에서 만들어주기

 ```
 select now();
 
 show databases;
 
 create database test;
 
 use test;
 
 CREATE TABLE MEMBER(
     ID VARCHAR(50) PRIMARY KEY,
     PWD VARCHAR(50) NOT NULL,
     NAME VARCHAR(50) NOT NULL,
     EMAIL VARCHAR(50) UNIQUE,
     AUTH INTEGER NOT NULL
 );
 ```



Driver -test로 바꿔주기



http://ec2-13-124-245-145.ap-northeast-2.compute.amazonaws.com:3000/dbtest 강사님꺼 참고



jar 파일 파일질라에 넣기

putty에서 ls

java - jar  파일명.jar



```
select * from MEMBER;

INSERT INTO MEMBER(ID, PWD, NAME, EMAIL, AUTH)
VALUES('abs', '123', 'abc', 'abc', 3);
```

