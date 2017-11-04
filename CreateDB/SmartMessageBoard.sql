drop database if exists `smartboard`;
create database smartboard;

create table user(
    UID int primary key AUTO_INCREMENT,
    Uname varchar(10) not null,
    Usex varchar(2) check (Usex='男' or Usex='女'),
    Uhead varchar(500)
);

create table Message(
    MID int primary key AUTO_INCREMENT,
    Message text not null,
    createtime datetime not null,
    creatorID int not null,
    FOREIGN KEY (creatorID) REFERENCES user(UID)
);
    
--show columns from user;
--show clomuns from message;

--测试数据：
insert into user(Uname, Usex, Uhead) values('Frazier', '男', 'https://avatars0.githubusercontent.com/u/18512486?s=460&v=4');
insert into user(Uname, Usex, Uhead) values('Gavin', '男', 'https://avatars1.githubusercontent.com/u/32097717?s=460&v=4');
insert into user(Uname, Usex, Uhead) values('tpof314', '男', 'https://avatars2.githubusercontent.com/u/999004?s=460&v=4');
insert into user(Uname, Usex, Uhead) values('Yangying', '女', 'https://qlogo1.store.qq.com/qzone/1484137272/1484137272/50?1486689385');

insert into Message(Message, createtime, creatorID) values('This is Frazier', now(), 1);
insert into Message(Message, createtime, creatorID) values('This is Gavin', now(), 2);
insert into Message(Message, createtime, creatorID) values('This is tpof314', sysdate(), 3);
insert into Message(Message, createtime, creatorID) values('This is 杨莹', sysdate(), 4);



