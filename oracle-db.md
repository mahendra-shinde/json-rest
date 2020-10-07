## application.properties for Oracle DB

```ini
spring.datasource.url=jdbc:oracle:thin:localhost:1521/xe
spring.datasource.username=test
spring.datasource.password=welcome123
spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
## instruct hibernate (ORM) to create all SQL Queries compatible with H2 Database
spring.jpa.database-platform=org.hibernate.dialect.OracleDialect
## DEBUG : display generated SQL queries in CONSOLE
spring.jpa.show-sql=true
## Create the TABLES on-the-fly!!!!
spring.jpa.generate-ddl=true
```