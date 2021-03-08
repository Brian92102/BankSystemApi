package com.banksystem.dto;

public class UserDto {

	private Long idUser;
	private String name;
	private String surname;
	private String dni;
	private String email;
	private String userName;
	private String password;
	
	
	public UserDto(String name,String surname, String userName, String email, String dni,String password) {
		this.name=name;
		this.surname=surname;
		this.userName=userName;
		this.email=email;
		this.dni=dni;
		this.password=password;
	}
	public UserDto() {
	}
	public Long getIdUser() {
		return idUser;
	}
	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
