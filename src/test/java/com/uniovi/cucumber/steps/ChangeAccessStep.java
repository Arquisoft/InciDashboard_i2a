package com.uniovi.cucumber.steps;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.uniovi.InciDashboardI2aApplication;
import com.uniovi.entities.Operator;
import com.uniovi.services.OperatorService;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes = InciDashboardI2aApplication.class, loader = SpringBootContextLoader.class)
@WebAppConfiguration
public class ChangeAccessStep {

	@Autowired
	OperatorService opService;

	Operator operator;

	@Given("^an admin$")
	public void Step1() {
		operator = opService.getOperatorByEmail("fireman1@gmail.com");
	}

	@When("^he wants to check if he has access to modifications$")
	public void Step2() {
		assertEquals(true, operator.hasModifyAccess());
	}

	@Then("^he wants to change the access to charts$")
	public void Step3() {
		operator.setChartAccess(false);
		assertEquals(false, operator.hasChartAccess());
	}

}
