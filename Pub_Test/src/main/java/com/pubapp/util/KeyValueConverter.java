package com.pubapp.util;

import java.io.IOException;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pubapp.model.KeyValuePair;

public class KeyValueConverter implements DynamoDBTypeConverter<String, List<KeyValuePair>>{

	public String convert(List<KeyValuePair> objects) {
		 ObjectMapper objectMapper = new ObjectMapper();
	        try {
	            String objectsString = objectMapper.writeValueAsString(objects);
	            return objectsString;
	        } catch (JsonProcessingException e) {
	            //do something
	        }
	        return null;
		
	}

	public List<KeyValuePair> unconvert(String objectssString) {
		 ObjectMapper objectMapper = new ObjectMapper();
	        try {
	            List<KeyValuePair> objects = objectMapper.readValue(objectssString, new TypeReference<List<Object>>(){});
	            return objects;
	        } catch (JsonParseException e) {
	            //do something
	        } catch (JsonMappingException e) {
	            //do something
	        } catch (IOException e) {
	            //do something
	        }
		return null;
	}
	
	

}
