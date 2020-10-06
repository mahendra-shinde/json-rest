# Spring boot : Using XML Response in REST

1.  No additional dependency required
2.  Model class must have annotation `@XmlRootElement`
3.  Modify your REST Controller method to produce both XML and JSON

    ```
   	@GetMapping(value="/{id}",produces = {"application/xml","application/json"})
	public ResponseEntity<Loan> find(@PathVariable int id) {
		Loan loan = service.findLoan(id);
		if (loan == null) {
			return new ResponseEntity<Loan>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Loan>(loan, HttpStatus.OK);
	}
    ```

4.  Use POSTMAN to create new GET request.
    Request Header:  Accept=application/json
                     Accept=application/xml