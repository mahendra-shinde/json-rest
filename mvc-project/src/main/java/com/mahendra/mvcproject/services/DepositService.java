package com.mahendra.mvcproject.services;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahendra.mvcproject.daos.DepositRepository;
import com.mahendra.mvcproject.models.Deposit;

@Service
public class DepositService {

	@Autowired
	private DepositRepository dao;
	
	public Deposit save(Deposit deposit) {
		return dao.save(deposit);
	}
	
	public Deposit update(Deposit deposit) {
		return dao.save(deposit);
	}
	
	public void delete(int id) {
		dao.deleteById(id);
	}
	
	public List<Deposit> getAll(){
		List<Deposit> deposits = new LinkedList<>();
		dao.findAll().forEach(deposit -> deposits.add(deposit));
		return deposits;
	}
	
	public Deposit findById(int accNumber) {
		Optional<Deposit> data = dao.findById(accNumber);
		if(data.isPresent())
			return data.get();
		return null;
	}
}
