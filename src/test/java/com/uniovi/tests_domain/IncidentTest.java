package com.uniovi.tests_domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.uniovi.entities.Incident;
import com.uniovi.entities.Operator;
import com.uniovi.entities.types.AgentKind;
import com.uniovi.entities.types.InciState;
import com.uniovi.entities.types.LatLng;
import com.uniovi.entities.types.OperatorKind;
import com.uniovi.utils.IncidentCreator;
import com.uniovi.utils.PrintIncidentProperties;

public class IncidentTest {
	private Incident inci1;
	private Incident inci2;
	
	private String[] agentId = new String[]{"javi@gmail.com", "alba@gmail.com"};
	private int[] kindCode = new int[] {1,2,3};
	
	private Operator op1;
	private Operator op2;	
	
	@Before
	public void setUp() {		
		op1 = new Operator("fireman@gmail.com", "123456", OperatorKind.FIREMAN, "ROLE_OPERATOR");
		op2 = new Operator("policeman@gmail.com", "123456", OperatorKind.POLICE, "ROLE_OPERATOR");
		
		List<String> inci1_tags = new ArrayList<String>();
		inci1_tags.add("fire");
		inci1_tags.add("smoke");
		inci1_tags.add("low visibility");
		
		List<String> inci1_multimedia = new ArrayList<String>();
		inci1_multimedia.add("pic1.jpg");
		inci1_multimedia.add("vid1.avi");
		
		Map<String, Object> inci1_properties = new HashMap<String, Object>();
		inci1_properties.put("danger", "medium");
		inci1_properties.put("injured", "3");
		inci1_properties.put("deaths", "1");
		
		List<String> inci1_comments = new ArrayList<String>();
		inci1_comments.add("Fire affecting all school labs");
		inci1_comments.add("Difficult access, crane needed");
		
		inci1 = new Incident(new ObjectId("5ae6ec8b1e360737787ed702"), "Fire", "Intense fire in the EII at UNIOVI", agentId[0], kindCode[0], inci1_tags, new LatLng(43.354929,-5.851416), InciState.OPEN, inci1_multimedia, inci1_properties, op1, inci1_comments);
	
		List<String> inci2_tags = new ArrayList<String>();
		inci2_tags.add("rain");
		inci2_tags.add("low visibility");
		inci2_tags.add("car collisions");
		
		
		List<String> inci2_multimedia = new ArrayList<String>();
		inci2_multimedia.add("pic1.jpg");
		inci2_multimedia.add("vid1.avi");
		
		Map<String, Object> inci2_properties = new HashMap<String, Object>();
		inci2_properties.put("danger", "high");
		inci2_properties.put("injured", "20");
		inci2_properties.put("deaths", "4");
		
		List<String> inci2_comments = new ArrayList<String>();
		inci2_comments.add("Slippery road conditions");
		inci2_comments.add("Chained car accidents");
		
		inci2 = new Incident(new ObjectId("5ae6ec8b1e360737787ed707"), "Rain", "Rain storm affecting A-66", agentId[1], kindCode[1], inci2_tags, new LatLng(43.3584404,-5.8284433), InciState.OPEN, inci2_multimedia, inci2_properties, op2, inci2_comments);
	}
	
	@Test
	public void inciNameDescriptionTest() {
		Assert.assertEquals("Fire", inci1.getName());
		Assert.assertEquals("Rain", inci2.getName());
		
		inci1.setName("Fire in university building");
		Assert.assertEquals("Fire in university building", inci1.getName());
		
		inci2.setName("Chained car accident");
		Assert.assertEquals("Chained car accident", inci2.getName());
		
		Assert.assertEquals("Intense fire in the EII at UNIOVI", inci1.getDescription());
		Assert.assertEquals("Rain storm affecting A-66", inci2.getDescription());
		
		inci1.setDescription("Intense fire at EII");
		Assert.assertEquals("Intense fire at EII", inci1.getDescription());
		
		inci2.setDescription("Rain storm affecting A-66 state");
		Assert.assertEquals("Rain storm affecting A-66 state", inci2.getDescription());		
	}
	
	@Test
	public void inciAgentIdTest() {
		Assert.assertEquals(agentId[0], inci1.getAgentId());
		Assert.assertEquals(agentId[1], inci2.getAgentId());
		
		inci1.setAgentId(agentId[1]);
		Assert.assertEquals(agentId[1], inci1.getAgentId());

		inci2.setAgentId(agentId[0]);
		Assert.assertEquals(agentId[0], inci2.getAgentId());
	}
	
	@Test
	public void inciAgentKindCodeTest() {
		Assert.assertEquals(AgentKind.PERSON, inci1.getAgentKind());
		Assert.assertEquals(AgentKind.ENTITY, inci2.getAgentKind());
		
		inci1.setKindCode(2);
		Assert.assertEquals(AgentKind.ENTITY, inci1.getAgentKind());
		inci2.setKindCode(3);
		Assert.assertEquals(AgentKind.SENSOR, inci2.getAgentKind());
	}
	
	@Test
	public void inciTagsTest() {
		Assert.assertEquals(3, inci1.getTags().size());
		Assert.assertEquals(3, inci2.getTags().size());
		
		inci1.addTag("tag test 1");
		Assert.assertEquals(4, inci1.getTags().size());
		
		inci2.addTag("tag test 2");
		Assert.assertEquals(4, inci2.getTags().size());
	}
	
	@Test
	public void inciLocationTest() {
		Assert.assertEquals(43.354929, inci1.getLocation().getLat(), 0.0001);
		Assert.assertEquals(-5.851416, inci1.getLocation().getLng(), 0.0001);
		
		Assert.assertEquals(43.3584404, inci2.getLocation().getLat(), 0.0001);
		Assert.assertEquals(-5.8284433, inci2.getLocation().getLng(), 0.0001);
		
		inci1.getLocation().setLat(43.3584404);
		inci1.getLocation().setLng(-5.8284433);
		LatLng loc = new LatLng();
		assertEquals(loc.toString(),"LatLng [lat=0.0, lng=0.0]");
		Assert.assertEquals(43.3584404, inci1.getLocation().getLat(), 0.0001);
		Assert.assertEquals(-5.8284433, inci1.getLocation().getLng(), 0.0001);
		
		inci2.getLocation().setLat(43.354929);
		inci2.getLocation().setLng(-5.851416);
		Assert.assertEquals(43.354929, inci2.getLocation().getLat(), 0.0001);
		Assert.assertEquals(-5.851416, inci2.getLocation().getLng(), 0.0001);
	}
	
	@Test
	public void inciStateTest() {
		Assert.assertEquals(InciState.OPEN, inci1.getState());
		Assert.assertEquals(InciState.OPEN, inci2.getState());
		
		inci1.setState(InciState.INPROCESS);
		Assert.assertEquals(InciState.INPROCESS, inci1.getState());
		
		inci2.setState(InciState.INPROCESS);
		Assert.assertEquals(InciState.INPROCESS, inci2.getState());
	}
	
	@Test
	public void inciMultimediaTest() {
		Assert.assertEquals(2, inci1.getMultimedia().size());
		Assert.assertEquals(2, inci2.getMultimedia().size());
		
		inci1.addFile("intervention1.txt");
		Assert.assertEquals(3, inci1.getMultimedia().size());
		
		inci2.addFile("intervention2.txt");
		Assert.assertEquals(3, inci2.getMultimedia().size());
		inci1.setMultimedia(new ArrayList<String>());
		Assert.assertTrue(inci1.getMultimedia().isEmpty());
		
	}
	
	@Test
	public void inciPropertiesTest() {
		Assert.assertEquals(3, inci1.getProperties().size());
		Assert.assertEquals(3, inci2.getProperties().size());
		
		inci1.getProperties().put("intervention", true);
		inci2.getProperties().put("intervention", true);
		
		Assert.assertEquals(4, inci1.getProperties().size());
		Assert.assertEquals(4, inci2.getProperties().size());
		inci1.setProperties(new HashMap<String,Object>());
		Assert.assertTrue(inci1.getProperties().size()==0);
	}
	
	@Test
	public void inciOperatorTest() {
		Assert.assertEquals(op1, inci1.getOperator());
		Assert.assertEquals(op2, inci2.getOperator());
		
		inci1.setOperator(op2);
		inci2.setOperator(op1);
		Assert.assertEquals(op2, inci1.getOperator());
		Assert.assertEquals(op1, inci2.getOperator());
		inci1.setTags(new ArrayList<String>());
	}
	
	@Test
	public void inciCommentsTest() {
		Assert.assertEquals(2, inci1.getComments().size());
		Assert.assertEquals(2, inci2.getComments().size());
		
		inci1.addComment("Incident managed successfully");
		inci2.addComment("Incident managed successfully");
		
		Assert.assertEquals(3, inci1.getComments().size());
		Assert.assertEquals(3, inci2.getComments().size());
		
		inci1.setComments(new ArrayList<String>());
		Assert.assertTrue(inci1.getComments().isEmpty());
		
		Incident i2 = new Incident();
		i2.setId(new ObjectId("507f1f77bcf86cd799439011"));
		Assert.assertEquals("507f1f77bcf86cd799439011", i2.getId().toString());
		i2.setKindCode(2);
		Assert.assertEquals(i2.getKindCode(),2);
		Assert.assertEquals(AgentKind.values()[1],i2.getAgentKind());
	}
	
	@Test
	public void testCreator() {
		IncidentCreator creator = new IncidentCreator();
		Incident i1 = creator.createIncident();
		i1.setProperties(creator.createRandomProperties());
		creator.createRandTemperatures(i1.getProperties(), 4);
		i1.setProperties(new HashMap<String,Object>());
		i1.getProperties().put("intervention", true);
		PrintIncidentProperties<String, Object> print = new PrintIncidentProperties<>(i1.getProperties());
		Assert.assertEquals("intervention=\"true\"", print.toString());
		String result = i1.toString();
		Assert.assertEquals(i1.toString(), result);
	}

}
	