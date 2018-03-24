package com.uniovi.utils;

import java.util.Map;

import javax.persistence.AttributeConverter;

public class InciPropertiesConversor implements AttributeConverter<Map<String, Object>, String> {
	
	private JsonPropertiesConversor jsonConversor = new JsonPropertiesConversor();
	@Override
	public String convertToDatabaseColumn(Map<String, Object> mapProperties) {
		return jsonConversor.mapToJson(mapProperties);
	}

	@Override
	public Map<String, Object> convertToEntityAttribute(String jsonProperties) {
		return jsonConversor.jsonToMap(jsonProperties);
	}

}
