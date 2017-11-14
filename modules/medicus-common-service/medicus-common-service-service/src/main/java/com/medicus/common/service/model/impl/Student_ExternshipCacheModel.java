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
import com.liferay.portal.kernel.util.StringPool;

import com.medicus.common.service.model.Student_Externship;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Student_Externship in entity cache.
 *
 * @author sandip.patel
 * @see Student_Externship
 * @generated
 */
@ProviderType
public class Student_ExternshipCacheModel implements CacheModel<Student_Externship>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Student_ExternshipCacheModel)) {
			return false;
		}

		Student_ExternshipCacheModel student_ExternshipCacheModel = (Student_ExternshipCacheModel)obj;

		if (studentExternshipId == student_ExternshipCacheModel.studentExternshipId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, studentExternshipId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{studentExternshipId=");
		sb.append(studentExternshipId);
		sb.append(", studentId=");
		sb.append(studentId);
		sb.append(", partnerId=");
		sb.append(partnerId);
		sb.append(", employerId=");
		sb.append(employerId);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", noOfHoursPerWeek=");
		sb.append(noOfHoursPerWeek);
		sb.append(", status=");
		sb.append(status);
		sb.append(", midPointReview=");
		sb.append(midPointReview);
		sb.append(", midPointReviewComment=");
		sb.append(midPointReviewComment);
		sb.append(", finalReview=");
		sb.append(finalReview);
		sb.append(", finalReviewComment=");
		sb.append(finalReviewComment);
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
	public Student_Externship toEntityModel() {
		Student_ExternshipImpl student_ExternshipImpl = new Student_ExternshipImpl();

		student_ExternshipImpl.setStudentExternshipId(studentExternshipId);
		student_ExternshipImpl.setStudentId(studentId);
		student_ExternshipImpl.setPartnerId(partnerId);
		student_ExternshipImpl.setEmployerId(employerId);

		if (startDate == Long.MIN_VALUE) {
			student_ExternshipImpl.setStartDate(null);
		}
		else {
			student_ExternshipImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			student_ExternshipImpl.setEndDate(null);
		}
		else {
			student_ExternshipImpl.setEndDate(new Date(endDate));
		}

		student_ExternshipImpl.setNoOfHoursPerWeek(noOfHoursPerWeek);
		student_ExternshipImpl.setStatus(status);

		if (midPointReview == Long.MIN_VALUE) {
			student_ExternshipImpl.setMidPointReview(null);
		}
		else {
			student_ExternshipImpl.setMidPointReview(new Date(midPointReview));
		}

		if (midPointReviewComment == null) {
			student_ExternshipImpl.setMidPointReviewComment(StringPool.BLANK);
		}
		else {
			student_ExternshipImpl.setMidPointReviewComment(midPointReviewComment);
		}

		if (finalReview == Long.MIN_VALUE) {
			student_ExternshipImpl.setFinalReview(null);
		}
		else {
			student_ExternshipImpl.setFinalReview(new Date(finalReview));
		}

		if (finalReviewComment == null) {
			student_ExternshipImpl.setFinalReviewComment(StringPool.BLANK);
		}
		else {
			student_ExternshipImpl.setFinalReviewComment(finalReviewComment);
		}

		if (createDate == Long.MIN_VALUE) {
			student_ExternshipImpl.setCreateDate(null);
		}
		else {
			student_ExternshipImpl.setCreateDate(new Date(createDate));
		}

		student_ExternshipImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			student_ExternshipImpl.setModifiedDate(null);
		}
		else {
			student_ExternshipImpl.setModifiedDate(new Date(modifiedDate));
		}

		student_ExternshipImpl.setModifiedBy(modifiedBy);

		student_ExternshipImpl.resetOriginalValues();

		return student_ExternshipImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		studentExternshipId = objectInput.readLong();

		studentId = objectInput.readLong();

		partnerId = objectInput.readLong();

		employerId = objectInput.readLong();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();

		noOfHoursPerWeek = objectInput.readInt();

		status = objectInput.readInt();
		midPointReview = objectInput.readLong();
		midPointReviewComment = objectInput.readUTF();
		finalReview = objectInput.readLong();
		finalReviewComment = objectInput.readUTF();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(studentExternshipId);

		objectOutput.writeLong(studentId);

		objectOutput.writeLong(partnerId);

		objectOutput.writeLong(employerId);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		objectOutput.writeInt(noOfHoursPerWeek);

		objectOutput.writeInt(status);
		objectOutput.writeLong(midPointReview);

		if (midPointReviewComment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(midPointReviewComment);
		}

		objectOutput.writeLong(finalReview);

		if (finalReviewComment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(finalReviewComment);
		}

		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long studentExternshipId;
	public long studentId;
	public long partnerId;
	public long employerId;
	public long startDate;
	public long endDate;
	public int noOfHoursPerWeek;
	public int status;
	public long midPointReview;
	public String midPointReviewComment;
	public long finalReview;
	public String finalReviewComment;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}