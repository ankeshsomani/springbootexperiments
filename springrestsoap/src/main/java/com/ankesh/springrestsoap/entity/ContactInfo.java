package com.ankesh.springrestsoap.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name="CONTACT_INFO")
public class ContactInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="CONTACT_INFO_SEQ")
	@SequenceGenerator(name="CONTACT_INFO_SEQ",sequenceName="CONTACT_INFO_SEQ",allocationSize=1)
	private long id;
	
	@Column(name="CONTACT_NAME")
    private String contactName;
	
	@Column(name="EMAIL_ADDRESS")
    private String emailAddress;

	@Column(name="PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATED_ON")
	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="IST")
	private Date createdOn;
	
	@Column(name="LAST_MODIFIED_BY")
	private String lastModifiedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_MODIFIED_ON")
	//@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="IST")
	private Date lastModifiedOn;


	public ContactInfo(String contactName, String emailAddress, String phoneNumber) {
		this.contactName = contactName;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
	}
}
