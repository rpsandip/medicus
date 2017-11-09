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

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Student}.
 * </p>
 *
 * @author sandip.patel
 * @see Student
 * @generated
 */
@ProviderType
public class StudentWrapper implements Student, ModelWrapper<Student> {
	public StudentWrapper(Student student) {
		_student = student;
	}

	@Override
	public Class<?> getModelClass() {
		return Student.class;
	}

	@Override
	public String getModelClassName() {
		return Student.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("studentId", getStudentId());
		attributes.put("companyId", getCompanyId());
		attributes.put("stundetCampusId", getStundetCampusId());
		attributes.put("campusId", getCampusId());
		attributes.put("schoolId", getSchoolId());
		attributes.put("firstName", getFirstName());
		attributes.put("middleName", getMiddleName());
		attributes.put("lastName", getLastName());
		attributes.put("profileImageId", getProfileImageId());
		attributes.put("dateOfBirth", getDateOfBirth());
		attributes.put("gender", getGender());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("homePhoneNumber", getHomePhoneNumber());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("primaryLanguage", getPrimaryLanguage());
		attributes.put("secondaryLanguage", getSecondaryLanguage());
		attributes.put("address", getAddress());
		attributes.put("city", getCity());
		attributes.put("zipcode", getZipcode());
		attributes.put("state", getState());
		attributes.put("pace", getPace());
		attributes.put("gpa", getGpa());
		attributes.put("resumeFileEntryId", getResumeFileEntryId());
		attributes.put("profession", getProfession());
		attributes.put("practices", getPractices());
		attributes.put("hired", getHired());
		attributes.put("graduationDate", getGraduationDate());
		attributes.put("activelySeekingEmployment",
			getActivelySeekingEmployment());
		attributes.put("haveExternship", getHaveExternship());
		attributes.put("createDate", getCreateDate());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		String stundetCampusId = (String)attributes.get("stundetCampusId");

		if (stundetCampusId != null) {
			setStundetCampusId(stundetCampusId);
		}

		Long campusId = (Long)attributes.get("campusId");

		if (campusId != null) {
			setCampusId(campusId);
		}

		Long schoolId = (Long)attributes.get("schoolId");

		if (schoolId != null) {
			setSchoolId(schoolId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String middleName = (String)attributes.get("middleName");

		if (middleName != null) {
			setMiddleName(middleName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		Long profileImageId = (Long)attributes.get("profileImageId");

		if (profileImageId != null) {
			setProfileImageId(profileImageId);
		}

		Date dateOfBirth = (Date)attributes.get("dateOfBirth");

		if (dateOfBirth != null) {
			setDateOfBirth(dateOfBirth);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		String homePhoneNumber = (String)attributes.get("homePhoneNumber");

		if (homePhoneNumber != null) {
			setHomePhoneNumber(homePhoneNumber);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String primaryLanguage = (String)attributes.get("primaryLanguage");

		if (primaryLanguage != null) {
			setPrimaryLanguage(primaryLanguage);
		}

		String secondaryLanguage = (String)attributes.get("secondaryLanguage");

		if (secondaryLanguage != null) {
			setSecondaryLanguage(secondaryLanguage);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String zipcode = (String)attributes.get("zipcode");

		if (zipcode != null) {
			setZipcode(zipcode);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String pace = (String)attributes.get("pace");

		if (pace != null) {
			setPace(pace);
		}

		Float gpa = (Float)attributes.get("gpa");

		if (gpa != null) {
			setGpa(gpa);
		}

		Long resumeFileEntryId = (Long)attributes.get("resumeFileEntryId");

		if (resumeFileEntryId != null) {
			setResumeFileEntryId(resumeFileEntryId);
		}

		String profession = (String)attributes.get("profession");

		if (profession != null) {
			setProfession(profession);
		}

		String practices = (String)attributes.get("practices");

		if (practices != null) {
			setPractices(practices);
		}

		Boolean hired = (Boolean)attributes.get("hired");

		if (hired != null) {
			setHired(hired);
		}

		Date graduationDate = (Date)attributes.get("graduationDate");

		if (graduationDate != null) {
			setGraduationDate(graduationDate);
		}

		Boolean activelySeekingEmployment = (Boolean)attributes.get(
				"activelySeekingEmployment");

		if (activelySeekingEmployment != null) {
			setActivelySeekingEmployment(activelySeekingEmployment);
		}

		Boolean haveExternship = (Boolean)attributes.get("haveExternship");

		if (haveExternship != null) {
			setHaveExternship(haveExternship);
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
	public Student toEscapedModel() {
		return new StudentWrapper(_student.toEscapedModel());
	}

	@Override
	public Student toUnescapedModel() {
		return new StudentWrapper(_student.toUnescapedModel());
	}

	/**
	* Returns the actively seeking employment of this student.
	*
	* @return the actively seeking employment of this student
	*/
	@Override
	public boolean getActivelySeekingEmployment() {
		return _student.getActivelySeekingEmployment();
	}

	/**
	* Returns the have externship of this student.
	*
	* @return the have externship of this student
	*/
	@Override
	public boolean getHaveExternship() {
		return _student.getHaveExternship();
	}

	/**
	* Returns the hired of this student.
	*
	* @return the hired of this student
	*/
	@Override
	public boolean getHired() {
		return _student.getHired();
	}

	/**
	* Returns <code>true</code> if this student is actively seeking employment.
	*
	* @return <code>true</code> if this student is actively seeking employment; <code>false</code> otherwise
	*/
	@Override
	public boolean isActivelySeekingEmployment() {
		return _student.isActivelySeekingEmployment();
	}

	@Override
	public boolean isCachedModel() {
		return _student.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _student.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this student is have externship.
	*
	* @return <code>true</code> if this student is have externship; <code>false</code> otherwise
	*/
	@Override
	public boolean isHaveExternship() {
		return _student.isHaveExternship();
	}

	/**
	* Returns <code>true</code> if this student is hired.
	*
	* @return <code>true</code> if this student is hired; <code>false</code> otherwise
	*/
	@Override
	public boolean isHired() {
		return _student.isHired();
	}

	@Override
	public boolean isNew() {
		return _student.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _student.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Student> toCacheModel() {
		return _student.toCacheModel();
	}

	/**
	* Returns the gpa of this student.
	*
	* @return the gpa of this student
	*/
	@Override
	public float getGpa() {
		return _student.getGpa();
	}

	@Override
	public int compareTo(Student student) {
		return _student.compareTo(student);
	}

	@Override
	public int hashCode() {
		return _student.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _student.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new StudentWrapper((Student)_student.clone());
	}

	/**
	* Returns the address of this student.
	*
	* @return the address of this student
	*/
	@Override
	public java.lang.String getAddress() {
		return _student.getAddress();
	}

	/**
	* Returns the city of this student.
	*
	* @return the city of this student
	*/
	@Override
	public java.lang.String getCity() {
		return _student.getCity();
	}

	/**
	* Returns the contact number of this student.
	*
	* @return the contact number of this student
	*/
	@Override
	public java.lang.String getContactNumber() {
		return _student.getContactNumber();
	}

	/**
	* Returns the email address of this student.
	*
	* @return the email address of this student
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _student.getEmailAddress();
	}

	/**
	* Returns the first name of this student.
	*
	* @return the first name of this student
	*/
	@Override
	public java.lang.String getFirstName() {
		return _student.getFirstName();
	}

	/**
	* Returns the gender of this student.
	*
	* @return the gender of this student
	*/
	@Override
	public java.lang.String getGender() {
		return _student.getGender();
	}

	/**
	* Returns the home phone number of this student.
	*
	* @return the home phone number of this student
	*/
	@Override
	public java.lang.String getHomePhoneNumber() {
		return _student.getHomePhoneNumber();
	}

	/**
	* Returns the last name of this student.
	*
	* @return the last name of this student
	*/
	@Override
	public java.lang.String getLastName() {
		return _student.getLastName();
	}

	/**
	* Returns the middle name of this student.
	*
	* @return the middle name of this student
	*/
	@Override
	public java.lang.String getMiddleName() {
		return _student.getMiddleName();
	}

	/**
	* Returns the pace of this student.
	*
	* @return the pace of this student
	*/
	@Override
	public java.lang.String getPace() {
		return _student.getPace();
	}

	/**
	* Returns the practices of this student.
	*
	* @return the practices of this student
	*/
	@Override
	public java.lang.String getPractices() {
		return _student.getPractices();
	}

	/**
	* Returns the primary language of this student.
	*
	* @return the primary language of this student
	*/
	@Override
	public java.lang.String getPrimaryLanguage() {
		return _student.getPrimaryLanguage();
	}

	/**
	* Returns the profession of this student.
	*
	* @return the profession of this student
	*/
	@Override
	public java.lang.String getProfession() {
		return _student.getProfession();
	}

	/**
	* Returns the secondary language of this student.
	*
	* @return the secondary language of this student
	*/
	@Override
	public java.lang.String getSecondaryLanguage() {
		return _student.getSecondaryLanguage();
	}

	/**
	* Returns the state of this student.
	*
	* @return the state of this student
	*/
	@Override
	public java.lang.String getState() {
		return _student.getState();
	}

	/**
	* Returns the stundet campus ID of this student.
	*
	* @return the stundet campus ID of this student
	*/
	@Override
	public java.lang.String getStundetCampusId() {
		return _student.getStundetCampusId();
	}

	/**
	* Returns the uuid of this student.
	*
	* @return the uuid of this student
	*/
	@Override
	public java.lang.String getUuid() {
		return _student.getUuid();
	}

	/**
	* Returns the zipcode of this student.
	*
	* @return the zipcode of this student
	*/
	@Override
	public java.lang.String getZipcode() {
		return _student.getZipcode();
	}

	@Override
	public java.lang.String toString() {
		return _student.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _student.toXmlString();
	}

	/**
	* Returns the create date of this student.
	*
	* @return the create date of this student
	*/
	@Override
	public Date getCreateDate() {
		return _student.getCreateDate();
	}

	/**
	* Returns the date of birth of this student.
	*
	* @return the date of birth of this student
	*/
	@Override
	public Date getDateOfBirth() {
		return _student.getDateOfBirth();
	}

	/**
	* Returns the graduation date of this student.
	*
	* @return the graduation date of this student
	*/
	@Override
	public Date getGraduationDate() {
		return _student.getGraduationDate();
	}

	/**
	* Returns the modified date of this student.
	*
	* @return the modified date of this student
	*/
	@Override
	public Date getModifiedDate() {
		return _student.getModifiedDate();
	}

	/**
	* Returns the campus ID of this student.
	*
	* @return the campus ID of this student
	*/
	@Override
	public long getCampusId() {
		return _student.getCampusId();
	}

	/**
	* Returns the company ID of this student.
	*
	* @return the company ID of this student
	*/
	@Override
	public long getCompanyId() {
		return _student.getCompanyId();
	}

	/**
	* Returns the created by of this student.
	*
	* @return the created by of this student
	*/
	@Override
	public long getCreatedBy() {
		return _student.getCreatedBy();
	}

	/**
	* Returns the modified by of this student.
	*
	* @return the modified by of this student
	*/
	@Override
	public long getModifiedBy() {
		return _student.getModifiedBy();
	}

	/**
	* Returns the primary key of this student.
	*
	* @return the primary key of this student
	*/
	@Override
	public long getPrimaryKey() {
		return _student.getPrimaryKey();
	}

	/**
	* Returns the profile image ID of this student.
	*
	* @return the profile image ID of this student
	*/
	@Override
	public long getProfileImageId() {
		return _student.getProfileImageId();
	}

	/**
	* Returns the resume file entry ID of this student.
	*
	* @return the resume file entry ID of this student
	*/
	@Override
	public long getResumeFileEntryId() {
		return _student.getResumeFileEntryId();
	}

	/**
	* Returns the school ID of this student.
	*
	* @return the school ID of this student
	*/
	@Override
	public long getSchoolId() {
		return _student.getSchoolId();
	}

	/**
	* Returns the student ID of this student.
	*
	* @return the student ID of this student
	*/
	@Override
	public long getStudentId() {
		return _student.getStudentId();
	}

	@Override
	public void persist() {
		_student.persist();
	}

	/**
	* Sets whether this student is actively seeking employment.
	*
	* @param activelySeekingEmployment the actively seeking employment of this student
	*/
	@Override
	public void setActivelySeekingEmployment(boolean activelySeekingEmployment) {
		_student.setActivelySeekingEmployment(activelySeekingEmployment);
	}

	/**
	* Sets the address of this student.
	*
	* @param address the address of this student
	*/
	@Override
	public void setAddress(java.lang.String address) {
		_student.setAddress(address);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_student.setCachedModel(cachedModel);
	}

	/**
	* Sets the campus ID of this student.
	*
	* @param campusId the campus ID of this student
	*/
	@Override
	public void setCampusId(long campusId) {
		_student.setCampusId(campusId);
	}

	/**
	* Sets the city of this student.
	*
	* @param city the city of this student
	*/
	@Override
	public void setCity(java.lang.String city) {
		_student.setCity(city);
	}

	/**
	* Sets the company ID of this student.
	*
	* @param companyId the company ID of this student
	*/
	@Override
	public void setCompanyId(long companyId) {
		_student.setCompanyId(companyId);
	}

	/**
	* Sets the contact number of this student.
	*
	* @param contactNumber the contact number of this student
	*/
	@Override
	public void setContactNumber(java.lang.String contactNumber) {
		_student.setContactNumber(contactNumber);
	}

	/**
	* Sets the create date of this student.
	*
	* @param createDate the create date of this student
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_student.setCreateDate(createDate);
	}

	/**
	* Sets the created by of this student.
	*
	* @param createdBy the created by of this student
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_student.setCreatedBy(createdBy);
	}

	/**
	* Sets the date of birth of this student.
	*
	* @param dateOfBirth the date of birth of this student
	*/
	@Override
	public void setDateOfBirth(Date dateOfBirth) {
		_student.setDateOfBirth(dateOfBirth);
	}

	/**
	* Sets the email address of this student.
	*
	* @param emailAddress the email address of this student
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_student.setEmailAddress(emailAddress);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_student.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_student.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_student.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the first name of this student.
	*
	* @param firstName the first name of this student
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_student.setFirstName(firstName);
	}

	/**
	* Sets the gender of this student.
	*
	* @param gender the gender of this student
	*/
	@Override
	public void setGender(java.lang.String gender) {
		_student.setGender(gender);
	}

	/**
	* Sets the gpa of this student.
	*
	* @param gpa the gpa of this student
	*/
	@Override
	public void setGpa(float gpa) {
		_student.setGpa(gpa);
	}

	/**
	* Sets the graduation date of this student.
	*
	* @param graduationDate the graduation date of this student
	*/
	@Override
	public void setGraduationDate(Date graduationDate) {
		_student.setGraduationDate(graduationDate);
	}

	/**
	* Sets whether this student is have externship.
	*
	* @param haveExternship the have externship of this student
	*/
	@Override
	public void setHaveExternship(boolean haveExternship) {
		_student.setHaveExternship(haveExternship);
	}

	/**
	* Sets whether this student is hired.
	*
	* @param hired the hired of this student
	*/
	@Override
	public void setHired(boolean hired) {
		_student.setHired(hired);
	}

	/**
	* Sets the home phone number of this student.
	*
	* @param homePhoneNumber the home phone number of this student
	*/
	@Override
	public void setHomePhoneNumber(java.lang.String homePhoneNumber) {
		_student.setHomePhoneNumber(homePhoneNumber);
	}

	/**
	* Sets the last name of this student.
	*
	* @param lastName the last name of this student
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_student.setLastName(lastName);
	}

	/**
	* Sets the middle name of this student.
	*
	* @param middleName the middle name of this student
	*/
	@Override
	public void setMiddleName(java.lang.String middleName) {
		_student.setMiddleName(middleName);
	}

	/**
	* Sets the modified by of this student.
	*
	* @param modifiedBy the modified by of this student
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_student.setModifiedBy(modifiedBy);
	}

	/**
	* Sets the modified date of this student.
	*
	* @param modifiedDate the modified date of this student
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_student.setModifiedDate(modifiedDate);
	}

	@Override
	public void setNew(boolean n) {
		_student.setNew(n);
	}

	/**
	* Sets the pace of this student.
	*
	* @param pace the pace of this student
	*/
	@Override
	public void setPace(java.lang.String pace) {
		_student.setPace(pace);
	}

	/**
	* Sets the practices of this student.
	*
	* @param practices the practices of this student
	*/
	@Override
	public void setPractices(java.lang.String practices) {
		_student.setPractices(practices);
	}

	/**
	* Sets the primary key of this student.
	*
	* @param primaryKey the primary key of this student
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_student.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_student.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the primary language of this student.
	*
	* @param primaryLanguage the primary language of this student
	*/
	@Override
	public void setPrimaryLanguage(java.lang.String primaryLanguage) {
		_student.setPrimaryLanguage(primaryLanguage);
	}

	/**
	* Sets the profession of this student.
	*
	* @param profession the profession of this student
	*/
	@Override
	public void setProfession(java.lang.String profession) {
		_student.setProfession(profession);
	}

	/**
	* Sets the profile image ID of this student.
	*
	* @param profileImageId the profile image ID of this student
	*/
	@Override
	public void setProfileImageId(long profileImageId) {
		_student.setProfileImageId(profileImageId);
	}

	/**
	* Sets the resume file entry ID of this student.
	*
	* @param resumeFileEntryId the resume file entry ID of this student
	*/
	@Override
	public void setResumeFileEntryId(long resumeFileEntryId) {
		_student.setResumeFileEntryId(resumeFileEntryId);
	}

	/**
	* Sets the school ID of this student.
	*
	* @param schoolId the school ID of this student
	*/
	@Override
	public void setSchoolId(long schoolId) {
		_student.setSchoolId(schoolId);
	}

	/**
	* Sets the secondary language of this student.
	*
	* @param secondaryLanguage the secondary language of this student
	*/
	@Override
	public void setSecondaryLanguage(java.lang.String secondaryLanguage) {
		_student.setSecondaryLanguage(secondaryLanguage);
	}

	/**
	* Sets the state of this student.
	*
	* @param state the state of this student
	*/
	@Override
	public void setState(java.lang.String state) {
		_student.setState(state);
	}

	/**
	* Sets the student ID of this student.
	*
	* @param studentId the student ID of this student
	*/
	@Override
	public void setStudentId(long studentId) {
		_student.setStudentId(studentId);
	}

	/**
	* Sets the stundet campus ID of this student.
	*
	* @param stundetCampusId the stundet campus ID of this student
	*/
	@Override
	public void setStundetCampusId(java.lang.String stundetCampusId) {
		_student.setStundetCampusId(stundetCampusId);
	}

	/**
	* Sets the uuid of this student.
	*
	* @param uuid the uuid of this student
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_student.setUuid(uuid);
	}

	/**
	* Sets the zipcode of this student.
	*
	* @param zipcode the zipcode of this student
	*/
	@Override
	public void setZipcode(java.lang.String zipcode) {
		_student.setZipcode(zipcode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentWrapper)) {
			return false;
		}

		StudentWrapper studentWrapper = (StudentWrapper)obj;

		if (Objects.equals(_student, studentWrapper._student)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _student.getStagedModelType();
	}

	@Override
	public Student getWrappedModel() {
		return _student;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _student.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _student.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_student.resetOriginalValues();
	}

	private final Student _student;
}