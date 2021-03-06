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

import com.medicus.common.service.exception.NoSuchCampusException;
import com.medicus.common.service.model.Campus;

/**
 * The persistence interface for the campus service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sandip.patel
 * @see com.medicus.common.service.service.persistence.impl.CampusPersistenceImpl
 * @see CampusUtil
 * @generated
 */
@ProviderType
public interface CampusPersistence extends BasePersistence<Campus> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CampusUtil} to access the campus persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the campuses where schoolId = &#63;.
	*
	* @param schoolId the school ID
	* @return the matching campuses
	*/
	public java.util.List<Campus> findByschoolId(long schoolId);

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
	public java.util.List<Campus> findByschoolId(long schoolId, int start,
		int end);

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
	public java.util.List<Campus> findByschoolId(long schoolId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campus> orderByComparator);

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
	public java.util.List<Campus> findByschoolId(long schoolId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campus> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first campus in the ordered set where schoolId = &#63;.
	*
	* @param schoolId the school ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campus
	* @throws NoSuchCampusException if a matching campus could not be found
	*/
	public Campus findByschoolId_First(long schoolId,
		com.liferay.portal.kernel.util.OrderByComparator<Campus> orderByComparator)
		throws NoSuchCampusException;

	/**
	* Returns the first campus in the ordered set where schoolId = &#63;.
	*
	* @param schoolId the school ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching campus, or <code>null</code> if a matching campus could not be found
	*/
	public Campus fetchByschoolId_First(long schoolId,
		com.liferay.portal.kernel.util.OrderByComparator<Campus> orderByComparator);

	/**
	* Returns the last campus in the ordered set where schoolId = &#63;.
	*
	* @param schoolId the school ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campus
	* @throws NoSuchCampusException if a matching campus could not be found
	*/
	public Campus findByschoolId_Last(long schoolId,
		com.liferay.portal.kernel.util.OrderByComparator<Campus> orderByComparator)
		throws NoSuchCampusException;

	/**
	* Returns the last campus in the ordered set where schoolId = &#63;.
	*
	* @param schoolId the school ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching campus, or <code>null</code> if a matching campus could not be found
	*/
	public Campus fetchByschoolId_Last(long schoolId,
		com.liferay.portal.kernel.util.OrderByComparator<Campus> orderByComparator);

	/**
	* Returns the campuses before and after the current campus in the ordered set where schoolId = &#63;.
	*
	* @param campusId the primary key of the current campus
	* @param schoolId the school ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next campus
	* @throws NoSuchCampusException if a campus with the primary key could not be found
	*/
	public Campus[] findByschoolId_PrevAndNext(long campusId, long schoolId,
		com.liferay.portal.kernel.util.OrderByComparator<Campus> orderByComparator)
		throws NoSuchCampusException;

	/**
	* Removes all the campuses where schoolId = &#63; from the database.
	*
	* @param schoolId the school ID
	*/
	public void removeByschoolId(long schoolId);

	/**
	* Returns the number of campuses where schoolId = &#63;.
	*
	* @param schoolId the school ID
	* @return the number of matching campuses
	*/
	public int countByschoolId(long schoolId);

	/**
	* Returns the campus where name = &#63; or throws a {@link NoSuchCampusException} if it could not be found.
	*
	* @param name the name
	* @return the matching campus
	* @throws NoSuchCampusException if a matching campus could not be found
	*/
	public Campus findByname(java.lang.String name)
		throws NoSuchCampusException;

	/**
	* Returns the campus where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching campus, or <code>null</code> if a matching campus could not be found
	*/
	public Campus fetchByname(java.lang.String name);

	/**
	* Returns the campus where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching campus, or <code>null</code> if a matching campus could not be found
	*/
	public Campus fetchByname(java.lang.String name, boolean retrieveFromCache);

	/**
	* Removes the campus where name = &#63; from the database.
	*
	* @param name the name
	* @return the campus that was removed
	*/
	public Campus removeByname(java.lang.String name)
		throws NoSuchCampusException;

	/**
	* Returns the number of campuses where name = &#63;.
	*
	* @param name the name
	* @return the number of matching campuses
	*/
	public int countByname(java.lang.String name);

	/**
	* Caches the campus in the entity cache if it is enabled.
	*
	* @param campus the campus
	*/
	public void cacheResult(Campus campus);

	/**
	* Caches the campuses in the entity cache if it is enabled.
	*
	* @param campuses the campuses
	*/
	public void cacheResult(java.util.List<Campus> campuses);

	/**
	* Creates a new campus with the primary key. Does not add the campus to the database.
	*
	* @param campusId the primary key for the new campus
	* @return the new campus
	*/
	public Campus create(long campusId);

	/**
	* Removes the campus with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campusId the primary key of the campus
	* @return the campus that was removed
	* @throws NoSuchCampusException if a campus with the primary key could not be found
	*/
	public Campus remove(long campusId) throws NoSuchCampusException;

	public Campus updateImpl(Campus campus);

	/**
	* Returns the campus with the primary key or throws a {@link NoSuchCampusException} if it could not be found.
	*
	* @param campusId the primary key of the campus
	* @return the campus
	* @throws NoSuchCampusException if a campus with the primary key could not be found
	*/
	public Campus findByPrimaryKey(long campusId) throws NoSuchCampusException;

	/**
	* Returns the campus with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param campusId the primary key of the campus
	* @return the campus, or <code>null</code> if a campus with the primary key could not be found
	*/
	public Campus fetchByPrimaryKey(long campusId);

	@Override
	public java.util.Map<java.io.Serializable, Campus> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the campuses.
	*
	* @return the campuses
	*/
	public java.util.List<Campus> findAll();

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
	public java.util.List<Campus> findAll(int start, int end);

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
	public java.util.List<Campus> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campus> orderByComparator);

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
	public java.util.List<Campus> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Campus> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the campuses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of campuses.
	*
	* @return the number of campuses
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}