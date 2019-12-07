package com.ankesh.springrestsoap.rest.dto;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;

@Getter
@Setter
@ToString
public class ContactInfoRestRequest {

	@JsonProperty(required=true)
	@NotNull(message=" contactName cannot be missing or empty")
	private String contactName;
	
	@JsonProperty
	@NotNull(message="emailAddress cannot be missing or empty")
	private String emailAddress;
	
	@JsonProperty
	@NotNull(message="phoneNumber cannot be missing or empty")
	private String phoneNumber;
	
}
