package com.uniovi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Incident;

public interface IncidentsRepository extends CrudRepository<Incident, Long>{
	
	@Query("select i from Incident i")
	public List<Incident> findAll();

}
