package com.uniovi.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import com.uniovi.entities.Agent;
import com.uniovi.entities.Incident;
import com.uniovi.entities.types.AgentKind;
import com.uniovi.entities.types.InciState;
import com.uniovi.entities.types.LatLng;

@Component
public class IncidentCreator {
	
	private List<Agent> agents;
	private Incident randIncident;
	private Random randNum;
	private SimpleDateFormat dateFormat;
	
	public IncidentCreator() {
		agents = new ArrayList<>();
		randNum = new Random();
		dateFormat = new SimpleDateFormat("HH:mm");
	}
	
	public void setAgents(List<Agent> agents) {
		this.agents = agents;
	}
	
	public Incident createIncident() {
		randIncident = new Incident();
		randIncident.setName(RandomStringUtils.randomAlphabetic(7));
		
		int randIndex = randNum.nextInt(agents.size());
		randIncident.setAgent(agents.get(randIndex));
		
		double lat = 35 + (randNum.nextDouble() * (44-35));
		double lng = -10 + (randNum.nextDouble() * (5+10));
		LatLng coords = new LatLng(lat, lng);
		randIncident.setLocation(coords);
		randIncident.setState(InciState.values()[randNum.nextInt(InciState.values().length)]);
		
		randIncident.setProperties(createRandomProperties());
		
		return randIncident;
	}
	
	private Map<String, Object> createRandomProperties(){
		Map<String, Object> randProperties = new HashMap<>();
		
		int randPriority = randNum.nextInt(5);
		randProperties.put("priority", randPriority);
		if(randIncident.getAgent().getKind().equals(AgentKind.SENSOR)) {
			/*double randTemp = 35 + (randNum.nextDouble() * (90-35));
			randProperties.put("temp", String.valueOf(randTemp));*/
			createRandTemperatures(randProperties, 12);
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.HOUR, 1);
			randProperties.put("expiration", calendar.getTime());
		}
		
		return randProperties;
	}
	
	private void createRandTemperatures(Map<String, Object> randProperties, int numTemps) {
		Calendar calendar = Calendar.getInstance();
		String[] temps = new String[numTemps];
		for(int i=0; i<numTemps; i++) {			
			String time = dateFormat.format(calendar.getTime());
			calendar.add(Calendar.MINUTE, 5);
			double randTemp = 35 + (randNum.nextDouble() * (90-35));
			temps[i] = time + "-" + randTemp;
		}
		randProperties.put("temp", temps);
	}
}
