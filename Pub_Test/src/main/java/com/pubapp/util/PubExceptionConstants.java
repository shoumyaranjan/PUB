package com.pubapp.util;

public enum PubExceptionConstants {

	KEY_NOT_FOUND(3000,"Invalid Key Parameter","Fail"),
	APPID_NOT_FOUND(3001,"Invalid Appid","Fail"),
	USERID_NOT_FOUND(3002,"Invalid Userid","Fail"),
	SUCCESSFULLY_UPDATED_KEY_VALUE(8000,"Key value succefully updated","Success"),
	SUCCESSFULLY_UPDATED_APPLICATION(9000,"Application successfully updated","Success"),
	SUCCESSFULLY_SAVE_USER(7000,"User successfully saved","success"),
	ACTION_NOT_FOUND(3003,"Action not found","Fail"),
	NEW_USER_NOT_FOUND(3004,"Empty User Info","Fail"),
	APP_ID_NOT_FOUND(3005,"Empty App Id","Fail"),
	USER_ID_NOT_FOUND(3006,"Empty User Id","Fail"),
    KEY_VALUE_NOT_FOUND(3007,"Empty Key value pair","Fail"),
   APPLICATION_TAB_NOT_FOUND(3008,"Empty Applications","Fail"),
   EMAIL_NOT_FOUND(3009,"Empty email field","Fail"),
   UPASSWORD_NOT_FOUND(3010,"Empty Password field","Fail"),
   USER_ALREADY_EXIST(3011,"User Already Exist","Fail"),
   TOKEN_NOT_FOUND(3012,"Token Is Missing","Fail")
   // KEY_NOT_FOUND(3004,"Invalid user","Fail"),
    ;
	private int code;
	private String message;
	private String status;
	private PubExceptionConstants(int code, String message, String status) {
		this.code = code;
		this.message = message;
		this.status = status;
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
	
	
	
}
