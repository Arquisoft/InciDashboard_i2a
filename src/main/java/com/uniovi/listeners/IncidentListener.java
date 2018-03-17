package com.uniovi.listeners;

import javax.annotation.ManagedBean;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@ManagedBean
public class IncidentListener {
	private static final Logger logger = Logger.getLogger(IncidentListener.class);
	
	@Autowired
	private SimpMessagingTemplate messagingTemplate;
	
	@KafkaListener(topics ="example")
	public void listenExample(String data) {
		logger.info("New example incident received: " + data);
	}
}
