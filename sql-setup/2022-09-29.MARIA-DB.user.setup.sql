use mysql;
-- Per determinare il valore della password:
-- select password('manager');
-- result:
-- *7D2ABFF56C15D67445082FBB4ACD2DCD26C0ED57
-- crea utente master con password manager con tutti i privilegi

drop database  if exists `corso`;

drop user if exists 'master'@'localhost';

drop user if exists 'master'@'%';

create user 'master'@'localhost' identified via mysql_native_password using password('manager');

create user 'master'@'%' identified via mysql_native_password using password('manager');

grant all privileges on *.* to 'master'@'localhost' require none
	with grant option max_queries_per_hour 0 max_connections_per_hour 0 max_updates_per_hour 0 max_user_connections 0;

grant all privileges on *.* to 'master'@'%' require none
	with grant option max_queries_per_hour 0 max_connections_per_hour 0 max_updates_per_hour 0 max_user_connections 0;

-- crea database corso
create database if not exists `corso`;

-- associa il database con l'utente
grant all privileges on `corso`.* to 'master'@'localhost';

grant all privileges on `corso\_%`.* to 'master'@'localhost';

grant all privileges on `corso`.* to 'master'@'%';

grant all privileges on `corso\_%`.* to 'master'@'%';


