package com.ankesh.springrestsoap.exception;

public class TransactionFailureException extends ContactInfoServiceException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9028457546286051951L;

	public TransactionFailureException(){
		super();
	}
	
	public TransactionFailureException(String msg) {
		super(msg);
	}
	
	public TransactionFailureException(Throwable throwable) {
		super(throwable);
	}

	public TransactionFailureException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	
	public String getExceptionMessage() {
		return this.getMessage();
	}

}
