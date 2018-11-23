package com.pubapp.util;

public enum Action {
	
	
	insertuser("insertuser"),
	updatekevalue("updatekevalue"),
	updateapplication("updateapplication"),
	getapplicationbyappid("getapplicationbyappid"),
	getkeyvaluepairs("getkeyvaluepairs"),
	getvalue("getvalue");
	
	private String path ;

	public String getPath() {
		return path;
	}

	private Action(String path) {
		this.path = path;
	}

	
	

	
}
