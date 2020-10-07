package com.mahendra.mvcproject.daos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mahendra.mvcproject.models.Deposit;

@Repository
public interface DepositRepository extends CrudRepository<Deposit, Integer>{

}
