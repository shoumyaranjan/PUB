package com.pubapp.model;

import com.pubapp.util.Action;

public class GetApplicationByAppIdRequest
{
	
	private String userid;
	private int appid;
	
	private Action action;

	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

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

	
}
