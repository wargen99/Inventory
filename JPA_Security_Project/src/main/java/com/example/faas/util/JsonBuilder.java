package com.example.faas.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.google.gson.GsonBuilder;

@Component
public class JsonBuilder {

	
	private static GsonBuilder gsonbuilder;
	
	@Autowired
    public JsonBuilder(GsonBuilder gs) {
		gsonbuilder = gs;
    }
	
	public static String buildJson(Object obj) {
		return gsonbuilder.create().toJson(obj);
	}

	public static <T> T getObject(Class<T> type, String jsonString) {
		return gsonbuilder.create().fromJson(jsonString, type);
	}
}
