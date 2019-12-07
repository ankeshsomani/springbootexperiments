package com.ankesh.springrestsoap.soap.exception;

import javax.xml.namespace.QName;

import com.ankesh.springrestsoap.exception.ObjectMappingFailureException;
import com.ankesh.springrestsoap.exception.ServiceFailureException;
import com.ankesh.springrestsoap.exception.TransactionFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.server.endpoint.SoapFaultMappingExceptionResolver;

import com.ankesh.springrestsoap.constants.ExceptionConstants;


public class DetailSoapFaultDefinitionExceptionResolver extends SoapFaultMappingExceptionResolver {

	private static final QName STATUS_CODE = new QName("statusCode");
	private static final QName MESSAGE = new QName("message");
	private static final QName ERROR_CODE = new QName("errorCode");

	@Override
	protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
		logger.warn("Exception processed ", ex);
		SoapFaultDetail detail = fault.addFaultDetail();
	
		detail.addFaultDetailElement(MESSAGE).addText(ex.getMessage());
		if (ex instanceof ObjectMappingFailureException) {
			detail.addFaultDetailElement(ERROR_CODE).addText(ExceptionConstants.OBJECT_MAPPPING_ERROR_CODE);
			detail.addFaultDetailElement(STATUS_CODE).addText(HttpStatus.BAD_REQUEST.name());
		}
		else if (ex instanceof TransactionFailureException) {
			detail.addFaultDetailElement(ERROR_CODE).addText(ExceptionConstants.TRANSACTION_FAILURE_ERROR_CODE);
			detail.addFaultDetailElement(STATUS_CODE).addText(HttpStatus.INTERNAL_SERVER_ERROR.name());
			
		}
		else if (ex instanceof ServiceFailureException) {
			detail.addFaultDetailElement(ERROR_CODE).addText(ExceptionConstants.SERVICE_FAILURE_EXCEPTION_CODE);
			detail.addFaultDetailElement(STATUS_CODE).addText(HttpStatus.INTERNAL_SERVER_ERROR.name());
		}
	}

}