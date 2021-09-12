# Oracle_SELECT

## 형식

```sql
SELECT (값, 컬럼(항목)명, 함수, SUB QUERY)
        FROM (테이블명, SUB QUERY);
```

- "문자열" 

-  AS는 생략이 가능하나, 빈 칸이있으면 " " 를 사용한다.
- || 를 사용하여 값과 값을 이어줄 수 있다.

```sql
SELECT first_name || '의 월급은' || SALARY || '입니다' AS "이름 + 월급"
FROM employees;
```



- **DISTINCT** 
  - 중복행을 삭제

```sql
SELECT DISTINCT department_id 
FROM employees;
```



-  **WHERE**

  -  비교연산자( > < <= >= = != <> ) 

  ```sql
  SELECT first_name, salary
  FROM EMPLOYEES
  WHERE SALARY >= 9000;
  ```

  

  - NULL,  **IS** NULL, **IS NOT** NULL

  ```sql
  SELECT first_name, manager_id
  FROM employees
  WHERE manager_id IS NOT NULL;
  ```

  

  - **AND**(ALL), **OR**(ANY), (우선비교)

  ```sql
  SELECT FIRST_NAME
  FROM employees
  -- ALL
  WHERE FIRST_NAME = ALL('Julia', 'John');
  -- FIRST_NAME = 'Julia' AND FIRST_NAME = 'John'
  
  -- ANY
  WHERE FIRST_NAME = ANY('Julia', 'John');
  -- FIRST_NAME = 'Julia' OR FIRST_NAME = 'John'
  ```

  

  - IN, **NOT** IN 

  ```sql
  SELECT FIRST_NAME, salary 
  FROM employees
  -- IN
  WHERE salary IN(8000, 3200, 6000);
  
  -- NOT IN
  WHERE salary NOT IN(8000, 3200, 6000)
  ```

  

  - BETWEEN, **NOT** BETWEEN

  ```sql
  SELECT FIRST_NAME, salary 
  FROM employees
  --WHERE salary >= 3200 AND salary <= 9000;
  
  -- BETWEEN
  WHERE salary BETWEEN 3200 AND 9000;
  
  -- NOT BETWEEN
  WHERE salary NOT BETWEEN 3200 AND 9000;
  
  ```

  

  - **Like**

  ```sql
  SELECT first_name
  FROM employees
  
  -- _ 한글자
  WHERE first_name LIKE 'G_ra_d'; 
  
  -- % 중간에 글자가 무엇이든 허용
  WHERE first_name LIKE 'K%y';  -- % 중간에 글자가 무엇이든 허용
  
  -- z 앞뒤로 무엇이든 허용
  WHERE  first_name LIKE '%z%';
  ```

  

  

## ORDER BY == Sorting(정렬)

- **ORDER BY** COLUMN (**ASC**(오름), **DESC**(내림))

```sql
SELECT FIRST_NAME,HIRE_DATE
FROM employees
--  ASC(오름)
ORDER BY HIRE_DATE ASC;
--  DESC(내림)
ORDER BY salary DESC;
```



## GROUP BY, HAVING

- **GROUP BY**: 그룹으로 묶는 기능

- **HAVING** : 묶었을 때 조건

  ```sql
  SELECT JOB_ID, SUM(salary)  -- 4
  FROM employees
  WHERE salary >= 5000        -- 1
  GROUP BY JOB_ID             -- 2
  HAVING SUM(salary) > 20000  -- 3
  ORDER BY SUM(salary) DESC;  -- 5
  ```

  

- 통계 - GROUP FUNCTION 
  - **COUNT** : 값의 갯수
  - **SUM** : 값을 더한 값
  - **AVG** : 평균 값
  - **MAX** : 최대 값
  - **MIN** : 최솟 값

```sql
SELECT COUNT(salary), COUNT(*), SUM(salary), AVG(salary), MAX(salary), MIN(salary)
FROM employees
WHERE job_id = 'IT_PROG'
```









