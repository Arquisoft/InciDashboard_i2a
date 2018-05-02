package com.uniovi.cucumber.steps;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.uniovi.InciDashboardI2aApplication;
import com.uniovi.entities.Incident;
import com.uniovi.entities.Operator;
import com.uniovi.entities.types.InciState;
import com.uniovi.services.IncidentService;
import com.uniovi.services.OperatorService;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes = InciDashboardI2aApplication.class, loader = SpringBootContextLoader.class)
@WebAppConfiguration
public class ModifyIncidentStep {
	@Autowired
	OperatorService opService;
	
	@Autowired
	IncidentService inciService;

	Operator operator;
	List<Incident> list;
	
	@Given("^an operator$")
	public void Step1() {
		operator = opService.getOperatorByEmail("medic@gmail.com");
	}

	@When("^he is logged in$")
	public void Step2() {
		
	}
	
	@And("^wants to modify an incident")
	public void Step3() {
		assertEquals(true, operator.hasModifyAccess());
	}

	@Then("^he lists all the incidents$")
	public void Step4() {
		//We create a new incident and then assign it to him just in case
//		Incident incident = new Incident();
//		incident.setOperator(operator);
//		incident.setName("Se quema la casa de chus");
//		incident.setState(InciState.OPEN);
//		inciService.addIncident(incident);
		list = inciService.getIncidentsOfOperator(operator);
	}
	
	@And("^modifies one of them")
	public void Step5() {
		Incident incident = list.get(0);
		incident.setDescription("Seems like the car caught fire");
		incident.addTag("Solved");
		incident.addComment("Firemen are in their way");
		incident.addComment("This incident has been modified by " + operator.getEmail());
		incident.setState(InciState.INPROCESS);
	}
}
