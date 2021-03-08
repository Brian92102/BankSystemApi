package com.banksystem.service.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banksystem.dto.UserDto;
import com.banksystem.entities.Account;
import com.banksystem.entities.User;
import com.banksystem.exception.AccountNotFoundException;
import com.banksystem.exception.ClientNotFoundException;
import com.banksystem.exception.InvalidAmmountException;
import com.banksystem.exception.NoCreditException;
import com.banksystem.repository.UserRepository;
import com.banksystem.service.AccountService;
import com.banksystem.service.ConverterService;
import com.banksystem.service.UserService;
import com.banksystem.util.ErrorsConstants;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private AccountService accountService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ConverterService converterService;
	
	@Override
	@Transactional
	public void deposit(Long idUser, Double money,String comments) throws AccountNotFoundException, InvalidAmmountException {
	Optional <Account> optionalAccount = accountService.getAccountById(idUser);

	if (optionalAccount.isPresent()) {
		accountService.addMoney(optionalAccount.get(), money, comments);
	}else {
		throw new AccountNotFoundException(ErrorsConstants.ACCOUNT_NOT_FOUND);
	}

	}

	@Override
	@Transactional
	public void extract(Long idUser, Double money,String comments) throws AccountNotFoundException, InvalidAmmountException, NoCreditException {
		Optional <Account> optionalAccount = accountService.getAccountById(idUser);

		if (optionalAccount.isPresent()) {
				accountService.extractMoney(optionalAccount.get(), money, comments);
		}else {
			throw new AccountNotFoundException(ErrorsConstants.ACCOUNT_NOT_FOUND);
		}

	}
	
	@Override
	public void addUserAndAccount(UserDto userDto) {
		if (!checkUser(userDto.getUserName(), userDto.getDni())) {
			User user = converterService.userDtoToEntity(userDto);
			accountService.addAccount(user);				
		}
		
	}
	
	@Override
	public void addOnlyUser(UserDto userDto){
		if(!checkUser(userDto.getUserName(), userDto.getDni())) {
		User user = converterService.userDtoToEntity(userDto);
		userRepository.save(user);
		}
	}
	@Override
	public boolean checkUser(String userName,String dni) {
		int result = userRepository.checkUser(userName, dni);
		if(result==0) {
			return false;
		}
		return true;
	}


	@Override
	public UserDto getByUserNameAndDni(String userName, String dni) throws ClientNotFoundException
	{
		Optional<User> user = userRepository.getByUsernameAndDni(userName, dni);
		if (user.isPresent()) {
		return converterService.userEntityToDto(user.get());
		} else {
			throw new ClientNotFoundException(ErrorsConstants.USER_NOT_FOUND);
		}
	}

	@Override
	@Transactional
	public void transfer(Long idUserGive, Long idTargetUser, Double money, String comments) throws AccountNotFoundException, InvalidAmmountException, NoCreditException{
		extract(idUserGive, money, comments);
		deposit(idTargetUser, money, comments);
		
	}
	
	
}
