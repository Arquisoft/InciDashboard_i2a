package com.uniovi.cucumber.steps;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.uniovi.InciDashboardI2aApplication;
import com.uniovi.entities.Incident;
import com.uniovi.entities.Operator;
import com.uniovi.services.IncidentService;
import com.uniovi.services.OperatorService;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

@ContextConfiguration(classes = InciDashboardI2aApplication.class, loader = SpringBootContextLoader.class)
@WebAppConfiguration
public class PromoteAdminStep {

	@Autowired
	OperatorService opService;
	
	@Autowired
	IncidentService inciService;

	Operator operator;
	List<Incident> list;
	
	@And("^wants to make another user admin")
	public void Step3() {
		operator = opService.getOperatorByEmail("fireman1@gmail.com");
		assertEquals(true, operator.hasModifyAccess());
		assertEquals(true, operator.isAdmin());
	}

	@Then("^he modifies the corresponding property$")
	public void Step4() {
		List<Operator> list = opService.getOperators();
		Random rand = new Random();
		Operator op2 = list.get(rand.nextInt(list.size()));;
		while (op2.equals(operator)) {
			op2 = list.get(rand.nextInt(list.size())); //If it's the same we don't change the permissions
		}
		op2.setRole("ROLE_ADMIN");
	}
	
}
