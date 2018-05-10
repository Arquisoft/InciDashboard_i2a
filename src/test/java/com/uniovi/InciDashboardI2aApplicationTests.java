package com.uniovi;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	com.uniovi.tests_domain.IncidentTest.class,
	com.uniovi.tests_domain.OperatorTest.class,
	com.uniovi.tests_domain.IncidentConversorTest.class,
	com.uniovi.DatabaseTest.class
})
public class InciDashboardI2aApplicationTests {

}
