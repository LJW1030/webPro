DROP TABLE MEMBER CASCADE CONSTRAINTS;
CREATE TABLE MEMBER(
    ID VARCHAR2(30) PRIMARY KEY,
    PW VARCHAR2(30) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    BIRTH DATE,
    RDATE DATE DEFAULT SYSDATE NOT NULL);
-- 회원가입
INSERT INTO MEMBER (ID, PW, NAME, BIRTH)
    VALUES ('aaa','1','이일일','1998-12-12');
INSERT INTO MEMBER (ID, PW, NAME, BIRTH)
    VALUES ('bbb','1','김길길',to_date('1990-10-10', 'yyyy-mm-dd'));
-- 회원리스트
SELECT * FROM MEMBER;
COMMIT;