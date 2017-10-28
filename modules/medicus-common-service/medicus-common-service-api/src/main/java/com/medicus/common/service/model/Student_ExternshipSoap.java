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
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class Student_ExternshipSoap implements Serializable {
	public static Student_ExternshipSoap toSoapModel(Student_Externship model) {
		Student_ExternshipSoap soapModel = new Student_ExternshipSoap();

		soapModel.setStudentExternshipId(model.getStudentExternshipId());
		soapModel.setStudentId(model.getStudentId());
		soapModel.setEmployerId(model.getEmployerId());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setNoOfHoursPerWeek(model.getNoOfHoursPerWeek());
		soapModel.setMidPointReview(model.getMidPointReview());
		soapModel.setMidPointReviewComment(model.getMidPointReviewComment());
		soapModel.setFinalReview(model.getFinalReview());
		soapModel.setFinalReviewComment(model.getFinalReviewComment());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static Student_ExternshipSoap[] toSoapModels(
		Student_Externship[] models) {
		Student_ExternshipSoap[] soapModels = new Student_ExternshipSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Student_ExternshipSoap[][] toSoapModels(
		Student_Externship[][] models) {
		Student_ExternshipSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Student_ExternshipSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Student_ExternshipSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Student_ExternshipSoap[] toSoapModels(
		List<Student_Externship> models) {
		List<Student_ExternshipSoap> soapModels = new ArrayList<Student_ExternshipSoap>(models.size());

		for (Student_Externship model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Student_ExternshipSoap[soapModels.size()]);
	}

	public Student_ExternshipSoap() {
	}

	public long getPrimaryKey() {
		return _studentExternshipId;
	}

	public void setPrimaryKey(long pk) {
		setStudentExternshipId(pk);
	}

	public long getStudentExternshipId() {
		return _studentExternshipId;
	}

	public void setStudentExternshipId(long studentExternshipId) {
		_studentExternshipId = studentExternshipId;
	}

	public long getStudentId() {
		return _studentId;
	}

	public void setStudentId(long studentId) {
		_studentId = studentId;
	}

	public long getEmployerId() {
		return _employerId;
	}

	public void setEmployerId(long employerId) {
		_employerId = employerId;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public int getNoOfHoursPerWeek() {
		return _noOfHoursPerWeek;
	}

	public void setNoOfHoursPerWeek(int noOfHoursPerWeek) {
		_noOfHoursPerWeek = noOfHoursPerWeek;
	}

	public Date getMidPointReview() {
		return _midPointReview;
	}

	public void setMidPointReview(Date midPointReview) {
		_midPointReview = midPointReview;
	}

	public String getMidPointReviewComment() {
		return _midPointReviewComment;
	}

	public void setMidPointReviewComment(String midPointReviewComment) {
		_midPointReviewComment = midPointReviewComment;
	}

	public Date getFinalReview() {
		return _finalReview;
	}

	public void setFinalReview(Date finalReview) {
		_finalReview = finalReview;
	}

	public String getFinalReviewComment() {
		return _finalReviewComment;
	}

	public void setFinalReviewComment(String finalReviewComment) {
		_finalReviewComment = finalReviewComment;
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

	private long _studentExternshipId;
	private long _studentId;
	private long _employerId;
	private Date _startDate;
	private Date _endDate;
	private int _noOfHoursPerWeek;
	private Date _midPointReview;
	private String _midPointReviewComment;
	private Date _finalReview;
	private String _finalReviewComment;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}