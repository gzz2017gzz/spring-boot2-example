create table if not exists user (
	id int not null primary key auto_increment,
	name varchar(100),
	sex varchar(1),
	age integer ,
	phone varchar(11),
	create_time timestamp
);