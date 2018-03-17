package com.uniovi.json;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uniovi.entities.Agent;
import com.uniovi.entities.AgentKind;
import com.uniovi.entities.InciState;
import com.uniovi.entities.Incident;
import com.uniovi.entities.LatLng;

public class JsonToIncident extends JsonDeserializer<Incident>{

	private ObjectMapper mapper = new ObjectMapper();
	
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
		JsonNode jsonAgent = json.get("agent");
		agent.setUsername(jsonAgent.get("username").textValue());
		agent.setPassword(jsonAgent.get("password").textValue());
		agent.setKind(AgentKind.valueOf(jsonAgent.get("kind").textValue()));
		incident.setAgent(agent);
		
		//Tags
		incident.setTags(jsonAgent.get("tags").textValue());
		
		//Location
		LatLng location = new LatLng();
		JsonNode jsonLocation = json.get("location");
		location.setLat(jsonLocation.get("lat").asDouble());
		location.setLng(jsonLocation.get("lng").asDouble());
		incident.setLocation(location);
		
		//State
		incident.setState(InciState.valueOf(json.get("state").textValue()));
		
		//Properties
		
		String jsonInput = "{\"property\": \"value\"}";
		TypeReference<HashMap<String, Object>> typeRef 
		  = new TypeReference<HashMap<String, Object>>() {};
		Map<String, Object> map = mapper.readValue(jsonInput, typeRef);
		incident.setProperties(map);
		
		
		return incident;
	}

}
