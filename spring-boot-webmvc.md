# Spring Boot-WebMVC with Thymeleaf template

1.  Create new spring-boot starter project with dependencies:

    - web
    - thymeleaf
    - devTools (optional)

2.  Create a new model class `Greeting`

    ```java
    public class Greeting {
        private String name;
        private String message;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }
        public Greeting(String name, String message) {
            super();
            this.name = name;
            this.message = message;
        }
        public Greeting() {
            super();
            // TODO Auto-generated constructor stub
        }
        
    }
    ```

3.  Create a new static html page `index.html` inside `src/main/resources/static` folder

    ```html
    <html>
    <head>
    <title>Greetings Application</title>
    </head>

    <body>
    <h2>Greetings App</h2>
    <form action="greet" method="post">
        Enter your name: <input type="text" name="uname" />
        <input type="submit" value="submit"/>
    </form>

    </body>
    </html>
    ```

4.  Create a new controller class `GreetingController`

    ```java
    @Controller
    @RequestMapping("/greet")
    public class GreetingController {

        @PostMapping
        public String greetNow(@RequestParam("uname") String uname, Model map) {
            System.out.println("Processing request for username: "+uname);
            Greeting greeting = new Greeting(uname, "Hey "+uname+", have a nice day!");
            map.addAttribute("greet",greeting);
            return "greet";
        }   
    }
    ```

5.  Create a new ThymeLeaf template (html page) named `greet.html` inside `src/main/resources/templates`

    ```html
    <!DOCTYPE html>
    <html xmlns:th="https://www.thymeleaf.org">
    <head>
    <meta charset="ISO-8859-1">
    <title>Greetings</title>
    </head>
    <body>
        <h2>
            Greeting: <span th:text="${greet.message}"></span>
        </h2>
    </body>
    </html>
    ```

6.  Run as Spring boot Application and access url http://localhost:8080/