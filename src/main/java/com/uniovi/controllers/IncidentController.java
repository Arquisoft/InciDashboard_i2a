package com.uniovi.controllers;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uniovi.entities.Incident;
import com.uniovi.entities.Operator;
import com.uniovi.entities.types.InciState;
import com.uniovi.entities.types.LatLng;
import com.uniovi.services.IncidentService;
import com.uniovi.services.OperatorService;

@Controller
public class IncidentController {
	@Autowired
	private IncidentService incidentService;
	
	@Autowired
	private OperatorService operatorsService;
	
	@RequestMapping(value = "/incident/edit/{id}")
	public String getEdit(Model model, @PathVariable Long id) {
		Incident incident = incidentService.getIncident(id);
		if(incident.getOperator().equals(getActiveOperator())) {
			model.addAttribute("incident", incident);
			model.addAttribute("statesList", EnumSet.allOf(InciState.class));
			return "incident/edit";
		}
		return "redirect:/dashboard";		
	}
	
	@RequestMapping(value = "/incident/edit/{id}", method = RequestMethod.POST)
	public String setEdit(Model model, @PathVariable Long id, @RequestParam String inciState, @RequestParam String latlng, @RequestParam String comment) {
		Incident original = incidentService.getIncident(id);
		if(!latlng.isEmpty()) {
			String[] splitLocation = latlng.split(",");
			LatLng location = new LatLng(Double.parseDouble(splitLocation[0]), Double.parseDouble(splitLocation[1]));
			original.setLocation(location);
		}		
		original.setState(InciState.valueOf(inciState));		
		original.getComments().add(comment);
		incidentService.addIncident(original);
		return "redirect:/dashboard";
	}
	
	private Operator getActiveOperator() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return operatorsService.getOperatorByEmail(auth.getName());
	}
}
