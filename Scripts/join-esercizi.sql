drop table if exists motherchild;
create table motherchild (mother varchar(20) , child varchar(20) );
insert into motherchild values('Lisa', 'Mary');
insert into motherchild values('Lisa', 'Greg');
insert into motherchild values('Anne', 'Kim');
insert into motherchild values('Anne', 'Phil');
insert into motherchild values('Mary', 'Andy');
insert into motherchild values('Mary', 'Rob');

drop table if exists fatherchild;
create table fatherchild ( father varchar(20), child varchar(20) );
insert into fatherchild values('Steve', 'Frank');
insert into fatherchild values('Greg', 'Kim');
insert into fatherchild values('Greg', 'Phil');
insert into fatherchild values('Frank', 'Andy');
insert into fatherchild values('Frank', 'Rob');

drop table if exists person;
create table person (name varchar(20) , age int , income int );
insert into person values('Andy', 27, 21000);
insert into person values('Rob', 25, 15000);
insert into person values('Mary', 55, 42000);
insert into person values('Anne', 50, 35000);
insert into person values('Phil', 26, 30000);
insert into person values('Greg', 50, 40000);
insert into person values('Frank', 60, 20000);
insert into person values('Kim', 30, 41000);
insert into person values('Mike', 85, 35000);
insert into person values('Lisa', 75, 87000);
