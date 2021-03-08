package com.banksystem.service;

import com.banksystem.dto.UserDto;
import com.banksystem.exception.AccountNotFoundException;
import com.banksystem.exception.ClientNotFoundException;
import com.banksystem.exception.InvalidAmmountException;
import com.banksystem.exception.NoCreditException;

public interface UserService {
	
	public void deposit(Long idUser, Double money,String comments) throws AccountNotFoundException, InvalidAmmountException;
	public void extract(Long idUser, Double money, String comments) throws AccountNotFoundException, InvalidAmmountException, NoCreditException;
	public void addUserAndAccount(UserDto userDto);
	public UserDto getByUserNameAndDni(String userName, String dni) throws  ClientNotFoundException;
	public void transfer(Long idUserGive, Long idTargetUser,Double money,String comments) throws AccountNotFoundException, InvalidAmmountException, NoCreditException;
	public boolean checkUser(String userName,String dni);
	public void addOnlyUser(UserDto userDto);
}
