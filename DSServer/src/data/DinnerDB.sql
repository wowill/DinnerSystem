CREATE DATABASE DinnerDB;
go

USE DinnerDB;
go

CREATE TABLE LeftItem(
id int primary key,
name varchar(50),

);
go

create table ItemToDetails(
id int primary key,
name varchar(50),
price float,
leave int default 0,
picture image null, 
ItemID int
);
go

