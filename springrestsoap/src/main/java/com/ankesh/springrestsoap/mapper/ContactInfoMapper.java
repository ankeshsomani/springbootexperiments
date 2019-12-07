package com.ankesh.springrestsoap.mapper;

import com.ankesh.springrestsoap.domain.ContactInfo;
import com.ankesh.springrestsoap.exception.ObjectMappingFailureException;
import com.ankesh.springrestsoap.constants.ExceptionConstants;
import com.ankesh.springrestsoap.rest.dto.ContactInfoRestRequest;
import com.ankesh.springrestsoap.soap.dto.ContactInfoSoapRequest;


public class ContactInfoMapper {

    public static ContactInfo convertToContactInfoDomain(ContactInfoRestRequest contactInfoRestRequest){
    	try{
    		
    		return new ContactInfo(contactInfoRestRequest.getContactName(),
                contactInfoRestRequest.getEmailAddress(),
                contactInfoRestRequest.getPhoneNumber());
    	}catch(Exception obj){
    		throw new ObjectMappingFailureException(ExceptionConstants.OBJECT_MAPPING_FAILURE_ERROR_MESSAGE,obj);
    	}
    }

    public static ContactInfo convertToContactInfoDomain(ContactInfoSoapRequest contactInfoSoapRequest){
    	try{
    		return new ContactInfo(contactInfoSoapRequest.getContactName(),
        		contactInfoSoapRequest.getEmailAddress(),
                contactInfoSoapRequest.getPhoneNumber());
    	}catch(Exception obj){
    		throw new ObjectMappingFailureException(ExceptionConstants.OBJECT_MAPPING_FAILURE_ERROR_MESSAGE,obj);
    	}
    }
    
    public static com.ankesh.springrestsoap.entity.ContactInfo convertContactInfoDomainToEntity(ContactInfo contactInfoDomain){
        
    	try{
    		return new com.ankesh.springrestsoap.entity.ContactInfo(
        		contactInfoDomain.getContactName(),
        		contactInfoDomain.getEmailAddress(),
        		contactInfoDomain.getPhoneNumber());
    	}catch(Exception obj){
    		throw new ObjectMappingFailureException(ExceptionConstants.OBJECT_MAPPING_FAILURE_ERROR_MESSAGE,obj);
    	}
    }
}
