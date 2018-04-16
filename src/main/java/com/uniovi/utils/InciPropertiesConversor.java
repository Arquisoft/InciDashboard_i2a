package com.uniovi.utils;

import java.util.Map;

import javax.persistence.AttributeConverter;

public class InciPropertiesConversor implements AttributeConverter<Map<String, Object>, String> {
	
	private JsonConversor jsonConversor = new JsonConversor();
	@Override
	public String convertToDatabaseColumn(Map<String, Object> mapProperties) {
		return jsonConversor.mapToJson(mapProperties);
	}

	@Override
	public Map<String, Object> convertToEntityAttribute(String jsonProperties) {
		return jsonConversor.jsonToMap(jsonProperties);
	}

}
