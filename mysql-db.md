## application.properties for MySQL DB

spring.datasource.url=jdbc:mysql://localhost:3306/[dbname]
spring.datasource.username=root
spring.datasource.password=welcome123
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
## instruct hibernate (ORM) to create all SQL Queries compatible with H2 Database
spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect
## DEBUG : display generated SQL queries in CONSOLE
spring.jpa.show-sql=true
## Create the TABLES on-the-fly!!!!
spring.jpa.generate-ddl=true
