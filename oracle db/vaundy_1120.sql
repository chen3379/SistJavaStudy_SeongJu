--PreparedStatement 예제를 위한 테이블

create table MyMallIpgo(num number primary key, category VARCHAR2(20),sangpum varchar2(20),su number(5),price number(5),ipgo date);

select * from mymallipgo;

select * from mymallipgo where sangpum like '%코%';

create table mystudentinfo(stu_no number primary key,
stu_name VARCHAR2(20),
stu_addr varchar2(20),
stu_grade number(20),
stu_blood varchar2(20),
stu_birth varchar2(20));