package com.uniovi.tests_domain;

import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniovi.entities.Incident;
import com.uniovi.entities.Operator;
import com.uniovi.entities.types.InciState;
import com.uniovi.entities.types.LatLng;
import com.uniovi.entities.types.OperatorKind;

public class IncidentConversorTest {

	private String inciJson;
	
	private ObjectMapper objectMapper;
	private ObjectId inciId;
	private Operator op;
	
	@Before
	public void setUp() {
		inciJson = "{\"incidentId\":\"5af063a9eef69f434c41d15e\",\"name\":\"Bernabeu en llamas\",\"description\":\"Intenso en fuego en concha espina\","
				+ "\"agentId\":\"juan@gmail.com\",\"kindCode\":\"PERSON\",\"tags\":[\"fuego\",\"aficion en llamas\"],\"location\":{\"lat\":\"40.4168\",\"lng\":\"3.7038\"},"
				+ "\"state\":\"OPEN\",\"multimedia\":[\"vid1.mp3\"],\"properties\":{\"prop2\":\"hola\",\"type\":\"FIREMAN\"},\"operator\":{\"email\":\"fireman@gmail.com\","
				+ "\"password\":\"123456\",\"kind\":\"FIREMAN\"},\"comments\":[\"Fire department attending incidente\"]}";
		objectMapper = new ObjectMapper();
		inciId = new ObjectId("5af063a9eef69f434c41d15e");
		op = new Operator("fireman@gmail.com", "123456", OperatorKind.FIREMAN, "ROLE_OPERATOR");
	}

	@Test
	public void json2inciTest() throws Exception {
		Incident incident = objectMapper.readValue(inciJson, Incident.class);
		
		assertEquals(inciId, incident.getId());
		assertEquals("Bernabeu en llamas", incident.getName());
		assertEquals("Intenso en fuego en concha espina", incident.getDescription());
		assertEquals("juan@gmail.com", incident.getAgentId());
		assertEquals(2, incident.getTags().size());
		assertEquals("fuego", incident.getTags().get(0));
		assertEquals("aficion en llamas", incident.getTags().get(1));
		assertEquals(40.4168, incident.getLocation().getLat(), 0.01);
		assertEquals(3.7038, incident.getLocation().getLng(), 0.01);
		assertEquals(InciState.OPEN, incident.getState());
		assertEquals(1, incident.getMultimedia().size());
		assertEquals("vid1.mp3", incident.getMultimedia().get(0));
		assertEquals(2, incident.getProperties().values().size());
		assertEquals(true, incident.getProperties().containsKey("type"));
		assertEquals("FIREMAN", incident.getProperties().get("type"));		
		assertEquals(true, incident.getProperties().containsKey("prop2"));
		assertEquals("hola", incident.getProperties().get("prop2"));
	}
	
	@Test
	public void inci2jsonTest() throws Exception {
		Incident incident = new Incident();
		incident.setId(inciId);
		incident.setName("Bernabeu en llamas");
		incident.setDescription("Intenso en fuego en concha espina");
		incident.setAgentId("juan@gmail.com");
		incident.setKindCode(1);
		
		incident.addTag("fuego");
		incident.addTag("aficion en llamas");
		
		LatLng location = new LatLng(40.4168, 3.7038);
		incident.setLocation(location);
		incident.setState(InciState.OPEN);
		
		incident.addFile("vid1.mp3");
		incident.addProperty("type", "FIREMAN");
		incident.addProperty("prop2", "hola");
		
		incident.setOperator(op);
		incident.addComment("Fire department attending incidente");
		
		String jsonTest = objectMapper.writeValueAsString(incident);
		assertEquals(jsonTest, inciJson);
	}

}
