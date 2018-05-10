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
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@ContextConfiguration(classes = InciDashboardI2aApplication.class, loader = SpringBootContextLoader.class)
@WebAppConfiguration
public class LoginStep {

	private static String PathFirefox = "C:\\Firefox46.win\\FirefoxPortable.exe";
	private static String gecko = "C:\\Firefox46.win\\geckodriver.exe";
	private static WebDriver driver;
	private static String baseUrl = "http://localhost:8082";

	public static WebDriver getDriver() {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.firefox.marionette", gecko);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	@When("^operator is in home page$")
	public void Step2() throws Exception {
		driver = getDriver();
		driver.navigate().to(baseUrl);
		WebElement login = driver.findElement(By.id("login"));
	}

	@And("^clicks on Log In$")
	public void Step3() {
		WebElement login = driver.findElement(By.id("login"));
		login.click();
	}

	@Then("^fills in correctly the email and password$")
	public void Step4() {
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("fireman1@gmail.com");
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		WebElement login = driver.findElement(By.id("login"));
		login.click();
	}

	@Then("^operator is logged in$")
	public void Step5() {
		//We find the welcome message
		driver.findElement(By.partialLinkText("Incident"));
		driver.quit();
		driver.close();
	}

}
