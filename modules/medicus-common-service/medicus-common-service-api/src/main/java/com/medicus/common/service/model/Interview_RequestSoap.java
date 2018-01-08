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

import com.medicus.common.service.service.persistence.Interview_RequestPK;

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
public class Interview_RequestSoap implements Serializable {
	public static Interview_RequestSoap toSoapModel(Interview_Request model) {
		Interview_RequestSoap soapModel = new Interview_RequestSoap();

		soapModel.setPartnerId(model.getPartnerId());
		soapModel.setStudentId(model.getStudentId());
		soapModel.setSchoolId(model.getSchoolId());
		soapModel.setCampusId(model.getCampusId());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static Interview_RequestSoap[] toSoapModels(
		Interview_Request[] models) {
		Interview_RequestSoap[] soapModels = new Interview_RequestSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Interview_RequestSoap[][] toSoapModels(
		Interview_Request[][] models) {
		Interview_RequestSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Interview_RequestSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Interview_RequestSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Interview_RequestSoap[] toSoapModels(
		List<Interview_Request> models) {
		List<Interview_RequestSoap> soapModels = new ArrayList<Interview_RequestSoap>(models.size());

		for (Interview_Request model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Interview_RequestSoap[soapModels.size()]);
	}

	public Interview_RequestSoap() {
	}

	public Interview_RequestPK getPrimaryKey() {
		return new Interview_RequestPK(_partnerId, _studentId);
	}

	public void setPrimaryKey(Interview_RequestPK pk) {
		setPartnerId(pk.partnerId);
		setStudentId(pk.studentId);
	}

	public long getPartnerId() {
		return _partnerId;
	}

	public void setPartnerId(long partnerId) {
		_partnerId = partnerId;
	}

	public long getStudentId() {
		return _studentId;
	}

	public void setStudentId(long studentId) {
		_studentId = studentId;
	}

	public long getSchoolId() {
		return _schoolId;
	}

	public void setSchoolId(long schoolId) {
		_schoolId = schoolId;
	}

	public long getCampusId() {
		return _campusId;
	}

	public void setCampusId(long campusId) {
		_campusId = campusId;
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

	private long _partnerId;
	private long _studentId;
	private long _schoolId;
	private long _campusId;
	private int _status;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}