--[본인 첫번째 만든 계정]
--1.department테이블에 다음을 일부만 insert할것
--102 영어영문학과 
--103 유아교육학과
--201 사이버학과
--202 경제학부
insert into department (deptno,dname)values(102,'영어영문학과');
insert into department (deptno,dname)values(103,'유아교육학과');
insert into department (deptno,dname)values(201,'사이버학과');
insert into department (deptno,dname)values(202,'경제학부');

--2. professor테이블에 전체 데이터를 insert하시오
--4008 홍길동 hong 조교수 440 85/01/01 100 103 hong@gmail.com http://hong.abc.com
insert into professor values(4008, '홍길동', 'hong', '조교수', 440 ,'85/01/01', 100, 103, 'hong@gmail.com', 'http://hong.abc.com');

--3. professor테이블에서 김영조의 직급을 정교수로 변경하시오
update professor set position='정교수' where profno=2002;

--4. professor테이블에서 4005 바비님의 데이터를 삭제하시오
DELETE from professor where profno=4005;

--5. 학생테이블에서 서진수의 담당교수를 2001로 수정하시오
update student set profno=2001 where studio=9411;

select * from professor;