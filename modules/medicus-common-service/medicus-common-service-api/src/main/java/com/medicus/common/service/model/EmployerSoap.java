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
public class EmployerSoap implements Serializable {
	public static EmployerSoap toSoapModel(Employer model) {
		EmployerSoap soapModel = new EmployerSoap();

		soapModel.setEmployerId(model.getEmployerId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setAddress1(model.getAddress1());
		soapModel.setAddress2(model.getAddress2());
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

	public static EmployerSoap[] toSoapModels(Employer[] models) {
		EmployerSoap[] soapModels = new EmployerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmployerSoap[][] toSoapModels(Employer[][] models) {
		EmployerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmployerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmployerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmployerSoap[] toSoapModels(List<Employer> models) {
		List<EmployerSoap> soapModels = new ArrayList<EmployerSoap>(models.size());

		for (Employer model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmployerSoap[soapModels.size()]);
	}

	public EmployerSoap() {
	}

	public long getPrimaryKey() {
		return _employerId;
	}

	public void setPrimaryKey(long pk) {
		setEmployerId(pk);
	}

	public long getEmployerId() {
		return _employerId;
	}

	public void setEmployerId(long employerId) {
		_employerId = employerId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getAddress1() {
		return _address1;
	}

	public void setAddress1(String address1) {
		_address1 = address1;
	}

	public String getAddress2() {
		return _address2;
	}

	public void setAddress2(String address2) {
		_address2 = address2;
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

	private long _employerId;
	private String _firstName;
	private String _lastName;
	private String _emailAddress;
	private String _address1;
	private String _address2;
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