-- sub query
/*
    Query���� Query
    
    SELECT ���� ROW ���� COLUMN (����Ǵ� �����ʹ� �Ѱ�, �÷��� �Ѱ�)
    FROM   ���� ROW ���� COLUMN  
    WHERE  ���� ROW ���� COLUMN  
*/

-- SELECT
SELECT employee_id, first_name, 
    (SELECT first_name
     FROM employees
     WHERE employee_id = 100) 
FROM employees;

SELECT employee_id, 
    (SELECT SUM(salary) from employees),
    (SELECT trunc(AVG(salary)) from employees)
FROM employees;

-- FROM
SELECT first_name, salary
FROM (SELECT employee_id, first_name, salary
        FROM employees
        WHERE department_id = 100)
WHERE salary > 8000;

SELECT first_name, salary
FROM employees     
WHERE salary > 8000
    and department_id = 100;


-- �������� �޿��� �հ�, �ο���, �����, ����
/*
SELECT job_id, SUM(salary), COUNT(*), first_name 
FROM employees
GROUP BY job_id;
*/

SELECT e.employee_id, e.salary,
    e.job_id, j.job_id,
    j."�޿��� �հ�", j.�ο���
FROM employees e, ( SELECT job_id, SUM(salary) as "�޿��� �հ�", COUNT(*) as �ο��� 
                    FROM employees
                    GROUP BY job_id ) j
WHERE e.job_id = j.job_id;

-- WHERE
-- ��� �޿����� ���� �޴� ���
SELECT first_name, salary
FROM employees
WHERE salary > (SELECT AVG(salary) FROM employees);

-- department_id = 90�� ����� ����(job_id)���� ����
SELECT job_id, first_name, department_id 
FROM employees
WHERE job_id IN(    SELECT job_id 
                    FROM employees
                    WHERE department_id = 90 );

-- �μ����� ���� �޿��� ���� �޴� ����� ���� �޿��� �޴� ���
SELECT first_name, salary, department_id 
FROM employees    
WHERE salary IN (   SELECT MIN(salary)
                    FROM employees
                    GROUP BY department_id );

-- �μ����� ���� �޿��� ���� �޴� ����� �̸�, �޿�, �μ���ȣ
SELECT department_id, salary, first_name 
FROM employees
WHERE (department_id, salary) IN (  SELECT department_id, MAX(salary)
                                    FROM employees
                                    GROUP BY department_id )
ORDER BY department_id;











