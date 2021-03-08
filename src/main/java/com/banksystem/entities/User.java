package com.banksystem.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User implements Serializable {

	private static final long serialVersionUID = -7527719601403171372L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER" , nullable = false, unique = true)
	private Long idUser;
	
	@Column(name="NAME", nullable = false, insertable = true, updatable = true)
	private String name;
	
	@Column(name="SURNAME", nullable = false, insertable = true, updatable = true)
	private String surname;
	
	@Column(name="DNI", nullable = false, insertable = true, updatable = true)
	private String dni;
	
	@Column(name="EMAIL", nullable = false, insertable = true, updatable = true)
	private String email;
	
	@Column(name="USER_NAME", nullable = false, insertable = true, updatable = true)
	private String userName;
	
	@Column(name="PASSWORD", nullable = false, insertable = true, updatable = true)
	private String password;
	
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "user")
    private Account account;


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


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
