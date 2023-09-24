package com.account.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.dto.CustomerDTO;
import com.account.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController{
	
	@Autowired
	private CustomerService customerService;
	
	//create
	@PostMapping
	public ResponseEntity<CustomerDTO>  addCustomer(@RequestBody CustomerDTO customerDto) {	
		return new ResponseEntity<>(customerService.addCustomer(customerDto),HttpStatus.CREATED);
	}
	
	//read
	@GetMapping
	public ResponseEntity<List<CustomerDTO>> getAllCustomer(){
		return ResponseEntity.ok(customerService.getAllCustomer());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable long id) {
		return ResponseEntity.ok(customerService.getCustomerById(id));
		
	}
	
	//to update all fields
	@PutMapping("/{id}")
	public ResponseEntity<CustomerDTO>  updateCustomer(@PathVariable long id,@RequestBody CustomerDTO customerDto) {	
		return ResponseEntity.ok(customerService.updateCustomerById(id, customerDto));
	}
	
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable long id) {
		CustomerDTO customer = customerService.getCustomerById(id);
		if(customer != null) {
			customerService.deleteCustomerById(id);
		}else
			throw new NoSuchElementException();
		
		return ResponseEntity.ok("user with id "+id+" successufully deleted !!!");
	}

}
