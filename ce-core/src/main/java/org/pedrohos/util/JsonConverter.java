package org.pedrohos.util;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonConverter {

	public static <T> T convert(String json, Class<T> clazz) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.readValue(json, clazz);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
