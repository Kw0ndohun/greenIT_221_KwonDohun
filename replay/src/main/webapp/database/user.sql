create database usersDb;
use usersDb;
create table users(
	id varchar(20) primary key,
    password varchar(20) not null,
    `name` varchar(40) not null,
    birthdate datetime not null,
    gender smallint(1) not null,
    email varchar(40) not null,
    coun varchar(10) not null,
    mobile varchar(13) not null
);
