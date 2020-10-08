## Rest Repository Demo

1.  Create new Spring starter project with following dependencies:

    - spring-web
    - spring-data-jpa
    - spring-rest-repositories
    - h2-database
    - devTools

2.  add properties to `application.properties` file

    ```ini
    ## Using Embedded Database mode
    spring.datasource.url= jdbc:h2:~/db1
    spring.datasource.username=hr
    spring.datasource.password=hr
    spring.datasource.driver-class-name=org.h2.Driver
    ## instruct hibernate (ORM) to create all SQL Queries compatible with H2 Database
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
    ## DEBUG : display generated SQL queries in CONSOLE
    spring.jpa.show-sql=true
    spring.h2.console.enabled=true
    ```

3.  Create a simple `HomeController`

    ```java
    @RestController
    @RequestMapping("/")
    public class HomeController {

        @GetMapping
        public String home() {
            return "hello world";
        }
    }
    ```

4.  Run as Spring boot application, visit http://localhost:8080/h2-console/

    ```sql
    CREATE table accounts
    (
    acc_no int primary key,
    acc_holder varchar(20),
    balance double,
    status char(1) default 'A');

    INSERT into accounts values(1001, 'Rakesh', 12000, 'A');
    INSERT into accounts values(1002, 'Ramesh', 1000, 'A');
    INSERT into accounts values(1003, 'Ganesh', 10000, 'A');
    ```