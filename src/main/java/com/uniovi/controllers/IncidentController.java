package com.uniovi.controllers;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uniovi.entities.Incident;
import com.uniovi.entities.types.InciState;
import com.uniovi.services.IncidentService;

@Controller
public class IncidentController {
	@Autowired
	private IncidentService incidentService;
	
	@RequestMapping(value = "/incident/edit/{id}")
	public String getEdit(Model model, @PathVariable Long id) {
		model.addAttribute("incident", incidentService.getIncident(id));
		model.addAttribute("statesList", EnumSet.allOf(InciState.class));
		return "incident/edit";
	}
	
	@RequestMapping(value = "/incident/edit/{id}", method = RequestMethod.POST)
	public String setEdit(Model model, @PathVariable Long id, @RequestParam String inciState, @RequestParam String comment) {
		Incident original = incidentService.getIncident(id);
		original.setState(InciState.valueOf(inciState));
		original.getComments().add(comment);
		incidentService.addIncident(original);
		return "redirect:/dashboard";
	}
}
