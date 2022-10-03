--
-- Quale è la zona sismica di Rimini?
--
-- Quali tabelle: comuni_italiani
SELECT comune, zona_sismica
FROM comuni_italiani
WHERE comune = "rimini";

--
-- Insieme voglio sapere se Rimini è capoluogo di provincia;
--
-- Quali tabelle: comuni_italiani + comuni
-- verifica select * from comuni c  where capoluogo_provincia <>0;
-- devo effettuare un join tra comuni e comuni_italiani.
-- ? è fattibile???
--
-- la tabella comuni è correlata con la tabella comuni_italiani tramite nome
select c.id_provincia, c.nome, ci.comune, ci.provincia
from comuni_italiani ci
left join comuni c
on ci.comune = c.nome;

select count(*) -- 7996
from comuni_italiani ci
left join comuni c
on ci.comune = c.nome;

-- conto i record e vedo se vi sono differenze
select
(select count(*) from comuni c) as comuni,
(select count(*) from comuni_italiani c) as comuni_italiani;

-- verificato se e quanti comuni matchano per nome
select c.id_provincia, c.nome, ci.comune, ci.provincia
from comuni_italiani ci
left join comuni c
on ci.comune = c.nome
where c.nome is null;

select c.id, c.nome, ci.comune, ci.id, ci.provincia
from comuni_italiani ci
left join comuni c
on ci.comune = c.nome;

-- verifica di quanti record matchano per nome
select count(*) -- 7996
from comuni_italiani ci
inner join comuni c
on ci.comune = c.nome;


-- record count comuni = 7999
-- record count comuni_italiani = 7978
-- delta = 21

-- join tra comuni.nome e comuni_italiani.comune
-- record 7853
-- delta 146

select c.id, c.nome, ci.comune, ci.istat, ci.provincia
from comuni_italiani ci
inner join comuni c
on ci.comune = c.nome;


select count(*) -- 7812
from comuni_italiani ci
inner join comuni c
on ci.istat  = c.id;

-- join tra comuni.nome e comuni_italiani.comune
-- record 7812
-- delta 187

select c.id, c.nome, ci.comune, ci.istat, ci.provincia
from comuni_italiani ci
left join comuni c
on ci.comune = c.nome
where c.nome is null;

select c.id, c.nome, ci.comune, ci.istat, ci.provincia
from comuni_italiani ci
left join comuni c
on ci.istat  = c.id
where c.nome is null;

-- aggiungo una colonna alla tabella comuni_italiani
alter table comuni_italiani add codice_comune int;

-- aggiorno codice_comune con comuni.id
update comuni_italiani ci
inner join comuni c
on ci.istat  = c.id
set codice_comune = c.id;

-- verifica 1 atteso 7812 OK
select count(*)
from comuni_italiani
where codice_comune is not null;

-- atteso (187-21) = 166 OK
select count(*)
from comuni_italiani
where codice_comune is null;

-- start transaction;

-- aggiorno codice_comune con comuni.id
-- effettuando la join sul nome dei comuni
-- verifica 157 records
select c.nome, c.id
from comuni_italiani ci
inner join comuni c
on ci.comune  = c.nome
where ci.codice_comune is null;


update comuni_italiani ci
inner join comuni c
on ci.comune  = c.nome
set codice_comune = c.id
where ci.codice_comune is null;

-- rollback;


-- quante sono le righe ancora aperte
-- attese 10 OK
select regione, provincia, comune, istat from comuni_italiani ci
where codice_comune is null;



select * from comuni where nome like '%pan%' order by nome;

select r.nome, p.nome, c.nome, c.id
from comuni c
inner join regioni r
on c.id_regione = r.id
inner join province p
on c.id_provincia = p.id
where c.nome = "lappano";

-- mappano nato nel 2013 perchè? caselle torinese, settimo torinese, borgaro torinese, leini
select * from comuni c where nome = "leini";

-- stiamo utilizando un database obsoleto!!!


