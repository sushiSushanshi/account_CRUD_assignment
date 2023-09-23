package com.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.entity.Contract;
import com.account.service.ContractService;

@RestController
@RequestMapping("/contracts")
public class ContractController {
	
	@Autowired
	private ContractService contractService;
	
	@PostMapping
	public ResponseEntity<Contract>  registerC(@RequestBody Contract contract) {	
		return new ResponseEntity<>(contractService.addContract(contract),HttpStatus.CREATED);
	}
}
