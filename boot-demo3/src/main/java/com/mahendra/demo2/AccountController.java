package com.mahendra.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountController {

	@Autowired	
	private AccountService service;
	
	public AccountController() {
		System.out.println("Instance of Account Controller created!");
	}
}
