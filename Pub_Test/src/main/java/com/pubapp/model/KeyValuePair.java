package com.pubapp.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

@DynamoDBDocument
public class KeyValuePair {
	@DynamoDBAttribute(attributeName="key")
private String key;
	@DynamoDBAttribute(attributeName="value")
private Object value;
public String getKey() {
	return key;
}
public void setKey(String key) {
	this.key = key;
}
public Object getValue() {
	return value;
}
public void setValue(Object value) {
	this.value = value;
}
@Override
public String toString() {
	return "KeyValuePair [key=" + key + ", value=" + value + "]";
}

}
