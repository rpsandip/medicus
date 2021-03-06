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
 * The base model interface for the Partner service. Represents a row in the &quot;Medicus_Partner&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.medicus.common.service.model.impl.PartnerModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.medicus.common.service.model.impl.PartnerImpl}.
 * </p>
 *
 * @author sandip.patel
 * @see Partner
 * @see com.medicus.common.service.model.impl.PartnerImpl
 * @see com.medicus.common.service.model.impl.PartnerModelImpl
 * @generated
 */
@ProviderType
public interface PartnerModel extends BaseModel<Partner> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a partner model instance should use the {@link Partner} interface instead.
	 */

	/**
	 * Returns the primary key of this partner.
	 *
	 * @return the primary key of this partner
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this partner.
	 *
	 * @param primaryKey the primary key of this partner
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the partner ID of this partner.
	 *
	 * @return the partner ID of this partner
	 */
	public long getPartnerId();

	/**
	 * Sets the partner ID of this partner.
	 *
	 * @param partnerId the partner ID of this partner
	 */
	public void setPartnerId(long partnerId);

	/**
	 * Returns the user ID of this partner.
	 *
	 * @return the user ID of this partner
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this partner.
	 *
	 * @param userId the user ID of this partner
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this partner.
	 *
	 * @return the user uuid of this partner
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this partner.
	 *
	 * @param userUuid the user uuid of this partner
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the partner org ID of this partner.
	 *
	 * @return the partner org ID of this partner
	 */
	public long getPartnerOrgId();

	/**
	 * Sets the partner org ID of this partner.
	 *
	 * @param partnerOrgId the partner org ID of this partner
	 */
	public void setPartnerOrgId(long partnerOrgId);

	/**
	 * Returns the address1 of this partner.
	 *
	 * @return the address1 of this partner
	 */
	@AutoEscape
	public String getAddress1();

	/**
	 * Sets the address1 of this partner.
	 *
	 * @param address1 the address1 of this partner
	 */
	public void setAddress1(String address1);

	/**
	 * Returns the city of this partner.
	 *
	 * @return the city of this partner
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this partner.
	 *
	 * @param city the city of this partner
	 */
	public void setCity(String city);

	/**
	 * Returns the zipcode of this partner.
	 *
	 * @return the zipcode of this partner
	 */
	@AutoEscape
	public String getZipcode();

	/**
	 * Sets the zipcode of this partner.
	 *
	 * @param zipcode the zipcode of this partner
	 */
	public void setZipcode(String zipcode);

	/**
	 * Returns the state of this partner.
	 *
	 * @return the state of this partner
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this partner.
	 *
	 * @param state the state of this partner
	 */
	public void setState(String state);

	/**
	 * Returns the country of this partner.
	 *
	 * @return the country of this partner
	 */
	@AutoEscape
	public String getCountry();

	/**
	 * Sets the country of this partner.
	 *
	 * @param country the country of this partner
	 */
	public void setCountry(String country);

	/**
	 * Returns the contact person name of this partner.
	 *
	 * @return the contact person name of this partner
	 */
	@AutoEscape
	public String getContactPersonName();

	/**
	 * Sets the contact person name of this partner.
	 *
	 * @param contactPersonName the contact person name of this partner
	 */
	public void setContactPersonName(String contactPersonName);

	/**
	 * Returns the contact person email of this partner.
	 *
	 * @return the contact person email of this partner
	 */
	@AutoEscape
	public String getContactPersonEmail();

	/**
	 * Sets the contact person email of this partner.
	 *
	 * @param contactPersonEmail the contact person email of this partner
	 */
	public void setContactPersonEmail(String contactPersonEmail);

	/**
	 * Returns the contact person phone number of this partner.
	 *
	 * @return the contact person phone number of this partner
	 */
	@AutoEscape
	public String getContactPersonPhoneNumber();

	/**
	 * Sets the contact person phone number of this partner.
	 *
	 * @param contactPersonPhoneNumber the contact person phone number of this partner
	 */
	public void setContactPersonPhoneNumber(String contactPersonPhoneNumber);

	/**
	 * Returns the website link of this partner.
	 *
	 * @return the website link of this partner
	 */
	@AutoEscape
	public String getWebsiteLink();

	/**
	 * Sets the website link of this partner.
	 *
	 * @param websiteLink the website link of this partner
	 */
	public void setWebsiteLink(String websiteLink);

	/**
	 * Returns the create date of this partner.
	 *
	 * @return the create date of this partner
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this partner.
	 *
	 * @param createDate the create date of this partner
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the created by of this partner.
	 *
	 * @return the created by of this partner
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this partner.
	 *
	 * @param createdBy the created by of this partner
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified date of this partner.
	 *
	 * @return the modified date of this partner
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this partner.
	 *
	 * @param modifiedDate the modified date of this partner
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified by of this partner.
	 *
	 * @return the modified by of this partner
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this partner.
	 *
	 * @param modifiedBy the modified by of this partner
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
	public int compareTo(Partner partner);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Partner> toCacheModel();

	@Override
	public Partner toEscapedModel();

	@Override
	public Partner toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}