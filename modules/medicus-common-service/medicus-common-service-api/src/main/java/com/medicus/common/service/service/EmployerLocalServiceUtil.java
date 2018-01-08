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
 * Provides the local service utility for Employer. This utility wraps
 * {@link com.medicus.common.service.service.impl.EmployerLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author sandip.patel
 * @see EmployerLocalService
 * @see com.medicus.common.service.service.base.EmployerLocalServiceBaseImpl
 * @see com.medicus.common.service.service.impl.EmployerLocalServiceImpl
 * @generated
 */
@ProviderType
public class EmployerLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.medicus.common.service.service.impl.EmployerLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	/**
	* Adds the employer to the database. Also notifies the appropriate model listeners.
	*
	* @param employer the employer
	* @return the employer that was added
	*/
	public static com.medicus.common.service.model.Employer addEmployer(
		com.medicus.common.service.model.Employer employer) {
		return getService().addEmployer(employer);
	}

	public static com.medicus.common.service.model.Employer addEmployer(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String emailAddress, java.lang.String address1,
		java.lang.String city, java.lang.String zipcode,
		java.lang.String state, java.lang.String country,
		java.lang.String contactPersonName,
		java.lang.String contactPersonEmail,
		java.lang.String contactPersonPhoneNumber,
		java.lang.String websiteLink, long creatorUserId) {
		return getService()
				   .addEmployer(firstName, lastName, emailAddress, address1,
			city, zipcode, state, country, contactPersonName,
			contactPersonEmail, contactPersonPhoneNumber, websiteLink,
			creatorUserId);
	}

	/**
	* Creates a new employer with the primary key. Does not add the employer to the database.
	*
	* @param employerId the primary key for the new employer
	* @return the new employer
	*/
	public static com.medicus.common.service.model.Employer createEmployer(
		long employerId) {
		return getService().createEmployer(employerId);
	}

	/**
	* Deletes the employer from the database. Also notifies the appropriate model listeners.
	*
	* @param employer the employer
	* @return the employer that was removed
	*/
	public static com.medicus.common.service.model.Employer deleteEmployer(
		com.medicus.common.service.model.Employer employer) {
		return getService().deleteEmployer(employer);
	}

	/**
	* Deletes the employer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employerId the primary key of the employer
	* @return the employer that was removed
	* @throws PortalException if a employer with the primary key could not be found
	*/
	public static com.medicus.common.service.model.Employer deleteEmployer(
		long employerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteEmployer(employerId);
	}

	public static com.medicus.common.service.model.Employer editEmployer(
		long employerId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String emailAddress, java.lang.String address1,
		java.lang.String city, java.lang.String zipcode,
		java.lang.String state, java.lang.String country,
		java.lang.String contactPersonName,
		java.lang.String contactPersonEmail,
		java.lang.String contactPersonPhoneNumber,
		java.lang.String websiteLink, long modifiedBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .editEmployer(employerId, firstName, lastName, emailAddress,
			address1, city, zipcode, state, country, contactPersonName,
			contactPersonEmail, contactPersonPhoneNumber, websiteLink,
			modifiedBy);
	}

	public static com.medicus.common.service.model.Employer fetchEmployer(
		long employerId) {
		return getService().fetchEmployer(employerId);
	}

	/**
	* Returns the employer with the primary key.
	*
	* @param employerId the primary key of the employer
	* @return the employer
	* @throws PortalException if a employer with the primary key could not be found
	*/
	public static com.medicus.common.service.model.Employer getEmployer(
		long employerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getEmployer(employerId);
	}

	/**
	* Updates the employer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param employer the employer
	* @return the employer that was updated
	*/
	public static com.medicus.common.service.model.Employer updateEmployer(
		com.medicus.common.service.model.Employer employer) {
		return getService().updateEmployer(employer);
	}

	/**
	* Returns the number of employers.
	*
	* @return the number of employers
	*/
	public static int getEmployersCount() {
		return getService().getEmployersCount();
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.EmployerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.EmployerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Returns a range of all the employers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.EmployerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of employers
	* @param end the upper bound of the range of employers (not inclusive)
	* @return the range of employers
	*/
	public static java.util.List<com.medicus.common.service.model.Employer> getEmployers(
		int start, int end) {
		return getService().getEmployers(start, end);
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

	public static EmployerLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EmployerLocalService, EmployerLocalService> _serviceTracker =
		ServiceTrackerFactory.open(EmployerLocalService.class);
}