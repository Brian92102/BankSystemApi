package com.banksystem.service;

import com.banksystem.entities.Account;

public interface OperationService {
	

	public void addOperation(Account account, Double ammount, String Description);

}
