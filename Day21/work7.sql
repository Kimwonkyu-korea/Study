-- ����1) EMPLOYEES ���̺��� 20�� �μ��� ���� ������ �����ϴ� EMP_20 VIEW�� ���� �϶�
CREATE VIEW EMP_20
AS
SELECT * 
FROM employees
WHERE department_id = 20;

CREATE OR REPLACE VIEW EMP_20   -- �����
AS
SELECT * 
FROM employees
WHERE department_id = 20;

-- ����2) EMPLOYEES ���̺��� 30�� �μ��� 
-- EMPLOYEE_ID �� emp_no �� LAST_NAME�� name���� SALARY�� sal�� �ٲپ� EMP_30 VIEW�� �����϶�.
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

-- ����3) �μ����� �μ���,�ּ� �޿�,�ִ� �޿�,�μ��� ��� �޿��� �����ϴ� DEPT_SUM VIEW�� �����Ͽ���.
CREATE  OR REPLACE VIEW DEPT_SUM(dname, minsal, maxsal, avgsal)
AS
SELECT  d.department_name, MIN(e.salary), MAX(e.salary), AVG(e.salary)
FROM departments d, employees e
WHERE d.department_id = e.employee_id
GROUP BY d.department_name;


-- ����4) �տ��� ������ EMP_20,EMP_30 VIEW�� �����Ͽ���.
DROP VIEW EMP_20;
DROP VIEW EMP_30;


















