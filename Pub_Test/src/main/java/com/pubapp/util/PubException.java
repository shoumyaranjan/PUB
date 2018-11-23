package com.pubapp.util;


public class PubException extends Exception{

private int code;
private String message;
private String status;
private Object data;

public PubException(PubExceptionConstants constants) {
	this.code=constants.getCode();
	this.message=constants.getMessage();
	this.status=constants.getStatus();
}

public PubException(PubExceptionConstants constants,Object data) {
	this.code=constants.getCode();
	this.message=constants.getMessage();
	this.status=constants.getStatus();
	this.data=data;
}

public int getCode() {
	return code;
}

public String getMessage() {
	return message;
}

public String getStatus() {
	return status;
}

public Object getData() {
	return data;
}	

	

	
}
