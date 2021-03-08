package com.banksystem.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT")
public class Account implements Serializable {

	private static final long serialVersionUID = 1068014083478358259L;
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "account")
	private List<Operation> listOperation = new ArrayList<Operation>();	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ACCOUNT" , nullable = false, unique = true)
	private Long idAccount;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_USER", referencedColumnName  ="ID_USER" ,updatable = false, nullable = true)
	private User user;
	
	@Column(name="BALANCE", nullable = false, insertable = true, updatable = true)
	private Double balance;

	public Account(double balance, User user) {
		this.balance=balance;
		this.user=user;
	}

	public Account() {
	}

	public List<Operation> getListOperation() {
		return listOperation;
	}

	public void setListOperation(List<Operation> listOperation) {
		this.listOperation = listOperation;
	}

	public Long getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(Long idAccount) {
		this.idAccount = idAccount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
