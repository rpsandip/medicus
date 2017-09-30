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

import com.medicus.common.service.model.School;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the school service. This utility wraps {@link com.medicus.common.service.service.persistence.impl.SchoolPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SchoolPersistence
 * @see com.medicus.common.service.service.persistence.impl.SchoolPersistenceImpl
 * @generated
 */
@ProviderType
public class SchoolUtil {
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
	public static void clearCache(School school) {
		getPersistence().clearCache(school);
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
	public static List<School> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<School> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<School> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<School> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static School update(School school) {
		return getPersistence().update(school);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static School update(School school, ServiceContext serviceContext) {
		return getPersistence().update(school, serviceContext);
	}

	/**
	* Caches the school in the entity cache if it is enabled.
	*
	* @param school the school
	*/
	public static void cacheResult(School school) {
		getPersistence().cacheResult(school);
	}

	/**
	* Caches the schools in the entity cache if it is enabled.
	*
	* @param schools the schools
	*/
	public static void cacheResult(List<School> schools) {
		getPersistence().cacheResult(schools);
	}

	/**
	* Creates a new school with the primary key. Does not add the school to the database.
	*
	* @param schoolId the primary key for the new school
	* @return the new school
	*/
	public static School create(long schoolId) {
		return getPersistence().create(schoolId);
	}

	/**
	* Removes the school with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param schoolId the primary key of the school
	* @return the school that was removed
	* @throws NoSuchSchoolException if a school with the primary key could not be found
	*/
	public static School remove(long schoolId)
		throws com.medicus.common.service.exception.NoSuchSchoolException {
		return getPersistence().remove(schoolId);
	}

	public static School updateImpl(School school) {
		return getPersistence().updateImpl(school);
	}

	/**
	* Returns the school with the primary key or throws a {@link NoSuchSchoolException} if it could not be found.
	*
	* @param schoolId the primary key of the school
	* @return the school
	* @throws NoSuchSchoolException if a school with the primary key could not be found
	*/
	public static School findByPrimaryKey(long schoolId)
		throws com.medicus.common.service.exception.NoSuchSchoolException {
		return getPersistence().findByPrimaryKey(schoolId);
	}

	/**
	* Returns the school with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param schoolId the primary key of the school
	* @return the school, or <code>null</code> if a school with the primary key could not be found
	*/
	public static School fetchByPrimaryKey(long schoolId) {
		return getPersistence().fetchByPrimaryKey(schoolId);
	}

	public static java.util.Map<java.io.Serializable, School> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the schools.
	*
	* @return the schools
	*/
	public static List<School> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the schools.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schools
	* @param end the upper bound of the range of schools (not inclusive)
	* @return the range of schools
	*/
	public static List<School> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the schools.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schools
	* @param end the upper bound of the range of schools (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of schools
	*/
	public static List<School> findAll(int start, int end,
		OrderByComparator<School> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the schools.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schools
	* @param end the upper bound of the range of schools (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of schools
	*/
	public static List<School> findAll(int start, int end,
		OrderByComparator<School> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the schools from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of schools.
	*
	* @return the number of schools
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static SchoolPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SchoolPersistence, SchoolPersistence> _serviceTracker =
		ServiceTrackerFactory.open(SchoolPersistence.class);
}