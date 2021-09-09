/*
    형식:
        SELECT (값, 컬럼(항목)명, 함수, SUB QUERY)
        FROM (테이블명, SUB QUERY)
*/

SELECT * FROM employees;

SELECT * FROM TAB;

SELECT employee_id, FIRST_NAME, SALARY
FROM employees;

SELECT employee_id, FIRST_NAME, salary * 12
FROM employees;

-- ALIAS            '문자열' "문자열"                      AS 생략가능               
SELECT employee_id AS 사원번호, salary AS "월 급", salary * 12 "일년치 연봉"
FROM employees;

-- XXX의 월급은 XXX입니다  "이름 + 월급"
SELECT first_name || '의 월급은' || SALARY || '입니다' AS "이름 + 월급"
FROM employees;

-- DISTINCT : 중복행을 삭제
SELECT DISTINCT department_id 
FROM employees;

-- 문제1) EMPLOYEES Table의 모든 자료를 출력하여라.
SELECT * FROM EMPLOYEES;

-- 문제2) EMPLOYEES Table의 컬럼들을 모두 출력하라.
DESC employees;


-- 문제3) EMPLOYEES Table에서 사원 번호, 이름, 급여, 담당업무를 출력하여라.
SELECT employee_id AS "사원 번호", first_name"이름", SALARY"월급", job_id"담당 업무"
FROM EMPLOYEES;

-- 문제4) 모든 종업원의 급여를 $300증가 시키기 위해서 덧셈 연산자를 사용하고 결과에 SALARY+300을 디스플레이 합니다.
SELECT first_name, salary ,salary + 300 
FROM EMPLOYEES;

-- 문제5) EMP 테이블에서 사원번호, 이름, 급여, 보너스, 보너스 금액을 출력하여라. 
-- (참고로 보너스는 월급 + (월급*커미션))
SELECT employee_id AS "사원 번호", first_name"이름", SALARY"월급", SALARY +NVL(commission_pct,0)"보너스", NVL(commission_pct,0)"보너스 금액" 
FROM EMPLOYEES;
/*
    NVL(컬럼, 컬럼의 값이 NULL이면 설정되는 값)
*/

-- 문제6) EMPLOYEES 테이블에서 LAST_NAME을 이름으로 SALARY을 급여로 출력하여라.
SELECT LAST_NAME AS "이름", SALARY AS 급여
FROM EMPLOYEES;

-- 문제7) EMPLOYEES 테이블에서 LAST_NAME을 Name으로 SALARY * 12를 Annual Salary(연봉)로 출력하여라
SELECT first_name AS Name  ,SALARY *12 AS "Annual Salary(연봉)"
FROM EMPLOYEES;

-- 문제8) EMPLOYEES 테이블에서 이름과 업무를 연결하여 출력하여라. 
SELECT first_name  || ' ' || job_id
FROM EMPLOYEES;

-- 문제9) EMPLOYEES 테이블에서 이름과 업무를 “KING is a PRESIDENT” 형식으로 출력하여라. 
SELECT first_name|| ' is a ' || job_id
FROM EMPLOYEES;

-- 문제10) EMPLOYEES 테이블에서 이름과 연봉을 “KING: 1 Year salary = 60000” 형식으로 출력하여라. 
SELECT first_name ||': 1 Year salary ='|| salary*12   
FROM EMPLOYEES;


-- 문제11) EMPLOYEES 테이블에서 JOB을 모두 출력하라.
SELECT DISTINCT job_id
FROM EMPLOYEES;








