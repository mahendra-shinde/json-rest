package com.mahendra.datademo.models;

import javax.persistence.*;

@Entity
@Table(name="deposits")
public class Deposit {
	
	@Id @Column(name="acc_id")
	private Integer accNumber;
	
	@Column(name="cust_name",length = 25)
	private String custName;
	
	@Column(name="amount",precision = 2, scale = 15)
	private Double amount;

	public Integer getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(Integer accNumber) {
		this.accNumber = accNumber;
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

	public Deposit(Integer accNumber, String custName, Double amount) {
		super();
		this.accNumber = accNumber;
		this.custName = custName;
		this.amount = amount;
	}

	public Deposit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
