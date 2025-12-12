create table fifarank(name varchar2(20),rank NUMBER(10));
select * from tab;
select * from fifarank;

create SEQUENCE seq1;

create table hello(num number(3) primary key, name varchar2(20),age number(5),writeday date);

select * from hello;

insert into hello values(seq1.nextval, '홍길동',33,sysdate);
commit;

create table myclub(cno number(3) primary key,cname VARCHAR2(20), caddr VARCHAR2(20),cjob VARCHAR2(20),chp VARCHAR2(20),gaipday date);

SELECT * FROM myclub;
--회원명 주소 직업 핸드폰
insert into myclub values(seq1.nextval,'고윤정','강남','배우','010-1242-3245',sysdate);
insert into myclub values(seq1.nextval,'추성훈','도쿄','운동선수','010-5372-9324',sysdate);
insert into myclub values(seq1.nextval,'바운디','오사카','가수','010-8564-1578',sysdate);
insert into myclub values(seq1.nextval,'조이현','강동','배우','010-4286-2131',sysdate);
insert into myclub values(seq1.nextval,'고경표','부산','배우','010-2485-2852',sysdate);
insert into myclub values(seq1.nextval,'임우일','구리','개그맨','010-9752-1456',sysdate);

update myclub set cname='조이현',caddr='LA',cjob='배우',chp=010-3245-4366 where cno=10;