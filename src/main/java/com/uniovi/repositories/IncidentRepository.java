package com.uniovi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.uniovi.entities.Incident;

public interface IncidentRepository extends CrudRepository<Incident, Long>{

	public List<Incident> findAll();

}
