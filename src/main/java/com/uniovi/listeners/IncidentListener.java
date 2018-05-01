package com.uniovi.listeners;

import java.io.IOException;

import javax.annotation.ManagedBean;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniovi.entities.Incident;
import com.uniovi.entities.types.OperatorKind;
import com.uniovi.services.IncidentService;
import com.uniovi.services.OperatorService;

@ManagedBean
public class IncidentListener {
	private static final Logger logger = Logger.getLogger(IncidentListener.class);
	
	@Autowired
	private OperatorService operatorsService;
	
	@Autowired
	private IncidentService incidentsService;

	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	@KafkaListener(topics = "${kafka.topic}")
	public void listenIncident(String data) {
		logger.info("New incident received: " + data);
		try {
			if(data != null && data.length() != 0) {
				
				ObjectMapper obj = new ObjectMapper();
				Incident incident = obj.readValue(data.getBytes(), Incident.class);
				OperatorKind opKind = OperatorKind.valueOf((String)incident.getProperties().get("type"));
				incident.setOperator(operatorsService.getRandomOperatorOfKind(opKind));
				incidentsService.addIncident(incident);
				
				messagingTemplate.convertAndSend("/incident", incident);
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
