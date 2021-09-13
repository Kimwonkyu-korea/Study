# sub query

- ### Query안의 Query



- #### SELECT 

  - 단일 ROW 단일 COLUMN (산출되는 데이터는 한개, 컬럼도 한개)

  ```sql
  SELECT employee_id, 
      (SELECT SUM(salary) from employees),
      (SELECT trunc(AVG(salary)) from employees)
  FROM employees;
  ```



- ####  FROM

  - 다중 ROW 다중 COLUMN

  ```sql
  SELECT first_name, salary
  FROM (SELECT employee_id, first_name, salary
          FROM employees
          WHERE department_id = 100)
  WHERE salary > 8000;
  ```



- #### WHERE

  - 다중 ROW 다중 COLUMN

  ```sql
  SELECT first_name, salary
  FROM employees
  WHERE salary > (SELECT AVG(salary) FROM employees);
  ```

  - ex) 부서별로 가장 급여를 적게 받는 사원의 이름, 급여, 부서번호

  ```sql
  SELECT department_id, salary, first_name 
  FROM employees
  WHERE (department_id, salary) IN (  SELECT department_id, MAX(salary)
                                      FROM employees
                                      GROUP BY department_id )
  ORDER BY department_id;
  ```

  



