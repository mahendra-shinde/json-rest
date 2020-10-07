package com.mahendra.mvcproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mahendra.mvcproject.models.Deposit;
import com.mahendra.mvcproject.services.DepositService;

@Controller
@SessionAttributes("msg")
@RequestMapping("/deposit")
public class DepositController {

	@Autowired private DepositService service;
	
	@GetMapping("/list")
	public String listAll(Model map) {
		List<Deposit> deposits = service.getAll();
		map.addAttribute("deposits",deposits);
		return "list/index";
	}
	
	@GetMapping("/create")
	public String create(Model map) {
		Deposit deposit = new Deposit();
		map.addAttribute("deposit",deposit);
		return "create/form";
	}
	
	@PostMapping("/create")
	public String submitCreate(@ModelAttribute("deposit") Deposit deposit, Model map) {
		service.save(deposit);
		map.addAttribute("msg","New deposit "+ deposit.getAccNumber()+" created!");
		return "redirect:/deposit/list";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam("accNum") int accNum, Model map) {
		Deposit deposit = service.findById(accNum);
		map.addAttribute("deposit",deposit);
		return "edit/form";
	}
	
	@PostMapping("/edit")
	public String submitEdit(@ModelAttribute("deposit") Deposit deposit, Model map) {
		service.update(deposit);
		map.addAttribute("msg","Deposit "+ deposit.getAccNumber()+" Updated!");
		return "redirect:/deposit/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("accNum")int accNum, Model map) {
		service.delete(accNum);
		map.addAttribute("msg","Deposit "+ accNum+" Deleted!");
		return "redirect:/deposit/list";
	}
}
