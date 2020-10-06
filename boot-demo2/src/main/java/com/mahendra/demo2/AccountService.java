package com.mahendra.demo2;

public class AccountService {
	private AccountDAO dao = null;
	
	public AccountService() {
		System.out.println("Instance of AccountService created!");
		dao = new AccountDAO();
	}
}
