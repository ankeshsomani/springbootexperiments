package com.ankesh.springrestsoap.exception;

import java.io.Serializable;

public class ContactInfoServiceException extends RuntimeException implements
Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8983828207370741170L;
	
	public ContactInfoServiceException(){
		super();
	}
	
	public ContactInfoServiceException(String msg) {
		super(msg);
	}
	
	public ContactInfoServiceException(Throwable throwable) {
		super(throwable);
	}

	public ContactInfoServiceException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	
	public String getExceptionMessage() {
		return this.getMessage();
	}

	



}
