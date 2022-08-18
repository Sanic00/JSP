select * from tab;


/*
 * 시퀀스 = 번호를 자동으로 
 * num 글의 번호
 * writer 작성자 
 * 이메일 
 * subject 제목
 * pass 패스워드
 * readcount 조회수
 * ref 부모글 참조
 * step 글이 있을때 답변글 ↘
 * depth 깊이  답변 ↘↘ 이러면 깊이가 2개  
 * regdate 작성 날짜
 * content 게시글 내용
 */

create table board(
num         number(7) not null,
writer      varchar2(15) not null,
email      varchar2(30) not null,
subject      varchar2(50) not null,
pass         varchar2(10)    not null,
readcount   number(5) default 0 not null,
ref         number(5) default 0 not null,
step         number(3) default 0 not null,
depth      number(3) default 0 not null,
regdate      timestamp(6) default sysdate not null,
content    varchar2(4000) not null,
ip            varchar2(20) not null,
constraint board_pk primary key(num)
);

create sequence board_seq
start with 1
increment by 1
nomaxvalue
nocache
nocycle;

