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

package com.medicus.common.service.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.medicus.common.service.exception.NoSuchStudent_ExternshipException;
import com.medicus.common.service.model.Student_Externship;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

/**
 * Provides the local service interface for Student_Externship. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author sandip.patel
 * @see Student_ExternshipLocalServiceUtil
 * @see com.medicus.common.service.service.base.Student_ExternshipLocalServiceBaseImpl
 * @see com.medicus.common.service.service.impl.Student_ExternshipLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface Student_ExternshipLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Student_ExternshipLocalServiceUtil} to access the student_ externship local service. Add custom service methods to {@link com.medicus.common.service.service.impl.Student_ExternshipLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public Student_Externship addStudentExternship(long studentId,
		long partnerId, long employerId, int externshipStatus, Date startDate,
		Date endDate, int noOfHoursPerWeek, Date midPointReview,
		java.lang.String midPointReviewComment, Date finalReview,
		java.lang.String finalReviewComment, java.lang.String shiftDesc,
		long createdBy);

	/**
	* Adds the student_ externship to the database. Also notifies the appropriate model listeners.
	*
	* @param student_Externship the student_ externship
	* @return the student_ externship that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Student_Externship addStudent_Externship(
		Student_Externship student_Externship);

	/**
	* Creates a new student_ externship with the primary key. Does not add the student_ externship to the database.
	*
	* @param studentExternshipId the primary key for the new student_ externship
	* @return the new student_ externship
	*/
	public Student_Externship createStudent_Externship(long studentExternshipId);

	/**
	* Deletes the student_ externship from the database. Also notifies the appropriate model listeners.
	*
	* @param student_Externship the student_ externship
	* @return the student_ externship that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public Student_Externship deleteStudent_Externship(
		Student_Externship student_Externship);

	/**
	* Deletes the student_ externship with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentExternshipId the primary key of the student_ externship
	* @return the student_ externship that was removed
	* @throws PortalException if a student_ externship with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public Student_Externship deleteStudent_Externship(long studentExternshipId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Student_Externship fetchStudent_Externship(long studentExternshipId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Student_Externship getStudentExternship(long studentId)
		throws NoSuchStudent_ExternshipException;

	/**
	* Returns the student_ externship with the primary key.
	*
	* @param studentExternshipId the primary key of the student_ externship
	* @return the student_ externship
	* @throws PortalException if a student_ externship with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Student_Externship getStudent_Externship(long studentExternshipId)
		throws PortalException;

	public Student_Externship updateStudentExternship(
		Student_Externship studentExternship, long studentId, long partnerId,
		long employerId, int externshipStatus, Date startDate, Date endDate,
		int noOfHoursPerWeek, Date midPointReview,
		java.lang.String midPointReviewComment, Date finalReview,
		java.lang.String finalReviewComment, java.lang.String shiftDesc,
		long modifiedBy);

	/**
	* Updates the student_ externship in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param student_Externship the student_ externship
	* @return the student_ externship that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public Student_Externship updateStudent_Externship(
		Student_Externship student_Externship);

	/**
	* Returns the number of student_ externships.
	*
	* @return the number of student_ externships
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getStudent_ExternshipsCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.Student_ExternshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.Student_ExternshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	/**
	* Returns a range of all the student_ externships.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.Student_ExternshipModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student_ externships
	* @param end the upper bound of the range of student_ externships (not inclusive)
	* @return the range of student_ externships
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Student_Externship> getStudent_Externships(int start, int end);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}