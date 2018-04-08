package com.uniovi.json;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniovi.entities.Agent;
import com.uniovi.entities.Incident;
import com.uniovi.entities.Operator;
import com.uniovi.entities.types.AgentKind;
import com.uniovi.entities.types.InciState;
import com.uniovi.entities.types.LatLng;
import com.uniovi.entities.types.OperatorKind;
import com.uniovi.services.OperatorService;

public class JsonToIncident extends JsonDeserializer<Incident>{

	@Autowired
	private OperatorService operatorsService;
	
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
		agent.setKind(AgentKind.valueOf(json.get("kindCode").textValue()));
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
		
		//Operator
		OperatorKind opKind = OperatorKind.valueOf(properties.get("type").textValue());	
		incident.setOperator(operatorsService.getRandomOperatorOfKind(opKind));
		
		return incident;
	}

}
