# Rest DEMO2

1.  Open the last rest-demo and goto `CustomerController` class

2.  Add new instance variable and a constructor.

    ```java
    private List<Customer> customers = null;
	
	public CustomerController() {
		Customer c1 = new Customer();
		c1.setFirstName("Rajiv");
		c1.setLastName("Bhatia");
		c1.setPhone("7657657657");
		Customer c2 = new Customer();
		c2.setFirstName("Ravi");
		c2.setLastName("Kapoor");
		c2.setPhone("576576576");	
		customers = Arrays.asList(c1,c2);
	}
	
    ```

3.  Replace the old "getCustomers()" method (first GET method) with following code


    ```java
	@GetMapping("/")
	///The final URL: http://localhost:8080/api/customers/
	public List<Customer> getCustomers() {
		System.out.println("Invoked: getCustomers()");
		return customers;		
	}
    ```