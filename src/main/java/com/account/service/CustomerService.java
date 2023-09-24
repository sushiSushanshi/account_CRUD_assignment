package com.account.service;

import java.util.List;

import com.account.dto.CustomerDTO;

public interface CustomerService {
	//create
	CustomerDTO addCustomer(CustomerDTO customer);
	
	//read
	List<CustomerDTO> getAllCustomer();
	CustomerDTO getCustomerById(long id);
	
	//update
	CustomerDTO updateCustomerById(long id, CustomerDTO customerDto);
	
	//delete
	void deleteCustomerById(long id);
}
