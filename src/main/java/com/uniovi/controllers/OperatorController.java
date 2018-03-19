package com.uniovi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OperatorController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() {
		return "login";
	}
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String getDashboard() {
		return "dashboard";
	}
}
