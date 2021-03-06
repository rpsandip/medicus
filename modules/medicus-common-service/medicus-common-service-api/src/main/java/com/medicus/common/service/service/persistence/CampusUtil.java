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

import com.medicus.common.service.model.Campus;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the campus service. This utility wraps {@link com.medicus.common.service.service.persistence.impl.CampusPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sandip.patel
 * @see CampusPersistence
 * @see com.medicus.common.service.service.persistence.impl.CampusPersistenceImpl
 * @generated
 */
@ProviderType
public class CampusUtil {
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
	public static void clearCache(Campus campus) {
		getPersistence().clearCache(campus);
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
	public static List<Campus> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Campus> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Campus> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Campus> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Campus update(Campus campus) {
		return getPersistence().update(campus);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Campus update(Campus campus, ServiceContext serviceContext) {
		return getPersistence().update(campus, serviceContext);
	}

	/**
	* Returns all the campuses where schoolId = &#63;.
	*
	* @param schoolId the school ID
	* @return the matching campuses
	*/
	public static List<Campus> findByschoolId(long schoolId) {
		return getPersistence().findByschoolId(schoolId);
	}

	/**
	* Returns a range of all the campuses where schoolId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param schoolId the school ID
	* @param start the lower bound of the range of campuses
	* @param end the upper bound of the range of campuses (not inclusive)
	* @return the range of matching campuses
	*/
	public static List<Campus> findByschoolId(long schoolId, int start, int end) {
		return getPersistence().findByschoolId(schoolId, start, end);
	}

	/**
	* Returns an ordered range of all the campuses where schoolId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param schoolId the school ID
	* @param start the lower bound of the range of campuses
	* @param end the upper bound of the range of campuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching campuses
	*/
	public static List<Campus> findByschoolId(long schoolId, int start,
		int end, OrderByComparator<Campus> orderByComparator) {
		return getPersistence()
				   .findByschoolId(schoolId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the campuses where schoolId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param schoolId the school ID
	* @param start the lower bound of the range of campuses
	* @param end the upper bound of the range of campuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching campuses
	*/
	public static List<Campus> findByschoolId(long schoolId, int start,
		int end, OrderByComparator<Campus> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByschoolId(schoolId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first campus in the ordered set where schoolId = &#63;.
	*
	* @param schoolId the school ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campus
	* @throws NoSuchCampusException if a matching campus could not be found
	*/
	public static Campus findByschoolId_First(long schoolId,
		OrderByComparator<Campus> orderByComparator)
		throws com.medicus.common.service.exception.NoSuchCampusException {
		return getPersistence().findByschoolId_First(schoolId, orderByComparator);
	}

	/**
	* Returns the first campus in the ordered set where schoolId = &#63;.
	*
	* @param schoolId the school ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campus, or <code>null</code> if a matching campus could not be found
	*/
	public static Campus fetchByschoolId_First(long schoolId,
		OrderByComparator<Campus> orderByComparator) {
		return getPersistence()
				   .fetchByschoolId_First(schoolId, orderByComparator);
	}

	/**
	* Returns the last campus in the ordered set where schoolId = &#63;.
	*
	* @param schoolId the school ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campus
	* @throws NoSuchCampusException if a matching campus could not be found
	*/
	public static Campus findByschoolId_Last(long schoolId,
		OrderByComparator<Campus> orderByComparator)
		throws com.medicus.common.service.exception.NoSuchCampusException {
		return getPersistence().findByschoolId_Last(schoolId, orderByComparator);
	}

	/**
	* Returns the last campus in the ordered set where schoolId = &#63;.
	*
	* @param schoolId the school ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campus, or <code>null</code> if a matching campus could not be found
	*/
	public static Campus fetchByschoolId_Last(long schoolId,
		OrderByComparator<Campus> orderByComparator) {
		return getPersistence().fetchByschoolId_Last(schoolId, orderByComparator);
	}

	/**
	* Returns the campuses before and after the current campus in the ordered set where schoolId = &#63;.
	*
	* @param campusId the primary key of the current campus
	* @param schoolId the school ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campus
	* @throws NoSuchCampusException if a campus with the primary key could not be found
	*/
	public static Campus[] findByschoolId_PrevAndNext(long campusId,
		long schoolId, OrderByComparator<Campus> orderByComparator)
		throws com.medicus.common.service.exception.NoSuchCampusException {
		return getPersistence()
				   .findByschoolId_PrevAndNext(campusId, schoolId,
			orderByComparator);
	}

	/**
	* Removes all the campuses where schoolId = &#63; from the database.
	*
	* @param schoolId the school ID
	*/
	public static void removeByschoolId(long schoolId) {
		getPersistence().removeByschoolId(schoolId);
	}

	/**
	* Returns the number of campuses where schoolId = &#63;.
	*
	* @param schoolId the school ID
	* @return the number of matching campuses
	*/
	public static int countByschoolId(long schoolId) {
		return getPersistence().countByschoolId(schoolId);
	}

	/**
	* Returns the campus where name = &#63; or throws a {@link NoSuchCampusException} if it could not be found.
	*
	* @param name the name
	* @return the matching campus
	* @throws NoSuchCampusException if a matching campus could not be found
	*/
	public static Campus findByname(java.lang.String name)
		throws com.medicus.common.service.exception.NoSuchCampusException {
		return getPersistence().findByname(name);
	}

	/**
	* Returns the campus where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching campus, or <code>null</code> if a matching campus could not be found
	*/
	public static Campus fetchByname(java.lang.String name) {
		return getPersistence().fetchByname(name);
	}

	/**
	* Returns the campus where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching campus, or <code>null</code> if a matching campus could not be found
	*/
	public static Campus fetchByname(java.lang.String name,
		boolean retrieveFromCache) {
		return getPersistence().fetchByname(name, retrieveFromCache);
	}

	/**
	* Removes the campus where name = &#63; from the database.
	*
	* @param name the name
	* @return the campus that was removed
	*/
	public static Campus removeByname(java.lang.String name)
		throws com.medicus.common.service.exception.NoSuchCampusException {
		return getPersistence().removeByname(name);
	}

	/**
	* Returns the number of campuses where name = &#63;.
	*
	* @param name the name
	* @return the number of matching campuses
	*/
	public static int countByname(java.lang.String name) {
		return getPersistence().countByname(name);
	}

	/**
	* Caches the campus in the entity cache if it is enabled.
	*
	* @param campus the campus
	*/
	public static void cacheResult(Campus campus) {
		getPersistence().cacheResult(campus);
	}

	/**
	* Caches the campuses in the entity cache if it is enabled.
	*
	* @param campuses the campuses
	*/
	public static void cacheResult(List<Campus> campuses) {
		getPersistence().cacheResult(campuses);
	}

	/**
	* Creates a new campus with the primary key. Does not add the campus to the database.
	*
	* @param campusId the primary key for the new campus
	* @return the new campus
	*/
	public static Campus create(long campusId) {
		return getPersistence().create(campusId);
	}

	/**
	* Removes the campus with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campusId the primary key of the campus
	* @return the campus that was removed
	* @throws NoSuchCampusException if a campus with the primary key could not be found
	*/
	public static Campus remove(long campusId)
		throws com.medicus.common.service.exception.NoSuchCampusException {
		return getPersistence().remove(campusId);
	}

	public static Campus updateImpl(Campus campus) {
		return getPersistence().updateImpl(campus);
	}

	/**
	* Returns the campus with the primary key or throws a {@link NoSuchCampusException} if it could not be found.
	*
	* @param campusId the primary key of the campus
	* @return the campus
	* @throws NoSuchCampusException if a campus with the primary key could not be found
	*/
	public static Campus findByPrimaryKey(long campusId)
		throws com.medicus.common.service.exception.NoSuchCampusException {
		return getPersistence().findByPrimaryKey(campusId);
	}

	/**
	* Returns the campus with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campusId the primary key of the campus
	* @return the campus, or <code>null</code> if a campus with the primary key could not be found
	*/
	public static Campus fetchByPrimaryKey(long campusId) {
		return getPersistence().fetchByPrimaryKey(campusId);
	}

	public static java.util.Map<java.io.Serializable, Campus> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the campuses.
	*
	* @return the campuses
	*/
	public static List<Campus> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the campuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campuses
	* @param end the upper bound of the range of campuses (not inclusive)
	* @return the range of campuses
	*/
	public static List<Campus> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the campuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campuses
	* @param end the upper bound of the range of campuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of campuses
	*/
	public static List<Campus> findAll(int start, int end,
		OrderByComparator<Campus> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the campuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link CampusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campuses
	* @param end the upper bound of the range of campuses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of campuses
	*/
	public static List<Campus> findAll(int start, int end,
		OrderByComparator<Campus> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the campuses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of campuses.
	*
	* @return the number of campuses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static CampusPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CampusPersistence, CampusPersistence> _serviceTracker =
		ServiceTrackerFactory.open(CampusPersistence.class);
}