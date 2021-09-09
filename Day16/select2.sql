/*
    SELECT
    FROM
    WHERE   ������ -> if
    
    �񱳿�����( > < <= >= = != <> )
    NULL, IS NULL, IS NOT NULL
    AND(&&), OR(||), (�켱��)
*/

-- �̸� -> Julia
SELECT first_name, last_name, salary
FROM EMPLOYEES
WHERE FIRST_NAME = 'Julia';

-- ������ $9000 �̻��� ���
SELECT first_name, salary
FROM EMPLOYEES
WHERE SALARY >= 9000;

-- �̸��� Shanta ���� ū �̸�
SELECT first_name
FROM EMPLOYEES
WHERE FIRST_NAME >= 'Shanta';

-- �̸��� ù���ڰ� J���� ū �̸�
SELECT first_name
FROM EMPLOYEES
WHERE first_name > 'J' and first_name >= 'Shanta';


-- �Ŵ����� ���� ���
SELECT first_name, manager_id
FROM employees
WHERE manager_id IS NULL;       -- manager_id = NULL


SELECT first_name, manager_id
FROM employees
WHERE manager_id = '';  

SELECT first_name, manager_id
FROM employees
WHERE manager_id IS NOT NULL;

-- && = AND 
-- �̸� john, ������ 5000�̻�
SELECT first_name, salary
FROM employees
WHERE first_name = 'John'
AND salary >= 5000;

-- || = OR
SELECT first_name, Last_name
FROM employees
WHERE first_name = 'John'
OR Last_name = 'Vollman';

-- 2007�� 12�� 31�� ���Ŀ� �Ի��� ����� ���
SELECT first_name, hire_date
FROM employees
WHERE hire_date > '07/12/31';

SELECT first_name, hire_date
FROM employees
WHERE hire_date > TO_DATE('20071231', 'YYYYMMDD');

/*
    ALL(=AND), ANY(=OR)
    IN, NOT IN 
    BETWEEN
    LIKE
*/
SELECT FIRST_NAME
FROM employees
WHERE FIRST_NAME = ALL('Julia', 'John');
-- FIRST_NAME = 'Julia' AND FIRST_NAME = 'John'

SELECT FIRST_NAME
FROM employees
WHERE FIRST_NAME = ANY('Julia', 'John');
-- FIRST_NAME = 'Julia' OR FIRST_NAME = 'John'

SELECT FIRST_NAME, salary 
FROM employees
WHERE salary = any(8000, 3200, 6000);


SELECT FIRST_NAME, salary 
FROM employees
WHERE salary IN(8000, 3200, 6000);

SELECT FIRST_NAME, salary 
FROM employees
WHERE salary NOT IN(8000, 3200, 6000);

SELECT FIRST_NAME, salary 
FROM employees
--WHERE salary >= 3200 AND salary <= 9000;
WHERE salary BETWEEN 3200 AND 9000;

SELECT FIRST_NAME, salary 
FROM employees
WHERE salary NOT BETWEEN 3200 AND 9000;


-- Like 
SELECT first_name
FROM employees
WHERE first_name LIKE 'G_ra_d'; -- _ �ѱ���

SELECT first_name 
FROM employees
WHERE first_name LIKE 'K%y';  -- % �߰��� ���ڰ� �����̵� ���


SELECT first_name, hire_date
FROM employees
WHERE hire_date LIKE '06%';


SELECT first_name 
FROM employees
WHERE  first_name LIKE '%z%';



