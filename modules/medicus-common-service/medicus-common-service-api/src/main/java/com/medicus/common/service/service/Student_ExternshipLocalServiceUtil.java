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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Student_Externship. This utility wraps
 * {@link com.medicus.common.service.service.impl.Student_ExternshipLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see Student_ExternshipLocalService
 * @see com.medicus.common.service.service.base.Student_ExternshipLocalServiceBaseImpl
 * @see com.medicus.common.service.service.impl.Student_ExternshipLocalServiceImpl
 * @generated
 */
@ProviderType
public class Student_ExternshipLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.medicus.common.service.service.impl.Student_ExternshipLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	public static com.medicus.common.service.model.Student_Externship addStudentExternship(
		long studentId, long employerId, java.util.Date startDate,
		java.util.Date endDate, int noOfHoursPerWeek,
		java.util.Date midPointReview, java.lang.String midPointReviewComment,
		java.util.Date finalReview, java.lang.String finalReviewComment,
		long createdBy) {
		return getService()
				   .addStudentExternship(studentId, employerId, startDate,
			endDate, noOfHoursPerWeek, midPointReview, midPointReviewComment,
			finalReview, finalReviewComment, createdBy);
	}

	/**
	* Adds the student_ externship to the database. Also notifies the appropriate model listeners.
	*
	* @param student_Externship the student_ externship
	* @return the student_ externship that was added
	*/
	public static com.medicus.common.service.model.Student_Externship addStudent_Externship(
		com.medicus.common.service.model.Student_Externship student_Externship) {
		return getService().addStudent_Externship(student_Externship);
	}

	/**
	* Creates a new student_ externship with the primary key. Does not add the student_ externship to the database.
	*
	* @param studentExternshipId the primary key for the new student_ externship
	* @return the new student_ externship
	*/
	public static com.medicus.common.service.model.Student_Externship createStudent_Externship(
		long studentExternshipId) {
		return getService().createStudent_Externship(studentExternshipId);
	}

	/**
	* Deletes the student_ externship from the database. Also notifies the appropriate model listeners.
	*
	* @param student_Externship the student_ externship
	* @return the student_ externship that was removed
	*/
	public static com.medicus.common.service.model.Student_Externship deleteStudent_Externship(
		com.medicus.common.service.model.Student_Externship student_Externship) {
		return getService().deleteStudent_Externship(student_Externship);
	}

	/**
	* Deletes the student_ externship with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentExternshipId the primary key of the student_ externship
	* @return the student_ externship that was removed
	* @throws PortalException if a student_ externship with the primary key could not be found
	*/
	public static com.medicus.common.service.model.Student_Externship deleteStudent_Externship(
		long studentExternshipId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteStudent_Externship(studentExternshipId);
	}

	public static com.medicus.common.service.model.Student_Externship fetchStudent_Externship(
		long studentExternshipId) {
		return getService().fetchStudent_Externship(studentExternshipId);
	}

	/**
	* Returns the student_ externship with the primary key.
	*
	* @param studentExternshipId the primary key of the student_ externship
	* @return the student_ externship
	* @throws PortalException if a student_ externship with the primary key could not be found
	*/
	public static com.medicus.common.service.model.Student_Externship getStudent_Externship(
		long studentExternshipId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getStudent_Externship(studentExternshipId);
	}

	/**
	* Updates the student_ externship in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param student_Externship the student_ externship
	* @return the student_ externship that was updated
	*/
	public static com.medicus.common.service.model.Student_Externship updateStudent_Externship(
		com.medicus.common.service.model.Student_Externship student_Externship) {
		return getService().updateStudent_Externship(student_Externship);
	}

	/**
	* Returns the number of student_ externships.
	*
	* @return the number of student_ externships
	*/
	public static int getStudent_ExternshipsCount() {
		return getService().getStudent_ExternshipsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

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
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

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
	public static java.util.List<com.medicus.common.service.model.Student_Externship> getStudent_Externships(
		int start, int end) {
		return getService().getStudent_Externships(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Student_ExternshipLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Student_ExternshipLocalService, Student_ExternshipLocalService> _serviceTracker =
		ServiceTrackerFactory.open(Student_ExternshipLocalService.class);
}