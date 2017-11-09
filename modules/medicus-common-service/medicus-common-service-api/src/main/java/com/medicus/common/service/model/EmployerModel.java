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
 * The base model interface for the Employer service. Represents a row in the &quot;Medicus_Employer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.medicus.common.service.model.impl.EmployerModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.medicus.common.service.model.impl.EmployerImpl}.
 * </p>
 *
 * @author sandip.patel
 * @see Employer
 * @see com.medicus.common.service.model.impl.EmployerImpl
 * @see com.medicus.common.service.model.impl.EmployerModelImpl
 * @generated
 */
@ProviderType
public interface EmployerModel extends BaseModel<Employer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a employer model instance should use the {@link Employer} interface instead.
	 */

	/**
	 * Returns the primary key of this employer.
	 *
	 * @return the primary key of this employer
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this employer.
	 *
	 * @param primaryKey the primary key of this employer
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the employer ID of this employer.
	 *
	 * @return the employer ID of this employer
	 */
	public long getEmployerId();

	/**
	 * Sets the employer ID of this employer.
	 *
	 * @param employerId the employer ID of this employer
	 */
	public void setEmployerId(long employerId);

	/**
	 * Returns the first name of this employer.
	 *
	 * @return the first name of this employer
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this employer.
	 *
	 * @param firstName the first name of this employer
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the last name of this employer.
	 *
	 * @return the last name of this employer
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this employer.
	 *
	 * @param lastName the last name of this employer
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the email address of this employer.
	 *
	 * @return the email address of this employer
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this employer.
	 *
	 * @param emailAddress the email address of this employer
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Returns the address1 of this employer.
	 *
	 * @return the address1 of this employer
	 */
	@AutoEscape
	public String getAddress1();

	/**
	 * Sets the address1 of this employer.
	 *
	 * @param address1 the address1 of this employer
	 */
	public void setAddress1(String address1);

	/**
	 * Returns the address2 of this employer.
	 *
	 * @return the address2 of this employer
	 */
	@AutoEscape
	public String getAddress2();

	/**
	 * Sets the address2 of this employer.
	 *
	 * @param address2 the address2 of this employer
	 */
	public void setAddress2(String address2);

	/**
	 * Returns the city of this employer.
	 *
	 * @return the city of this employer
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this employer.
	 *
	 * @param city the city of this employer
	 */
	public void setCity(String city);

	/**
	 * Returns the zipcode of this employer.
	 *
	 * @return the zipcode of this employer
	 */
	@AutoEscape
	public String getZipcode();

	/**
	 * Sets the zipcode of this employer.
	 *
	 * @param zipcode the zipcode of this employer
	 */
	public void setZipcode(String zipcode);

	/**
	 * Returns the state of this employer.
	 *
	 * @return the state of this employer
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this employer.
	 *
	 * @param state the state of this employer
	 */
	public void setState(String state);

	/**
	 * Returns the country of this employer.
	 *
	 * @return the country of this employer
	 */
	@AutoEscape
	public String getCountry();

	/**
	 * Sets the country of this employer.
	 *
	 * @param country the country of this employer
	 */
	public void setCountry(String country);

	/**
	 * Returns the contact person name of this employer.
	 *
	 * @return the contact person name of this employer
	 */
	@AutoEscape
	public String getContactPersonName();

	/**
	 * Sets the contact person name of this employer.
	 *
	 * @param contactPersonName the contact person name of this employer
	 */
	public void setContactPersonName(String contactPersonName);

	/**
	 * Returns the contact person email of this employer.
	 *
	 * @return the contact person email of this employer
	 */
	@AutoEscape
	public String getContactPersonEmail();

	/**
	 * Sets the contact person email of this employer.
	 *
	 * @param contactPersonEmail the contact person email of this employer
	 */
	public void setContactPersonEmail(String contactPersonEmail);

	/**
	 * Returns the contact person phone number of this employer.
	 *
	 * @return the contact person phone number of this employer
	 */
	@AutoEscape
	public String getContactPersonPhoneNumber();

	/**
	 * Sets the contact person phone number of this employer.
	 *
	 * @param contactPersonPhoneNumber the contact person phone number of this employer
	 */
	public void setContactPersonPhoneNumber(String contactPersonPhoneNumber);

	/**
	 * Returns the website link of this employer.
	 *
	 * @return the website link of this employer
	 */
	@AutoEscape
	public String getWebsiteLink();

	/**
	 * Sets the website link of this employer.
	 *
	 * @param websiteLink the website link of this employer
	 */
	public void setWebsiteLink(String websiteLink);

	/**
	 * Returns the create date of this employer.
	 *
	 * @return the create date of this employer
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this employer.
	 *
	 * @param createDate the create date of this employer
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the created by of this employer.
	 *
	 * @return the created by of this employer
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this employer.
	 *
	 * @param createdBy the created by of this employer
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified date of this employer.
	 *
	 * @return the modified date of this employer
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this employer.
	 *
	 * @param modifiedDate the modified date of this employer
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified by of this employer.
	 *
	 * @return the modified by of this employer
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this employer.
	 *
	 * @param modifiedBy the modified by of this employer
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
	public int compareTo(Employer employer);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Employer> toCacheModel();

	@Override
	public Employer toEscapedModel();

	@Override
	public Employer toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}