package com.pubapp.model;

import java.util.List;

import com.pubapp.util.Action;

public class PubRequest {
	private NewUser newuser;
	private String Userid;
	private int appid;
	private List<KeyValuePair> keyvalue;
	private List<ApplicationTab> applicationtab;
	private String key;
	private String action;
	private String token;
	
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public NewUser getNewuser() {
		return newuser;
	}
	public void setNewuser(NewUser newuser) {
		this.newuser = newuser;
	}
	public String getUserid() {
		return Userid;
	}
	public void setUserid(String userid) {
		Userid = userid;
	}
	public int getAppid() {
		return appid;
	}
	public void setAppid(int appid) {
		this.appid = appid;
	}
	public List<KeyValuePair> getKeyvalue() {
		return keyvalue;
	}
	public void setKeyvalue(List<KeyValuePair> keyvalue) {
		this.keyvalue = keyvalue;
	}
	public List<ApplicationTab> getApplicationtab() {
		return applicationtab;
	}
	public void setApplicationtab(List<ApplicationTab> applicationtab) {
		this.applicationtab = applicationtab;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	@Override
	public String toString() {
		return "PubRequest [newuser=" + newuser + ", Userid=" + Userid + ", appid=" + appid + ", keyvalue=" + keyvalue
				+ ", applicationtab=" + applicationtab + ", key=" + key + ", action=" + action + "]";
	}
	
	
	

}
