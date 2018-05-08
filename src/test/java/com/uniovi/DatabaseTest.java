package com.uniovi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uniovi.utils.JsonConversor;


/**
 * Created by Nicolás on 15/02/2017. Modified by Marcos on 17/02/2018
 */
@SpringBootTest(classes = { InciDashboardI2aApplication.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class DatabaseTest {

	@Autowired
	private JsonConversor jsonConv;
	
	@Test
	public void testConversor() {
		Map<String,Object> mapp = new HashMap<String,Object>();
		mapp.put("hola", 4.0);
		String json = jsonConv.mapToJson(mapp);
		assertNotNull(json);
		Map<String,Object> mapp2 = jsonConv.jsonToMap(json);
		assertEquals(mapp2,mapp);
	}
	



}
