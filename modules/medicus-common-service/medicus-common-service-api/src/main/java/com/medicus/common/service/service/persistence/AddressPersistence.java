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

package com.medicus.common.service.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.medicus.common.service.exception.NoSuchAddressException;
import com.medicus.common.service.model.Address;

/**
 * The persistence interface for the address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.medicus.common.service.service.persistence.impl.AddressPersistenceImpl
 * @see AddressUtil
 * @generated
 */
@ProviderType
public interface AddressPersistence extends BasePersistence<Address> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AddressUtil} to access the address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the address where userId = &#63; or throws a {@link NoSuchAddressException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching address
	* @throws NoSuchAddressException if a matching address could not be found
	*/
	public Address findByuserId(long userId) throws NoSuchAddressException;

	/**
	* Returns the address where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching address, or <code>null</code> if a matching address could not be found
	*/
	public Address fetchByuserId(long userId);

	/**
	* Returns the address where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching address, or <code>null</code> if a matching address could not be found
	*/
	public Address fetchByuserId(long userId, boolean retrieveFromCache);

	/**
	* Removes the address where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the address that was removed
	*/
	public Address removeByuserId(long userId) throws NoSuchAddressException;

	/**
	* Returns the number of addresses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching addresses
	*/
	public int countByuserId(long userId);

	/**
	* Caches the address in the entity cache if it is enabled.
	*
	* @param address the address
	*/
	public void cacheResult(Address address);

	/**
	* Caches the addresses in the entity cache if it is enabled.
	*
	* @param addresses the addresses
	*/
	public void cacheResult(java.util.List<Address> addresses);

	/**
	* Creates a new address with the primary key. Does not add the address to the database.
	*
	* @param addressId the primary key for the new address
	* @return the new address
	*/
	public Address create(long addressId);

	/**
	* Removes the address with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param addressId the primary key of the address
	* @return the address that was removed
	* @throws NoSuchAddressException if a address with the primary key could not be found
	*/
	public Address remove(long addressId) throws NoSuchAddressException;

	public Address updateImpl(Address address);

	/**
	* Returns the address with the primary key or throws a {@link NoSuchAddressException} if it could not be found.
	*
	* @param addressId the primary key of the address
	* @return the address
	* @throws NoSuchAddressException if a address with the primary key could not be found
	*/
	public Address findByPrimaryKey(long addressId)
		throws NoSuchAddressException;

	/**
	* Returns the address with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param addressId the primary key of the address
	* @return the address, or <code>null</code> if a address with the primary key could not be found
	*/
	public Address fetchByPrimaryKey(long addressId);

	@Override
	public java.util.Map<java.io.Serializable, Address> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the addresses.
	*
	* @return the addresses
	*/
	public java.util.List<Address> findAll();

	/**
	* Returns a range of all the addresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of addresses
	* @param end the upper bound of the range of addresses (not inclusive)
	* @return the range of addresses
	*/
	public java.util.List<Address> findAll(int start, int end);

	/**
	* Returns an ordered range of all the addresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of addresses
	* @param end the upper bound of the range of addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of addresses
	*/
	public java.util.List<Address> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address> orderByComparator);

	/**
	* Returns an ordered range of all the addresses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AddressModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of addresses
	* @param end the upper bound of the range of addresses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of addresses
	*/
	public java.util.List<Address> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Address> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the addresses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of addresses.
	*
	* @return the number of addresses
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}