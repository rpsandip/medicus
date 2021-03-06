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

import com.medicus.common.service.exception.NoSuchStudent_ExternshipException;
import com.medicus.common.service.model.Student_Externship;

/**
 * The persistence interface for the student_ externship service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author sandip.patel
 * @see com.medicus.common.service.service.persistence.impl.Student_ExternshipPersistenceImpl
 * @see Student_ExternshipUtil
 * @generated
 */
@ProviderType
public interface Student_ExternshipPersistence extends BasePersistence<Student_Externship> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Student_ExternshipUtil} to access the student_ externship persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the student_ externship where studentId = &#63; or throws a {@link NoSuchStudent_ExternshipException} if it could not be found.
	*
	* @param studentId the student ID
	* @return the matching student_ externship
	* @throws NoSuchStudent_ExternshipException if a matching student_ externship could not be found
	*/
	public Student_Externship findBystudentId(long studentId)
		throws NoSuchStudent_ExternshipException;

	/**
	* Returns the student_ externship where studentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param studentId the student ID
	* @return the matching student_ externship, or <code>null</code> if a matching student_ externship could not be found
	*/
	public Student_Externship fetchBystudentId(long studentId);

	/**
	* Returns the student_ externship where studentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param studentId the student ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching student_ externship, or <code>null</code> if a matching student_ externship could not be found
	*/
	public Student_Externship fetchBystudentId(long studentId,
		boolean retrieveFromCache);

	/**
	* Removes the student_ externship where studentId = &#63; from the database.
	*
	* @param studentId the student ID
	* @return the student_ externship that was removed
	*/
	public Student_Externship removeBystudentId(long studentId)
		throws NoSuchStudent_ExternshipException;

	/**
	* Returns the number of student_ externships where studentId = &#63;.
	*
	* @param studentId the student ID
	* @return the number of matching student_ externships
	*/
	public int countBystudentId(long studentId);

	/**
	* Caches the student_ externship in the entity cache if it is enabled.
	*
	* @param student_Externship the student_ externship
	*/
	public void cacheResult(Student_Externship student_Externship);

	/**
	* Caches the student_ externships in the entity cache if it is enabled.
	*
	* @param student_Externships the student_ externships
	*/
	public void cacheResult(
		java.util.List<Student_Externship> student_Externships);

	/**
	* Creates a new student_ externship with the primary key. Does not add the student_ externship to the database.
	*
	* @param studentExternshipId the primary key for the new student_ externship
	* @return the new student_ externship
	*/
	public Student_Externship create(long studentExternshipId);

	/**
	* Removes the student_ externship with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentExternshipId the primary key of the student_ externship
	* @return the student_ externship that was removed
	* @throws NoSuchStudent_ExternshipException if a student_ externship with the primary key could not be found
	*/
	public Student_Externship remove(long studentExternshipId)
		throws NoSuchStudent_ExternshipException;

	public Student_Externship updateImpl(Student_Externship student_Externship);

	/**
	* Returns the student_ externship with the primary key or throws a {@link NoSuchStudent_ExternshipException} if it could not be found.
	*
	* @param studentExternshipId the primary key of the student_ externship
	* @return the student_ externship
	* @throws NoSuchStudent_ExternshipException if a student_ externship with the primary key could not be found
	*/
	public Student_Externship findByPrimaryKey(long studentExternshipId)
		throws NoSuchStudent_ExternshipException;

	/**
	* Returns the student_ externship with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param studentExternshipId the primary key of the student_ externship
	* @return the student_ externship, or <code>null</code> if a student_ externship with the primary key could not be found
	*/
	public Student_Externship fetchByPrimaryKey(long studentExternshipId);

	@Override
	public java.util.Map<java.io.Serializable, Student_Externship> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the student_ externships.
	*
	* @return the student_ externships
	*/
	public java.util.List<Student_Externship> findAll();

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
	public java.util.List<Student_Externship> findAll(int start, int end);

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
	public java.util.List<Student_Externship> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student_Externship> orderByComparator);

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
	public java.util.List<Student_Externship> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Student_Externship> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the student_ externships from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of student_ externships.
	*
	* @return the number of student_ externships
	*/
	public int countAll();
}