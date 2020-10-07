# MVC Form Validation using JSR 303 Validation API (Annotation based)

1. Follow steps in [mvc-forms.md](./mvc-forms.md) first to create mvc-demo3

2.  Modify the model class `Loan.java`

    ```java
    import javax.validation.constraints.Min;
    import javax.validation.constraints.NotEmpty;
    import org.hibernate.validator.constraints.Length;

    public class Loan {
        
        @NotEmpty(message = "Firstname is required")
        @Length(min = 3, max = 20,message = "Firstname must be min 3 characters and maximum 20 characters long")
        private String firstName;
        
        @NotEmpty(message = "Lastname is required")
        @Length(min = 3, max = 20,message = "Lastname must be min 3 chars and max 20 chars long")
        private String lastName;
        
        @NotEmpty(message = "Please specify type of loan")
        private String loanType;
        
        @Min(value=10000, message = "Loan amount must be >= 10000")
        private double amount;
        
        ///Getters...Setters...and..constructors
        
    }
    ```

3.  Modify the controller class to include `@Valid` annotation to modelAttribute in submit method:

    ```java
    @PostMapping
	public String submit(@Valid @ModelAttribute("loan") Loan loan,BindingResult result, Model map) {
		//AFTER SUBMIT, Collect user input into LOAN object
		if(result.hasErrors()) {
			System.out.println("Found "+result.getErrorCount()+" errors!!");
			map.addAllAttributes(result.getAllErrors());
			return "form";
		}
		System.out.println("Processing loan for "+loan.getFirstName());
		map.addAttribute("loan",loan);
		map.addAttribute("msg","Your request is accepted!");
		return "success";
	}
    ```

4.  Modify the FORM page to include TAGs for ERROR message!

    ```html
    <form action="#" th:action="@{/apply-loan}" th:object="${loan}" method="post">
		Name of applicant: <input type="text" th:field="*{firstName}" /><input type="text" th:field="*{lastName}" />
		<span class="error" th:if="${#fields.hasErrors('firstName')}" th:errors="*{firstName}" ></span>
		<span class="error" th:if="${#fields.hasErrors('lastName')}" th:errors="*{lastName}" ></span>
		<br/>
		Loan type: <input type="text" th:field="*{loanType}" />
		<span class="error" th:if="${#fields.hasErrors('loanType')}" th:errors="*{loanType}" ></span><br/>
		
		Amount needed: <input type="text" th:field="*{amount}" />
		<span class="error" th:if="${#fields.hasErrors('amount')}" th:errors="*{amount}" ></span><br/>
		
		<input type="submit" value="submit" />
	</form>
    ```