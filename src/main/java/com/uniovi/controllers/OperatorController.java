package com.uniovi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OperatorController {
	
	@RequestMapping("/login")
	public String getLogin() {
		return "login";
	}
}
