create database if not exists `url-shortener`;

use `url-shortener`;

create table if not exists `shortened-url` (
	id bigint not null AUTO_INCREMENT,
	original_url varchar(2000) not null,
	shortened_url varchar(10) not null unique,
	primary key (id)
);