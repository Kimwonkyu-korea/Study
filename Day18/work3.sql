1. employees ���̺��� ����̸� �� a�� ���Ե� ����̸��� ���ϰ� �� �̸� �� �տ��� 3�ڸ� �����Ͽ� ����϶�.
--SELECT RPAD(first_name, 3)
SELECT SUBSTR(first_name, 1, 3)
FROM employees
WHERE first_name LIKE '%a%' ;

2. �̸��� ����° ���ڰ� a�� ��� ����� �̸��� ǥ���Ͻÿ�.
SELECT first_name
FROM employees
WHERE SUBSTR(first_name, 3, 1) = 'a';
-- WHERE first_name LIKE '__a%';

3. �̸��� J,A �Ǵ� M���� �����ϴ� ��� ����� �̸�(ù ���ڴ� �빮�ڷ�, ������ ���ڴ� �ҹ��ڷ� ǥ��) �� �̸��� ���̸� ǥ���Ͻÿ�.(�� ���̺��� name�� length�� ǥ��)
SELECT INITCAP(first_name) AS NAME , LENGTH(first_name) AS length
FROM employees
WHERE first_name LIKE 'J%'
OR first_name LIKE 'A%'
OR first_name LIKE 'M%';

4. �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �ҹ��ڷ� �̸��� ����Ͻÿ�
SELECT LOWER (first_name)
FROM employees
WHERE LENGTH(first_name) >= 6 ;

5. �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� ����Ͻÿ�.
SELECT LOWER (SUBSTR(first_name, 1, 3))
FROM employees
WHERE LENGTH(first_name) >= 6 ;

6. ��� ����� �̸��� �޿��� ǥ���Ͻÿ�. �޿��� 15�� ���̷� ���ʿ� $��ȣ�� ä���� �������� ǥ���ϰ� �����̺��� �������� �����Ͻÿ�.
SELECT first_name, LPAD(salary, 15, '$') as ����
FROM employees;

7. ������̺��� �Ի�⵵�� ������� ���϶�. 
SELECT TO_CHAR(hire_date,'YYYY') AS �Ի�⵵, COUNT(*)
FROM employees
GROUP BY  TO_CHAR(hire_date,'YYYY')
ORDER BY  TO_CHAR(hire_date,'YYYY') ASC;
