## Rest Repository Demo

> Spring DATA-REST is module to create REST endpoints/controller from MODEL class directly!

> No need of DAO classes and SERVICE classes.


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
    ## Disable TABLE DROP/CREATE (Only for Embedded Database)
    ## The below statement is DEFAULT for all external dbs like MySQL, Oracle, MSSQL & Postgres
    spring.jpa.hibernate.ddl-auto=none
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

5.  Create a model class `Account`

    ```java
    @Entity
    @Table(name="accounts")
    public class Account {
	
	@Id @Column(name="acc_no")
	private Integer accNo;
	
	@Column(name="acc_holder")
	private String accHolder;
	
	@Column(name="balance")
	private Double balance;
	
	@Column(name="status",length = 1)
	private String status;
    //getters, setters & constructors...
    }
    ```

6.  Create a new REST Repository interface `AccountRepository` in package `com.mahendra.restproject1.controllers`

    ```java
    @RepositoryRestResource(collectionResourceRel = "accounts",path="account")
    public interface AccountRepository extends PagingAndSortingRepository<Account, Integer> {

    }
    ```

7.  Run application once again, and try visiting URL:

    http://localhost:8080/account/
    http://localhost:8080/account/1001


8.  Using Postman create POST request

    POST http://localhost:8080/account/

    Request body [Raw, JSON]
    
    ```json
    {
    "accNo": 1004, 
    "accHolder": "Suresh",
    "balance": 10000.0,
    "status": "A"
    }
    ```

9.  Test using URL: http://localhost:8080/account/1004