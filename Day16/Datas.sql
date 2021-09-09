/*
��(�׸�) : column
�� : low, record
*/

SELECT * FROM employees;

-- ���� �ּ���

-- table ����
/*
CREATE TABLE ���̺��(
    �÷���1 �ڷ���,
    �÷���2 �ڷ���,
);
*/

-- �ڷ���
/*
    Java        DB                          Mysql
    String      VARCHAR2, CHAR, LONG        VARCHAR
    int         INTEGER, NUMBER
    double      NUMBER
    Date        DATE
*/

-- ���ڿ�
-- CHAR
CREATE TABLE TB_CHAR(
    COL1 CHAR(10 BYTE),
    COL2 CHAR(10 CHAR),
    COL3 CHAR(10)
);

/*
INSERT INTO ���̺��( �÷���1, �÷���2 ...)
VALUES( ��1, ��2, ...);
*/

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('��', '��', '��');  -- �ѱ� : 3 BYTE

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('ABC', 'ABC', 'ABC');  -- ���� : 1 BYTE

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('����', '����', '����');  -- �ѱ� : 3 BYTE

INSERT INTO TB_CHAR(COL1, COL2, COL3)
VALUES('������', '������', '������');  -- �ѱ� : 3 BYTE

SELECT * FROM tb_char;

SELECT  COL1, COL2, COL3,
    LENGTHB(COL1),LENGTHB(COL2),LENGTHB(COL3)
FROM tb_char;

/*
    10 CHAR
    ��    -> 3 BYTE = 3 + 9 => 12 
    ����   -> 6 BYTE = 6 + 8 => 14
    ������ -> 9 BYTE = 9 + 7 => 16 
*/    

-- VARCHAR2
CREATE TABLE TB_VARCHAR(
    COL1 VARCHAR2(10 BYTE),
    COL2 VARCHAR2(10 CHAR),
    COL3 VARCHAR2(10)
);
    
INSERT INTO TB_VARCHAR(COL1, COL2, COL3)
VALUES( 'ABC','ABC','ABC');

INSERT INTO TB_VARCHAR(COL1, COL2, COL3)
VALUES( '������','������','������');

SELECT  COL1, COL2, COL3,
    LENGTHB(COL1),LENGTHB(COL2),LENGTHB(COL3)
FROM TB_VARCHAR;

-- LONG
-- �ִ� 2GB���� ������ ����
-- ���̺�� 1���� �÷��� ����� ����
CREATE TABLE TB_LONG(
    COL LONG
--    COL1 LONG
);

INSERT INTO TB_LONG(COL)
VALUES('ABCDE');

SELECT COL, LENGTHB(COL)
FROM tb_long;

-- ���� (INTEGER, NUMBER)
CREATE TABLE TB_INTEGER(
    COL1 INTEGER,
    COL2 INTEGER
);

INSERT INTO TB_INTEGER(COL1, COL2)
VALUES(123, 456);

INSERT INTO TB_INTEGER(COL1, COL2)
VALUES(123, 456.1);


INSERT INTO TB_INTEGER(COL1, COL2)
VALUES('123', '456');

CREATE TABLE TB_NUMBER(
    COL1 NUMBER,
    COL2 NUMBER(5),
    COL3 NUMBER(5, 2),
    COL4 NUMBER(* ,2)
);

INSERT INTO TB_NUMBER(COL1, COL2, COL3, COL4)
VALUES(1234.5678, 12345.12, 123.456, 123.56789);

SELECT
    * FROM TB_NUMBER;
-- ��¥
-- ����, ��, �� , ��, ��, ��
CREATE TABLE TB_DATE(
    COL1 DATE,
    COL2 DATE
);

INSERT INTO TB_DATE(COL1, COL2)
VALUES('21/09/09', SYSDATE);

INSERT INTO TB_DATE(COL1, COL2)
VALUES('21-09-09', SYSDATE-1);

INSERT INTO TB_DATE(COL1, COL2)
VALUES(TO_DATE('2021-09-09 11:55:23', 'YYYY-MM-DD HH:MI:SS'), SYSDATE-1);

/*
    VARCHAR2
    INTEGER < NUMBER
    DATE
*/

