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

import com.medicus.common.service.model.Student;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Student in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Student
 * @generated
 */
@ProviderType
public class StudentCacheModel implements CacheModel<Student>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudentCacheModel)) {
			return false;
		}

		StudentCacheModel studentCacheModel = (StudentCacheModel)obj;

		if (studentId == studentCacheModel.studentId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, studentId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(65);

		sb.append("{studentId=");
		sb.append(studentId);
		sb.append(", stundetCampusId=");
		sb.append(stundetCampusId);
		sb.append(", campusId=");
		sb.append(campusId);
		sb.append(", schoolId=");
		sb.append(schoolId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", middleName=");
		sb.append(middleName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", profileImageId=");
		sb.append(profileImageId);
		sb.append(", dateOfBirth=");
		sb.append(dateOfBirth);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", contactNumber=");
		sb.append(contactNumber);
		sb.append(", homePhoneNumber=");
		sb.append(homePhoneNumber);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", primaryLanguage=");
		sb.append(primaryLanguage);
		sb.append(", secondaryLanguage=");
		sb.append(secondaryLanguage);
		sb.append(", address=");
		sb.append(address);
		sb.append(", city=");
		sb.append(city);
		sb.append(", zipcode=");
		sb.append(zipcode);
		sb.append(", state=");
		sb.append(state);
		sb.append(", pace=");
		sb.append(pace);
		sb.append(", gpa=");
		sb.append(gpa);
		sb.append(", resumeFileEntryId=");
		sb.append(resumeFileEntryId);
		sb.append(", profession=");
		sb.append(profession);
		sb.append(", practices=");
		sb.append(practices);
		sb.append(", hired=");
		sb.append(hired);
		sb.append(", graduationDate=");
		sb.append(graduationDate);
		sb.append(", activelySeekingEmployment=");
		sb.append(activelySeekingEmployment);
		sb.append(", haveExternship=");
		sb.append(haveExternship);
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
	public Student toEntityModel() {
		StudentImpl studentImpl = new StudentImpl();

		studentImpl.setStudentId(studentId);

		if (stundetCampusId == null) {
			studentImpl.setStundetCampusId(StringPool.BLANK);
		}
		else {
			studentImpl.setStundetCampusId(stundetCampusId);
		}

		studentImpl.setCampusId(campusId);
		studentImpl.setSchoolId(schoolId);

		if (firstName == null) {
			studentImpl.setFirstName(StringPool.BLANK);
		}
		else {
			studentImpl.setFirstName(firstName);
		}

		if (middleName == null) {
			studentImpl.setMiddleName(StringPool.BLANK);
		}
		else {
			studentImpl.setMiddleName(middleName);
		}

		if (lastName == null) {
			studentImpl.setLastName(StringPool.BLANK);
		}
		else {
			studentImpl.setLastName(lastName);
		}

		studentImpl.setProfileImageId(profileImageId);

		if (dateOfBirth == Long.MIN_VALUE) {
			studentImpl.setDateOfBirth(null);
		}
		else {
			studentImpl.setDateOfBirth(new Date(dateOfBirth));
		}

		if (gender == null) {
			studentImpl.setGender(StringPool.BLANK);
		}
		else {
			studentImpl.setGender(gender);
		}

		if (contactNumber == null) {
			studentImpl.setContactNumber(StringPool.BLANK);
		}
		else {
			studentImpl.setContactNumber(contactNumber);
		}

		if (homePhoneNumber == null) {
			studentImpl.setHomePhoneNumber(StringPool.BLANK);
		}
		else {
			studentImpl.setHomePhoneNumber(homePhoneNumber);
		}

		if (emailAddress == null) {
			studentImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			studentImpl.setEmailAddress(emailAddress);
		}

		if (primaryLanguage == null) {
			studentImpl.setPrimaryLanguage(StringPool.BLANK);
		}
		else {
			studentImpl.setPrimaryLanguage(primaryLanguage);
		}

		if (secondaryLanguage == null) {
			studentImpl.setSecondaryLanguage(StringPool.BLANK);
		}
		else {
			studentImpl.setSecondaryLanguage(secondaryLanguage);
		}

		if (address == null) {
			studentImpl.setAddress(StringPool.BLANK);
		}
		else {
			studentImpl.setAddress(address);
		}

		if (city == null) {
			studentImpl.setCity(StringPool.BLANK);
		}
		else {
			studentImpl.setCity(city);
		}

		if (zipcode == null) {
			studentImpl.setZipcode(StringPool.BLANK);
		}
		else {
			studentImpl.setZipcode(zipcode);
		}

		if (state == null) {
			studentImpl.setState(StringPool.BLANK);
		}
		else {
			studentImpl.setState(state);
		}

		if (pace == null) {
			studentImpl.setPace(StringPool.BLANK);
		}
		else {
			studentImpl.setPace(pace);
		}

		studentImpl.setGpa(gpa);
		studentImpl.setResumeFileEntryId(resumeFileEntryId);

		if (profession == null) {
			studentImpl.setProfession(StringPool.BLANK);
		}
		else {
			studentImpl.setProfession(profession);
		}

		if (practices == null) {
			studentImpl.setPractices(StringPool.BLANK);
		}
		else {
			studentImpl.setPractices(practices);
		}

		studentImpl.setHired(hired);

		if (graduationDate == Long.MIN_VALUE) {
			studentImpl.setGraduationDate(null);
		}
		else {
			studentImpl.setGraduationDate(new Date(graduationDate));
		}

		studentImpl.setActivelySeekingEmployment(activelySeekingEmployment);
		studentImpl.setHaveExternship(haveExternship);

		if (createDate == Long.MIN_VALUE) {
			studentImpl.setCreateDate(null);
		}
		else {
			studentImpl.setCreateDate(new Date(createDate));
		}

		studentImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			studentImpl.setModifiedDate(null);
		}
		else {
			studentImpl.setModifiedDate(new Date(modifiedDate));
		}

		studentImpl.setModifiedBy(modifiedBy);

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		studentId = objectInput.readLong();
		stundetCampusId = objectInput.readUTF();

		campusId = objectInput.readLong();

		schoolId = objectInput.readLong();
		firstName = objectInput.readUTF();
		middleName = objectInput.readUTF();
		lastName = objectInput.readUTF();

		profileImageId = objectInput.readLong();
		dateOfBirth = objectInput.readLong();
		gender = objectInput.readUTF();
		contactNumber = objectInput.readUTF();
		homePhoneNumber = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		primaryLanguage = objectInput.readUTF();
		secondaryLanguage = objectInput.readUTF();
		address = objectInput.readUTF();
		city = objectInput.readUTF();
		zipcode = objectInput.readUTF();
		state = objectInput.readUTF();
		pace = objectInput.readUTF();

		gpa = objectInput.readFloat();

		resumeFileEntryId = objectInput.readLong();
		profession = objectInput.readUTF();
		practices = objectInput.readUTF();

		hired = objectInput.readBoolean();
		graduationDate = objectInput.readLong();

		activelySeekingEmployment = objectInput.readBoolean();

		haveExternship = objectInput.readBoolean();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(studentId);

		if (stundetCampusId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stundetCampusId);
		}

		objectOutput.writeLong(campusId);

		objectOutput.writeLong(schoolId);

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (middleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(middleName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		objectOutput.writeLong(profileImageId);
		objectOutput.writeLong(dateOfBirth);

		if (gender == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (contactNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactNumber);
		}

		if (homePhoneNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(homePhoneNumber);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (primaryLanguage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(primaryLanguage);
		}

		if (secondaryLanguage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(secondaryLanguage);
		}

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (zipcode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zipcode);
		}

		if (state == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (pace == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pace);
		}

		objectOutput.writeFloat(gpa);

		objectOutput.writeLong(resumeFileEntryId);

		if (profession == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(profession);
		}

		if (practices == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(practices);
		}

		objectOutput.writeBoolean(hired);
		objectOutput.writeLong(graduationDate);

		objectOutput.writeBoolean(activelySeekingEmployment);

		objectOutput.writeBoolean(haveExternship);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long studentId;
	public String stundetCampusId;
	public long campusId;
	public long schoolId;
	public String firstName;
	public String middleName;
	public String lastName;
	public long profileImageId;
	public long dateOfBirth;
	public String gender;
	public String contactNumber;
	public String homePhoneNumber;
	public String emailAddress;
	public String primaryLanguage;
	public String secondaryLanguage;
	public String address;
	public String city;
	public String zipcode;
	public String state;
	public String pace;
	public float gpa;
	public long resumeFileEntryId;
	public String profession;
	public String practices;
	public boolean hired;
	public long graduationDate;
	public boolean activelySeekingEmployment;
	public boolean haveExternship;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}