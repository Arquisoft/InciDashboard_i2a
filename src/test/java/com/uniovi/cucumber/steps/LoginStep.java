package com.uniovi.cucumber.steps;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
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

	private HtmlUnitDriver driver;
	private String baseUrl = "http://localhost:8082";

	
	public HtmlUnitDriver driver() throws Exception {
		driver = new HtmlUnitDriver();
		return driver;
	}

	@When("^operator is in home page$")
	public void Step2() throws Exception {
		driver = driver();
		driver.setJavascriptEnabled(true);
		driver.navigate().to(baseUrl);
		System.out.println("ENTRANDO EN EL INDEXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
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
