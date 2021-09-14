-- ����1) EMPLOYEES ���̺��� Kochhar(last_name)�� �޿����� ���� ����� ������ �����ȣ,�̸�,������,�޿��� ����϶�.
SELECT employee_id, last_name, job_id, salary
FROM employees
WHERE salary >= (SELECT salary
               FROM employees
               WHERE last_name = 'Kochhar')
    AND last_name != 'Kochhar';

-- ����2) EMPLOYEES ���̺��� �޿��� ��պ��� ���� ����� �����ȣ,�̸�,������,�޿�,�μ���ȣ�� ����Ͽ���.  
SELECT employee_id, last_name, job_id, salary, department_id
FROM employees
WHERE salary < (SELECT AVG(salary)
                FROM employees);

-- ����3) EMPLOYEES ���̺��� 100�� �μ��� �ּ� �޿����� �ּ� �޿��� ���� �ٸ� ��� �μ��� ����϶�
SELECT department_id, MIN(salary)
FROM employees   
GROUP BY department_id
HAVING MIN(salary) < (SELECT MIN(salary)
                         FROM employees
                         WHERE department_id = 100);

-- ����4) �������� �ּ� �޿��� �޴� ����� ������ �����ȣ,�̸�,����,�μ���ȣ�� ����Ͽ���. 
-- �� �������� �����Ͽ���.
SELECT  employee_id, first_name, job_id, department_id 
FROM employees 
WHERE (job_id, salary) IN (SELECT job_id, MIN(salary)
                            FROM employees
                            GROUP BY job_id )
ORDER BY JOB_ID;

-- ����5) EMPLOYEES �� DEPARTMENTS ���̺��� ������ SA_MAN ����� ������ �̸�,����,�μ���,�ٹ����� ����϶�.
SELECT e.first_name, e.job_id, d.department_name, l.city
FROM employees e, departments d, locations l
WHERE e.department_id = d.department_id
    AND d.location_id = l.location_id
        AND e.job_id = 'SA_MAN';

SELECT e.first_name, e.job_id, d. department_id, d.location_id
FROM 
        (SELECT first_name, job_id, department_id
         FROM employees
         WHERE job_id ='SA_MAN') e, departments d
WHERE e.department_id = d.department_id;
         
-- ����6) EMPLOYEES ���̺��� ���� ���� ����� ���� MANAGER�� �����ȣ�� ����϶�.
SELECT manager_id 
FROM employees
GROUP BY manager_id
HAVING COUNT(manager_id) IN(SELECT MAX(COUNT(manager_id)) 
                        FROM employees
                        GROUP BY manager_id);


-- ����7) EMPLOYEES ���̺��� ���� ���� ����� ���� �ִ� �μ� ��ȣ�� �������  ����϶�.
SELECT department_id, COUNT(department_id)
FROM employees
GROUP BY department_id
HAVING COUNT(department_id) = (SELECT MAX(COUNT(department_id))
                                FROM employees
                                GROUP BY department_id);



-- ����8) EMPLOYEES ���̺��� �����ȣ�� 123�� ����� ������ ���� 
-- �����ȣ�� 192�� ����� �޿����� ���� ����� �����ȣ,�̸�,����,�޿��� ����϶�.
SELECT employee_id, first_name, job_id, salary
FROM employees
WHERE job_id = (SELECT job_id
                FROM employees
                WHERE employee_id = 123)
            AND 
       salary >(SELECT salary
                FROM employees
                WHERE employee_id = 192);
                 
-- ����9)�������� �ּұ޿��� �޴� ����� ������ �����ȣ,�̸�,����,�μ����� ����϶�.
-- ����1 :�������� ������������
SELECT employee_id, first_name, department_id, salary
FROM employees a
WHERE salary = (SELECT MIN(salary)
                FROM employees b
                WHERE a.job_id = b.job_id
                GROUP BY job_id)
ORDER BY job_id DESC;


-- ����10) EMPLOYEES ���̺��� 50�� �μ��� �ּ� �޿��� �޴� ������� ���� �޿��� �޴� ����� ������ �����ȣ,�̸�,����,�Ի�����,�޿�,�μ���ȣ�� ����϶�. 
-- �� 50���� ����
SELECT employee_id, first_name, job_id, hire_date, salary, department_id
FROM employees 
WHERE salary > (SELECT MIN(salary)
                FROM employees 
                WHERE department_id = 50)
    AND department_id != 50;

-- ����11) EMPLOYEES ���̺��� 50�� �μ��� �ְ� �޿��� �޴� ������� ���� �޿��� �޴� ����� ������ �����ȣ,�̸�,����,�Ի�����,�޿�,�μ���ȣ�� ����϶�. 
-- ��50���� ����

SELECT employee_id, first_name, job_id, hire_date, salary, department_id
FROM employees 
WHERE salary > (SELECT MAX(salary)
                FROM employees 
                WHERE department_id = 50)
    AND department_id != 50;







