package com.ankesh.springrestsoap.rest.dto;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ServiceResponse {

	@JsonProperty("success")
	private boolean success = false;

	/** The error message. */
	@JsonProperty("errorCode")
	private String errorCode;
	
	/** The error message. */
	@JsonProperty("errorMessage")
	private String errorMessage;
	
	/** The response objects. */
	@JsonProperty("result")
	private Map<String, Object> result;
	
	
}
