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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author sandip.patel
 * @generated
 */
@ProviderType
public class PartnerSoap implements Serializable {
	public static PartnerSoap toSoapModel(Partner model) {
		PartnerSoap soapModel = new PartnerSoap();

		soapModel.setPartnerId(model.getPartnerId());
		soapModel.setUserId(model.getUserId());
		soapModel.setPartnerOrgId(model.getPartnerOrgId());
		soapModel.setAddress1(model.getAddress1());
		soapModel.setCity(model.getCity());
		soapModel.setZipcode(model.getZipcode());
		soapModel.setState(model.getState());
		soapModel.setCountry(model.getCountry());
		soapModel.setContactPersonName(model.getContactPersonName());
		soapModel.setContactPersonEmail(model.getContactPersonEmail());
		soapModel.setContactPersonPhoneNumber(model.getContactPersonPhoneNumber());
		soapModel.setWebsiteLink(model.getWebsiteLink());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static PartnerSoap[] toSoapModels(Partner[] models) {
		PartnerSoap[] soapModels = new PartnerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PartnerSoap[][] toSoapModels(Partner[][] models) {
		PartnerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PartnerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PartnerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PartnerSoap[] toSoapModels(List<Partner> models) {
		List<PartnerSoap> soapModels = new ArrayList<PartnerSoap>(models.size());

		for (Partner model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PartnerSoap[soapModels.size()]);
	}

	public PartnerSoap() {
	}

	public long getPrimaryKey() {
		return _partnerId;
	}

	public void setPrimaryKey(long pk) {
		setPartnerId(pk);
	}

	public long getPartnerId() {
		return _partnerId;
	}

	public void setPartnerId(long partnerId) {
		_partnerId = partnerId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getPartnerOrgId() {
		return _partnerOrgId;
	}

	public void setPartnerOrgId(long partnerOrgId) {
		_partnerOrgId = partnerOrgId;
	}

	public String getAddress1() {
		return _address1;
	}

	public void setAddress1(String address1) {
		_address1 = address1;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getZipcode() {
		return _zipcode;
	}

	public void setZipcode(String zipcode) {
		_zipcode = zipcode;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public String getContactPersonName() {
		return _contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		_contactPersonName = contactPersonName;
	}

	public String getContactPersonEmail() {
		return _contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		_contactPersonEmail = contactPersonEmail;
	}

	public String getContactPersonPhoneNumber() {
		return _contactPersonPhoneNumber;
	}

	public void setContactPersonPhoneNumber(String contactPersonPhoneNumber) {
		_contactPersonPhoneNumber = contactPersonPhoneNumber;
	}

	public String getWebsiteLink() {
		return _websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		_websiteLink = websiteLink;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	private long _partnerId;
	private long _userId;
	private long _partnerOrgId;
	private String _address1;
	private String _city;
	private String _zipcode;
	private String _state;
	private String _country;
	private String _contactPersonName;
	private String _contactPersonEmail;
	private String _contactPersonPhoneNumber;
	private String _websiteLink;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}