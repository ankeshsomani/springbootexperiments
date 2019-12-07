package com.ankesh.springrestsoap.service;

import java.util.Date;

import com.ankesh.springrestsoap.domain.ContactInfo;
import com.ankesh.springrestsoap.exception.ServiceFailureException;
import com.ankesh.springrestsoap.exception.TransactionFailureException;
import com.ankesh.springrestsoap.repository.ContactInfoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankesh.springrestsoap.constants.ExceptionConstants;
import com.ankesh.springrestsoap.mapper.ContactInfoMapper;


@Service
public class ContactInfoService {

	@Autowired
	private ContactInfoRepository contactInfoRepository;

	Logger logger = Logger.getLogger(ContactInfoService.class);

	@Transactional(rollbackFor = { Exception.class })
	public ContactInfo addContactInfo(
			ContactInfo contactInfoDomain) {

		logger.info(contactInfoDomain);

		try {
			com.ankesh.springrestsoap.entity.ContactInfo contactInfoEntity = ContactInfoMapper
					.convertContactInfoDomainToEntity(contactInfoDomain);
			contactInfoEntity.setCreatedOn(new Date());
			try {
				contactInfoRepository.save(contactInfoEntity);
				
			} catch (Exception e) {
				logger.info("Service Exception :" + e.getMessage());
				throw new TransactionFailureException(ExceptionConstants.TRANSACTION_FAILURE_ERROR_MESSAGE, e);
			}
			
			return contactInfoDomain;

		} catch (TransactionFailureException te) {
			logger.info("Service Exception :" + te.getMessage());
			throw new TransactionFailureException(ExceptionConstants.TRANSACTION_FAILURE_ERROR_MESSAGE, te);
		} catch (Exception e) {
			logger.info("Service Exception :" + e.getMessage());
			throw new ServiceFailureException(ExceptionConstants.SERVICE_FAILURE_EXCEPTION_MESSAGE, e);
		}

	}

}
