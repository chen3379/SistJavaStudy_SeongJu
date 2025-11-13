--[조인]

--emp dept_ deptno
--사원명 부서명
select e.ename 사원명,d.dname 부서명 from emp e,dept d where e.deptno=d.deptno;