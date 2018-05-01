package com.uniovi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uniovi.entities.Incident;
import com.uniovi.entities.Operator;
import com.uniovi.services.IncidentService;
import com.uniovi.services.OperatorService;
import com.uniovi.services.SecurityService;

@Controller
public class OperatorController {
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private IncidentService incidentsService;
	
	@Autowired
	private OperatorService operatorsService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/admin/login", method = RequestMethod.GET)
	public String getAdminLogin() {
		return "adminLogin";
	}
	
	@RequestMapping(value = "/admin/login", method = RequestMethod.POST)
	public String adminLogin(Model model, @RequestParam String email, @RequestParam String password) {
		Operator operator = operatorsService.getOperatorByEmail(email);
		if(operator != null && operatorsService.checkPassword(operator, password) && operator.getRole().equals("ROLE_ADMIN")) {
			securityService.autoLogin(email, password);
			return "redirect:/dashboard";
		}
		else {
			model.addAttribute("error", true);
			return "adminLogin";
		}
		
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
	
	@RequestMapping(value = "/operator/permissions", method = RequestMethod.GET)
	public String getOperatorPermissions(Model model) {
		model.addAttribute("operatorsList", operatorsService.getOperators());
		return "/operator/permissions";
	}
	
	@RequestMapping(value = "/operator/permissions/{id}", method = RequestMethod.POST)
	@ResponseBody
	public boolean operatorPermissionsChanged(@PathVariable String id) {
		return operatorsService.modifyPermission(id);
	}
	
	private Operator getActiveOperator() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return operatorsService.getOperatorByEmail(auth.getName());
	}
}
