package com.uniovi.entities;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.uniovi.json.IncidentToJson;
import com.uniovi.json.JsonToIncident;
import com.uniovi.utils.PrintIncidentProperties;

@Entity
@JsonDeserialize(using = JsonToIncident.class)
@JsonSerialize(using = IncidentToJson.class)
public class Incident {
	@Id 
	@GeneratedValue
	private Long id;
	
	private String name;
	private String description;
	
	@ManyToOne
	@JoinColumn(name="agen_id")
	private Agent agent;
	
	private String tags;
	private LatLng location;
	
	@Enumerated(EnumType.STRING)
	private InciState state;
	
	private Map<String,Object> properties;
	
	public Incident() {
		
	}

	public Incident(String name, Agent agent, LatLng location) {
		super();
		this.name = name;
		this.agent = agent;
		this.location = location;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public LatLng getLocation() {
		return location;
	}

	public void setLocation(LatLng location) {
		this.location = location;
	}

	public InciState getState() {
		return state;
	}

	public void setState(InciState state) {
		this.state = state;
	}

	public Map<String, Object> getProperties() {
		return properties;
	}
	
	public String getPrintedProperties() {
		return new PrintIncidentProperties<String, Object>(getProperties()).toString();
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	public Long getId() {
		return id;
	}
	
	
}
