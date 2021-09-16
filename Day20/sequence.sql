/*
    SEQUENCE :  ������ ��(�ߺ��� ���� �ƴ�)�� ������ �ִ� ������Ʈ
                ȸ����ȣ, �Խ��� �۹�ȣ
                �ʱ�ȭ�� �ȵȴ�.
                
    int count = 0;
    while(true){
        count++;
    }

*/
-- SEQUENCE ����
CREATE SEQUENCE TESTSEQ
INCREMENT BY 1      -- 1�� ����
START WITH 10       -- ���� ����
MAXVALUE 100
MINVALUE 1;

-- CURRVAL = ������ SEQ
SELECT TESTSEQ.CURRVAL
FROM DUAL;

-- NEXTVAL = ���� ��
SELECT TESTSEQ.NEXTVAL
FROM DUAL;

-- ����
ALTER SEQUENCE TESTSEQ
INCREMENT BY 3;

-- ����
DROP SEQUENCE TESTSEQ;


INSERT INTO employees(employee_id, last_name, email, hire_date, job_id)
VALUES(EMPLOYEES_SEQ.nextval, 'ȫ', 'hgd@naver.com', '21/09/13', 'IT_PROG');

SELECT
    * FROM employees;

ROLLBACK;