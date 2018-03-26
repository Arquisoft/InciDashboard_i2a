package com.uniovi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uniovi.entities.Incident;
import com.uniovi.entities.Operator;
import com.uniovi.services.IncidentService;
import com.uniovi.services.OperatorService;

@Controller
public class OperatorController {
	
	@Autowired
	private IncidentService incidentsService;
	
	@Autowired
	private OperatorService operatorsService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String getDashboard(Model model) {
		List<Incident> incidents = incidentsService.getIncidents();
		model.addAttribute("activeOperator", getActiveOperator());
		model.addAttribute("incidentsList", incidents);
		return "dashboard";
	}
	
	@RequestMapping(value = "/dashboard/update", method = RequestMethod.GET)
	public String updateDashboard(Model model) {
		List<Incident> incidents = incidentsService.getIncidents();
		model.addAttribute("activeOperator", getActiveOperator());
		model.addAttribute("incidentsList", incidents);
		return "dashboard :: dashboardInfo";
	}
	
	@RequestMapping(value = "/operator/assignedIncidents", method = RequestMethod.GET)
	public String getAssignedIncidents(Model model) {
		model.addAttribute("incidentsList", incidentsService.getIncidentsOfOperator(getActiveOperator()));
		return "/operator/assignedIncidents";
	}
	
	private Operator getActiveOperator() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return operatorsService.getOperatorByEmail(auth.getName());
	}
}
