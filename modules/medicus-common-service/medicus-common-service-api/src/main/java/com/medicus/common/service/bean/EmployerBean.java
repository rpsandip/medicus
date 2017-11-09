package com.medicus.common.service.bean;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.medicus.common.service.model.Employer;

public class EmployerBean {
	
	Log _log = LogFactoryUtil.getLog(EmployerBean.class.getName());
	
	private long employerId;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private long userId;
	private long employerOrgId;
	private String address1;
	private String  address2;
	private String city;
	private String zipcode;
	private String state;
	private String country;
	private String contactPersonName;
	private String contactPersonEmail;
	private String contactPersonPhoneNumber;
	private String websiteLink;
	
	public EmployerBean(Employer employer){
		this.firstName=employer.getFirstName();
		this.lastName = employer.getLastName();
		this.emailAddress = employer.getEmailAddress();
		this.employerId = employer.getEmployerId();
		this.address1 = employer.getAddress1();
		this.address2 = employer.getAddress2();
		this.city = employer.getCity();
		this.zipcode = employer.getZipcode();
		this.state = employer.getState();
		this.country = employer.getCountry();
		this.contactPersonName = employer.getContactPersonName();
		this.contactPersonEmail = employer.getContactPersonEmail();
		this.contactPersonPhoneNumber = employer.getContactPersonPhoneNumber();
		this.websiteLink = employer.getWebsiteLink();
		
		
		if(this.userId>0){
			try {
				User user = UserLocalServiceUtil.getUser(userId);
				this.firstName = user.getFirstName();
				this.lastName = user.getLastName();
				this.emailAddress = user.getEmailAddress();
			} catch (PortalException e) {
				_log.error(e);
			}
		}
	}

	public long getEmployerId() {
		return employerId;
	}

	public void setEmployerId(long employerId) {
		this.employerId = employerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getEmployerOrgId() {
		return employerOrgId;
	}

	public void setEmployerOrgId(long employerOrgId) {
		this.employerOrgId = employerOrgId;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getContactPersonEmail() {
		return contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}

	public String getContactPersonPhoneNumber() {
		return contactPersonPhoneNumber;
	}

	public void setContactPersonPhoneNumber(String contactPersonPhoneNumber) {
		this.contactPersonPhoneNumber = contactPersonPhoneNumber;
	}

	public String getWebsiteLink() {
		return websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
