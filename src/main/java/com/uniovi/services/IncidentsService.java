package com.uniovi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Incident;
import com.uniovi.repositories.IncidentsRepository;

@Service
public class IncidentsService {

	@Autowired
	private IncidentsRepository incidentsRepository;

	public List<Incident> getIncidents() {
		return incidentsRepository.findAll();
	}
	
	
}
