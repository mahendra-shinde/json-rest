package com.mahendra.demo2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootDemo2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BootDemo2Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		AccountController con1 = new AccountController();
		AccountController con2 = new AccountController();
	}

}
