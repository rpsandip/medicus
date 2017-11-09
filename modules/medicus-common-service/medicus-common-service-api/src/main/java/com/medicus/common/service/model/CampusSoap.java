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
public class CampusSoap implements Serializable {
	public static CampusSoap toSoapModel(Campus model) {
		CampusSoap soapModel = new CampusSoap();

		soapModel.setCampusId(model.getCampusId());
		soapModel.setSchoolId(model.getSchoolId());
		soapModel.setName(model.getName());
		soapModel.setAddress1(model.getAddress1());
		soapModel.setAddress2(model.getAddress2());
		soapModel.setCity(model.getCity());
		soapModel.setState(model.getState());
		soapModel.setCountry(model.getCountry());
		soapModel.setZipcode(model.getZipcode());
		soapModel.setContactNumber(model.getContactNumber());
		soapModel.setWebsiteLink(model.getWebsiteLink());
		soapModel.setContactPersonName(model.getContactPersonName());
		soapModel.setContactPersonPhoneNumber(model.getContactPersonPhoneNumber());
		soapModel.setContactPersonEmail(model.getContactPersonEmail());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static CampusSoap[] toSoapModels(Campus[] models) {
		CampusSoap[] soapModels = new CampusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CampusSoap[][] toSoapModels(Campus[][] models) {
		CampusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CampusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CampusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CampusSoap[] toSoapModels(List<Campus> models) {
		List<CampusSoap> soapModels = new ArrayList<CampusSoap>(models.size());

		for (Campus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CampusSoap[soapModels.size()]);
	}

	public CampusSoap() {
	}

	public long getPrimaryKey() {
		return _campusId;
	}

	public void setPrimaryKey(long pk) {
		setCampusId(pk);
	}

	public long getCampusId() {
		return _campusId;
	}

	public void setCampusId(long campusId) {
		_campusId = campusId;
	}

	public long getSchoolId() {
		return _schoolId;
	}

	public void setSchoolId(long schoolId) {
		_schoolId = schoolId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
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

	public String getZipcode() {
		return _zipcode;
	}

	public void setZipcode(String zipcode) {
		_zipcode = zipcode;
	}

	public String getContactNumber() {
		return _contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		_contactNumber = contactNumber;
	}

	public String getWebsiteLink() {
		return _websiteLink;
	}

	public void setWebsiteLink(String websiteLink) {
		_websiteLink = websiteLink;
	}

	public String getContactPersonName() {
		return _contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		_contactPersonName = contactPersonName;
	}

	public String getContactPersonPhoneNumber() {
		return _contactPersonPhoneNumber;
	}

	public void setContactPersonPhoneNumber(String contactPersonPhoneNumber) {
		_contactPersonPhoneNumber = contactPersonPhoneNumber;
	}

	public String getContactPersonEmail() {
		return _contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		_contactPersonEmail = contactPersonEmail;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
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

	private long _campusId;
	private long _schoolId;
	private String _name;
	private String _address1;
	private String _address2;
	private String _city;
	private String _state;
	private String _country;
	private String _zipcode;
	private String _contactNumber;
	private String _websiteLink;
	private String _contactPersonName;
	private String _contactPersonPhoneNumber;
	private String _contactPersonEmail;
	private int _status;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}