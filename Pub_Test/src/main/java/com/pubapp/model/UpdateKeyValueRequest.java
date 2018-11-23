package com.pubapp.model;

import java.util.List;

import com.pubapp.util.Action;

public class UpdateKeyValueRequest {
	
	private String userid;
	private int appid;
	private List<KeyValuePair> keyvalue;
	
	private Action action;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
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

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	

}
