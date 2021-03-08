package com.banksystem.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banksystem.entities.Account;
import com.banksystem.entities.User;
import com.banksystem.exception.InvalidAmmountException;
import com.banksystem.exception.NoCreditException;
import com.banksystem.repository.AccountRepository;
import com.banksystem.service.AccountService;
import com.banksystem.service.OperationService;
import com.banksystem.util.ErrorsConstants;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private OperationService operationService;
	
	
	
	@Override
	public Optional<Account> getAccountById(Long idUser) {
		Optional <Account> optionalAccount = accountRepository.findById(idUser);
		return optionalAccount;
	}
	@Override
	public Optional<Account> getByUsernameAndDni(String userName,String dni) {
		Optional <Account> optionalAccount = accountRepository.getByUsernameAndDni(userName,dni);
		return optionalAccount;
	}
	
	
	@Override
	public void addMoney(Account account, Double money,String description) throws InvalidAmmountException{
		if (validateAmount(money)) {
		account.setBalance(account.getBalance()+money);
		operationService.addOperation(account, money, description);
	}
		}
	
	@Override
	public void extractMoney(Account account, Double money,String description) throws InvalidAmmountException,NoCreditException {
		Double balance = account.getBalance();
		if (validateAmount(money)&&(validateExtract(balance,money))) {
		account.setBalance(account.getBalance()-money);
		operationService.addOperation(account, money, description);
	}
		}
	
	@Override
	public boolean validateAmount(Double money) throws InvalidAmmountException {
		if (money>=0) {
			return true;
		}
		throw new InvalidAmmountException(ErrorsConstants.NO_VALID_AMOUNT);
	}
	
	@Override
	public boolean validateExtract(Double balance,Double money) throws NoCreditException {
		if (money<=balance) {
			return true;
		}else {
			throw new NoCreditException(ErrorsConstants.NO_CREDIT);
			
		}
		
		
	}
	
	@Override
	public void addAccount(User user) {
		 Account account = new Account(0D,user);
		 accountRepository.save(account);
	}
	

}
