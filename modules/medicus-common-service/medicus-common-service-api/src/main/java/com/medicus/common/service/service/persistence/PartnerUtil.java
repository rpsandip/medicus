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

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.medicus.common.service.model.Partner;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the partner service. This utility wraps {@link com.medicus.common.service.service.persistence.impl.PartnerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sandip.patel
 * @see PartnerPersistence
 * @see com.medicus.common.service.service.persistence.impl.PartnerPersistenceImpl
 * @generated
 */
@ProviderType
public class PartnerUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Partner partner) {
		getPersistence().clearCache(partner);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Partner> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Partner> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Partner> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Partner> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Partner update(Partner partner) {
		return getPersistence().update(partner);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Partner update(Partner partner, ServiceContext serviceContext) {
		return getPersistence().update(partner, serviceContext);
	}

	/**
	* Returns the partner where userId = &#63; or throws a {@link NoSuchPartnerException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching partner
	* @throws NoSuchPartnerException if a matching partner could not be found
	*/
	public static Partner findByuserId(long userId)
		throws com.medicus.common.service.exception.NoSuchPartnerException {
		return getPersistence().findByuserId(userId);
	}

	/**
	* Returns the partner where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching partner, or <code>null</code> if a matching partner could not be found
	*/
	public static Partner fetchByuserId(long userId) {
		return getPersistence().fetchByuserId(userId);
	}

	/**
	* Returns the partner where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching partner, or <code>null</code> if a matching partner could not be found
	*/
	public static Partner fetchByuserId(long userId, boolean retrieveFromCache) {
		return getPersistence().fetchByuserId(userId, retrieveFromCache);
	}

	/**
	* Removes the partner where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the partner that was removed
	*/
	public static Partner removeByuserId(long userId)
		throws com.medicus.common.service.exception.NoSuchPartnerException {
		return getPersistence().removeByuserId(userId);
	}

	/**
	* Returns the number of partners where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching partners
	*/
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	* Caches the partner in the entity cache if it is enabled.
	*
	* @param partner the partner
	*/
	public static void cacheResult(Partner partner) {
		getPersistence().cacheResult(partner);
	}

	/**
	* Caches the partners in the entity cache if it is enabled.
	*
	* @param partners the partners
	*/
	public static void cacheResult(List<Partner> partners) {
		getPersistence().cacheResult(partners);
	}

	/**
	* Creates a new partner with the primary key. Does not add the partner to the database.
	*
	* @param partnerId the primary key for the new partner
	* @return the new partner
	*/
	public static Partner create(long partnerId) {
		return getPersistence().create(partnerId);
	}

	/**
	* Removes the partner with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param partnerId the primary key of the partner
	* @return the partner that was removed
	* @throws NoSuchPartnerException if a partner with the primary key could not be found
	*/
	public static Partner remove(long partnerId)
		throws com.medicus.common.service.exception.NoSuchPartnerException {
		return getPersistence().remove(partnerId);
	}

	public static Partner updateImpl(Partner partner) {
		return getPersistence().updateImpl(partner);
	}

	/**
	* Returns the partner with the primary key or throws a {@link NoSuchPartnerException} if it could not be found.
	*
	* @param partnerId the primary key of the partner
	* @return the partner
	* @throws NoSuchPartnerException if a partner with the primary key could not be found
	*/
	public static Partner findByPrimaryKey(long partnerId)
		throws com.medicus.common.service.exception.NoSuchPartnerException {
		return getPersistence().findByPrimaryKey(partnerId);
	}

	/**
	* Returns the partner with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param partnerId the primary key of the partner
	* @return the partner, or <code>null</code> if a partner with the primary key could not be found
	*/
	public static Partner fetchByPrimaryKey(long partnerId) {
		return getPersistence().fetchByPrimaryKey(partnerId);
	}

	public static java.util.Map<java.io.Serializable, Partner> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the partners.
	*
	* @return the partners
	*/
	public static List<Partner> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Partner> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Partner> findAll(int start, int end,
		OrderByComparator<Partner> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Partner> findAll(int start, int end,
		OrderByComparator<Partner> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the partners from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of partners.
	*
	* @return the number of partners
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static PartnerPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<PartnerPersistence, PartnerPersistence> _serviceTracker =
		ServiceTrackerFactory.open(PartnerPersistence.class);
}