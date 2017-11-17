/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.medicus.common.service.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Employer}.
 * </p>
 *
 * @author sandip.patel
 * @see Employer
 * @generated
 */
@ProviderType
public class EmployerWrapper implements Employer, ModelWrapper<Employer> {
	public EmployerWrapper(Employer employer) {
		_employer = employer;
	}

	@Override
	public Class<?> getModelClass() {
		return Employer.class;
	}

	@Override
	public String getModelClassName() {
		return Employer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employerId", getEmployerId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("address1", getAddress1());
		attributes.put("city", getCity());
		attributes.put("zipcode", getZipcode());
		attributes.put("state", getState());
		attributes.put("country", getCountry());
		attributes.put("contactPersonName", getContactPersonName());
		attributes.put("contactPersonEmail", getContactPersonEmail());
		attributes.put("contactPersonPhoneNumber", getContactPersonPhoneNumber());
		attributes.put("websiteLink", getWebsiteLink());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employerId = (Long)attributes.get("employerId");

		if (employerId != null) {
			setEmployerId(employerId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String address1 = (String)attributes.get("address1");

		if (address1 != null) {
			setAddress1(address1);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String zipcode = (String)attributes.get("zipcode");

		if (zipcode != null) {
			setZipcode(zipcode);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String contactPersonName = (String)attributes.get("contactPersonName");

		if (contactPersonName != null) {
			setContactPersonName(contactPersonName);
		}

		String contactPersonEmail = (String)attributes.get("contactPersonEmail");

		if (contactPersonEmail != null) {
			setContactPersonEmail(contactPersonEmail);
		}

		String contactPersonPhoneNumber = (String)attributes.get(
				"contactPersonPhoneNumber");

		if (contactPersonPhoneNumber != null) {
			setContactPersonPhoneNumber(contactPersonPhoneNumber);
		}

		String websiteLink = (String)attributes.get("websiteLink");

		if (websiteLink != null) {
			setWebsiteLink(websiteLink);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	@Override
	public Employer toEscapedModel() {
		return new EmployerWrapper(_employer.toEscapedModel());
	}

	@Override
	public Employer toUnescapedModel() {
		return new EmployerWrapper(_employer.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _employer.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _employer.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _employer.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _employer.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Employer> toCacheModel() {
		return _employer.toCacheModel();
	}

	@Override
	public int compareTo(Employer employer) {
		return _employer.compareTo(employer);
	}

	@Override
	public int hashCode() {
		return _employer.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _employer.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new EmployerWrapper((Employer)_employer.clone());
	}

	/**
	* Returns the address1 of this employer.
	*
	* @return the address1 of this employer
	*/
	@Override
	public java.lang.String getAddress1() {
		return _employer.getAddress1();
	}

	/**
	* Returns the city of this employer.
	*
	* @return the city of this employer
	*/
	@Override
	public java.lang.String getCity() {
		return _employer.getCity();
	}

	/**
	* Returns the contact person email of this employer.
	*
	* @return the contact person email of this employer
	*/
	@Override
	public java.lang.String getContactPersonEmail() {
		return _employer.getContactPersonEmail();
	}

	/**
	* Returns the contact person name of this employer.
	*
	* @return the contact person name of this employer
	*/
	@Override
	public java.lang.String getContactPersonName() {
		return _employer.getContactPersonName();
	}

	/**
	* Returns the contact person phone number of this employer.
	*
	* @return the contact person phone number of this employer
	*/
	@Override
	public java.lang.String getContactPersonPhoneNumber() {
		return _employer.getContactPersonPhoneNumber();
	}

	/**
	* Returns the country of this employer.
	*
	* @return the country of this employer
	*/
	@Override
	public java.lang.String getCountry() {
		return _employer.getCountry();
	}

	/**
	* Returns the email address of this employer.
	*
	* @return the email address of this employer
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _employer.getEmailAddress();
	}

	/**
	* Returns the first name of this employer.
	*
	* @return the first name of this employer
	*/
	@Override
	public java.lang.String getFirstName() {
		return _employer.getFirstName();
	}

	/**
	* Returns the last name of this employer.
	*
	* @return the last name of this employer
	*/
	@Override
	public java.lang.String getLastName() {
		return _employer.getLastName();
	}

	/**
	* Returns the state of this employer.
	*
	* @return the state of this employer
	*/
	@Override
	public java.lang.String getState() {
		return _employer.getState();
	}

	/**
	* Returns the website link of this employer.
	*
	* @return the website link of this employer
	*/
	@Override
	public java.lang.String getWebsiteLink() {
		return _employer.getWebsiteLink();
	}

	/**
	* Returns the zipcode of this employer.
	*
	* @return the zipcode of this employer
	*/
	@Override
	public java.lang.String getZipcode() {
		return _employer.getZipcode();
	}

	@Override
	public java.lang.String toString() {
		return _employer.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _employer.toXmlString();
	}

	/**
	* Returns the create date of this employer.
	*
	* @return the create date of this employer
	*/
	@Override
	public Date getCreateDate() {
		return _employer.getCreateDate();
	}

	/**
	* Returns the modified date of this employer.
	*
	* @return the modified date of this employer
	*/
	@Override
	public Date getModifiedDate() {
		return _employer.getModifiedDate();
	}

	/**
	* Returns the created by of this employer.
	*
	* @return the created by of this employer
	*/
	@Override
	public long getCreatedBy() {
		return _employer.getCreatedBy();
	}

	/**
	* Returns the employer ID of this employer.
	*
	* @return the employer ID of this employer
	*/
	@Override
	public long getEmployerId() {
		return _employer.getEmployerId();
	}

	/**
	* Returns the modified by of this employer.
	*
	* @return the modified by of this employer
	*/
	@Override
	public long getModifiedBy() {
		return _employer.getModifiedBy();
	}

	/**
	* Returns the primary key of this employer.
	*
	* @return the primary key of this employer
	*/
	@Override
	public long getPrimaryKey() {
		return _employer.getPrimaryKey();
	}

	@Override
	public void persist() {
		_employer.persist();
	}

	/**
	* Sets the address1 of this employer.
	*
	* @param address1 the address1 of this employer
	*/
	@Override
	public void setAddress1(java.lang.String address1) {
		_employer.setAddress1(address1);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_employer.setCachedModel(cachedModel);
	}

	/**
	* Sets the city of this employer.
	*
	* @param city the city of this employer
	*/
	@Override
	public void setCity(java.lang.String city) {
		_employer.setCity(city);
	}

	/**
	* Sets the contact person email of this employer.
	*
	* @param contactPersonEmail the contact person email of this employer
	*/
	@Override
	public void setContactPersonEmail(java.lang.String contactPersonEmail) {
		_employer.setContactPersonEmail(contactPersonEmail);
	}

	/**
	* Sets the contact person name of this employer.
	*
	* @param contactPersonName the contact person name of this employer
	*/
	@Override
	public void setContactPersonName(java.lang.String contactPersonName) {
		_employer.setContactPersonName(contactPersonName);
	}

	/**
	* Sets the contact person phone number of this employer.
	*
	* @param contactPersonPhoneNumber the contact person phone number of this employer
	*/
	@Override
	public void setContactPersonPhoneNumber(
		java.lang.String contactPersonPhoneNumber) {
		_employer.setContactPersonPhoneNumber(contactPersonPhoneNumber);
	}

	/**
	* Sets the country of this employer.
	*
	* @param country the country of this employer
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_employer.setCountry(country);
	}

	/**
	* Sets the create date of this employer.
	*
	* @param createDate the create date of this employer
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_employer.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this employer.
	*
	* @param createdBy the created by of this employer
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_employer.setCreatedBy(createdBy);
	}

	/**
	* Sets the email address of this employer.
	*
	* @param emailAddress the email address of this employer
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_employer.setEmailAddress(emailAddress);
	}

	/**
	* Sets the employer ID of this employer.
	*
	* @param employerId the employer ID of this employer
	*/
	@Override
	public void setEmployerId(long employerId) {
		_employer.setEmployerId(employerId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_employer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_employer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_employer.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the first name of this employer.
	*
	* @param firstName the first name of this employer
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_employer.setFirstName(firstName);
	}

	/**
	* Sets the last name of this employer.
	*
	* @param lastName the last name of this employer
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_employer.setLastName(lastName);
	}

	/**
	* Sets the modified by of this employer.
	*
	* @param modifiedBy the modified by of this employer
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_employer.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this employer.
	*
	* @param modifiedDate the modified date of this employer
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_employer.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_employer.setNew(n);
	}

	/**
	* Sets the primary key of this employer.
	*
	* @param primaryKey the primary key of this employer
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_employer.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_employer.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the state of this employer.
	*
	* @param state the state of this employer
	*/
	@Override
	public void setState(java.lang.String state) {
		_employer.setState(state);
	}

	/**
	* Sets the website link of this employer.
	*
	* @param websiteLink the website link of this employer
	*/
	@Override
	public void setWebsiteLink(java.lang.String websiteLink) {
		_employer.setWebsiteLink(websiteLink);
	}

	/**
	* Sets the zipcode of this employer.
	*
	* @param zipcode the zipcode of this employer
	*/
	@Override
	public void setZipcode(java.lang.String zipcode) {
		_employer.setZipcode(zipcode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployerWrapper)) {
			return false;
		}

		EmployerWrapper employerWrapper = (EmployerWrapper)obj;

		if (Objects.equals(_employer, employerWrapper._employer)) {
			return true;
		}

		return false;
	}

	@Override
	public Employer getWrappedModel() {
		return _employer;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _employer.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _employer.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_employer.resetOriginalValues();
	}

	private final Employer _employer;
}