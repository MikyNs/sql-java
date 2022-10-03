SELECT * -- evitare
FROM regioni;

describe regioni;

SELECT id, nome as regione, latitudine, longitudine
FROM regioni
WHERE id = 5 or id = 13 or id = 1;


SELECT id, nome as regione, latitudine, longitudine
FROM regioni
WHERE id in(5, 13, 1);

SELECT id, nome as regione, latitudine, longitudine
FROM regioni
WHERE id in(5, 13, 1)
order by nome, id, 3 desc;

SELECT id, nome as regione, latitudine, longitudine
FROM regioni
WHERE id in(5, 13, 1)
order by 2;

SELECT id, nome as regione, latitudine, longitudine
FROM regioni
WHERE id in(5, 13, 1)
order by 2 desc;

SELECT id, nome
FROM regioni 
order by nome;

SELECT id, nome
FROM province
WHERE id_regione in(12,15)
order by nome;

SELECT id, nome
FROM comuni 
WHERE iD_regione in(
	select id 
	from regioni
	where nome ="basilicata"
)
order by nome;

select "Regioni:" as "tipo", count(*) as conteggio from regioni
union
select "Province:", count(*) from province
union
select "Comuni:", count(*) from comuni
;








