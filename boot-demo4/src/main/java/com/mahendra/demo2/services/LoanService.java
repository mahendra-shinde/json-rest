package com.mahendra.demo2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahendra.demo2.daos.LoanRepository;
import com.mahendra.demo2.models.Loan;

@Service
public class LoanService {

	@Autowired private LoanRepository dao;
	
	public Loan create(Loan loan) {
		return dao.save(loan);
	}
	
	
	public List<Loan> getAll(){
		
		return dao.getAll();
	}
	public Loan updateCustomer(String customer, int loanId) {
		Loan temp = dao.findById(loanId);
		if(temp==null)
			return null;
		temp.setCustName(customer);
		dao.update(temp);
		return temp;
	}
	
	public Loan findLoan(int loanId) {
		return dao.findById(loanId);
	}
}
