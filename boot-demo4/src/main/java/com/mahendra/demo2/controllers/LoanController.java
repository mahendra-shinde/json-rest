package com.mahendra.demo2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahendra.demo2.models.Loan;
import com.mahendra.demo2.services.LoanService;

@RestController
@RequestMapping("/api/loans")
public class LoanController {
	
	@Autowired private LoanService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Loan> find(@PathVariable int id) {
		Loan loan = service.findLoan(id);
		if(loan==null) {
			return new  ResponseEntity<Loan>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Loan>(loan,HttpStatus.OK);
	}
	
}
