DROP TABLE BOARD;
CREATE TABLE BOARD(
    NUM NUMBER(5,0) PRIMARY KEY, -- 글번호
    WRITER VARCHAR2(30) NOT NULL, -- 글작성자
    SUBJECT VARCHAR2(100) NOT NULL, -- 글제목
    CONTENT VARCHAR2(4000) NOT NULL, -- 본문
    EMAIL VARCHAR2(30),
    READCOUNT NUMBER(5) DEFAULT 0, -- 글 HIT수(조회수)
    PW VARCHAR2(30)  NOT NULL, -- 글 삭제시 쓸 비밀번호
    REF NUMBER(5,0) NOT NULL, -- 글 그룹(원글일 경우 글번호로 / 답변글일 경우 원글의 글번호로
    RE_STEP NUMBER(5) NOT NULL, -- 그릅내 출력 순서 (원글 0)
    RE_INDENT NUMBER(5) NOT NULL, -- 글 LIST 출력시 제목 들여쓰기 정도(원글0)
    IP VARCHAR2(20) NOT NULL, -- 글 작성시 컴퓨터 IP주소
    RDATE DATE DEFAULT SYSDATE -- 글쓴 시점
    );
    -- 글 갯수
    SELECT COUNT(*) FROM BOARD;
    
    -- 글 목록(최신글부터)
    SELECT * FROM BOARD ORDER BY REF DESC, RE_STEP;
    
    --글 목록(페이징)
    SELECT * FROM (SELECT ROWNUM RN, A.* FROM
            (SELECT * FROM BOARD ORDER BY REF DESC)A)
            WHERE RN BETWEEN 2 AND 3;
    -- 글쓰기(원글)
        --글쓰기시 글번호 생성
        SELECT NVL(MAX(NUM), 0)+1 FROM BOARD;
    INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
        VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '이일일', '글제목1', '본문내용\n안녕하세요', NULL, '111', (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '111.111.11.1');
    INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
        VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '김길길', '글제목2', '본문내용', NULL, '111', (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '111.111.11.1');
    INSERT INTO BOARD (NUM, WRITER, SUBJECT, CONTENT, EMAIL, PW, REF, RE_STEP, RE_INDENT, IP)
        VALUES ((SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), '박발발', '글제목3', '본문내용', NULL, '111', (SELECT NVL(MAX(NUM), 0)+1 FROM BOARD), 0, 0, '111.111.11.1');
        
    -- 글번호로 글 가져오기
    SELECT * FROM BOARD WHERE NUM=1;
    
    -- 조회수 올리기
    UPDATE BOARD SET READCOUNT = READCOUNT+1 WHERE NUM=1;
    
    -- 글 수정
    UPDATE BOARD SET SUBJECT = '수정된제목1',
                                    CONTENT = '수정된 본문',
                                    EMAIL = 'LEE@naver.com',
                                    PW = '111',
                                    IP = '127.0.0.1'
                                WHERE NUM = 1;
    
    COMMIT;            
    -- 글 삭제
    DELETE FROM BOARD WHERE NUM =1 AND PW='111';
    
    SELECT * FROM BOARD;
    ROLLBACK;
    
    -- 조회수 조작
    UPDATE BOARD SET READCOUNT = 12 WHERE NUM = 2;
    COMMIT;