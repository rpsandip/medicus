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
 * This class is a wrapper for {@link Campus}.
 * </p>
 *
 * @author sandip.patel
 * @see Campus
 * @generated
 */
@ProviderType
public class CampusWrapper implements Campus, ModelWrapper<Campus> {
	public CampusWrapper(Campus campus) {
		_campus = campus;
	}

	@Override
	public Class<?> getModelClass() {
		return Campus.class;
	}

	@Override
	public String getModelClassName() {
		return Campus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("campusId", getCampusId());
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
		Long campusId = (Long)attributes.get("campusId");

		if (campusId != null) {
			setCampusId(campusId);
		}

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
	public Campus toEscapedModel() {
		return new CampusWrapper(_campus.toEscapedModel());
	}

	@Override
	public Campus toUnescapedModel() {
		return new CampusWrapper(_campus.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _campus.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _campus.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _campus.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _campus.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Campus> toCacheModel() {
		return _campus.toCacheModel();
	}

	@Override
	public int compareTo(Campus campus) {
		return _campus.compareTo(campus);
	}

	/**
	* Returns the status of this campus.
	*
	* @return the status of this campus
	*/
	@Override
	public int getStatus() {
		return _campus.getStatus();
	}

	@Override
	public int hashCode() {
		return _campus.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _campus.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new CampusWrapper((Campus)_campus.clone());
	}

	/**
	* Returns the address1 of this campus.
	*
	* @return the address1 of this campus
	*/
	@Override
	public java.lang.String getAddress1() {
		return _campus.getAddress1();
	}

	/**
	* Returns the address2 of this campus.
	*
	* @return the address2 of this campus
	*/
	@Override
	public java.lang.String getAddress2() {
		return _campus.getAddress2();
	}

	/**
	* Returns the city of this campus.
	*
	* @return the city of this campus
	*/
	@Override
	public java.lang.String getCity() {
		return _campus.getCity();
	}

	/**
	* Returns the contact number of this campus.
	*
	* @return the contact number of this campus
	*/
	@Override
	public java.lang.String getContactNumber() {
		return _campus.getContactNumber();
	}

	/**
	* Returns the contact person email of this campus.
	*
	* @return the contact person email of this campus
	*/
	@Override
	public java.lang.String getContactPersonEmail() {
		return _campus.getContactPersonEmail();
	}

	/**
	* Returns the contact person name of this campus.
	*
	* @return the contact person name of this campus
	*/
	@Override
	public java.lang.String getContactPersonName() {
		return _campus.getContactPersonName();
	}

	/**
	* Returns the contact person phone number of this campus.
	*
	* @return the contact person phone number of this campus
	*/
	@Override
	public java.lang.String getContactPersonPhoneNumber() {
		return _campus.getContactPersonPhoneNumber();
	}

	/**
	* Returns the country of this campus.
	*
	* @return the country of this campus
	*/
	@Override
	public java.lang.String getCountry() {
		return _campus.getCountry();
	}

	/**
	* Returns the name of this campus.
	*
	* @return the name of this campus
	*/
	@Override
	public java.lang.String getName() {
		return _campus.getName();
	}

	/**
	* Returns the state of this campus.
	*
	* @return the state of this campus
	*/
	@Override
	public java.lang.String getState() {
		return _campus.getState();
	}

	/**
	* Returns the website link of this campus.
	*
	* @return the website link of this campus
	*/
	@Override
	public java.lang.String getWebsiteLink() {
		return _campus.getWebsiteLink();
	}

	/**
	* Returns the zipcode of this campus.
	*
	* @return the zipcode of this campus
	*/
	@Override
	public java.lang.String getZipcode() {
		return _campus.getZipcode();
	}

	@Override
	public java.lang.String toString() {
		return _campus.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _campus.toXmlString();
	}

	/**
	* Returns the create date of this campus.
	*
	* @return the create date of this campus
	*/
	@Override
	public Date getCreateDate() {
		return _campus.getCreateDate();
	}

	/**
	* Returns the modified date of this campus.
	*
	* @return the modified date of this campus
	*/
	@Override
	public Date getModifiedDate() {
		return _campus.getModifiedDate();
	}

	/**
	* Returns the campus ID of this campus.
	*
	* @return the campus ID of this campus
	*/
	@Override
	public long getCampusId() {
		return _campus.getCampusId();
	}

	/**
	* Returns the created by of this campus.
	*
	* @return the created by of this campus
	*/
	@Override
	public long getCreatedBy() {
		return _campus.getCreatedBy();
	}

	/**
	* Returns the modified by of this campus.
	*
	* @return the modified by of this campus
	*/
	@Override
	public long getModifiedBy() {
		return _campus.getModifiedBy();
	}

	/**
	* Returns the primary key of this campus.
	*
	* @return the primary key of this campus
	*/
	@Override
	public long getPrimaryKey() {
		return _campus.getPrimaryKey();
	}

	/**
	* Returns the school ID of this campus.
	*
	* @return the school ID of this campus
	*/
	@Override
	public long getSchoolId() {
		return _campus.getSchoolId();
	}

	@Override
	public void persist() {
		_campus.persist();
	}

	/**
	* Sets the address1 of this campus.
	*
	* @param address1 the address1 of this campus
	*/
	@Override
	public void setAddress1(java.lang.String address1) {
		_campus.setAddress1(address1);
	}

	/**
	* Sets the address2 of this campus.
	*
	* @param address2 the address2 of this campus
	*/
	@Override
	public void setAddress2(java.lang.String address2) {
		_campus.setAddress2(address2);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_campus.setCachedModel(cachedModel);
	}

	/**
	* Sets the campus ID of this campus.
	*
	* @param campusId the campus ID of this campus
	*/
	@Override
	public void setCampusId(long campusId) {
		_campus.setCampusId(campusId);
	}

	/**
	* Sets the city of this campus.
	*
	* @param city the city of this campus
	*/
	@Override
	public void setCity(java.lang.String city) {
		_campus.setCity(city);
	}

	/**
	* Sets the contact number of this campus.
	*
	* @param contactNumber the contact number of this campus
	*/
	@Override
	public void setContactNumber(java.lang.String contactNumber) {
		_campus.setContactNumber(contactNumber);
	}

	/**
	* Sets the contact person email of this campus.
	*
	* @param contactPersonEmail the contact person email of this campus
	*/
	@Override
	public void setContactPersonEmail(java.lang.String contactPersonEmail) {
		_campus.setContactPersonEmail(contactPersonEmail);
	}

	/**
	* Sets the contact person name of this campus.
	*
	* @param contactPersonName the contact person name of this campus
	*/
	@Override
	public void setContactPersonName(java.lang.String contactPersonName) {
		_campus.setContactPersonName(contactPersonName);
	}

	/**
	* Sets the contact person phone number of this campus.
	*
	* @param contactPersonPhoneNumber the contact person phone number of this campus
	*/
	@Override
	public void setContactPersonPhoneNumber(
		java.lang.String contactPersonPhoneNumber) {
		_campus.setContactPersonPhoneNumber(contactPersonPhoneNumber);
	}

	/**
	* Sets the country of this campus.
	*
	* @param country the country of this campus
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_campus.setCountry(country);
	}

	/**
	* Sets the create date of this campus.
	*
	* @param createDate the create date of this campus
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_campus.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this campus.
	*
	* @param createdBy the created by of this campus
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_campus.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_campus.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_campus.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_campus.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this campus.
	*
	* @param modifiedBy the modified by of this campus
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_campus.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this campus.
	*
	* @param modifiedDate the modified date of this campus
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_campus.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the name of this campus.
	*
	* @param name the name of this campus
	*/
	@Override
	public void setName(java.lang.String name) {
		_campus.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_campus.setNew(n);
	}

	/**
	* Sets the primary key of this campus.
	*
	* @param primaryKey the primary key of this campus
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_campus.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_campus.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the school ID of this campus.
	*
	* @param schoolId the school ID of this campus
	*/
	@Override
	public void setSchoolId(long schoolId) {
		_campus.setSchoolId(schoolId);
	}

	/**
	* Sets the state of this campus.
	*
	* @param state the state of this campus
	*/
	@Override
	public void setState(java.lang.String state) {
		_campus.setState(state);
	}

	/**
	* Sets the status of this campus.
	*
	* @param status the status of this campus
	*/
	@Override
	public void setStatus(int status) {
		_campus.setStatus(status);
	}

	/**
	* Sets the website link of this campus.
	*
	* @param websiteLink the website link of this campus
	*/
	@Override
	public void setWebsiteLink(java.lang.String websiteLink) {
		_campus.setWebsiteLink(websiteLink);
	}

	/**
	* Sets the zipcode of this campus.
	*
	* @param zipcode the zipcode of this campus
	*/
	@Override
	public void setZipcode(java.lang.String zipcode) {
		_campus.setZipcode(zipcode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CampusWrapper)) {
			return false;
		}

		CampusWrapper campusWrapper = (CampusWrapper)obj;

		if (Objects.equals(_campus, campusWrapper._campus)) {
			return true;
		}

		return false;
	}

	@Override
	public Campus getWrappedModel() {
		return _campus;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _campus.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _campus.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_campus.resetOriginalValues();
	}

	private final Campus _campus;
}