# MVC Form demo

1.  Create new Spring boot starter project `mvc-demo3` with following dependencies:

    spring-web, spring devtools, thymeleaf


2.  Create Model class `Loan`

    ```java
    private String firstName;
	private String lastName;
	private String loanType;
	private double amount;
    ```

3.  Generate Getters/Setters & Two Constructors inside `Loan` class.

4.  Create a Controller class `LoanController`

    ```java
    @Controller
    @RequestMapping("/apply-loan")
    public class LoanController {

        @GetMapping
        public String showForm(Model map){
            Loan loan = new Loan();
            map.addAttribute("loan",loan);
            return "form";
        }
        
        @PostMapping
        public String submit(@ModelAttribute("loan") Loan loan, Model map) {
            //AFTER SUBMIT, Collect user input into LOAN object
            System.out.println("Processing loan for "+loan.getFirstName());
            map.addAttribute("loan",loan);
            map.addAttribute("msg","Your request is accepted!");
            return "success";
        }
    }
    ```

5.  Create a new template page `form.html` (src/main/resources/templates)

    ```htm
    <!DOCTYPE html>
    <html xmlns:th="https://www.thymeleaf.org">
    <head>
    <meta charset="ISO-8859-1">
    <title>Loan Application</title>
    </head>
    <body>
        <form action="#" th:action="@{/apply-loan}" th:object="${loan}" method="post">
            Name of applicant: <input type="text" th:field="*{firstName}" /><input type="text" th:field="*{lastName}" /><br/>
            Loan type: <input type="text" th:field="*{loanType}" /><br/>
            Amount needed: <input type="text" th:field="*{amount}" /><br/>
            <input type="submit" value="submit" />
        </form>
    </body>
    </html>
    ```

6.  Create a Success page `success.html`

    ```html
    <!DOCTYPE html>
    <html xmlns:th="https://www.thymeleaf.org">

    <head>
    <meta charset="ISO-8859-1">
    <title>Apply for loan</title>
    </head>
    <body>
    <h2 th:text="${msg}"></h2>
    <h3>Loan Application: </h3>
    Name of Applicant: <span th:text="${loan.firstName}" />
    </body>
    </html>
    ```

7.  Run as Spring Boot Application and test URL:
    
    http://localhost:8080/apply-loan

    
