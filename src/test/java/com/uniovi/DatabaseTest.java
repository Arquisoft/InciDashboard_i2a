package com.uniovi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uniovi.entities.Operator;
import com.uniovi.entities.types.OperatorKind;
import com.uniovi.repositories.OperatorRepository;
import com.uniovi.services.IncidentService;
import com.uniovi.services.OperatorService;
import com.uniovi.services.SecurityService;
import com.uniovi.services.UserDetailsServiceImpl;
import com.uniovi.utils.JsonConversor;


/**
 * Created by Nicolás on 15/02/2017. Modified by Marcos on 17/02/2018
 */
@SpringBootTest(classes = { InciDashboardI2aApplication.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class DatabaseTest {

	@Autowired
	private JsonConversor jsonConv;
	@Autowired
	private UserDetailsServiceImpl userDet;
	@Autowired
	private OperatorService operatorServ;
	@Autowired
	private OperatorRepository operatorRepository;
	@Autowired
	private SecurityService security;
	@Autowired
	private IncidentService inciServ;
	
	@Test
	public void testConversor() {
		Map<String,Object> mapp = new HashMap<String,Object>();
		mapp.put("hola", 4.0);
		String json = jsonConv.mapToJson(mapp);
		assertNotNull(json);
		Map<String,Object> mapp2 = jsonConv.jsonToMap(json);
		assertEquals(mapp2,mapp);
	}
	
	@Test
	public void testServices() {
		Operator o = operatorRepository.findByEmail("prueba20@mail.com");
		if(o!=null)operatorRepository.delete(o);
		userDet.loadUserByUsername("fireman1@gmail.com");
		boolean except = false;
		try {
			userDet.loadUserByUsername("a");
		}catch(Exception e) {
			except = true;
		}
		assertTrue(except);
		
		Operator o1 = new Operator();
		o1.setEmail("prueba20@mail.com");
		o1.setPassword("123456");
		o1.setRole("ROLE_OPERATOR");
		operatorServ.addOperator(o1);
		assertTrue(operatorServ.checkPassword(o1, "123456"));
		assertNotNull(operatorServ.getRandomOperatorOfKind(OperatorKind.FIREMAN));
		assertEquals(o1,operatorServ.getOperatorByEmail("prueba20@mail.com"));
		assertNotNull(operatorServ.getOperators());
		operatorServ.updateOperatorIncident(o1);
		
		except = false;
		try {
			security.findLoggedInEmail();
		}catch(Exception e) {
			except = true;
		}
		assertTrue(except);
		assertNotNull(security.getLogger());
		security.autoLogin("prueba20@mail.com", "123456");
		assertNull(security.findLoggedInEmail());
		
		assertTrue(inciServ.getIncidentsOfOperator(o1).size()==0);
		operatorRepository.delete(o1);
	}



}
