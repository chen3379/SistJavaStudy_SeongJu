SELECT * FROM test.login;

insert into login values(null,"손종원","son","1234");
insert into login values(null,"최강록","choi","1234");
insert into login values(null,"샘킴","kim","1234");
insert into login values(null,"정호영","jeong","1234");
insert into login values(null,"이균","edward","1234");
insert into login values(null,"권성준","gwon","1234");

create table memguest (num smallint primary key auto_increment,
myid varchar(20),
photo varchar(50),
content varchar(1000),
writeday datetime
);