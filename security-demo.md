# Launch the h2 console from Command line

1. Open command prompt and type these commands

    ```
    cd .m2\repository\com\h2database\h2\1.4.200
    java -jar h2-1.4.200.jar
    ```

2.  Provide connection string

    ```yml
    JDBC-URL: jdbc:h2:~/db2
    Username: hr
    Password: hr
    ```

3.  Run following SQL Query to create the schema

    ```sql
    CREATE TABLE `users` (
    `username` VARCHAR(50) NOT NULL,
    `password` VARCHAR(120) NOT NULL,
    `enabled` TINYINT(1) NOT NULL,
    PRIMARY KEY (`username`)
    );
    -- authorities table structure
    CREATE TABLE `authorities` (
    `username` VARCHAR(50) NOT NULL,
    `authority` VARCHAR(50) NOT NULL,
    
    CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`)
    REFERENCES `users` (`username`)
    );
    ```

4.  Once table is created, go back to command prompt and press CTRL+C to stop h2 database

5.  Create New Spring starter project

    spring-security, spring-web, h2, data-jpa

6.  Application properties `src/main/resources/application.properties`

    ```ini
    spring.datasource.url= jdbc:h2:~/db2
    spring.datasource.username=hr
    spring.datasource.password=hr
    spring.datasource.driver-class-name=org.h2.Driver
    spring.h2.console.enabled=true
    ```

7.  Create WebSecurityConfiguration class in base-package

    ```java
    @Configuration
    @EnableWebSecurity
    public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        private static final String ADMIN = "ADMIN";
        private static final String USER = "USER";

        @Autowired
        private DataSource dataSource;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.jdbcAuthentication().dataSource(dataSource)
                .passwordEncoder(passwordEncoder());
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().authorizeRequests()
                .antMatchers("/admin").hasRole(ADMIN)
                .antMatchers("/user").hasAnyRole(ADMIN, USER)
                .antMatchers("/", "/register-user").permitAll()
                .and().httpBasic();
        }
        
        @Bean
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }

        @Bean
        public JdbcUserDetailsManager jdbcUserDetailsManager() {
            return new JdbcUserDetailsManager(dataSource);
        }
    }
    ```

8.  Create a User model class in models package

    ```java
    public class MyUser {

        private String userName;
        private String password;
        private String roles;

        // Generate Getters and Setters...

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRoles() {
            return roles;
        }

        public void setRoles(String roles) {
            this.roles = roles;
        }

    }
    ```

9.  Create controller class in `controllers` package

    ```java
    @RestController
    public class UserController {

        @Autowired
        private JdbcUserDetailsManager jdbcUserDetailsManager;

        @Autowired
        private BCryptPasswordEncoder passwordEncoder;

        @PostMapping(value = "/register-user")
        public String regiter(@RequestBody MyUser myUser) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(myUser.getRoles()));
            String encodededPassword = passwordEncoder.encode(myUser.getPassword());
            User user = new User(myUser.getUserName(), encodededPassword, authorities);
            jdbcUserDetailsManager.createUser(user);
            return "User created :)";
        }

        @GetMapping(value = "/admin")
        public String admin() {
            return "<h3>Welcome Admin :)</h3>";
        }

        @GetMapping(value = "/user")
        public String user() {
            return "<h3>Hello User :)</h3>";
        }

        @GetMapping(value = "/")
        public String welcome() {
            return "<h3>Welcome :)</h3>";
        }
    }

    ```

10. To run application as spring boot application
    Use postman to create a new user

    POST    http://localhost:8080/register-user

    Request Body : Raw/JSON
    ```json
    {
        "userName":"superman",
        "password":"super",
        "roles":"ROLE_ADMIN"
    }
    ````

11. Use Postman (new tab) to test admin user 

    GET http://localhost:8080/admin

    Request Header:
    Authentication: 
        username: superman
        password: super
