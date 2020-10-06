# Dependency Injection (DI)

* Dependency Injection is one of the implementation of Inversion of Control
* Inversion of Control & Dependency Injection were MAIN features of Spring framework
* These features were also available in legacy spring framework (prior to spring boot)
* No Additional starter-pom required.
* Another alternative to IoC is DL (dependency lookup) which JAVAEE provides.
* Inversion of Control (IoC) simply means, DO NOT let components create their dependencies
    
    eg. Traditional Approach
    
    ```java
    public class AccountController{

        private AccountService service = null;

        public AccountController(){
            // You are allowing "AccountController" to create instance of
            // it's dependency 'AccountService
            service = new AccountService();
        }
    }
    ```

*   IoC with Dependency Injection

    ```java
    @Component // Mark this class as CAN BE INJECTED SOMEWHERE!
    public class AccountController{

        //Use spring's IOC Container to INJECT instance of AccountService
        @Autowired
        private AccountService service = null;

        public AccountController(){
            
        }
    }
    ```

*   Only those classes with annotations `@Controller`, `@Service`, `@Repository`, `@Controller` or `@RestController` could be used for auto-wiring.
