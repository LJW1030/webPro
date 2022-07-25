--★ Dept.xml id=deptList
SELECT * FROM DEPT;
--★ Emp.xml id = empList
--SELECT * FROM EMP ORDER BY EMPNO; --출력조건
SELECT * FROM (SELECT ROWNUM RN, A.* FROM (SELECT * FROM EMP ORDER BY EMPNO) A)
    WHERE RN BETWEEN 6 AND 10;
--★ EmpDept.xml id=empDeptList
-- SELECT E.*, DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO ORDER BY EMPNO;
SELECT * FROM (SELECT ROWNUM RN, A.* FROM
    (SELECT E.*, DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO=D.DEPTNO ORDER BY EMPNO) A)
    WHERE RN BETWEEN 6 AND 10;
--★ Emp.xml id=totCnt
SELECT COUNT(*) FROM EMP;
--★ Emp.xml id= detail
SELECT * FROM EMP WHERE EMPNO=7698;
--★ Emp.xml id=managerList
SELECT * FROM EMP WHERE EMPNO IN (SELECT MGR FROM EMP);
--★ Emp.xmi id=insert
INSERT INTO EMP VALUES (9000, '홍길석', 'IT', 7902, '22/07/20', 6000, 800, 40);
--★ Emp,xml id=update
UPDATE EMP SET ENAME='홍홍힝',
                        JOB='MANAGER',
                        MGR=7839,
                        HIREDATE='21/07/20',
                        SAL=7000,
                        COMM=1000,
                        DEPTNO=20
                    WHERE EMPNO = 9000;
--★ Emp.xml id=delete
DELETE FROM EMP WHERE EMPNO=9000;

