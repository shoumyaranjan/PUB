package com.pubapp.model;

import com.pubapp.util.Action;

public class GetKeyValuePairsRequest {
	
	private String Userid;
	private int appid;
	private Action action;
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
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
	
	

}
