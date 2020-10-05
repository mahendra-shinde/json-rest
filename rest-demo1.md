# REST DEMO1

1.  Using SpringTool Suite, create a new "Spring Starter Project"

2.  Project Details:

    ```yml
    Name: rest-DEMO1
    ArtifactId: restdemo1
    GroupId:  com.mahendra
    base-package: com.mahendra.restdemo1
    Dependencies:  Spring-Web
    Language: Java
    Project Type: Maven
    Java Version: 8
    Packaging: JAR
    ```

3.  Create a new Class `Customer` in package `com.mahendra.restdemo1.models` package

    ```java
    //POJO: Plain Old Java Object

    //POJO: Class MUST BE PUBLIC
    //POJO: Class name must be in "TitleCase"

    public class Customer {
        
        //POJO: Must have DEFAULT NO_ARG CONSTRUCTORS (public)
        public Customer() {
            
        }

        //POJO: All properties must be PRIVATE and names should be in "camelCase"
        private String firstName;
        private String lastName;
        private String phone;
        
        //POJO: Getters (Accessors) and Setters (Mutators) for properties

        public String getFirstName() {
            return firstName;
        }
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        public String getLastName() {
            return lastName;
        }
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        public String getPhone() {
            return phone;
        }
        public void setPhone(String phone) {
            this.phone = phone;
        }
        
        
    }
    ```

4.  Create a Class `CustomerController` in package `com.mahendra.restdemo1.controllers`

    ```java
    @RestController
    @RequestMapping("/api/customers/")
    ///The final URL: http://localhost:8080/api/customers
    public class CustomerController {

        @GetMapping("/")
        ///The final URL: http://localhost:8080/api/customers/
        public String getCustomers() {
            System.out.println("Invoked: getCustomers()");
            return "List of Customers";
        }
        
        @GetMapping("/{id}")
        ///The final URL: http://localhost:8080/api/customers/101
        // 101 could be replaced with any number
        public String getCustomer(@PathVariable("id") Integer id) {
            System.out.println("Invoked: getCustomer()");
            return "Customer details of "+id;
        }
        
        @PutMapping("/{id}")
        ///The final URL: http://localhost:8080/api/customers/101
        // 101 could be replaced with any number
        public String putCustomer(@PathVariable("id") Integer id) {
            System.out.println("Invoked: putCustomer()");
            return "Modifying customer "+id;
        }
        
        @DeleteMapping("/{id}")
        ///The final URL: http://localhost:8080/api/customers/101
        // 101 could be replaced with any number
        public String deleteCustomer(@PathVariable("id") Integer id) {
            System.out.println("Invoked: deleteCustomer");
            return "Deleting customer "+id;
        }
           
    }
    ```

5.  Open `application.properties` file from `src/main/resources` and add following line:

    ```ini
    server.port=8080
    ```

6.  Run application as Spring boot project

7.  Use Postman to fire following request:

    GET http://localhost:8080/api/customers/
    GET http://localhost:8080/api/customers/101
    PUT http://localhost:8080/api/customers/101
    DELETE http://localhost:8080/api/customers/101
    OPTIONS http://localhost:8080/api/customers/101
