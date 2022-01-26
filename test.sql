
SELECT * FROM 
(SELECT rownum rnum, num, writer, title, writeDay, readCnt, repIndent FROM 
(SELECT * FROM posting ORDER BY repRoot desc, repStep asc))

DROP TABLE information
DROP TABLE notice
DROP TABLE posting
DROP TABLE member
DROP TABLE users
DROP TABLE board

CREATE TABLE board(
num NUMBER(10),
board VARCHAR2(30) NOT NULL,
CONSTRAINT pk_board_num PRIMARY KEY(num)
)

CREATE TABLE information(
num NUMBER,
writer VARCHAR2(30) NOT NULL,
title VARCHAR2(150) NOT NULL,
content VARCHAR2(3000) ,
writeday DATE DEFAULT SYSDATE,
readcnt NUMBER DEFAULT 0,
repRoot NUMBER,
repStep NUMBER,
repIndent NUMBER,
CONSTRAINT pk_information_num PRIMARY KEY(num),
CONSTRAINT fk_information_writer FOREIGN KEY(writer) REFERENCES member(id) ON DELETE CASCADE
)


CREATE TABLE notice(
num NUMBER,
writer VARCHAR2(30) NOT NULL,
title VARCHAR2(150) NOT NULL,
content VARCHAR2(3000) NOT NULL,
writeday DATE DEFAULT SYSDATE,
readcnt NUMBER DEFAULT 0,
CONSTRAINT pk_notice_num PRIMARY KEY(num),
CONSTRAINT fk_notice_writer FOREIGN KEY(writer) REFERENCES member(id) ON DELETE CASCADE
);

CREATE TABLE posting(
num NUMBER,
writer VARCHAR2(30) NOT NULL,
title VARCHAR2(150) NOT NULL,
content VARCHAR2(3000) NOT NULL, 
writeday DATE DEFAULT SYSDATE,
readcnt NUMBER DEFAULT 0,
repRoot NUMBER,
repStep NUMBER,
repIndent NUMBER,
CONSTRAINT pk_posting_num PRIMARY KEY(num),
CONSTRAINT fk_posting_writer FOREIGN KEY(writer) REFERENCES member(id) ON DELETE CASCADE
);



CREATE TABLE member(
id VARCHAR2(30) NOT NULL,
pw VARCHAR2(30) NOT NULL,
name VARCHAR2(30),
birthday DATE,
address VARCHAR2(300),
gender VARCHAR2(30),
email VARCHAR2(150),
phone NUMBER(11),
role VARCHAR2(30),
CONSTRAINT pk_member_id PRIMARY KEY(id),
CONSTRAINT fk_member_role FOREIGN KEY(role) REFERENCES users(role) ON DELETE CASCADE
);

CREATE TABLE users(
num NUMBER(6),
role VARCHAR2(30),
CONSTRAINT pk_users_role PRIMARY KEY(role)
);

INSERT INTO users values (3, 'admin')
INSERT INTO users values (2, 'manager')
INSERT INTO users values (1, 'guest')

INSERT INTO member values ('admin', 1111, '경영자', '2000-11-11', '주소', '남성', 'admin@admin.com', 19283746, 'admin')
 

SELECT * FROM member
SELECT * FROM posting
SELECT * FROM users

CREATE SEQUENCE seq_information_num
CREATE SEQUENCE seq_board_num
CREATE SEQUENCE seq_notice_num;
CREATE SEQUENCE seq_posting_num

DROP SEQUENCE seq_information_num
DROP SEQUENCE seq_board_num
DROP SEQUENCE seq_notice_num
DROP SEQUENCE seq_posting_num

SELECT * FROM member




BEGIN
DECLARE i INT DEFAULT 1;
WHILE(i<100) DO
INSERT INTO member (id, pw, name, birthday, address, gender, email, phone, role) 
value ('client'i, 1111, '홍길동'i, '2000-11-11', '주소', '남성', 'admin@admin.com', 19283746, 'guest');
SET i = i + 1;
END WHILE;
End


