-- ���̺� ���� (JOB -> PERSON / ���� �̸��� ���̺��� �����Ǿ��� ��� DROP : PERSON ->JOB)
DROP TABLE JOB;
CREATE TABLE JOB (
        jNO NUMBER(2) PRIMARY KEY,
        jNAME VARCHAR2(30) NOT NULL
        );
CREATE TABLE PERSON (
        pNO NUMBER(5) PRIMARY KEY,
        pNAME VARCHAR2(30),
        jNO NUMBER(2) REFERENCES JOB(jNO),
        KOR NUMBER(3),
        ENG NUMBER(3),
        MAT NUMBER(3)
        );
CREATE SEQUENCE PER_SEQ
        MAXVALUE 99999
        NOCACHE
        NOCYCLE;
-- ���̵�����(JOB -> PERSON)
INSERT INTO JOB VALUES (10, '���');
INSERT INTO JOB VALUES (20, '����');
SELECT * FROM JOB;
INSERT INTO PERSON VALUES (PER_SEQ.NEXTVAL, '���켺', 10, 90, 80, 81);
INSERT INTO PERSON VALUES (PER_SEQ.NEXTVAL, '�ڼ���', 10, 80, 90, 80);
INSERT INTO PERSON VALUES (PER_SEQ.NEXTVAL, '�����', 20, 20, 90, 90);
INSERT INTO PERSON VALUES (PER_SEQ.NEXTVAL, '����', 20, 95, 95, 95);
INSERT INTO PERSON VALUES (PER_SEQ.NEXTVAL, '������', 10, 100, 100, 100);
SELECT * FROM PERSON;
COMMIT;
-- 1�� : PNAME, JNAME, KOR, ENG, MAT�� �Է¹޾� INSERT
INSERT INTO PERSON 
    VALUES (PER_SEQ.NEXTVAL, 'ȫ�浿', (SELECT JNO FROM JOB WHERE JNAME='����'), 81,83,85);

-- 2�� : �������� �Է¹޾� ���,�̸�(pNO),������,����(kor),����(eng),����(mat),������ ���(������������ �������� ����)
SELECT PNAME||'('||PNO||'��)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
    FROM PERSON P, JOB J
    WHERE P.JNO=J.JNO AND JNAME='���'
    ORDER BY SUM DESC; -- FROM���� SUBQUERY(INLINE VIEW)�� �� ����
SELECT ROWNUM RANK, A.*
    FROM (SELECT PNAME||'('||PNO||'��)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
            FROM PERSON P, JOB J
            WHERE P.JNO=J.JNO AND JNAME='���'
            ORDER BY SUM DESC) A ; -- 2�� ��ɿ� �� QUERY

-- 3�� : ��� ���� ���, �̸�(pNO),������,����(kor),����(eng),����(mat),������ ���(������������ �������� ����)
SELECT ROWNUM RANK, A.*
    FROM (SELECT PNAME||'('||PNO||'��)' PNAME, JNAME, KOR, ENG, MAT, KOR+ENG+MAT SUM
            FROM PERSON P, JOB J
            WHERE P.JNO=J.JNO
            ORDER BY SUM DESC) A ;