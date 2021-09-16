# View

### 의미

- 가상 테이블
- 실체가 없는 테이블
- 다른 테이블에 접근하기 위한 테이블



### 장점

- 한개의 View 테이블로 여러개의 테이블을 검색할 수 있다.
- 속도가 빠르다.
- 제한설정이 가능하다. (readonly)



#### 생성

```sql
CREATE VIEW 테이블명
AS
SELECT 컬럼명1, 컬럼명2, 컬럼명3
FROM 가져올 테이블명;
```



**ROLLBACK** 

- 되돌릴 때 쓰는 명령어

```sql
ROLLBACK;
```



**COMMIT** 

- 적용 시킬때 쓰는 명령어

```sql
COMMIT;
```



**READONLY**

- 데이터 조회만 가능하다.

```sql
CREATE VIEW 테이블명
AS
SELECT 컬럼명1, 컬럼명2, 컬럼명3
FROM 가져올 테이블명
WITH READ ONLY;     
```



**JOIN**

```sql
CREATE VIEW 테이블명
AS
SELECT a.컬럼명1, a.컬럼명2, b.컬럼명1,b.컬럼명2
FROM 테이블명 a, 테이블명 b
WHERE a.컬럼명1 = b.컬럼명1;
```





