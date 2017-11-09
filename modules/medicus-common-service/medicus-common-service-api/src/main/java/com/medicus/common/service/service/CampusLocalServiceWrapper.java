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
 * Provides a wrapper for {@link CampusLocalService}.
 *
 * @author sandip.patel
 * @see CampusLocalService
 * @generated
 */
@ProviderType
public class CampusLocalServiceWrapper implements CampusLocalService,
	ServiceWrapper<CampusLocalService> {
	public CampusLocalServiceWrapper(CampusLocalService campusLocalService) {
		_campusLocalService = campusLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _campusLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _campusLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _campusLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campusLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campusLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the campus to the database. Also notifies the appropriate model listeners.
	*
	* @param campus the campus
	* @return the campus that was added
	*/
	@Override
	public com.medicus.common.service.model.Campus addCampus(
		com.medicus.common.service.model.Campus campus) {
		return _campusLocalService.addCampus(campus);
	}

	@Override
	public com.medicus.common.service.model.Campus addCampus(long schoolId,
		java.lang.String name, java.lang.String address1,
		java.lang.String address2, java.lang.String city,
		java.lang.String state, java.lang.String country,
		java.lang.String campusContactNumber, java.lang.String websiteLink,
		java.lang.String contactPersonName,
		java.lang.String contactPersonEmail,
		java.lang.String contactPersonPhoneNumber, long createdBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campusLocalService.addCampus(schoolId, name, address1,
			address2, city, state, country, campusContactNumber, websiteLink,
			contactPersonName, contactPersonEmail, contactPersonPhoneNumber,
			createdBy);
	}

	/**
	* Creates a new campus with the primary key. Does not add the campus to the database.
	*
	* @param campusId the primary key for the new campus
	* @return the new campus
	*/
	@Override
	public com.medicus.common.service.model.Campus createCampus(long campusId) {
		return _campusLocalService.createCampus(campusId);
	}

	/**
	* Deletes the campus from the database. Also notifies the appropriate model listeners.
	*
	* @param campus the campus
	* @return the campus that was removed
	*/
	@Override
	public com.medicus.common.service.model.Campus deleteCampus(
		com.medicus.common.service.model.Campus campus) {
		return _campusLocalService.deleteCampus(campus);
	}

	/**
	* Deletes the campus with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param campusId the primary key of the campus
	* @return the campus that was removed
	* @throws PortalException if a campus with the primary key could not be found
	*/
	@Override
	public com.medicus.common.service.model.Campus deleteCampus(long campusId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campusLocalService.deleteCampus(campusId);
	}

	@Override
	public com.medicus.common.service.model.Campus fetchCampus(long campusId) {
		return _campusLocalService.fetchCampus(campusId);
	}

	/**
	* Returns the campus with the primary key.
	*
	* @param campusId the primary key of the campus
	* @return the campus
	* @throws PortalException if a campus with the primary key could not be found
	*/
	@Override
	public com.medicus.common.service.model.Campus getCampus(long campusId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campusLocalService.getCampus(campusId);
	}

	@Override
	public com.medicus.common.service.model.Campus getCampusByName(
		java.lang.String campusName)
		throws com.medicus.common.service.exception.NoSuchCampusException {
		return _campusLocalService.getCampusByName(campusName);
	}

	@Override
	public com.medicus.common.service.model.Campus upateCampus(long campusId,
		long schoolId, java.lang.String name, java.lang.String address1,
		java.lang.String address2, java.lang.String city,
		java.lang.String state, java.lang.String country,
		java.lang.String campusContactNumber, java.lang.String websiteLink,
		java.lang.String contactPersonName,
		java.lang.String contactPersonEmail,
		java.lang.String contactPersonPhoneNumber, long modifiedBy)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _campusLocalService.upateCampus(campusId, schoolId, name,
			address1, address2, city, state, country, campusContactNumber,
			websiteLink, contactPersonName, contactPersonEmail,
			contactPersonPhoneNumber, modifiedBy);
	}

	/**
	* Updates the campus in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param campus the campus
	* @return the campus that was updated
	*/
	@Override
	public com.medicus.common.service.model.Campus updateCampus(
		com.medicus.common.service.model.Campus campus) {
		return _campusLocalService.updateCampus(campus);
	}

	/**
	* Returns the number of campuses.
	*
	* @return the number of campuses
	*/
	@Override
	public int getCampusesCount() {
		return _campusLocalService.getCampusesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _campusLocalService.getOSGiServiceIdentifier();
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
		return _campusLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.CampusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _campusLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.CampusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _campusLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.medicus.common.service.model.Campus> getCampusListBySchooId(
		long schoolId) {
		return _campusLocalService.getCampusListBySchooId(schoolId);
	}

	/**
	* Returns a range of all the campuses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.medicus.common.service.model.impl.CampusModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of campuses
	* @param end the upper bound of the range of campuses (not inclusive)
	* @return the range of campuses
	*/
	@Override
	public java.util.List<com.medicus.common.service.model.Campus> getCampuses(
		int start, int end) {
		return _campusLocalService.getCampuses(start, end);
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
		return _campusLocalService.dynamicQueryCount(dynamicQuery);
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
		return _campusLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public CampusLocalService getWrappedService() {
		return _campusLocalService;
	}

	@Override
	public void setWrappedService(CampusLocalService campusLocalService) {
		_campusLocalService = campusLocalService;
	}

	private CampusLocalService _campusLocalService;
}