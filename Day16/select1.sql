/*
    ����:
        SELECT (��, �÷�(�׸�)��, �Լ�, SUB QUERY)
        FROM (���̺��, SUB QUERY)
*/

SELECT * FROM employees;

SELECT * FROM TAB;

SELECT employee_id, FIRST_NAME, SALARY
FROM employees;

SELECT employee_id, FIRST_NAME, salary * 12
FROM employees;

-- ALIAS            '���ڿ�' "���ڿ�"                      AS ��������               
SELECT employee_id AS �����ȣ, salary AS "�� ��", salary * 12 "�ϳ�ġ ����"
FROM employees;

-- XXX�� ������ XXX�Դϴ�  "�̸� + ����"
SELECT first_name || '�� ������' || SALARY || '�Դϴ�' AS "�̸� + ����"
FROM employees;

-- DISTINCT : �ߺ����� ����
SELECT DISTINCT department_id 
FROM employees;

-- ����1) EMPLOYEES Table�� ��� �ڷḦ ����Ͽ���.
SELECT * FROM EMPLOYEES;

-- ����2) EMPLOYEES Table�� �÷����� ��� ����϶�.
DESC employees;


-- ����3) EMPLOYEES Table���� ��� ��ȣ, �̸�, �޿�, �������� ����Ͽ���.
SELECT employee_id AS "��� ��ȣ", first_name"�̸�", SALARY"����", job_id"��� ����"
FROM EMPLOYEES;

-- ����4) ��� �������� �޿��� $300���� ��Ű�� ���ؼ� ���� �����ڸ� ����ϰ� ����� SALARY+300�� ���÷��� �մϴ�.
SELECT first_name, salary ,salary + 300 
FROM EMPLOYEES;

-- ����5) EMP ���̺��� �����ȣ, �̸�, �޿�, ���ʽ�, ���ʽ� �ݾ��� ����Ͽ���. 
-- (����� ���ʽ��� ���� + (����*Ŀ�̼�))
SELECT employee_id AS "��� ��ȣ", first_name"�̸�", SALARY"����", SALARY +NVL(commission_pct,0)"���ʽ�", NVL(commission_pct,0)"���ʽ� �ݾ�" 
FROM EMPLOYEES;
/*
    NVL(�÷�, �÷��� ���� NULL�̸� �����Ǵ� ��)
*/

-- ����6) EMPLOYEES ���̺��� LAST_NAME�� �̸����� SALARY�� �޿��� ����Ͽ���.
SELECT LAST_NAME AS "�̸�", SALARY AS �޿�
FROM EMPLOYEES;

-- ����7) EMPLOYEES ���̺��� LAST_NAME�� Name���� SALARY * 12�� Annual Salary(����)�� ����Ͽ���
SELECT first_name AS Name  ,SALARY *12 AS "Annual Salary(����)"
FROM EMPLOYEES;

-- ����8) EMPLOYEES ���̺��� �̸��� ������ �����Ͽ� ����Ͽ���. 
SELECT first_name  || ' ' || job_id
FROM EMPLOYEES;

-- ����9) EMPLOYEES ���̺��� �̸��� ������ ��KING is a PRESIDENT�� �������� ����Ͽ���. 
SELECT first_name|| ' is a ' || job_id
FROM EMPLOYEES;

-- ����10) EMPLOYEES ���̺��� �̸��� ������ ��KING: 1 Year salary = 60000�� �������� ����Ͽ���. 
SELECT first_name ||': 1 Year salary ='|| salary*12   
FROM EMPLOYEES;


-- ����11) EMPLOYEES ���̺��� JOB�� ��� ����϶�.
SELECT DISTINCT job_id
FROM EMPLOYEES;








