-- 登陆数据库
-- $ mysql -u root

use mysql;
INSERT INTO user (
    host, user, password, select_priv, insert_priv, update_priv, delete_priv, create_priv, drop_priv)
    VALUES ('localhost', 'smart', PASSWORD('smart'), 'Y', 'Y', 'Y', 'Y', 'Y', 'Y');
FLUSH PRIVILEGES;

--退出重新登陆数据库
--用 smart 登陆：
--$ mysql -u smart -p

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
    
show columns from user;
show clomuns from message;