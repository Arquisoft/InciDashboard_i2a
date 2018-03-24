package com.uniovi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Incident;
import com.uniovi.entities.Operator;

public interface IncidentRepository extends CrudRepository<Incident, Long>{

	public List<Incident> findAll();
	
	public List<Incident> findAllByOperator(Operator operator);
	
}
