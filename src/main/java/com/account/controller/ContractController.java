package com.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.dto.ContractDTO;
import com.account.service.ContractService;

@RestController
@RequestMapping("/contracts")
public class ContractController {
	
	@Autowired
	private ContractService contractService;
	
	//create
	@PostMapping
	public ResponseEntity<ContractDTO>  registerC(@RequestBody ContractDTO contract) {	
		return new ResponseEntity<>(contractService.addContract(contract),HttpStatus.CREATED);
	}
	
	//read
	@GetMapping
	public ResponseEntity<List<ContractDTO>> getAllContract(){
		return ResponseEntity.ok(contractService.getAllContract());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ContractDTO> getContractById(@PathVariable String id){
		return ResponseEntity.ok(contractService.getContractById(id));
	}
	
	//update
	@PutMapping("/{id}")
	public ResponseEntity<ContractDTO> updateContract(@PathVariable String id,@RequestBody ContractDTO contract){
		return ResponseEntity.ok(contractService.updateContractById(id, contract));
	}
}
