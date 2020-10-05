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