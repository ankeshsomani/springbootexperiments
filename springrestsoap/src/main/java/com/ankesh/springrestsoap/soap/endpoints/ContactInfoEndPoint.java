package com.ankesh.springrestsoap.soap.endpoints;


import com.ankesh.springrestsoap.soap.dto.AddContactInfoSoapResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.ankesh.springrestsoap.domain.ContactInfo;
import com.ankesh.springrestsoap.mapper.ContactInfoMapper;
import com.ankesh.springrestsoap.service.ContactInfoService;
import com.ankesh.springrestsoap.soap.dto.AddContactInfoSoapRequest;


@Endpoint
public class ContactInfoEndPoint {
    private static final String NAMESPACE_URI = "http://ankesh.com/springrestsoap/soap/dto";

    Logger logger = Logger.getLogger(ContactInfoEndPoint.class);

    @Autowired
    private ContactInfoService contactInfoService;

    @PayloadRoot(namespace = NAMESPACE_URI,localPart = "addContactInfoSoapRequest")
    @ResponsePayload
    public AddContactInfoSoapResponse addContactInfo(@RequestPayload AddContactInfoSoapRequest addContactInfoSoapRequest){

        ContactInfo contactInfo = ContactInfoMapper.convertToContactInfoDomain(addContactInfoSoapRequest.getContactInfoSoapRequest());
        contactInfoService.addContactInfo(contactInfo);
        AddContactInfoSoapResponse response = new AddContactInfoSoapResponse();
        response.setErrorCode(null);
        response.setErrorMessage("no error");
        response.setSuccess(true);     
        return response;
    }


}
