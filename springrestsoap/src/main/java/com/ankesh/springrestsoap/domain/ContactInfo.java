package com.ankesh.springrestsoap.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContactInfo {
	private String contactName;
	
	private String emailAddress;
	
	private String phoneNumber;
	
}
