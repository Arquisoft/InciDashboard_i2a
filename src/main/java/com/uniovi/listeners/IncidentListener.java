package com.uniovi.listeners;

import javax.annotation.ManagedBean;

import org.jboss.logging.Logger;
import org.springframework.kafka.annotation.KafkaListener;

@ManagedBean
public class IncidentListener {
	private static final Logger logger = Logger.getLogger(IncidentListener.class);
	
	@KafkaListener(topics ="example")
	public void listenExample(String data) {
		logger.info("New example incident received: " + data);
	}
}
