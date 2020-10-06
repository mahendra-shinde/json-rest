package com.mahendra.demo2.controllers;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahendra.demo2.models.Loan;
import com.mahendra.demo2.models.LoanList;
import com.mahendra.demo2.services.LoanService;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

	@GetMapping(value="/",produces={"application/xml","application/json"})
	public LoanList getAll() {
		LoanList list = new LoanList();
		list.setList(service.getAll());		
		return list;
	}
	
	@Autowired
	private LoanService service;
	
	@GetMapping(value="/{id}",produces = {"application/xml","application/json"})
	public ResponseEntity<Loan> find(@PathVariable int id) {
		Loan loan = service.findLoan(id);
		if (loan == null) {
			return new ResponseEntity<Loan>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Loan>(loan, HttpStatus.OK);
	}

	/**	
	//Using PRODUCES annotation, we defined TWO response types
	@GetMapping(value="/xml/{id}",produces = {"application/xml"})
	public ResponseEntity<Loan> findXml(@PathVariable int id) {
		Loan loan = service.findLoan(id);
		if (loan == null) {
			return new ResponseEntity<Loan>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Loan>(loan, HttpStatus.OK);
	}
	
	@GetMapping(value="/json/{id}",produces = {"application/json"})
	public ResponseEntity<Loan> findJSON(@PathVariable int id) {
		Loan loan = service.findLoan(id);
		if (loan == null) {
			return new ResponseEntity<Loan>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Loan>(loan, HttpStatus.OK);
	}
	**/

}
