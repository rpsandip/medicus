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

import com.medicus.common.service.model.Student_Externship;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the student_ externship service. This utility wraps {@link com.medicus.common.service.service.persistence.impl.Student_ExternshipPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sandip.patel
 * @see Student_ExternshipPersistence
 * @see com.medicus.common.service.service.persistence.impl.Student_ExternshipPersistenceImpl
 * @generated
 */
@ProviderType
public class Student_ExternshipUtil {
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
	public static void clearCache(Student_Externship student_Externship) {
		getPersistence().clearCache(student_Externship);
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
	public static List<Student_Externship> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Student_Externship> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Student_Externship> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Student_Externship> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Student_Externship update(
		Student_Externship student_Externship) {
		return getPersistence().update(student_Externship);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Student_Externship update(
		Student_Externship student_Externship, ServiceContext serviceContext) {
		return getPersistence().update(student_Externship, serviceContext);
	}

	/**
	* Returns the student_ externship where studentId = &#63; or throws a {@link NoSuchStudent_ExternshipException} if it could not be found.
	*
	* @param studentId the student ID
	* @return the matching student_ externship
	* @throws NoSuchStudent_ExternshipException if a matching student_ externship could not be found
	*/
	public static Student_Externship findBystudentId(long studentId)
		throws com.medicus.common.service.exception.NoSuchStudent_ExternshipException {
		return getPersistence().findBystudentId(studentId);
	}

	/**
	* Returns the student_ externship where studentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param studentId the student ID
	* @return the matching student_ externship, or <code>null</code> if a matching student_ externship could not be found
	*/
	public static Student_Externship fetchBystudentId(long studentId) {
		return getPersistence().fetchBystudentId(studentId);
	}

	/**
	* Returns the student_ externship where studentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param studentId the student ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching student_ externship, or <code>null</code> if a matching student_ externship could not be found
	*/
	public static Student_Externship fetchBystudentId(long studentId,
		boolean retrieveFromCache) {
		return getPersistence().fetchBystudentId(studentId, retrieveFromCache);
	}

	/**
	* Removes the student_ externship where studentId = &#63; from the database.
	*
	* @param studentId the student ID
	* @return the student_ externship that was removed
	*/
	public static Student_Externship removeBystudentId(long studentId)
		throws com.medicus.common.service.exception.NoSuchStudent_ExternshipException {
		return getPersistence().removeBystudentId(studentId);
	}

	/**
	* Returns the number of student_ externships where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the number of matching student_ externships
	*/
	public static int countBystudentId(long studentId) {
		return getPersistence().countBystudentId(studentId);
	}

	/**
	* Caches the student_ externship in the entity cache if it is enabled.
	*
	* @param student_Externship the student_ externship
	*/
	public static void cacheResult(Student_Externship student_Externship) {
		getPersistence().cacheResult(student_Externship);
	}

	/**
	* Caches the student_ externships in the entity cache if it is enabled.
	*
	* @param student_Externships the student_ externships
	*/
	public static void cacheResult(List<Student_Externship> student_Externships) {
		getPersistence().cacheResult(student_Externships);
	}

	/**
	* Creates a new student_ externship with the primary key. Does not add the student_ externship to the database.
	*
	* @param studentExternshipId the primary key for the new student_ externship
	* @return the new student_ externship
	*/
	public static Student_Externship create(long studentExternshipId) {
		return getPersistence().create(studentExternshipId);
	}

	/**
	* Removes the student_ externship with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentExternshipId the primary key of the student_ externship
	* @return the student_ externship that was removed
	* @throws NoSuchStudent_ExternshipException if a student_ externship with the primary key could not be found
	*/
	public static Student_Externship remove(long studentExternshipId)
		throws com.medicus.common.service.exception.NoSuchStudent_ExternshipException {
		return getPersistence().remove(studentExternshipId);
	}

	public static Student_Externship updateImpl(
		Student_Externship student_Externship) {
		return getPersistence().updateImpl(student_Externship);
	}

	/**
	* Returns the student_ externship with the primary key or throws a {@link NoSuchStudent_ExternshipException} if it could not be found.
	*
	* @param studentExternshipId the primary key of the student_ externship
	* @return the student_ externship
	* @throws NoSuchStudent_ExternshipException if a student_ externship with the primary key could not be found
	*/
	public static Student_Externship findByPrimaryKey(long studentExternshipId)
		throws com.medicus.common.service.exception.NoSuchStudent_ExternshipException {
		return getPersistence().findByPrimaryKey(studentExternshipId);
	}

	/**
	* Returns the student_ externship with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param studentExternshipId the primary key of the student_ externship
	* @return the student_ externship, or <code>null</code> if a student_ externship with the primary key could not be found
	*/
	public static Student_Externship fetchByPrimaryKey(long studentExternshipId) {
		return getPersistence().fetchByPrimaryKey(studentExternshipId);
	}

	public static java.util.Map<java.io.Serializable, Student_Externship> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the student_ externships.
	*
	* @return the student_ externships
	*/
	public static List<Student_Externship> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the student_ externships.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Student_ExternshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student_ externships
	* @param end the upper bound of the range of student_ externships (not inclusive)
	* @return the range of student_ externships
	*/
	public static List<Student_Externship> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the student_ externships.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Student_ExternshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student_ externships
	* @param end the upper bound of the range of student_ externships (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of student_ externships
	*/
	public static List<Student_Externship> findAll(int start, int end,
		OrderByComparator<Student_Externship> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the student_ externships.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Student_ExternshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student_ externships
	* @param end the upper bound of the range of student_ externships (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of student_ externships
	*/
	public static List<Student_Externship> findAll(int start, int end,
		OrderByComparator<Student_Externship> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the student_ externships from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of student_ externships.
	*
	* @return the number of student_ externships
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Student_ExternshipPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Student_ExternshipPersistence, Student_ExternshipPersistence> _serviceTracker =
		ServiceTrackerFactory.open(Student_ExternshipPersistence.class);
}