# Предварительная настройка

docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres -d postgres

docker run -it --rm --link postgres:postgres postgres psql -h postgres -U postgres

create database assignment;

Смотрим на каком IP поднялся postgres у Docker и этот IP прописываем в файл
/assignment2_evgenyigumnov/src/main/resources/application.properties

менять строчку:
spring.datasource.url=jdbc:postgresql://192.168.99.100/assignment

Инициализация структур БД происходит вовремя запуска автоматически
Наполнение начальными данными тамже

# Запуск тестов и сервера

mvn clean compile test spring-boot:run

# Визуальная проверка

http://localhost:8080/
http://localhost:8080/api/student
http://localhost:8080/api/degree
http://localhost:8080/api/course

