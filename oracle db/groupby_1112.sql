--[그룹함수 복습]
select sum(sal) 합계 from emp;
SELECT sum(pay) 총급여 from professor;

--자리수,전체합계와 평균(소수점이하 한자리 반올림)
select sum(sal) 합계,round(avg(sal),1) 평균 from emp;
select sum(pay) 합계,round(avg(pay),2) 평균 from professor;
select Max(pay) 최대급여,min(pay) 최소급여 from professor;

--emp에서 입사월이 5월인 사람만 출력(to_char)
select * from emp where to_char(hiredate, 'mm')=05;

--emp에서 입사년도가 81년도인 사람만 출력
select * from emp where to_char(hiredate, 'yy') =81;

--emp에서 입사년도가 81년도인 사람 출력(to_char - between A and B)
select * from emp where hiredate between '81/01/01' and '81/12/31';

--(특정조건으로 세부적인 그룹화하기-GROUP BY)
--select절에 사용된 그룹함수 이외에 컬럼은 반드시 group by절에 포함이 돼야한다

--professor에서 학과별로 교수들의 평균급여를 출력하시오
select deptno 학과,avg(nvl(pay,0)) 평균급여 from professor group by deptno;

select job 직업, count(*) 합계 from emp group by job;

--학과별,직급별로 교수들의 평균급여
select deptno 학과, position 직급, avg(nvl(pay,0)) 평균급여 from professor group by deptno, position;

--학생테이블에서 학년별 최고몸무게,평균키를 구하시오
select grade 학년, max(weight) 최고몸무게,avg(nvl(height,0)) 평균키 from student group by grade order by grade;

select avg(nvl(height,0)) from student;
select nvl(avg(height),0) from student;

--같은 직무를 가진 사원수 구하기(emp)
select job 직무, count(*) 사원수 from emp group by job;

--직무별로 sal의 평균급여 구하시오
select job 직무, round(avg(nvl(sal,0)),2) 평균급여 from emp group by job;

--교수 직급별로 최고급여와 최고보너스를 구하시오
select position 직급,max(pay) 최고급여,max(nvl(bonus,0)) 최고보너스 from professor group by position;

--교수 직급별 인원수 구하시오
select position 직급,count(*) 인원수 from professor group by position;

--학년별 인원수,평균키,평균몸무게 구하시오
select grade 학년,count(*) 인원수, avg(nvl(height,0)) 평균키,avg(nvl(weight,0)) 평균몸무게 from student group by grade;

--(Having절은 Group by에 조건을 줄때 쓰인다)
--where -- > group by --> having --> order by
--부서별 평균급여를 구하려면 group by만 필요하다
--평균급여가 450 이상인 부서의 평균급여를 구하려면 having절이 필요
select deptno 학과,avg(pay) 평균급여 from professor group by deptno;

--where 절은 그룹함수 비교조건으로 쓸 수 없다
select deptno 학과,avg(pay) 평균급여 from professor group by deptno having avg(pay)>=450;

--emp에서 부서별로 평균급여를 구하되 2000이상만 조회하시오
select deptno 부서,round(avg(sal),1) 평균급여 from emp group by deptno having avg(sal)>=2000;

--deptno가 10,20인 부서의 직무별 개수는?
select job, count(*) from emp where deptno in(10,20) group by job;

--deptno가 10,20인 부서의 직무별 개수를 구하되 2명 이상만 조회?
select job, count(*) from emp where deptno in(10,20) group by job having count(*)>=2;

--직무별 인원수와 총급여를 구하되 인원이 2명 이상이고 총급여가 6000이상인 직무만 조회
select job 직무,count(*) 인원수, sum(sal) 총급여 from emp group by job having sum(sal)>=6000 and count(job)>=2;

--where not in(' ') - ' '를 제외
--모든 where 조건과 group by,order by, having 포함
--MANAGER 제외, 직무별로 그룹화, 급여합계 5000 이상, 급여합계 내림차순
select job 직무,sum(sal) "급여 합계" from emp where job not in('MANAGER') group by job having sum(sal)>=5000 order by sum(sal) desc;

--[Rollup,Cube] 자동으로 소계/합계 구해주는 함수
--Rollup: group by절에 주어진 조건으로 소계값구해준다 - 최하단 행에 추가
select deptno 학과번호,position 직위,sum(pay) 총급여 from professor group by position, rollup(deptno);

select position 직위,count(*) 총급여,sum(pay) from professor group by rollup(position);

--Cube - 최상단 행에 추가
--소계 총계까지 최상단에 추가
SELECT deptno,position,COUNT(*),sum(pay) from professor group by cube (deptno,position);