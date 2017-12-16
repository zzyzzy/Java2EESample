create table sungjuk (
	sjno int primary key auto_increment,
	name varchar(10) not null,
	kor decimal(3),
	eng decimal(3),
	mat decimal(3),
	tot decimal(3) default 0,
	avrg decimal(4,1) default 0.0,
	grd varchar(2) default '가',
	regdate datetime default current_timestamp
);
