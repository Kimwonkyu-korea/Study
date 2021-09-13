/*
    JOIN
    두 개 이상의 테이블의 데이터를 검색하는 방법이다.
    보통 두 개 이상의 행(ROW)들의 공통된 값(기본키, 외래키)를 사용해서 JOIN한다.
    
    기본키(Primary Key)
    - 테이블에서 중복이 되지 않는 키          -> PK
    
    외래키(Foreign Key)
    - 다른 테이블에서 PK, UK인 경우가 많다.   -> FK   
    
    JOIN 종류
    inner join = 교집합        *****
    full outer join = 합집합
    cross join
    outer join
        left join               ***
        right join              ***
    self join = 교집합         *****
    
*/

-- inner join
-- ansi SQL
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e INNER JOIN departments d
    ON e.department_id = d.department_id;

-- Oracle 
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;


SELECT e.employee_id, e.first_name, -- 테이블 명은 생략가능
e.job_id, j.job_id,                 -- 단, 동일할 경우 구분
job_title
FROM employees e, jobs j
WHERE e.job_id = j.job_id
    AND e.job_id = 'IT_PROG';

-- cross join : 전체를 다 JOIN 시킨다.
-- ansi
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e CROSS JOIN departments d;

-- Oracle
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d;

-- full outer join
-- ansi
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e FULL OUTER JOIN departments d
    ON e.department_id = d.department_id;

-- Oracle
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+)
UNION -- 집합을 합해라
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d
WHERE e.department_id(+) = d.department_id;



-- Outer Join
-- left
-- ansi
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name 
FROM employees e LEFT OUTER JOIN departments d
ON e.department_id = d.department_id;


-- Oracle : + 가 없는 곳으로 간다.
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+);


SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id(+)
    AND e.department_id IS NULL; -- 차집합


--  right
SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d
WHERE e.department_id(+) = d.department_id
    AND e.department_id IS NULL;


SELECT e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e FULL OUTER JOIN departments d
    ON e.department_id = d.department_id
WHERE e.department_id IS NULL
    OR d.department_id IS NULL;

-- 부서명, 업무명  Nancy
SELECT e.first_name,
    e.department_id, d.department_id,
    e.job_id, j.job_id,
    d.department_name, j.job_title
FROM employees e, departments d, jobs j
WHERE e.first_name = 'Nancy'
    AND e.department_id = d.department_id
        AND e.job_id = j.job_id;

-- self Join : 동일한 테이블을 Join한다.
SELECT a.employee_id, a.first_name, 
    a.manager_id, b.employee_id, 
    b.first_name
FROM employees a, employees b   -- a: 사원 , b: 상사
WHERE a.manager_id = b.employee_id;




