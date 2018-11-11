package com.pubapp.util;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DynamoDBUtil {
	private  DynamoDBMapper maper;
	public  DynamoDBMapper initDynamoDbClient() {
		if(this.maper!=null){
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
		this.maper = new DynamoDBMapper(client);
		}
		return this.maper;
	}
}
