# 테이블(Table)

- 열(column)과 행(row)으로 구성

### 테이블 스페이스(space)

- 테이블(object) 및 다른 object(view, seqence...) 저장하는 논리적 공간



### Object

- CREATE,  ALTER(생성),  DROP(삭제)

### Date

- INSERT, UPDATE, DELETE



#### 1. 테이블 생성

```sql
CREATE TABLE TB_TEST01(
    COL1 VARCHAR2(10 BYTE), -- BYTE 생략가능
    COL2 VARCHAR2(10),
    COL3 VARCHAR2(10)
);
```



#### 2. 테이블 복제

```sql
CREATE TABLE TB_TEST03(JNAME, JTITLE, SALMIN, SALMAX)
AS 
SELECT * FROM jobs;
```

#### 2.1 테이블을 복제 : 데이터를 미포함

```sql
CREATE TABLE TB_TEST04
AS
SELECT * 
FROM employees
WHERE 1 = 2;
```



#### 3. 테이블명 수정

```sql
ALTER TABLE TB_TEST04
RENAME
TO TB_TEST99;
```



### COLUMN

#### 1. 컬럼 추가

```sql
ALTER TABLE TB_TEST99
ADD
NEWCOL VARCHAR2(20);
```



#### 2. 컬럼 수정

```sql
ALTER TABLE TB_TEST99
MODIFY
NEWCOL DATE;
```



#### 3. 컬럼 삭제

```sql
ALTER TABLE TB_TEST99
DROP
COLUMN NEWCOL;
```



#### 4. 컬럼명 수정

```sql
ALTER TABLE TB_TEST99
RENAME 
COLUMN EMPLOYEE_ID TO EMPNO;
```



### DATA

#### 1. 데이터 추가 INSERT

```sql
INSERT INTO tb_test03(JNAME, JTITLE, SALMIN, SALMAX)
VALUES('SALS_AD', '영업부', 8000, 20000);

INSERT INTO tb_test03
VALUES('BALL_MO', '야구부', 8500, 25000);
```



#### 2. 데이터 삭제 DELETE

```sql
DELETE FROM tb_test03
WHERE JNAME = 'SAVE';

DELETE FROM tb_test03
WHERE SALMAX = 25000;
```



#### 3. 데이터 수정 UPDATE

```sql
UPDATE tb_test03
SET jtitle = '개발부', salmax = 25000, salmin = 9000
WHERE JNAME = 'SALES_AD';
```







