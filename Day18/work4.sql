-- hr
-- ����1) ������� �̸�, �μ���ȣ, �μ����� ����϶�
SELECT e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- ����2) 30�� �μ��� ������� �̸�,����,�μ����� ����϶�
SELECT e.first_name, e.job_id, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
   AND  e.department_id = 30;

-- ����3) Ŀ�̼��� �޴� ����� �̸�, ����, �μ���ȣ,�μ����� ����϶�
SELECT e.first_name, e.job_id, 
    e.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
    AND e.commission_pct IS NOT NULL;


-- ����4) ������ȣ 2500 ���� �ٹ��ϴ� ����� �̸�, ����,�μ���ȣ,�μ����� ����϶�
SELECT e.first_name, e.job_id, 
    e.department_id, d.department_name, l.city
FROM employees e, departments d, locations l
WHERE  e.department_id = d.department_id
    AND d.location_id = l.location_id
        AND d.location_id = 2500;


-- ����5) �̸��� A�� ���� ������� �̸��� �μ��̸��� ����϶�
SELECT first_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
AND e.first_name LIKE '%A%';
-- AND SUBSTR(first_name, 1, 1) = 'A';

-- ����6) ����̸��� �� ����� ������ �̸��� ����϶�
SELECT a.first_name "���",
    a.manager_id, a.employee_id,
    b.first_name "���"
FROM employees a, employees b   -- a: ��� b:������
WHERE a.manager_id = b.employee_id;

-- ����7) ����̸��� �μ���� ������ ����ϴµ� ������ 3000 �̻��� ����� ����϶�
SELECT e.first_name, d.department_name , e.salary
FROM employees e, departments d
WHERE e.department_id = d.department_id
AND e.salary >= 3000;

-- ����8) TJ �̶� ������� �ʰ� �Ի��� ����� �̸��� �Ի����� ����϶�
SELECT a.first_name, a.hire_date "TJ �Ի糯¥",
    b.first_name , b.hire_date
FROM employees a, employees b       -- a: TJ , b: �����
WHERE a.first_name = 'TJ'
    AND a.hire_date < b.hire_date
ORDER BY b.hire_date ASC;

-- ����9) �޿��� 3000���� 5000������ ����� �̸��� �ҼӺμ��� ����϶�
SELECT e.first_name, d.department_name 
FROM employees e, departments d
WHERE e.department_id = d.department_id
    AND  e.salary >= 3000
      AND e.salary <= 5000;
-- e.salary BETWEEN 3000 AND 5000;


-- ����10) ACCOUNTING �μ� �Ҽ� ����� �̸��� �Ի��� ����϶�
SELECT e.first_name, e.hire_date
FROM employees e, departments d
WHERE e.department_id = d.department_id 
    AND d.department_name = 'Accounting';


-- ����11) �޿��� 3000������ ����� �̸��� �޿�, �ٹ���
SELECT e.first_name, e.salary, l.city
FROM employees e, departments d,locations l
WHERE e.department_id = d.department_id
    AND salary <= 3000
     AND d.location_id = l.location_id;
        

-- ����12) 101�� ����� ���� �Ʒ��� ����� �����ϴ� ������ �ۼ��� ����.
-- ���   ����� JOB��Ī   JOB�������� JOB�������� JOB����μ���
SELECT jh.employee_id, e.first_name, j.job_title,
    jh.start_date ,jh.end_date, d.department_name
FROM employees e,  job_history jh, jobs j , departments d
WHERE jh.job_id = j.job_id
    AND e.employee_id = jh.employee_id
    AND d.department_id = jh.department_id
    AND e.employee_id = 101;


