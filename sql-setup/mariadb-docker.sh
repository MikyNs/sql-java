
# Start mariadb docker container
docker run  --rm  --detach --name db-mariadb -v mariadb-dati-2209:/var/lib/mysql --env MARIADB_ROOT_PASSWORD=root  -p 3306:3306 mariadb:latest


# per fermare il container
docker stop db-mariadb

exit

# ispeziona i dati del container (es: indirizzo di rete)
docker container inspect db-mariadb

## collegamento all'interno del container tramite la shell bash (apre un terminale interattivo)
docker exec -it db-mariadb bash

## collegamento al container via client mysql
docker run -it --rm mariadb mysql -h 172.17.0.2 -u master -p

## collegamento a mariadb monitor
docker exec -it db-mariadb mariadb --user root -proot

## backup del database
docker exec db-mariadb sh -c 'exec mariadb-dump --add-drop-database --flush-privileges -umaster -pmanager --databases corso ' > corso_backup.sql

## restore del database
docker exec -i db-mariadb sh -c "exec mysql -h localhost -umaster -pmanager" < corso_backup.sql

