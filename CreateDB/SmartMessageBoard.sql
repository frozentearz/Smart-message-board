drop database if exists `smartboard`;
create database smartboard;
use smartboard;

create table user(
    UID int primary key AUTO_INCREMENT,
    Uname varchar(10) not null,
    Upasswd varchar(25) not null,
    Usex char(1) check (Usex='M' or Usex='F') not null,
    Uhead varchar(500)
);

create table message(
    MID int primary key AUTO_INCREMENT,
    message text not null,
    createtime datetime not null,
    creatorID int not null,01
    FOREIGN KEY (creatorID) REFERENCES user(UID)
);
    
--show columns from user;
--show clomuns from message;

--测试数据：
insert into user(Uname, Upasswd, Usex, Uhead) values('Frazier', 'Frazier', 'M', 'https://avatars0.githubusercontent.com/u/18512486?s=460&v=4');
insert into user(Uname, Upasswd, Usex, Uhead) values('Gavin', 'Gavin', 'M', 'https://avatars1.githubusercontent.com/u/32097717?s=460&v=4');
insert into user(Uname, Upasswd, Usex, Uhead) values('tpof314','tpof314', 'M', 'https://avatars2.githubusercontent.com/u/999004?s=460&v=4');
insert into user(Uname, Upasswd, Usex, Uhead) values('Yangying', 'Yangying', 'F', 'https://qlogo1.store.qq.com/qzone/1484137272/1484137272/50?1486689385');

insert into message(Message, createtime, creatorID) values('This is Frazier', now(), 1);
insert into message(Message, createtime, creatorID) values('This is Gavin', now(), 2);
insert into message(Message, createtime, creatorID) values('This is tpof314', sysdate(), 3);
insert into message(Message, createtime, creatorID) values('This is 杨莹', sysdate(), 4);



