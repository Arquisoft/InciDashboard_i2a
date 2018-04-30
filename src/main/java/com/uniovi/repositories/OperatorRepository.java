package com.uniovi.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.uniovi.entities.Operator;
import com.uniovi.entities.types.OperatorKind;

public interface OperatorRepository extends MongoRepository<Operator, ObjectId>{
	List<Operator> findAll();
	
	Operator findByEmail(String email);
	
	List<Operator> findAllByKind(OperatorKind kind);
}
