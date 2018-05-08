package com.uniovi.cucumber.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.uniovi.InciDashboardI2aApplication;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes = InciDashboardI2aApplication.class, loader = SpringBootContextLoader.class)
@WebAppConfiguration
public class LoginStep {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	private WebDriver driver;
	private String baseUrl;

	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
		driver = new HtmlUnitDriver();
		baseUrl = "http://localhost:8082";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^operator is in home page$")
	public void Step2() {
		driver.get(baseUrl);
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
