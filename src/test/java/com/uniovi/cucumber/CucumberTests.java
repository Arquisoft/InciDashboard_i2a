package com.uniovi.cucumber;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber; 

@RunWith(Cucumber.class) 
@CucumberOptions(features = "src/test/java/com/uniovi/features/",
	    glue = "cucumber.steps")
public class CucumberTests {

}
