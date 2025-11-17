--[조인]

--emp dept_ deptno
--사원명 부서명
SELECT E.ENAME 사원명,D.DNAME 부서명 -- e,d,는 테이블의 약어
FROM EMP E,DEPT D -- e,d,는 테이블의 약어 선언
WHERE E.DEPTNO=D.DEPTNO;

--사원명 회사위치
SELECT EMP.ENAME ,DEPT.LOC -- 약자를 지정하지 않으면 [테이블명].[컬럼명]으로 하기도 함
FROM EMP,DEPT 
WHERE EMP.DEPTNO=DEPT.DEPTNO;

--사원명 회사위치
SELECT ENAME ,LOC -- 해당 테이블만 유일하게 존재하는 column이면 테이블명 생략 가능
FROM EMP, DEPT 
WHERE EMP.DEPTNO=DEPT.DEPTNO;

--student,department 이용해서 다음과 같이 출력할 것
--학생명 학년 학과명
--서진수 4 컴퓨터공학과
SELECT S.NAME 학생명, S.GRADE 학년, D.DNAME 학과명
FROM STUDENT S, DEPARTMENT D
WHERE S.DEPTNO1= D.DEPTNO;

--student,professor
--학생명 담당교수
--이미경 나한열 교수
SELECT S.NAME 학생명, P.NAME|| ' 교수' 담당교수
FROM STUDENT S, PROFESSOR P
WHERE S.PROFNO=P.PROFNO;

--product panmae
--새우깡 800 3 2400
SELECT PRODUCT.P_NAME 상품명,PRODUCT.P_PRICE 상품가,PANMAE.P_QTY 판매량, PANMAE.P_TOTAL 판매액
FROM PRODUCT, PANMAE
WHERE PRODUCT.P_CODE=PANMAE.P_CODE;

--emp1 dept1
--사원명 부서 근무지
--안영희 총무부 서울
SELECT EMP1.NAME 사원명,DEPT1.NAME||'부' 부서,LOC 근무지
FROM EMP1,DEPT1
WHERE EMP1.DNO=DEPT1.DNO;

--student professor department
--학번 학생명 부전공 담당교수명
--9412 구유미 컴퓨터공학과 허은
--(+)연산자 표시하면 null이거나 없는 데이터도 처리가능
select studno 학번, s.name 학생명, NVL(dname,'없음'), p.name 담당교수명
from student s,professor p, department d
where s.profno=p.profno and s.deptno2=d.deptno(+);

--1.비정규화된 테이블 생성 후 데이터 삽입 후 조회
--거래처회사,직원 테이블: companysawon
--회사명: company varchar2(20)
--회사주소: addr varchar2(20)
--회사전화: phone varchar2(20)
--직원명: sawon_name varchar2(20)
--직급: position varchar2(20)
--이메일: email varchar2(20)
--휴대폰:hp varchar2(20)
create table companysawon(
company varchar2(20),
addr varchar2(30),
phone varchar2(20),
sawon_name varchar2(20),
position varchar2(20),
email varchar2(20),
hp varchar2(20));

select * from companysawon;

--insert==>직원을 추가할 때마다 거래처 회사에 대한 정보가 중복- 메모리 낭비가 심하다
--그러므로 정규화된 테이블이 필요
insert into companysawon values('삼성','서울 강남구','02-111-2222','홍길동',
'과장', 'hong@gmail.com','010-3333-4444');
insert into companysawon values('삼성','서울 강남구','02-511-2222','이재용',
'사장', 'jaedragon@gmail.com','010-3333-4444');
insert into companysawon values('KT','서울 강남구','02-211-2222','이동수',
'부장', 'lee@gmail.com','010-3333-4444');
insert into companysawon values('LG','서울 강북구','02-311-2222','윤계상',
'과장', 'yoon@gmail.com','010-3333-4444');
insert into companysawon values('KT','서울 강남구','02-411-2222','윤미라',
'부장', 'mira@gmail.com','010-3333-4444');

rollback;
--2.위의 테이블을 2개로 나눠서 외부키를 이용해서 연결
--회사ID: 기본키 회사명 회사주소 회사전화
create table company(companyid  number(5) primary key,company varchar2(30),
addr varchar2(20),phone varchar2(30));

--insert
insert into company VALUES(10,'LG','서울 강동구','02-222-2222');
insert into company VALUES(20,'삼성','서울 강남구','02-333-4444');
insert into company VALUES(30,'KT','서울 강북구','02-555-6666');


--거래처 직원테이블:c_sawon 직원명 직급 이메일 휴대폰
create table c_sawon(companyid number(5),name varchar2(20),position varchar2(20),email varchar2(20),phone varchar2(20));

--insert
insert into c_sawon values(10,'홍길동','대리','hong@gmail.com','010-2222-3333');
insert into c_sawon values(10,'길동홍','부장','gil@gmail.com','010-4444-5555');

--조인을 이용해서 한번에 출력
--회사명 회사주소 회사대표번호 거래처사원 직위 이메일 휴대전화

--3.데이터 삭제 시 정규화된 테이블의 경우 문제 발생 cascade 연산자를 이용해서 테이블 삭제

select company 회사명, addr 회사주소, c.phone 회사대표번호,name 거래처사원,position 직위,email 이메일,s.phone 휴대전화
from company c,c_sawon s
where c.companyid=s.companyid;

--방법1
select company 거래처회사,name 거래처사원,position 직위
from company,c_sawon
where company.companyid=c_sawon.companyid;

--방법2
select company 거래처회사,name 거래처사원,position 직위
from company c,c_sawon s
where c.companyid=s.companyid;

--방법3
select c.company 거래처회사,s.name 거래처사원,s.position 직위
from company c,c_sawon s
where c.companyid=s.companyid;

--emp

--사원명 부서명
--smith 20번에 해당하는 실제부서명
select e.ename 사원명,d.dname 부서명
from emp e,dept d
where e.deptno=d.deptno;

--교수명      학과명
--이수연 교수 영어영문학과
select name||' 교수' 교수명,dname 학과명
from professor p,department d
where p.deptno=d.deptno;



select * from company;
select * from c_sawon;
commit;