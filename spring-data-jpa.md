## Spring DATA-JPA

1.  Create new Spring starter project `data-demo1` with following dependencies:

    ```yaml
    boot-devTools
    data-jpa
    H2 Database
    Spring-Web
    ```

2.  Open `src/main/resources/application.properties` add following :

    ```ini
    spring.datasource.url=jdbc:h2:mem:db1
    spring.datasource.username=hr
    spring.datasource.password=hr
    spring.datasource.driver-class-name=org.h2.Driver
    ## instruct hibernate (ORM) to create all SQL Queries compatible with H2 Database
    spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
    ## DEBUG : display generated SQL queries in CONSOLE
    spring.jpa.show-sql=true
    ## Create the TABLES on-the-fly!!!!
    spring.jpa.generate-ddl=true
    ## Enable h2-console http://localhost:8080/h2-console/
    spring.h2.console.enabled=true
    ```

3.  Create an Entity class `Deposit`

    ```java
    import javax.persistence.*;

    @Entity //An Object which is LINKED to DB Table
    @Table(name="deposits") //Name of Linked Table
    public class Deposit {
        
        @Id @Column(name="acc_id")
        private Integer accNumber;
        
        @Column(name="cust_name",length = 25)
        private String custName;
        
        @Column(name="amount",precision = 2, scale = 15)
        private Double amount;
        //Getters, Setters & no-arg Constructor
    }
    ```

4.  Create a new Repository/DAO Interface with name `DepositRepository`

    ```java
    @Repository
    public interface DepositRepository extends CrudRepository<Deposit, Integer>{

    }
    ```

5.  Create a new Service class `DepositService`

    ```java
    @Service
    public class DepositService {

        @Autowired
        private DepositRepository dao;
        
        public Deposit save(Deposit deposit) {
            return dao.save(deposit);
        }
        
        public Deposit update(Deposit deposit) {
            return dao.save(deposit);
        }
        
        public void delete(int id) {
            dao.deleteById(id);
        }
        
        public List<Deposit> getAll(){
            List<Deposit> deposits = new LinkedList<>();
            dao.findAll().forEach(deposit -> deposits.add(deposit));
            return deposits;
        }
    }

    ```

6.  Create the REST Controller `DepositController`

    ```java
    @RestController
    @RequestMapping("/api/deposits")
    public class DepositController {
        
        @Autowired
        private DepositService service;
        
        
        @GetMapping("/")
        public List<Deposit> getAll(){
            return service.getAll();
        }
    }
    ```

7.  Run as Spring-boot-application

8.  Visit URL http://localhost:8080/h2-console

    ```yml
    URL: jdbc:h2:mem:db1
    Username: hr
    Password: hr
    ```

9.  Run following Query to create a sample record

    ```sql
    INSERT into deposits VALUES (101, 12000, 'Vijay');
    INSERT into deposits VALUES (102, 11000, 'Ajay');
    ```

10. Visit another URL in browser tab

    http://localhost:8080/api/deposits/