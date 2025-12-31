SELECT * FROM test.myboard;
insert into myboard values(null,1,1,1,1,1,now());
insert into myboard values(null,1,1,1,1,1,now());
select * from myboard limit 1,3;
select * from myboard limit 4,8;

create table myboardanswer (idx smallint auto_increment primary key, 
num smallint,
nickname varchar(30),
comment varchar(1000),
writeday date,
foreign key(num) references myboard(num) on delete cascade);

select * from myboardanswer  where num=39 order by idx desc;