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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Address}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Address
 * @generated
 */
@ProviderType
public class AddressWrapper implements Address, ModelWrapper<Address> {
	public AddressWrapper(Address address) {
		_address = address;
	}

	@Override
	public Class<?> getModelClass() {
		return Address.class;
	}

	@Override
	public String getModelClassName() {
		return Address.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addressId", getAddressId());
		attributes.put("userId", getUserId());
		attributes.put("address1", getAddress1());
		attributes.put("address2", getAddress2());
		attributes.put("city", getCity());
		attributes.put("zipcode", getZipcode());
		attributes.put("state", getState());
		attributes.put("country", getCountry());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addressId = (Long)attributes.get("addressId");

		if (addressId != null) {
			setAddressId(addressId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String address1 = (String)attributes.get("address1");

		if (address1 != null) {
			setAddress1(address1);
		}

		String address2 = (String)attributes.get("address2");

		if (address2 != null) {
			setAddress2(address2);
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

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}
	}

	@Override
	public Address toEscapedModel() {
		return new AddressWrapper(_address.toEscapedModel());
	}

	@Override
	public Address toUnescapedModel() {
		return new AddressWrapper(_address.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _address.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _address.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _address.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _address.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Address> toCacheModel() {
		return _address.toCacheModel();
	}

	@Override
	public int compareTo(Address address) {
		return _address.compareTo(address);
	}

	@Override
	public int hashCode() {
		return _address.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _address.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new AddressWrapper((Address)_address.clone());
	}

	/**
	* Returns the address1 of this address.
	*
	* @return the address1 of this address
	*/
	@Override
	public java.lang.String getAddress1() {
		return _address.getAddress1();
	}

	/**
	* Returns the address2 of this address.
	*
	* @return the address2 of this address
	*/
	@Override
	public java.lang.String getAddress2() {
		return _address.getAddress2();
	}

	/**
	* Returns the city of this address.
	*
	* @return the city of this address
	*/
	@Override
	public java.lang.String getCity() {
		return _address.getCity();
	}

	/**
	* Returns the country of this address.
	*
	* @return the country of this address
	*/
	@Override
	public java.lang.String getCountry() {
		return _address.getCountry();
	}

	/**
	* Returns the state of this address.
	*
	* @return the state of this address
	*/
	@Override
	public java.lang.String getState() {
		return _address.getState();
	}

	/**
	* Returns the user uuid of this address.
	*
	* @return the user uuid of this address
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _address.getUserUuid();
	}

	/**
	* Returns the zipcode of this address.
	*
	* @return the zipcode of this address
	*/
	@Override
	public java.lang.String getZipcode() {
		return _address.getZipcode();
	}

	@Override
	public java.lang.String toString() {
		return _address.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _address.toXmlString();
	}

	/**
	* Returns the address ID of this address.
	*
	* @return the address ID of this address
	*/
	@Override
	public long getAddressId() {
		return _address.getAddressId();
	}

	/**
	* Returns the primary key of this address.
	*
	* @return the primary key of this address
	*/
	@Override
	public long getPrimaryKey() {
		return _address.getPrimaryKey();
	}

	/**
	* Returns the user ID of this address.
	*
	* @return the user ID of this address
	*/
	@Override
	public long getUserId() {
		return _address.getUserId();
	}

	@Override
	public void persist() {
		_address.persist();
	}

	/**
	* Sets the address1 of this address.
	*
	* @param address1 the address1 of this address
	*/
	@Override
	public void setAddress1(java.lang.String address1) {
		_address.setAddress1(address1);
	}

	/**
	* Sets the address2 of this address.
	*
	* @param address2 the address2 of this address
	*/
	@Override
	public void setAddress2(java.lang.String address2) {
		_address.setAddress2(address2);
	}

	/**
	* Sets the address ID of this address.
	*
	* @param addressId the address ID of this address
	*/
	@Override
	public void setAddressId(long addressId) {
		_address.setAddressId(addressId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_address.setCachedModel(cachedModel);
	}

	/**
	* Sets the city of this address.
	*
	* @param city the city of this address
	*/
	@Override
	public void setCity(java.lang.String city) {
		_address.setCity(city);
	}

	/**
	* Sets the country of this address.
	*
	* @param country the country of this address
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_address.setCountry(country);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_address.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_address.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_address.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_address.setNew(n);
	}

	/**
	* Sets the primary key of this address.
	*
	* @param primaryKey the primary key of this address
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_address.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_address.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the state of this address.
	*
	* @param state the state of this address
	*/
	@Override
	public void setState(java.lang.String state) {
		_address.setState(state);
	}

	/**
	* Sets the user ID of this address.
	*
	* @param userId the user ID of this address
	*/
	@Override
	public void setUserId(long userId) {
		_address.setUserId(userId);
	}

	/**
	* Sets the user uuid of this address.
	*
	* @param userUuid the user uuid of this address
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_address.setUserUuid(userUuid);
	}

	/**
	* Sets the zipcode of this address.
	*
	* @param zipcode the zipcode of this address
	*/
	@Override
	public void setZipcode(java.lang.String zipcode) {
		_address.setZipcode(zipcode);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AddressWrapper)) {
			return false;
		}

		AddressWrapper addressWrapper = (AddressWrapper)obj;

		if (Objects.equals(_address, addressWrapper._address)) {
			return true;
		}

		return false;
	}

	@Override
	public Address getWrappedModel() {
		return _address;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _address.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _address.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_address.resetOriginalValues();
	}

	private final Address _address;
}