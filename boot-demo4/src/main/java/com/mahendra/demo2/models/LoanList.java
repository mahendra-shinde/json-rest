package com.mahendra.demo2.models;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="loans")
public class LoanList implements Serializable{
	
	private List<Loan> list = null;

	@XmlElement(name="loan")
	public List<Loan> getList() {
		return list;
	}
	
	public void setList(List<Loan> list) {
		this.list = list;
	}


}
