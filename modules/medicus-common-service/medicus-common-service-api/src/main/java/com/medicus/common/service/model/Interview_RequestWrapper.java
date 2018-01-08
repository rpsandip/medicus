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
 * This class is a wrapper for {@link Interview_Request}.
 * </p>
 *
 * @author sandip.patel
 * @see Interview_Request
 * @generated
 */
@ProviderType
public class Interview_RequestWrapper implements Interview_Request,
	ModelWrapper<Interview_Request> {
	public Interview_RequestWrapper(Interview_Request interview_Request) {
		_interview_Request = interview_Request;
	}

	@Override
	public Class<?> getModelClass() {
		return Interview_Request.class;
	}

	@Override
	public String getModelClassName() {
		return Interview_Request.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("partnerId", getPartnerId());
		attributes.put("studentId", getStudentId());
		attributes.put("schoolId", getSchoolId());
		attributes.put("campusId", getCampusId());
		attributes.put("status", getStatus());
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

		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

		Long schoolId = (Long)attributes.get("schoolId");

		if (schoolId != null) {
			setSchoolId(schoolId);
		}

		Long campusId = (Long)attributes.get("campusId");

		if (campusId != null) {
			setCampusId(campusId);
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
	public Interview_Request toEscapedModel() {
		return new Interview_RequestWrapper(_interview_Request.toEscapedModel());
	}

	@Override
	public Interview_Request toUnescapedModel() {
		return new Interview_RequestWrapper(_interview_Request.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _interview_Request.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _interview_Request.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _interview_Request.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _interview_Request.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Interview_Request> toCacheModel() {
		return _interview_Request.toCacheModel();
	}

	/**
	* Returns the primary key of this interview_ request.
	*
	* @return the primary key of this interview_ request
	*/
	@Override
	public com.medicus.common.service.service.persistence.Interview_RequestPK getPrimaryKey() {
		return _interview_Request.getPrimaryKey();
	}

	@Override
	public int compareTo(Interview_Request interview_Request) {
		return _interview_Request.compareTo(interview_Request);
	}

	/**
	* Returns the status of this interview_ request.
	*
	* @return the status of this interview_ request
	*/
	@Override
	public int getStatus() {
		return _interview_Request.getStatus();
	}

	@Override
	public int hashCode() {
		return _interview_Request.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _interview_Request.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new Interview_RequestWrapper((Interview_Request)_interview_Request.clone());
	}

	@Override
	public java.lang.String toString() {
		return _interview_Request.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _interview_Request.toXmlString();
	}

	/**
	* Returns the create date of this interview_ request.
	*
	* @return the create date of this interview_ request
	*/
	@Override
	public Date getCreateDate() {
		return _interview_Request.getCreateDate();
	}

	/**
	* Returns the modified date of this interview_ request.
	*
	* @return the modified date of this interview_ request
	*/
	@Override
	public Date getModifiedDate() {
		return _interview_Request.getModifiedDate();
	}

	/**
	* Returns the campus ID of this interview_ request.
	*
	* @return the campus ID of this interview_ request
	*/
	@Override
	public long getCampusId() {
		return _interview_Request.getCampusId();
	}

	/**
	* Returns the created by of this interview_ request.
	*
	* @return the created by of this interview_ request
	*/
	@Override
	public long getCreatedBy() {
		return _interview_Request.getCreatedBy();
	}

	/**
	* Returns the modified by of this interview_ request.
	*
	* @return the modified by of this interview_ request
	*/
	@Override
	public long getModifiedBy() {
		return _interview_Request.getModifiedBy();
	}

	/**
	* Returns the partner ID of this interview_ request.
	*
	* @return the partner ID of this interview_ request
	*/
	@Override
	public long getPartnerId() {
		return _interview_Request.getPartnerId();
	}

	/**
	* Returns the school ID of this interview_ request.
	*
	* @return the school ID of this interview_ request
	*/
	@Override
	public long getSchoolId() {
		return _interview_Request.getSchoolId();
	}

	/**
	* Returns the student ID of this interview_ request.
	*
	* @return the student ID of this interview_ request
	*/
	@Override
	public long getStudentId() {
		return _interview_Request.getStudentId();
	}

	@Override
	public void persist() {
		_interview_Request.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_interview_Request.setCachedModel(cachedModel);
	}

	/**
	* Sets the campus ID of this interview_ request.
	*
	* @param campusId the campus ID of this interview_ request
	*/
	@Override
	public void setCampusId(long campusId) {
		_interview_Request.setCampusId(campusId);
	}

	/**
	* Sets the create date of this interview_ request.
	*
	* @param createDate the create date of this interview_ request
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_interview_Request.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this interview_ request.
	*
	* @param createdBy the created by of this interview_ request
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_interview_Request.setCreatedBy(createdBy);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_interview_Request.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_interview_Request.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_interview_Request.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the modified by of this interview_ request.
	*
	* @param modifiedBy the modified by of this interview_ request
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_interview_Request.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this interview_ request.
	*
	* @param modifiedDate the modified date of this interview_ request
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_interview_Request.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_interview_Request.setNew(n);
	}

	/**
	* Sets the partner ID of this interview_ request.
	*
	* @param partnerId the partner ID of this interview_ request
	*/
	@Override
	public void setPartnerId(long partnerId) {
		_interview_Request.setPartnerId(partnerId);
	}

	/**
	* Sets the primary key of this interview_ request.
	*
	* @param primaryKey the primary key of this interview_ request
	*/
	@Override
	public void setPrimaryKey(
		com.medicus.common.service.service.persistence.Interview_RequestPK primaryKey) {
		_interview_Request.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_interview_Request.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the school ID of this interview_ request.
	*
	* @param schoolId the school ID of this interview_ request
	*/
	@Override
	public void setSchoolId(long schoolId) {
		_interview_Request.setSchoolId(schoolId);
	}

	/**
	* Sets the status of this interview_ request.
	*
	* @param status the status of this interview_ request
	*/
	@Override
	public void setStatus(int status) {
		_interview_Request.setStatus(status);
	}

	/**
	* Sets the student ID of this interview_ request.
	*
	* @param studentId the student ID of this interview_ request
	*/
	@Override
	public void setStudentId(long studentId) {
		_interview_Request.setStudentId(studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Interview_RequestWrapper)) {
			return false;
		}

		Interview_RequestWrapper interview_RequestWrapper = (Interview_RequestWrapper)obj;

		if (Objects.equals(_interview_Request,
					interview_RequestWrapper._interview_Request)) {
			return true;
		}

		return false;
	}

	@Override
	public Interview_Request getWrappedModel() {
		return _interview_Request;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _interview_Request.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _interview_Request.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_interview_Request.resetOriginalValues();
	}

	private final Interview_Request _interview_Request;
}