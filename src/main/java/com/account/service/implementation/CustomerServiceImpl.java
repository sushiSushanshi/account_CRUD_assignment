package com.account.service.implementation;

import java.util.List;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.dto.CustomerDTO;
import com.account.entity.Customer;
import com.account.entity.CustomerDetails;
import com.account.mapper.ModelMapper;
import com.account.repository.CustomerRepository;
import com.account.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDTO addCustomer(CustomerDTO customerDto) {
		Customer customer = ModelMapper.convertCustomerDtoToEntity(customerDto);
		return ModelMapper.convertCustomerEntityToDto(customerRepository.save(customer));
	}

	@Override
	public List<CustomerDTO> getAllCustomer() {
		List<CustomerDTO> customers= customerRepository.findAll()
				.stream().map(ModelMapper::convertCustomerEntityToDto)
				.collect(Collectors.toList()); 
		return customers;
	}

	@Override
	public CustomerDTO getCustomerById(long id) {
		Optional<CustomerDTO> customer=customerRepository.findById(id)
				.map(ModelMapper::convertCustomerEntityToDto);
		return customer.get();
	}

	@Override
	public CustomerDTO updateCustomerById(long id, CustomerDTO customerDto) {
		CustomerDTO existingCustomer = ModelMapper.convertCustomerEntityToDto(customerRepository.findById(id).get());
		
		existingCustomer.setName(customerDto.getName());
		existingCustomer.setBusinessRequirements(customerDto.getBusinessRequirements());
		existingCustomer.setAccountType(customerDto.getAccountType());
		
		//new customer detail values
		CustomerDetails newCustomerDetails = customerDto.getDetails();
		
		//existing user customer detail values
		CustomerDetails existingCustomerDetail = existingCustomer.getDetails();
		
		//updating new updated values
		existingCustomerDetail.setCity(newCustomerDetails.getCity());
		existingCustomerDetail.setSex(newCustomerDetails.getSex());
		existingCustomerDetail.setDOB(newCustomerDetails.getDOB());
		existingCustomer.setDetails(newCustomerDetails);
		
		//updating contract type values
		existingCustomer.setContractType(customerDto.getContractType());
		
		Customer customer = ModelMapper.convertCustomerDtoToEntity(existingCustomer);
		 
		return ModelMapper.convertCustomerEntityToDto(customerRepository.save(customer));
	}

	@Override
	public void deleteCustomerById(long id) {
		customerRepository.deleteById(id);
		
	}
}
