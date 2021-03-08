package com.banksystem.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banksystem.dto.UserDto;
import com.banksystem.entities.User;
import com.banksystem.service.ConverterService;
@Service
public class ConverterServiceImpl implements ConverterService {

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public User userDtoToEntity(UserDto userDto) {
		return modelMapper.map(userDto,User.class);
	}

	@Override
	public UserDto userEntityToDto(User user) {
		return modelMapper.map(user,UserDto.class);
		
	}
	
}
