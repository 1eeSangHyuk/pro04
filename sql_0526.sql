show databases;
use myshop;
show tables;

create table notice(
	notiNo int primary key auto_increment,
    notiTitle varchar(20),
    notiText varchar(500),
    notiCnt integer default 0,
    notiRegDate time default current_timestamp
);

drop table notice;
insert into notice(notiTitle, notiText, notiCnt, notiRegDate) values('title1', 'text1', default, default);
insert into notice(notiTitle, notiText, notiCnt, notiRegDate) values('title2', 'text2', default, default);

select count(*) from notice;

select * from notice;

commit;