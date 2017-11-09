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
 * This class is a wrapper for {@link School}.
 * </p>
 *
 * @author sandip.patel
 * @see School
 * @generated
 */
@ProviderType
public class SchoolWrapper implements School, ModelWrapper<School> {
	public SchoolWrapper(School school) {
		_school = school;
	}

	@Override
	public Class<?> getModelClass() {
		return School.class;
	}

	@Override
	public String getModelClassName() {
		return School.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("schoolId", getSchoolId());
		attributes.put("name", getName());
		attributes.put("address1", getAddress1());
		attributes.put("address2", getAddress2());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("country", getCountry());
		attributes.put("zipcode", getZipcode());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("websiteLink", getWebsiteLink());
		attributes.put("contactPersonName", getContactPersonName());
		attributes.put("contactPersonPhoneNumber", getContactPersonPhoneNumber());
		attributes.put("contactPersonEmail", getContactPersonEmail());
		attributes.put("status", getStatus());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long schoolId = (Long)attributes.get("schoolId");

		if (schoolId != null) {
			setSchoolId(schoolId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
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

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String zipcode = (String)attributes.get("zipcode");

		if (zipcode != null) {
			setZipcode(zipcode);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		String websiteLink = (String)attributes.get("websiteLink");

		if (websiteLink != null) {
			setWebsiteLink(websiteLink);
		}

		String contactPersonName = (String)attributes.get("contactPersonName");

		if (contactPersonName != null) {
			setContactPersonName(contactPersonName);
		}

		String contactPersonPhoneNumber = (String)attributes.get(
				"contactPersonPhoneNumber");

		if (contactPersonPhoneNumber != null) {
			setContactPersonPhoneNumber(contactPersonPhoneNumber);
		}

		String contactPersonEmail = (String)attributes.get("contactPersonEmail");

		if (contactPersonEmail != null) {
			setContactPersonEmail(contactPersonEmail);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
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
	public School toEscapedModel() {
		return new SchoolWrapper(_school.toEscapedModel());
	}

	@Override
	public School toUnescapedModel() {
		return new SchoolWrapper(_school.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _school.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _school.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _school.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _school.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<School> toCacheModel() {
		return _school.toCacheModel();
	}

	@Override
	public int compareTo(School school) {
		return _school.compareTo(school);
	}

	/**
	* Returns the status of this school.
	*
	* @return the status of this school
	*/
	@Override
	public int getStatus() {
		return _school.getStatus();
	}

	@Override
	public int hashCode() {
		return _school.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _school.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new SchoolWrapper((School)_school.clone());
	}

	/**
	* Returns the address1 of this school.
	*
	* @return the address1 of this school
	*/
	@Override
	public java.lang.String getAddress1() {
		return _school.getAddress1();
	}

	/**
	* Returns the address2 of this school.
	*
	* @return the address2 of this school
	*/
	@Override
	public java.lang.String getAddress2() {
		return _school.getAddress2();
	}

	/**
	* Returns the city of this school.
	*
	* @return the city of this school
	*/
	@Override
	public java.lang.String getCity() {
		return _school.getCity();
	}

	/**
	* Returns the contact number of this school.
	*
	* @return the contact number of this school
	*/
	@Override
	public java.lang.String getContactNumber() {
		return _school.getContactNumber();
	}

	/**
	* Returns the contact person email of this school.
	*
	* @return the contact person email of this school
	*/
	@Override
	public java.lang.String getContactPersonEmail() {
		return _school.getContactPersonEmail();
	}

	/**
	* Returns the contact person name of this school.
	*
	* @return the contact person name of this school
	*/
	@Override
	public java.lang.String getContactPersonName() {
		return _school.getContactPersonName();
	}

	/**
	* Returns the contact person phone number of this school.
	*
	* @return the contact person phone number of this school
	*/
	@Override
	public java.lang.String getContactPersonPhoneNumber() {
		return _school.getContactPersonPhoneNumber();
	}

	/**
	* Returns the country of this school.
	*
	* @return the country of this school
	*/
	@Override
	public java.lang.String getCountry() {
		return _school.getCountry();
	}

	/**
	* Returns the name of this school.
	*
	* @return the name of this school
	*/
	@Override
	public java.lang.String getName() {
		return _school.getName();
	}

	/**
	* Returns the state of this school.
	*
	* @return the state of this school
	*/
	@Override
	public java.lang.String getState() {
		return _school.getState();
	}

	/**
	* Returns the website link of this school.
	*
	* @return the website link of this school
	*/
	@Override
	public java.lang.String getWebsiteLink() {
		return _school.getWebsiteLink();
	}

	/**
	* Returns the zipcode of this school.
	*
	* @return the zipcode of this school
	*/
	@Override
	public java.lang.String getZipcode() {
		return _school.getZipcode();
	}

	@Override
	public java.lang.String toString() {
		return _school.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _school.toXmlString();
	}

	/**
	* Returns the create date of this school.
	*
	* @return the create date of this school
	*/
	@Override
	public Date getCreateDate() {
		return _school.getCreateDate();
	}

	/**
	* Returns the modified date of this school.
	*
	* @return the modified date of this school
	*/
	@Override
	public Date getModifiedDate() {
		return _school.getModifiedDate();
	}

	/**
	* Returns the created by of this school.
	*
	* @return the created by of this school
	*/
	@Override
	public long getCreatedBy() {
		return _school.getCreatedBy();
	}

	/**
	* Returns the modified by of this school.
	*
	* @return the modified by of this school
	*/
	@Override
	public long getModifiedBy() {
		return _school.getModifiedBy();
	}

	/**
	* Returns the primary key of this school.
	*
	* @return the primary key of this school
	*/
	@Override
	public long getPrimaryKey() {
		return _school.getPrimaryKey();
	}

	/**
	* Returns the school ID of this school.
	*
	* @return the school ID of this school
	*/
	@Override
	public long getSchoolId() {
		return _school.getSchoolId();
	}

	@Override
	public void persist() {
		_school.persist();
	}

	/**
	* Sets the address1 of this school.
	*
	* @param address1 the address1 of this school
	*/
	@Override
	public void setAddress1(java.lang.String address1) {
		_school.setAddress1(address1);
	}

	/**
	* Sets the address2 of this school.
	*
	* @param address2 the address2 of this school
	*/
	@Override
	public void setAddress2(java.lang.String address2) {
		_school.setAddress2(address2);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_school.setCachedModel(cachedModel);
	}

	/**
	* Sets the city of this school.
	*
	* @param city the city of this school
	*/
	@Override
	public void setCity(java.lang.String city) {
		_school.setCity(city);
	}

	/**
	* Sets the contact number of this school.
	*
	* @param contactNumber the contact number of this school
	*/
	@Override
	public void setContactNumber(java.lang.String contactNumber) {
		_school.setContactNumber(contactNumber);
	}

	/**
	* Sets the contact person email of this school.
	*
	* @param contactPersonEmail the contact person email of this school
	*/
	@Override
	public void setContactPersonEmail(java.lang.String contactPersonEmail) {
		_school.setContactPersonEmail(contactPersonEmail);
	}

	/**
	* Sets the contact person name of this school.
	*
	* @param contactPersonName the contact person name of this school
	*/
	@Override
	public void setContactPersonName(java.lang.String contactPersonName) {
		_school.setContactPersonName(contactPersonName);
	}

	/**
	* Sets the contact person phone number of this school.
	*
	* @param contactPersonPhoneNumber the contact person phone number of this school
	*/
	@Override
	public void setContactPersonPhoneNumber(
		java.lang.String contactPersonPhoneNumber) {
		_school.setContactPersonPhoneNumber(contactPersonPhoneNumber);
	}

	/**
	* Sets the country of this school.
	*
	* @param country the country of this school
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_school.setCountry(country);
	}

	/**
	* Sets the create date of this school.
	*
	* @param createDate the create date of this school
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_school.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this school.
	*
	* @param createdBy the created by of this school
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_school.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_school.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_school.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_school.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this school.
	*
	* @param modifiedBy the modified by of this school
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_school.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this school.
	*
	* @param modifiedDate the modified date of this school
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_school.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this school.
	*
	* @param name the name of this school
	*/
	@Override
	public void setName(java.lang.String name) {
		_school.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_school.setNew(n);
	}

	/**
	* Sets the primary key of this school.
	*
	* @param primaryKey the primary key of this school
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_school.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_school.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the school ID of this school.
	*
	* @param schoolId the school ID of this school
	*/
	@Override
	public void setSchoolId(long schoolId) {
		_school.setSchoolId(schoolId);
	}

	/**
	* Sets the state of this school.
	*
	* @param state the state of this school
	*/
	@Override
	public void setState(java.lang.String state) {
		_school.setState(state);
	}

	/**
	* Sets the status of this school.
	*
	* @param status the status of this school
	*/
	@Override
	public void setStatus(int status) {
		_school.setStatus(status);
	}

	/**
	* Sets the website link of this school.
	*
	* @param websiteLink the website link of this school
	*/
	@Override
	public void setWebsiteLink(java.lang.String websiteLink) {
		_school.setWebsiteLink(websiteLink);
	}

	/**
	* Sets the zipcode of this school.
	*
	* @param zipcode the zipcode of this school
	*/
	@Override
	public void setZipcode(java.lang.String zipcode) {
		_school.setZipcode(zipcode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SchoolWrapper)) {
			return false;
		}

		SchoolWrapper schoolWrapper = (SchoolWrapper)obj;

		if (Objects.equals(_school, schoolWrapper._school)) {
			return true;
		}

		return false;
	}

	@Override
	public School getWrappedModel() {
		return _school;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _school.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _school.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_school.resetOriginalValues();
	}

	private final School _school;
}