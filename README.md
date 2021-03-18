# registration-login-springboot-security-thymeleaf
registration-login-module using springboot, spring mvc, spring security and thymeleaf
https://blog-tech.groupeonepoint.com/spring-boot-docker-comment-rendre-ca-un-peu-plus-green/

http://www.javaguides.net/2018/10/user-registration-module-using-springboot-springmvc-springsecurity-hibernate5-thymeleaf-mysql.html
https://www.javatuto.com/docker/docker-how-to-list-containers/
https://blogs.perficient.com/2020/07/23/docker-for-windows-with-building-docker-images/

docker container run --name mysqldb --network employee-mysql -e MYSQL_ROOT_PASSWORD=operantic -e MYSQL_DATABASE=operanticdb -d mysql:8
docker run --name demo-mysql -e MYSQL_ROOT_PASSWORD=operantic -e MYSQL_DATABASE=operanticdb MYSQL_USER=operantic -e MYSQL_PASSWORD=operantic -d mysql:8

docker run --name operanticdb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=operantic -d mysql/mysql-server:8


docker-compose up démarre les services décrits dans mon docker-compose.yml et ne me rend pas la main.
docker-compose up -d fait la même chose mais me rend la main une fois que les services sont démarrés.
docker-compose up –build reconstruit les services avant de les lancer.

docker-compose down stoppe les services.

docker-compose restart redémarre l’ensemble des services.
docker-compose restart nginx redémarre un des services (ici nginx).

docker-compose exec rails bash me fournit une console bash au sein du conteneur rails.
docker-compose exec rails bin/rails db:migrate effectue un rails db:migrate au sein du conteneur rails.

docker-compose logs me retourne l’ensemble des logs des services depuis le dernier démarrage et me rend la main.
docker-compose logs -f affiche les logs des services et continue à les « écouter » sans me rendre la main.
docker-compose logs -f rails fait la même chose pour le conteneur rails uniquement.

https://www.youtube.com/watch?v=XV9Cvn0DrHg&list=PLgOUQYMnO_STL4dsvG8gfZ88QIFEB4c1w&index=3
https://www.xarg.org/puzzles/
