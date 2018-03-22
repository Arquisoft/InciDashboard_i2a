package com.uniovi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Incident;
import com.uniovi.repositories.IncidentRepository;

@Service
public class IncidentService {

	@Autowired
	private IncidentRepository incidentsRepository;
	
	public void addIncident(Incident incident) {
		this.incidentsRepository.save(incident);
	}
	
	public Incident getIncident(Long id) {
		return incidentsRepository.findById(id).orElse(null);
	}

	public List<Incident> getIncidents() {
		return incidentsRepository.findAll();
	}
	
	
}
