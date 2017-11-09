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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EmployerLocalService}.
 *
 * @author sandip.patel
 * @see EmployerLocalService
 * @generated
 */
@ProviderType
public class EmployerLocalServiceWrapper implements EmployerLocalService,
	ServiceWrapper<EmployerLocalService> {
	public EmployerLocalServiceWrapper(
		EmployerLocalService employerLocalService) {
		_employerLocalService = employerLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _employerLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _employerLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _employerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employerLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the employer to the database. Also notifies the appropriate model listeners.
	*
	* @param employer the employer
	* @return the employer that was added
	*/
	@Override
	public com.medicus.common.service.model.Employer addEmployer(
		com.medicus.common.service.model.Employer employer) {
		return _employerLocalService.addEmployer(employer);
	}

	@Override
	public com.medicus.common.service.model.Employer addEmployer(
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String emailAddress, java.lang.String address1,
		java.lang.String address2, java.lang.String city,
		java.lang.String zipcode, java.lang.String state,
		java.lang.String country, java.lang.String contactPersonName,
		java.lang.String contactPersonEmail,
		java.lang.String contactPersonPhoneNumber,
		java.lang.String websiteLink, long creatorUserId) {
		return _employerLocalService.addEmployer(firstName, lastName,
			emailAddress, address1, address2, city, zipcode, state, country,
			contactPersonName, contactPersonEmail, contactPersonPhoneNumber,
			websiteLink, creatorUserId);
	}

	/**
	* Creates a new employer with the primary key. Does not add the employer to the database.
	*
	* @param employerId the primary key for the new employer
	* @return the new employer
	*/
	@Override
	public com.medicus.common.service.model.Employer createEmployer(
		long employerId) {
		return _employerLocalService.createEmployer(employerId);
	}

	/**
	* Deletes the employer from the database. Also notifies the appropriate model listeners.
	*
	* @param employer the employer
	* @return the employer that was removed
	*/
	@Override
	public com.medicus.common.service.model.Employer deleteEmployer(
		com.medicus.common.service.model.Employer employer) {
		return _employerLocalService.deleteEmployer(employer);
	}

	/**
	* Deletes the employer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param employerId the primary key of the employer
	* @return the employer that was removed
	* @throws PortalException if a employer with the primary key could not be found
	*/
	@Override
	public com.medicus.common.service.model.Employer deleteEmployer(
		long employerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employerLocalService.deleteEmployer(employerId);
	}

	@Override
	public com.medicus.common.service.model.Employer editEmployer(
		long employerId, java.lang.String firstName, java.lang.String lastName,
		java.lang.String emailAddress, java.lang.String address1,
		java.lang.String address2, java.lang.String city,
		java.lang.String zipcode, java.lang.String state,
		java.lang.String country, java.lang.String contactPersonName,
		java.lang.String contactPersonEmail,
		java.lang.String contactPersonPhoneNumber,
		java.lang.String websiteLink, long modifiedBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employerLocalService.editEmployer(employerId, firstName,
			lastName, emailAddress, address1, address2, city, zipcode, state,
			country, contactPersonName, contactPersonEmail,
			contactPersonPhoneNumber, websiteLink, modifiedBy);
	}

	@Override
	public com.medicus.common.service.model.Employer fetchEmployer(
		long employerId) {
		return _employerLocalService.fetchEmployer(employerId);
	}

	/**
	* Returns the employer with the primary key.
	*
	* @param employerId the primary key of the employer
	* @return the employer
	* @throws PortalException if a employer with the primary key could not be found
	*/
	@Override
	public com.medicus.common.service.model.Employer getEmployer(
		long employerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _employerLocalService.getEmployer(employerId);
	}

	/**
	* Updates the employer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param employer the employer
	* @return the employer that was updated
	*/
	@Override
	public com.medicus.common.service.model.Employer updateEmployer(
		com.medicus.common.service.model.Employer employer) {
		return _employerLocalService.updateEmployer(employer);
	}

	/**
	* Returns the number of employers.
	*
	* @return the number of employers
	*/
	@Override
	public int getEmployersCount() {
		return _employerLocalService.getEmployersCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _employerLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _employerLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _employerLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _employerLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
	@Override
	public java.util.List<com.medicus.common.service.model.Employer> getEmployers(
		int start, int end) {
		return _employerLocalService.getEmployers(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _employerLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _employerLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public EmployerLocalService getWrappedService() {
		return _employerLocalService;
	}

	@Override
	public void setWrappedService(EmployerLocalService employerLocalService) {
		_employerLocalService = employerLocalService;
	}

	private EmployerLocalService _employerLocalService;
}