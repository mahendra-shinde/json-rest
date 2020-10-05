# REST DEMO3

1.  Copy the last project with new name rest-demo2

2.  Create a new class `CustomerService` in new package `com.mahendra.restdemo1.services`

    ```java
    @Service
    //Single Instance of CustomerService
    @ApplicationScope
    public class CustomerService {

        private List<Customer> customers = null;

        public CustomerService() {
        
        Customer c1 = new Customer();
        c1.setFirstName("Rajiv");
        c1.setLastName("Bhatia");
        c1.setPhone("7657657657");
        Customer c2 = new Customer();
        c2.setFirstName("Ravi");
        c2.setLastName("Kapoor");
        c2.setPhone("576576576");	
        Customer c3 = new Customer();
        c3.setFirstName("Randheer");
        c3.setLastName("Kapoor");
        c3.setPhone("6876876766");
        Customer c4 = new Customer();
        c4.setFirstName("Ranveer");
        c4.setLastName("Kapoor");
        c4.setPhone("7897867876");
        Customer c5 = new Customer();
        c5.setFirstName("Ashok");
        c5.setLastName("Saraf");
        c5.setPhone("87766576");
        
        customers = new LinkedList<>();
        customers.add(c1);
        customers.add(c2);
        customers.add(c3);
        customers.add(c4);
        customers.add(c5);
        }
        
        public List<Customer> findAll(){
            return customers;
        }
        
        public Customer save(Customer customer) {
            customers.add(customer);
            return customer;
        }
        
        public Customer update(Customer customer,int id) {
            Customer temp = findById(id);
            temp.setFirstName(customer.getFirstName());
            temp.setLastName(customer.getLastName());
            temp.setPhone(customer.getPhone());
            return temp;
        }
        
        public Customer findById(int id) {
            if(id>=customers.size())
                throw new RuntimeException("Record not found!");
            return customers.get(id-1);
        }
        
        public String deleteById(int id) {
            customers.remove(id-1);
            return "deleted!";
        }
    }
    ```

3.  Modify the `CustomerController` class

    ```java
    @RestController
    @RequestMapping("/api/customers/")
    ///The final URL: http://localhost:8080/api/customers
    public class CustomerController {
        
        @Autowired private CustomerService service;
        

        @GetMapping("/")
        ///The final URL: http://localhost:8080/api/customers/
        public List<Customer> getCustomers() {
            System.out.println("Invoked: getCustomers()");
            return service.findAll();		
        }
        
        @GetMapping("/{id}")
        ///The final URL: http://localhost:8080/api/customers/1
        // 1 could be replaced with any number
        public Customer getCustomer(@PathVariable("id") Integer id) {
            System.out.println("Invoked: getCustomer()");
            return service.findById(id);
        }
        
        @PutMapping(value="/{id}",consumes="application/json")
        ///The final URL: http://localhost:8080/api/customers/101
        // 101 could be replaced with any number
        public Customer putCustomer(@PathVariable("id") Integer id,@RequestBody Customer customer) {
            System.out.println("Invoked: putCustomer()");
            return service.update(customer, id);
        }
        
        @PostMapping(value="/", consumes="application/json")
        ///The final URL: http://localhost:8080/api/customers/101
        // 101 could be replaced with any number
        public Customer createCustomer(@RequestBody Customer customer) {
            System.out.println("Invoked: createCustomer()");
            return service.save(customer);
        }
        
        @DeleteMapping(value="/{id}")
        public String delete(@PathVariable("id") int id) {
            System.out.println("Invoked: delete()");
            return service.deleteById(id);
        }
        
    }

    ```

4.  Test using Postman

    4.1 GET http://localhost:8080/api/customers/
    
    4.2 PUT http://localhost:8080/api/customers/2
            
            REQUEST BODY : Choose RAW > 'JSON' 

            ```json
            {
            "firstName": "Jeetendra",
            "lastName": "Kapoor",
            "phone": "576576576"
            }
            ```

    4.3 POST http://localhost:8080/api/customers/

        REQYEST BODY: Choose RAW > 'JSON'

        ```json
        {
            "firstName": "Mahendra",
            "lastName": "Shinde",
            "phone": "576576576"
        }
        ```