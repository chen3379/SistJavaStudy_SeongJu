-- 주석 처리

-- 조회연습하기
select ename from emp;
SELECT ename,sal from emp;
SELECT ename FROM emp WHERE sal>=1200;
SELECT * FROM emp;
SELECT * from TAB;
SELECT ename 사원명 from emp;
SELECT ename as 이름 from emp; -- as 별칭
SELECT ename "바 보" from emp; -- 별칭을 띄어쓰려면 반드시 ""안에 넣어야 함
SELECT ename 사원명, sal 급여 FROM emp;

-- emp에서 사원명과 직업을 조회하시오
SELECT ename 사원명, job 직업 FROM emp;
SELECT distinct job from emp; -- 직업만 출력하는데 겹치는거 없이 한번만 할경우(중복 제거)

-- 표현식(컬럼 외에 출력을 원하는 내용을 select 구문 뒤에 ' '로 작성
SELECT ename 사원명,'오늘 근무중' from emp;

-- 문자끼리 더해서 출력해주는 연산자 ||
-- my name is ename입니다 출력
SELECT 'my name is '|| ename ||'입니다' from emp;

-- emp에서 Smith님의 직업은 CLERK 입니다
SELECT ename||'님의 직업은 '||job||'입니다' from emp where ename = 'SMITH';

-- professor에서 송강님은 정교수 입니다
SELECT pname || '님은 ' || orders || '입니다' from professor where pname='송강';

-- 정렬(오름차순 - asc, 내림차순 - desc)
-- 기본 오름차순 정렬이기 때문에 order by 시 asc는 생략 가능
select name 학생명, grade 학년, birthday 생년월일 from student order by grade desc;
select name 학생명, grade 학년, birthday 생년월일 from student order by name desc;
select name 학생명, grade 학년, birthday 생년월일 from student order by 1 desc; -- 1은 1열을 의미
select name 학생명, grade 학년, birthday 생년월일 from student order by grade asc;

-- emp에서 급여가 높은 순으로 사원명,급여를 조회하시오
select ename 사원명,sal 급여 from emp ORDER by sal desc;

-- 조건절(where)
-- select [column](조회할 컬럼) from [table](조회할 테이블) where [원하는 조건](column = ' ');

-- emp에서 deptno가 20번인 사원명과 부서번호를 조회하시오
SELECT ename 사원명, deptno 부서번호 from emp where deptno = '20';

-- emp에서 급여가 3000만원 이상인 사원명과 급여를 조회하시오
select ename 사원명, sal 급여 from emp where sal >=3000;

-- SMITH의 모든 정보 조회
SELECT * from emp where ename = 'SMITH';

-- 문자와 날짜는 모두 ' '
SELECT * from emp where hiredate>'85/01/01'; -- /가 아닌 1985-01-01로도 가능

-- 학생 테이블에서 키가 180 이상인 학생의 학생명과 신장을 조회하시오
select name 학생,height 키 from student where height >= 180;

-- between 연산자 - between A(작은거) and B(큰거)
select name 학생,height 키 from student where height between 180 and 190;

-- 학생 몸무게 60~80kg까지를 학생명과 몸무게 열로 조회하시오
select name 학생,weight 몸무게 from student where weight between 70 and 80 order by weight desc;

-- BETWEEN 연산자는 and, IN 연산자는 or로 대체 가능하다(유사한 기능)
-- and, or이 더 활용 가능한 범위가 넓다
select name 학생,height 키 from student where height<=180 and height >170;

-- In 연산자
-- 부서번호가 20,30만 조회
select ename 사원명, deptno 부서번호 from emp where deptno in(20,30);
select deptno 부서번호 from emp where deptno =20 or deptno=30;

-- 직업이 SALESMAN,MANAGER 인 사람의 사원명과 직업을 조회하시오
select ename 사원명,job 직업 from emp where job in('SALESMAN','MANAGER');

-- IS NULL, IS NOT NULL
-- 보너스가 없는 사원의 사원명만 조회
select ename 사원명 from emp where comm is null;
-- 보너스가 있는 사원의 사원명과 보너스 조회
select ename 사원명,comm 보너스 from emp where comm is not null;

-- 기존 컬럼명으로 새로운 컬럼명을 만들어 조회할 수도 있다
-- null 과 연산을 하게 되면 무조건 결과가 null이 된다
-- 그러므로 우리는 null을 다른 값으로 바꿔줘야 한다
select ename 사원명, sal 급여, comm 보너스, sal+comm "실제 급여" from emp;

-- NVL ..모든 데이터에 적용, 0, ***
-- 위의 계산을 null을 0으로 바꿔서 총금액이 제대로 조회되도록 한다
-- NVL(comm,0) 을 하게 되면 컬럼값의 null이 0인 comm이 된다
-- 컬럼 자체가 변경되는 게 아니기 때문에 comm을 여러 번 null을 바꿔서 사용하려면 그때마다 NVL을 사용해야 한다
select ename 사원명, sal 급여,nvl(comm,0) 보너스, sal+nvl(comm,0) "실제 급여" from emp;

-- 전체인원수 count(컬럼명) 컬럼명에 해당하는 컬럼의 수를 조회
-- 컬럼에 null이 존재할 시 null을 제외한 수를 조회함
-- count(*) count(null이 없는 컬럼명) 주로 사용
SELECT count(ename) 인원수 from emp;

-- emp에서 mgr이 7902,7698인 사원의 사원명과 mgr을 조회하시오(단 IN 사용)
select ename 사원명,mgr from emp where mgr in(7902,7698);

-- 사원명이 JAMES인 사원의 사원명, 급여, 총급여를 조회하시오
select ename 사원명, sal 급여, sal+nvl(comm,0)총급여 from emp where ename = 'JAMES';

-- professor에서 정교수만 교수명 직급을 출력하시오(단 이름의 오름차순)
select pname 교수명, orders 직급 from professor where orders = '정교수' order by pname;

-- Like 연산자
-- % : 여러개의 문자를 대체
-- _ : 하나의 문자를 대체
-- 교수 테이블에서 이씨만 조회
select pname 교수명 from professor where pname like '송%';

-- emp에서 사원명이 C로 시작하는 사원 조회 - C%
SELECT ename 사원명 from emp where ename like 'C%';
SELECT ename 사원명 from emp where ename like 'S%';
-- emp에서 사원명이 K로 끝나는 사원 조회 - %K
SELECT ename 사원명 from emp where ename like '%K';

-- emp에서 사원명의 3번째 글자가 K인 사원 조회 - __K% (언더바 2개 K% - 세번째 글자가 K로 시작하는 사원 조회)
SELECT ename 사원명 from emp where ename like '__L%';

-- emp에서 직업의 2번째 글자가 N인 사원의 사원명과 직업 조회
SELECT ename 사원명,job 직업 from emp where job like '_N%';

select name 이름 from student where name like '서_수';

-- student에서 이름에 주가 들어간 학생의 이름 조회
select name 이름 from student where name like '%주%';

-- emp에서 사원번호와 사원명 입사일 조회(단 82년 이후 입사했거나 직업이 MANAGER인 사원)
select empno 사원번호, ename 사원명, hiredate 입사일 from emp where hiredate>= '82/01/01' or job ='MANAGER';

-- emp에서 사원번호와 사원명, 총급여(급여*12+comm) 조회
select empno 사원번호, ename 사원명, sal*12+nvl(comm,0) 총급여 from emp;

-- emp에서 사원명과 입사일 조회(단 이름에 S가 포함된 사원, 사원명의 오름차순으로)
select ename 사원명, hiredate 입사일 from emp where ename like '%S%' order by ename;

-- emp에서 사원명과 급여 조회(단 급여가 3000 이상이고 직업이 ANALYST인 사원만)
SELECT ename 사원명, sal 급여 from emp where sal>=3000 and job = 'ANALYST';

-- emp에서 키가 180 이상이고 4학년인 학생의 학생명과 키 조회
select name 학생명, height 키 from student where grade=4 and height >=180;

-- 2차 정렬(다중 정렬)
-- 직업으로 오름차순 후에 급여가 낮은 순으로 오름차순
select empno 사원번호,ename 사원명,job 직업,sal 급여,hiredate 입사일 from emp order by job asc,sal; 
-- 1차 정렬된 이후에 2차 정렬

-- 학생테이블 1학년 학생의 이름,학년,키,몸무게 출력(단 학년 내림차순, 키 오름차순)
SELECT name 이름,grade 학년,height 키,weight 몸무게 from student order by grade desc,height asc;

-- Q.
-- Emp
select ename||'님의 급여는'||sal||'만원 입니다' from emp where ename = 'SMITH';

select distinct area 지역 from dept2;

select * from professor where deptno =101 and position = '정교수';

select gname 이름,jumin 주민번호 from gogak where point >=500000;

select name 이름,grade 학년,tel 전화번호 from student where name ='서진수';

select name 이름,jumin 주민번호 from student where deptno1=101 or deptno1=301;

-- SQL 그룹함수 group by
-- count(*)
select count(*) from professor;
-- sum(합계)
select count(bonus),sum(bonus) from professor;
-- avg(평균)
SELECT AVG(bonus) from professor;
-- max min
select count(bonus),sum(bonus), AVG(bonus),max(BONUS),MIN(BONUS) FROM professor;

SELECT MAX(HIREDATE),MIN(HIREDATE) FROM EMP;

-- EMP의 급여평균 소수점 2자리로(round)
-- round(s,i)
select round(avg(sal),2) from emp; -- 소수점 2자리

select round(avg(sal),0) from emp; -- 소수점 없이 반올림

select round(avg(sal),-2) from emp; -- 백단위로 반올림

-- 콘솔에 출력
select sysdate from dual; -- 현재 날짜
SELECT sysdate+7 from dual;

-- to_char함수 통해서 날짜 및 수치데이터를 문자로 변환하기 위한 함수
select to_char(sysdate,'year') from dual; -- 영어
select to_char(sysdate,'yyyy') from dual; -- 영어
select to_char(sysdate,'mm') from dual; -- 영어
select to_char(sysdate,'dd') from dual; -- 영어
select to_char(sysdate,'day') from dual; -- 영어

select to_char(sysdate,'yyyy-mm-dd-hh-mi-ss') from dual;

-- to_char 숫자에도 적용 가능하다
select to_char(245879,'999,999,999')from dual;
select to_char(245879,'00,999,00')from dual; -- 숫자에 천단위 구분기호

-- emp 사원번호 사원명 입사년도 만 조회하시오
select empno 사원번호,ename 사원명,to_char(hiredate,'yyyy') 입사년도 from emp;
-- emp 사원번호 사원명 입사월 만 조회하시오
select empno 사원번호,ename 사원명,to_char(hiredate,'mm') 입사월 from emp;

-- emp 급여 표시
select empno 사원번호,ename 사원명,to_char(sal,'$999,999,999') 급여 from emp;

-- [서브쿼리]
-- 쿼리 안에 또다른 쿼리 담김
-- SMITH의 급여보다 많이 받는 사람
-- select 컬럼1, 컬럼2
-- from 테이블
-- where 조건연산자 (select 컬럼명 from 테이블 where 조건);
-- 메인쿼리(서브쿼리)
-- 서브쿼리가 먼저 수행되서 결과값을 메인쿼리에 전해주고 그 값을 받아서 메인쿼리 수행
-- 서브쿼리는 order by는 못함

-- 평균 연봉보다 더 많이 받는 사람들의 목록을 조회하시오
select * from emp where sal>(select avg(sal) from emp);

-- 이름이 SCOTT인 사람과 같은 MGR을 가진 사람의 목록을 출력하시오
select * from emp where mgr=(select mgr from emp where ename = 'SCOTT');

-- 학생 테이블에서 4학년 평균 키보다 큰 사람의 학생명, 주민번호, 키를 구하시오
select name 학생명,jumin 주민번호,height 키 from student where height>(select avg(height) from student where grade=4);

-- JAMES와 급여가 동일하거나 더 많이 받는 사원
select ename 사원명,sal 급여 from emp where sal>=(select sal from emp where ename ='JAMES');


--1. emp에서 표현식을 이용하여 다음처럼 출력하시오   SMITH(CLERK)
select ename||'('||job||')' from emp where ename = 'SMITH';

--2.교수테이블에서 이름,급여,보너스,총급여를 구하시오
select name 이름,pay 급여,nvl(bonus,0) 보너스,pay+nvl(bonus,0) 총급여 from professor;

--3.고객테이블에서 포인트가 30~50만 사이인 사람의 이름과 포인트를 출력하시오
select gname 이름,point 포인트 from gogak where point between 300000 and 500000;

--4.교수테이블에서 성이 김씨인 사람의 이름,직위,전공과목을 조회하시오
select name 이름,position 직위 from professor where name like '김%';

--5.emp에서 comm이 null인 사람의 이름과 급여를 출력하시오
select ename 이름,sal 급여 from emp where comm is null;

--6.학생테이블에서 4학년중에서 키가 170보다 작거나 몸무게가 60보다 큰학생의 이름,학년,키,몸무게를 조회하시오
select name 이름,grade 학년,height 키,weight 몸무게 from student where (height<170 or weight >60) and grade=4;

--7.emp에서 comm의 null을 0으로 바꾸어서 직업이 MANAGER인 사람만 이름과 보너스 출력하시오
select ename 이름,nvl(comm,0) from emp where job ='MANAGER';

--8.1학년 학생의 이름,키,몸무게 출력하시오 단 몸무게 많은순으로 정렬하세요
select name 이름,height 키,weight 몸무게 from student where grade =1 order by weight desc;

--9.교수테이블에서 나한열의 pay와 같은 페이를 받은 교수명과 pay를 조회하시오
select name 교수명,pay from professor where pay=(select pay from professor where name='나한열');

--10.교수테이블에서 조인형의 직급과 같은 직급을 가진 사람의 이름 급여 직급을 조회하시오
select name 이름,pay 급여,position 직급 from professor where position=(select position from professor where name='조인형');