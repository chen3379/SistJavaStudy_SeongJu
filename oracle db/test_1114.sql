--DB정규화
--한마디로 DB서버의 메모리를 낭비하지 않기 위해서 어떤 테이블을 식별자를 가지는 여러 개의
--테이블로 나누는 과정을 정규화 라고 한다
--정규화된 데이터베이스는 중복이 최소화되도록 설계된 DB이다

--on Delete Cascade: 외부키로 연결이 되어있다 하더라도 부모 테이블의 데이터를 삭제하면
--자식테이블의 데이터까지 자동삭제 시켜주는 기능

--첫번째 DB정규화
--시퀀스를 만들고 shop테이블,cart테이블을 만들어 조회해볼 것

--시퀀스
create SEQUENCE seq_shop;

--shop테이블(상품번호-기본키 상품명 색상
create table shop(num number(5) primary key,name varchar2(20),color varchar(20));

insert into shop values(seq_shop.nextval, '키보드', '검정색');
insert into shop values(seq_shop.nextval, '마우스', '하얀색');
insert into shop values(seq_shop.nextval, '모니터', '검정색');
insert into shop values(seq_shop.nextval, '마우스패드', '빨간색');
insert into shop values(seq_shop.nextval, '책상', '갈색');
insert into shop values(seq_shop.nextval, '의자', '파란색');
insert into shop values(seq_shop.nextval, '스피커', '주황색');
insert into shop values(seq_shop.nextval, '헤드셋', '분홍색');
insert into shop values(seq_shop.nextval, '충전기', '하얀색');
insert into shop values(seq_shop.nextval, '거치대', '하늘색');

select * from shop;
commit;

--cart테이블(주문번호(기본키), shop의 num(외부키), 개수, 구입날짜
--CREATE table cart(num_order number(5) primary key,num number(5)
--constraint cart_fk_num REFERENCES shop(num), count number(5),buy date);

--constraint를 쿼리 마지막에 넣는 케이스
--이 케이스에선 foreign key(column명)을 선언해줘야 한다
CREATE table cart(num_order number(5) primary key,num number(5),
count number(5),buy date, constraint cart_fk_num foreign key(num) REFERENCES shop(num));

--cart2테이블 shop테이블의 num을 외부키지정하고 on delete cascade
--부모테이블 삭제 시 그 상품과 연결된 카트를 자동으로 지워준다
CREATE table cart2(num_order number(5) primary key,num number(5) constraint cart_fk2_num
references shop(num) on delete cascade, count number(5),buy date);

select * from cart;
select * from cart2;

--cart테이블에 상품추가,1번 상품 추가
insert into cart values(seq_shop.nextval, 1, 2 ,sysdate);--1번 상품 2개 추가
insert into cart values(seq_shop.nextval, 4, 1 ,sysdate);--4번 상품 1개 추가

--cart테이블에 shop에 존재하지 않는 상품 추가
insert into cart values(seq_shop.nextval, 11,2,sysdate);


--cart2테이블에 상품추가,3번2개,4번3개
insert into cart2 values(seq_shop.nextval,3,2,sysdate);
insert into cart2 values(seq_shop.nextval,4,3,sysdate);

--부모테이블의 1번 상품 삭제
delete from shop where num=1; --무결성 제약조건(TEST.CART_FK_NUM)이 위배되었습니다- 자식 레코드가 발견되었습니다

delete from shop where num=5;

--cart2에 담긴 3,4번중 3번은 shop에서 지워질까??
--yes:cascade설정으로 부모테이블 데이터 지우면 자식테이블의 데이터도 같이 지워진다
delete from shop where num=3;--cart2의 3번 담은 상품이 사라짐

--join위해서 cart2에 데이터 추가
insert into cart2 values(seq_shop.nextval,6,3,sysdate);
insert into cart2 values(seq_shop.nextval,8,4,sysdate);
insert into cart2 values(seq_shop.nextval,7,6,sysdate);
insert into cart2 values(seq_shop.nextval,10,2,sysdate);

--cart에 담긴 상품을 shop과 join해서 자세히 출력
--주문번호 상품번호 상품명 상품색상 주문갯수 구입한날짜
select num_order 주문번호, c.num 상품번호,name 상품명,color 상품색상, count 주문갯수, buy 구입한날짜
from shop s,cart c
where s.num=c.num;

--cart2에 담긴 상품을 shop과 join해서 자세히 출력
select c.num_order 주문번호, s.num 상품번호,s.name 상품명,s.color 상품색상, c.count 주문갯수, c.buy 구입한날짜
from shop s,cart2 c
where s.num=c.num;

--[2번째 테이블 생성]
--게시판에 원글을 작성시 댓글을 남기는 경우를 가정해서 작성
create SEQUENCE seq_a;

--board테이블 기본키 작성자 제목 원글작성날짜
create table board(n number(5) constraint board_pk_n primary key,writer varchar2(20),
title varchar2(20),upload date); 

insert into board values(seq_a.nextval,'홍길동','홍길동전','2023-01-24');
insert into board values(seq_a.nextval,'이재현','오늘은금요일','2023-01-24');
insert into board values(seq_a.nextval,'김주혁','내일은토요일','2019-03-27');
insert into board values(seq_a.nextval,'박재민','모레는일요일','2024-09-14');
insert into board values(seq_a.nextval,'황주호','어제는목요일','2019-07-02');

select * from board;
update board set upload=sysdate where writer='이재현';

//comment테이블 기본키 작성자 댓글 댓글작성날짜
create table b_comment(b_comm number(5) primary key, n number(5) CONSTRAINT comm_fk_n references board(n) on delete cascade, writer varchar2(20),comm varchar2(20),upload_comm date);

--원하는 원글에 댓글을 최소5개 넣어보기
insert into b_comment values(seq_a.nextval,1,'ANDREW','재밌다',sysdate);
insert into b_comment values(seq_a.nextval,2,'DOROTHY','좋아요',sysdate);
insert into b_comment values(seq_a.nextval,3,'BEN','안녕',sysdate);
insert into b_comment values(seq_a.nextval,4,'CURRY','하이',sysdate);
insert into b_comment values(seq_a.nextval,3,'CHRIS','잘 봤어요',sysdate);

--글 댓글작성자 댓글 댓글작성일자 join해서 조회
select title 작성글, b_comment.writer 댓글작성자, b_comment.comm 댓글,upload_comm "댓글작성일자"
from board, b_comment
where board.n=b_comment.n;

--join으로 출력
--글번호(원글) 작성자 작성내용 댓글작성자 댓글내용 원글작성날짜 댓글작성날짜
select board.n 글번호,board.writer 작성자, title 작성글, b_comment.writer 댓글작성자, b_comment.comm 댓글내용,upload 원글작성날짜,upload_comm "댓글작성일자"
from board, b_comment
where board.n=b_comment.n;

--원글 2번 삭제 가능(댓글도 삭제)
delete from board where n=2;

select * from board; -- 원글 2번 삭제됨
select * from b_comment; -- 원글 2번에 달린 댓글도 자동 삭제

--삭제
drop table board; --외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다

--자식테이블을 먼저 삭제해야함
drop table b_comment;
drop table board;
commit;



--[조인,외부키 문제]
--시퀀스: SEQ_4 이용해서 기본 키에 활용하세요

--테이블: Foodshop
--fno 기본키, fname 음식명, fprice 음식가격, shopname 음식점이름,shoploc 음식점위치
create table Foodshop(fno number(5) primary key,fname varchar2(20),fprice number(10),shopname varchar2(20),shoploc varchar2(20));

--최소 데이터 10개 insert
insert into Foodshop values(seq_4.nextval,'치킨버거',5000,'롯데리아','선릉');
insert into Foodshop values(seq_4.nextval,'불고기버거',4000,'롯데리아','선릉');
insert into Foodshop values(seq_4.nextval,'짬뽕',11000,'명정루','역삼');
insert into Foodshop values(seq_4.nextval,'짜장면',8000,'명정루','역삼');
insert into Foodshop values(seq_4.nextval,'아메리카노',1800,'컴포즈','대치');
insert into Foodshop values(seq_4.nextval,'딸기스무디',5000,'컴포즈','대치');
insert into Foodshop values(seq_4.nextval,'아인슈페너',6000,'매머드','구룡');
insert into Foodshop values(seq_4.nextval,'엽기떡볶이',14000,'동대문엽떡','서초');
insert into Foodshop values(seq_4.nextval,'마라탕',10000,'압구정마라','압구정');
insert into Foodshop values(seq_4.nextval,'요거트',18000,'요아정','압구정');




--테이블: Orderapp
--ono 기본키, cname 주문자, fno 음식번호(외부키), caddr(주문자주소)
create table Orderapp(ono number(5) primary key,cname varchar2(20),fno number(10),caddr varchar2(20),
CONSTRAINT orderapp_fk_n foreign key(fno) REFERENCES foodshop(fno) on delete CASCADE);

alter table orderapp modify caddr varchar(40);
--최소 데이터 10개 insert 가게 주소랑 주문자 주소가 너무 어긋나지 않도록 insert
insert into orderapp values(seq_4.nextval,'손흥민',105,'선릉역 1번 출구');
insert into orderapp values(seq_4.nextval,'이재성',125,'대치동 풋살장');
insert into orderapp values(seq_4.nextval,'고윤정',130,'asd스튜디오 구룡점');
insert into orderapp values(seq_4.nextval,'아이유',170,'압구정 정형외과');
insert into orderapp values(seq_4.nextval,'지창욱',120,'역삼 dsa호텔');
insert into orderapp values(seq_4.nextval,'남주혁',115,'역삼공원 입구');
insert into orderapp values(seq_4.nextval,'이재용',145,'삼성 수리센터 대치점');
insert into orderapp values(seq_4.nextval,'권지용',110,'fgds스튜디오 선릉점');
insert into orderapp values(seq_4.nextval,'영케이',135,'서초도서관 1층');
insert into orderapp values(seq_4.nextval,'김동현',105,'쌍용교육센터 5층 선릉점');
insert into orderapp values(seq_4.nextval,'김연아',170,'스케이트장 압구정점');

select * from foodshop;
select * from orderapp;
delete from foodshop where fno in(150,155,160,165);

--최종출력 - 주문자 이름 오름차순 정렬
--순서
--주문번호 주문자이름 음식명       음식가격   상호명    가게위치         주문자 주소
--25      손흥민    알리오올리오  18,000    쏘렌토    강남구 역삼동    역삼2동 쌍용교육센터 7층
select o.fno 주문번호, cname 주문자이름,fname 음식명,to_char(fprice,'999,999') 음식가격,shopname 상호명,
shoploc 가게위치,caddr 주문자주소
from foodshop f,orderapp o
where f.fno=o.fno
order by cname;

commit;
rollback;
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
-- 기본키 상품명 가격 매너점수 상대방주소
create table Mycarrot(cnum number(10) primary key,csangpum VARCHAR2(20),cprice number(10),cscore number(10),caddr VARCHAR2(20));
insert into mycarrot values(seq_a.nextval,'텀블러',5000,'95','강북');
insert into mycarrot values(seq_a.nextval,'물티슈',2000,'92','강남');
insert into mycarrot values(seq_a.nextval,'의자',12000,'97','강서');
insert into mycarrot values(seq_a.nextval,'가방',3000,'88','강동');
insert into mycarrot values(seq_a.nextval,'보조배터리',10000,'65','강서');
insert into mycarrot values(seq_a.nextval,'바지',6000,'96','강남');
insert into mycarrot values(seq_a.nextval,'다리미',9000,'99','강동');
insert into mycarrot values(seq_a.nextval,'수납장',11000,'73','강북');
insert into mycarrot values(seq_a.nextval,'시계',7000,'87','강북');
insert into mycarrot values(seq_a.nextval,'주전자',8000,'76','강동');

commit;
select * from mycarrot;