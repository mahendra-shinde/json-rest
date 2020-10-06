package com.mahendra.demo2;

public class AccountController {

	private AccountService service;
	
	public AccountController() {
		System.out.println("Instance of Account Controller created!");
		service = new AccountService();
	}
}
