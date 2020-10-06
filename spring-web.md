# Build a new Spring boot (web) application

1. Create `Loan` model class [DO NOT USE ANY ANNOTATION]
    properties: loanId, custName, amount, duration, rateOfInterest

2. Create following "Repository" class 

    Classname: LoanRepository

    Instance variable:  List<Loan> loans
    Add 2/3 loan instance

    C.R.U.D.

3. Create another Service class
    classname: LoanService

    Autowire "LoanRepository"

    CRUD Method 

4.  RestController 'LoanController'

    GET /loans/
    POST /loans
    DELETE /loans/1
