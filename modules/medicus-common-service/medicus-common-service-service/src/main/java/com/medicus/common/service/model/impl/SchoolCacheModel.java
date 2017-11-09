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

import com.medicus.common.service.model.School;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing School in entity cache.
 *
 * @author sandip.patel
 * @see School
 * @generated
 */
@ProviderType
public class SchoolCacheModel implements CacheModel<School>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SchoolCacheModel)) {
			return false;
		}

		SchoolCacheModel schoolCacheModel = (SchoolCacheModel)obj;

		if (schoolId == schoolCacheModel.schoolId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, schoolId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{schoolId=");
		sb.append(schoolId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", address1=");
		sb.append(address1);
		sb.append(", address2=");
		sb.append(address2);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", country=");
		sb.append(country);
		sb.append(", zipcode=");
		sb.append(zipcode);
		sb.append(", contactNumber=");
		sb.append(contactNumber);
		sb.append(", websiteLink=");
		sb.append(websiteLink);
		sb.append(", contactPersonName=");
		sb.append(contactPersonName);
		sb.append(", contactPersonPhoneNumber=");
		sb.append(contactPersonPhoneNumber);
		sb.append(", contactPersonEmail=");
		sb.append(contactPersonEmail);
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
	public School toEntityModel() {
		SchoolImpl schoolImpl = new SchoolImpl();

		schoolImpl.setSchoolId(schoolId);

		if (name == null) {
			schoolImpl.setName(StringPool.BLANK);
		}
		else {
			schoolImpl.setName(name);
		}

		if (address1 == null) {
			schoolImpl.setAddress1(StringPool.BLANK);
		}
		else {
			schoolImpl.setAddress1(address1);
		}

		if (address2 == null) {
			schoolImpl.setAddress2(StringPool.BLANK);
		}
		else {
			schoolImpl.setAddress2(address2);
		}

		if (city == null) {
			schoolImpl.setCity(StringPool.BLANK);
		}
		else {
			schoolImpl.setCity(city);
		}

		if (state == null) {
			schoolImpl.setState(StringPool.BLANK);
		}
		else {
			schoolImpl.setState(state);
		}

		if (country == null) {
			schoolImpl.setCountry(StringPool.BLANK);
		}
		else {
			schoolImpl.setCountry(country);
		}

		if (zipcode == null) {
			schoolImpl.setZipcode(StringPool.BLANK);
		}
		else {
			schoolImpl.setZipcode(zipcode);
		}

		if (contactNumber == null) {
			schoolImpl.setContactNumber(StringPool.BLANK);
		}
		else {
			schoolImpl.setContactNumber(contactNumber);
		}

		if (websiteLink == null) {
			schoolImpl.setWebsiteLink(StringPool.BLANK);
		}
		else {
			schoolImpl.setWebsiteLink(websiteLink);
		}

		if (contactPersonName == null) {
			schoolImpl.setContactPersonName(StringPool.BLANK);
		}
		else {
			schoolImpl.setContactPersonName(contactPersonName);
		}

		if (contactPersonPhoneNumber == null) {
			schoolImpl.setContactPersonPhoneNumber(StringPool.BLANK);
		}
		else {
			schoolImpl.setContactPersonPhoneNumber(contactPersonPhoneNumber);
		}

		if (contactPersonEmail == null) {
			schoolImpl.setContactPersonEmail(StringPool.BLANK);
		}
		else {
			schoolImpl.setContactPersonEmail(contactPersonEmail);
		}

		schoolImpl.setStatus(status);

		if (createDate == Long.MIN_VALUE) {
			schoolImpl.setCreateDate(null);
		}
		else {
			schoolImpl.setCreateDate(new Date(createDate));
		}

		schoolImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			schoolImpl.setModifiedDate(null);
		}
		else {
			schoolImpl.setModifiedDate(new Date(modifiedDate));
		}

		schoolImpl.setModifiedBy(modifiedBy);

		schoolImpl.resetOriginalValues();

		return schoolImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		schoolId = objectInput.readLong();
		name = objectInput.readUTF();
		address1 = objectInput.readUTF();
		address2 = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();
		country = objectInput.readUTF();
		zipcode = objectInput.readUTF();
		contactNumber = objectInput.readUTF();
		websiteLink = objectInput.readUTF();
		contactPersonName = objectInput.readUTF();
		contactPersonPhoneNumber = objectInput.readUTF();
		contactPersonEmail = objectInput.readUTF();

		status = objectInput.readInt();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(schoolId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (address1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address1);
		}

		if (address2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address2);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (state == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (zipcode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(zipcode);
		}

		if (contactNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactNumber);
		}

		if (websiteLink == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(websiteLink);
		}

		if (contactPersonName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactPersonName);
		}

		if (contactPersonPhoneNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactPersonPhoneNumber);
		}

		if (contactPersonEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactPersonEmail);
		}

		objectOutput.writeInt(status);
		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long schoolId;
	public String name;
	public String address1;
	public String address2;
	public String city;
	public String state;
	public String country;
	public String zipcode;
	public String contactNumber;
	public String websiteLink;
	public String contactPersonName;
	public String contactPersonPhoneNumber;
	public String contactPersonEmail;
	public int status;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}