package com.example.faas.dto;

import com.example.faas.util.JsonBuilder;
import com.google.gson.GsonBuilder;

public class Message {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {

		return JsonBuilder.buildJson(this);
	}
}
