package com.uniovi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Operator;
import com.uniovi.entities.types.OperatorKind;

public interface OperatorRepository extends CrudRepository<Operator, Long>{
	List<Operator> findAll();
	
	Operator findByEmail(String email);
	
	List<Operator> findAllByKind(OperatorKind kind);
}
