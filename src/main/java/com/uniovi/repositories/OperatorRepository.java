package com.uniovi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Operator;

public interface OperatorRepository extends CrudRepository<Operator, Long>{
	
	Operator findByEmail(String email);
}
