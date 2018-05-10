package com.uniovi.cucumber.steps;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import com.uniovi.InciDashboardI2aApplication;
import com.uniovi.cucumber.pageobjects.PO_HomeView;

import cucumber.api.java.en.And;
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

	public static WebDriver getDriver() {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.firefox.marionette", gecko);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	private String email = "fireman1@gmail.com";
	private String password = "123456";
	
	@Given("^somebody is in home page$")
	public void operator_is_in_home_page() {
		driver.navigate().to(baseUrl);
	}

	@When("^clicks on Log In$")
	public void clicks_on_log_in() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
	}

	@Then("^fills in correctly the email and password$")
	public void fills_in_correctly_the_email_and_password() {
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys(email);
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys(password);
		WebElement login = driver.findElement(By.id("login"));
		login.click();
	}
	
	@Then("^fills in incorrectly the email and password$")
	public void fills_in_incorrectly_the_email_and_password() {
		email = "pepe@gmail.com";
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys(email);
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys(password);
		WebElement login = driver.findElement(By.id("login"));
		login.click();
	}

	@Then("^operator is logged in$")
	public void operator_is_logged_in() {
		//We find the welcome message
		driver.findElement(By.partialLinkText("Incident"));
	}
	
	@Then("^he is not logged in$")
	public void he_is_not_logged_in() {
		//We find the login message
		driver.findElement(By.partialLinkText("Login"));
	}

}
