package com.banksystem.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="OPERATION")
public class Operation implements Serializable {

	private static final long serialVersionUID = -7899791873171575825L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_OPERATION" , nullable = false, unique = true)
	private Long idOperation;
	
	@ManyToOne
    @JoinColumn(name = "ID_ACCOUNT", nullable = false, updatable = false)
	private Account account;
	
	@Column(name="DATE", nullable = false, insertable = true, updatable = true)
	private Date date;
	
	@Column(name="DESCRIPTION", nullable = true, insertable = true, updatable = true)
	private String description;
	
	@Column(name="AMOUNT", nullable = false, insertable = true, updatable = true)
	private Double amount;
	
	

	public Operation() {
	}

	public Operation(Double amount, String description, Date date, Account account) {
		this.amount=amount;
		this.description=description;
		this.date=date;
		this.account=account;
	}

	public Long getIdOperation() {
		return idOperation;
	}

	public void setIdOperation(Long idOperation) {
		this.idOperation = idOperation;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
