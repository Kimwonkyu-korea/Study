/*
    JOIN
    �� �� �̻��� ���̺��� �����͸� �˻��ϴ� ����̴�.
    ���� �� �� �̻��� ��(ROW)���� ����� ��(�⺻Ű, �ܷ�Ű)�� ����ؼ� JOIN�Ѵ�.
    
    �⺻Ű(Primary Key)
    - ���̺��� �ߺ��� ���� �ʴ� Ű          -> PK
    
    �ܷ�Ű(Foreign Key)
    - �ٸ� ���̺��� PK, UK�� ��찡 ����.   -> FK   
    
    JOIN ����
    inner join = ������        *****
    full outer join = ������
    cross join
    outer join
        left join               ***
        right join              ***
    self join = ������         *****
    
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


SELECT e.employee_id, e.first_name, -- ���̺� ���� ��������
e.job_id, j.job_id,                 -- ��, ������ ��� ����
job_title
FROM employees e, jobs j
WHERE e.job_id = j.job_id
    AND e.job_id = 'IT_PROG';

-- cross join : ��ü�� �� JOIN ��Ų��.
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
UNION -- ������ ���ض�
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


-- Oracle : + �� ���� ������ ����.
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
    AND e.department_id IS NULL; -- ������


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

-- �μ���, ������  Nancy
SELECT e.first_name,
    e.department_id, d.department_id,
    e.job_id, j.job_id,
    d.department_name, j.job_title
FROM employees e, departments d, jobs j
WHERE e.first_name = 'Nancy'
    AND e.department_id = d.department_id
        AND e.job_id = j.job_id;

-- self Join : ������ ���̺��� Join�Ѵ�.
SELECT a.employee_id, a.first_name, 
    a.manager_id, b.employee_id, 
    b.first_name
FROM employees a, employees b   -- a: ��� , b: ���
WHERE a.manager_id = b.employee_id;




