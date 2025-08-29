## Установка и запуск

### 1. Склонировать репозиторий

```bash
git clone https://github.com/Mikki158/library
cd library
```

### 2. Настроить подключение к PostgreSQL

Отредактируйте файл `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/librarydb
spring.datasource.username=postgres
spring.datasource.password=assword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
server.port=8080
```

### 3. Собрать проект

```bash
mvn clean package
```

### 4. Запустить приложение

```bash
java -jar target/library-app-0.0.1-SNAPSHOT.jar
```

### 5. Открыть в браузере

* **Список книг:** [http://localhost:8080/books](http://localhost:8080/books)
* **Список клиентов:** [http://localhost:8080/clients](http://localhost:8080/clients)
* **Список взятых книг:** [http://localhost:8080/readings](http://localhost:8080/readings)
* **REST API для читаемых книг:** [http://localhost:8080/api/readings](http://localhost:8080/api/readings)

Хочешь, чтобы я это сделал?
