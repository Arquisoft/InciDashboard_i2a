package com.uniovi.cucumber.steps;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IncidentsListStep {
	private String PathFirefox = "C:\\Firefox46.win\\FirefoxPortable.exe";
	private String gecko = "C:\\Firefox46.win\\geckodriver.exe";
	private String URL = "http://localhost:8082/login";
	private WebDriver driver = getDriver(PathFirefox);

	@Before
	public WebDriver getDriver(String PathFirefox) {
		// Firefox (Versión 46.0) sin geckodriver para Selenium 2.x.
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.firefox.marionette", gecko);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	@Before
	public void setUp() throws Exception {
		driver.navigate().to(URL);
	}

	@After
	public void tearDown() throws Exception {
		driver.manage().deleteAllCookies();
	}

	// Antes de la primera prueba
	@BeforeClass
	public void begin() {
	}

	// Al finalizar la última prueba
	@After
	public void end() {
		// Cerramos el navegador al finalizar las pruebas
		driver.quit();
	}


	@When("^logged in")
	public void logged() {
		driver.get("http://localhost:8082/login");
		driver.findElement(By.id("email")).sendKeys("fireman@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123456");
		driver.findElement(By.id("login")).click();
	}

	@And("^has assigned incidents")
	public void incidentsAssigned() {

	}

	@And("^click on 'Assigned incidents'") //this should work
	public void incidentsClick() {
		driver.findElement(By.id("assignedIncidents")).click();
	}

	@Then("^operator's incidents are shown")
	public void checkFail() {
		if (driver.getCurrentUrl().equalsIgnoreCase("http://localhost:8082/operator/assignedIncidents")) {
			//maybe we can check the number of incidents obtained .. next deliverable
			System.out.println("Test Pass");
		} else {
			System.out.println("Test1 Failed");
		}
		driver.close();
	}
}
