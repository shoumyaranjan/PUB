package com.pubapp.model;

import java.util.Date;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.pubapp.util.KeyValueConverter;
@DynamoDBDocument
public class ApplicationTab {
	@DynamoDBAttribute(attributeName="appid")
	
	private int appid;
	@DynamoDBAttribute(attributeName="appname")
	private String appname;
	@DynamoDBAttribute(attributeName="keyvaluepairs")
	private List<KeyValuePair> keyvaluepairs;
	
	@DynamoDBTypeConverted(converter = KeyValueConverter.class)
	public List<KeyValuePair> getKeyvaluepairs() {
		return keyvaluepairs;
	}
	@DynamoDBTypeConverted(converter = KeyValueConverter.class)
	public void setKeyvaluepairs(List<KeyValuePair> keyvaluepairs) {
		this.keyvaluepairs = keyvaluepairs;
	}
	public int getAppid() {
		return appid;
	}
	public void setAppid(int appid) {
		this.appid = appid;
	}
	public String getAppname() {
		return appname;
	}
	public void setAppname(String appname) {
		this.appname = appname;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	Date date=new Date();

	@Override
	public String toString() {
		return "ApplicationTab [appid=" + appid + ", appname=" + appname + ", date=" + date + "]";
	}
	
	
	
	

}
