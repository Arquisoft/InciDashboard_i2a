package com.uniovi.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.uniovi.entities.Incident;
import com.uniovi.entities.Operator;

public interface IncidentRepository extends MongoRepository<Incident, Long>{

	public List<Incident> findAll();
	
	public List<Incident> findAllByOperator(Operator operator);
	
}
