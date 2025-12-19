use test;

create table info(num int auto_increment primary key,
name varchar(20),
hp varchar(20),
age smallint,
photo varchar(100));

insert into info (name,hp,age,photo) values ('김성주','010-1234-5678',22,'../image/만화이미지/01.png');
insert into info (name,hp,age,photo) values ('고윤정','010-3453-5435',26,'../image/만화이미지/02.png');
insert into info (name,hp,age,photo) values ('지창욱','010-5675-2343',31,'../image/만화이미지/03.png');
insert into info (name,hp,age,photo) values ('조이현','010-6575-2342',28,'../image/만화이미지/04.png');
insert into info (name,hp,age,photo) values ('이광수','010-5464-3462',33,'../image/만화이미지/05.png');


select * from info;

create table team(num int auto_increment primary key,
name varchar(20),
driver varchar(20),
addr varchar(20),
writeday date);

insert into team (name, driver, addr, writeday) values ('이광수','있음','서울',now());
insert into team (name, driver, addr, writeday) values ('지창욱','없음','인천',now());
insert into team (name, driver, addr, writeday) values ('고윤정','있음','경기',now());
insert into team (name, driver, addr, writeday) values ('김성주','있음','부산',now());
insert into team (name, driver, addr, writeday) values ('조이현','없음','수원',now());

select * from team;
