# 데이터베이스(Oracle)

- 데이터들을 모아서 일정한 형태로 저장해 놓은 것
- 한 조직이나 기업에 여러 응용 시스템들이 공통으로 사용하기 위해 저장한 운영데이터의 집합



## Oracle

- DBMS(Datebse Mangement System), 데이터 베이스 관리 프로그램

- RDBMS 최초 상용화하며 시장 점유율이 높다



## 테이블(Table)

| 이름   | 나이 | 주소   | 핸드폰 |
| :----- | ---- | ------ | ------ |
| 홍길동 | 24   | 서울시 | -      |
|        |      |        |        |
|        |      |        |        |

- **열(Column)** , **행(Row)**로 구성된 2차원 구조를 가진 데이터 저장 장소이다.



## **SQL : Structured Query Languae**

- 데이터베이스에 저장된 데이터를 조회, 입력, 수정, 삭제하는 조작이나, 테이블을 비롯한 다양한 객체(시퀀스, 인덱스, 등)를 생성 및 제어하는 역할

### 자료형

```sql
    -Java-        -DB-                      -Mysql-
    String      VARCHAR2, CHAR, LONG        VARCHAR
    int         INTEGER, NUMBER
    double      NUMBER
    Date        DATE
```



### **SQL의 종류**

**1. DDL ( Data Definition Language ) : 데이터 정의어**

데이터베이스 관리자나 응용 프로그래머가 데이터베이스의 논리적 구조를 정의하기 위한 언어로서 데이터 사전(Data Dictionary)에 저장 된다.



● CREAT : 테이블 생성 

```sql
CREATE TABLE 테이블명(
    컬럼명1 자료형,
    컬럼명2 자료형,
);
```

● ALTER : 테이블 구조 변경 

●  DROP : 테이블 삭제 

● RENAME : 테이블 이름 변경 

● TRUNCATE : 테이블의 모든 내용 제거 



**2. DML ( Data Manipulation Language ) : 데이터 조작어**

데이터베이스에 저장된 데이터를 조직하기 위해 사용하는 언어로서, 데이터 검색, 추가, 삭제, 갱신 작업을 수행한다.



● INSERT : 데이터 삽입

```sql
INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('가', '나', '다');  -- 한글 : 3 BYTE

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('ABC', 'ABC', 'ABC');  -- 영문 : 1 BYTE
```

● DELETE : 데이터 삭제 

● UPDATE : 데이터 수정 

● SELECT : 데이터 삽입: 테이블에 저장 된 데이터를 조회**

```sql
SELECT 검색대상 FROM 테이블명;
```



**3. TCL ( Transaction Control Language ) : 데이터 조작어에 의해 변경 된 내용 저장**

● COMMIT : 변경 된 내용을 영구적으로 저장 

● ROLLBACK : 변경되기 전 상태로 돌림

● SAVEPOINT : 특정 위치까지 영구 저장 혹은 이전 상태로 돌릴 수 있도록 트랜잭션 중에 임시 저장점을 만듦



**4. DCL( Data Control Language ) : 데이터 제어어**

데이터에 대한 접근 권한 부여 등의 데이터베이스 시스템의 트랜잭션을 관리하기 위한 목적으로 사용하는 언어



● GRANT : 사용자에게 특정 권한 부여 

● REVOKE : 사용자로부터 특정 권한 제거 
