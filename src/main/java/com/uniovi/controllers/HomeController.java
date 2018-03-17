package com.uniovi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uniovi.entities.Incident;
import com.uniovi.services.IncidentsService;

@Controller
public class HomeController {
	
	@Autowired
	private IncidentsService incidentsService;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Incident> incidents = incidentsService.getIncidents();
		model.addAttribute("incidentsList",incidents);
		return "index";
	}
}
