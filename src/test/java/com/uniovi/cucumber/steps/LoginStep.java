package com.uniovi.cucumber.steps;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.uniovi.InciDashboardI2aApplication;
import com.uniovi.controllers.OperatorController;
import com.uniovi.entities.Operator;
import com.uniovi.services.OperatorService;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes = InciDashboardI2aApplication.class, loader = SpringBootContextLoader.class)
@WebAppConfiguration
public class LoginStep {

	@Autowired
	OperatorService opService;
	
	@Autowired
	OperatorController opController;

	Operator operator;

	@When("^operator is in home page$")
	public void Step2() {
		assertEquals("login", opController.getLogin());
	}

	@And("^clicks on Log In$")
	public void Step3() {

	}
	
	@Then("^fills in correctly the email and password$")
	public void Step4() {

	}
	
	@Then("^operator is logged in$")
	public void Step5() {

	}
	
}
