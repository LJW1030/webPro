-- ★★Member.xml(회원가입, id중복체크, id로 memberDto로 가져오기, 로그인, 정보수정)
-- idConfirm
SELECT * FROM MEMBER WHERE mID = 'aaa';
-- joinMember
INSERT INTO MEMBER VALUES ( 'bbb', '1', '김고객', 'go@naver.com', '43168', '제주도');
-- getDetailMember
SELECT * FROM MEMBER WHERE mID = 'bbb';
-- modifyMember
UPDATE MEMBER SET mPW='1',
                                    mNAME='김수정',
                                    mMAIL='kim@naver.com',
                                    mPOST='43311',
                                    mADDR='완주'
                                WHERE mID='bbb';
-- ★★Book.xml (페이징없이 신규순list, 페이징포함된 도서보기(책이름순), 책갯수, 상세보기, 도서등록, 도서수정)
-- mainList
SELECT * FROM BOOK ORDER BY bRDATE;
-- bookList
SELECT * FROM(SELECT ROWNUM RN, A.* FROM
    (SELECT * FROM BOOK ORDER BY BTITLE)A)
    WHERE RN BETWEEN 2 AND 3;
-- totCntBook
SELECT COUNT(*) FROM BOOK;
-- getDetailBook
SELECT * FROM BOOK WHERE bNUM='1';
-- registerBook
INSERT INTO BOOK (bNUM, bTITLE, bWRITER, bRDATE, bIMG1, bIMG2, bINFO) 
        VALUES (BOOK_SQ.NEXTVAL, '책이오', '김오이', SYSDATE, 'noImg.png', 'noImg.png', '책이란?');
-- modifyBook
UPDATE BOOK SET bTITLE='수정책',
                                bWRITER='박수정',
                                bRDATE='2020/08/20',
                                bIMG1= 'noImg.png',
                                bIMG2= 'noImg.png',
                                bINFO='수정된책'
                            WHERE bNUM=3;
                            
COMMIT;