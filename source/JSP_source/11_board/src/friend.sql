DROP TABLE FRIEND;
CREATE TABLE FRIEND(
        NO NUMBER(2) PRIMARY KEY,
        FNAME VARCHAR2(10) NOT NULL,
        TEL VARCHAR2(20)
        );
CREATE SEQUENCE F_SEQ
        MAXVALUE 99
        NOCACHE
        NOCYCLE;
        
SELECT * FROM FRIEND;

INSERT INTO FRIEND VALUES (F_SEQ.NEXTVAL, '이진우', '010-1234-1234');

SELECT * FROM FRIEND WHERE FNAME LIKE '%'||'이'||'%' AND TEL LIKE '%'||1||'%';