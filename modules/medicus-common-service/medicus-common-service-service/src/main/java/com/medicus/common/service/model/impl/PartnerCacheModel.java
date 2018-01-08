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

import com.medicus.common.service.model.Partner;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Partner in entity cache.
 *
 * @author sandip.patel
 * @see Partner
 * @generated
 */
@ProviderType
public class PartnerCacheModel implements CacheModel<Partner>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PartnerCacheModel)) {
			return false;
		}

		PartnerCacheModel partnerCacheModel = (PartnerCacheModel)obj;

		if (partnerId == partnerCacheModel.partnerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, partnerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{partnerId=");
		sb.append(partnerId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", partnerOrgId=");
		sb.append(partnerOrgId);
		sb.append(", address1=");
		sb.append(address1);
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
	public Partner toEntityModel() {
		PartnerImpl partnerImpl = new PartnerImpl();

		partnerImpl.setPartnerId(partnerId);
		partnerImpl.setUserId(userId);
		partnerImpl.setPartnerOrgId(partnerOrgId);

		if (address1 == null) {
			partnerImpl.setAddress1(StringPool.BLANK);
		}
		else {
			partnerImpl.setAddress1(address1);
		}

		if (city == null) {
			partnerImpl.setCity(StringPool.BLANK);
		}
		else {
			partnerImpl.setCity(city);
		}

		if (zipcode == null) {
			partnerImpl.setZipcode(StringPool.BLANK);
		}
		else {
			partnerImpl.setZipcode(zipcode);
		}

		if (state == null) {
			partnerImpl.setState(StringPool.BLANK);
		}
		else {
			partnerImpl.setState(state);
		}

		if (country == null) {
			partnerImpl.setCountry(StringPool.BLANK);
		}
		else {
			partnerImpl.setCountry(country);
		}

		if (contactPersonName == null) {
			partnerImpl.setContactPersonName(StringPool.BLANK);
		}
		else {
			partnerImpl.setContactPersonName(contactPersonName);
		}

		if (contactPersonEmail == null) {
			partnerImpl.setContactPersonEmail(StringPool.BLANK);
		}
		else {
			partnerImpl.setContactPersonEmail(contactPersonEmail);
		}

		if (contactPersonPhoneNumber == null) {
			partnerImpl.setContactPersonPhoneNumber(StringPool.BLANK);
		}
		else {
			partnerImpl.setContactPersonPhoneNumber(contactPersonPhoneNumber);
		}

		if (websiteLink == null) {
			partnerImpl.setWebsiteLink(StringPool.BLANK);
		}
		else {
			partnerImpl.setWebsiteLink(websiteLink);
		}

		if (createDate == Long.MIN_VALUE) {
			partnerImpl.setCreateDate(null);
		}
		else {
			partnerImpl.setCreateDate(new Date(createDate));
		}

		partnerImpl.setCreatedBy(createdBy);

		if (modifiedDate == Long.MIN_VALUE) {
			partnerImpl.setModifiedDate(null);
		}
		else {
			partnerImpl.setModifiedDate(new Date(modifiedDate));
		}

		partnerImpl.setModifiedBy(modifiedBy);

		partnerImpl.resetOriginalValues();

		return partnerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		partnerId = objectInput.readLong();

		userId = objectInput.readLong();

		partnerOrgId = objectInput.readLong();
		address1 = objectInput.readUTF();
		city = objectInput.readUTF();
		zipcode = objectInput.readUTF();
		state = objectInput.readUTF();
		country = objectInput.readUTF();
		contactPersonName = objectInput.readUTF();
		contactPersonEmail = objectInput.readUTF();
		contactPersonPhoneNumber = objectInput.readUTF();
		websiteLink = objectInput.readUTF();
		createDate = objectInput.readLong();

		createdBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		modifiedBy = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(partnerId);

		objectOutput.writeLong(userId);

		objectOutput.writeLong(partnerOrgId);

		if (address1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address1);
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

		objectOutput.writeLong(createDate);

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeLong(modifiedBy);
	}

	public long partnerId;
	public long userId;
	public long partnerOrgId;
	public String address1;
	public String city;
	public String zipcode;
	public String state;
	public String country;
	public String contactPersonName;
	public String contactPersonEmail;
	public String contactPersonPhoneNumber;
	public String websiteLink;
	public long createDate;
	public long createdBy;
	public long modifiedDate;
	public long modifiedBy;
}