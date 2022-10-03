##
## come effetturare le selezioni
##
SELECT id, nome FROM comuni WHERE nome LIKE 'o%';

SELECT nome as comune, id_provincia 
FROM comuni 
WHERE iD_regione in(
	select id 
	from regioni
	where nome ="campania" and id_provincia != 63
)
order by nome;


SELECT count(*) from(
SELECT nome as comune, id_provincia
FROM comuni 
WHERE id_regione in(
	select id_regione 
	from regioni r
	where r.nome ="campania"
) AND id_provincia NOT IN (
	Select id 
	FROM province p
	WHERE p.nome = 'Napoli'
)
) xyz
where id_provincia = '63';
