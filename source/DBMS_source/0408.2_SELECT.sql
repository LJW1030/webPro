-- [II] SELECT �� - ���� ���� ���̴� DML(Data Manipulation Language) ; �˻� ���
-- 1. SELECT ���� �ۼ���
-- ���� ���� (���� : ctrl + Enter)
SHOW USER; 
SELECT * FROM TAB; -- �� ����(scott)�� ������ �ִ� ���̺�
SELECT * FROM EMP; -- EMP ���̺��� ��� ��(�ʵ�), ��� ��
SELECT * FROM DEPT; -- DEPT���̺��� ��� ��, ��� ��
-- EMP ���̺��� ����
DESC EMP;
DESC DEPT;

-- 2. SELECT�� ����(Ư�� ���� ���)
SELECT EMPNO, ENAME, SAL, JOB FROM EMP;
SELECT EMPNO AS "�� ��", ENAME AS "�̸�", SAL AS "�޿�", JOB FROM EMP; -- ��Ī
SELECT EMPNO AS ���, ENAME AS �̸�, SAL AS �޿�, JOB FROM EMP;
SELECT EMPNO ���, ENAME �̸�, SAL �޿�, JOB FROM EMP;
SELECT EMPNO "�� ��", ENAME "�� ��", SAL "�� ��", JOB FROM EMP;
SELECT EMPNO NO, ENAME NAME, SAL SALARY FROM EMP; -- TITLE : NO, NAME, SALARY

-- 3. Ư�� �� ��� : WHERE ��(����)-�񱳿����� ; ����(=), ũ�ų�����(>=).. �ٸ���(!=, ^=, <>)
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL = 3000; -- ����
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL != 3000; -- �ٸ���
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL ^= 3000; -- �ٸ���
SELECT EMPNO "���", ENAME "�̸�", SAL "�޿�" FROM EMP WHERE SAL <> 3000; -- �ٸ���
    -- �񱳿����ڴ� ����, ����, ��¥�� ��� ����
    -- ex. ����̸�(ENAME)�� 'A','B','C'�� �����ϴ� ����� ��� �ʵ�
    SELECT * FROM EMP WHERE ENAME < 'D';
    -- ex. 81�⵵ ������ �Ի��� ����� ��� �ʵ�
    SELECT * FROM EMP WHERE HIREDATE < '81/01/01';
    -- ex. 10�� �μ���ȣ(deptno)�� ����� ��� �ʵ带 ���
    SELECT * FROM EMP WHERE DEPTNO=10;
    -- ex. �̸�(ENAME)�� FORD�� ������ EMPNO, ENAME, MGR(����� ���)�� ���
    SELECT EMPNO, ENAME, MGR FROM EMP WHERE ENAME = 'FORD';
    select empno, ename, mgr from emp where ename = 'FORD'; -- �����ʹ� ��ҹ��� ����

-- 4. �������� : AND, OR, NOT
    -- ex. �޿�(SAL)�� 2000�̻� 3000������ ������ ��� �ʵ�
SELECT * FROM EMP WHERE SAL>=2000 AND SAL<=3000;
    -- ex. 82�⵵�� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE >= '82/01/01' AND HIREDATE<= '82/12/31';
-- ��¥ ǥ��� ���� (���� : YY/MM/DD OR RR/MM/DD)
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-RR';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD'; -- �ѱ��������� ���� INSTALL
SELECT ENAME, HIREDATE FROM EMP;
    -- ������ 2400 �̻��� ������ ENAME, SAL, ���� ��� (���� = SAL*12)
    SELECT ENAME, SAL, SAL*12 "����" FROM EMP WHERE SAL*12 > 2400;
    SELECT ENAME, SAL, SAL*12 "����" FROM EMP WHERE ����>2400; -- WHERE������ ��Ī�� �� �� ����
    SELECT ENAME, SAL, SAL*12 "����" 
        FROM EMP 
        WHERE SAL*12>2400 
        ORDER BY ����; -- ORDER BY������ ��Ī ��� ����
    -- 10�� �μ�(DEPTNO)�̰ų� ��å(JOB)�� MANAGER�� ����� ��� �ʵ�
    SELECT * FROM EMP WHERE DEPTNO=10 OR JOB='MANAGER';
    -- �μ���ȣ�� 10���� �ƴ� ����� ��� �ʵ�
    SELECT * FROM EMP WHERE DEPTNO != 10;
    SELECT * FROM EMP WHERE NOT DEPTNO=10;

-- 5. ���ǥ����
SELECT ENAMEK, SAL "����޿�", SAL+100 "�ø��޿�" FROM EMP WHERE DEPTNO=10;
    -- ex. ��� ����� �̸�(ENAME), ����(SAL), ��(COMM), ����(SAL*12+COMM)
    -- ��������� ����� NULL�����ϸ� ����� NULL
    -- NVL(NULL�� ���� �ִ� �ʵ��, ��ġ��) �ݵ�� �Ű����� ���� Ÿ�� ���ƾ� ��
    SELECT ENAME, SAL, COMM, SAL*12+COMM FROM EMP;
    SELECT ENAME, SAL, COMM, SAL*12+NVL(COMM, 0) FROM EMP;
    -- ��� ����� �����(ENAME), ����� ���(MGR)�� ���(�������� 0)
    SELECT ENAME, NVL(MGR, 0) FROM EMP;
    SELECT ENAME, NVL(MGR, '����') FROM EMP; -- NVL �Ű����� Ÿ�� ����ġ ����

-- 6. ���Ῥ����(||) : ���̳� ���ڸ� ����
SELECT ENAME || '��' || JOB "EMPLOYEES" FROM EMP;
    -- ex. "SMITH : ���� = XXX"�� ���� ��� �� ���(���� = SAL*12+COMM)
    SELECT ENAME || ' : ���� = ' || (SAL*12+NVL(COMM,0)) FROM EMP;

-- 7. �ߺ����� (DISTINCT)
SELECT JOB FROM EMP;
SELECT DEPTNO FROM EMP;
SELECT DISTINCT JOB FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;

-- �� �������� �� Ǯ��
    --1. emp ���̺��� ���� ���(����Ŭ)
DESC EMP; 
    --2. emp ���̺��� ��� ������ ��� 
SELECT * FROM EMP;
    --3. �� scott �������� ��밡���� ���̺� ���
SHOW USER;
SELECT * FROM TAB; -- ���� ������ ������ �ִ� ���̺�
    --4. emp ���̺��� ���, �̸�, �޿�, ����, �Ի��� ���
SELECT EMPNO, ENAME, SAL, JOB, HIREDATE FROM EMP;
    --5. emp ���̺��� �޿��� 2000�̸��� ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL<2000;
    --6. �Ի����� 81/02���Ŀ� �Ի��� ����� ���, �̸�, ����, �Ի��� ���
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP 
    WHERE HIREDATE >= '81/02/01';
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP 
    WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') >= '81/02/01'; -- �������Լ�(4�� ����) 
SELECT EMPNO, ENAME, JOB, HIREDATE FROM EMP 
    WHERE HIREDATE >= TO_DATE('81/02/01', 'RR/MM/DD'); -- �������Լ�(4�� ����)
-- # ��¥���� (YYYY �⵵4�ڸ�, RR �⵵2�ڸ�, M��, D��)
ALTER SESSION SET NLS_DATE_FORMAT = 'MM-DD-RR'; 
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
-- # ��¥�� -> ���������� ��ȯ�ϴ� �Լ� : TO_CHAR(��¥��������, ����)
-- # ������ -> ��¥������ ��ȯ�ϴ� �Լ� : TO_DATE(������������, ����)

    --7. ������ SALESMAN�� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB = 'SALESMAN';
    --8. ������ CLERK�� �ƴ� ����� ��� �ڷ� ���
SELECT * FROM EMP WHERE JOB != 'CLERK';
SELECT * FROM EMP WHERE JOB <> 'CLERK';
SELECT * FROM EMP WHERE JOB ^= 'CLERK';
SELECT * FROM EMP WHERE NOT JOB = 'CLERK';
    --9. �޿��� 1500�̻��̰� 3000������ ����� ���, �̸�, �޿� ���
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL<=3000;
    --10. �μ��ڵ尡 10���̰ų� 30�� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE DEPTNO=10 OR DEPTNO=30;
    --11. ������ SALESMAN�̰ų� �޿��� 3000�̻��� ����� ���, �̸�, ����, �μ��ڵ� ���
SELECT EMPNO, ENAME, JOB, DEPTNO FROM EMP WHERE JOB='SALESMAN' OR SAL>=3000;
    --12. �޿��� 2500�̻��̰� ������ MANAGER�� ����� ���, �̸�, ����, �޿� ���
SELECT EMPNO, ENAME, JOB, SAL FROM EMP WHERE SAL>=2500 AND JOB = 'MANAGER';
    --13.��ename�� XXX �����̰� ������ XX�١� ��Ÿ�Ϸ� ��� ���(������ SAL*12+COMM)
SELECT ENAME||'��(��) '||job||'�����̰� ������ '||(SAL*12+NVL(COMM,0)) ||'��' FROM EMP;

-- 8. SQL ������(BETWEEN, IN, LIKE, IS NULL)
  -- (1) BETWEEON : (����)������ BETWEEON A AND B (A<=B)
    -- ex. SAL�� 1500�̻� 3000������ ��� �̸� �޿�
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL>=1500 AND SAL<=3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 1500 AND 3000;
SELECT EMPNO, ENAME, SAL FROM EMP WHERE SAL BETWEEN 3000 AND 1500 ; -- x
    -- ex. 1500�̸�, 3000�ʰ��ϴ� ��� �ʵ�
SELECT * FROM EMP WHERE SAL NOT BETWEEN 1500 AND 3000;
    -- ex.82�⵵�� �Ի��� ������ ��� �ʵ� ���
SELECT * FROM EMP WHERE HIREDATE BETWEEN '82/01/01' AND '82/12/31';
SELECT * FROM EMP 
    WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') BETWEEN '82/01/01' AND '82/12/31';
    -- ex. ����̸��� 'A','B'�� �����ϴ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME BETWEEN 'A' AND 'C' AND ENAME!='C';
    -- ex. ����̸��� 'B','C'�� �����ϴ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME BETWEEN 'B' AND 'D' AND ENAME<>'D';
  -- (2) IN : (����)������ IN (A,B,C...)
    -- ex. �μ���ȣ�� 10,20,40���� �μ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO=10 OR DEPTNO=20 OR DEPTNO=40;
SELECT * FROM EMP WHERE DEPTNO IN (10,20,40);
    -- ex. �μ���ȣ�� 10,20,40�� �μ��� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE DEPTNO NOT IN (10,20,40);
SELECT * FROM EMP WHERE DEPTNO!=10 AND DEPTNO<>20 AND DEPTNO^=40;
    -- ex. ����� 7902, 7788, 7566�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE EMPNO IN (7902, 7788, 7566);

  -- (3) LIKE ���� : (����) ������ LIKE ����(���ϵ�ī�� %:0�����̻�, _:�ѱ���)
    -- ex. �̸��� M�� �� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%M%';
    -- ex. �̸��� M���� �����ϴ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE 'M%';
    -- ex. �̸��� S�� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%S';
    -- ex. SAL�� 5�� ������ ����� ��� �ʵ�
SELECT * FROM EMP WHERE SAL LIKE '%5';
SELECT * FROM EMP WHERE SAL = '2975'; -- �������� ������ �� ����
    -- ex. 82�⵵�� �Ի��� ����� ��� �ʵ�;
SELECT * FROM EMP WHERE HIREDATE LIKE '%82%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '82/%';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = '82';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR') = 82;
    -- ex. 1���� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE LIKE '__/01/__';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '__/01/__';
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '01';
    -- ex. 82�⵵�� �ƴ� �⵵�� �Ի��� ����� ��� �ʵ�
SELECT * FROM EMP WHERE HIREDATE NOT LIKE '82/%';
    -- ex. �̸��� %�� �� ����� ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%%%'; -- ��� �ʵ�
SELECT * FROM EMP WHERE ENAME LIKE '%\%%' ESCAPE '\';
INSERT INTO EMP VALUES (9999, 'ȫ%', NULL, NULL, NULL, 9000, 900, 40); -- ������ �Է�
ROLLBACK; -- DML(�߰�, ����, ����)�� ������ ������ ���󺹱�(DML ���)

  -- (4) IS NULL
SELECT * FROM EMP;
    -- ex. �󿩱��� NULL�� ����� ��� �ʵ�
SELECT * FROM EMP WHERE COMM IS NULL;
SELECT * FROM EMP WHERE COMM=NULL; -- NULL�� �񱳽� �ݵ�� IS NULL��.
    -- ex. �󿩱��� ���� ����� ��� �ʵ�(COMM �� NULL�̰ų� 0)
SELECT * FROM EMP WHERE COMM IS NULL OR COMM=0;
    -- ex. �󿩱��� �ִ� ����� ��� �ʵ�(COMM�� NULL�� �ƴϰ� 0�� �ƴϰ�)
SELECT * FROM EMP WHERE NOT COMM IS NULL AND COMM!=0;
SELECT * FROM EMP WHERE NOT (COMM IS NULL OR COMM=0);

-- 9. ����(��������, ��������)
SELECT ENAME, SAL FROM EMP ORDER BY SAL; -- �޿� �������� ����
SELECT ENAME, SAL FROM EMP ORDER BY SAL ASC; -- �޿� �������� ����
SELECT ENAME, SAL FROM EMP ORDER BY SAL DESC; -- �޿� �������� ����
SELECT ENAME, SAL FROM EMP ORDER BY ENAME; -- �̸� ABCD������ 
SELECT ENAME, SAL FROM EMP ORDER BY ENAME DESC; -- �̸� ���ĺ��� �ݴ�� 
SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE; -- ��¥ ������� ����
SELECT ENAME, HIREDATE FROM EMP ORDER BY HIREDATE DESC; -- �ֽż����� ����
    -- �̸�, ����(SAL*12+COMM)�� ���(������ ���� ������, ������ ���� ��� �̸�������)
SELECT ENAME, SAL*12+NVL(COMM,0) "ANNUAL_SAL" FROM EMP 
    ORDER BY SAL*12+NVL(COMM,0) DESC, ENAME;
SELECT ENAME, SAL*12+NVL(COMM,0) "ANNUAL_SAL" 
    FROM EMP 
    ORDER BY ANNUAL_SAL DESC, ENAME; -- ORDER BY ������ ��Ī ��� ����(FROM->WHERE->SELECT->ORDER)
    -- ex. ���, �̸�, �Ի���, �޿�, �μ���ȣ (�μ���ȣ��, �μ��� ������ �Ի��� ������������ ���)
SELECT EMPNO, ENAME, HIREDATE, SAL, DEPTNO FROM EMP ORDER BY DEPTNO, HIREDATE DESC;

-- �� ���� ��������(�� �����ϱ�) - yisy0703@naver.com�� ����ٶ��ϴ�
  --1.EMP ���̺��� sal�� 3000�̻��� ����� empno, ename, job, sal�� ���
SELECT EMPNO, ENAME, JOB, SAL 
    FROM EMP 
    WHERE SAL>=3000;
    
  --2.EMP ���̺��� empno�� 7788�� ����� ename�� deptno�� ���
SELECT ENAME, DEPTNO 
    FROM EMP 
    WHERE EMPNO=7788;
    
  --3.����(sal*12+comm)�� 24000 �̻��� ���, �̸�, �޿� ��� (�޿�������)
SELECT EMPNO, ENAME, SAL 
    FROM EMP 
    WHERE (SAL*12+NVL(COMM,0))>=24000 
    ORDER BY SAL;
    
  --4.EMP ���̺��� hiredate�� 1981�� 2�� 20�� 1981�� 5�� 1�� ���̿� �Ի��� ����� 
  --ename,job,hiredate�� ����ϴ� SELECT ������ �ۼ� (�� hiredate ������ ���)
SELECT ENAME, JOB, HIREDATE FROM EMP 
    WHERE HIREDATE BETWEEN '81/02/20' AND '81/05/01' 
    ORDER BY HIREDATE;
SELECT ENAME, JOB, HIREDATE FROM EMP 
    WHERE HIREDATE >= '81/02/20' AND HIREDATE<='81/05/01' 
    ORDER BY HIREDATE ;

SELECT ENAME, JOB, HIREDATE FROM EMP 
    WHERE HIREDATE BETWEEN TO_DATE('1981/02/20','YYYY/MM/DD') 
                    AND TO_DATE('1981/05/01' ,'YYYY/MM/DD')
    ORDER BY HIREDATE;
SELECT ENAME, JOB, HIREDATE FROM EMP 
    WHERE HIREDATE BETWEEN TO_DATE('81/02/20','RR/MM/DD') 
                    AND TO_DATE('81/05/01' ,'RR/MM/DD')
    ORDER BY HIREDATE; 
    
  --5.EMP ���̺��� deptno�� 10,20�� ����� ��� ������ ��� (�� ename������ ����)
SELECT * FROM EMP WHERE DEPTNO=10 OR DEPTNO=20 ORDER BY ENAME;
SELECT * FROM EMP WHERE DEPTNO IN (10,20) ORDER BY ENAME;

  --6.EMP ���̺��� sal�� 1500�̻��̰� deptno�� 10,30�� ����� ename�� sal�� ���
  -- (�� HEADING�� employee�� Monthly Salary�� ���)
SELECT ENAME employee, SAL "Monthly Salary" FROM EMP 
  WHERE SAL>=1500 AND DEPTNO IN (10,30);
SELECT ENAME employee, SAL "Monthly Salary" FROM EMP 
  WHERE SAL>=1500 AND (DEPTNO=10 OR DEPTNO=30);
  
  --7.EMP ���̺��� hiredate�� 1982���� ����� ��� ������ ���
SELECT * FROM EMP WHERE HIREDATE LIKE '82%';
--��¥ ���� ����
ALTER SESSION SET NLS_DATE_FORMAT = 'MM/DD/YYYY';
ALTER SESSION SET NLS_DATE_FORMAT = 'RR/MM/DD';
-- TO_DATE(), TO_CHAR()�Լ� �̿�
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'YYYY') = 1982;
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE,'RR') = 82;
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR/MM/DD') LIKE '82%';

  --8.�̸��� ù�ڰ� C����  P�� �����ϴ� ����� �̸�, �޿� �̸��� ����
SELECT ENAME, SAL FROM EMP 
  WHERE (ENAME BETWEEN 'C' AND 'Q') AND ENAME!='Q'
  ORDER BY SAL, ENAME;
  
  --9.EMP ���̺��� comm�� sal�� 10%�̻��� ��, ��� ����� ���Ͽ� �̸�, �޿�, �󿩱��� 
  --����ϴ� SELECT ���� �ۼ�
SELECT ENAME, SAL, COMM FROM EMP WHERE COMM>SAL*1.1 ;

  --10.job�� CLERK�̰ų� ANALYST�̰� sal�� 1000,3000,5000�� �ƴ� ����� ��� �ʵ�
SELECT * FROM EMP WHERE (JOB='CLERK' OR JOB='ANALYST') 
  AND SAL NOT IN (1000,3000,5000);
SELECT * FROM EMP WHERE JOB IN('CLERK','ANALYST') 
  AND SAL NOT  IN (1000,3000,5000);
SELECT * FROM EMP WHERE (job='CLERK' OR job='ANALYST') 
  AND NOT SAL IN (1000,3000,5000);
  
  --11.EMP ���̺��� ename�� L�� �� �ڰ� �ְ� deptno�� 30�̰ų� �Ǵ� mgr�� 7782�� ����� 
  --��� ������ ����ϴ� SELECT ���� �ۼ��Ͽ���.
SELECT * FROM EMP 
  WHERE ENAME LIKE '%L%L%' AND DEPTNO=30 OR MGR=7782;
  
  --12.��� ���̺��� �Ի����� 81�⵵�� ������ ���,�����, �Ի���, ����, �޿��� ���
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP 
  WHERE HIREDATE LIKE '81%';
-- TO_CHAR()�Լ� �̿��Ͽ� � �ý��ۿ����� �� ����ǵ���
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP 
    WHERE TO_CHAR(HIREDATE, 'RR') = 81;
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP
  WHERE HIREDATE BETWEEN '81/01/01' AND '81/12/31';
-- TO_DATE() �Լ� �̿��Ͽ� � �ý��ۿ����� �� ����ǵ���
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP
    WHERE HIREDATE BETWEEN TO_DATE('81/01/01', 'RR/MM/DD') 
        AND TO_DATE('81/12/31', 'RR/MM/DD');

  --13.��� ���̺��� �Ի�����81���̰� ������ 'SALESMAN'�� �ƴ� ������ ���, �����, �Ի���, 
  -- ����, �޿��� �˻��Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP 
  WHERE HIREDATE LIKE '%81%' AND JOB!='SALESMAN';
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP
  WHERE TO_CHAR(HIREDATE, 'RR')=81 AND JOB !='SALESMAN';
  
  --14.��� ���̺��� ���, �����, �Ի���, ����, �޿��� �޿��� ���� ������ �����ϰ�, 
  -- �޿��� ������ �Ի����� ���� ������� �����Ͻÿ�.
SELECT EMPNO, ENAME, HIREDATE, JOB, SAL FROM EMP 
      ORDER BY SAL DESC, HIREDATE;
      
  --15.��� ���̺��� ������� �� ��° ���ĺ��� 'N'�� ����� ���, ������� �˻��Ͻÿ�
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '__N%';

  --16.	����� 'A'�� �� ����� ���, ������� ���
SELECT EMPNO, ENAME FROM EMP WHERE ENAME LIKE '%A%';

  --17.��� ���̺��� ����(SAL*12)�� 35000 �̻��� ���, �����, ������ �˻� �Ͻÿ�.
SELECT EMPNO, ENAME, SAL*12 ���� FROM EMP WHERE SAL*12 > 35000;