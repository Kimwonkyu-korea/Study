-- hr
-- 문제1) 사원들의 이름, 부서번호, 부서명을 출력하라
SELECT e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- 문제2) 30번 부서의 사원들의 이름,직업,부서명을 출력하라
SELECT e.first_name, e.job_id, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
   AND  e.department_id = 30;

-- 문제3) 커미션을 받는 사원의 이름, 직업, 부서번호,부서명을 출력하라
SELECT e.first_name, e.job_id, 
    e.department_id, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
    AND e.commission_pct IS NOT NULL;


-- 문제4) 지역번호 2500 에서 근무하는 사원의 이름, 직업,부서번호,부서명을 출력하라
SELECT e.first_name, e.job_id, 
    e.department_id, d.department_name, l.city
FROM employees e, departments d, locations l
WHERE  e.department_id = d.department_id
    AND d.location_id = l.location_id
        AND d.location_id = 2500;


-- 문제5) 이름에 A가 들어가는 사원들의 이름과 부서이름을 출력하라
SELECT first_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
AND e.first_name LIKE '%A%';
-- AND SUBSTR(first_name, 1, 1) = 'A';

-- 문제6) 사원이름과 그 사원의 관리자 이름을 출력하라
SELECT a.first_name "사원",
    a.manager_id, a.employee_id,
    b.first_name "상사"
FROM employees a, employees b   -- a: 사원 b:관리자
WHERE a.manager_id = b.employee_id;

-- 문제7) 사원이름과 부서명과 월급을 출력하는데 월급이 3000 이상인 사원을 출력하라
SELECT e.first_name, d.department_name , e.salary
FROM employees e, departments d
WHERE e.department_id = d.department_id
AND e.salary >= 3000;

-- 문제8) TJ 이란 사원보다 늦게 입사한 사원의 이름과 입사일을 출력하라
SELECT a.first_name, a.hire_date "TJ 입사날짜",
    b.first_name , b.hire_date
FROM employees a, employees b       -- a: TJ , b: 사원들
WHERE a.first_name = 'TJ'
    AND a.hire_date < b.hire_date
ORDER BY b.hire_date ASC;

-- 문제9) 급여가 3000에서 5000사이인 사원의 이름과 소속부서명 출력하라
SELECT e.first_name, d.department_name 
FROM employees e, departments d
WHERE e.department_id = d.department_id
    AND  e.salary >= 3000
      AND e.salary <= 5000;
-- e.salary BETWEEN 3000 AND 5000;


-- 문제10) ACCOUNTING 부서 소속 사원의 이름과 입사일 출력하라
SELECT e.first_name, e.hire_date
FROM employees e, departments d
WHERE e.department_id = d.department_id 
    AND d.department_name = 'Accounting';


-- 문제11) 급여가 3000이하인 사원의 이름과 급여, 근무지
SELECT e.first_name, e.salary, l.city
FROM employees e, departments d,locations l
WHERE e.department_id = d.department_id
    AND salary <= 3000
     AND d.location_id = l.location_id;
        

-- 문제12) 101번 사원에 대해 아래의 결과를 산출하는 쿼리를 작성해 보자.
-- 사번   사원명 JOB명칭   JOB시작일자 JOB종료일자 JOB수행부서명
SELECT jh.employee_id, e.first_name, j.job_title,
    jh.start_date ,jh.end_date, d.department_name
FROM employees e,  job_history jh, jobs j , departments d
WHERE jh.job_id = j.job_id
    AND e.employee_id = jh.employee_id
    AND d.department_id = jh.department_id
    AND e.employee_id = 101;


