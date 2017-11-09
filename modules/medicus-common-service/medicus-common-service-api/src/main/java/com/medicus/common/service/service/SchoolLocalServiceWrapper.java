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
 * Provides a wrapper for {@link SchoolLocalService}.
 *
 * @author sandip.patel
 * @see SchoolLocalService
 * @generated
 */
@ProviderType
public class SchoolLocalServiceWrapper implements SchoolLocalService,
	ServiceWrapper<SchoolLocalService> {
	public SchoolLocalServiceWrapper(SchoolLocalService schoolLocalService) {
		_schoolLocalService = schoolLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _schoolLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _schoolLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _schoolLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _schoolLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _schoolLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the school to the database. Also notifies the appropriate model listeners.
	*
	* @param school the school
	* @return the school that was added
	*/
	@Override
	public com.medicus.common.service.model.School addSchool(
		com.medicus.common.service.model.School school) {
		return _schoolLocalService.addSchool(school);
	}

	@Override
	public com.medicus.common.service.model.School addSchool(
		java.lang.String name, java.lang.String address1,
		java.lang.String address2, java.lang.String city,
		java.lang.String state, java.lang.String country,
		java.lang.String schoolContactNumber, java.lang.String websiteLink,
		java.lang.String contactPersonName,
		java.lang.String contactPersonEmail,
		java.lang.String contactPersonPhoneNumber, long createdBy) {
		return _schoolLocalService.addSchool(name, address1, address2, city,
			state, country, schoolContactNumber, websiteLink,
			contactPersonName, contactPersonEmail, contactPersonPhoneNumber,
			createdBy);
	}

	/**
	* Creates a new school with the primary key. Does not add the school to the database.
	*
	* @param schoolId the primary key for the new school
	* @return the new school
	*/
	@Override
	public com.medicus.common.service.model.School createSchool(long schoolId) {
		return _schoolLocalService.createSchool(schoolId);
	}

	/**
	* Deletes the school from the database. Also notifies the appropriate model listeners.
	*
	* @param school the school
	* @return the school that was removed
	*/
	@Override
	public com.medicus.common.service.model.School deleteSchool(
		com.medicus.common.service.model.School school) {
		return _schoolLocalService.deleteSchool(school);
	}

	/**
	* Deletes the school with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param schoolId the primary key of the school
	* @return the school that was removed
	* @throws PortalException if a school with the primary key could not be found
	*/
	@Override
	public com.medicus.common.service.model.School deleteSchool(long schoolId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _schoolLocalService.deleteSchool(schoolId);
	}

	@Override
	public com.medicus.common.service.model.School fetchSchool(long schoolId) {
		return _schoolLocalService.fetchSchool(schoolId);
	}

	/**
	* Returns the school with the primary key.
	*
	* @param schoolId the primary key of the school
	* @return the school
	* @throws PortalException if a school with the primary key could not be found
	*/
	@Override
	public com.medicus.common.service.model.School getSchool(long schoolId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _schoolLocalService.getSchool(schoolId);
	}

	@Override
	public com.medicus.common.service.model.School getSchoolByName(
		java.lang.String schoolName)
		throws com.medicus.common.service.exception.NoSuchSchoolException {
		return _schoolLocalService.getSchoolByName(schoolName);
	}

	/**
	* Updates the school in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param school the school
	* @return the school that was updated
	*/
	@Override
	public com.medicus.common.service.model.School updateSchool(
		com.medicus.common.service.model.School school) {
		return _schoolLocalService.updateSchool(school);
	}

	@Override
	public com.medicus.common.service.model.School updateSchool(long schoolId,
		java.lang.String name, java.lang.String address1,
		java.lang.String address2, java.lang.String city,
		java.lang.String state, java.lang.String country,
		java.lang.String schoolContactNumber, java.lang.String websiteLink,
		java.lang.String contactPersonName,
		java.lang.String contactPersonEmail,
		java.lang.String contactPersonPhoneNumber, long modifiedBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _schoolLocalService.updateSchool(schoolId, name, address1,
			address2, city, state, country, schoolContactNumber, websiteLink,
			contactPersonName, contactPersonEmail, contactPersonPhoneNumber,
			modifiedBy);
	}

	/**
	* Returns the number of schools.
	*
	* @return the number of schools
	*/
	@Override
	public int getSchoolsCount() {
		return _schoolLocalService.getSchoolsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _schoolLocalService.getOSGiServiceIdentifier();
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
		return _schoolLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _schoolLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _schoolLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the schools.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.SchoolModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of schools
	* @param end the upper bound of the range of schools (not inclusive)
	* @return the range of schools
	*/
	@Override
	public java.util.List<com.medicus.common.service.model.School> getSchools(
		int start, int end) {
		return _schoolLocalService.getSchools(start, end);
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
		return _schoolLocalService.dynamicQueryCount(dynamicQuery);
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
		return _schoolLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public SchoolLocalService getWrappedService() {
		return _schoolLocalService;
	}

	@Override
	public void setWrappedService(SchoolLocalService schoolLocalService) {
		_schoolLocalService = schoolLocalService;
	}

	private SchoolLocalService _schoolLocalService;
}