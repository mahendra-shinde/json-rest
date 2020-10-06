package com.mahendra.demo2.models;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="loans")
public class LoanList implements Serializable{
	
	@XmlElement(name="loan")
	private List<Loan> list = null;

	
	public void setList(List<Loan> list) {
		this.list = list;
	}


}
