package com.account.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.dto.ContractDTO;
import com.account.entity.Contract;
import com.account.mapper.ModelMapper;
import com.account.repository.ContractRepository;
import com.account.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService{
	
	@Autowired
	private ContractRepository contractRepository;

	@Override
	public ContractDTO addContract(ContractDTO contractDto) {
		Contract contract = ModelMapper.convertContractDtoToEntity(contractDto);
		return ModelMapper.convertContractEntityToDto(contractRepository.save(contract));
	}

	@Override
	public List<ContractDTO> getAllContract() {
		return contractRepository.findAll()
				.stream().map(ModelMapper::convertContractEntityToDto).collect(Collectors.toList());
	}

	@Override
	public ContractDTO getContractById(String id){
		Optional<ContractDTO> customerDto = contractRepository.findById(id)
				.map(ModelMapper::convertContractEntityToDto);		
		return customerDto.get();
	}


	@Override
	public ContractDTO updateContractById(String id, ContractDTO contractDto) {
		ContractDTO existingContract = ModelMapper
				.convertContractEntityToDto(contractRepository.findById(id).get());

		existingContract.setName(contractDto.getName());
		Contract contract= contractRepository.save(ModelMapper.convertContractDtoToEntity(existingContract));
		return ModelMapper.convertContractEntityToDto(contract);
	}


}
