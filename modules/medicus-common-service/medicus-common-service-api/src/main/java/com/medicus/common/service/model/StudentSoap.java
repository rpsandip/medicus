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
public class StudentSoap implements Serializable {
	public static StudentSoap toSoapModel(Student model) {
		StudentSoap soapModel = new StudentSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setStudentId(model.getStudentId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setStundetCampusId(model.getStundetCampusId());
		soapModel.setCampusId(model.getCampusId());
		soapModel.setSchoolId(model.getSchoolId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setMiddleName(model.getMiddleName());
		soapModel.setLastName(model.getLastName());
		soapModel.setProfileImageId(model.getProfileImageId());
		soapModel.setDateOfBirth(model.getDateOfBirth());
		soapModel.setGender(model.getGender());
		soapModel.setContactNumber(model.getContactNumber());
		soapModel.setHomePhoneNumber(model.getHomePhoneNumber());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setPrimaryLanguage(model.getPrimaryLanguage());
		soapModel.setSecondaryLanguage(model.getSecondaryLanguage());
		soapModel.setAddress(model.getAddress());
		soapModel.setCity(model.getCity());
		soapModel.setZipcode(model.getZipcode());
		soapModel.setState(model.getState());
		soapModel.setPace(model.getPace());
		soapModel.setEthnicityDesc(model.getEthnicityDesc());
		soapModel.setGpa(model.getGpa());
		soapModel.setResumeFileEntryId(model.getResumeFileEntryId());
		soapModel.setProfession(model.getProfession());
		soapModel.setPractices(model.getPractices());
		soapModel.setHired(model.getHired());
		soapModel.setGraduationDate(model.getGraduationDate());
		soapModel.setActivelySeekingEmployment(model.getActivelySeekingEmployment());
		soapModel.setHaveExternship(model.getHaveExternship());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static StudentSoap[] toSoapModels(Student[] models) {
		StudentSoap[] soapModels = new StudentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StudentSoap[][] toSoapModels(Student[][] models) {
		StudentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StudentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StudentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StudentSoap[] toSoapModels(List<Student> models) {
		List<StudentSoap> soapModels = new ArrayList<StudentSoap>(models.size());

		for (Student model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StudentSoap[soapModels.size()]);
	}

	public StudentSoap() {
	}

	public long getPrimaryKey() {
		return _studentId;
	}

	public void setPrimaryKey(long pk) {
		setStudentId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getStudentId() {
		return _studentId;
	}

	public void setStudentId(long studentId) {
		_studentId = studentId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public String getStundetCampusId() {
		return _stundetCampusId;
	}

	public void setStundetCampusId(String stundetCampusId) {
		_stundetCampusId = stundetCampusId;
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

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getMiddleName() {
		return _middleName;
	}

	public void setMiddleName(String middleName) {
		_middleName = middleName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public long getProfileImageId() {
		return _profileImageId;
	}

	public void setProfileImageId(long profileImageId) {
		_profileImageId = profileImageId;
	}

	public Date getDateOfBirth() {
		return _dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		_dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public String getContactNumber() {
		return _contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		_contactNumber = contactNumber;
	}

	public String getHomePhoneNumber() {
		return _homePhoneNumber;
	}

	public void setHomePhoneNumber(String homePhoneNumber) {
		_homePhoneNumber = homePhoneNumber;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getPrimaryLanguage() {
		return _primaryLanguage;
	}

	public void setPrimaryLanguage(String primaryLanguage) {
		_primaryLanguage = primaryLanguage;
	}

	public String getSecondaryLanguage() {
		return _secondaryLanguage;
	}

	public void setSecondaryLanguage(String secondaryLanguage) {
		_secondaryLanguage = secondaryLanguage;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
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

	public String getPace() {
		return _pace;
	}

	public void setPace(String pace) {
		_pace = pace;
	}

	public String getEthnicityDesc() {
		return _ethnicityDesc;
	}

	public void setEthnicityDesc(String ethnicityDesc) {
		_ethnicityDesc = ethnicityDesc;
	}

	public float getGpa() {
		return _gpa;
	}

	public void setGpa(float gpa) {
		_gpa = gpa;
	}

	public long getResumeFileEntryId() {
		return _resumeFileEntryId;
	}

	public void setResumeFileEntryId(long resumeFileEntryId) {
		_resumeFileEntryId = resumeFileEntryId;
	}

	public String getProfession() {
		return _profession;
	}

	public void setProfession(String profession) {
		_profession = profession;
	}

	public String getPractices() {
		return _practices;
	}

	public void setPractices(String practices) {
		_practices = practices;
	}

	public boolean getHired() {
		return _hired;
	}

	public boolean isHired() {
		return _hired;
	}

	public void setHired(boolean hired) {
		_hired = hired;
	}

	public Date getGraduationDate() {
		return _graduationDate;
	}

	public void setGraduationDate(Date graduationDate) {
		_graduationDate = graduationDate;
	}

	public boolean getActivelySeekingEmployment() {
		return _activelySeekingEmployment;
	}

	public boolean isActivelySeekingEmployment() {
		return _activelySeekingEmployment;
	}

	public void setActivelySeekingEmployment(boolean activelySeekingEmployment) {
		_activelySeekingEmployment = activelySeekingEmployment;
	}

	public boolean getHaveExternship() {
		return _haveExternship;
	}

	public boolean isHaveExternship() {
		return _haveExternship;
	}

	public void setHaveExternship(boolean haveExternship) {
		_haveExternship = haveExternship;
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

	private String _uuid;
	private long _studentId;
	private long _companyId;
	private String _stundetCampusId;
	private long _campusId;
	private long _schoolId;
	private String _firstName;
	private String _middleName;
	private String _lastName;
	private long _profileImageId;
	private Date _dateOfBirth;
	private String _gender;
	private String _contactNumber;
	private String _homePhoneNumber;
	private String _emailAddress;
	private String _primaryLanguage;
	private String _secondaryLanguage;
	private String _address;
	private String _city;
	private String _zipcode;
	private String _state;
	private String _pace;
	private String _ethnicityDesc;
	private float _gpa;
	private long _resumeFileEntryId;
	private String _profession;
	private String _practices;
	private boolean _hired;
	private Date _graduationDate;
	private boolean _activelySeekingEmployment;
	private boolean _haveExternship;
	private int _status;
	private Date _createDate;
	private long _createdBy;
	private Date _modifiedDate;
	private long _modifiedBy;
}