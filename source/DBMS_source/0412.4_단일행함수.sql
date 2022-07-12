--[IV] ������ �Լ� ; �����Լ�, SQL �ֿ��Լ�
-- �Լ�  = �������Լ� + �׷��Լ�(�����Լ�)
    -- �������Լ� (INPUT 1�� -> OUTPUT 1��) : 4��
SELECT HIREDATE, TO_CHAR(HIREDATE, 'YY"��"MM"��"DD"��"') FROM EMP; -- ������ �Լ�
SELECT ENAME, INITCAP(ENAME) FROM EMP; -- �������Լ�
    -- �׷��Լ� (INPUT N�� -> OUTPUT 1��) : 5��
SELECT SUM(SAL) FROM EMP; -- ��ü SAL ��
SELECT DEPTNO, SUM(SAL) FROM EMP GROUP BY DEPTNO; -- �μ��� SAL ��

-- �� �������Լ� ���� : ���ڰ����Լ�, ���ڰ����Լ�, ��¥�����Լ�(�����), ����ȯ�Լ�, NVL(), ETC,.. ��

-- 1. ���ڰ����Լ�
    -- DUAL ���̺� : ����Ŭ���� �����ϴ� 1��1���ڸ� dummy table (cf)DUMMY
DESC DUAL;
SELECT * FROM DUAL;
SELECT * FROM DUMMY;
DESC DUMMY;
SELECT -9, ABS(-9) FROM DUAL; -- ���밪
SELECT FLOOR(34.5678) FROM DUAL; -- �Ҽ������� ����
SELECT FLOOR(34.5678*100)/100 FROM DUAL; -- �Ҽ��� �ι�°�ڸ����� ����
SELECT TRUNC(34.5678, 2) FROM DUAL;      -- �Ҽ��� �ι�°�ڸ����� ����
SELECT TRUNC(34.5678) FROM DUAL;         -- �Ҽ������� ����
SELECT TRUNC(34, -1) FROM DUAL;          -- ���� �ڸ����� ����
    -- ex. EMP���̺��� �̸�, �޿�(���� �ڸ����� ����)
    SELECT ENAME, SAL, TRUNC(SAL, -2) FROM EMP;

SELECT CEIL(34.5678) FROM DUAL;         -- �Ҽ������� �ø�
SELECT CEIL(34.5678*100)/100 FROM DUAL; -- �Ҽ��� �ι�°�ڸ����� �ø�

SELECT ROUND(34.5678) FROM DUAL;    -- �Ҽ������� �ݿø�
SELECT ROUND(34.5678, 2) FROM DUAL; -- �Ҽ��� �ι�° �ڸ����� �ݿø�
SELECT ROUND(34.5678, -1) FROM DUAL;-- ���� �ڸ����� �ݿø�

SELECT MOD(9,2) FROM DUAL; -- ������ ������ 
    -- ex. ����� Ȧ���� ����� ��� �ʵ� ���
    SELECT * FROM EMP WHERE MOD(EMPNO,2) != 0;
    -- ex. Ȧ���޿� �Ի��� ����� ��� �ʵ� ���
    SELECT * FROM EMP WHERE MOD(TO_CHAR(HIREDATE, 'MM'),2)=1;

-- 2. ���ڰ����Լ�
-- (1)��ҹ��ڰ���
SELECT UPPER('abcABC') FROM DUAL;
SELECT LOWER('abcABC') FROM DUAL;
SELECT INITCAP('WELCOM TO ORACLE') FROM DUAL;
    -- ex. JOB�� 'manager'�� ������ ��� �ʵ� ���
    SELECT * FROM EMP WHERE UPPER(JOB) = 'MANAGER';
    SELECT * FROM EMP WHERE LOWER(JOB) = 'manager';
    SELECT * FROM EMP WHERE INITCAP(JOB) = 'Manager';

-- (2) ���ڿ���(CONCAT, ||������)
SELECT 'AB'||'CD'||'EF'||'GH' FROM DUAL;
SELECT CONCAT('AB','CD','EF','GH') FROM DUAL; -- �Ұ� CONCAT�� �Ű����� 2����
SELECT CONCAT(CONCAT('AB','CD'), CONCAT('EF','GH')) FROM DUAL;
    -- ex. "�ƹ���(ENAME)�� xx(JOB)�̴�" �������� EMPM ���̺� ���� ���
    SELECT CONCAT(CONCAT(ENAME, '�� '), CONCAT(JOB, '�̴�(��)')) FROM EMP;
    SELECT ENAME || '�� ' || JOB || '�̴�(��)' FROM EMP;
-- (3) SUBSTR(STR, ������ġ, ���ڰ���) ù��°��ġ�� 1, ������ġ ��������
--     SUBSTRB(STR, ���۹���Ʈ��ġ, ���ڹ���Ʈ��)
-- O R A C L E
-- 1 2 3 4 5 6
---6-5-4-3-2-1
SELECT SUBSTR('ORACLE', 3,2) FROM DUAL; -- 3��° ���ں��� 2���� ����
SELECT SUBSTRB('ORACLE', 3, 2) FROM DUAL; -- 3��° ����Ʈ���� 2����Ʈ ����
SELECT SUBSTR('�����ͺ��̽�', 4, 3) FROM DUAL; -- 4��° ���ں��� 3���� ����
SELECT SUBSTRB('�����ͺ��̽�', 4, 3) FROM DUAL; -- 4��° ����Ʈ���� 3����Ʈ ���� (�ѱ� 1���ڴ� 3BYTE)
SELECT SUBSTRB('ȫ�浿', 3, 3) FROM DUAL;
SELECT SUBSTR('ABCDXD', -1, 1) FROM DUAL;
SELECT SUBSTR(123, 2, 1) FROM DUAL; -- ���ڵ� ����
    -- ex. 9���� �Ի��� ����� ��� �ʵ� (��, date ��� format 'RR/MM/DD')
    SELECT * FROM EMP WHERE SUBSTR(HIREDATE, 4, 2) = '09';
    -- ex. 9�Ͽ� �Ի��� ����� ��� �ʵ� (DATA ���� : 'RR/MM/DD')
    SELECT * FROM EMP WHERE SUBSTR(HIREDATE, -2, 2) = '09';

-- (4) ���ڼ�(LENGTH) VS ����Ʈ��(LENGTHB)
SELECT LENGTH('ABC') FROM DUAL;   -- ���ڼ�:3
SELECT LENGTHB('ABC') FROM DUAL;  -- ����Ʈ�� : 3
SELECT LENGTH('����Ŭ') FROM DUAL; -- ���ڼ� : 3
SELECT LENGTHB('����Ŭ') FROM DUAL;-- ����Ʈ�� : 9

-- (5) INSTR(STR, ã������) : STR���� ã�� ������ ��ġ(ù��° 1), ������ 0
--     INSTR(STR, ã������, ������ġ) : STR���� ������ġ���� ã�Ƽ� ã�� ������ ��ġ. ��ġ�� ���� ����
SELECT INSTR('ABCABC','B') FROM DUAL; -- ó������ ã�Ƽ� ó�� ������ B�� ��ġ : 2
SELECT INSTR('ABCABC','B',3) FROM DUAL;-- ��3��°���� ã�Ƽ� ó�� ������ B�� ��ġ : 5
SELECT INSTR('ABCABC','B',-3) FROM DUAL; --��3��°���� �ڿ��� ������ ã�� ó�� ������ B�� ��ġ : 2
    -- ex. 9���� �Ի��� ����� ��� �ʵ�(INSTR) 09/09/09
    SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 4) = 4;
    -- ex. 9�Ͽ� �Ի��� ����� ��� �ʵ�(INSTR) 09/09/09
    SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 7) = 7;
    -- ex. 9�Ͽ� �ƴ� �� �Ի��� ����� ��� �ʵ�(INSTR) 09/09/09
    SELECT * FROM EMP WHERE INSTR(HIREDATE, '09', 7) = 0;
-- (6) LPAD(STR, �ڸ���, ä�﹮��) STR�� �ڸ�����ŭ Ȯ���ϰ� ���� ���ڸ��� ä�� ���� ���
--     RPAD(STR, �ڸ���, ä�﹮��) STR�� �ڸ�����ŭ Ȯ���ϰ� ������ ���ڸ��� ä�� ���� ���
SELECT LPAD('ORACLE', 10, '#') FROM DUAL;
SELECT RPAD('ORACLE', 10, '#') FROM DUAL;
SELECT ENAME, SAL, LPAD(SAL, 6, '*') FROM EMP;
    -- ex. ���, �̸� (7788 S****, 7894 S****, �̸��� �� �ѱ��ڸ� ����ϰ� �������� *) RPAD,LENGTH,SUBSTR
    --     7369 S****
    --     7839 K***
    --     7934 M*****
    SELECT EMPNO, RPAD(SUBSTR(ENAME, 1, 1), LENGTH(ENAME),'*') "NAME" FROM EMP; 
    -- ex. ���, �̸�, �Ի��� (�̸��� 10�ڸ� Ȯ���ϸ鼭 �̸� ���ڼ���ŭ *�� ä������ �Ǹ����� ���ڸ� ���)
    --     7369 SMITH  _____****H  80/12/**   LPAD, SUBSTR, LENGTH, RPAD, TO_CHAR
    --     7499 ALLEN  _____****N  81/02/**
    --     7521 WARD   ______***D  81/22/**
    --     7934 MILLER ____*****R  82/01/**
    SELECT EMPNO, ENAME, LPAD(LPAD(SUBSTR(ENAME, -1, 1), LENGTH(ENAME), '*'), 10, ' ') "NAME",
        TO_CHAR(HIREDATE, 'RR/MM/')||'**' "HIREDATE" FROM EMP;
    SELECT EMPNO, ENAME, LPAD(LPAD(SUBSTR(ENAME, -1, 1), LENGTH(ENAME), '*'), 10, ' ') "NAME",
        RPAD(SUBSTR(HIREDATE, 1, 6), LENGTH(HIREDATE), '*') "HIREDATE" FROM EMP;   
    -- ex. �̸��� ����° �ڸ��� R�� ����� ��� �ʵ�(LIKE ���, INSTR ���, SUBSTR ���)
    SELECT * FROM EMP WHERE ENAME LIKE '__R%';
    SELECT * FROM EMP WHERE INSTR(ENAME, 'R', 3)=3; -- RARA
    SELECT * FROM EMP WHERE SUBSTR(ENAME, 3, 1) ='R';

-- (7) ��������
SELECT TRIM('    ORACLE DB   ') FROM DUAL;
SELECT RTRIM('    ORACLE DB   ') FROM DUAL;
SELECT LTRIM('    ORACLE DB   ') FROM DUAL;

-- (8) 
SELECT REPLACE(ENAME, 'A', 'XX') FROM EMP;
SELECT REPLACE(HIREDATE , '0', ' ') FROM EMP;

-- 3. ��¥�����Լ� �� �����
-- (1) SYSDATE : ����
SELECT SYSDATE FROM DUAL;
ALTER SESSION SET NLS_DATE_FORMAT='RR/MM/DD DY HH24:MI:SS';
SELECT SYSDATE FROM DUAL;
SELECT ENAME, HIREDATE FROM EMP;
ALTER SESSION SET NLS_DATE_FORMAT='RR/MM/DD'; -- ���󺹱�
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD DY HH24:MI:SS') FROM DUAL;
SELECT SYSDATE-1 "�����̽ð�", SYSDATE ����, SYSDATE+1 "�����̽ð�" FROM DUAL;
--(2)��¥��� : 14����
SELECT SYSDATE+14 "�ݳ�������" FROM DUAL;
    -- ex. �̸�, �Ի���, �ٹ��ϼ�
    SELECT ENAME, HIREDATE, FLOOR(SYSDATE-HIREDATE) �ٹ��ϼ� FROM EMP;
    -- ex. �̸�, �Ի���, �ٹ��ּ�, �ٹ����
    SELECT ENAME, HIREDATE, FLOOR((SYSDATE-HIREDATE)/7) �ٹ��ּ�, FLOOR((SYSDATE-HIREDATE)/365) �ٹ����
        FROM EMP;
-- (3)MONTHS_BETWEEN(��¥, ��¥) : �� ��¥���� ������
    -- ex. �̸�, �Ի���, �ٹ�����
    SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) �ٹ����� FROM EMP; 
    -- ex. �̸�, �Ի������� ���� �޿��� ��(�޿��� �Ŵ� sal�� �ް�, COMM�� 1�⿡ 2ȸ ����)
    SELECT ENAME, 
        TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE))*SAL + TRUNC((SYSDATE-HIREDATE)/365)*2*NVL(COMM,0) COST
        FROM EMP;
-- (4) ADD_MONTHS(��¥, ������) : Ư���������� ��� ���� ��¥
    -- ex. �̸�, �Ի���, ���������� (�����Ⱓ�� �Ի��Ϸκ��� 6������ �Ѵ�)
    SELECT ENAME, HIREDATE, ADD_MONTHS(HIREDATE, 6) FROM EMP;
-- (5) LAST_DAY(��¥) : Ư����¥�� ���� ����
SELECT LAST_DAY(SYSDATE) FROM DUAL;
    -- ex. �̸�, �Ի���, ù����(���޳��� ����)
    SELECT ENAME, HIREDATE, LAST_DAY(HIREDATE) FROM EMP;
-- (6) ROUND(��¥, XX) : ��¥ �ݿø� / TRUNC(��¥, XX) :��¥����
SELECT ROUND(34.5678, 2) FROM DUAL;
SELECT ROUND(SYSDATE, 'YEAR') FROM DUAL; -- ��� : ����� 1��1��
SELECT ROUND(SYSDATE, 'MONTH') FROM DUAL; -- ��� : ����� 1�� (1~15���� �̹��� 1��, 16�����Ĵ� ������ 1��)
SELECT ROUND(SYSDATE, 'DAY') FROM DUAL;   -- ��� : ����� �Ͽ���
SELECT ROUND(SYSDATE) FROM DUAL;          -- ��� : ����� 0��
SELECT TO_CHAR(ROUND(SYSDATE),'RR/MM/DD HH24:MI') FROM DUAL; 

SELECT TRUNC(SYSDATE, 'YEAR') FROM DUAL; -- ��� : ���� 1��1��
SELECT TRUNC(SYSDATE, 'MONTH') FROM DUAL; -- ��� : �̹��� 1��
SELECT TRUNC(SYSDATE, 'DAY') FROM DUAL;   -- ��� : ���� �Ͽ���
SELECT TRUNC(SYSDATE) FROM DUAL;          -- ��� : ���� 0��
    -- ex1. �̸�, �Ի���, �Ի��� ���� 5��
    SELECT ENAME, HIREDATE, TRUNC(HIREDATE, 'MONTH')+4 FROM EMP;
    -- ex2. �̸�, �Ի���, ���޳�(���޳��� �Ŵ�16��)
    SELECT ENAME, HIREDATE, ROUND(HIREDATE, 'MONTH')+15 "���޳�" FROM EMP;
    -- ex3. �̸�, �Ի���, ���޳�(���޳��� �Ŵ�15��)
    SELECT ENAME, HIREDATE, ROUND(HIREDATE+1, 'MONTH')+14 "���޳�" FROM EMP;
    -- ex3. �̸�, �Ի���, ���޳�(���޳��� �Ŵ�5��)
    SELECT ENAME, HIREDATE, ROUND(HIREDATE+11, 'MONTH')+4 "���޳�" FROM EMP;
    -- ex3. �̸�, �Ի���, ���޳�(���޳��� �Ŵ�20��)
    SELECT ENAME, HIREDATE, ROUND(HIREDATE-4, 'MONTH')+19 "���޳�" FROM EMP;
-- (7) NEXT_DAY(��¥, '��') : Ư����¥�κ��� ó�� �����ϴ� ������
SELECT SYSDATE, NEXT_DAY(SYSDATE, '��') FROM DUAL;

-- 4. ����ȯ �Լ� (����<->��¥, ����<->����)
-- (1) TO_CHAR(��¥��������, '�������')
    -- YYYY(�⵵4�ڸ�) YY(�⵵2�ڸ�) RR(�⵵2�ڸ�) MM(��) DD(��)  DAY(����) DY(���Ͽ��ǥ��)
    -- AM�̳�PM(����/����) HH12(12�ð�) HH24(24�ð�) MI(��) SS(��)
SELECT TO_CHAR(SYSDATE, 'YY"��"MM"��"DD"��" DY"����" HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YY"��"MM"��"DD"��" DY"����" AM HH12:MI:SS') FROM DUAL;
-- (2) TO_CHAR(���ڵ�����, '�������')
    -- 0 : �ڸ���. ��������� �ڸ����� ������ 0���� ä��
    -- 9 : �ڸ���. ��������� �ڸ����� ���Ƶ� ���ڸ�ŭ�� ���(�Ҽ��� ��)
    -- , : ���ڸ����� , ����
    -- . : �Ҽ���
    -- $ : ��ȭ���� $�� �տ� ���� �� ����
    -- L : ������ȭ������ �տ� ���� �� ����
SELECT TO_CHAR(123456, '9,999,999.99') FROM DUAL;
SELECT TO_CHAR(123456, '0,000,000.00') FROM DUAL;
SELECT TO_CHAR(10000, 'L999,999') FROM DUAL;
SELECT ENAME, TO_CHAR(SAL, '$99,999') FROM EMP;
SELECT ENAME, TO_CHAR(SAL, '$00,999') FROM EMP;
-- TO_DATE(���ڵ�����, '����')
SELECT TO_DATE('2022-0412', 'YYYY-MMDD') FROM DUAL;
    -- ex. 81/5/1 ~ 83/5/1 ���̿� �Ի��� ������ ��� �ʵ�(TO_DATA ���)
SELECT * FROM EMP 
    WHERE HIREDATE BETWEEN TO_DATE('810501','RRMMDD') AND TO_DATE('83/05/01','RR/MM/DD');
-- (4) TO_NUMBER(����, '����')
SELECT '1234'+1 FROM DUAL;
SELECT TO_NUMBER('1,234','9,999')+1 FROM DUAL;

-- 5. NVL(���ϼ����ִµ�����, ���̸����Ұ�) - �Ű����� 2���� Ÿ�� ��ġ
SELECT ENAME, NVL(COMM, 0) FROM EMP;
    -- ex. �̸�, ����ǻ��(MGR)�� ����ϵ�, ����ǻ���� NULL�� ��� 'CEO'�� ��� ���
    SELECT ENAME, NVL(TO_CHAR(MGR), 'CEO') FROM EMP;

-- 6. ETC
-- (1) EXTRACT ; �⵵�� ���̳� ��¥�� ���ڷ� �����ϰ��� �� ��
SELECT EXTRACT(YEAR FROM SYSDATE) FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY') FROM DUAL;
SELECT EXTRACT(MONTH FROM HIREDATE) FROM EMP;
SELECT EXTRACT(DAY FROM HIREDATE) FROM EMP;
    -- 2���� �Ի��� ������ ��� �ʵ�
    SELECT * FROM EMP WHERE HIREDATE LIKE '__/02/__';
    SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '02';
    SELECT * FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE) = 2;
    -- 81�⵵�� �Ի��� ������ ��� �ʵ�
    SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'YYYY')='1981';
    SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'RR')='81';
    SELECT * FROM EMP WHERE EXTRACT(YEAR FROM HIREDATE)=1981;
-- (2) ������ ���(������ ���) : LEVEL, START WITH ����(MGR IS NULL), CONNECT BY PRIOR ����(EMPNO=MGR)
SELECT LEVEL, LPAD('��', LEVEL*2)||ENAME
    FROM EMP
    START WITH MGR IS NULL
    CONNECT BY PRIOR EMPNO=MGR;

-- <�� ��������>
-- 1. ���� ��¥�� ����ϰ� TITLE�� ��Current Date���� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT SYSDATE "Current Date" FROM DUAL;

-- 2. EMP ���̺��� ���� �޿��� 15%�� ������ �޿��� ����Ͽ�,
    -- �����ȣ,�̸�,����,�޿�,������ �޿�(New Salary),������(Increase)�� ����ϴ� SELECT ����
SELECT EMPNO, ENAME, JOB, SAL, SAL*1.15 "NewSalary", SAL*0.15 "Increase" FROM EMP;
    
--3. �̸�, �Ի���, �Ի��Ϸκ��� 6���� �� ���ƿ��� ������ ���Ͽ� ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, HIREDATE, NEXT_DAY(ADD_MONTHS(HIREDATE, 6), '��') "6MonthsLaterMon" FROM EMP;

--4. �̸�, �Ի���, �Ի��Ϸκ��� ��������� ������, �޿�, �Ի��Ϻ��� ��������� ���� �޿��� �Ѱ踦 ���
SELECT ENAME, HIREDATE, 
        TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) MONTHS, SAL, 
        ROUND(MONTHS_BETWEEN(SYSDATE, HIREDATE)*SAL,2) SUM_SAL 
    FROM EMP;
    
SELECT ENAME, HIREDATE, 
    TRUNC(MONTHS_BETWEEN(SYSDATE, HIREDATE)) MONTHS, SAL, 
    TO_CHAR(ROUND(MONTHS_BETWEEN(SYSDATE, HIREDATE),2)*SAL, '$99,999,999.99') SUM_SAL
    FROM EMP;
    
--5. ��� ����� �̸��� �޿�(15�ڸ��� ��� ������ �� ���� ��*���� ��ġ)�� ���
SELECT ENAME, LPAD(SAL, 15, '*') FROM EMP;

--6. ��� ����� ������ �̸�,����,�Ի���,�Ի��� ������ ����ϴ� SELECT ������ ����Ͻÿ�.
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DAY') DAY from EMP;
SELECT ENAME, JOB, HIREDATE, TO_CHAR(HIREDATE, 'DY"����"') DAY from EMP;

--7. �̸��� ���̰� 6�� �̻��� ����� ������ �̸�,�̸��� ���ڼ�,������ ���
SELECT ENAME, LENGTH(ENAME), JOB FROM EMP WHERE LENGTH(ENAME)>= 6;

--8. ��� ����� ������ �̸�, ����, �޿�, ���ʽ�, �޿�+���ʽ��� ���
SELECT ENAME, JOB, SAL, COMM, SAL+NVL(COMM,0) "SAL_COMM" FROM EMP;

-- 9.��� ���̺��� ������� 2��° ���ں��� 3���� ���ڸ� �����Ͻÿ�. 
SELECT  ENAME, SUBSTR(ENAME, 2,3) FROM EMP;

--10. ��� ���̺��� �Ի����� 12���� ����� ���, �����, �Ի����� �˻��Ͻÿ�. 
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE HIREDATE LIKE '%/12/%';
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE SUBSTR(HIREDATE, 4, 2)='12'; 
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE INSTR(HIREDATE, '12', 4)=4;
  --  �ý��ۿ� ���� DATE FORMAT �ٸ� �� �����Ƿ� �Ʒ��� ��� ��õ
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE EXTRACT(MONTH FROM HIREDATE)=12;
SELECT EMPNO, ENAME, HIREDATE FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '12';

--11. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
--EMPNO		ENAME		�޿�
--7369		SMITH		*******800
--7499		ALLEN		******1600
--7521		WARD		******1250
--����. 
SELECT EMPNO, ENAME, LPAD(SAL, 10, '*') �޿� FROM EMP;

-- 12. ������ ���� ����� �˻��� �� �ִ� SQL ������ �ۼ��Ͻÿ�
-- EMPNO	 ENAME 	�Ի���
-- 7369	  SMITH		1980-12-17
-- ��.
SELECT EMPNO, ENAME, TO_CHAR(HIREDATE, 'YYYY-MM-DD') �Ի��� FROM EMP;

--13. ��� ���̺��� �μ� ��ȣ�� 20�� ����� ���, �̸�, ����, �޿��� ����Ͻÿ�.
    --(�޿��� �տ� $�� �����ϰ�3�ڸ����� ,�� ����Ѵ�)
DESC EMP; 
SELECT EMPNO, ENAME, JOB, TO_CHAR(SAL, '$99,999') FROM EMP WHERE DEPTNO=20;