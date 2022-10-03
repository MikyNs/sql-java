
START TRANSACTION; -- attiva la transazione 

DELETE FROM person;
SELECT count(*) FROM person;

ROLLBACK;

SELECT count(*) FROM person;

START TRANSACTION; -- attiva la transazione 

DELETE FROM fatherchild;

SELECT count(*) FROM fatherchild;

COMMIT; -- rende persistente l'aggiornamento

