package com.uniovi.cucumber;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import cucumber.api.junit.*;
import cucumber.api.CucumberOptions; 

@Ignore
@RunWith(Cucumber.class) 
@CucumberOptions(
	   // glue = "cucumber.steps",
	    features = "src/test/java/com/uniovi/features/")
public class CucumberTests {

}
