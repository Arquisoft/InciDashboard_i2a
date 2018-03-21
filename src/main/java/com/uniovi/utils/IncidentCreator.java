package com.uniovi.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import com.uniovi.entities.Agent;
import com.uniovi.entities.Incident;
import com.uniovi.entities.types.AgentKind;
import com.uniovi.entities.types.LatLng;

@Component
public class IncidentCreator {
	
	private List<Agent> agents;
	private Incident randIncident;
	
	public IncidentCreator() {
		agents = new ArrayList<>();
	}
	
	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	
	public Incident createIncident() {
		randIncident = new Incident();
		randIncident.setName(RandomStringUtils.randomAlphabetic(7));
		
		int randIndex = (int) Math.random() * agents.size();
		randIncident.setAgent(agents.get(randIndex));
		
		double lat = (Math.random() * (43 - 40)) + 40;
		double lng = (Math.random() * (30 - 5 )) + 5;
		LatLng coords = new LatLng(lat, lng);
		randIncident.setLocation(coords);
		
		randIncident.setProperties(createRandomProperties());
		
		return randIncident;
	}
	
	private Map<String, String> createRandomProperties(){
		Map<String, String> randProperties = new HashMap<>();
		
		int randPriority = (int) Math.random() * 5;
		randProperties.put("priority", String.valueOf(randPriority));
		if(randIncident.getAgent().getKind().equals(AgentKind.SENSOR)) {
			double randTemp = (Math.random() * (90 - 35)) + 35;
			randProperties.put("temp", String.valueOf(randTemp));
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.HOUR, 1);
			randProperties.put("expiration", calendar.getTime().toString());
		}
		
		return randProperties;
	}
}
