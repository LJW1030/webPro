-- 부서번호 중복체크
SELECT * FROM DEPT WHERE DEPTNO = 70; -- rs.next()결과가 true(중복출력) / false(부서명/부서위치입력받아 입력)
SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=70;
-- 입력
INSERT INTO DEPT VALUES (70, 'IT', 'SEOUL');
-- 수정
UPDATE DEPT SET DNAME = 'ABC', LOC='SEOUL' WHERE DEPTNO=60;
COMMIT;
-- 삭제
DELETE FROM DEPT WHERE DEPTNO=80;
SELECT * FROM DEPT;
ROLLBACK;

-- 부서명을 입력받아 해당 부서 사원의 사번, 이름, 직책, 급여를 출력
SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND DNAME=UPPER('sales');
SELECT DNAME FROM DEPT;