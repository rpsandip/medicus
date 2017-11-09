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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Campus service. Represents a row in the &quot;Medicus_Campus&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.medicus.common.service.model.impl.CampusModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.medicus.common.service.model.impl.CampusImpl}.
 * </p>
 *
 * @author sandip.patel
 * @see Campus
 * @see com.medicus.common.service.model.impl.CampusImpl
 * @see com.medicus.common.service.model.impl.CampusModelImpl
 * @generated
 */
@ProviderType
public interface CampusModel extends BaseModel<Campus> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a campus model instance should use the {@link Campus} interface instead.
	 */

	/**
	 * Returns the primary key of this campus.
	 *
	 * @return the primary key of this campus
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this campus.
	 *
	 * @param primaryKey the primary key of this campus
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the campus ID of this campus.
	 *
	 * @return the campus ID of this campus
	 */
	public long getCampusId();

	/**
	 * Sets the campus ID of this campus.
	 *
	 * @param campusId the campus ID of this campus
	 */
	public void setCampusId(long campusId);

	/**
	 * Returns the school ID of this campus.
	 *
	 * @return the school ID of this campus
	 */
	public long getSchoolId();

	/**
	 * Sets the school ID of this campus.
	 *
	 * @param schoolId the school ID of this campus
	 */
	public void setSchoolId(long schoolId);

	/**
	 * Returns the name of this campus.
	 *
	 * @return the name of this campus
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this campus.
	 *
	 * @param name the name of this campus
	 */
	public void setName(String name);

	/**
	 * Returns the address1 of this campus.
	 *
	 * @return the address1 of this campus
	 */
	@AutoEscape
	public String getAddress1();

	/**
	 * Sets the address1 of this campus.
	 *
	 * @param address1 the address1 of this campus
	 */
	public void setAddress1(String address1);

	/**
	 * Returns the address2 of this campus.
	 *
	 * @return the address2 of this campus
	 */
	@AutoEscape
	public String getAddress2();

	/**
	 * Sets the address2 of this campus.
	 *
	 * @param address2 the address2 of this campus
	 */
	public void setAddress2(String address2);

	/**
	 * Returns the city of this campus.
	 *
	 * @return the city of this campus
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this campus.
	 *
	 * @param city the city of this campus
	 */
	public void setCity(String city);

	/**
	 * Returns the state of this campus.
	 *
	 * @return the state of this campus
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this campus.
	 *
	 * @param state the state of this campus
	 */
	public void setState(String state);

	/**
	 * Returns the country of this campus.
	 *
	 * @return the country of this campus
	 */
	@AutoEscape
	public String getCountry();

	/**
	 * Sets the country of this campus.
	 *
	 * @param country the country of this campus
	 */
	public void setCountry(String country);

	/**
	 * Returns the zipcode of this campus.
	 *
	 * @return the zipcode of this campus
	 */
	@AutoEscape
	public String getZipcode();

	/**
	 * Sets the zipcode of this campus.
	 *
	 * @param zipcode the zipcode of this campus
	 */
	public void setZipcode(String zipcode);

	/**
	 * Returns the contact number of this campus.
	 *
	 * @return the contact number of this campus
	 */
	@AutoEscape
	public String getContactNumber();

	/**
	 * Sets the contact number of this campus.
	 *
	 * @param contactNumber the contact number of this campus
	 */
	public void setContactNumber(String contactNumber);

	/**
	 * Returns the website link of this campus.
	 *
	 * @return the website link of this campus
	 */
	@AutoEscape
	public String getWebsiteLink();

	/**
	 * Sets the website link of this campus.
	 *
	 * @param websiteLink the website link of this campus
	 */
	public void setWebsiteLink(String websiteLink);

	/**
	 * Returns the contact person name of this campus.
	 *
	 * @return the contact person name of this campus
	 */
	@AutoEscape
	public String getContactPersonName();

	/**
	 * Sets the contact person name of this campus.
	 *
	 * @param contactPersonName the contact person name of this campus
	 */
	public void setContactPersonName(String contactPersonName);

	/**
	 * Returns the contact person phone number of this campus.
	 *
	 * @return the contact person phone number of this campus
	 */
	@AutoEscape
	public String getContactPersonPhoneNumber();

	/**
	 * Sets the contact person phone number of this campus.
	 *
	 * @param contactPersonPhoneNumber the contact person phone number of this campus
	 */
	public void setContactPersonPhoneNumber(String contactPersonPhoneNumber);

	/**
	 * Returns the contact person email of this campus.
	 *
	 * @return the contact person email of this campus
	 */
	@AutoEscape
	public String getContactPersonEmail();

	/**
	 * Sets the contact person email of this campus.
	 *
	 * @param contactPersonEmail the contact person email of this campus
	 */
	public void setContactPersonEmail(String contactPersonEmail);

	/**
	 * Returns the status of this campus.
	 *
	 * @return the status of this campus
	 */
	public int getStatus();

	/**
	 * Sets the status of this campus.
	 *
	 * @param status the status of this campus
	 */
	public void setStatus(int status);

	/**
	 * Returns the create date of this campus.
	 *
	 * @return the create date of this campus
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this campus.
	 *
	 * @param createDate the create date of this campus
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the created by of this campus.
	 *
	 * @return the created by of this campus
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this campus.
	 *
	 * @param createdBy the created by of this campus
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified date of this campus.
	 *
	 * @return the modified date of this campus
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this campus.
	 *
	 * @param modifiedDate the modified date of this campus
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified by of this campus.
	 *
	 * @return the modified by of this campus
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this campus.
	 *
	 * @param modifiedBy the modified by of this campus
	 */
	public void setModifiedBy(long modifiedBy);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Campus campus);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Campus> toCacheModel();

	@Override
	public Campus toEscapedModel();

	@Override
	public Campus toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}