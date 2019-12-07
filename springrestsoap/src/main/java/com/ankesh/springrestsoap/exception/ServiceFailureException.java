package com.ankesh.springrestsoap.exception;

public class ServiceFailureException extends ContactInfoServiceException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8938662283205739602L;

	public ServiceFailureException(){
		super();
	}
	
	public ServiceFailureException(String msg) {
		super(msg);
	}
	
	public ServiceFailureException(Throwable throwable) {
		super(throwable);
	}

	public ServiceFailureException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	
	public String getExceptionMessage() {
		return this.getMessage();
	}
}
