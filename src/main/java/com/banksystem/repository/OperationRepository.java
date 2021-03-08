package com.banksystem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.banksystem.entities.Operation;

@Repository
public interface OperationRepository extends CrudRepository<Operation, Long> {

}
