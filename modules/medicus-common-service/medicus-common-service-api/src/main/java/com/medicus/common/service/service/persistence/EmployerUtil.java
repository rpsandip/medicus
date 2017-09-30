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

import com.medicus.common.service.model.Employer;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the employer service. This utility wraps {@link com.medicus.common.service.service.persistence.impl.EmployerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmployerPersistence
 * @see com.medicus.common.service.service.persistence.impl.EmployerPersistenceImpl
 * @generated
 */
@ProviderType
public class EmployerUtil {
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
	public static void clearCache(Employer employer) {
		getPersistence().clearCache(employer);
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
	public static List<Employer> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Employer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Employer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Employer> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Employer update(Employer employer) {
		return getPersistence().update(employer);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Employer update(Employer employer,
		ServiceContext serviceContext) {
		return getPersistence().update(employer, serviceContext);
	}

	/**
	* Returns the employer where userId = &#63; or throws a {@link NoSuchEmployerException} if it could not be found.
	*
	* @param userId the user ID
	* @return the matching employer
	* @throws NoSuchEmployerException if a matching employer could not be found
	*/
	public static Employer findByuserId(long userId)
		throws com.medicus.common.service.exception.NoSuchEmployerException {
		return getPersistence().findByuserId(userId);
	}

	/**
	* Returns the employer where userId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @return the matching employer, or <code>null</code> if a matching employer could not be found
	*/
	public static Employer fetchByuserId(long userId) {
		return getPersistence().fetchByuserId(userId);
	}

	/**
	* Returns the employer where userId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching employer, or <code>null</code> if a matching employer could not be found
	*/
	public static Employer fetchByuserId(long userId, boolean retrieveFromCache) {
		return getPersistence().fetchByuserId(userId, retrieveFromCache);
	}

	/**
	* Removes the employer where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @return the employer that was removed
	*/
	public static Employer removeByuserId(long userId)
		throws com.medicus.common.service.exception.NoSuchEmployerException {
		return getPersistence().removeByuserId(userId);
	}

	/**
	* Returns the number of employers where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching employers
	*/
	public static int countByuserId(long userId) {
		return getPersistence().countByuserId(userId);
	}

	/**
	* Caches the employer in the entity cache if it is enabled.
	*
	* @param employer the employer
	*/
	public static void cacheResult(Employer employer) {
		getPersistence().cacheResult(employer);
	}

	/**
	* Caches the employers in the entity cache if it is enabled.
	*
	* @param employers the employers
	*/
	public static void cacheResult(List<Employer> employers) {
		getPersistence().cacheResult(employers);
	}

	/**
	* Creates a new employer with the primary key. Does not add the employer to the database.
	*
	* @param employerId the primary key for the new employer
	* @return the new employer
	*/
	public static Employer create(long employerId) {
		return getPersistence().create(employerId);
	}

	/**
	* Removes the employer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employerId the primary key of the employer
	* @return the employer that was removed
	* @throws NoSuchEmployerException if a employer with the primary key could not be found
	*/
	public static Employer remove(long employerId)
		throws com.medicus.common.service.exception.NoSuchEmployerException {
		return getPersistence().remove(employerId);
	}

	public static Employer updateImpl(Employer employer) {
		return getPersistence().updateImpl(employer);
	}

	/**
	* Returns the employer with the primary key or throws a {@link NoSuchEmployerException} if it could not be found.
	*
	* @param employerId the primary key of the employer
	* @return the employer
	* @throws NoSuchEmployerException if a employer with the primary key could not be found
	*/
	public static Employer findByPrimaryKey(long employerId)
		throws com.medicus.common.service.exception.NoSuchEmployerException {
		return getPersistence().findByPrimaryKey(employerId);
	}

	/**
	* Returns the employer with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param employerId the primary key of the employer
	* @return the employer, or <code>null</code> if a employer with the primary key could not be found
	*/
	public static Employer fetchByPrimaryKey(long employerId) {
		return getPersistence().fetchByPrimaryKey(employerId);
	}

	public static java.util.Map<java.io.Serializable, Employer> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the employers.
	*
	* @return the employers
	*/
	public static List<Employer> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the employers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employers
	* @param end the upper bound of the range of employers (not inclusive)
	* @return the range of employers
	*/
	public static List<Employer> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the employers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employers
	* @param end the upper bound of the range of employers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of employers
	*/
	public static List<Employer> findAll(int start, int end,
		OrderByComparator<Employer> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the employers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EmployerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employers
	* @param end the upper bound of the range of employers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of employers
	*/
	public static List<Employer> findAll(int start, int end,
		OrderByComparator<Employer> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the employers from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of employers.
	*
	* @return the number of employers
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static EmployerPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmployerPersistence, EmployerPersistence> _serviceTracker =
		ServiceTrackerFactory.open(EmployerPersistence.class);
}