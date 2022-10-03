-- inner join con where clause
-- QUALI SONO GLI ORDINI EFFETTUATI DAI CLIENTI?
SELECT c.id_cliente, c.nome, c.cognome, o.valore
FROM clienti c, ordino o
WHERE c.id_cliente o.id_cliente
ORDER BY 1;

-- inner join 
-- QUALI SONO GLI ORDINI EFFETTUATI DAI CLIENTI?
SELECT c.id_cliente, c.nome, c.cognome, o.valore
FROM clienti c
INNER JOIN ordini o
ON c.id_cliente = o.id_cliente;

-- inner join con sintassi compatta
-- QUALI SONO GLI ORDINI EFFETTUATI DAI CLIENTI?
SELECT c.id_cliente, c.nome, c.cognome, o.valore
FROM clienti c
INNER JOIN ordini o
using (id_cliente);

-- prodotto cartesiano
select a.x, b.x
from cjdA a, cjdB b;

-- Quali sono le province che appartengono al Lazio
-- (join per allineare province e regioni ed una scrematura per estrarre solo il lazio)
SELECT r.nome, p.nome
FROM province p 
inner join regioni r
on p.id_regione = r.id
WHERE r.nome = ("Lazio");

-- Quali sono i comuni delle province del lazio ordinati per province/comune
select p.id, p.nome as provincia, c.id, c.nome as comune
from province p 
inner join comuni c
on p.id = c.id_provincia 
where p.id_regione in (select id from regioni where nome = "lazio")
order by 2,4;

-- risolvere la medesima select con le join
select p.id, p.nome as provincia, c.id, c.nome as comune
from province p 
inner join comuni c
on p.id = c.id_provincia 
inner join regioni r
on  p.id_regione = r.id 
where r.nome ="lazio"
order by p.nome, c.nome;

-- left (outer) join
select a.id_cliente, b.id_cliente, a.nome, a.cognome, b.data, b.valore
from clienti a
left outer join ordini b 
on a.id_cliente = b.id_cliente
where b.id_cliente is null;

-- di che provincia sono i clienti cattivi?
select provincia, a.id_cliente, b.id_cliente, a.nome, a.cognome, b.data, b.valore
from clienti a
left outer join ordini b 
on a.id_cliente = b.id_cliente
where b.id_cliente is null;

-- 
select  p.nome as provincia, a.id_cliente, b.id_cliente, a.nome, a.cognome, b.data, b.valore
from province p 
inner join clienti a
on p.sigla_automobilistica = a.provincia 
left outer join ordini b
on a.id_cliente = b.id_cliente
where b.id_cliente is null;

-- 
select a.id_cliente, b.id_cliente, a.nome, a.cognome,a.citta , b.data, b.valore
from clienti a
left outer join ordini b
on a.id_cliente = b.id_cliente
inner join comuni c
on a.citta = c.nome
inner  join province p
on c.id_provincia  = p.id
where b.id_cliente is null;

-- right join
select a.id_cliente, b.id_cliente, a.nome, a.cognome, b.data, b.valore
from clienti a
right outer join ordini b
on a.id_cliente = b.id_cliente;

-- right join con inclusione solo del lato outer
select a.id_cliente, b.id_cliente, a.nome, a.cognome, b.data, b.valore
from clienti a
right outer join ordini b
on a.id_cliente = b.id_cliente;
where a.id_cliente is null;

-- right join per inversione della left
-- ci sono problemi nel DB, ordini senza cliente
select a.id_cliente, b.id_cliente, a.nome, a.cognome, b.data, b.valore
from ordini b
left outer join clienti a
on a.id_cliente = b.id_cliente;

-- full join (left union right)
select a.id_cliente, b.id_cliente, a.nome, a.cognome, b.data, b.valore
from clienti a
left outer join ordini b
on a.id_cliente = b.id_cliente
union
select a.id_cliente, b.id_cliente, a.nome, a.cognome, b.data, b.valore
from clienti a
right outer join ordini b
on a.id_cliente = b.id_cliente;

-- full join (left union right) solo dei fallimenti di join
select a.id_cliente, b.id_cliente, a.nome, a.cognome, b.data, b.valore
from clienti a
left outer join ordini b
on a.id_cliente = b.id_cliente
where b.id_cliente is null
union
select a.id_cliente, b.id_cliente, a.nome, a.cognome, b.data, b.valore
from clienti a
right outer join ordini b
on a.id_cliente = b.id_cliente
where a.id_cliente is null;





