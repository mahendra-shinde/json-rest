package com.mahendra.demo2.daos;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mahendra.demo2.models.Loan;

@Repository
public class LoanRepository {

	private List<Loan> loans = null;
	
	public LoanRepository() {
		loans = new LinkedList<>();
		loans.add(new Loan(101, "Deepika", 12000D, 3, 12.5));
		loans.add(new Loan(102,"Sara",14000D, 5, 11.9));
		loans.add(new Loan(103, "Rakool",15000D, 3, 15D));
	}
	
	public List<Loan> getAll(){
		return loans;
	}
	
	public Loan save(Loan loan) {
		loans.add(loan);
		return loan;
	}
	
	public Loan update(Loan loan) {
		Loan temp = findById(loan.getLoanId());
		temp.setAmount(loan.getAmount());
		temp.setCustName(loan.getCustName());
		temp.setRateOfInterest(loan.getRateOfInterest());
		temp.setDuration(loan.getDuration());
		return temp;
	}
	
	public Loan findById(int loanId) {
		for(Loan l : loans) {
			if(l.getLoanId() == loanId) {
				return l;
			}
		}
		return null;
	}
	
	public Loan deleteById(int loanId) {
		Loan temp = findById(loanId);
		loans.remove(temp);
		return temp;
	}
}
