-- 문제1) EMPLOYEES 테이블에서 20번 부서의 세부 사항을 포함하는 EMP_20 VIEW를 생성 하라
CREATE VIEW EMP_20
AS
SELECT * 
FROM employees
WHERE department_id = 20;

CREATE OR REPLACE VIEW EMP_20   -- 덮어쓰기
AS
SELECT * 
FROM employees
WHERE department_id = 20;

-- 문제2) EMPLOYEES 테이블에서 30번 부서만 
-- EMPLOYEE_ID 를 emp_no 로 LAST_NAME을 name으로 SALARY를 sal로 바꾸어 EMP_30 VIEW를 생성하라.
CREATE VIEW EMP_30
AS
SELECT employee_id AS emp_no, last_name name, salary sal 
FROM employees
WHERE department_id = 30;

CREATE OR REPLACE VIEW EMP_30(emp_no, name, sal)
AS
SELECT employee_id , last_name , salary 
FROM employees
WHERE department_id = 30;

-- 문제3) 부서별로 부서명,최소 급여,최대 급여,부서의 평균 급여를 포함하는 DEPT_SUM VIEW을 생성하여라.
CREATE  OR REPLACE VIEW DEPT_SUM(dname, minsal, maxsal, avgsal)
AS
SELECT  d.department_name, MIN(e.salary), MAX(e.salary), AVG(e.salary)
FROM departments d, employees e
WHERE d.department_id = e.employee_id
GROUP BY d.department_name;


-- 문제4) 앞에서 생성한 EMP_20,EMP_30 VIEW을 삭제하여라.
DROP VIEW EMP_20;
DROP VIEW EMP_30;


















