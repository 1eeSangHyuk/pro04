use myshop;

create table member(
	id varchar(20) primary key,
	pw varchar(300) not null,
	name varchar(50) not null,
	email varchar(30) not null,
	tel varchar(11),
	addr1 varchar(30),
	addr2 varchar(30),
	postcode varchar(7),
	regdate datetime default current_timestamp,
    birth date,
	pt int default 100,
	visited int default 0
);

commit;

show tables;
select * from member;