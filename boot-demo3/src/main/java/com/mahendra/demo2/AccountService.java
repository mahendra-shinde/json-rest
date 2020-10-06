package com.mahendra.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountService {
	
	@Autowired
	private AccountDAO dao = null;
	
	public AccountService() {
		System.out.println("Instance of AccountService created!");
	
	}
}
