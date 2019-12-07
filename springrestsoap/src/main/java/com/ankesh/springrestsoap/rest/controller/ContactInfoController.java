package com.ankesh.springrestsoap.rest.controller;

import javax.validation.Valid;

import com.ankesh.springrestsoap.constants.RequestMappingConstants;
import com.ankesh.springrestsoap.domain.ContactInfo;
import com.ankesh.springrestsoap.mapper.ContactInfoMapper;
import com.ankesh.springrestsoap.rest.dto.ServiceResponse;
import com.ankesh.springrestsoap.service.ContactInfoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankesh.springrestsoap.rest.dto.ContactInfoRestRequest;

@RestController
@RequestMapping(value= RequestMappingConstants.CONTACT_INFO_URL)
public class ContactInfoController {
	
	Logger logger = Logger.getLogger(ContactInfoController.class);
	
	@Autowired
	private ContactInfoService contactInfoService;
	
	@PostMapping(path="/add")
	public ServiceResponse addContactInfo(@Valid @RequestBody ContactInfoRestRequest contactInfoRestRequest){
		
		ContactInfo contactInfo = ContactInfoMapper.convertToContactInfoDomain(contactInfoRestRequest);
		contactInfoService.addContactInfo(contactInfo);

		return new ServiceResponse(true, null, null,null);
	}
	
}
