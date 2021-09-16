/*
    ���Ἲ : CONSTRAINT
            COLUMN�� �����ϴ� ����
            
    Primary Key : �⺻Ű
                NULL�� ������� �ʴ´�.
                �ߺ��� ������� �ʴ´�.         
    Unique Key : ����Ű
                NULL�� ����Ѵ�.
                �ߺ��� ������� �ʴ´�.
    Foreign Key : �ܷ�Ű
                ���̺�� ���̺��� �����ϴ� ���� ������ �����̴�. Join�� ����
                NULL�� ����Ѵ�.
                �ܷ�Ű�� ������ �÷��� ����� ���̺��� �÷����� Primary Key�� Unique Key�� �����Ǿ� �־�� �Ѵ�.
    Check : ������ ������ �� �ְ�, ���� ������ ���� �ִ�. ������ �� �ܴ̿� ����� �� ����.
            NULL�� ����Ѵ�.
    NOT NULL : NULL�� ������� �ʴ´�.
*/
DROP TABLE TB_TEST04;


CREATE TABLE TB_TEST04(
    COL1 VARCHAR2(10) NOT NULL,
    COL2 VARCHAR2(20)
);

INSERT INTO TB_TEST04(COL1, COL2)
VALUES('AAA', '111');


INSERT INTO TB_TEST04(COL1, COL2)
VALUES('BBB', '');

SELECT * FROM TB_TEST04;

INSERT INTO TB_TEST04(COL1, COL2)
VALUES('', '222');

INSERT INTO TB_TEST04(COL1)
VALUES('CCC');

-- Check : ������ ������ ������ �� �ִ�. NULL�� ���
CREATE TABLE TB_CHECK(
    COL1 VARCHAR2(10),
    COL2 VARCHAR2(20),
    CONSTRAINT CHK_01 CHECK( COL1 IN('���', '��', '�ٳ���') ),
    CONSTRAINT CHK_02 CHECK( COL2 > 0 AND COL2 <= 10 ) 
);

INSERT INTO TB_CHECK(COL1, COL2)
VALUES('���', 5);

INSERT INTO TB_CHECK(COL1, COL2)
VALUES('��', 5); -- ������ ���� �ƴ�


INSERT INTO TB_CHECK(COL1, COL2)
VALUES('', 5);  --NULL ���

INSERT INTO TB_CHECK(COL2)
VALUES(5);

INSERT INTO TB_CHECK(COL1, COL2)
VALUES('���', 0);  -- ������ ���


-- Primary Key = Unique + NOT NULL

CREATE TABLE TB_TEST05(
    COL1_PK VARCHAR2(10) CONSTRAINT PK_TEST_01 PRIMARY KEY,
    COL2 VARCHAR2(20)
);

INSERT INTO tb_test05(COL1_PK, COL2)
VALUES('AAA', '111');

INSERT INTO tb_test05(COL1_PK, COL2)
VALUES('BBB', '');

INSERT INTO tb_test05(COL1_PK)
VALUES('CCC');

INSERT INTO tb_test05(COL1_PK, COL2)
VALUES('', '111'); -- PK�� �� ���� ������� �ʴ´�.

CREATE TABLE TB_TEST06( -- ���̺��� �ϳ��� �⺻ Ű�� ���� �� �ִ�.
    COL1_PK VARCHAR2(10) CONSTRAINT PK_TEST_02 PRIMARY KEY,
    COL2_PK VARCHAR2(10) CONSTRAINT PK_TEST_03 PRIMARY KEY, -- table can have only one primary key
    COL2 VARCHAR2(20)
);

CREATE TABLE TB_TEST06(
    COL1 VARCHAR2(10), 
    COL2 VARCHAR2(10),
    COL3 VARCHAR2(20),
    CONSTRAINT PK_TEST_02 PRIMARY KEY(COL1, COL2)
);

CREATE TABLE TB_TEST07(
    COL1 VARCHAR2(10), 
    COL2 VARCHAR2(10)
);
-- TB_TEST07 COL1�� PRIMARY KEY�� ����
ALTER TABLE TB_TEST07
ADD
PRIMARY KEY(COL1);

-- TB_TEST07 PRIMARY KEY ����
ALTER TABLE TB_TEST07
DROP
PRIMARY KEY;

-- Unique : �ߺ��� ���� ���Ұ�. NULL���
CREATE TABLE TB_TEST08(
    COL1 VARCHAR2(10) CONSTRAINT UK_TEST_01 UNIQUE,
    COL2 VARCHAR2(20)
);

INSERT INTO TB_TEST08(COL1, COL2)
VALUES('AAA', '111');

INSERT INTO TB_TEST08(COL1, COL2)
VALUES('', '222');

-- FOREIGN KEY : �ܷ�Ű
--               Join�� ����, ���̺� ����
--               �⺻���̺��� �÷��� PK, UK�� �Ǿ� �־�� �Ѵ�.
--               NULL�� ���

CREATE TABLE DEPT(      
    DEPARTMENT_ID VARCHAR2(10), -- �⺻Ű
    DEPARTMENT_NAME VARCHAR2(20),
    LOCATION_ID NUMBER,
    CONSTRAINT PK_DEPT_TEST PRIMARY KEY(DEPARTMENT_ID)
);

INSERT INTO DEPT(DEPARTMENT_ID, DEPARTMENT_NAME,LOCATION_ID)
VALUES('10', '��ȹ��', 100);

INSERT INTO DEPT(DEPARTMENT_ID, DEPARTMENT_NAME,LOCATION_ID)
VALUES('20', '������', 110);

INSERT INTO DEPT(DEPARTMENT_ID, DEPARTMENT_NAME,LOCATION_ID)
VALUES('30', '���ߺ�', 120);

-- �������� ���̺�
CREATE TABLE EMP(
    EMPNO VARCHAR2(10),
    ENAME VARCHAR2(20),
    DEPARTMENT_ID_FK VARCHAR2(10), -- �ܷ�Ű, �⺻Ű�� ���� �����ϰ� �ϴ°� ����
    CONSTRAINT FK_EMP_TEST FOREIGN KEY(DEPARTMENT_ID_FK)
    REFERENCES DEPT(DEPARTMENT_ID) -- �ش� ���̺��� ����
);

-- DEPARTMENT_ID_FK �⺻���̺� ��, NULL���� ���
INSERT INTO EMP(EMPNO, ENAME, DEPARTMENT_ID_FK)
VALUES(1, 'ȫ�浿', '30');


INSERT INTO EMP(EMPNO, ENAME, DEPARTMENT_ID_FK)
VALUES(2, '������', '10');

INSERT INTO EMP(EMPNO, ENAME, DEPARTMENT_ID_FK)
VALUES(3, '������', '20');

-- DEPT���̺�� emp���̺��� JOIN�Ͽ� 'ȫ�浿' ���
SELECT e.ename
FROM DEPT d, emp e
WHERE d.department_id = e.department_id_fk
AND e.department_id_fk = '30';

CREATE TABLE LOC(
    LOCATION_ID NUMBER,
    LOC1 VARCHAR2(10),
    LOC2 VARCHAR2(20),
    CONSTRAINT FK_LOC PRIMARY KEY(LOCATION_ID),
    CONSTRAINT FK_LOC FOREIGN KEY(LOCATION_ID)
    REFERENCES DEPT(LOCATION_ID)
)













