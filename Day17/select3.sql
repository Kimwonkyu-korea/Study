/*
    ORDER BY == Sorting(정렬)
    
    SELECT COLUMN VALUE SUBQUERY
    FROM TABLE SUBQUERY
    WHERE 
    
    ORDER BY COLUMN (ASC(오름), DESC(내림))
    
*/

SELECT FIRST_NAME,HIRE_DATE
FROM employees
ORDER BY HIRE_DATE ASC;
    
SELECT first_name, salary
FROM employees
ORDER BY salary DESC;

-- ALIAS
SELECT employee_id, first_name, SALARY * 12 AS ANNSAL
FROM employees
ORDER BY ANNSAL DESC;

SELECT first_name, NVL(commission_pct,0)
FROM employees
ORDER BY commission_pct ASC NULLS FIRST; -- LAST

SELECT DISTINCT JOB_ID
FROM employees
ORDER BY JOB_ID;

/*
    GROUP BY : 그룹으로 묶는 기능
    HAVING : 묶었을 때 조건
*/

SELECT DISTINCT JOB_ID
FROM employees;

SELECT JOB_ID
FROM employees
GROUP BY JOB_ID;

/*
     통계 - GROUP FUNCTION 
     COUNT 
     SUM 
     AVG
     MAX
     MIN
*/

SELECT COUNT(salary), COUNT(*), SUM(salary), AVG(salary), MAX(salary), MIN(salary)
FROM employees
WHERE job_id = 'IT_PROG';

SELECT JOB_ID, SUM(salary), MAX(salary)
FROM employees
GROUP BY job_id
ORDER BY COUNT(*) DESC;

SELECT department_id, SUM(salary)
FROM employees
GROUP BY department_id
HAVING SUM(salary) >= 50000;

SELECT JOB_ID, SUM(salary)  -- 4
FROM employees
WHERE salary >= 5000        -- 1
GROUP BY JOB_ID             -- 2
HAVING SUM(salary) > 20000  -- 3
ORDER BY SUM(salary) DESC;  -- 5


