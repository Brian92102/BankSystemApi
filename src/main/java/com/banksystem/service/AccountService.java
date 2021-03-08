package com.banksystem.service;

import java.util.Optional;

import com.banksystem.entities.Account;
import com.banksystem.entities.User;
import com.banksystem.exception.InvalidAmmountException;
import com.banksystem.exception.NoCreditException;


public interface AccountService {
	public Optional<Account> getAccountById(Long idUser);
	public Optional<Account> getByUsernameAndDni(String userName, String dni);
	public void addMoney(Account account, Double money, String description) throws InvalidAmmountException;
	public void extractMoney(Account account, Double money, String description) throws InvalidAmmountException, NoCreditException;
	public boolean validateAmount(Double money) throws  InvalidAmmountException;
	public boolean validateExtract(Double balance,Double money) throws  NoCreditException;
	public void addAccount(User user);
}
