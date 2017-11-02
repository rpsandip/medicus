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
 * Provides the local service utility for Student. This utility wraps
 * {@link com.medicus.common.service.service.impl.StudentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see StudentLocalService
 * @see com.medicus.common.service.service.base.StudentLocalServiceBaseImpl
 * @see com.medicus.common.service.service.impl.StudentLocalServiceImpl
 * @generated
 */
@ProviderType
public class StudentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.medicus.common.service.service.impl.StudentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean deleteStudentDetail(long studentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteStudentDetail(studentId);
	}

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

	/**
	* Adds the student to the database. Also notifies the appropriate model listeners.
	*
	* @param student the student
	* @return the student that was added
	*/
	public static com.medicus.common.service.model.Student addStudent(
		com.medicus.common.service.model.Student student) {
		return getService().addStudent(student);
	}

	public static com.medicus.common.service.model.Student addStudent(
		long schoolId, long campusId, java.lang.String studentCampusId,
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String emailAddress,
		java.util.Date dob, java.lang.String gender,
		java.lang.String contactNumber, java.lang.String homePhoneNumber,
		java.lang.String primaryLang, java.lang.String secondaryLangs,
		java.lang.String address, java.lang.String city,
		java.lang.String zipcode, java.lang.String state,
		java.lang.String pace, float gpa, java.lang.String profession,
		java.lang.String practices, boolean hired,
		java.util.Date graduationDate, boolean activelySeekingEmployment,
		boolean haveExternship, long employerId,
		java.lang.String employerZipCode, java.lang.String employerWebSiteLink,
		java.util.Date externshipStartDate, java.util.Date externshipEndDate,
		int noOfHoursPerWeek, java.util.Date midPointReviewDate,
		java.lang.String midPointReviewComment, java.util.Date finalReviewDate,
		java.lang.String finalPointReviewComment, java.io.File profileImage,
		java.lang.String profileImageFileName, java.io.File resume,
		java.lang.String resumeFileName,
		java.util.Map<java.lang.String, java.io.File> agreementFileMap,
		java.util.Map<java.lang.String, java.io.File> othersFileMap,
		long createdBy) {
		return getService()
				   .addStudent(schoolId, campusId, studentCampusId, firstName,
			middleName, lastName, emailAddress, dob, gender, contactNumber,
			homePhoneNumber, primaryLang, secondaryLangs, address, city,
			zipcode, state, pace, gpa, profession, practices, hired,
			graduationDate, activelySeekingEmployment, haveExternship,
			employerId, employerZipCode, employerWebSiteLink,
			externshipStartDate, externshipEndDate, noOfHoursPerWeek,
			midPointReviewDate, midPointReviewComment, finalReviewDate,
			finalPointReviewComment, profileImage, profileImageFileName,
			resume, resumeFileName, agreementFileMap, othersFileMap, createdBy);
	}

	/**
	* Creates a new student with the primary key. Does not add the student to the database.
	*
	* @param studentId the primary key for the new student
	* @return the new student
	*/
	public static com.medicus.common.service.model.Student createStudent(
		long studentId) {
		return getService().createStudent(studentId);
	}

	/**
	* Deletes the student from the database. Also notifies the appropriate model listeners.
	*
	* @param student the student
	* @return the student that was removed
	*/
	public static com.medicus.common.service.model.Student deleteStudent(
		com.medicus.common.service.model.Student student) {
		return getService().deleteStudent(student);
	}

	/**
	* Deletes the student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student
	* @return the student that was removed
	* @throws PortalException if a student with the primary key could not be found
	*/
	public static com.medicus.common.service.model.Student deleteStudent(
		long studentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteStudent(studentId);
	}

	public static com.medicus.common.service.model.Student fetchStudent(
		long studentId) {
		return getService().fetchStudent(studentId);
	}

	/**
	* Returns the student with the primary key.
	*
	* @param studentId the primary key of the student
	* @return the student
	* @throws PortalException if a student with the primary key could not be found
	*/
	public static com.medicus.common.service.model.Student getStudent(
		long studentId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getStudent(studentId);
	}

	public static com.medicus.common.service.model.Student getStudentByStudentCampusId(
		java.lang.String studentCampusId) {
		return getService().getStudentByStudentCampusId(studentCampusId);
	}

	public static com.medicus.common.service.model.Student importStudent(
		java.lang.String firstName, java.lang.String middleName,
		java.lang.String lastName, java.lang.String emailAddress,
		java.util.Date dob, java.lang.String studentCampusId,
		java.lang.String address, java.lang.String city,
		java.lang.String state, java.lang.String zipcode,
		java.lang.String mobilePhone, java.lang.String homePhone,
		java.lang.String gender, java.lang.String primaryLangs,
		java.lang.String secondaryLangs, float gpa, java.lang.String pace,
		long schoolId, long campusId, java.lang.String profession,
		long createdBy) {
		return getService()
				   .importStudent(firstName, middleName, lastName,
			emailAddress, dob, studentCampusId, address, city, state, zipcode,
			mobilePhone, homePhone, gender, primaryLangs, secondaryLangs, gpa,
			pace, schoolId, campusId, profession, createdBy);
	}

	/**
	* Updates the student in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param student the student
	* @return the student that was updated
	*/
	public static com.medicus.common.service.model.Student updateStudent(
		com.medicus.common.service.model.Student student) {
		return getService().updateStudent(student);
	}

	public static com.medicus.common.service.model.Student updateStudent(
		long studentId, long schoolId, long campusId,
		java.lang.String studentCampusId, java.lang.String firstName,
		java.lang.String middleName, java.lang.String lastName,
		java.lang.String emailAddress, java.util.Date dob,
		java.lang.String gender, java.lang.String contactNumber,
		java.lang.String homePhoneNumber, java.lang.String primaryLang,
		java.lang.String secondaryLangs, java.lang.String address,
		java.lang.String city, java.lang.String zipcode,
		java.lang.String state, java.lang.String pace, float gpa,
		java.lang.String profession, java.lang.String practices, boolean hired,
		java.util.Date graduationDate, boolean activelySeekingEmployment,
		boolean haveExternship, long employerId,
		java.lang.String employerZipCode, java.lang.String employerWebSiteLink,
		java.util.Date externshipStartDate, java.util.Date externshipEndDate,
		int noOfHoursPerWeek, java.util.Date midPointReviewDate,
		java.lang.String midPointReviewComment, java.util.Date finalReviewDate,
		java.lang.String finalPointReviewComment, java.io.File profileImage,
		java.lang.String profileImageFileName, java.io.File resume,
		java.lang.String resumeFileName,
		java.util.Map<java.lang.String, java.io.File> agreementFileMap,
		java.util.Map<java.lang.String, java.io.File> othersFileMap,
		long modifiedBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .updateStudent(studentId, schoolId, campusId,
			studentCampusId, firstName, middleName, lastName, emailAddress,
			dob, gender, contactNumber, homePhoneNumber, primaryLang,
			secondaryLangs, address, city, zipcode, state, pace, gpa,
			profession, practices, hired, graduationDate,
			activelySeekingEmployment, haveExternship, employerId,
			employerZipCode, employerWebSiteLink, externshipStartDate,
			externshipEndDate, noOfHoursPerWeek, midPointReviewDate,
			midPointReviewComment, finalReviewDate, finalPointReviewComment,
			profileImage, profileImageFileName, resume, resumeFileName,
			agreementFileMap, othersFileMap, modifiedBy);
	}

	/**
	* Returns the number of students.
	*
	* @return the number of students
	*/
	public static int getStudentsCount() {
		return getService().getStudentsCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of students
	*/
	public static java.util.List<com.medicus.common.service.model.Student> getStudents(
		int start, int end) {
		return getService().getStudents(start, end);
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

	public static StudentLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StudentLocalService, StudentLocalService> _serviceTracker =
		ServiceTrackerFactory.open(StudentLocalService.class);
}