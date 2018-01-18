package com.lecoder.common.exception;

public class UserException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -788042106330513890L;
	
	public static final int USER_EXISTED = 1;
	
	public static final int USER_PASSWORD_ERROR = 2;
	
	public static final int USER_NOT_EXIST = 3;
	
	private int code;
	
	public UserException(int code,String msg){
		super(msg);
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	
}
