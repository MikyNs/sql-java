
drop table if exists prova_creazione;

create table if not exists prova_creazione (
	codice int,
	descrizione varchar(256), -- not null
	primary key (codice)
);

-- inserire dati
-- insert sintassi completa
insert into prova_creazione (codice, descrizione) values (1, "articolo di prova 001");
insert into prova_creazione (descrizione, codice) values ("articolo di prova 002", 2);
insert into prova_creazione (codice) values (3);

-- insert versione abbreviata
insert into prova_creazione values (4, "articolo di prova 003");
insert into prova_creazione values (5, null);

-- insert versione multipla
insert into prova_creazione (codice, descrizione) values (10, "desc 10"), (11, "desc 11"), (12, "desc 12");


-- rimuovere (cancellare) la tupla con codice 11
delete from prova_creazione where codice = 11;

-- aggiornare la descrizione della riga 10
update prova_creazione set descrizione = "Televisore ultimo modello" where codice = 10;

-- ATTENZIONE con delete e update qualificare bene la query (occhio alla where)
-- update prova_creazione set descrizione = "Televisore ultimo modello";
-- delete from prova_creazione;