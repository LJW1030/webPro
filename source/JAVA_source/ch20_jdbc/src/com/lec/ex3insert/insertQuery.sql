-- �μ���ȣ �ߺ�üũ
SELECT * FROM DEPT WHERE DEPTNO = 70; -- rs.next()����� true(�ߺ����) / false(�μ���/�μ���ġ�Է¹޾� �Է�)
SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=70;
-- �Է�
INSERT INTO DEPT VALUES (70, 'IT', 'SEOUL');
-- ����
UPDATE DEPT SET DNAME = 'ABC', LOC='SEOUL' WHERE DEPTNO=60;
COMMIT;
-- ����
DELETE FROM DEPT WHERE DEPTNO=80;
SELECT * FROM DEPT;
ROLLBACK;

-- �μ����� �Է¹޾� �ش� �μ� ����� ���, �̸�, ��å, �޿��� ���
SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO = D.DEPTNO AND DNAME=UPPER('sales');
SELECT DNAME FROM DEPT;