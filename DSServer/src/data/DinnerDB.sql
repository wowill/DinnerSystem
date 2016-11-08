CREATE DATABASE DinnerDB;
go

USE DinnerDB;
go

drop table LeftItem
go
CREATE TABLE LeftItem(
id int primary key,
name varchar(50)
);
go
drop table ItemToDetails

create table ItemToDetails(
id int primary key,
name varchar(50),
price float,
leave int default 0,
sold int default 0,
picture varchar(100) null, 
perID int,
ItemID int
);
go

insert into LeftItem values
(1, '²âÊÔ²Ëµ¥Ò»'),
(2, '²âÊÔ²Ëµ¥¶þ'),
(3, '²âÊÔ²Ëµ¥Èý'),
(4, '²âÊÔ²Ëµ¥ËÄ'),
(5, '²âÊÔ²Ëµ¥Îå'),
(6, '²âÊÔ²Ëµ¥Áù'),
(7, '²âÊÔ²Ëµ¥Æß'),
(8, '²âÊÔ²Ëµ¥°Ë')
go



insert into ItemToDetails values
(1,'²Ë1-1', 10.05, 50, 30, 'c:/OrderingImages/0001.png',1, 1),
(2,'²Ë1-2', 9.99, 50, 30, 'c:/OrderingImages/0002.png',2, 1),
(3,'²Ë1-3', 12.99, 40, 30, 'c:/OrderingImages/0003.png',3, 1),
(4,'²Ë1-4', 43.00, 50, 130, 'c:/OrderingImages/0004.png',4, 1),
(5,'²Ë1-5', 5.30, 50, 60, 'c:/OrderingImages/0005.png',5, 1),
(6,'²Ë2-1', 10.05, 20, 30, 'c:/OrderingImages/0001.png',1, 2),
(7,'²Ë2-2', 9.99, 50, 30, 'c:/OrderingImages/0002.png',2, 2),
(8,'²Ë2-3', 12.99, 50, 30, 'c:/OrderingImages/0003.png',3, 2),
(9,'²Ë2-4', 43.00, 50, 80, 'c:/OrderingImages/0004.png',4, 2),
(10,'²Ë2-5', 5.30, 50, 60, 'c:/OrderingImages/0005.png',5, 2),
(11,'²Ë2-6', 10.05, 50, 30, 'c:/OrderingImages/0001.png',6, 2),
(12,'²Ë2-7', 9.99, 50, 10, 'c:/OrderingImages/0002.png',7, 2),
(13,'²Ë2-8', 12.99, 60, 20, 'c:/OrderingImages/0003.png',8, 2),
(14,'²Ë2-9', 43.00, 50, 30, 'c:/OrderingImages/0004.png',9, 2),
(15,'²Ë2-10', 5.30, 80, 30, 'c:/OrderingImages/0005.png',10, 2),
(16,'²Ë3-1', 10.05, 50, 30, 'c:/OrderingImages/0001.png',1, 3),
(17,'²Ë3-2', 9.99, 50, 30, 'c:/OrderingImages/0002.png',2 ,3),
(18,'²Ë3-3', 12.99, 40, 30, 'c:/OrderingImages/0003.png',3, 3),
(19,'²Ë3-4', 43.00, 50, 130, 'c:/OrderingImages/0004.png',4, 3),
(20,'²Ë3-5', 5.30, 50, 60, 'c:/OrderingImages/0005.png',5, 3),
(21,'²Ë3-6', 10.05, 20, 30, 'c:/OrderingImages/0001.png',6, 3),
(22,'²Ë3-7', 9.99, 50, 30, 'c:/OrderingImages/0002.png',7, 3),
(23,'²Ë3-8', 12.99, 50, 30, 'c:/OrderingImages/0003.png',8, 3),
(24,'²Ë3-9', 43.00, 50, 80, 'c:/OrderingImages/0004.png',9, 3),
(25,'²Ë3-10', 5.30, 50, 60, 'c:/OrderingImages/0005.png',10, 3),
(26,'²Ë3-11', 10.05, 50, 30, 'c:/OrderingImages/0001.png',11, 3),
(27,'²Ë3-12', 9.99, 50, 10, 'c:/OrderingImages/0002.png',12, 3),
(28,'²Ë3-13', 12.99, 60, 20, 'c:/OrderingImages/0003.png',13, 3),
(29,'²Ë3-14', 43.00, 50, 30, 'c:/OrderingImages/0004.png',14, 3),
(30,'²Ë3-15', 5.30, 80, 30, 'c:/OrderingImages/0005.png',15, 3)
go

insert into ItemToDetails values
(31,'²Ë4-1', 43.00, 50, 80, 'c:/OrderingImages/0004.png',1, 4),
(32,'²Ë5-1', 12.99, 60, 20, 'c:/OrderingImages/0003.png',2, 5),
(33,'²Ë6-1', 10.05, 50, 30, 'c:/OrderingImages/0001.png',3, 6),
(34,'²Ë7-1', 43.00, 50, 80, 'c:/OrderingImages/0004.png',4, 7),
(35,'²Ë8-1', 9.99, 50, 30, 'c:/OrderingImages/0002.png', 5, 8)
go

select * from ItemToDetails
