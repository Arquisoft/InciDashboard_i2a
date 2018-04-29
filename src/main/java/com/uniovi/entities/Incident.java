package com.uniovi.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.uniovi.entities.types.InciState;
import com.uniovi.entities.types.LatLng;
import com.uniovi.json.IncidentToJson;
import com.uniovi.json.JsonToIncident;

@Document(collection = "incidents")
@JsonDeserialize(using = JsonToIncident.class)
@JsonSerialize(using = IncidentToJson.class)
public class Incident {
	@Id 
	private String id;
	
	private String name;
	private String description;
	
	private Agent agent;
	
	private List<String> tags = new ArrayList<String>();
	
	private LatLng location;
	
	private InciState state;	
	
	private List<String> multimedia = new ArrayList<String>();	
	
	private Map<String,Object> properties = new HashMap<String, Object>();
	
	private Operator operator;
	
	private List<String> comments = new ArrayList<String>();
	
	public Incident() {
		
	}

	public Incident(String id, String name, String description, Agent agent, List<String> tags, LatLng location,
			InciState state, List<String> multimedia, Map<String, Object> properties, Operator operator,
			List<String> comments) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.agent = agent;
		this.tags = tags;
		this.location = location;
		this.state = state;
		this.multimedia = multimedia;
		this.properties = properties;
		this.operator = operator;
		this.comments = comments;
	}

	public Incident(String name, Agent agent, LatLng location) {
		super();
		setName(name);
		setAgent(agent);
		setLocation(location);
	}
	
	public String getId() {
		return id;
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

	public Map<String, Object> getProperties() {
		return properties;
	}
	
	public void setProperties(Map<String, Object> properties) {
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
	
	public void addComment(String comment) {
		this.comments.add(comment);
	}

	@Override
	public String toString() {
		return "Incident [id=" + id + ", agent=" + agent + ", name=" + name + ", description=" + description
				+ ", location=" + location + ", state=" + state + ", tags=" + tags + ", multimedia=" + multimedia
				+ ", properties=" + properties + ", operator=" + operator + "]";
	}

	
}
