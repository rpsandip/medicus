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

import com.medicus.common.service.model.Employer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Employer in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Employer
 * @generated
 */
@ProviderType
public class EmployerCacheModel implements CacheModel<Employer>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EmployerCacheModel)) {
			return false;
		}

		EmployerCacheModel employerCacheModel = (EmployerCacheModel)obj;

		if (employerId == employerCacheModel.employerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{employerId=");
		sb.append(employerId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", employerOrgId=");
		sb.append(employerOrgId);
		sb.append(", address1=");
		sb.append(address1);
		sb.append(", address2=");
		sb.append(address2);
		sb.append(", city=");
		sb.append(city);
		sb.append(", zipcode=");
		sb.append(zipcode);
		sb.append(", state=");
		sb.append(state);
		sb.append(", country=");
		sb.append(country);
		sb.append(", contactPersonName=");
		sb.append(contactPersonName);
		sb.append(", contactPersonEmail=");
		sb.append(contactPersonEmail);
		sb.append(", contactPersonPhoneNumber=");
		sb.append(contactPersonPhoneNumber);
		sb.append(", websiteLink=");
		sb.append(websiteLink);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Employer toEntityModel() {
		EmployerImpl employerImpl = new EmployerImpl();

		employerImpl.setEmployerId(employerId);
		employerImpl.setUserId(userId);
		employerImpl.setEmployerOrgId(employerOrgId);

		if (address1 == null) {
			employerImpl.setAddress1(StringPool.BLANK);
		}
		else {
			employerImpl.setAddress1(address1);
		}

		if (address2 == null) {
			employerImpl.setAddress2(StringPool.BLANK);
		}
		else {
			employerImpl.setAddress2(address2);
		}

		if (city == null) {
			employerImpl.setCity(StringPool.BLANK);
		}
		else {
			employerImpl.setCity(city);
		}

		if (zipcode == null) {
			employerImpl.setZipcode(StringPool.BLANK);
		}
		else {
			employerImpl.setZipcode(zipcode);
		}

		if (state == null) {
			employerImpl.setState(StringPool.BLANK);
		}
		else {
			employerImpl.setState(state);
		}

		if (country == null) {
			employerImpl.setCountry(StringPool.BLANK);
		}
		else {
			employerImpl.setCountry(country);
		}

		if (contactPersonName == null) {
			employerImpl.setContactPersonName(StringPool.BLANK);
		}
		else {
			employerImpl.setContactPersonName(contactPersonName);
		}

		if (contactPersonEmail == null) {
			employerImpl.setContactPersonEmail(StringPool.BLANK);
		}
		else {
			employerImpl.setContactPersonEmail(contactPersonEmail);
		}

		if (contactPersonPhoneNumber == null) {
			employerImpl.setContactPersonPhoneNumber(StringPool.BLANK);
		}
		else {
			employerImpl.setContactPersonPhoneNumber(contactPersonPhoneNumber);
		}

		if (websiteLink == null) {
			employerImpl.setWebsiteLink(StringPool.BLANK);
		}
		else {
			employerImpl.setWebsiteLink(websiteLink);
		}

		employerImpl.resetOriginalValues();

		return employerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employerId = objectInput.readLong();

		userId = objectInput.readLong();

		employerOrgId = objectInput.readLong();
		address1 = objectInput.readUTF();
		address2 = objectInput.readUTF();
		city = objectInput.readUTF();
		zipcode = objectInput.readUTF();
		state = objectInput.readUTF();
		country = objectInput.readUTF();
		contactPersonName = objectInput.readUTF();
		contactPersonEmail = objectInput.readUTF();
		contactPersonPhoneNumber = objectInput.readUTF();
		websiteLink = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(employerId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(employerOrgId);

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

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (contactPersonName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactPersonName);
		}

		if (contactPersonEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactPersonEmail);
		}

		if (contactPersonPhoneNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactPersonPhoneNumber);
		}

		if (websiteLink == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(websiteLink);
		}
	}

	public long employerId;
	public long userId;
	public long employerOrgId;
	public String address1;
	public String address2;
	public String city;
	public String zipcode;
	public String state;
	public String country;
	public String contactPersonName;
	public String contactPersonEmail;
	public String contactPersonPhoneNumber;
	public String websiteLink;
}