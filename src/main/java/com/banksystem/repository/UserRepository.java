package com.banksystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banksystem.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User , Long >{

	@Query("select u from User u where u.userName=(?1) and u.dni=(?2)")
	public  Optional<User> getByUsernameAndDni(String userName,String dni);
	
	@Query("select count(*) from User u where u.userName=(?1) and u.dni=(?2)")
	public int checkUser(String userName,String dni);
}
