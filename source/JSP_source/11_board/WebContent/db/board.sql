DROP TABLE BOARD;
CREATE TABLE BOARD(
    NUM NUMBER(5,0) PRIMARY KEY, -- �۹�ȣ
    WRITER VARCHAR2(30) NOT NULL, -- ���ۼ���
    SUBJECT VARCHAR2(100) NOT NULL, -- ������
    CONTENT VARCHAR2(4000) NOT NULL, -- ����
    EMAIL VARCHAR2(30),
    READCOUNT NUMBER(5) DEFAULT 0, -- �� HIT��(��ȸ��)
    PW VARCHAR2(30)  NOT NULL, -- �� ������ �� ��й�ȣ
    REF NUMBER(5,0) NOT NULL, -- �� �׷�(������ ��� �۹�ȣ�� / �亯���� ��� ������ �۹�ȣ��
    RE_STEP NUMBER(5) NOT NULL, -- �׸��� ��� ���� (���� 0)
    RE_INDENT NUMBER(5) NOT NULL, -- �� LIST ��½� ���� �鿩���� ����(����0)
    IP VARCHAR2(20) NOT NULL, -- �� �ۼ��� ��ǻ�� IP�ּ�
    RDATE DATE DEFAULT SYSDATE -- �۾� ����
    );
    -- �� ����
    SELECT COUNT(*) FROM BOARD;
    
    -- �� ���(�ֽűۺ���)
    SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP;
    
    --�� ���(����¡)
    SELECT * FROM (SELECT ROWNUM RN, A.* FROM
            (SELECT * FROM BOARD ORDER BY REF DESC)A)
            WHERE RN BETWEEN 2 AND 3;
    -- �۾���(����)
        --�۾���� �۹�ȣ ����
        SELECT NVL(MAX(NUM), 0)+1 FROM BOARD;
    INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
        VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '������', '������1', '��������\n�ȳ��ϼ���', NULL, '111', (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '111.111.11.1');
    INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
        VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '����', '������2', '��������', NULL, '111', (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '111.111.11.1');
    INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
        VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '�ڹ߹�', '������3', '��������', NULL, '111', (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '111.111.11.1');
        
    -- �۹�ȣ�� �� ��������
    SELECT * FROM BOARD WHERE NUM=1;
    
    -- ��ȸ�� �ø���
    UPDATE BOARD SET READCOUNT = READCOUNT+1 WHERE NUM=1;
    
    -- �� ����
    UPDATE BOARD SET SUBJECT = '����������1',
                                    CONTENT = '������ ����',
                                    EMAIL = 'LEE@naver.com',
                                    PW = '111',
                                    IP = '127.0.0.1'
                                WHERE NUM = 1;
    
    COMMIT;            
    -- �� ����
    DELETE FROM BOARD WHERE NUM =1 AND PW='111';
    
    SELECT * FROM BOARD;
    ROLLBACK;
    
    -- ��ȸ�� ����
    UPDATE BOARD SET READCOUNT = 12 WHERE NUM = 2;
    COMMIT;