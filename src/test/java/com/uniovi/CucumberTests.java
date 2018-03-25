package com.uniovi;
import org.junit.runner.RunWith;
import cucumber.api.junit.*;
import cucumber.api.CucumberOptions; 

@RunWith(Cucumber.class) 
@CucumberOptions(format = {"pretty", "html:target/cucumber"})
public class CucumberTests {

}
