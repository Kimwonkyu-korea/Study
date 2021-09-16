# SEQUENCE

## 의미

- 유일한 값(중복된 값이 아님)을 생성해 주는 오브젝트
- 회원번호, 게시판 글번호에서 사용된다.
- 초기화가 안된다.



**SEQUENCE 생성**

```sql
CREATE SEQUENCE 테이블명
INCREMENT BY 1      -- 1씩 증가
START WITH 10       -- 시작 숫자
MAXVALUE 100
MINVALUE 1;
```



**CURRVAL**

- 현재의 SEQ

```sql
SELECT 테이블명.CURRVAL
FROM DUAL;
```



**NEXTVAL**

- 진행 값
- 초기에 한번 실행해줘야된다.

```sql
SELECT 테이블명.NEXTVAL
FROM DUAL;
```



**수정**

```sql
ALTER SEQUENCE 테이블명
INCREMENT BY 3;
```



**삭제**

```sql
DROP SEQUENCE 테이블명;
```









