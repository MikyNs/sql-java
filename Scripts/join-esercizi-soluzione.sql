-- elencare l'età dei figli e delle mardi
SELECT p.name, p.age
FROM person p
INNER JOIN motherchild m 
ON m.mother = p.name;

SELECT p.age as age_mother, m.mother as nome_mother, q.age, m.child 
FROM motherchild m
INNER JOIN person p
ON m.mother = p.name
INNER JOIN person q
ON m.child = q.name;


-- elencare l'età dei figli e delle madri
select m.mother as madre, ' ',ma.age as "età madre", m.child as figlio, f.age as "età figlio"
from motherchild m
join person ma on m.mother = ma.name
join person f on m.child = f.name -- ;
union
-- elencare l'età dei figli e dei padri
select ' ',fc.father as padre, p.age as "età padre", fc.child as figlio, f.age as "età figlio"
from fatherchild fc
join person p on fc.father = p.name
join person f on fc.child = f.name;


-- stampare madre e padre nella medesima riga
select m.mother as madre, ' ',ma.age as "età madre", m.child as figlio, f.age as "età figlio"
from motherchild m
join person ma on m.mother = ma.name
join person f on m.child = f.name -- ;
union
-- elencare l'età dei figli e dei padri
select ' ',fc.father as padre, p.age as "età padre", fc.child as figlio, f.age as "età figlio"
from fatherchild fc
join person p on fc.father = p.name
join person f on fc.child = f.name;

-- steve manca dalla tabella person
insert into person (name, age, income) values ('Steve', 80, 38000 )


SELECT m.mother as madre,   f.father as padre,   p.name as figlio
from person p 
join fatherchild f on p.name = f.child 
 left join motherchild m on p.name = m.child

union

SELECT m.mother as madre,   f.father as padre,   p.name as figlio
from person p
join motherchild m on p.name = m.child 
left  join fatherchild f on p.name = f.child;










