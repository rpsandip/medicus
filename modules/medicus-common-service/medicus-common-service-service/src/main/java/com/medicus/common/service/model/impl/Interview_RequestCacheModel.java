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

package com.medicus.common.service.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.medicus.common.service.model.Interview_Request;
import com.medicus.common.service.service.persistence.Interview_RequestPK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Interview_Request in entity cache.
 *
 * @author sandip.patel
 * @see Interview_Request
 * @generated
 */
@ProviderType
public class Interview_RequestCacheModel implements CacheModel<Interview_Request>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Interview_RequestCacheModel)) {
			return false;
		}

		Interview_RequestCacheModel interview_RequestCacheModel = (Interview_RequestCacheModel)obj;

		if (interview_RequestPK.equals(
					interview_RequestCacheModel.interview_RequestPK)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, interview_RequestPK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{partnerId=");
		sb.append(partnerId);
		sb.append(", studentId=");
		sb.append(studentId);
		sb.append(", schoolId=");
		sb.append(schoolId);
		sb.append(", campusId=");
		sb.append(campusId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Interview_Request toEntityModel() {
		Interview_RequestImpl interview_RequestImpl = new Interview_RequestImpl();

		interview_RequestImpl.setPartnerId(partnerId);
		interview_RequestImpl.setStudentId(studentId);
		interview_RequestImpl.setSchoolId(schoolId);
		interview_RequestImpl.setCampusId(campusId);
		interview_RequestImpl.setStatus(status);

		if (createDate == Long.MIN_VALUE) {
			interview_RequestImpl.setCreateDate(null);
		}
		else {
			interview_RequestImpl.setCreateDate(new Date(createDate));
		}

		interview_RequestImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			interview_RequestImpl.setModifiedDate(null);
		}
		else {
			interview_RequestImpl.setModifiedDate(new Date(modifiedDate));
		}

		interview_RequestImpl.setModifiedBy(modifiedBy);

		interview_RequestImpl.resetOriginalValues();

		return interview_RequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		partnerId = objectInput.readLong();

		studentId = objectInput.readLong();

		schoolId = objectInput.readLong();

		campusId = objectInput.readLong();

		status = objectInput.readInt();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();

		interview_RequestPK = new Interview_RequestPK(partnerId, studentId);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(partnerId);

		objectOutput.writeLong(studentId);

		objectOutput.writeLong(schoolId);

		objectOutput.writeLong(campusId);

		objectOutput.writeInt(status);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long partnerId;
	public long studentId;
	public long schoolId;
	public long campusId;
	public int status;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
	public transient Interview_RequestPK interview_RequestPK;
}