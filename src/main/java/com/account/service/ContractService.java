package com.account.service;

import java.util.List;

import com.account.dto.ContractDTO;

public interface ContractService {
	//to create
	ContractDTO addContract(ContractDTO contract);
	
	//to read
	List<ContractDTO> getAllContract();
	ContractDTO getContractById(String id);
	
	//to update
	ContractDTO updateContractById(String id, ContractDTO contract);
	
}
