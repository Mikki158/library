Установка и запуск

Склонировать репозиторий:

git clone https://github.com/Mikki158/library
cd library


Настроить подключение к PostgreSQL в файле src/main/resources/application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/librarydb
spring.datasource.username=postgres
spring.datasource.password=assword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
server.port=8080


Собрать проект:

mvn clean package


Запустить приложение:

java -jar target/library-app-0.0.1-SNAPSHOT.jar


Открыть в браузере:

Список книг: http://localhost:8080/books

Список клиентов: http://localhost:8080/clients

Список взятых книг: http://localhost:8080/readings

REST API для читаемых книг: http://localhost:8080/api/readings