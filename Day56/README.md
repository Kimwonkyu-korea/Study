### AWS 2일차

MYSQL 추가

```
CREATE TABLE BBS(
	SEQ INT PRIMARY KEY,
	ID VARCHAR(50) NOT NULL,		-- 글의 작성자
	
	REF INT NOT NULL,			-- 답변을 설정 		
	STEP INT NOT NULL,
	DEPTH INT NOT NULL,
	
	TITLE VARCHAR(200) NOT NULL,
	CONTENT VARCHAR(4000) NOT NULL,
	WDATE DATE NOT NULL,
	
	DEL INT NOT NULL,			-- 삭제 
	READCOUNT INT NOT NULL
);

-- 시퀀스 테이블 생성
CREATE TABLE sequences(
    name varchar(32), 
    currval BIGINT UNSIGNED 
)ENGINE=InnoDB;

-- 시퀀스를 생성하는 프로시저 생성
CREATE PROCEDURE create_sequence(IN the_name text)
MODIFIES SQL DATA
DETERMINISTIC
BEGIN
    DELETE FROM sequences WHERE name=the_name;
    INSERT INTO sequences VALUES (the_name, 0);
END

-- nextval function 생성
CREATE FUNCTION NEXTVAL(the_name varchar(32)) 
RETURNS BIGINT UNSIGNED
MODIFIES SQL DATA
DETERMINISTIC
BEGIN
    DECLARE ret BIGINT UNSIGNED;
    UPDATE sequences SET currval=currval+1 WHERE name=the_name;
    SELECT currval INTO ret FROM sequences WHERE name=the_name limit 1;
RETURN ret;
END

-- 시퀀스명 입력 및 0값 넣기 ('Student_seq' 대신 원하는 시퀀스 명을 넣을 것)
INSERT INTO sequences 
VALUES('SEQ_BBS', 0);

-- nextval 값 가져오기(확인용)
select NEXTVAL('SEQ_BBS') as Student_seq 
from dual;

ALTER TABLE BBS
ADD CONSTRAINT FK_BBS_ID FOREIGN KEY(ID)
REFERENCES MEMBER(ID);
```



이클립스 - db - 설정 - driver proper~ url 복사

- 백엔드 스프링 app~.proper~ url + 아이디 비번 수정

![image-20211124091809054](C:\Users\원규\AppData\Roaming\Typora\typora-user-images\image-20211124091809054.png)





- 스프링 
- 프로젝트 우클릭  - Run as

![image-20211124092713139](C:\Users\원규\AppData\Roaming\Typora\typora-user-images\image-20211124092713139.png)



파일질라 실행 - 파일 - 관리자 - url 포트 22



jar파일 파일질라에 넣기 



파일질라 서버가 한개 더 필요하다.

http://tomcat.apache.org/ 톰켓 접속 -> https://tomcat.apache.org/download-90.cgi

9.0 버전 zip 파일

톰켓을 파일질라에 옴김

![image-20211124101647996](C:\Users\원규\AppData\Roaming\Typora\typora-user-images\image-20211124101647996.png)



putty 에서 확인 -> ls

![image-20211124101702749](C:\Users\원규\AppData\Roaming\Typora\typora-user-images\image-20211124101702749.png)

cd apache-tomcat-9.0.55

cd bin

./startyup.sh

![image-20211124101927587](C:\Users\원규\AppData\Roaming\Typora\typora-user-images\image-20211124101927587.png)

서버 끄고 싶을때 :  ./shutdown.sh



server.xml 수정

- apach - conf - server.xml 접근

- cd conf
- vi server.xml
- ![image-20211124105943994](C:\Users\원규\AppData\Roaming\Typora\typora-user-images\image-20211124105943994.png)Connector 포트번호 8090 수정  :wq!



규칙 추가 8090



톰켓 tar.gz 

putty에서 wget https://dlcdn.apache.org/tomcat/tomcat-9/v9.0.55/bin/apache-tomcat-9.0.55.tar.gz

![image-20211124104341290](C:\Users\원규\AppData\Roaming\Typora\typora-user-images\image-20211124104341290.png)



압축 풀기 

tar -zvxf apache-tomcat-9.0.55.tar.gz

![image-20211124104451024](C:\Users\원규\AppData\Roaming\Typora\typora-user-images\image-20211124104451024.png)



아파치 - 앱~ 삭제 후 war 넣기

- war 프론트 프로젝트 우클릭 export - > warfail 체크 다 하기

![image-20211124104940443](C:\Users\원규\AppData\Roaming\Typora\typora-user-images\image-20211124104940443.png)