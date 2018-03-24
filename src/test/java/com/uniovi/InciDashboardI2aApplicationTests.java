package com.uniovi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.uniovi.entities.Agent;
import com.uniovi.entities.Incident;
import com.uniovi.entities.Operator;
import com.uniovi.entities.types.AgentKind;
import com.uniovi.entities.types.InciState;
import com.uniovi.entities.types.LatLng;
import com.uniovi.entities.types.OperatorKind;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InciDashboardI2aApplicationTests {

	@Test
	public void agentTest() {
		Agent person = new Agent("Agent1", "passwd", AgentKind.PERSON);
		assertEquals("Agent1", person.getUsername());
		person.setUsername("Person");
		assertEquals("Person", person.getUsername());
		assertEquals("passwd", person.getPassword());
		person.setPassword("123456");
		assertEquals("123456", person.getPassword());
		assertEquals(AgentKind.PERSON, person.getKind());
		person.setKind(AgentKind.SENSOR);
		assertEquals(AgentKind.SENSOR, person.getKind());
		assertEquals("Agent [id=" + person.getId() + ", username=" + person.getUsername() + ", password="
				+ person.getPassword() + ", kind=" + person.getKind() + "]", person.toString());
		Agent person2 = new Agent("Agent1", "passwd", AgentKind.PERSON);
		assertEquals(true, person.equals(person2));
	}

	@Test
	public void incidentTest() {
		Agent person = new Agent("fireman", "passwd", AgentKind.PERSON);

		LatLng latLng = new LatLng(23.13, 46.12);

		Incident incident = new Incident("Fire", person, latLng);

		incident.setDescription("fire in a building");

		List<String> tags = new ArrayList<String>();
		tags.add("fire");
		tags.add("fireman");
		tags.add("building");
		tags.add("help");
		incident.setTags(tags);
		incident.addTag("sos");

		incident.setState(InciState.OPEN);

		Map<String, String> properties = new HashMap<String, String>();
		properties.put("danger", "medium");
		properties.put("injured", "3");
		properties.put("deaths", "1");
		incident.setProperties(properties);

		Operator op = new Operator("op1@gmail.com", "1234", OperatorKind.FIREMAN);
		incident.setOperator(op);

		List<String> comments = new ArrayList<String>();
		comments.add("fire in street xxx");
		comments.add("3 injured people, 1 death");
		incident.setComments(comments);

		List<String> multimedia = new ArrayList<String>();
		multimedia.add("pic1.jpg");
		multimedia.add("vid1.avi");
		incident.setMultimedia(multimedia);
		incident.addFile("pic2.png");

		assertEquals("Fire", incident.getName());
		assertEquals("fire in a building", incident.getDescription());
		assertEquals(person, incident.getAgent());
		assertEquals(tags, incident.getTags());
		assertEquals(latLng, incident.getLocation());
		assertEquals(InciState.OPEN, incident.getState());
		assertEquals(multimedia, incident.getMultimedia());
		assertEquals(properties, incident.getProperties());
		assertEquals(op, incident.getOperator());
		assertEquals(comments, incident.getComments());
		assertEquals("Incident [id=" + incident.getId() + ", agent=" + incident.getAgent() + ", name="
				+ incident.getName() + ", description=" + incident.getDescription() + ", location="
				+ incident.getLocation() + ", state=" + incident.getState() + ", tags=" + incident.getTags()
				+ ", multimedia=" + incident.getMultimedia() + ", properties=" + incident.getProperties()
				+ ", operator=" + incident.getOperator() + "]", incident.toString());

	}

	@Test
	public void operatorTest() {
		Operator op = new Operator("op@gmail.com", "12345", OperatorKind.POLICE);

		Agent a = new Agent("police", "12345", AgentKind.PERSON);

		Incident i1 = new Incident("robbery", a, new LatLng(12.65, 85.12));
		Incident i2 = new Incident("homicide", a, new LatLng(42.53, 11.76));

		Set<Incident> incidents = new HashSet<Incident>();
		incidents.add(i1);
		incidents.add(i2);

		op.setIncidents(incidents);

		Incident i3 = new Incident("reckless driving", a, new LatLng(43.66, 87.12));
		incidents.add(i3);
		op.assignIncident(i3);

		assertEquals("op@gmail.com", op.getEmail());
		assertEquals("12345", op.getPassword());
		assertEquals(OperatorKind.POLICE, op.getKind());
		assertEquals(incidents, op.getIncidents());
		assertEquals(true, op.isAssignedToIncident(i2));
		assertEquals(true, op.isAssignedToIncident(i1));
		assertEquals(true, op.isAssignedToIncident(i3));
		assertEquals("Operator [id=" + op.getId() + ", email=" + op.getEmail() + ", password=" + op.getPassword()
				+ ", incidents=" + op.getIncidents() + "]", op.toString());
		
		Operator op2 = new Operator("op@gmail.com", "12345", OperatorKind.POLICE);
		assertEquals(true, op.equals(op2));

	}

	@Test
	public void latLngTest() {
		LatLng lat = new LatLng(12.42, 63.82);
		lat.setLat(23.54);
		lat.setLng(12.86);
		assertTrue(23.54 == lat.getLat());
		assertTrue(12.86 == lat.getLng());
		assertEquals("LatLng [lat=" + lat.getLat() + ", lng=" + lat.getLng() + "]", lat.toString());
	}

}
