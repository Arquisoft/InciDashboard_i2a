package com.uniovi.json;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniovi.entities.Agent;
import com.uniovi.entities.Incident;
import com.uniovi.entities.types.AgentKind;
import com.uniovi.entities.types.InciState;
import com.uniovi.entities.types.LatLng;

public class JsonToIncident extends JsonDeserializer<Incident>{
	
	@SuppressWarnings("unchecked")
	@Override
	public Incident deserialize(JsonParser jsonParser, DeserializationContext context)
			throws IOException, JsonProcessingException {
		ObjectCodec objectCodec = jsonParser.getCodec();
		JsonNode json = objectCodec.readTree(jsonParser);
		
		Incident incident = new Incident();
		
		incident.setName(json.get("name").textValue());
		incident.setDescription(json.get("description").textValue());
		
		//Agent
		Agent agent = new Agent();
		agent.setUsername(json.get("agentId").textValue());
		agent.setKind(AgentKind.values()[json.get("kindCode").asInt()]);
		incident.setAgent(agent);
		
		//Tags
		Iterator<JsonNode> tagsList = json.get("tags").elements();
		while(tagsList.hasNext()) {
			JsonNode tag = tagsList.next();
			incident.addTag(tag.textValue());
		}
		
		//Location
		LatLng location = new LatLng();
		JsonNode jsonLocation = json.get("location");
		location.setLat(jsonLocation.get("lat").asDouble());
		location.setLng(jsonLocation.get("lng").asDouble());
		incident.setLocation(location);
		
		//State
		incident.setState(InciState.valueOf(json.get("state").textValue()));
		
		//Multimedia
		Iterator<JsonNode> multimediaList = json.get("multimedia").elements();
		while(multimediaList.hasNext()) {
			JsonNode file = multimediaList.next();
			incident.addFile(file.textValue());
		}
		
		//Properties
		JsonNode properties = json.get("properties");
		ObjectMapper mapper = new ObjectMapper();
		incident.setProperties(mapper.convertValue(properties, Map.class));	
		
		return incident;
	}

}
