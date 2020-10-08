package com.mahendra.restproject1.controllers;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestParam;

import com.mahendra.restproject1.models.Account;

@RepositoryRestResource(collectionResourceRel = "accounts",path="account")
@PreAuthorize("hasRole('USER')")
public interface AccountRepository extends PagingAndSortingRepository<Account, Integer> {
	
	List<Account> findByAccHolder(@RequestParam("accHolder") String accHolder);
}
