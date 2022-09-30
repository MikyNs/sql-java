
drop table if exists studenti;

create table if not exists studenti (
	matricola char(5),
	nome varchar(50),
	cognome varchar(50),
	primary key (matricola)
);


insert into studenti (matricola, nome, cognome) values (89045,"Gaetano","Tiani");
insert into studenti (matricola, nome, cognome) values (78655,"Michele","Tesse");
insert into studenti (matricola, nome, cognome) values (27841,"Francesco","Totti");
insert into studenti (matricola, nome, cognome) values (45712,"Giuseppe","Petillo");
insert into studenti (matricola, nome, cognome) values (52489,"Franco","Bisceglie");

delete from studenti where matricola = 45712;

update studenti set nome = "Francesco" where matricola = 52489;
update studenti set nome = "Angelo" where matricola = 45712;