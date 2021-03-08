package com.banksystem.service.impl;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banksystem.entities.Account;
import com.banksystem.entities.Operation;
import com.banksystem.repository.OperationRepository;
import com.banksystem.service.OperationService;

@Service
public class OperationServiceImpl implements OperationService {

	@Autowired
	OperationRepository operationRepository;
	
	@Override
	public void addOperation(Account account,Double amount,String description) {
		Operation operation = new Operation(amount, description, new Date(), account);
		account.getListOperation().add(operation);
		operationRepository.save(operation);
		
	}

}
