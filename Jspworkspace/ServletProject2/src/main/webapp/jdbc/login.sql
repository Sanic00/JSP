select*from tab;

create table tempmember (
id varchar2(20)not null,
passwd varchar2(20),
name varchar2(20),
mem_num1 varchar2(6),
mem_num2 varchar2(7),
e_mail varchar2(50),
phone varchar2(30),
zipcode varchar2(7),
address varchar2(80),
job varchar2(30), 
primary key(id)

);

select * from tempmember;

insert into tempmember values('aaaa', '1111', '홍길동', '123456', '7654321', 'hong@never.com', '010-0000-0000', '12345', '대구특별시 수성구 어딘지 몰루?' , '(짭)프로그래머');
insert into tempmember values('bbbb', '2222', '손고쿠', '156656', '7667321', 'son@never.com', '010-0020-0000', '12375', '부산특별시 수성구 어딘지 몰루?' , '(짭)프로그래머');
insert into tempmember values('cccc', '3333', '손고한', '111156', '7899321', 'go@never.com', '010-1230-0500', '11335', '부산특별시 해운대해운대' , '(짭)프로그래머');



