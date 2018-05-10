package com.uniovi.cucumber.steps;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.uniovi.InciDashboardI2aApplication;
import com.uniovi.cucumber.pageobjects.PO_View;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes = InciDashboardI2aApplication.class, loader = SpringBootContextLoader.class)
@WebAppConfiguration
public class OperatorStep {

	private static String PathFirefox = "C:\\Firefox46.win\\FirefoxPortable.exe";
	private static String gecko = "C:\\Firefox46.win\\geckodriver.exe";
	private static WebDriver driver = getDriver();
	private static String baseUrl = "http://localhost:8082";
	private String email = "fireman2@gmail.com";
	private String password = "123456";

	public static WebDriver getDriver() {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.firefox.marionette", gecko);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	@After
	public void tearDown() throws Exception {
		driver.manage().deleteAllCookies();
	}

	// Al finalizar la última prueba
	@AfterClass
	static public void end() {
		// Cerramos el navegador al finalizar las pruebas
		driver.quit();
	}

	@Given("^a logged in operator$")
	public void operatorHomePage() {
		driver = getDriver();
		driver.navigate().to(baseUrl);
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("fireman2@gmail.com");
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		login = driver.findElement(By.id("login"));
		login.click();
	}

	@Then("^he wants to modify an incident")
	public void heWantsModifyIncident() {

		List<WebElement> list = PO_View.checkElement(driver, "free", "//table[@name='tableIncidents']/tbody/tr");
		// Comprobamos que hay 1
		assertTrue(list.size() >= 1);

	}

}