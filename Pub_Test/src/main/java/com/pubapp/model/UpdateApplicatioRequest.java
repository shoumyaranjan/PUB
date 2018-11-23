package com.pubapp.model;

import java.util.List;

import com.pubapp.util.Action;

public class UpdateApplicatioRequest {
	
	private String userid;
	private List<ApplicationTab> aaptab;
	
	private Action updateapplicationaction;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public List<ApplicationTab> getAaptab() {
		return aaptab;
	}

	public void setAaptab(List<ApplicationTab> aaptab) {
		this.aaptab = aaptab;
	}

	public Action getUpdateapplicationaction() {
		return updateapplicationaction;
	}

	public void setUpdateapplicationaction(Action updateapplicationaction) {
		this.updateapplicationaction = updateapplicationaction;
	}

}
