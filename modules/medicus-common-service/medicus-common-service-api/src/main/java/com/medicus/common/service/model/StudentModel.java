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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Student service. Represents a row in the &quot;Medicus_Student&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.medicus.common.service.model.impl.StudentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.medicus.common.service.model.impl.StudentImpl}.
 * </p>
 *
 * @author sandip.patel
 * @see Student
 * @see com.medicus.common.service.model.impl.StudentImpl
 * @see com.medicus.common.service.model.impl.StudentModelImpl
 * @generated
 */
@ProviderType
public interface StudentModel extends BaseModel<Student>, ShardedModel,
	StagedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a student model instance should use the {@link Student} interface instead.
	 */

	/**
	 * Returns the primary key of this student.
	 *
	 * @return the primary key of this student
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this student.
	 *
	 * @param primaryKey the primary key of this student
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this student.
	 *
	 * @return the uuid of this student
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this student.
	 *
	 * @param uuid the uuid of this student
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the student ID of this student.
	 *
	 * @return the student ID of this student
	 */
	public long getStudentId();

	/**
	 * Sets the student ID of this student.
	 *
	 * @param studentId the student ID of this student
	 */
	public void setStudentId(long studentId);

	/**
	 * Returns the company ID of this student.
	 *
	 * @return the company ID of this student
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this student.
	 *
	 * @param companyId the company ID of this student
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the stundet campus ID of this student.
	 *
	 * @return the stundet campus ID of this student
	 */
	@AutoEscape
	public String getStundetCampusId();

	/**
	 * Sets the stundet campus ID of this student.
	 *
	 * @param stundetCampusId the stundet campus ID of this student
	 */
	public void setStundetCampusId(String stundetCampusId);

	/**
	 * Returns the campus ID of this student.
	 *
	 * @return the campus ID of this student
	 */
	public long getCampusId();

	/**
	 * Sets the campus ID of this student.
	 *
	 * @param campusId the campus ID of this student
	 */
	public void setCampusId(long campusId);

	/**
	 * Returns the school ID of this student.
	 *
	 * @return the school ID of this student
	 */
	public long getSchoolId();

	/**
	 * Sets the school ID of this student.
	 *
	 * @param schoolId the school ID of this student
	 */
	public void setSchoolId(long schoolId);

	/**
	 * Returns the first name of this student.
	 *
	 * @return the first name of this student
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this student.
	 *
	 * @param firstName the first name of this student
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the middle name of this student.
	 *
	 * @return the middle name of this student
	 */
	@AutoEscape
	public String getMiddleName();

	/**
	 * Sets the middle name of this student.
	 *
	 * @param middleName the middle name of this student
	 */
	public void setMiddleName(String middleName);

	/**
	 * Returns the last name of this student.
	 *
	 * @return the last name of this student
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this student.
	 *
	 * @param lastName the last name of this student
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the profile image ID of this student.
	 *
	 * @return the profile image ID of this student
	 */
	public long getProfileImageId();

	/**
	 * Sets the profile image ID of this student.
	 *
	 * @param profileImageId the profile image ID of this student
	 */
	public void setProfileImageId(long profileImageId);

	/**
	 * Returns the date of birth of this student.
	 *
	 * @return the date of birth of this student
	 */
	public Date getDateOfBirth();

	/**
	 * Sets the date of birth of this student.
	 *
	 * @param dateOfBirth the date of birth of this student
	 */
	public void setDateOfBirth(Date dateOfBirth);

	/**
	 * Returns the gender of this student.
	 *
	 * @return the gender of this student
	 */
	@AutoEscape
	public String getGender();

	/**
	 * Sets the gender of this student.
	 *
	 * @param gender the gender of this student
	 */
	public void setGender(String gender);

	/**
	 * Returns the contact number of this student.
	 *
	 * @return the contact number of this student
	 */
	@AutoEscape
	public String getContactNumber();

	/**
	 * Sets the contact number of this student.
	 *
	 * @param contactNumber the contact number of this student
	 */
	public void setContactNumber(String contactNumber);

	/**
	 * Returns the home phone number of this student.
	 *
	 * @return the home phone number of this student
	 */
	@AutoEscape
	public String getHomePhoneNumber();

	/**
	 * Sets the home phone number of this student.
	 *
	 * @param homePhoneNumber the home phone number of this student
	 */
	public void setHomePhoneNumber(String homePhoneNumber);

	/**
	 * Returns the email address of this student.
	 *
	 * @return the email address of this student
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this student.
	 *
	 * @param emailAddress the email address of this student
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Returns the primary language of this student.
	 *
	 * @return the primary language of this student
	 */
	@AutoEscape
	public String getPrimaryLanguage();

	/**
	 * Sets the primary language of this student.
	 *
	 * @param primaryLanguage the primary language of this student
	 */
	public void setPrimaryLanguage(String primaryLanguage);

	/**
	 * Returns the secondary language of this student.
	 *
	 * @return the secondary language of this student
	 */
	@AutoEscape
	public String getSecondaryLanguage();

	/**
	 * Sets the secondary language of this student.
	 *
	 * @param secondaryLanguage the secondary language of this student
	 */
	public void setSecondaryLanguage(String secondaryLanguage);

	/**
	 * Returns the address of this student.
	 *
	 * @return the address of this student
	 */
	@AutoEscape
	public String getAddress();

	/**
	 * Sets the address of this student.
	 *
	 * @param address the address of this student
	 */
	public void setAddress(String address);

	/**
	 * Returns the city of this student.
	 *
	 * @return the city of this student
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this student.
	 *
	 * @param city the city of this student
	 */
	public void setCity(String city);

	/**
	 * Returns the zipcode of this student.
	 *
	 * @return the zipcode of this student
	 */
	@AutoEscape
	public String getZipcode();

	/**
	 * Sets the zipcode of this student.
	 *
	 * @param zipcode the zipcode of this student
	 */
	public void setZipcode(String zipcode);

	/**
	 * Returns the state of this student.
	 *
	 * @return the state of this student
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this student.
	 *
	 * @param state the state of this student
	 */
	public void setState(String state);

	/**
	 * Returns the pace of this student.
	 *
	 * @return the pace of this student
	 */
	@AutoEscape
	public String getPace();

	/**
	 * Sets the pace of this student.
	 *
	 * @param pace the pace of this student
	 */
	public void setPace(String pace);

	/**
	 * Returns the ethnicity desc of this student.
	 *
	 * @return the ethnicity desc of this student
	 */
	@AutoEscape
	public String getEthnicityDesc();

	/**
	 * Sets the ethnicity desc of this student.
	 *
	 * @param ethnicityDesc the ethnicity desc of this student
	 */
	public void setEthnicityDesc(String ethnicityDesc);

	/**
	 * Returns the gpa of this student.
	 *
	 * @return the gpa of this student
	 */
	public float getGpa();

	/**
	 * Sets the gpa of this student.
	 *
	 * @param gpa the gpa of this student
	 */
	public void setGpa(float gpa);

	/**
	 * Returns the resume file entry ID of this student.
	 *
	 * @return the resume file entry ID of this student
	 */
	public long getResumeFileEntryId();

	/**
	 * Sets the resume file entry ID of this student.
	 *
	 * @param resumeFileEntryId the resume file entry ID of this student
	 */
	public void setResumeFileEntryId(long resumeFileEntryId);

	/**
	 * Returns the profession of this student.
	 *
	 * @return the profession of this student
	 */
	@AutoEscape
	public String getProfession();

	/**
	 * Sets the profession of this student.
	 *
	 * @param profession the profession of this student
	 */
	public void setProfession(String profession);

	/**
	 * Returns the practices of this student.
	 *
	 * @return the practices of this student
	 */
	@AutoEscape
	public String getPractices();

	/**
	 * Sets the practices of this student.
	 *
	 * @param practices the practices of this student
	 */
	public void setPractices(String practices);

	/**
	 * Returns the hired of this student.
	 *
	 * @return the hired of this student
	 */
	public boolean getHired();

	/**
	 * Returns <code>true</code> if this student is hired.
	 *
	 * @return <code>true</code> if this student is hired; <code>false</code> otherwise
	 */
	public boolean isHired();

	/**
	 * Sets whether this student is hired.
	 *
	 * @param hired the hired of this student
	 */
	public void setHired(boolean hired);

	/**
	 * Returns the graduation date of this student.
	 *
	 * @return the graduation date of this student
	 */
	public Date getGraduationDate();

	/**
	 * Sets the graduation date of this student.
	 *
	 * @param graduationDate the graduation date of this student
	 */
	public void setGraduationDate(Date graduationDate);

	/**
	 * Returns the actively seeking employment of this student.
	 *
	 * @return the actively seeking employment of this student
	 */
	public boolean getActivelySeekingEmployment();

	/**
	 * Returns <code>true</code> if this student is actively seeking employment.
	 *
	 * @return <code>true</code> if this student is actively seeking employment; <code>false</code> otherwise
	 */
	public boolean isActivelySeekingEmployment();

	/**
	 * Sets whether this student is actively seeking employment.
	 *
	 * @param activelySeekingEmployment the actively seeking employment of this student
	 */
	public void setActivelySeekingEmployment(boolean activelySeekingEmployment);

	/**
	 * Returns the have externship of this student.
	 *
	 * @return the have externship of this student
	 */
	public boolean getHaveExternship();

	/**
	 * Returns <code>true</code> if this student is have externship.
	 *
	 * @return <code>true</code> if this student is have externship; <code>false</code> otherwise
	 */
	public boolean isHaveExternship();

	/**
	 * Sets whether this student is have externship.
	 *
	 * @param haveExternship the have externship of this student
	 */
	public void setHaveExternship(boolean haveExternship);

	/**
	 * Returns the status of this student.
	 *
	 * @return the status of this student
	 */
	public int getStatus();

	/**
	 * Sets the status of this student.
	 *
	 * @param status the status of this student
	 */
	public void setStatus(int status);

	/**
	 * Returns the create date of this student.
	 *
	 * @return the create date of this student
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this student.
	 *
	 * @param createDate the create date of this student
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the created by of this student.
	 *
	 * @return the created by of this student
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this student.
	 *
	 * @param createdBy the created by of this student
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the modified date of this student.
	 *
	 * @return the modified date of this student
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this student.
	 *
	 * @param modifiedDate the modified date of this student
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the modified by of this student.
	 *
	 * @return the modified by of this student
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this student.
	 *
	 * @param modifiedBy the modified by of this student
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
	public int compareTo(Student student);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Student> toCacheModel();

	@Override
	public Student toEscapedModel();

	@Override
	public Student toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}