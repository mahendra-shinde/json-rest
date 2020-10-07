package com.mahendra.datademo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mahendra.datademo.models.Deposit;
import com.mahendra.datademo.services.DepositService;

@RestController
@RequestMapping("/api/deposits")
public class DepositController {
	
	@Autowired
	private DepositService service;
	
	
	@GetMapping("/")
	public List<Deposit> getAll(){
		return service.getAll();
	}
}
