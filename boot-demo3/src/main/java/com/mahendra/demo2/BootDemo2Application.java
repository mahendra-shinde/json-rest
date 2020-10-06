package com.mahendra.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootDemo2Application implements CommandLineRunner {

	@Autowired private AccountController con1;
	@Autowired private AccountController con2;
	
	public static void main(String[] args) {
		SpringApplication.run(BootDemo2Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
	}

}
