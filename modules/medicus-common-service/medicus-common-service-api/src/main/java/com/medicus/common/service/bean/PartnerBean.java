package com.medicus.common.service.bean;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.medicus.common.service.model.Partner;

public class PartnerBean {
	Log _log = LogFactoryUtil.getLog(PartnerBean.class.getName());
	
	private long partnerId;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private long userId;
	private long partnerOrgId;
	private String address1;
	private String city;
	private String zipcode;
	private String state;
	private String country;
	private String contactPersonName;
	private String contactPersonEmail;
	private String contactPersonPhoneNumber;
	private String websiteLink;
	
	public PartnerBean(Partner partner){
		this.partnerId = partner.getPartnerId();
		this.userId = partner.getUserId();
		this.partnerOrgId = partner.getPartnerId();
		this.address1 = partner.getAddress1();
		this.city = partner.getCity();
		this.zipcode = partner.getZipcode();
		this.state = partner.getState();
		this.country = partner.getCountry();
		this.contactPersonName = partner.getContactPersonName();
		this.contactPersonEmail = partner.getContactPersonEmail();
		this.contactPersonPhoneNumber = partner.getContactPersonPhoneNumber();
		this.websiteLink = partner.getWebsiteLink();
		
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
	
	
	public long getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(long partnerId) {
		this.partnerId = partnerId;
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getPartnerOrgId() {
		return partnerOrgId;
	}
	public void setPartnerOrgId(long partnerOrgId) {
		this.partnerOrgId = partnerOrgId;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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
	
	
}
