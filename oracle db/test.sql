--test계정에서 테이블을 만들어보기

--테이블 확인
select * from tab;

CREATE table test(name varchar2(10) null);

--테이블 생성 [basic]
--primary key : 기본키 - unique + not null
--num은 기본키이기 때문에 두 번 넣으면 무결성 제약조건에 어긋나서 오류 발생
create table basic(num number(5) primary key not null, name varchar2(20), score number(6,2),birthday date);

select * from tab;

--basic테이블의 구조확인
desc basic;

--테이블 확인
select * from basic;
alter table basic rename column birthday to birth;
select * from basic;

--basic테이블에 전체 데이터 insert하기
insert into basic values(1,'김성주',100,'2000-04-25');
select * from basic;

update basic set score='300' where score='100';
insert into basic values(2, '고윤정',100,'1999-05-11');
insert into basic values(4, '장원영',95,'2001-03-20');
insert into basic values(3,'이도현',null,'1995-11-23');

--basic테이블에 일부 데이터 insert하기
insert into basic (num,name)values(6,'Vaundy');
select * from basic;
insert into basic values(9,'Son',null,'1995-07-17');

--basic테이블의 일부만 조회
select name,score from basic;
select name,birth from basic;

--sysdate : 현재 날짜
insert into basic values(16,'이정재',77.7,sysdate);

--column 추가
alter table basic add age number(5);

select * from basic;

--insert into basic age values(age,16);
--default로 값 지정해서 컬럼추가 가능
alter table basic add addr varchar(20) default '강남구';

--주소 컬럼을 데이터타입을 20에서 30으로 변경
alter table basic modify addr varchar(30);
desc basic; --테이블 구조 확인 가능

--메모리에 시퀀스를 미리 할당(cache)혹은 할당하지않음(nocache)

--시퀀스 기본으로 생성..1부터 1씩 증가하는 시퀀스 생성됨
create sequence seq1;

--전체 시퀀스 확인
select * from seq;

--시퀀스에서 다음 시퀀스 발생해서 콘솔에 출력
select seq1.nextval from dual;

--시퀀스에서 마지막 발생한 값
select seq1.currval from dual;

--seq1시퀀스 삭제
drop SEQUENCE seq1;
select * from seq;

--10부터 5씩 증가하는 시퀀스 생성 - cache 값은 삭제
create SEQUENCE seq1 start with 10 INCREMENT by 5 nocache;

--시퀀스 발생
select seq1.nextval from dual;

select seq1.currval from dual;

--시퀀스 삭제
drop sequence seq1;

--seq1 : 시작값 5 증가값 5 캐시 no
create SEQUENCE seq1 start with 5 increment by 5 nocache;
--seq2 : 시작값 1 증가값 2
create SEQUENCE seq2 start with 1 increment by 2;
--seq3 : 시작값 1 증가값 1 캐시 no
create SEQUENCE seq3 start with 1 increment by 1 nocache;
--seq는 기본값이므로 create SEQUENCE seq3 nocache; 로 생성해도 같음

select * from seq;
--출력
select seq1.nextval,seq2.nextval,seq3.nextval from dual;

select seq1.currval,seq2.currval,seq3.currval from dual;

--seq1,seq2,seq3 삭제
drop sequence seq1;
drop sequence seq2;
drop sequence seq3;

--시퀀스 생성 후 테이블 생성하고 기본키 발생시킬 때 시퀀스 적용해보기

--시퀀스 생성 seq_test
create SEQUENCE seq_test;

--테이블 생성 person
create table person (num number(5) primary key ,name VARCHAR2(20),job varchar2(20),gender varchar(10),age number(3),hp varchar2(20),birth date);

select * from person;

--구조확인
desc person;

--birth를 ipsaday로 바꿔보자
--alter table [테이블명] rename column [old컬럼명] to [new컬럼명];
alter table person rename column birth to ipsaday;

desc person; -- birth에서 ipsaday로 컬럼명 변경 확인

--조회 연습을 위해서 10개 이상 데이터 추가(시퀀스 추가)_요리사,교사,개발자
insert into person values(seq_test.nextval,'고윤정','배우','여자',28,'010-4123-1241','2020-12-23');
insert into person values(seq_test.nextval,'이도현','교사','남자',30,'010-3243-1123','2023-01-22');
insert into person values(seq_test.nextval,'정형돈','요리사','남자',38,'010-5623-1141','2021-07-23');
insert into person values(seq_test.nextval,'손흥민','개발자','남자',34,'010-4853-1541','2019-11-13');
insert into person values(seq_test.nextval,'지수','요리사','여자',27,'010-4124-2341','2005-10-03');
insert into person values(seq_test.nextval,'김민재','개발자','남자',29,'010-1223-1261','2023-05-03');
insert into person values(seq_test.nextval,'야마모토','교사','남자',25,'010-2323-1245','2017-06-08');
insert into person values(seq_test.nextval,'오타니','요리사','남자',31,'010-8723-1278','2019-03-17');
insert into person values(seq_test.nextval,'프리먼','교사','남자',33,'010-8123-2241','2022-09-25');
insert into person values(seq_test.nextval,'김연경','개발자','여자',33,'010-9523-7241','2024-04-28');
insert into person values(seq_test.nextval,'아이유','배우','여자',23,'010-7123-6241','2025-02-22');

--생성 후 최종 저장
commit; --commit을 해야 반영이 되기 때문에 필수

--person 테이블 조회
select * from person;

--person 인원수 조회
select count(*) from person;

--이름 오름차순 출력
select * from person order by name;

--나이의 역순으로 출력
select * from person order by age desc;

--성별의 오름차순, 같을 경우 이름의 오름차순
select * from person order by gender,name;

--중복되지 않게 직업의 종류만 출력
select distinct job 직업 from person;

--성이 이씨인 사람만 출력
select * from person where name like '이%';

--핸드폰이 010으로 시작하는 사람 출력
select * from person where hp like '010%';

--입사월이 10월인 사람 출력
select * from person where to_char(ipsaday,'mm')=10;

--입사연도가 2025년도만 출력
select * from person where to_char(ipsaday,'yy')=25;

--나이가 20~25세 사이(AND)
select * from person where age>=20 and age<=25;

--나이가 20~25세 사이(between)
select * from person where age between 20 and 25;

--직업이 교사이거나 배우인 사람 출력(IN)
select * from person where job in('교사','배우');

--직업이 교사이거나 개발자인 사람 출력(OR)
select * from person where job ='교사' or job ='개발자';

--직업이 교사,개발자를 제외한 직업을 가진 사람 조회
select * from person where job not in('교사', '개발자');

--person테이블에 데이터 추가
INSERT INTO person 
VALUES (seq_test.NEXTVAL, '박보영', '배우', '여자', 34, '010-7312-8820', '24-08-19');

INSERT INTO person 
VALUES (seq_test.NEXTVAL, '백종원', '요리사', '남자', 58, '010-9321-4478', '22-11-03');

INSERT INTO person 
VALUES (seq_test.NEXTVAL, '이수현', '개발자', '여자', 29, '010-5123-9682', '23-06-21');

INSERT INTO person 
VALUES (seq_test.NEXTVAL, '정우성', '교사', '남자', 43, '010-7834-2157', '25-02-14');

-- update문 
-- update [테이블명] set [컬럼명]=[데이터값] where 조건;
update person set age='27' where name ='정우성';
select * from person where name = '정우성';

--수정한 컬럼의 한열 전부 수정
update person set job='간호사',age=33;

--rollback : 잘못 수정된 데이터 원래대로 복구
rollback;

--시퀀스 3번만 바꾸기
update person set job='개그맨',age=33 where num='3';

--정씨이면서 개그맨인 사람의 성별을 여자로 수정
update person set gender='여자' where name like '정%' and job ='개그맨';

--홍길동 데이터 삽입
insert into person values (seq_test.nextval, '홍길동','도둑','남자',134,null,null);

--num이 8번인 사람의 직업을 교수,입사일을 25-01-02로 변경
update person set job='교수',ipsaday='25-01-02' where num =8;

--최종 저장
commit;

--삭제

--5번 삭제
delete from person where num=5;

--여자이면서 30세 이상 모두 삭제
delete from person where gender= '여자'and age >=30;

delete from person where name ='홍길동';


--출력
select * from person;

--[과제물]
--시퀀스생성
--seq_4 시작:5 증가:5
create sequence seq_4 start with 5 increment by 5;

--테이블 생성
--테이블명: moim
--no number(3) 기본키: seq값
--name  varchar2(20)
--addr  varchar2(30)
--hp  varchar2(20)
--job   varchar2(30)
--gaipday   오늘날짜

--최소 10개 이상 (commit 필수)
create table moim(no number(3) primary key, name varchar2(20), addr varchar2(30),hp varchar2(20),job varchar2(30),gaipday date);
select * from moim;
insert into moim values(seq_4.nextval,'고윤정','서울','010-4123-1234','배우',sysdate);
insert into moim values(seq_4.nextval,'이도현','경기','010-3243-1123','교사',sysdate);
insert into moim values(seq_4.nextval,'손흥민','강원','010-4853-1541','개발자',sysdate);
insert into moim values(seq_4.nextval,'김민재','충청','010-1223-1261','개발자',sysdate);
insert into moim values(seq_4.nextval,'야마모토','서울','010-1223-1261','교사',sysdate);
insert into moim values(seq_4.nextval,'오타니','제주','010-8723-1278','배우',sysdate);
insert into moim values(seq_4.nextval,'프리먼','강원','010-8123-2241','개그맨',sysdate);
insert into moim values(seq_4.nextval,'아이유','경기','010-7123-6241','운동선수',sysdate);
insert into moim values(seq_4.nextval,'이수현','충청','010-9321-4478','개그맨',sysdate);
insert into moim values(seq_4.nextval,'박보영','제주','010-5123-9682','운동선수',sysdate);

commit;

select * from moim;