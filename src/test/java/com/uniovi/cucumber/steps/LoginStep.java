package com.uniovi.cucumber.steps;

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
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes = InciDashboardI2aApplication.class, loader = SpringBootContextLoader.class)
@WebAppConfiguration
public class LoginStep {

	private static String PathFirefox = "C:\\Firefox46.win\\FirefoxPortable.exe";
	private static String gecko = "C:\\Firefox46.win\\geckodriver.exe";
	private static WebDriver driver = getDriver();
	private static String baseUrl = "http://localhost:8082";
	private String email = "fireman1@gmail.com";
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
	
	@Given("^somebody is in home page$")
	public void operatorHomePage() {
		driver.navigate().to(baseUrl);
	}

	@When("^clicks on Log In$")
	public void clicksLogIn() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
	}

	@Then("^fills in correctly the email and password$")
	public void fillsCorrectly() {
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys(email);
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys(password);
		WebElement login = driver.findElement(By.id("login"));
		login.click();
	}
	
	@Then("^fills in incorrectly the email and password$")
	public void fillsIncorrectly() {
		email = "pepe@gmail.com";
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys(email);
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys(password);
		WebElement login = driver.findElement(By.id("login"));
		login.click();
	}

	@Then("^operator is logged in$")
	public void operatorLogged() {
		//We find the welcome message
		driver.findElement(By.partialLinkText("Incident"));
	}
	
	@Then("^he is not logged in$")
	public void notLogged() {
		//We find the login message
		driver.findElement(By.partialLinkText("Login"));
	}

}
