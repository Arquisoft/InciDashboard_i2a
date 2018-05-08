package com.uniovi.cucumber.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ListIncidentsStep {
	
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
	
	@When("^logged in$")
	public void Step2() throws Exception {
		driver.navigate().to(baseUrl);
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("fireman1@gmail.com");
		WebElement pass = driver.findElement(By.id("pass"));
		pass.sendKeys("123456");
		login = driver.findElement(By.id("login"));
		login.click();
	}

	@And("^has assigned incidents$")
	public void Step3() {
		//We find the welcome message
		WebElement assigned = driver.findElement(By.id("assignedIncidents"));
		assigned.click();
	}
	
	@Then("^operator's incidents are shown")
	public void Step4() {
		WebElement assigned = driver.findElement(By.name("tableIncidents"));
		driver.quit();
	}
	
	

}
