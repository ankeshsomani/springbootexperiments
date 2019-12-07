package com.ankesh.springrestsoap.exception;

import org.apache.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ankesh.springrestsoap.constants.ExceptionConstants;
import com.ankesh.springrestsoap.rest.dto.ServiceResponse;

@ControllerAdvice
public class ServiceExceptionControllerAdvice extends
ResponseEntityExceptionHandler{
	
	private static final Logger logger = Logger.getLogger(ServiceExceptionControllerAdvice.class);
	
	
	@ExceptionHandler(ServiceFailureException.class)
	protected ResponseEntity<Object> handleServiceFailureException(
			ServiceFailureException ex, WebRequest request) {
		// LOG THE MESSAGE

		logger.error(ex.getMessage(), ex);
		ServiceResponse serviceResponse = new ServiceResponse(false,
				ExceptionConstants.SERVICE_FAILURE_EXCEPTION_CODE,ExceptionConstants.SERVICE_FAILURE_EXCEPTION_MESSAGE,null);
		return handleExceptionInternal(ex, serviceResponse, new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR, request);
	}
	
	@ExceptionHandler(TransactionFailureException.class)
	protected ResponseEntity<Object> handleTransactionFailureException(
			TransactionFailureException ex, WebRequest request) {
		// LOG THE MESSAGE
		logger.error(ex.getMessage(), ex);
		ServiceResponse serviceResponse = new ServiceResponse(false,
				ExceptionConstants.TRANSACTION_FAILURE_ERROR_CODE,ExceptionConstants.TRANSACTION_FAILURE_ERROR_MESSAGE,null);
		return handleExceptionInternal(ex, serviceResponse, new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

	@ExceptionHandler(ObjectMappingFailureException.class)
	protected ResponseEntity<Object> handleValidationFailureException(
			ObjectMappingFailureException ex, WebRequest request) {
		logger.error(ex.getMessage(), ex);
		ServiceResponse serviceResponse = new ServiceResponse(false,
				ExceptionConstants.OBJECT_MAPPPING_ERROR_CODE,ExceptionConstants.OBJECT_MAPPING_FAILURE_ERROR_MESSAGE,null);
		return handleExceptionInternal(ex, serviceResponse, new HttpHeaders(),
				HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleServiceException(Exception ex,
			WebRequest request) {
		logger.error(ex.getMessage(), ex);
		ServiceResponse serviceResponse = new ServiceResponse(false,
				ExceptionConstants.RUNTIME_ERROR_CODE,ExceptionConstants.RUNTIME_ERROR_MESSAGE,null);
		return handleExceptionInternal(ex, serviceResponse, new HttpHeaders(),
				HttpStatus.INTERNAL_SERVER_ERROR, request);
	}

}
