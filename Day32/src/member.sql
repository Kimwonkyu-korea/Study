
CREATE TABLE MEMBER(
	ID VARCHAR2(50) PRIMARY KEY,
	PWD VARCHAR2(50) NOT NULL,
	NAME VARCHAR2(50) NOT NULL,
	EMAIL VARCHAR2(50) UNIQUE,
	AUTH NUMBER(1) NOT NULL
);

SELECT * FROM MEMBER;

-- id 확인, 1이상이면 중복, 0이면 중복X
SELECT COUNT(*)
FROM MEMBER
WHERE ID = 'abc';

SELECT COUNT(*)
FROM MEMBER 
WHERE ID='abc' AND PWD = '123';