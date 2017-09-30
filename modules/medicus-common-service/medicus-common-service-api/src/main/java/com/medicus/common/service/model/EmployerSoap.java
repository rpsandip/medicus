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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class EmployerSoap implements Serializable {
	public static EmployerSoap toSoapModel(Employer model) {
		EmployerSoap soapModel = new EmployerSoap();

		soapModel.setEmployerId(model.getEmployerId());
		soapModel.setUserId(model.getUserId());
		soapModel.setEmployerOrgId(model.getEmployerOrgId());
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getEmployerOrgId() {
		return _employerOrgId;
	}

	public void setEmployerOrgId(long employerOrgId) {
		_employerOrgId = employerOrgId;
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

	private long _employerId;
	private long _userId;
	private long _employerOrgId;
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
}