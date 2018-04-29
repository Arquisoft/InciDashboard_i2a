package com.uniovi.tests_domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.uniovi.entities.*;
import com.uniovi.entities.types.*;

public class IncidentTest {
	private Incident inci1;
	private Incident inci2;
	
	private Agent agent1;
	private Agent agent2;
	
	private Operator op1;
	private Operator op2;	
	
	@Before
	public void setUp() {
		agent1 = new Agent("juan@gmail.com", "123456", AgentKind.PERSON);
		agent2 = new Agent("rainsensor@gmail.com", "123456", AgentKind.SENSOR);
		
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
		
		inci1 = new Incident(1L, "Fire", "Intense fire in the EII at UNIOVI", agent1, inci1_tags, new LatLng(43.354929,-5.851416), InciState.OPEN, inci1_multimedia, inci1_properties, op1, inci1_comments);
	
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
		
		inci2 = new Incident(2L, "Rain", "Rain storm affecting A-66", agent2, inci2_tags, new LatLng(43.3584404,-5.8284433), InciState.OPEN, inci2_multimedia, inci2_properties, op2, inci2_comments);
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
	public void inciAgentTest() {
		Assert.assertEquals(agent1, inci1.getAgent());
		Assert.assertEquals(agent2, inci2.getAgent());
		
		inci1.setAgent(agent2);
		Assert.assertEquals(agent2, inci1.getAgent());

		inci2.setAgent(agent1);
		Assert.assertEquals(agent1, inci2.getAgent());
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
	}
	
	@Test
	public void inciPropertiesTest() {
		Assert.assertEquals(3, inci1.getProperties().size());
		Assert.assertEquals(3, inci2.getProperties().size());
		
		inci1.getProperties().put("intervention", true);
		inci2.getProperties().put("intervention", true);
		
		Assert.assertEquals(4, inci1.getProperties().size());
		Assert.assertEquals(4, inci2.getProperties().size());
	}
	
	@Test
	public void inciOperatorTest() {
		Assert.assertEquals(op1, inci1.getOperator());
		Assert.assertEquals(op2, inci2.getOperator());
		
		inci1.setOperator(op2);
		inci2.setOperator(op1);
		Assert.assertEquals(op2, inci1.getOperator());
		Assert.assertEquals(op1, inci2.getOperator());
	}
	
	@Test
	public void inciCommentsTest() {
		Assert.assertEquals(2, inci1.getComments().size());
		Assert.assertEquals(2, inci2.getComments().size());
		
		inci1.addComment("Incident managed successfully");
		inci2.addComment("Incident managed successfully");
		
		Assert.assertEquals(3, inci1.getComments().size());
		Assert.assertEquals(3, inci2.getComments().size());
	}

}
	