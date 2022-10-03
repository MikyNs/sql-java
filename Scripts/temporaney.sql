CREATE TEMPORARY TABLE tprova (
	chiave int PRIMARY KEY,
	valore int
);

INSERT INTO tprova (chiave,valore) VALUES
(1,0), (2,18), (3,100);

SELECT * FROM tprova;

CREATE TEMPORARY TABLE tprova2 (
	id int PRIMARY KEY auto_increment;
	valore int
);

INSERT INTO tprova(valore) VALUES (1), (44), (777), (88), (96), (109);

SELECT * FROM tprova2;

DELETE FROM tprova2 WHERE id=0;