package com.uniovi;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	com.uniovi.tests_domain.IncidentTest.class,
<<<<<<< HEAD
	//com.uniovi.cucumber.CucumberTests.class
=======
	com.uniovi.tests_domain.OperatorTest.class,
	com.uniovi.tests_domain.IncidentConversorTest.class,
	com.uniovi.DatabaseTest.class
>>>>>>> master
})
public class InciDashboardI2aApplicationTests {

}
