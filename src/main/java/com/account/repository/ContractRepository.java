package com.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.account.entity.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, String>{

}
