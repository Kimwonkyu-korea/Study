# JOIN(조인)

## 의미

- **두 개 이상**의 테이블의 데이터를 검색하는 방법이다.
- 보통 두 개 이상의 행(ROW)들의 공통된 값(**기본키**, **외래키**)를 사용해서 JOIN한다.



**1. 기본키(Primary Key)**

    - 테이블에서 중복이 되지 않는 키       		 	-> 	PK



**2. 외래키(Foreign Key)**

- 다른 테이블에서 PK, UK인 경우가 많다.   	-> 	FK   



### JOIN 종류

- **INNER JOIN** = 교집합      

  - 테이블 명은 생략가능 단, 동일할 경우 구분

  

  -  Ansi SQL

  ```sql
  SELECT e.employee_id, e.first_name,
      e.department_id, d.department_id,
      d.department_name
  FROM employees e INNER JOIN departments d
      ON e.department_id = d.department_id;
  ```

  - Oracle 

  ```sql
  SELECT e.employee_id, e.first_name,
      e.department_id, d.department_id,
      d.department_name
  FROM employees e, departments d
  WHERE e.department_id = d.department_id;
  ```

  

- **CROSS JOIN** : 전체를 다 JOIN 시킨다.

  - ```sql
    -- 생략 --
    FROM employees e CROSS JOIN departments d;
    ```

- **FULL OUTER JOIN**

  - Ansi

  - ```sql
    -- 생략 --
    FROM employees e FULL OUTER JOIN departments d
        ON e.department_id = d.department_id;
    ```

  - Oracle

  ```sql
  집합 1
  UNION	-- 집합을 합해라
  집합 2 
  ```

- **OUTER JOIN**

  1. **LEFT**

     - Ansi

     ```sql
     -- 생략 --
     FROM employees e LEFT OUTER JOIN departments d
     ON e.department_id = d.department_id;
     ```

     - Oracle : + 가 없는 곳으로 간다.

     ```sql
     -- 생략 --
     FROM employees e, departments d
     WHERE e.department_id = d.department_id(+);
     -- AND e.department_id IS NULL; -- 차집합
     ```

  2. RIGHT

     - Ansi

     ```sql
     -- 생략 --
     FROM employees e RIGHT OUTER JOIN departments d
     ON e.department_id = d.department_id;
     ```

     - Oracle

     ```sql
     -- 생략 --
     FROM employees e, departments d
     WHERE e.department_id(+) = d.department_id;
     -- AND e.department_id IS NULL; -- 차집합
     ```

- **SELF JOIN** 

  - 동일한 테이블을 Join한다.

  ```sql
  SELECT a.employee_id, a.first_name, 
      a.manager_id, b.employee_id, 
      b.first_name
  FROM employees a, employees b   -- a: 사원 , b: 상사
  WHERE a.manager_id = b.employee_id;
  ```

  