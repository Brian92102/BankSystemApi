package com.banksystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banksystem.entities.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account,Long>{

	@Query("select a from Account a where a.user.userName=(?1) and a.user.dni=(?2)")
	public  Optional<Account> getByUsernameAndDni(String userName,String dni);
}
