-- �μ���ȣ �ߺ�üũ
SELECT * FROM DEPT WHERE DEPTNO=70; -- rs.next()����� true(�ߺ����) / false(�μ���/�μ���ġ�Է¹޾� �Է�)
SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO=70;
-- �Է�
INSERT INTO DEPT VALUES (55, 'IT', 'SEOUL');
-- ����
UPDATE DEPT SET DNAME='ABC', LOC='SEOUL' WHERE DEPTNO=11;
COMMIT;
SELECT * FROM DEPT;
desc dept;
-- ����
DELETE FROM DEPT WHERE DEPTNO=88;
commit;
-- �μ����� �Է¹޾� �ش� �μ� ����� ���, �̸�, ��å, �޿��� ���
SELECT EMPNO, ENAME, JOB, SAL
    FROM EMP E, DEPT D
    WHERE E.DEPTNO=D.DEPTNO AND DNAME=UPPER('sales');
UPDATE DEPT SET DNAME = UPPER(DNAME);
SELECT * FROM DEPT;



















