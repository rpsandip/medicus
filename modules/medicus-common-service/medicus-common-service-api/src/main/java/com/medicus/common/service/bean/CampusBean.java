package com.medicus.common.service.bean;

import java.util.Date;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.medicus.common.service.model.Campus;
import com.medicus.common.service.model.School;
import com.medicus.common.service.service.SchoolLocalServiceUtil;

public class CampusBean {
	
	Log _log = LogFactoryUtil.getLog(CampusBean.class.getName());
	
	private long campusId;
	private long schoolId;
	private String name;
	private String schoolName;
	private String address1;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	private String contactNumber;
	private String websiteLink;
	private String contactPersonName;
	private String contactPersonPhoneNumber;
	private String contactPersonEmail;
	private int status;
	private Date createDate;
	private long  createdBy;
	private Date modifiedDate;
	private long  modifiedBy;
	
	public CampusBean(Campus campus){
		this.campusId = campus.getCampusId();
		this.schoolId = campus.getSchoolId();
		this.name = campus.getName();
		this.address1 = campus.getAddress1();
		this.city = campus.getCity();
		this.websiteLink = campus.getWebsiteLink();
		this.state = campus.getState();
		this.country = campus.getCountry();
		this.zipcode = campus.getZipcode();
		this.contactNumber = campus.getContactNumber();
		this.contactPersonName = campus.getContactPersonName();
		this.contactPersonEmail = campus.getContactPersonEmail();
		this.contactPersonPhoneNumber = campus.getContactPersonPhoneNumber();
		this.state  = campus.getState();
		this.createDate = campus.getCreateDate();
		this.createdBy = campus.getCreatedBy();
		this.modifiedDate = campus.getModifiedDate();
		this.modifiedBy = campus.getModifiedBy();
		
		if(this.schoolId>0){
			try {
				School school = SchoolLocalServiceUtil.getSchool(this.schoolId);
				this.schoolName = school.getName();
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		
	}
	
	
	public long getCampusId() {
		return campusId;
	}
	public void setCampusId(long campusId) {
		this.campusId = campusId;
	}
	public long getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(long schoolId) {
		this.schoolId = schoolId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getWebsiteLink() {
		return websiteLink;
	}
	public void setWebsiteLink(String websiteLink) {
		this.websiteLink = websiteLink;
	}
	public String getContactPersonName() {
		return contactPersonName;
	}
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}
	public String getContactPersonPhoneNumber() {
		return contactPersonPhoneNumber;
	}
	public void setContactPersonPhoneNumber(String contactPersonPhoneNumber) {
		this.contactPersonPhoneNumber = contactPersonPhoneNumber;
	}
	public String getContactPersonEmail() {
		return contactPersonEmail;
	}
	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public long getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(long modifiedBy) {
		this.modifiedBy = modifiedBy;
	}


	public String getSchoolName() {
		return schoolName;
	}


	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	
	
}
