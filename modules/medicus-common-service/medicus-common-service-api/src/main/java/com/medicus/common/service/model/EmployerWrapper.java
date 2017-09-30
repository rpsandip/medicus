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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Employer}.
 * </p>
 *
 * @author Brian Wing Shun Chan
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
		attributes.put("userId", getUserId());
		attributes.put("employerOrgId", getEmployerOrgId());
		attributes.put("address1", getAddress1());
		attributes.put("address2", getAddress2());
		attributes.put("city", getCity());
		attributes.put("zipcode", getZipcode());
		attributes.put("state", getState());
		attributes.put("country", getCountry());
		attributes.put("contactPersonName", getContactPersonName());
		attributes.put("contactPersonEmail", getContactPersonEmail());
		attributes.put("contactPersonPhoneNumber", getContactPersonPhoneNumber());
		attributes.put("websiteLink", getWebsiteLink());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employerId = (Long)attributes.get("employerId");

		if (employerId != null) {
			setEmployerId(employerId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long employerOrgId = (Long)attributes.get("employerOrgId");

		if (employerOrgId != null) {
			setEmployerOrgId(employerOrgId);
		}

		String address1 = (String)attributes.get("address1");

		if (address1 != null) {
			setAddress1(address1);
		}

		String address2 = (String)attributes.get("address2");

		if (address2 != null) {
			setAddress2(address2);
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
	* Returns the address2 of this employer.
	*
	* @return the address2 of this employer
	*/
	@Override
	public java.lang.String getAddress2() {
		return _employer.getAddress2();
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
	* Returns the state of this employer.
	*
	* @return the state of this employer
	*/
	@Override
	public java.lang.String getState() {
		return _employer.getState();
	}

	/**
	* Returns the user uuid of this employer.
	*
	* @return the user uuid of this employer
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _employer.getUserUuid();
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
	* Returns the employer ID of this employer.
	*
	* @return the employer ID of this employer
	*/
	@Override
	public long getEmployerId() {
		return _employer.getEmployerId();
	}

	/**
	* Returns the employer org ID of this employer.
	*
	* @return the employer org ID of this employer
	*/
	@Override
	public long getEmployerOrgId() {
		return _employer.getEmployerOrgId();
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

	/**
	* Returns the user ID of this employer.
	*
	* @return the user ID of this employer
	*/
	@Override
	public long getUserId() {
		return _employer.getUserId();
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

	/**
	* Sets the address2 of this employer.
	*
	* @param address2 the address2 of this employer
	*/
	@Override
	public void setAddress2(java.lang.String address2) {
		_employer.setAddress2(address2);
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
	* Sets the employer ID of this employer.
	*
	* @param employerId the employer ID of this employer
	*/
	@Override
	public void setEmployerId(long employerId) {
		_employer.setEmployerId(employerId);
	}

	/**
	* Sets the employer org ID of this employer.
	*
	* @param employerOrgId the employer org ID of this employer
	*/
	@Override
	public void setEmployerOrgId(long employerOrgId) {
		_employer.setEmployerOrgId(employerOrgId);
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
	* Sets the user ID of this employer.
	*
	* @param userId the user ID of this employer
	*/
	@Override
	public void setUserId(long userId) {
		_employer.setUserId(userId);
	}

	/**
	* Sets the user uuid of this employer.
	*
	* @param userUuid the user uuid of this employer
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_employer.setUserUuid(userUuid);
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