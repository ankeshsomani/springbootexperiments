package com.ankesh.springrestsoap.exception;

public class ObjectMappingFailureException extends ContactInfoServiceException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8902203796217419299L;

	public ObjectMappingFailureException(){
		super();
	}
	
	public ObjectMappingFailureException(String msg) {
		super(msg);
	}
	
	public ObjectMappingFailureException(Throwable throwable) {
		super(throwable);
	}

	public ObjectMappingFailureException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	
	public String getExceptionMessage() {
		return this.getMessage();
	}

}
