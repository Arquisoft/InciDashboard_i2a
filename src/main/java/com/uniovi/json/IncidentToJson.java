package com.uniovi.json;

import java.io.IOException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.uniovi.entities.Incident;

public class IncidentToJson extends JsonSerializer<Incident>{
	
	@Override
	public void serialize(Incident incident, 
			JsonGenerator jsonGenerator, SerializerProvider serProvider) throws IOException {
		jsonGenerator.writeStartObject();
		
		jsonGenerator.writeStringField("id", String.valueOf(incident.getId()));
	
		jsonGenerator.writeStringField("name", incident.getName());
		jsonGenerator.writeStringField("description", incident.getDescription());
		
		// incident's agent
		jsonGenerator.writeStringField("agentId", incident.getAgentId());
		jsonGenerator.writeStringField("kindCode", String.valueOf(incident.getKindCode()));		
		// tags
		jsonGenerator.writeArrayFieldStart("tags");
		for(String tag: incident.getTags()) {
			jsonGenerator.writeString(tag);
		}
		jsonGenerator.writeEndArray();
		
		// location
		jsonGenerator.writeObjectFieldStart("location");
		jsonGenerator.writeStringField("lat", String.valueOf(incident.getLocation().getLat()));
		jsonGenerator.writeStringField("lng", String.valueOf(incident.getLocation().getLng()));
		jsonGenerator.writeEndObject();
		
		// state
		jsonGenerator.writeStringField("state", incident.getState().toString());
		
		//multimedia
		jsonGenerator.writeArrayFieldStart("multimedia");
		for(String multimedia: incident.getMultimedia()) {
			jsonGenerator.writeString(multimedia);
		}
		jsonGenerator.writeEndArray();
		
		//properties
		jsonGenerator.writeArrayFieldStart("properties");
		for(String property: incident.getProperties().keySet()) {
			jsonGenerator.writeStartObject();
			jsonGenerator.writeObjectField(property, incident.getProperties().get(property));
			jsonGenerator.writeEndObject();
		}
		jsonGenerator.writeEndArray();		
		
		//operator
		jsonGenerator.writeObjectFieldStart("operator");
		jsonGenerator.writeStringField("email", incident.getOperator().getEmail());
		jsonGenerator.writeStringField("password", incident.getOperator().getPassword());
		jsonGenerator.writeStringField("kind", incident.getOperator().getKind().toString());
		jsonGenerator.writeEndObject();
		
		//comments
		jsonGenerator.writeArrayFieldStart("comments");
		for(String comment: incident.getComments()) {
			jsonGenerator.writeString(comment);
		}
		jsonGenerator.writeEndArray();
		
		jsonGenerator.writeEndObject();
	}

}
