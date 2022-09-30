use mysql
CREATE USER 'master'@'%' IDENTIFIED WITH mysql_native_password BY 'manager';
FLUSH PRIVILEGES;
create database corso;
GRANT ALL PRIVILEGES ON test.* TO 'corso';
GRANT ALL PRIVILEGES ON corso.* TO 'corso';
use mysql;
select user, host from user;
select * from user where user ='corso';

