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

import com.medicus.common.service.exception.NoSuchPartnerException;
import com.medicus.common.service.model.Partner;

/**
 * The persistence interface for the partner service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sandip.patel
 * @see com.medicus.common.service.service.persistence.impl.PartnerPersistenceImpl
 * @see PartnerUtil
 * @generated
 */
@ProviderType
public interface PartnerPersistence extends BasePersistence<Partner> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PartnerUtil} to access the partner persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the partner where userId = &#63; or throws a {@link NoSuchPartnerException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching partner
	* @throws NoSuchPartnerException if a matching partner could not be found
	*/
	public Partner findByuserId(long userId) throws NoSuchPartnerException;

	/**
	* Returns the partner where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching partner, or <code>null</code> if a matching partner could not be found
	*/
	public Partner fetchByuserId(long userId);

	/**
	* Returns the partner where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching partner, or <code>null</code> if a matching partner could not be found
	*/
	public Partner fetchByuserId(long userId, boolean retrieveFromCache);

	/**
	* Removes the partner where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the partner that was removed
	*/
	public Partner removeByuserId(long userId) throws NoSuchPartnerException;

	/**
	* Returns the number of partners where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching partners
	*/
	public int countByuserId(long userId);

	/**
	* Caches the partner in the entity cache if it is enabled.
	*
	* @param partner the partner
	*/
	public void cacheResult(Partner partner);

	/**
	* Caches the partners in the entity cache if it is enabled.
	*
	* @param partners the partners
	*/
	public void cacheResult(java.util.List<Partner> partners);

	/**
	* Creates a new partner with the primary key. Does not add the partner to the database.
	*
	* @param partnerId the primary key for the new partner
	* @return the new partner
	*/
	public Partner create(long partnerId);

	/**
	* Removes the partner with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param partnerId the primary key of the partner
	* @return the partner that was removed
	* @throws NoSuchPartnerException if a partner with the primary key could not be found
	*/
	public Partner remove(long partnerId) throws NoSuchPartnerException;

	public Partner updateImpl(Partner partner);

	/**
	* Returns the partner with the primary key or throws a {@link NoSuchPartnerException} if it could not be found.
	*
	* @param partnerId the primary key of the partner
	* @return the partner
	* @throws NoSuchPartnerException if a partner with the primary key could not be found
	*/
	public Partner findByPrimaryKey(long partnerId)
		throws NoSuchPartnerException;

	/**
	* Returns the partner with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param partnerId the primary key of the partner
	* @return the partner, or <code>null</code> if a partner with the primary key could not be found
	*/
	public Partner fetchByPrimaryKey(long partnerId);

	@Override
	public java.util.Map<java.io.Serializable, Partner> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the partners.
	*
	* @return the partners
	*/
	public java.util.List<Partner> findAll();

	/**
	* Returns a range of all the partners.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PartnerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of partners
	* @param end the upper bound of the range of partners (not inclusive)
	* @return the range of partners
	*/
	public java.util.List<Partner> findAll(int start, int end);

	/**
	* Returns an ordered range of all the partners.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PartnerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of partners
	* @param end the upper bound of the range of partners (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of partners
	*/
	public java.util.List<Partner> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Partner> orderByComparator);

	/**
	* Returns an ordered range of all the partners.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link PartnerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of partners
	* @param end the upper bound of the range of partners (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of partners
	*/
	public java.util.List<Partner> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Partner> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the partners from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of partners.
	*
	* @return the number of partners
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}