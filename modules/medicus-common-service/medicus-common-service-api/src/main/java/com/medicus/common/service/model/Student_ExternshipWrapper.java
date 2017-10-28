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
 * This class is a wrapper for {@link Student_Externship}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Student_Externship
 * @generated
 */
@ProviderType
public class Student_ExternshipWrapper implements Student_Externship,
	ModelWrapper<Student_Externship> {
	public Student_ExternshipWrapper(Student_Externship student_Externship) {
		_student_Externship = student_Externship;
	}

	@Override
	public Class<?> getModelClass() {
		return Student_Externship.class;
	}

	@Override
	public String getModelClassName() {
		return Student_Externship.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("studentExternshipId", getStudentExternshipId());
		attributes.put("studentId", getStudentId());
		attributes.put("employerId", getEmployerId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("noOfHoursPerWeek", getNoOfHoursPerWeek());
		attributes.put("midPointReview", getMidPointReview());
		attributes.put("midPointReviewComment", getMidPointReviewComment());
		attributes.put("finalReview", getFinalReview());
		attributes.put("finalReviewComment", getFinalReviewComment());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long studentExternshipId = (Long)attributes.get("studentExternshipId");

		if (studentExternshipId != null) {
			setStudentExternshipId(studentExternshipId);
		}

		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

		Long employerId = (Long)attributes.get("employerId");

		if (employerId != null) {
			setEmployerId(employerId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Integer noOfHoursPerWeek = (Integer)attributes.get("noOfHoursPerWeek");

		if (noOfHoursPerWeek != null) {
			setNoOfHoursPerWeek(noOfHoursPerWeek);
		}

		Date midPointReview = (Date)attributes.get("midPointReview");

		if (midPointReview != null) {
			setMidPointReview(midPointReview);
		}

		String midPointReviewComment = (String)attributes.get(
				"midPointReviewComment");

		if (midPointReviewComment != null) {
			setMidPointReviewComment(midPointReviewComment);
		}

		Date finalReview = (Date)attributes.get("finalReview");

		if (finalReview != null) {
			setFinalReview(finalReview);
		}

		String finalReviewComment = (String)attributes.get("finalReviewComment");

		if (finalReviewComment != null) {
			setFinalReviewComment(finalReviewComment);
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
	public Student_Externship toEscapedModel() {
		return new Student_ExternshipWrapper(_student_Externship.toEscapedModel());
	}

	@Override
	public Student_Externship toUnescapedModel() {
		return new Student_ExternshipWrapper(_student_Externship.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _student_Externship.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _student_Externship.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _student_Externship.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _student_Externship.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Student_Externship> toCacheModel() {
		return _student_Externship.toCacheModel();
	}

	@Override
	public int compareTo(Student_Externship student_Externship) {
		return _student_Externship.compareTo(student_Externship);
	}

	/**
	* Returns the no of hours per week of this student_ externship.
	*
	* @return the no of hours per week of this student_ externship
	*/
	@Override
	public int getNoOfHoursPerWeek() {
		return _student_Externship.getNoOfHoursPerWeek();
	}

	@Override
	public int hashCode() {
		return _student_Externship.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _student_Externship.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new Student_ExternshipWrapper((Student_Externship)_student_Externship.clone());
	}

	/**
	* Returns the final review comment of this student_ externship.
	*
	* @return the final review comment of this student_ externship
	*/
	@Override
	public java.lang.String getFinalReviewComment() {
		return _student_Externship.getFinalReviewComment();
	}

	/**
	* Returns the mid point review comment of this student_ externship.
	*
	* @return the mid point review comment of this student_ externship
	*/
	@Override
	public java.lang.String getMidPointReviewComment() {
		return _student_Externship.getMidPointReviewComment();
	}

	@Override
	public java.lang.String toString() {
		return _student_Externship.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _student_Externship.toXmlString();
	}

	/**
	* Returns the create date of this student_ externship.
	*
	* @return the create date of this student_ externship
	*/
	@Override
	public Date getCreateDate() {
		return _student_Externship.getCreateDate();
	}

	/**
	* Returns the end date of this student_ externship.
	*
	* @return the end date of this student_ externship
	*/
	@Override
	public Date getEndDate() {
		return _student_Externship.getEndDate();
	}

	/**
	* Returns the final review of this student_ externship.
	*
	* @return the final review of this student_ externship
	*/
	@Override
	public Date getFinalReview() {
		return _student_Externship.getFinalReview();
	}

	/**
	* Returns the mid point review of this student_ externship.
	*
	* @return the mid point review of this student_ externship
	*/
	@Override
	public Date getMidPointReview() {
		return _student_Externship.getMidPointReview();
	}

	/**
	* Returns the modified date of this student_ externship.
	*
	* @return the modified date of this student_ externship
	*/
	@Override
	public Date getModifiedDate() {
		return _student_Externship.getModifiedDate();
	}

	/**
	* Returns the start date of this student_ externship.
	*
	* @return the start date of this student_ externship
	*/
	@Override
	public Date getStartDate() {
		return _student_Externship.getStartDate();
	}

	/**
	* Returns the created by of this student_ externship.
	*
	* @return the created by of this student_ externship
	*/
	@Override
	public long getCreatedBy() {
		return _student_Externship.getCreatedBy();
	}

	/**
	* Returns the employer ID of this student_ externship.
	*
	* @return the employer ID of this student_ externship
	*/
	@Override
	public long getEmployerId() {
		return _student_Externship.getEmployerId();
	}

	/**
	* Returns the modified by of this student_ externship.
	*
	* @return the modified by of this student_ externship
	*/
	@Override
	public long getModifiedBy() {
		return _student_Externship.getModifiedBy();
	}

	/**
	* Returns the primary key of this student_ externship.
	*
	* @return the primary key of this student_ externship
	*/
	@Override
	public long getPrimaryKey() {
		return _student_Externship.getPrimaryKey();
	}

	/**
	* Returns the student externship ID of this student_ externship.
	*
	* @return the student externship ID of this student_ externship
	*/
	@Override
	public long getStudentExternshipId() {
		return _student_Externship.getStudentExternshipId();
	}

	/**
	* Returns the student ID of this student_ externship.
	*
	* @return the student ID of this student_ externship
	*/
	@Override
	public long getStudentId() {
		return _student_Externship.getStudentId();
	}

	@Override
	public void persist() {
		_student_Externship.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_student_Externship.setCachedModel(cachedModel);
	}

	/**
	* Sets the create date of this student_ externship.
	*
	* @param createDate the create date of this student_ externship
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_student_Externship.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this student_ externship.
	*
	* @param createdBy the created by of this student_ externship
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_student_Externship.setCreatedBy(createdBy);
	}

	/**
	* Sets the employer ID of this student_ externship.
	*
	* @param employerId the employer ID of this student_ externship
	*/
	@Override
	public void setEmployerId(long employerId) {
		_student_Externship.setEmployerId(employerId);
	}

	/**
	* Sets the end date of this student_ externship.
	*
	* @param endDate the end date of this student_ externship
	*/
	@Override
	public void setEndDate(Date endDate) {
		_student_Externship.setEndDate(endDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_student_Externship.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_student_Externship.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_student_Externship.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the final review of this student_ externship.
	*
	* @param finalReview the final review of this student_ externship
	*/
	@Override
	public void setFinalReview(Date finalReview) {
		_student_Externship.setFinalReview(finalReview);
	}

	/**
	* Sets the final review comment of this student_ externship.
	*
	* @param finalReviewComment the final review comment of this student_ externship
	*/
	@Override
	public void setFinalReviewComment(java.lang.String finalReviewComment) {
		_student_Externship.setFinalReviewComment(finalReviewComment);
	}

	/**
	* Sets the mid point review of this student_ externship.
	*
	* @param midPointReview the mid point review of this student_ externship
	*/
	@Override
	public void setMidPointReview(Date midPointReview) {
		_student_Externship.setMidPointReview(midPointReview);
	}

	/**
	* Sets the mid point review comment of this student_ externship.
	*
	* @param midPointReviewComment the mid point review comment of this student_ externship
	*/
	@Override
	public void setMidPointReviewComment(java.lang.String midPointReviewComment) {
		_student_Externship.setMidPointReviewComment(midPointReviewComment);
	}

	/**
	* Sets the modified by of this student_ externship.
	*
	* @param modifiedBy the modified by of this student_ externship
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_student_Externship.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this student_ externship.
	*
	* @param modifiedDate the modified date of this student_ externship
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_student_Externship.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_student_Externship.setNew(n);
	}

	/**
	* Sets the no of hours per week of this student_ externship.
	*
	* @param noOfHoursPerWeek the no of hours per week of this student_ externship
	*/
	@Override
	public void setNoOfHoursPerWeek(int noOfHoursPerWeek) {
		_student_Externship.setNoOfHoursPerWeek(noOfHoursPerWeek);
	}

	/**
	* Sets the primary key of this student_ externship.
	*
	* @param primaryKey the primary key of this student_ externship
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_student_Externship.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_student_Externship.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the start date of this student_ externship.
	*
	* @param startDate the start date of this student_ externship
	*/
	@Override
	public void setStartDate(Date startDate) {
		_student_Externship.setStartDate(startDate);
	}

	/**
	* Sets the student externship ID of this student_ externship.
	*
	* @param studentExternshipId the student externship ID of this student_ externship
	*/
	@Override
	public void setStudentExternshipId(long studentExternshipId) {
		_student_Externship.setStudentExternshipId(studentExternshipId);
	}

	/**
	* Sets the student ID of this student_ externship.
	*
	* @param studentId the student ID of this student_ externship
	*/
	@Override
	public void setStudentId(long studentId) {
		_student_Externship.setStudentId(studentId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Student_ExternshipWrapper)) {
			return false;
		}

		Student_ExternshipWrapper student_ExternshipWrapper = (Student_ExternshipWrapper)obj;

		if (Objects.equals(_student_Externship,
					student_ExternshipWrapper._student_Externship)) {
			return true;
		}

		return false;
	}

	@Override
	public Student_Externship getWrappedModel() {
		return _student_Externship;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _student_Externship.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _student_Externship.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_student_Externship.resetOriginalValues();
	}

	private final Student_Externship _student_Externship;
}