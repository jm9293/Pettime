
--유저데이터 DML--
INSERT INTO PETTIME.USERDATA
(ID, PASSWORD, NAME, PHONE, EMAIL, ENABLED)
VALUES('ryu5986', '개똥꼬','a12345', '01088175986', 'ryu5986@naver.com', '1');
--개데이터 DML--
INSERT INTO PETTIME.PETDATA
(USERID, NAME, "TYPE", KIND, MEMO, STATE)
VALUES('ryu5986', '빡세다', '견', '중형견', '짖음', '1');
--디자이너데이터 DML--
INSERT INTO PETTIME.DESIGNER
(ID, PASSWORD, NAME, EMAIL, PHONE, INTRO, ENABLED)
VALUES('seon0216', 'a12345', '에리카', 'aaa1234@naver.com', '01012345678', '하이하이', '1');

--예약데이터 DML--
INSERT INTO PETTIME.RESLIST
(STIME, ETIME, ADDRESS, USERID, DEGID, PETNUM, TPRICE, STATE)
VALUES('2020-12-01', '2020-12-01', '강서구', 'ryu5986', 'seon0216', 1, 30000, '예약');

SELECT COUNT(*) FROM PETTIME.RESLIST WHERE TO_CHAR(STIME,'YYYYMMDD') = TO_CHAR(SYSDATE,'YYYYMMDD');

