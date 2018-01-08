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

import com.medicus.common.service.exception.NoSuchSchoolException;
import com.medicus.common.service.model.School;

/**
 * The persistence interface for the school service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sandip.patel
 * @see com.medicus.common.service.service.persistence.impl.SchoolPersistenceImpl
 * @see SchoolUtil
 * @generated
 */
@ProviderType
public interface SchoolPersistence extends BasePersistence<School> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SchoolUtil} to access the school persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the school where name = &#63; or throws a {@link NoSuchSchoolException} if it could not be found.
	*
	* @param name the name
	* @return the matching school
	* @throws NoSuchSchoolException if a matching school could not be found
	*/
	public School findByname(java.lang.String name)
		throws NoSuchSchoolException;

	/**
	* Returns the school where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching school, or <code>null</code> if a matching school could not be found
	*/
	public School fetchByname(java.lang.String name);

	/**
	* Returns the school where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching school, or <code>null</code> if a matching school could not be found
	*/
	public School fetchByname(java.lang.String name, boolean retrieveFromCache);

	/**
	* Removes the school where name = &#63; from the database.
	*
	* @param name the name
	* @return the school that was removed
	*/
	public School removeByname(java.lang.String name)
		throws NoSuchSchoolException;

	/**
	* Returns the number of schools where name = &#63;.
	*
	* @param name the name
	* @return the number of matching schools
	*/
	public int countByname(java.lang.String name);

	/**
	* Caches the school in the entity cache if it is enabled.
	*
	* @param school the school
	*/
	public void cacheResult(School school);

	/**
	* Caches the schools in the entity cache if it is enabled.
	*
	* @param schools the schools
	*/
	public void cacheResult(java.util.List<School> schools);

	/**
	* Creates a new school with the primary key. Does not add the school to the database.
	*
	* @param schoolId the primary key for the new school
	* @return the new school
	*/
	public School create(long schoolId);

	/**
	* Removes the school with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param schoolId the primary key of the school
	* @return the school that was removed
	* @throws NoSuchSchoolException if a school with the primary key could not be found
	*/
	public School remove(long schoolId) throws NoSuchSchoolException;

	public School updateImpl(School school);

	/**
	* Returns the school with the primary key or throws a {@link NoSuchSchoolException} if it could not be found.
	*
	* @param schoolId the primary key of the school
	* @return the school
	* @throws NoSuchSchoolException if a school with the primary key could not be found
	*/
	public School findByPrimaryKey(long schoolId) throws NoSuchSchoolException;

	/**
	* Returns the school with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param schoolId the primary key of the school
	* @return the school, or <code>null</code> if a school with the primary key could not be found
	*/
	public School fetchByPrimaryKey(long schoolId);

	@Override
	public java.util.Map<java.io.Serializable, School> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the schools.
	*
	* @return the schools
	*/
	public java.util.List<School> findAll();

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
	public java.util.List<School> findAll(int start, int end);

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
	public java.util.List<School> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<School> orderByComparator);

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
	public java.util.List<School> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<School> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the schools from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of schools.
	*
	* @return the number of schools
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}