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
 * This class is a wrapper for {@link Partner}.
 * </p>
 *
 * @author sandip.patel
 * @see Partner
 * @generated
 */
@ProviderType
public class PartnerWrapper implements Partner, ModelWrapper<Partner> {
	public PartnerWrapper(Partner partner) {
		_partner = partner;
	}

	@Override
	public Class<?> getModelClass() {
		return Partner.class;
	}

	@Override
	public String getModelClassName() {
		return Partner.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("partnerId", getPartnerId());
		attributes.put("userId", getUserId());
		attributes.put("partnerOrgId", getPartnerOrgId());
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
		Long partnerId = (Long)attributes.get("partnerId");

		if (partnerId != null) {
			setPartnerId(partnerId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long partnerOrgId = (Long)attributes.get("partnerOrgId");

		if (partnerOrgId != null) {
			setPartnerOrgId(partnerOrgId);
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
	public Partner toEscapedModel() {
		return new PartnerWrapper(_partner.toEscapedModel());
	}

	@Override
	public Partner toUnescapedModel() {
		return new PartnerWrapper(_partner.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _partner.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _partner.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _partner.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _partner.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Partner> toCacheModel() {
		return _partner.toCacheModel();
	}

	@Override
	public int compareTo(Partner partner) {
		return _partner.compareTo(partner);
	}

	@Override
	public int hashCode() {
		return _partner.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _partner.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new PartnerWrapper((Partner)_partner.clone());
	}

	/**
	* Returns the address1 of this partner.
	*
	* @return the address1 of this partner
	*/
	@Override
	public java.lang.String getAddress1() {
		return _partner.getAddress1();
	}

	/**
	* Returns the city of this partner.
	*
	* @return the city of this partner
	*/
	@Override
	public java.lang.String getCity() {
		return _partner.getCity();
	}

	/**
	* Returns the contact person email of this partner.
	*
	* @return the contact person email of this partner
	*/
	@Override
	public java.lang.String getContactPersonEmail() {
		return _partner.getContactPersonEmail();
	}

	/**
	* Returns the contact person name of this partner.
	*
	* @return the contact person name of this partner
	*/
	@Override
	public java.lang.String getContactPersonName() {
		return _partner.getContactPersonName();
	}

	/**
	* Returns the contact person phone number of this partner.
	*
	* @return the contact person phone number of this partner
	*/
	@Override
	public java.lang.String getContactPersonPhoneNumber() {
		return _partner.getContactPersonPhoneNumber();
	}

	/**
	* Returns the country of this partner.
	*
	* @return the country of this partner
	*/
	@Override
	public java.lang.String getCountry() {
		return _partner.getCountry();
	}

	/**
	* Returns the state of this partner.
	*
	* @return the state of this partner
	*/
	@Override
	public java.lang.String getState() {
		return _partner.getState();
	}

	/**
	* Returns the user uuid of this partner.
	*
	* @return the user uuid of this partner
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _partner.getUserUuid();
	}

	/**
	* Returns the website link of this partner.
	*
	* @return the website link of this partner
	*/
	@Override
	public java.lang.String getWebsiteLink() {
		return _partner.getWebsiteLink();
	}

	/**
	* Returns the zipcode of this partner.
	*
	* @return the zipcode of this partner
	*/
	@Override
	public java.lang.String getZipcode() {
		return _partner.getZipcode();
	}

	@Override
	public java.lang.String toString() {
		return _partner.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _partner.toXmlString();
	}

	/**
	* Returns the create date of this partner.
	*
	* @return the create date of this partner
	*/
	@Override
	public Date getCreateDate() {
		return _partner.getCreateDate();
	}

	/**
	* Returns the modified date of this partner.
	*
	* @return the modified date of this partner
	*/
	@Override
	public Date getModifiedDate() {
		return _partner.getModifiedDate();
	}

	/**
	* Returns the created by of this partner.
	*
	* @return the created by of this partner
	*/
	@Override
	public long getCreatedBy() {
		return _partner.getCreatedBy();
	}

	/**
	* Returns the modified by of this partner.
	*
	* @return the modified by of this partner
	*/
	@Override
	public long getModifiedBy() {
		return _partner.getModifiedBy();
	}

	/**
	* Returns the partner ID of this partner.
	*
	* @return the partner ID of this partner
	*/
	@Override
	public long getPartnerId() {
		return _partner.getPartnerId();
	}

	/**
	* Returns the partner org ID of this partner.
	*
	* @return the partner org ID of this partner
	*/
	@Override
	public long getPartnerOrgId() {
		return _partner.getPartnerOrgId();
	}

	/**
	* Returns the primary key of this partner.
	*
	* @return the primary key of this partner
	*/
	@Override
	public long getPrimaryKey() {
		return _partner.getPrimaryKey();
	}

	/**
	* Returns the user ID of this partner.
	*
	* @return the user ID of this partner
	*/
	@Override
	public long getUserId() {
		return _partner.getUserId();
	}

	@Override
	public void persist() {
		_partner.persist();
	}

	/**
	* Sets the address1 of this partner.
	*
	* @param address1 the address1 of this partner
	*/
	@Override
	public void setAddress1(java.lang.String address1) {
		_partner.setAddress1(address1);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_partner.setCachedModel(cachedModel);
	}

	/**
	* Sets the city of this partner.
	*
	* @param city the city of this partner
	*/
	@Override
	public void setCity(java.lang.String city) {
		_partner.setCity(city);
	}

	/**
	* Sets the contact person email of this partner.
	*
	* @param contactPersonEmail the contact person email of this partner
	*/
	@Override
	public void setContactPersonEmail(java.lang.String contactPersonEmail) {
		_partner.setContactPersonEmail(contactPersonEmail);
	}

	/**
	* Sets the contact person name of this partner.
	*
	* @param contactPersonName the contact person name of this partner
	*/
	@Override
	public void setContactPersonName(java.lang.String contactPersonName) {
		_partner.setContactPersonName(contactPersonName);
	}

	/**
	* Sets the contact person phone number of this partner.
	*
	* @param contactPersonPhoneNumber the contact person phone number of this partner
	*/
	@Override
	public void setContactPersonPhoneNumber(
		java.lang.String contactPersonPhoneNumber) {
		_partner.setContactPersonPhoneNumber(contactPersonPhoneNumber);
	}

	/**
	* Sets the country of this partner.
	*
	* @param country the country of this partner
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_partner.setCountry(country);
	}

	/**
	* Sets the create date of this partner.
	*
	* @param createDate the create date of this partner
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_partner.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this partner.
	*
	* @param createdBy the created by of this partner
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_partner.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_partner.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_partner.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_partner.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this partner.
	*
	* @param modifiedBy the modified by of this partner
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_partner.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this partner.
	*
	* @param modifiedDate the modified date of this partner
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_partner.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_partner.setNew(n);
	}

	/**
	* Sets the partner ID of this partner.
	*
	* @param partnerId the partner ID of this partner
	*/
	@Override
	public void setPartnerId(long partnerId) {
		_partner.setPartnerId(partnerId);
	}

	/**
	* Sets the partner org ID of this partner.
	*
	* @param partnerOrgId the partner org ID of this partner
	*/
	@Override
	public void setPartnerOrgId(long partnerOrgId) {
		_partner.setPartnerOrgId(partnerOrgId);
	}

	/**
	* Sets the primary key of this partner.
	*
	* @param primaryKey the primary key of this partner
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_partner.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_partner.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the state of this partner.
	*
	* @param state the state of this partner
	*/
	@Override
	public void setState(java.lang.String state) {
		_partner.setState(state);
	}

	/**
	* Sets the user ID of this partner.
	*
	* @param userId the user ID of this partner
	*/
	@Override
	public void setUserId(long userId) {
		_partner.setUserId(userId);
	}

	/**
	* Sets the user uuid of this partner.
	*
	* @param userUuid the user uuid of this partner
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_partner.setUserUuid(userUuid);
	}

	/**
	* Sets the website link of this partner.
	*
	* @param websiteLink the website link of this partner
	*/
	@Override
	public void setWebsiteLink(java.lang.String websiteLink) {
		_partner.setWebsiteLink(websiteLink);
	}

	/**
	* Sets the zipcode of this partner.
	*
	* @param zipcode the zipcode of this partner
	*/
	@Override
	public void setZipcode(java.lang.String zipcode) {
		_partner.setZipcode(zipcode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PartnerWrapper)) {
			return false;
		}

		PartnerWrapper partnerWrapper = (PartnerWrapper)obj;

		if (Objects.equals(_partner, partnerWrapper._partner)) {
			return true;
		}

		return false;
	}

	@Override
	public Partner getWrappedModel() {
		return _partner;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _partner.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _partner.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_partner.resetOriginalValues();
	}

	private final Partner _partner;
}