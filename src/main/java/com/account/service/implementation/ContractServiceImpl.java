package com.account.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.entity.Contract;
import com.account.repository.ContractRepository;
import com.account.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService{
	
	@Autowired
	private ContractRepository contractRepository;

	@Override
	public Contract addContract(Contract contract) {
		
		return contractRepository.save(contract);
	}

}
