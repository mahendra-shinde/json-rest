package com.mahendra.datademo.services;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mahendra.datademo.daos.DepositRepository;
import com.mahendra.datademo.models.Deposit;

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
}
