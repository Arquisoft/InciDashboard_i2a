package com.uniovi.utils;

import java.lang.reflect.Type;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Component
public class JsonConversor {
	
	public <K, V> String mapToJson(Map<String, Object> map) {
		Gson gson = new Gson();
		String json = gson.toJson(map);
		return json;
	}
	
	public <K, V> Map<K, V> jsonToMap(String json) {
		Gson gson = new Gson();
		Type type = new TypeToken<Map<K, V>>(){}.getType();
		Map<K, V> map = gson.fromJson(json, type);		
		return map;
	}
}
