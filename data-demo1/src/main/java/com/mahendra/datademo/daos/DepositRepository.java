package com.mahendra.datademo.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mahendra.datademo.models.Deposit;

@Repository
public interface DepositRepository extends CrudRepository<Deposit, Integer>{

}
