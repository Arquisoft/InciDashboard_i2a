package com.uniovi.json;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.uniovi.entities.Incident;

public class IncidentToJson extends JsonSerializer<Incident>{

	
	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public void serialize(Incident incident, 
			JsonGenerator jsonGenerator, SerializerProvider serProvider) throws IOException {
		jsonGenerator.writeStartObject();
		
		jsonGenerator.writeStringField("name", incident.getName());
		jsonGenerator.writeStringField("description", incident.getDescription());
		
		// incident's agent
		jsonGenerator.writeObjectFieldStart("agent");
		jsonGenerator.writeStringField("username", incident.getAgent().getUsername());
		jsonGenerator.writeStringField("password", incident.getAgent().getPassword());
		jsonGenerator.writeStringField("kind", incident.getAgent().getKind().toString());
		jsonGenerator.writeEndObject();
		
		// tags
		jsonGenerator.writeStringField("tags", incident.getTags());
		
		// location
		jsonGenerator.writeObjectFieldStart("location");
		jsonGenerator.writeStringField("lat", String.valueOf(incident.getLocation().getLat()));
		jsonGenerator.writeStringField("lng", String.valueOf(incident.getLocation().getLng()));
		jsonGenerator.writeEndObject();
		
		// state
		jsonGenerator.writeStringField("state", incident.getState().toString());
		
		//properties
		/*String jsonResult = mapper.writerWithDefaultPrettyPrinter()
				  .writeValueAsString(incident.getProperties());
		jsonGenerator.writeStringField("properties", jsonResult);*/
		StringWriter writer = new StringWriter();
        mapper.writeValue(writer, incident.getProperties());
        jsonGenerator.writeFieldName(writer.toString());
		
	}

}
