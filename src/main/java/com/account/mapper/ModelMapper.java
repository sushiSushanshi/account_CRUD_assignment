package com.account.mapper;

import com.account.dto.ContractDTO;
import com.account.dto.CustomerDTO;
import com.account.entity.Contract;
import com.account.entity.Customer;

public class ModelMapper {
	
	public static CustomerDTO convertCustomerEntityToDto(Customer customer) {
		CustomerDTO customerDto = new CustomerDTO();
		customerDto.setId(customer.getId());
		customerDto.setName(customer.getName());
		customerDto.setBusinessRequirements(customer.getBusinessRequirements());
		customerDto.setAccountType(customer.getAccountType());
		customerDto.setDetails(customer.getDetails());
		customerDto.setContractType(customer.getContractType());
	
		return customerDto;
	}

	public static Customer convertCustomerDtoToEntity(CustomerDTO customerDto) {
		Customer customer = new Customer();
		
		customer.setId(customerDto.getId());
		customer.setName(customerDto.getName());
		customer.setBusinessRequirements(customerDto.getBusinessRequirements());
		customer.setAccountType(customerDto.getAccountType());
		customer.setDetails(customerDto.getDetails());
		customer.setContractType(customerDto.getContractType());
	
		return customer;
	}
	
	public static ContractDTO convertContractEntityToDto(Contract contract) {
		ContractDTO contractDto = new ContractDTO();
		contractDto.setId(contract.getId());
		contractDto.setName(contract.getName());
		
		return contractDto;
	}
	public static Contract convertContractDtoToEntity(ContractDTO contractDto) {
		Contract contract = new Contract();
		contract.setId(contractDto.getId());
		contract.setName(contractDto.getName());
		
		return contract;
	}
	
}
