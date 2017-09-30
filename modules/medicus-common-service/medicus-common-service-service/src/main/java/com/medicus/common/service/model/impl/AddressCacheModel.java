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

import com.medicus.common.service.model.Address;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Address in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Address
 * @generated
 */
@ProviderType
public class AddressCacheModel implements CacheModel<Address>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddressCacheModel)) {
			return false;
		}

		AddressCacheModel addressCacheModel = (AddressCacheModel)obj;

		if (addressId == addressCacheModel.addressId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, addressId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{addressId=");
		sb.append(addressId);
		sb.append(", userId=");
		sb.append(userId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Address toEntityModel() {
		AddressImpl addressImpl = new AddressImpl();

		addressImpl.setAddressId(addressId);
		addressImpl.setUserId(userId);

		if (address1 == null) {
			addressImpl.setAddress1(StringPool.BLANK);
		}
		else {
			addressImpl.setAddress1(address1);
		}

		if (address2 == null) {
			addressImpl.setAddress2(StringPool.BLANK);
		}
		else {
			addressImpl.setAddress2(address2);
		}

		if (city == null) {
			addressImpl.setCity(StringPool.BLANK);
		}
		else {
			addressImpl.setCity(city);
		}

		if (zipcode == null) {
			addressImpl.setZipcode(StringPool.BLANK);
		}
		else {
			addressImpl.setZipcode(zipcode);
		}

		if (state == null) {
			addressImpl.setState(StringPool.BLANK);
		}
		else {
			addressImpl.setState(state);
		}

		if (country == null) {
			addressImpl.setCountry(StringPool.BLANK);
		}
		else {
			addressImpl.setCountry(country);
		}

		addressImpl.resetOriginalValues();

		return addressImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		addressId = objectInput.readLong();

		userId = objectInput.readLong();
		address1 = objectInput.readUTF();
		address2 = objectInput.readUTF();
		city = objectInput.readUTF();
		zipcode = objectInput.readUTF();
		state = objectInput.readUTF();
		country = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(addressId);

		objectOutput.writeLong(userId);

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
	}

	public long addressId;
	public long userId;
	public String address1;
	public String address2;
	public String city;
	public String zipcode;
	public String state;
	public String country;
}