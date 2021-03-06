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

import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import com.medicus.common.service.service.persistence.Interview_RequestPK;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Interview_Request service. Represents a row in the &quot;Medicus_Interview_Request&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.medicus.common.service.model.impl.Interview_RequestModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.medicus.common.service.model.impl.Interview_RequestImpl}.
 * </p>
 *
 * @author sandip.patel
 * @see Interview_Request
 * @see com.medicus.common.service.model.impl.Interview_RequestImpl
 * @see com.medicus.common.service.model.impl.Interview_RequestModelImpl
 * @generated
 */
@ProviderType
public interface Interview_RequestModel extends BaseModel<Interview_Request> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a interview_ request model instance should use the {@link Interview_Request} interface instead.
	 */

	/**
	 * Returns the primary key of this interview_ request.
	 *
	 * @return the primary key of this interview_ request
	 */
	public Interview_RequestPK getPrimaryKey();

	/**
	 * Sets the primary key of this interview_ request.
	 *
	 * @param primaryKey the primary key of this interview_ request
	 */
	public void setPrimaryKey(Interview_RequestPK primaryKey);

	/**
	 * Returns the partner ID of this interview_ request.
	 *
	 * @return the partner ID of this interview_ request
	 */
	public long getPartnerId();

	/**
	 * Sets the partner ID of this interview_ request.
	 *
	 * @param partnerId the partner ID of this interview_ request
	 */
	public void setPartnerId(long partnerId);

	/**
	 * Returns the student ID of this interview_ request.
	 *
	 * @return the student ID of this interview_ request
	 */
	public long getStudentId();

	/**
	 * Sets the student ID of this interview_ request.
	 *
	 * @param studentId the student ID of this interview_ request
	 */
	public void setStudentId(long studentId);

	/**
	 * Returns the school ID of this interview_ request.
	 *
	 * @return the school ID of this interview_ request
	 */
	public long getSchoolId();

	/**
	 * Sets the school ID of this interview_ request.
	 *
	 * @param schoolId the school ID of this interview_ request
	 */
	public void setSchoolId(long schoolId);

	/**
	 * Returns the campus ID of this interview_ request.
	 *
	 * @return the campus ID of this interview_ request
	 */
	public long getCampusId();

	/**
	 * Sets the campus ID of this interview_ request.
	 *
	 * @param campusId the campus ID of this interview_ request
	 */
	public void setCampusId(long campusId);

	/**
	 * Returns the status of this interview_ request.
	 *
	 * @return the status of this interview_ request
	 */
	public int getStatus();

	/**
	 * Sets the status of this interview_ request.
	 *
	 * @param status the status of this interview_ request
	 */
	public void setStatus(int status);

	/**
	 * Returns the create date of this interview_ request.
	 *
	 * @return the create date of this interview_ request
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this interview_ request.
	 *
	 * @param createDate the create date of this interview_ request
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the created by of this interview_ request.
	 *
	 * @return the created by of this interview_ request
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this interview_ request.
	 *
	 * @param createdBy the created by of this interview_ request
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified date of this interview_ request.
	 *
	 * @return the modified date of this interview_ request
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this interview_ request.
	 *
	 * @param modifiedDate the modified date of this interview_ request
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified by of this interview_ request.
	 *
	 * @return the modified by of this interview_ request
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this interview_ request.
	 *
	 * @param modifiedBy the modified by of this interview_ request
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
	public int compareTo(Interview_Request interview_Request);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Interview_Request> toCacheModel();

	@Override
	public Interview_Request toEscapedModel();

	@Override
	public Interview_Request toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}