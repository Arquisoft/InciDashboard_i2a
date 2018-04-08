package com.uniovi.listeners;

import java.io.IOException;

import javax.annotation.ManagedBean;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniovi.entities.Incident;
import com.uniovi.entities.types.OperatorKind;
import com.uniovi.services.AgentService;
import com.uniovi.services.IncidentService;
import com.uniovi.services.OperatorService;

@ManagedBean
public class IncidentListener {
	private static final Logger logger = Logger.getLogger(IncidentListener.class);
	
	@Autowired
	private AgentService agentsService;
	
	@Autowired
	private OperatorService operatorsService;
	
	@Autowired
	private IncidentService incidentsService;
	
	@KafkaListener(topics ="example")
	public void listenExample(String data) {
		logger.info("New example incident received: " + data);
	}
	
	@KafkaListener(topics = "incident")
	public void listenIncident(String data) {
		logger.info("New incident received: " + data);
		try {
			if(data != null && data.length() != 0) {
				ObjectMapper obj = new ObjectMapper();
				Incident incident = obj.readValue(data.getBytes(), Incident.class);
				OperatorKind opKind = OperatorKind.valueOf((String)incident.getProperties().get("type"));
				incident.setOperator(operatorsService.getRandomOperatorOfKind(opKind));
				agentsService.addAgent(incident.getAgent());
				operatorsService.addOperator(incident.getOperator());
				incidentsService.addIncident(incident);
			}
		}catch(JsonParseException e) {
			e.printStackTrace();			
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
