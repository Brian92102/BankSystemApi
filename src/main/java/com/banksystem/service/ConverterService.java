package com.banksystem.service;

import com.banksystem.dto.UserDto;
import com.banksystem.entities.User;

public interface ConverterService {

	public User userDtoToEntity (UserDto userDto);
	
	public UserDto userEntityToDto (User user);
	
}
