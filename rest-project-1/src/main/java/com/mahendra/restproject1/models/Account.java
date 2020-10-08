package com.mahendra.restproject1.models;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

	@Id
	@Column(name = "acc_no")
	private Integer accNo;

	@Column(name = "acc_holder")
	private String accHolder;

	@Column(name = "balance")
	private Double balance;

	@Column(name = "status", length = 1)
	private String status;

	public Integer getAccNo() {
		return accNo;
	}

	public void setAccNo(Integer accNo) {
		this.accNo = accNo;
	}

	public String getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(String accHolder) {
		this.accHolder = accHolder;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Integer accNo, String accHolder, Double balance, String status) {
		super();
		this.accNo = accNo;
		this.accHolder = accHolder;
		this.balance = balance;
		this.status = status;
	}

}
