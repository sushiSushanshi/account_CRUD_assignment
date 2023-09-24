package com.account.dto;

import java.util.List;

import com.account.entity.Contract;
import com.account.entity.CustomerDetails;

import lombok.Data;


@Data
public class CustomerDTO {
	long id;
	String name;
	CustomerDetails details;
	String accountType;
	List<String> businessRequirements;
	Contract contractType;
	
}
