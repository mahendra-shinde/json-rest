package com.mahendra.demo2.models;

public class Loan {

	private Integer loanId;
	private String custName;
	private Double amount;
	private Integer duration;
	private Double rateOfInterest;
	
	
	
	public Loan(Integer loanId, String custName, Double amount, Integer duration, Double rateOfInterest) {
		super();
		this.loanId = loanId;
		this.custName = custName;
		this.amount = amount;
		this.duration = duration;
		this.rateOfInterest = rateOfInterest;
	}
	public Loan() {
		super();
	}
	public Integer getLoanId() {
		return loanId;
	}
	public void setLoanId(Integer loanId) {
		this.loanId = loanId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Double getRateOfInterest() {
		return rateOfInterest;
	}
	public void setRateOfInterest(Double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}
	
	
}
