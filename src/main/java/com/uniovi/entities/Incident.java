package com.uniovi.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.uniovi.entities.types.InciState;
import com.uniovi.entities.types.LatLng;
import com.uniovi.json.IncidentToJson;
import com.uniovi.json.JsonToIncident;

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
	@JoinColumn(name="agent_id")
	private Agent agent;
	
	@ElementCollection(targetClass=String.class)
	private List<String> tags;
	private LatLng location;
	
	@Enumerated(EnumType.STRING)
	private InciState state;	
	
	@ElementCollection(targetClass=String.class)
	private List<String> multimedia = new ArrayList<String>();	
	
	@Transient
	private Map<String,String> properties = new HashMap<String, String>();
	
	@ManyToOne
	@JoinColumn(name="operator_id")
	private Operator operator;
	
	@ElementCollection(targetClass=String.class)
	private List<String> comments = new ArrayList<String>();
	
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

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	public void addTag(String tag) {
		this.tags.add(tag);
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

	public List<String> getMultimedia() {
		return multimedia;
	}

	public void setMultimedia(List<String> multimedia) {
		this.multimedia = multimedia;
	}
	
	public void addFile(String file) {
		this.multimedia.add(file);
	}

	public Map<String, String> getProperties() {
		return properties;
	}
	
	public void setProperties(Map<String, String> properties) {
		this.properties = properties;
	}	

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public List<String> getComments() {
		return comments;
	}

	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Incident [id=" + id + ", agent=" + agent + ", name=" + name + ", description=" + description
				+ ", location=" + location + ", state=" + state + ", tags=" + tags + ", multimedia=" + multimedia
				+ ", properties=" + properties + ", operator=" + operator + "]";
	}

	
}
