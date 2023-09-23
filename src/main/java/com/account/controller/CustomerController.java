package com.account.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.entity.Contract;
import com.account.entity.Customer;
import com.account.entity.CustomerDetails;
import com.account.repository.ContractRepository;
import com.account.repository.CustomerRepository;
import com.account.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController{
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/add")
	public ResponseEntity<Customer>  register(@RequestBody Customer customer) {	
		return new ResponseEntity<>(customerService.addCustomer(customer),HttpStatus.CREATED);
	}
	

}
